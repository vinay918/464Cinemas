package lecture464.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.databaseAccessLayer.*;
import lecture464.model.*;

/**
 * Servlet implementation class CustomerTransactionConfirmation
 */
public class CustomerTransactionConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerTransactionConfirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("active") == null || !request.getSession().getAttribute("active").equals(1)){
			response.sendRedirect("Login.jsp");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("active") == null || !request.getSession().getAttribute("active").equals(1)){
			response.sendRedirect("Login.jsp");
			return;
		}
		
		//TODO: Validate user card credential
		boolean isValidate = true;
		HttpSession session = request.getSession();
		TransactionDB transDb = new TransactionDB();
		session.removeAttribute("currentOrder");
//		User user = (User) session.getAttribute("user");
//		int id = user.getId();
//		CreditCard trans = transDb.getTransaction(id);
//		//TODO: debug
//		double total = (double) session.getAttribute("total");
//		String cardName = request.getParameter("cardName");
//		String cardNumber  = request.getParameter("userCardNum");
//		String securityCode  = request.getParameter("userSecurityCode");
//		String expirationMonth = request.getParameter("cardMonth");
//		String expirationYear = request.getParameter("cardYear");
//		String expirationDate  = expirationMonth+ "/" + expirationYear;
//		String cardType  = request.getParameter("cardType");
//		String address  = request.getParameter("userBillingAddress");
		ArrayList<CartItem> cart = (ArrayList<CartItem>)session.getAttribute("shoppingCart");
		if(cart.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("EmptyCart.jsp");
			rd.include(request, response);
		}
//		try {
//		CreditCard userTransaction = new CreditCard(cardNumber, cardType, securityCode, expirationDate, total, cardName, address);
//		String transactionAddress;
//		if(!userTransaction.ValidateTransaction(trans, userTransaction)) {
//			String msg = "Please make sure your bank details are correct and the balance is enough.";
//			session.setAttribute("balanceAndDetails", msg);
//			transactionAddress = "CustomerTransaction.jsp";
//			RequestDispatcher rd = request.getRequestDispatcher(transactionAddress);
//			rd.include(request, response);
//		}else {
//			session.removeAttribute("balanceAndDetails");
//			transactionAddress = "TransactionSuccess.jsp";
//			OrdersDB orders = new OrdersDB();
//			double balance = trans.getBalance() - userTransaction.getBalance();
//			Calendar calendar = Calendar.getInstance();
//			int date = calendar.get(Calendar.DAY_OF_YEAR);
//			int hour = calendar.get(Calendar.HOUR_OF_DAY);
//			int minute = calendar.get(Calendar.MINUTE);
//			int second = calendar.get(Calendar.SECOND);
//			String orderId = Integer.toString(date)+Integer.toString(hour)+Integer.toString(minute)+Integer.toString(second);
//			orders.addOrder(Integer.parseInt(orderId), id, total, LocalDate.now().toString() , address, cardNumber);
//			for(int i=0;i<cart.size();i++) {
//				orders.addOrderItem(Integer.parseInt(orderId), cart.get(i).getMovie().getId(), cart.get(i).getTicketQuantity(), cart.get(i).getPrice());
//				int ticketPurchasedBeforeOrder = transDb.getNumberPurchased(cart.get(i).getMovie().getId());
//				transDb.setNumberPurchased((ticketPurchasedBeforeOrder+cart.get(i).getTicketQuantity()), cart.get(i).getMovie().getId());
//			}
//			ArrayList<OrderItem> currentOrder = orders.getOrderItems(Integer.parseInt(orderId));
//			transDb.setTransaction(balance, id);
//			session.setAttribute("orderId", orderId);
//			session.setAttribute("currentOrder", currentOrder);
//			session.setAttribute("orderDate", java.time.LocalDate.now());
//			session.removeAttribute("shoppingCart");
//			ArrayList<CartItem> cart1 = new ArrayList<CartItem>();
//			session.setAttribute("shoppingCart", cart1);
//			RequestDispatcher rd = request.getRequestDispatcher(transactionAddress);
//			rd.include(request, response);
//			}
//		}catch(Exception e) {
//			String msg = "New user does not have an address.";
//			session.setAttribute("balanceAndDetails", msg);
//			RequestDispatcher rd = request.getRequestDispatcher("CustomerTransaction.jsp");
//			rd.include(request, response);
//		}
	}

}
