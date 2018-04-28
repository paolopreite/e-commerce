package it.ecommerce.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.ecommerce.entity.Role;

@Stateless
public class RoleBean implements RoleLocal {

	@PersistenceContext(unitName="ecommercePersistence")
	EntityManager manager;
	
	public void addRole(Role r) {
		manager.persist(r);
	}
	
	public void updateRole(Role r) {
		manager.merge(r);
	}
	
	public void deleteRole(Integer id) {
		Role r = getRole(id);
		manager.remove(r);
	}
	
	public Role getRole(Integer id) {
		return manager.find(Role.class, id);
	}
	
	public List<Role> getRoles() {
		Query q = manager.createQuery("SELECT r FROM Role r");
		
		return q.getResultList();
	}
}
