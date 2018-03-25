package lecture464.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.databaseAccessLayer.*;
import lecture464.model.*;

/**
 * Servlet implementation class ManageOrder
 */
public class ManageOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageOrder() {
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
		if(request.getSession().getAttribute("active") == null || !request.getSession().getAttribute("active").equals(1)){
			response.sendRedirect("Login.jsp");
			return;
		}
		HttpSession session = request.getSession();
		session.removeAttribute("order");
		session.removeAttribute("orderId");
		session.removeAttribute("orderDate");
		String orderDate = request.getParameter("orderDate");
		String orderId = request.getParameter("orderId");
		session.setAttribute("orderId", orderId);
		session.setAttribute("orderDate", orderDate);
		OrdersDB db = new OrdersDB();
		ArrayList<OrderItem> orderItems = db.getOrderItems(Integer.parseInt(orderId));
		session.setAttribute("orderItems", orderItems);
		RequestDispatcher rd = request.getRequestDispatcher("ManageOrder.jsp");
		rd.include(request, response);
	}

}
