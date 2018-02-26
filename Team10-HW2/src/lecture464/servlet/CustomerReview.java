package lecture464.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.databaseAccessLayer.*;
import lecture464.model.*;

/**
 * Servlet implementation class CustomerReview
 */
public class CustomerReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address;
		boolean success = true;
		
		String review = request.getParameter("review");
		String rating = request.getParameter("rating");
		HttpSession session = request.getSession();
		MovieShowing selectedMovie = (MovieShowing) session.getAttribute("showing");
		User user = (User) request.getAttribute("user");
		CustomerReviewDB customerReview = new CustomerReviewDB();
		System.out.println(rating + "    " +review);
		try {
			double ratingD = Double.parseDouble(rating);
			customerReview.addMovieReview(selectedMovie, user, review, ratingD);
		}catch(Exception e){
			success = false;
		}
		if (success) {
			address = "ReviewSuccess.jsp";
		} else {
			address = "ReviewFail.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
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
