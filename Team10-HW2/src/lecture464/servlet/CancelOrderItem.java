package lecture464.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.databaseAccessLayer.*;
import lecture464.model.*;

/**
 * Servlet implementation class CancelOrderItem
 */
public class CancelOrderItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String orderItemId = request.getParameter("orderItemId");
		String orderDate = request.getParameter("orderDate");
		System.out.println(orderItemId);
		try {
			User user = (User) session.getAttribute("user");
			System.out.println("Details "+ orderItemId);
			OrdersDB db = new OrdersDB();
			TransactionDB trans = new TransactionDB();
			db.setCancelOrderItem(Integer.parseInt(orderItemId));
			double afterRefund = trans.getCardBalance(user.getId()) + db.getOrderItemPrice(Integer.parseInt(orderItemId));
			System.out.println("Details "+ afterRefund);
			trans.setTransaction(afterRefund, user.getId());
			session.setAttribute("orderItemId", orderItemId);
			OrderItem item = db.getOrderItem(Integer.parseInt(orderItemId));
			session.setAttribute("cancelledItem", item);
			session.setAttribute("orderDate", orderDate);
			RequestDispatcher rd = request.getRequestDispatcher("CancellationConfirmation.jsp");
			rd.include(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("ManageOrder.jsp");
			rd.include(request, response);
		}
	}

}
