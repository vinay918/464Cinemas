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
 * Servlet implementation class MovieDetails
 */
public class MovieDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("active") == null || !request.getSession().getAttribute("active").equals(1)){
			response.sendRedirect("Login.jsp");
			return;
		}
		String showingId = request.getParameter("selection");
		MovieShowingDB showingDB = new MovieShowingDB();
		CustomerReviewDB customerReviewDB = new CustomerReviewDB();
		MovieShowing showing = showingDB.getMovieShowing(Integer.parseInt(showingId));
		int id = Integer.parseInt(showingId);
		List<CustomerReview> reviews = customerReviewDB.getMovieReviews(id);
		HttpSession session = request.getSession();
		session.setAttribute("showing", showing);
		session.setAttribute("showingReviews", reviews);
		
		RequestDispatcher rd = request.getRequestDispatcher("MovieDetailsAndSelection.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
