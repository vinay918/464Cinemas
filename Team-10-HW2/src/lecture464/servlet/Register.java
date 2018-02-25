package lecture464.servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.User;


/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static long users = 0;
    private static String firstUser;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void init() throws ServletException{
    	firstUser = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    }
    
    public void destroy() {
        saveState();
      }

     public void saveState() {
        // Try to save the accumulated count
      try {
        FileWriter fileWriter = new FileWriter("Current State.txt");
        String userNum = String.valueOf(users);
        fileWriter.write("Users:"+userNum+";"+"first user logged on:" +firstUser);
        fileWriter.close();
        return;
       }
       catch (IOException e) { 
       }
     }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");		
		// Registration via the Users object
<<<<<<< HEAD
		User aUser = new User(userName, password, fName, lName, email, phone);
=======
		User aUser = new User(-1,userName, password, fName, lName, email, phone);
>>>>>>> refs/remotes/origin/master
		
		HttpSession session = request.getSession();
		session.setAttribute("aUser", aUser);
		
		// Register the Users object
		if(!aUser.validateUser(aUser) && !aUser.userRegistered(aUser) && aUser.validEmail(aUser) && aUser.validPhone(aUser)){
			aUser.registerUser(aUser);
			users++;
			session.setAttribute("WrongPassword","You have been successfully registered!");
			session.removeAttribute("Error");
		}else if(aUser.userRegistered(aUser)){
			session.setAttribute("Error","The Username has been already used. Please pick something else");
			session.removeAttribute("WrongPassword");
			response.sendRedirect("Register.jsp");
			return;
		}else if(!aUser.validEmail(aUser) || !aUser.validPhone(aUser)){
			session.setAttribute("Error","Please enter valid inputs for your email and phone numbers");
			session.removeAttribute("WrongPassword");
			response.sendRedirect("Register.jsp");	
			return;
		}
		
		response.setContentType("text/html");
		response.sendRedirect("Login.jsp"); 
		return;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
