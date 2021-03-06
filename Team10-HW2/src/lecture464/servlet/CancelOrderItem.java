package lecture464.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import lecture464.databaseAccessLayer.*;
import lecture464.model.*;

/**
 * Servlet implementation class CancelOrderItem
 */
public class CancelOrderItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static org.apache.log4j.Logger log = Logger.getLogger(CancelOrderItem.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("active") == null || !request.getSession().getAttribute("active").equals(1)){
			response.sendRedirect("Login.jsp");
			return;
		}
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
		String orderItemId = request.getParameter("orderItemId");
		String orderDate = request.getParameter("orderDate");
		try {
			User user = (User) session.getAttribute("user");
			OrdersDB db = new OrdersDB();
			PlaceOrderDB trans = new PlaceOrderDB();
			db.setCancelOrderItem(Integer.parseInt(orderItemId));
			double afterRefund = trans.getCardBalance(user.getId()) + db.getOrderItemPrice(Integer.parseInt(orderItemId));
			trans.setTransaction(afterRefund, user.getId());
			session.setAttribute("orderItemId", orderItemId);
			OrderItem item = db.getOrderItem(Integer.parseInt(orderItemId));
			int ticketBeforeCancellation = trans.getNumberPurchased(item.getMovie().getId());
			int ticketAfterCancellation = ticketBeforeCancellation - item.getQuantity();
			trans.setNumberPurchased(ticketAfterCancellation, item.getMovie().getId());
			session.setAttribute("cancelledItem", item);
			session.setAttribute("orderDate", orderDate);
			RequestDispatcher rd = request.getRequestDispatcher("CancellationConfirmation.jsp");
			rd.include(request, response);
		}catch(Exception e) {
	    	log.debug("sent to manage order",e);
			RequestDispatcher rd = request.getRequestDispatcher("ManageOrder.jsp");
			rd.include(request, response);
		}
	}

}
