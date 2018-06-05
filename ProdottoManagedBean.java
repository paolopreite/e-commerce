package it.ecommerce.view;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.SelectEvent;

import it.ecommerce.business.CategoriaBeanLocal;
import it.ecommerce.business.CompanyBeanLocal;
import it.ecommerce.business.ProdottoBeanLocal;
import it.ecommerce.entity.Prodotto;



@ManagedBean(name="productmanager")
@RequestScoped
public class ProdottoManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String descrizione; 
	private String prezzo;
	private String produttore;
	private String foto;
	private Long idCompany;
	private Long idCategoria;
	private Prodotto selectedProduct;
	
	@EJB
	private CompanyBeanLocal companyBusinnes;
	@EJB
	private ProdottoBeanLocal prodottoBusinnes;
	@EJB
	private CategoriaBeanLocal categoriaBusinnes;
	
	public final Long getId() {
		return id;
	}
	public final void setId(Long id) {
		this.id = id;
	}
	public final String getNome() {
		return nome;
	}
	public final void setNome(String nome) {
		this.nome = nome;
	}
	public final String getDescrizione() {
		return descrizione;
	}
	public final void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public final String getPrezzo() {
		return prezzo;
	}
	public final void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}
	public final String getProduttore() {
		return produttore;
	}
	public final void setProduttore(String produttore) {
		this.produttore = produttore;
	}
	public final String getFoto() {
		return foto;
	}
	public final void setFoto(String foto) {
		this.foto = foto;
	}
	
	public List<Prodotto> getProductList() {
		return prodottoBusinnes.findAllProdotti();
	}

	public void deleteProdotto(Long id) {
		prodottoBusinnes.deleteProdotto(id);
    }
	
	public final Prodotto getSelectedProduct() {
		return selectedProduct;
	}
	public void setSelectedProduct(Prodotto selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	
	 public void onRowSelect(SelectEvent event) {	
	    	Prodotto prodotto = (Prodotto) event.getObject();
	    	this.setId(prodotto.getId());
	    	this.setNome(prodotto.getNome());
	    	this.setDescrizione(prodotto.getDescrizione());
	    	this.setPrezzo(prodotto.getPrezzo());
	    	this.setProduttore(prodotto.getProduttore());
	    	this.setFoto(prodotto.getFoto());
	    	this.setIdCompany(prodotto.getCompany().getId());
	    	this.setIdCategoria(prodotto.getCategoria().getId());
	    	prodotto.setCompany(companyBusinnes.getCompanyByID(getIdCompany()));
	    	prodotto.setCategoria(categoriaBusinnes.getCategoriaByID(getIdCategoria()));
	    }

	
	public void initProduct()
	{
		this.setNome(null);
		this.setDescrizione(null);
		this.setPrezzo(null);
		this.setProduttore(null);
		this.setFoto(null);
	}
	
	public void saveProduct() {
		if (getId() != null) {
			Prodotto prodotto = prodottoBusinnes.getProdottoByID(getId());
			prodotto.setNome(getNome());
			prodotto.setDescrizione(getDescrizione());
			prodotto.setPrezzo(getPrezzo());
			prodotto.setProduttore(getProduttore());
			prodotto.setFoto(getFoto());
			prodotto.setCompany(companyBusinnes.getCompanyByID(getIdCompany()));
			prodotto.setCategoria(categoriaBusinnes.getCategoriaByID(getIdCategoria()));
			prodottoBusinnes.updateProdotto(prodotto);
			
		} else {
			Prodotto prodotto = new Prodotto();
			prodotto.setNome(getNome());
			prodotto.setDescrizione(getDescrizione());
			prodotto.setPrezzo(getPrezzo());
			prodotto.setProduttore(getProduttore());
			prodotto.setFoto(getFoto());
			prodotto.setCompany(companyBusinnes.getCompanyByID(getIdCompany()));
			prodotto.setCategoria(categoriaBusinnes.getCategoriaByID(getIdCategoria()));
			prodottoBusinnes.addProdotto(prodotto);
		}

	}
	public final Long getIdCompany() {
		return idCompany;
	}
	public final void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}
	public final Long getIdCategoria() {
		return idCategoria;
	}
	public final void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	
}
