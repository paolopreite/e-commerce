package it.ecommerce.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.ecommerce.entity.Prodotto;

/**
 * Session Bean implementation class Prodotto
 */
@Stateless
@LocalBean
public class ProdottoBean implements ProdottoBeanLocal {

	@PersistenceContext(unitName="webPersistence")
	EntityManager em;
	
    public ProdottoBean() {
        
    }


	@Override
	public Prodotto getProdottoByID(Long id) {
		return em.find(Prodotto.class, id);
		
	}


	public void deleteProdotto(Long id) {
		Prodotto p= getProdottoByID(id);
		em.remove(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prodotto> findAllProdotti() {
		return em.createQuery("SELECT p FROM Prodotto p").getResultList();
	}


	@Override
	public void addProdotto(Prodotto p) {
		em.persist(p);
		
	}


	@Override
	public void updateProdotto(Prodotto p) {
		em.merge(p);
		
	}




}
