package lecture464.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.databaseAccessLayer.*;
import lecture464.model.*;

/**
 * Servlet implementation class Bank
 */
public class Bank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bank() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String text = "some text";

	    response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(text);       // Write response body.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("active") == null || !request.getSession().getAttribute("active").equals(1)){
			response.sendRedirect("Login.jsp");
			return;
		}
		// TODO Auto-generated method stub
		//TODO: Validate user card credential
		boolean isValidate = true;
		HttpSession session = request.getSession();
		TransactionDB transDb = new TransactionDB();
		User user = (User) session.getAttribute("user");
		int id = user.getId();
		CreditCard trans = transDb.getTransaction(id);
		//TODO: debug
		double total = (double) session.getAttribute("total");
		String cardName = request.getParameter("cardName");
		String cardNumber  = request.getParameter("userCardNum");
		String securityCode  = request.getParameter("userSecurityCode");
		String expirationDate  = request.getParameter("expirationDate");
		String cardType  = request.getParameter("cardType");
		String address  = request.getParameter("userBillingAddress");
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		// Get the printwriter object from response to write the required json object to the output stream      
		
		try {
			CreditCard userTransaction = new CreditCard(cardNumber, cardType, securityCode, expirationDate, total, cardName, address);
			String transactionAddress;
			if(!userTransaction.ValidateTransaction(trans, userTransaction)) {
				String msg = "Please make sure your bank details are correct and the balance is enough.";
				String jsonObject = "{ \"message\": \""+ msg+ "\",  \"success\": false }";
				response.getWriter().write(jsonObject);
				response.getWriter().flush();
			}else {
				double balance = trans.getBalance() - userTransaction.getBalance();
				transDb.setTransaction(balance, id);
				String msg = "Your order is being process.";
				String jsonObject = "{ \"message\": \""+ msg+ "\",  \"success\": true }";
				response.getWriter().write(jsonObject);
				response.getWriter().flush();
			}
		}catch(Exception e) {
			String msg ="Oops. Something went wrong. Or you might be inactive for too long. You will be redirected back to Login.";
			String url ="Login.jsp";
			String jsonObject = "{ \"message\": \""+ msg+ "\",  \"success\": false }";
			response.getWriter().write(jsonObject);
			response.getWriter().flush();
			
		}
	}

}
