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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("active") == null || !request.getSession().getAttribute("active").equals(1)){
			response.sendRedirect("Login.jsp");
			return;
		}
		String ticketQuantityS = request.getParameter("ticketQuantity");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		CartItem item = new CartItem();
		ArrayList<CartItem> cart = (ArrayList<CartItem>)session.getAttribute("shoppingCart");
		if(cart == null) {
			session.setAttribute("shoppingCart", cart);
		}
		MovieShowingDB showingDB = new MovieShowingDB();
		MovieShowing movie = (MovieShowing)session.getAttribute("showing");
		int movieId = movie.getId();
		item.setMovie(showingDB.getMovieShowing(movieId));
		item.setTicketQuantity(Integer.parseInt(ticketQuantityS));
		item.setSinglePrice(showingDB.getMovieShowing(movieId).getPrice());
		item.setPrice(item.getSinglePrice()*item.getTicketQuantity());
		cart.add(item);
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
