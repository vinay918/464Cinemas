package lecture464.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.databaseAccessLayer.TheatreDB;
import lecture464.model.Theatre;
import lecture464.model.User;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super(); 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		/* The users.properties file is stored in the "WEB-INF" folder.
		   To access this file, you will need its absolute path. */

		HttpSession session = request.getSession();
		
		User user = new User(userName, password);
		
		if(user.validateUser(user)){
			response.sendRedirect("CustomerHomePage.jsp");
			session.removeAttribute("WrongPassword");
			session.removeAttribute("UserNameTaken");
			session.setAttribute("user", user);
			TheatreDB theatreDB = new TheatreDB();
			ArrayList<Theatre> theatres = theatreDB.getTheatres();
			session.setAttribute("theatres",theatres);
		}else if(!user.userRegistered(user)){
			session.removeAttribute("WrongPassword");
			session.setAttribute("UserNameTaken","Your username is not registered in our system");
			response.sendRedirect("Register.jsp");			
		}else{
			session.setAttribute("WrongPassword","Incorrect Password");
			session.removeAttribute("UserNameTaken");
			response.sendRedirect("Login.jsp");				
		}
		return;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
