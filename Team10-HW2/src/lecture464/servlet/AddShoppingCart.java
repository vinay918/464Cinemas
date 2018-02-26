package lecture464.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.CartItem;
import lecture464.model.MovieShowing;

/**
 * Servlet implementation class AddShoppingCart
 */
public class AddShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ticketQuantityS = request.getParameter("ticketQuantity");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		CartItem item = new CartItem();
		ArrayList<CartItem> cart = (ArrayList<CartItem>)session.getAttribute("shopingCart");
		MovieShowing movie = (MovieShowing)session.getAttribute("showing");
		
		int ticketQuantity = Integer.parseInt(ticketQuantityS);
		item.setMovie(movie);
		item.setTicketQuantity(ticketQuantity);
		cart.add(item);
		response.sendRedirect("ViewAndCheckoutShoopingCart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
