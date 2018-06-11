package it.ecommerce.business;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.openejb.jee.jba.Home;

import it.ecommerce.entity.User;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
public class UserBean implements UserBeanLocal {

	@PersistenceContext(unitName="webPersistence")
	EntityManager em;
	
    public UserBean() {
        
    }

public void addUser(User u) {
		em.persist(u);
	}

	@Override
	public void updateUser(User u) {
		em.merge(u);
	}

	@Override
	public void deleteUser(Long id) {
	    User u = getUserByID(id);
	    em.remove(u);
	}

	@GET
	@Path(value="/user/lista/{id_user}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByID(@PathParam("id_user")Long id) {
		return em.find(User.class, id);
	}
	
	@GET
	@Path(value="/user/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findAllUser() {
		return em.createQuery("SELECT u FROM User u").getResultList();
	}
	
	@GET
	public User login(String user, String pwd) {
		/*User u = (User) em.createQuery("SELECT u FROM User u WHERE u.username =:user1 AND u.password = :pwd1")
		      .setParameter("user1", user)
		      .setParameter("pwd1", pwd)
		      .getSingleResult();
          
		return u;*/
		return null;
	}

	@Override
	public User findUserByPasswordHash(String username, String passwordHash) {
		Query q = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password");
		q.setParameter("username", username);
		q.setParameter("password", passwordHash);
		
		List<User> results =  (List<User>) q.getResultList();
		if(!results.isEmpty()) {
			return results.get(0);
		}
		
		return null;
	}
	
	
}
