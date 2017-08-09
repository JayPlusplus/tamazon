
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTool.DBuser;
import model.User;


/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("useremail");
		String nextURL = "";
		
		User u = DBuser.getUserByEmail(email);


		if (u == null){
			u = new User();
			u.setUsername(username);
			u.setUseremail(email);
			u.setUserpassword(password);
			session.setAttribute("user", u);
			DBuser.insert(u);
			System.out.println("under insert method");
			nextURL = "/logined.jsp";
		}else{
			String message = "You have an account - ";
			request.setAttribute("message", message);
			nextURL = "/login.jsp";
};		
			
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
	}

}
