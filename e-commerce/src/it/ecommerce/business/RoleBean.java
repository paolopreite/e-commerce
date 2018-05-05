package it.ecommerce.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.ecommerce.entity.Role;

/**
 * Session Bean implementation class RoleBean
 */
@Stateless
@LocalBean
public class RoleBean implements RoleBeanLocal {

	@PersistenceContext(unitName="webPersistence")
	EntityManager em;
	
    public RoleBean() {
       
    }

	@Override
	public void addRole(Role r) {
		em.persist(r);
		
	}
	
	@Override
	public void updateRole(Role r) {
		em.merge(r);
		
	}

	@Override
	public void deleteRole(Long id) {
		Role r = (Role)em.find(Role.class, id);
	    em.remove(r);
	}

	@Override
	public Role getRoleByID(Long id) {
		return em.find(Role.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAllRole() {
		Query q = em.createQuery("SELECT r FROM Role r");
		
		return q.getResultList();
		
	}

}
