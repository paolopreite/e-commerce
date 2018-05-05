package it.ecommerce.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.ecommerce.entity.User;


/**
 * Session Bean implementation class UserBean
 */
@Stateless
@LocalBean
public class UserBean implements UserBeanLocal {

	@PersistenceContext(unitName="webPersistence")
	EntityManager em;
	
    public UserBean() {
        
    }

	public void addUser(User u) {
		em.persist(u);
	}

	@Override
	public void updateUser(Long id) {
		User u= getUserByID(id);
		em.merge(u);
	}

	@Override
	public void deleteUser(Long id) {
		User u= getUserByID(id);
		em.remove(u);
	}

	
	@GET
	@Path(value="/user/lista/{id_user}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByID(@PathParam("id_user")Long id) {
		return em.find(User.class, id);
		
	}

	@SuppressWarnings("unchecked")
	
	@GET
	@Path(value="/user/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findAllUser() {
		return em.createQuery("SELECT u FROM User u").getResultList();
	}

}
