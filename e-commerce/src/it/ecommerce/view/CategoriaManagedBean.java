package it.ecommerce.view;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import it.ecommerce.business.CategoriaBeanLocal;

import it.ecommerce.entity.Categoria;




@ManagedBean(name="categoriamanager")
@RequestScoped
public class CategoriaManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String nome;
	private String descrizione;
	private Categoria selectedCategoria;

	@EJB
	private CategoriaBeanLocal categoriaBusinnes;
	
	
	public CategoriaManagedBean() {
	}
	
	

	public void saveCategoria () {
		if (getId() != null) {
			Categoria categoria = categoriaBusinnes.getCategoriaByID(getId());
			categoria.setNome(getNome());
			categoria.setDescrizione(getDescrizione());

			categoriaBusinnes.updateCategoria(categoria);
			
		} else {
			Categoria categoria = new Categoria();
			categoria.setNome(getNome());
			categoria.setDescrizione(getDescrizione());

			categoriaBusinnes.addCategoria(categoria);
		}

	}
	
	
	public Categoria getSelectedCategoria() {
		return selectedCategoria;
	}

	public void setSelectedCategoria(Categoria selectedCategoria) {
		this.selectedCategoria = selectedCategoria;
	}
    
    public void onRowSelect(SelectEvent event) {
    	
    	Categoria categoria = (Categoria) event.getObject();
    	this.setId(categoria.getId());
    	this.setNome(categoria.getNome());
    	this.setDescrizione(categoria.getDescrizione());
    }
    
    public void initCategoria()
	{
		this.setNome(null);
		this.setDescrizione(null);
	}

    public List<Categoria> getCategoriaList() {
		return categoriaBusinnes.findAllCategorie();
	}
    

    public void deleteCategoria(Long id) {
    	
    	Categoria cat = categoriaBusinnes.getCategoriaByID(id);
		if (!(categoriaBusinnes.getProductByCategory(cat).size() > 0)) {
			categoriaBusinnes.deleteCategoria(id);
		}
		else {
			RequestContext.getCurrentInstance().showMessageInDialog(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							"Attenzione", 
							"Non puoi cancellare la categoria commerciale perchè è già stata assegnata ad alcuni prodotti"
			));
		}

    }
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
	
	 public void cleanDialogCategoria()
		{
			this.setNome(null);
			this.setDescrizione(null);
		}
}
