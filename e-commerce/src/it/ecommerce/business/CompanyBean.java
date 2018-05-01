package it.ecommerce.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	@Override
	public Company getCompanybyID(Long id) {
		return em.find(Company.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findAllCompany() {
		return em.createQuery("SELECT c FROM Company c").getResultList();
		
	}

}
