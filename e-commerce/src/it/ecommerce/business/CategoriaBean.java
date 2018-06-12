package it.ecommerce.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;

import it.ecommerce.entity.Categoria;
import it.ecommerce.entity.Prodotto;
import it.ecommerce.entity.Role;
import it.ecommerce.entity.User;

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
		Categoria r = getCategoriaByID(id);
		  em.remove(r);
		
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
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Prodotto> getProductByCategory(Categoria categoria) {
		return em.createQuery("SELECT u FROM Prodotto u WHERE u.categoria =:categoria")
			      .setParameter("categoria", categoria)
			      .getResultList();
	}



}
