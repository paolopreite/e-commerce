package it.ecommerce.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		u.setAddress("aggiornato");
		em.merge(u);
	}

	@Override
	public void deleteUser(Long id) {
		User u= getUserByID(id);
		em.remove(u);
	}

	@Override
	public User getUserByID(Long id) {
		return em.find(User.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUser() {
		return em.createQuery("SELECT u FROM User u").getResultList();
	}

}
