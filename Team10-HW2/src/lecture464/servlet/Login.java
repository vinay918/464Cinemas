package lecture464.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import lecture464.databaseAccessLayer.TheatreDB;
import lecture464.model.*;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static org.apache.log4j.Logger log = Logger.getLogger(Register.class);

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
		ServletContext sc = this.getServletContext();
		/* Store the log4j.properties file in the WEB-INF/lib directory.
		   Relative path is converted into the absolute path. */
		String propFilePath = sc.getRealPath("/WEB-INF/lib/log4j.properties");
		
		
		/* PropertyConfigurator class initializes log4j with 
		      the configuration properties specified in log4j.properties.*/
		PropertyConfigurator.configure(propFilePath);		
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		String auth = request.getParameter("auth");
		userName = Jsoup.clean(userName, Whitelist.basic());
		password = Jsoup.clean(password, Whitelist.basic());
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		User sessionUser = (User)session.getAttribute("user");
		
		User tempUser = new User(-1,userName, password, "","","","");
		if(tempUser.validateUser(tempUser)){
			if(auth != null && sessionUser != null && tempUser.getUserName().equals(sessionUser.getUserName())){
				session.setAttribute("valid",1);
				out.println(1);
				return;
			}
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
			session.setMaxInactiveInterval((int)TimeUnit.MINUTES.toMillis(15));
		}else if(!tempUser.userRegistered(tempUser)){
			if(auth != null){
				out.println(0);
				return;
			}			
			session.removeAttribute("WrongPassword");
			session.setAttribute("Error","Your username is not registered in our system");
			response.sendRedirect("Register.jsp");			
		}else{
			if(auth != null){
				out.println(0);
				return;
			}
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
