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


	public void addRole(Role r) {
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

	@GET
	@Path(value="/role/lista/{id_role}")
	@Produces(MediaType.APPLICATION_JSON)
	public Role getRoleByID(@PathParam("id_role")Long id) {
		return em.find(Role.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path(value="/role/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Role> findAllRole() {
		return em.createQuery("SELECT r FROM Role r").getResultList();
		
	}

}
