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
	@EJB
	private RoleBeanLocal roleBusinnes;
	
	private User user   ;
	private Long idRole   ;
	
	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public UserManagedBean() {
		super();
		user = new User();
	}

	public User getUser() {
		return user;
	}
	
	public void setRole(User u) {
		user = u;
	}

	public void saveUser () {
		user.setUserRole(roleBusinnes.getRoleByID(idRole));
		userBusinnes.addUser(user);
}
	public List<User> getUsersList() {
		return userBusinnes.findAllUser();
	}
	

}
