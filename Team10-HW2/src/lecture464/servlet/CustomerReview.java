package lecture464.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import lecture464.databaseAccessLayer.*;
import lecture464.model.*;

/**
 * Servlet implementation class CustomerReview
 */
public class CustomerReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static org.apache.log4j.Logger log = Logger.getLogger(CustomerReview.class);
       
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
		if(request.getSession().getAttribute("active") == null || !request.getSession().getAttribute("active").equals(1)){
			response.sendRedirect("Login.jsp");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getSession().getAttribute("active") == null || !request.getSession().getAttribute("active").equals(1)){
			response.sendRedirect("Login.jsp");
			return;
		}
		
		PrintWriter out = response.getWriter();
		String address;
		boolean success = true;
		
		String review = request.getParameter("review");
		String rating = request.getParameter("rating");
		review = Jsoup.clean(review, Whitelist.basic());
		rating = Jsoup.clean(rating, Whitelist.basic());

		HttpSession session = request.getSession();
		MovieShowing selectedMovie = (MovieShowing) session.getAttribute("showing");
		User user = (User) session.getAttribute("user");
		CustomerReviewDB customerReview = new CustomerReviewDB();


		try {
			customerReview.addMovieReview(selectedMovie.getMovie().getId(), user.getId() , review, Double.parseDouble(rating));
		}catch(Exception e){
	    	log.debug("Unable to add review",e);
			success = false;
		}
		if (success) {
			out.println(1);
		} else {
			out.println(0);
		}
		return;
	}

}
