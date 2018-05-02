package it.ecommerce.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.ecommerce.entity.Company;

/**
 * Session Bean implementation class CompanyBean
 */
@Stateless
@LocalBean
public class CompanyBean implements CompanyBeanLocal {

	@PersistenceContext(unitName="webPersistence")
	EntityManager em;
	
    public CompanyBean() {
        
    }

	@Override
	public void addCompany(Company c) {
		em.persist(c);
		
	}

	@Override
	public void updateCompany(Long id) {
		Company c= this.getCompanybyID(id);
		em.merge(c);
	}

	@Override
	public void deleteCompany(Long id) {
		Company c= getCompanybyID(id);
		em.remove(c);
		
	}


	@GET
	@Path(value="/company/lista/{id_company}")
	@Produces(MediaType.APPLICATION_JSON)
	public Company getCompanybyID(@PathParam("id_company")Long id) {
		return em.find(Company.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path(value="/company/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Company> findAllCompany() {
		return em.createQuery("SELECT c FROM Company c").getResultList();
		
	}

}
