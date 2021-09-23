package database.dao;

import java.util.List;

import database.entity.User;

public interface UserDAOInterface {
    List<User> findAllUsers();
    User findUserById(Integer idIn);
    List<User> findUserByName(String Name);
    User addUser(User userIn);
    User removeUser(User userIn);

}
	
