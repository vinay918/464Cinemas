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
import lecture464.model.MovieShowing;

/**
 * Servlet implementation class MovieSearch
 */
public class MovieSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieSearch() {
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
		
		
		String theatre = request.getParameter("theatre");
		int theatreId = Integer.parseInt(theatre);
		String movie = request.getParameter("movie");
		
		MovieShowingDB movieDB = new MovieShowingDB();
		ArrayList<MovieShowing> showings = movieDB.getMovieShowings(theatreId, movie);
		
		HttpSession session = request.getSession();
		session.setAttribute("showings", showings);
		
		RequestDispatcher rd = request.getRequestDispatcher("MovieSearchResults.jsp");
		rd.include(request, response);
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
