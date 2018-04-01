package lecture464.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.databaseAccessLayer.UserDB;
import lecture464.model.User;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prevPass = request.getParameter("prevpassword");
		String newPass = request.getParameter("newpassword1");

		HttpSession session = request.getSession();
		
		User sessionUser = (User)session.getAttribute("user");

		User tempUser = new User(-1,sessionUser.getUserName(), prevPass, "","","","");

		if(tempUser.validateUser(tempUser)){
			UserDB userdb = new UserDB();
			userdb.changePassword(sessionUser, newPass);
			response.sendRedirect("CustomerHomePage.jsp");
		}else{
			session.setAttribute("passError","Please enter your correct current password");
			response.sendRedirect("ChangePassword.jsp");
		}
		return;
	}

}
