package lecture464.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.databaseAccessLayer.TheatreDB;
import lecture464.model.*;

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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");

		HttpSession session = request.getSession();
		
		User tempUser = new User(-1,userName, password, "","","","");
		
		if(tempUser.validateUser(tempUser)){
			if(remember != null && remember.equals("on")){
				Cookie cookieUName = new Cookie("userName",userName);
				Cookie cookiePass = new Cookie("password",password);				
				cookieUName.setMaxAge(60 * 60 * 24 * 365 * 10);
				cookiePass.setMaxAge(60 * 60 * 24 * 365 * 10);
				response.addCookie(cookieUName);
				response.addCookie(cookiePass);	
			}
			User user = tempUser.completeUser(tempUser);
			ArrayList<CartItem> shoppingCart= new ArrayList<CartItem>();
			response.sendRedirect("CustomerHomePage.jsp");
			session.removeAttribute("WrongPassword");
			session.removeAttribute("Error");
			session.setAttribute("user", user);
			session.setAttribute("shoppingCart", shoppingCart);
			TheatreDB theatreDB = new TheatreDB();
			ArrayList<Theatre> theatres = theatreDB.getTheatres();
			int active = 1;
			session.setAttribute("active",active);
			session.setAttribute("theatres",theatres);
		}else if(!tempUser.userRegistered(tempUser)){
			session.removeAttribute("WrongPassword");
			session.setAttribute("Error","Your username is not registered in our system");
			response.sendRedirect("Register.jsp");			
		}else{
			session.setAttribute("WrongPassword","Incorrect Password");
			session.removeAttribute("Error");
			response.sendRedirect("Login.jsp");				
		}
		return;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
