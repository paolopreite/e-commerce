package it.ecommerce.view;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;

import org.primefaces.context.RequestContext;

import it.ecommerce.business.UserBeanLocal;
import it.ecommerce.entity.User;
import it.ecommerce.utils.Utils;

@ManagedBean(name="login")
@RequestScoped
public class LoginBean {
	
	
	@EJB
	private UserBeanLocal UserBusiness;
	
	private User User;
	
	public LoginBean() {
		User = new User();
	}

	public UserBeanLocal getUserBusiness() {
		return UserBusiness;
	}

	public User getUser() {
		return User;
	}

	public void setUserBusiness(UserBeanLocal UserBusiness) {
		this.UserBusiness = UserBusiness;
	}

	public void setUser(User User) {
		this.User = User;
	}

	public void login() {
		String passwordHash = new String();
		String username = getUser().getUsername();
		try {
			passwordHash = Utils.getMd5Hash(getUser().getPassword());
			if(UserBusiness.findUserByPasswordHash(username,passwordHash) != null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("login-success.xhtml");
				//TODO: Add user to session
			} else FacesContext.getCurrentInstance().addMessage("login-error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Username not found or password does not match"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
