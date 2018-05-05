package it.ecommerce.view;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import it.ecommerce.business.CompanyBeanLocal;
import it.ecommerce.entity.Company;


@ManagedBean(name="companymanager")
@RequestScoped
public class CompanyManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String partitaIva;
	private String ragioneSociale;
	private String descrizione;
	
	@EJB
	private CompanyBeanLocal companyBusinnes;
	public CompanyManagedBean() {
	}
	
	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Company> getCompaniesList() {
		List<Company> r = companyBusinnes.findAllRole();
		
		return r;
		
	}
	
	public void saveCompany () {
		Company company = new Company();
		company.setRagioneSociale(getRagioneSociale());
		company.setPartitaIva(getPartitaIva());
		company.setDescrizione(getDescrizione());

	    companyBusinnes.addCompany(company);
	}
	
	public void deleteCompany(Long id) {
		companyBusinnes.deleteCompany(id);
    }
}
