

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTool.DBcart;
import customTool.DBproduct;
import model.Cart;
import model.Product;

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
		Integer productid = Integer.parseInt(request.getParameter("productid"));
		Integer quantity = Integer.parseInt(request.getParameter("quant"));
		//List<Product> pro = new ArrayList();
		String addToCart = "";
		
		if (addToCart.equals(request.getParameter("addToCart"))) {
			Product pro = DBproduct.getProduct(productid);
			System.out.println(pro);
			//List<Cart> ord = new ArrayList();
			
			//ord.setQuantity(quantity);
			DBcart.insert(pro);
		//String car = session.getAttribute()
			List<Cart> list = DBcart.listOfProducts();
			session.setAttribute("list", list);
		
		}
		
		getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
	}

}
