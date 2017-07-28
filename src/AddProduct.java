

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTool.DBcart;
import model.Cart;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String Productid = request.getParameter("productid");

		Integer productid = Integer.parseInt(request.getParameter("productid"));
		Integer quantity = Integer.parseInt(request.getParameter("quant"));

		Cart ord = new Cart();
		ord.setQuantity(quantity);
		ord.setUserid(3);
		
		DBcart.insert(ord);
		//List<Cart> list = DBcart.cartList(session.getAttribute("user.username"));
		
	//	session.setAttribute("list", list);
		
		//response.getWriter().append(cart.printProducts());
        response.sendRedirect(request.getContextPath() + "/cart.jsp");
		
		
		
		session.setAttribute("order", ord);
		DBcart.insert(ord);
		
		getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
	}

}
