package it.ecommerce.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.ecommerce.entity.User;
import javax.persistence.Query;


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
	    User u = (User)em.find(User.class, id);
	    em.remove(u);
	}

	@Override
	public User getUserByID(Long id) {
		return em.find(User.class, id);
		
	}

	@Override
	public List<User> findAllUser() {
		Query q = em.createQuery("SELECT u FROM User u");
		
		return q.getResultList();
	}


	
}
