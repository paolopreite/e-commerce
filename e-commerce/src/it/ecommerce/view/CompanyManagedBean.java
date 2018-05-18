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
import it.ecommerce.entity.Company;
import it.ecommerce.entity.Role;
import it.ecommerce.entity.User;

@ManagedBean(name = "companymanager")
@SessionScoped
public class CompanyManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Dichiaro le variabili BeanLocal (Business Layer)
	@EJB
	private CompanyBeanLocal cbl;
	
	private String ragioneSociale; 
	private String partitaIva;
	private String codiceFiscale;
	private String descrizione;
	
	
	
	public final String getRagioneSociale() {
		return ragioneSociale;
	}
	public final void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public final String getPartitaIva() {
		return partitaIva;
	}
	public final void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public final String getCodiceFiscale() {
		return codiceFiscale;
	}
	public final void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public final String getDescrizione() {
		return descrizione;
	}
	public final void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public List<Company> getListCompany() {
		List<Company> companies= cbl.findAllCompany();
		return companies;
	}
	
	public void deleteCompany(Long id) {
		cbl.deleteCompany(id);
    }
	
/*	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Company Selected",this.getRagioneSociale());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }*/
	
}
