package customTool;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import customTool.DbUtil;
import model.Product;

public class DBproduct {
	 
		public static List<Product> listOfProducts (){
			EntityManager em = DbUtil.getEmFactory().createEntityManager();
			String qString = "select b from Product b";
			List<Product> products = null;
			try{
				TypedQuery<Product> query = em.createQuery(qString,Product.class);
				products = query.getResultList();
				//System.out.println("here in the try");
			}catch (Exception e){
				e.printStackTrace();
			}
			finally{
					em.close();
				}
			return products;
		}
		public static Product getProduct(int productID)
		{
			EntityManager em = DbUtil.getEmFactory().createEntityManager();
			Product pro = em.find(Product.class, productID);
			return pro; 
		}
}
