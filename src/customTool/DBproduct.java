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
			List<Product> posts = null;
			try{
				TypedQuery<Product> query = em.createQuery(qString,Product.class);
				posts = query.getResultList();

			}catch (Exception e){
				e.printStackTrace();
			}
			finally{
					em.close();
				}
			return posts;
		}
}
