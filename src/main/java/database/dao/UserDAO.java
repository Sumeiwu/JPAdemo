package database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import database.entity.Product;
import database.entity.User;

public class UserDAO implements UserDAOInterface{
	 private EntityManager entitymanager = null;
	 
	 public UserDAO(){
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("whatever I want");
	     entitymanager = entityManagerFactory.createEntityManager();
	 }
	 
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		String sql = "SELECT u FROM User u";
		TypedQuery<User> query = entitymanager.createQuery(sql, User.class);
		//List<User> users = query.getResultList();
		return query.getResultList();
	}
	
	@Override
	public User findUserById(Integer idIn) {
		// TODO Auto-generated method stub
		String sql = "SELECT u FROM User u WHERE u.id = :idValue";
		TypedQuery<User> query = entitymanager.createQuery(sql, User.class);
		query.setParameter("idValue", idIn);
		return query.getSingleResult();
		
	}
	
	@Override
	public List<User> findUserByName(String Name) {
		// TODO Auto-generated method stub
		 String sql = "SELECT u FROM User u WHERE u.fullName = :Name";
		 TypedQuery<User> query = entitymanager.createQuery(sql, User.class);
		 query.setParameter("Name", Name);
		 List<User> users = query.getResultList();
		 return users;
	}
	
	@Override
	public User addUser(User userIn) {
		// TODO Auto-generated method stub
		entitymanager.getTransaction().begin();
        entitymanager.persist(userIn);
        entitymanager.getTransaction().commit();

        return userIn;
	}
	@Override
	public User removeUser(User userIn) {
		// TODO Auto-generated method stub
		entitymanager.getTransaction().begin();
        entitymanager.remove(userIn);
        entitymanager.getTransaction().commit();
        return userIn;
	}
	
	public Product findProductById(Integer idIn) {
		// TODO Auto-generated method stub
		String sql = "SELECT p FROM Product p WHERE p.id = :idValue";
		TypedQuery<Product> query = entitymanager.createQuery(sql, Product.class);
		query.setParameter("idValue", idIn);
		return query.getSingleResult();
		
	}
}
