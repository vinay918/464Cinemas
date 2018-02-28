package lecture464.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.CartItem;

/**
 * Servlet implementation class RemoveItem
 */
public class RemoveItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveItem() {
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
		// TODO Auto-generated method stub

		if(request.getSession().getAttribute("active") == null || !request.getSession().getAttribute("active").equals(1)){
			response.sendRedirect("Login.jsp");
			return;
		}
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		ArrayList<CartItem> cart = (ArrayList<CartItem>)session.getAttribute("shoppingCart");
		String showingId = request.getParameter("selection");
		for(int i=0;i<cart.size();i++) {
			int id = cart.get(i).getMovie().getId();
			if(id == Integer.parseInt(showingId)) {
				cart.remove(i);
			}
		}
		session.removeAttribute("shoppingCart");
		session.setAttribute("shoppingCart", cart);
		double total = 0;
		for(int i=0; i<cart.size();i++) {
			total = cart.get(i).getPrice() + total;
		}
		session.setAttribute("total", total);
		if(cart.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("EmptyCart.jsp");
			rd.include(request, response);
		}else {
		RequestDispatcher rd = request.getRequestDispatcher("ViewAndCheckoutShoppingCart.jsp");
		rd.include(request, response);
		}
	}

}
