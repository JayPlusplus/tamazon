package customTool;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import Model.User;
import customTool.DbUtil;


public class DBuser {
	public static boolean isValidUser(String username, String userpassword)
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "Select count(b.userID) from User b "
				+ "where b.username = :username and b.userpassword = :userpassword";
		TypedQuery<Long> q = em.createQuery(qString,Long.class);
		boolean result = false;
		q.setParameter("username",username);
		q.setParameter("userpassword",userpassword);

		try{
			long userID = q.getSingleResult();
			if (userID > 0)
			{
				result = true;
			}
		}catch (Exception e){

			result = false;
		}
		finally{
			em.close(); 
		} 
		return result;

	}
	public static User getUser(int userID)
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		User user = em.find(User.class, userID);
		return user; 
	}
	
	public static User getUser(String username)
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "Select u from User u "
				+ "where u.username = :username";
		TypedQuery<User> q = em.createQuery(qString, User.class);
		q.setParameter("username", username);
		User p = null;
		try {
			p = q.getSingleResult();
		}catch (NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		return p;
	}
	public static void insert(User p) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(p);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("DbBullhorn: rollback transaction");
			trans.rollback();
		} finally {
			//System.out.println("DbBullhorn: close em");
			em.close();
		}
}
}