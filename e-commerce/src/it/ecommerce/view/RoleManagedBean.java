package it.ecommerce.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import it.ecommerce.business.CompanyBeanLocal;
import it.ecommerce.business.RoleBeanLocal;
import it.ecommerce.business.UserBeanLocal;
import it.ecommerce.entity.Role;
import it.ecommerce.entity.User;

@ManagedBean(name = "rolemanager")
@SessionScoped
public class RoleManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Dichiaro le variabili BeanLocal (Business Layer)
	@EJB

	private RoleBeanLocal rbl;

	
	private String nome;
	private String descrizione;
	
	
	 
	public RoleManagedBean() {
	}



	public final String getNome() {
		return nome;
	}



	public final void setNome(String nome) {
		this.nome = nome;
	}



	public final String getDescrizione() {
		return descrizione;
	}



	public final void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public List<Role> getListRole() {
		return rbl.findAllRole();
		
		
	}
	
/*	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Role Selected",this.getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }*/

}

	