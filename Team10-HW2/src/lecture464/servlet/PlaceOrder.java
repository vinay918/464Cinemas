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
 * Servlet implementation class PlaceOrder
 */
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("active") == null || !request.getSession().getAttribute("active").equals(1)){
			response.sendRedirect("Login.jsp");
			return;
		}
		
		HttpSession session = request.getSession();
		//Get connection to database
		BankDB transDb = new BankDB();
		OrdersDB orders = new OrdersDB();
		
		try {
		//Get ajax Data
		String address  = request.getParameter("userBillingAddress");
		String cardNumber  = request.getParameter("userCardNum");
		
		ArrayList<CartItem> cart = (ArrayList<CartItem>)session.getAttribute("shoppingCart");
		
		if(cart.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("EmptyCart.jsp");
			rd.include(request, response);
		}
		
		//Remove session incase there's another current order just made
		session.removeAttribute("currentOrder");
		session.removeAttribute("balanceAndDetails");
		
		//Get user details
		User user = (User) session.getAttribute("user");
		int id = user.getId();
		double total = (double) session.getAttribute("total");

		//Set time to compute order number
		Calendar calendar = Calendar.getInstance();
		int date = calendar.get(Calendar.DAY_OF_YEAR);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		//set orderId
		String orderId = Integer.toString(date)+Integer.toString(hour)+Integer.toString(minute)+Integer.toString(second);
		orders.addOrder(Integer.parseInt(orderId), id, total, LocalDate.now().toString() , address, cardNumber);
		
		//Writing all order to database
		for(int i=0;i<cart.size();i++) {
			orders.addOrderItem(Integer.parseInt(orderId), cart.get(i).getMovie().getId(), cart.get(i).getTicketQuantity(), cart.get(i).getPrice());
			int ticketPurchasedBeforeOrder = transDb.getNumberPurchased(cart.get(i).getMovie().getId());
			transDb.setNumberPurchased((ticketPurchasedBeforeOrder+cart.get(i).getTicketQuantity()), cart.get(i).getMovie().getId());
		}
		ArrayList<OrderItem> currentOrder = orders.getOrderItems(Integer.parseInt(orderId));
		
		//set attribute 
		session.setAttribute("orderId", orderId);
		session.setAttribute("currentOrder", currentOrder);
		session.setAttribute("orderDate", java.time.LocalDate.now());
		session.removeAttribute("total");
		session.removeAttribute("shoppingCart");
		
		//reset cart
		ArrayList<CartItem> cart1 = new ArrayList<CartItem>();
		session.setAttribute("shoppingCart", cart1);
		
			String msg = "Order "+ orderId +" placed";
			String jsonObject = "{ \"message\": \""+ msg+ "\", \"orderId\": \""+orderId+"\", \"orderDate\": \""+ java.time.LocalDate.now() +"\", \"success\": true }";
			response.getWriter().write(jsonObject);
			response.getWriter().flush();
			
		}catch(Exception e) {
			
			String msg = "Something went wrong.";
			String jsonObject = "{ \"message\": \""+ msg+ "\",  \"success\": false }";
			response.getWriter().write(jsonObject);
			response.getWriter().flush();
		}
	}

}
