package database;

import java.util.List;

import database.dao.UserDAO;
import database.dao.UserRoleDAO;
import database.entity.Product;
import database.entity.User;
import database.entity.UserRole;

public class ExampleDAPMain {
	//1 findUserByName(String name)
	//2 update the address or city or state
	//3 save
	//4 create a new user in the database and print the newly generated id
	public static void main(String[] args) {
//		UserDAO userDao = new UserDAO();
//		UserRoleDAO userRoleDao = new UserRoleDAO();
//		List<UserRole> roles = userRoleDao.findAllUsers();
//		for (UserRole role:roles) System.out.println(role);
//		List<User> users = userDao.findAllUsers();
//		
//		for (User user:users) {
//			System.out.println(user);
//		}
		
		UserDAO userDao2 = new UserDAO();
		User user = userDao2.findUserById(1);
		System.out.println(user);
		
		for (UserRole role:user.getUserRoles()) {
			System.out.println(role);
		}
		
		for (Product p :user.getProducts()) System.out.println(p);
		System.out.println("----------------");
		
		Product p = userDao2.findProductById(1);
		System.out.println(p);
		for (User u:p.getUsers()) System.out.println(u);

	}

}
