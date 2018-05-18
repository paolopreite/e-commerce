package it.ecommerce.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.GET;

import org.primefaces.event.SelectEvent;

import it.ecommerce.business.CompanyBeanLocal;
import it.ecommerce.business.RoleBeanLocal;
import it.ecommerce.business.UserBeanLocal;

import it.ecommerce.entity.User;


@ManagedBean(name = "usermanager")
//@SessionScoped
@RequestScoped
public class UserManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Dichiaro le variabili BeanLocal (Business Layer)
	@EJB
	private UserBeanLocal ubl;



/*	With a @ManagedProperty, which sets the parameter as managed bean property.
	@ManagedProperty("#{param.someparam}")  -> Request Scope
	private String someparam;*/

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
	private Long idrole;
	private Long idcompany;
	
	
	 
	public UserManagedBean() {
	}



	public final Long getId() {
		return id;
	}



	public final void setId(Long id) {
		this.id = id;
	}



	public final String getNome() {
		return nome;
	}



	public final void setNome(String nome) {
		this.nome = nome;
	}



	public final String getCognome() {
		return cognome;
	}



	public final void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public final String getUsername() {
		return username;
	}



	public final void setUsername(String username) {
		this.username = username;
	}



	public final String getPassword() {
		return password;
	}



	public final void setPassword(String password) {
		this.password = password;
	}



	public final String getCountry() {
		return country;
	}



	public final void setCountry(String country) {
		this.country = country;
	}



	public final String getCity() {
		return city;
	}



	public final void setCity(String city) {
		this.city = city;
	}



	public final String getAddress() {
		return address;
	}



	public final void setAddress(String address) {
		this.address = address;
	}



	public final String getCap() {
		return cap;
	}



	public final void setCap(String cap) {
		this.cap = cap;
	}



	public final Long getIdrole() {
		return idrole;
	}



	public final void setIdrole(Long idrole) {
		this.idrole = idrole;
	}



	public final Long getIdcompany() {
		return idcompany;
	}



	public final void setIdcompany(Long idcompany) {
		this.idcompany = idcompany;
	}

	//Va richiamato nel xhtml senza il get e con la prima lettera minuscola (es:usermanager.listUser)
	public List<User> getListUser() 
	{
		return ubl.findAllUser();
	}
	
	
	public User checkLogin(String user,String pwd)
	{
		return ubl.login(user,pwd);
	}
	
	
	

/*	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("User Selected",this.getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }*/
	
}
