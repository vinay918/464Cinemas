package lecture464.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.databaseAccessLayer.MovieShowingDB;
import lecture464.model.CartItem;
import lecture464.model.MovieShowing;

/**
 * Servlet implementation class UpdateShoppingCart
 */
public class UpdateShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("active") == null || !request.getSession().getAttribute("active").equals(1)){
			response.sendRedirect("Login.jsp");
			return;
		}
		String index = request.getParameter("index");
		String ticketQuantity = request.getParameter("ticketQuantity");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		ArrayList<CartItem> cart = (ArrayList<CartItem>)session.getAttribute("shoppingCart");
		if(cart == null) {
			session.setAttribute("shoppingCart", cart);
		}
		cart.get(Integer.parseInt(index)-1).setTicketQuantity(Integer.parseInt(ticketQuantity));
		cart.get(Integer.parseInt(index)-1).setPrice(cart.get(Integer.parseInt(index)-1).getSinglePrice()*Integer.parseInt(ticketQuantity));
		double total = 0;
		for(int i=0; i<cart.size();i++) {
			total = cart.get(i).getPrice() + total;
		}
		session.setAttribute("shoppingCart", cart);
		session.setAttribute("total", total);
		RequestDispatcher rd = request.getRequestDispatcher("ViewAndCheckoutShoppingCart.jsp");
		rd.include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
