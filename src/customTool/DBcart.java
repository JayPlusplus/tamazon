package customTool;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import customTool.DbUtil;
import model.Cart;
import model.Product;

public class DBcart {
		public static void insert(Product ord) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(ord);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();

		}
	}
	public static void delete(Cart ord) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(ord));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	   public static List<Cart> cartList (String username)
	    {
	        EntityManager em = DbUtil.getEmFactory().createEntityManager();
	        List<Cart> productname = null;
	        String qString = "select b from Cart b "
	                + "where b.cart.username = :userename";
	        
	        try{
	            TypedQuery<Cart> query = em.createQuery(qString,Cart.class);
	            query.setParameter("username", username);
	            productname = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        finally{
	                em.close();
	            }
	        return productname;    
	    }
		public static List<Cart> listOfProducts (){
			EntityManager em = DbUtil.getEmFactory().createEntityManager();
			String qString = "select b from Product b";
			List<Cart> products = null;
			try{
				TypedQuery<Cart> query = em.createQuery(qString,Cart.class);
				products = query.getResultList();

			}catch (Exception e){
				e.printStackTrace();
			}
			finally{
					em.close();
				}
			return products;
		}
}
