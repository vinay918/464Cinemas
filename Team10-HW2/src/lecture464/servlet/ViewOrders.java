package lecture464.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.databaseAccessLayer.OrdersDB;
import lecture464.model.*;

/**
 * Servlet implementation class ViewOrder
 */
public class ViewOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrders() {
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
		String address;
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		OrdersDB orderDb = new OrdersDB();
		ArrayList<Orders> orders = orderDb.getUserOrders(user.getId());
		if(orders.isEmpty()) {
			address = "NoOrder.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(address);
			rd.include(request, response);
		}else {
			address = "ViewOrders.jsp";
			session.setAttribute("orders", orders);
			RequestDispatcher rd = request.getRequestDispatcher(address);
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
