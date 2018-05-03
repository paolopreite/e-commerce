package it.ecommerce.view;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import it.ecommerce.business.RoleBeanLocal;
import it.ecommerce.business.UserBeanLocal;
import it.ecommerce.entity.Role;
import it.ecommerce.entity.User;


@ManagedBean(name="usermanager")
@RequestScoped
public class UserManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserBeanLocal userBusinnes;
	private User user   ;
	
	public UserManagedBean() {
		super();
		user = new User();
		user.setUserRole(new Role());
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User u) {
		user = u;
	}

	public void saveUser () {
		userBusinnes.addUser(user);
}
	public List<User> getUsersList() {
		return userBusinnes.findAllUser();
	}
	

}
