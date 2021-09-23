package database;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import database.entity.User;

public class Example {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("whatever I want");
		EntityManager entitymanager = emfactory.createEntityManager();
		List<User> users2 = findUserByName("Rachel Wu");

		for ( User user : users2 ) {
			System.out.println(user);
		}
		
		String sql3 = "SELECT u FROM User u";
		TypedQuery<User> query3 = entitymanager.createQuery(sql3, User.class);
		List<User> users3 = query3.getResultList();
		for (User user : users3 ) {
			System.out.println(user);
		}
		
// ================= query all records from user table ==========
		
		String sql = "SELECT u FROM User u where u.id = :id";
		
		Query query = entitymanager.createQuery(sql);
		query.setParameter("id", 1);
		List<User> users = query.getResultList();

		for ( User user : users ) {
			System.out.println(user.getEmail());
		}
		
		// ================== query single user into a list ===============
		
//		String sql1 = "SELECT u FROM User u WHERE u.id = :id";
//		
//		Query query1 = entitymanager.createQuery(sql1);
//		query1.setParameter("id", 1);
//		List<User> users1 = query1.getResultList();
//
//		for ( User user : users1 ) {
//			System.out.println(user);
//		}
		
		
		// =================== query single user into user object ==========
		
		
//		String sql = "SELECT u FROM User u WHERE u.id = :id and u.fullName = :name";
//		
//		Query query = entitymanager.createQuery(sql);
//		query.setParameter("name", "Eric Heilig");
//		query.setParameter("id", 1);	
//		
//		User user = (User)query.getSingleResult();
//
//		System.out.println(user);
		
		//================ code to delete a record ================
//		User user = entitymanager.find(User.class, 5);
//		System.out.println(user);
//				
//		entitymanager.getTransaction().begin();
//		entitymanager.remove(user);
//		entitymanager.getTransaction().commit();		
//		System.out.println(user);
		
	// ================ code to update a record ================
		
//		User user = entitymanager.find(User.class, 4);
//
//		System.out.println(user);
//		
//		user.setAddressLine1("ADDRESS LINE 1");
//		user.setAddressLine2("ADDRESS LINE 2");
//		
//		entitymanager.getTransaction().begin();
//		entitymanager.persist(user);
//		entitymanager.getTransaction().commit();
//		
//		System.out.println(user);
		
//		=============== code to create a new record ==============
//		User newUser = new User();
//		
//		newUser.setFullName("User's Full Name");
//		newUser.setAddressLine1("address 1");
//		newUser.setEmail("email@email.com");
//		newUser.setPassword("password");
		
//		entitymanager.getTransaction().begin();
//		entitymanager.persist(newUser);
//		entitymanager.getTransaction().commit();
//
//		System.out.println(newUser);
	}
//}
/*

public class Example {

	public static void main(String[] args) {
		//EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("whatever I want");
		//EntityManager entitymanager = emfactory.createEntityManager();
		//User user = entitymanager.find(User.class, 8);
		//System.out.println(user);

		List<User> res = findUserByName("Rachel");
		for (User u:res) {
			System.out.println(u.getEmail());
		}

	}
	*/
	public static List<User> findUserByName(String name){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("whatever I want");
		EntityManager entitymanager = emfactory.createEntityManager();
		List<User> user = entitymanager.createQuery("Select u FROM User u  Where u.fullName Like :custName")
	            .setParameter("custName", name)
	            .getResultList();
        //return user != null ? ArrayList.of(user) : ArrayList.empty();
	    return user;
	}

}