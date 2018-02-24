package lecture464.servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		// Registration via the Users object
		User aUser = new User(userName, password);
		
		//First check whether the user already exists via methods from Users class
		
		// Register the Users object
		if(!aUser.validateUser(aUser)){
			aUser.registerUser(aUser);
			users++;
		}
		
		response.setContentType("text/html");
		response.sendRedirect("Login.jsp"); 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
