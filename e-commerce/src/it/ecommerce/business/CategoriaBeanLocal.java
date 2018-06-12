package it.ecommerce.business;

import java.util.List;

import javax.ejb.Local;

import it.ecommerce.entity.Categoria;
import it.ecommerce.entity.Prodotto;


@Local
public interface CategoriaBeanLocal {

	public void addCategoria(Categoria c);
	public void updateCategoria(Categoria c);
	public void deleteCategoria(Long id);
	public Categoria getCategoriaByID(Long id);
	public List<Categoria> findAllCategorie();
	public List<Prodotto>getProductByCategory(Categoria cat);
}
