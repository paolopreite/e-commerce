package it.ecommerce.business;

import java.util.List;
import it.ecommerce.entity.Prodotto;
import javax.ejb.Local;

@Local
public interface ProdottoBeanLocal {
	public void addProdotto(Prodotto p);
	public void updateProdotto(Prodotto p);
	public Prodotto getProdottoByID(Long id);
	public void deleteProdotto(Long id);
	public List<Prodotto>findAllProdotti();
}
