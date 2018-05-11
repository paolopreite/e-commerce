package it.ecommerce.view;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.SelectEvent;

import it.ecommerce.business.CompanyBeanLocal;
import it.ecommerce.entity.Company;
import it.ecommerce.entity.Role;


@ManagedBean(name="companymanager")
@RequestScoped
public class CompanyManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String partitaIva;
	private String ragioneSociale;
	private String descrizione;
	private Long   id;
	private Company selectedCompany;
	
	@EJB
	private CompanyBeanLocal companyBusinnes;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Company getSelectedCompany() {
		return selectedCompany;
	}

	public void setSelectedCompany(Company selectedCompany) {
		this.selectedCompany = selectedCompany;
	}

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
		
		if (getId() != null) {
			Company company = new Company();
			company.setId(getId());
			company.setRagioneSociale(getRagioneSociale());
			company.setPartitaIva(getPartitaIva());
			company.setDescrizione(getDescrizione());

			companyBusinnes.updateCompany(company);
		}
		else {
			Company company = new Company();
			company.setRagioneSociale(getRagioneSociale());
			company.setPartitaIva(getPartitaIva());
			company.setDescrizione(getDescrizione());
	
		    companyBusinnes.addCompany(company);
		}
	}
	
	public void deleteCompany(Long id) {
		companyBusinnes.deleteCompany(id);
    }
	
    public void onRowSelect(SelectEvent event) {
    	Company company = (Company) event.getObject();
    	this.setId(company.getId());
    	this.setRagioneSociale(company.getRagioneSociale());
    	this.setPartitaIva(company.getPartitaIva());
    	this.setDescrizione(company.getDescrizione());
    }
}
