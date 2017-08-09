
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTool.DBproduct;
import customTool.DBuser;
import model.Product;
import model.User;


/**
 * Servlet implementation class ValidateServ
 */
@WebServlet("/ValidateServ")
public class ValidateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServ() {
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
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String userpassword = request.getParameter("password");
		String message = "";
		String url = "";
		session.setAttribute("message", message);
		
		
		
		if (DBuser.isValidUser(username, userpassword)) {
				message = "Welcome! ";
				url = "/logined.jsp";
				System.out.println("it's in if here");
				User u = DBuser.getUser(username);
				
				List<Product> p = DBproduct.listOfProducts();
				session.setAttribute("product", p);
				session.setAttribute("user", u);
				
				
				getServletContext().getRequestDispatcher(url).forward(request, response);
				
			}
			else {
				message = "please sign up first if you don't have membership with Dave's catering";
				session.setAttribute("message", message);
				url = "/login.jsp";
				System.out.println("it's in else here");
				getServletContext().getRequestDispatcher(url).forward(request, response);
			
		}
	}

}
