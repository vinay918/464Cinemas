package lecture464.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("active") == null || !request.getSession().getAttribute("active").equals(1)){
			response.sendRedirect("Login.jsp");
			return;
		}
		
		String theatre = request.getParameter("theatre");
		int theatreId = Integer.parseInt(theatre);
		String movie = request.getParameter("movie");

		theatre = Jsoup.clean(theatre, Whitelist.basic());
		movie = Jsoup.clean(movie, Whitelist.basic());		
		
		
		MovieShowingDB movieDB = new MovieShowingDB();
		ArrayList<MovieShowing> showings = movieDB.getMovieShowings(theatreId, movie);
		
		HttpSession session = request.getSession();
		session.setAttribute("showings", showings);

		for(Cookie c:request.getCookies()){
			if(c.getName().equals("searches")){
				c.setValue(movie);
				response.addCookie(c);
			}else{
				Cookie cookie = new Cookie("searches",movie);
				cookie.setMaxAge(60 * 60 * 24 * 365 * 10);
				response.addCookie(cookie);
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("MovieSearchResults.jsp");
		rd.include(request, response);
		
		return;
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
