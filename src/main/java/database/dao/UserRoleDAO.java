package database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import database.entity.User;
import database.entity.UserRole;

public class UserRoleDAO{
	 private EntityManager entitymanager = null;
	 
	 public UserRoleDAO(){
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("whatever I want");
	     entitymanager = entityManagerFactory.createEntityManager();
	 }
	 
	public List<UserRole> findAllUsers() {
		// TODO Auto-generated method stub
		String sql = "SELECT u FROM UserRole u";
		TypedQuery<UserRole> query = entitymanager.createQuery(sql, UserRole.class);
		//List<User> users = query.getResultList();
		return query.getResultList();
	}
	
	public UserRole findUserById(Integer idIn) {
		// TODO Auto-generated method stub
		String sql = "SELECT u FROM UserRole u WHERE u.userid = :idValue";
		TypedQuery<UserRole> query = entitymanager.createQuery(sql, UserRole.class);
		query.setParameter("idValue", idIn);
		return query.getSingleResult();
		
	}
	
	public UserRole addUser(UserRole userIn) {
		// TODO Auto-generated method stub
		entitymanager.getTransaction().begin();
        entitymanager.persist(userIn);
        entitymanager.getTransaction().commit();

        return userIn;
	}

	public UserRole removeUser(UserRole userIn) {
		// TODO Auto-generated method stub
		entitymanager.getTransaction().begin();
        entitymanager.remove(userIn);
        entitymanager.getTransaction().commit();
        return userIn;
	}
}
