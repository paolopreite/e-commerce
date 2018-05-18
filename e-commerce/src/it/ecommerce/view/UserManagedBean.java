package it.ecommerce.view;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.SelectEvent;

import it.ecommerce.business.CompanyBeanLocal;
import it.ecommerce.business.RoleBeanLocal;
import it.ecommerce.business.UserBeanLocal;
import it.ecommerce.entity.User;


@ManagedBean(name="usermanager")
@RequestScoped
public class UserManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserBeanLocal userBusinnes;
	@EJB
	private RoleBeanLocal roleBusinnes;
	@EJB
	private CompanyBeanLocal companyBusinnes;
	private Long id;
	private String nome;
	private String cognome;
	
	@ManagedProperty(value="#{param.username}")
	private String username;

	@ManagedProperty(value="#{param.password}")
	private String password;

	private String country;
	private String city;
	private String address;
	private String cap;

	private Long idRole;
	private Long idCompany;
	private User selectedUser;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}
	
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

	public Long getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public void saveUser() {
		if(getId() != null) {
			User user = userBusinnes.getUserByID(getId());
			user.setCognome(getCognome());
		    user.setNome(getNome());
		    user.setUsername(getUsername());
		    user.setPassword(getPassword());
		    user.setCountry(getCountry());
		    user.setCity(getCity());
		    user.setAddress(getAddress());
		    user.setCap(getCap());
		    user.setRole(roleBusinnes.getRoleByID(getIdRole()));
		    user.setCompany(companyBusinnes.getCompanyByID(getIdCompany()));

		    userBusinnes.updateUser(user);
		} else {
			User user = new User();
		    user.setCognome(getCognome());
		    user.setNome(getNome());
		    user.setUsername(getUsername());
		    user.setPassword(getPassword());
		    user.setCountry(getCountry());
		    user.setCity(getCity());
		    user.setAddress(getAddress());
		    user.setCap(getCap());
		    user.setRole(roleBusinnes.getRoleByID(getIdRole()));
		    user.setCompany(companyBusinnes.getCompanyByID(getIdCompany()));

		    userBusinnes.addUser(user);
		}
	}
	
	public List<User> getUsersList() {
		return userBusinnes.findAllUser();
	}
	
	public void deleteUser(Long id) {
		userBusinnes.deleteUser(id);
    }
	
    public void onRowSelect(SelectEvent event) {
    	User user = (User) event.getObject();
    	this.setId(user.getId());
    	this.setNome(user.getNome());
    	this.setCognome(user.getCognome());
    	this.setUsername(user.getUsername());
    	this.setPassword(user.getPassword());
    	this.setCountry(user.getCountry());
    	this.setCity(user.getCity());
    	this.setAddress(user.getAddress());
    	this.setCap(user.getCap());
    	this.setIdRole(user.getRole().getId());
    	this.setIdCompany(user.getCompany().getId());
    }

	//Va richiamato nel xhtml senza il get e con la prima lettera minuscola (es:usermanager.listUser)
	public List<User> getListUser() {
		return userBusinnes.findAllUser();
	}
	
	public User checkLogin(String user,String pwd) {
		return userBusinnes.login(user,pwd);
	}
}
