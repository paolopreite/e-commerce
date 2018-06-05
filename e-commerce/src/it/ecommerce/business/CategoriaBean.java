package it.ecommerce.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.ecommerce.entity.Categoria;

/**
 * Session Bean implementation class CategoriaBean
 */
@Stateless
public class CategoriaBean implements CategoriaBeanLocal {

	@PersistenceContext(unitName="webPersistence")
	EntityManager em;
    public CategoriaBean() {
        
    }

	@Override
	public void addCategoria(Categoria c) {
		em.persist(c);
		
	}

	@Override
	public void updateCategoria(Categoria c) {
		em.merge(c);
		
	}

	@Override
	public void deleteCategoria(Long id) {
		em.remove(id);
		
	}

	@Override
	public Categoria getCategoriaByID(Long id) {
		return em.find(Categoria.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findAllCategorie() {
		return em.createQuery("SELECT c FROM Categoria c").getResultList();
	}

}
