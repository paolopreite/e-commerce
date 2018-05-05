package it.ecommerce.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.ecommerce.entity.Company;

/**
 * Session Bean implementation class RoleBean
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
	public void updateCompany(Company c) {
		em.merge(c);
		
	}

	@Override
	public void deleteCompany(Company c) {
		em.remove(c);
		
	}

	@Override
	public Company getCompanyByID(Long id) {
		return em.find(Company.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findAllRole() {
		Query q = em.createQuery("SELECT c FROM Company c");
		
		return q.getResultList();
		
	}

}
