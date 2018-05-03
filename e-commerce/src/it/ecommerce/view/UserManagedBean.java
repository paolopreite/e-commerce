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
	private String nome;
	private String cognome;
	private Long idRole;
	
	public UserManagedBean() {

	}

	public String getNome() {
		return nome;
	}


	public void setNome(String n) {
		nome = n;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String c) {
		cognome = c;
	}


	public Long getIdRole() {
		return idRole;
	}


	public void setIdRole(Long id) {
		idRole = id;
	}


	public void saveUser () {
		User user = new User();
	    user.setCognome(getCognome());
	    user.setNome(getNome());
	    user.setUserRole(roleBusinnes.getRoleByID(idRole));

		userBusinnes.addUser(user);
}
	public List<User> getUsersList() {
		return userBusinnes.findAllUser();
	}
	

}
