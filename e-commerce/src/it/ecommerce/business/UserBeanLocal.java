package it.ecommerce.business;

import java.util.List;

import javax.ejb.Local;

import it.ecommerce.entity.User;

@Local
public interface UserBeanLocal {

	public void addUser(User u);
	public void updateUser(User u);
	public void deleteUser(Long id);
	public User getUserByID(Long id);
	public List<User> findAllUser();
	public User login(String user,String pwd);
	public User findUserByPasswordHash(String username, String passwordHash);
}
