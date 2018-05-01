package it.ecommerce.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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


	public void addeRole(Role r) {
		em.persist(r);
		
	}
	
	@Override
	public void updateRole(Long id) {
		Role r= getRoleByID(id);
		em.merge(r);
		
	}

	@Override
	public void deleteRole(Long id) {
		Role r= getRoleByID(id);
		em.remove(r);
		
	}

	@Override
	public Role getRoleByID(Long id) {
		return em.find(Role.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAllRole() {
		return em.createQuery("SELECT r FROM Role r").getResultList();
		
	}

}
