package org.socialnetworking.dao;

import java.util.List;
import org.socialnetworking.model.User;


public interface IUserDAO{
	
	public User getUser(int id);
	public List<User> getAllUsers();
	public List<User> getDUsers();
	public List<User> getAUsers();
	public User getUserByUserName(String userName);
	public boolean activateUser(int id);
	public boolean addUser(User u);
	public boolean updateUser(User u);
	public boolean deleteUser(int id);

}
