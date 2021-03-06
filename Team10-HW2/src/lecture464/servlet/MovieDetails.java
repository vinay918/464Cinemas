package lecture464.servlet;
import lecture464.model.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.databaseAccessLayer.CustomerReviewDB;
import lecture464.databaseAccessLayer.MovieShowingDB;
import lecture464.model.CustomerReview;

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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("active") == null || !request.getSession().getAttribute("active").equals(1)){
			response.sendRedirect("Login.jsp");
			return;
		
		}
		String showingId = request.getParameter("selection");
		MovieShowingDB showingDB = new MovieShowingDB();
		MovieShowing showing;
		HttpSession session = request.getSession();
		
		if(showingId!=null) {
			showing = showingDB.getMovieShowing(Integer.parseInt(showingId));
			session.setAttribute("showing", showing);
		}else{
			showing = (MovieShowing) session.getAttribute("showing");
		}
		int movieId=showing.getMovie().getId();
		
		CustomerReviewDB reviewDB = new CustomerReviewDB();
		ArrayList<CustomerReview> reviews = reviewDB.getCustomerReview(movieId);
		session.setAttribute("reviews", reviews);
		double avg = reviewAverage(reviews);
		DecimalFormat numberFormat = new DecimalFormat("#.0");
		session.setAttribute("avg", numberFormat.format(avg));	
		RequestDispatcher rd = request.getRequestDispatcher("MovieDetailsAndSelection.jsp");
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
	
	
	protected double reviewAverage(ArrayList<CustomerReview> reviews){
		double tempSum = 0;
		for(CustomerReview cr:reviews){
			tempSum = tempSum + cr.getRating();
		}
		return tempSum/reviews.size();
	}

}
