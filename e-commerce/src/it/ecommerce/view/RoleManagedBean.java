package it.ecommerce.view;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.tomee.loader.filter.PackageFilter;
import org.primefaces.context.PrimeFacesContext;
import org.primefaces.event.SelectEvent;

import it.ecommerce.business.RoleBeanLocal;
import it.ecommerce.entity.Role;


@ManagedBean(name="rolemanager")
@RequestScoped
public class RoleManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private RoleBeanLocal roleBusinnes;
	private String nome;
	private String descrizione;
	private Long   idRuolo;
	private Role selectedRole;
	
	
	public RoleManagedBean() {
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public List<Role> getRolesList() {
		List<Role> r = roleBusinnes.findAllRole();
		return r;
		
	}
	
	public Long getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(Long idRuolo) {
		this.idRuolo = idRuolo;
	}

	public void saveRole () {
		
		if (getIdRuolo() != null) {
			Role role = new Role();
			role.setId(getIdRuolo());
			role.setNome(getNome());
			role.setDescrizione(getDescrizione());

			roleBusinnes.updateRole(role);
		}
		else {
			Role role = new Role();
			role.setNome(getNome());
			role.setDescrizione(getDescrizione());

			roleBusinnes.addRole(role);
		}

	}
	
	public void deleteRole(Long id) {
		roleBusinnes.deleteRole(id);
    }
	
	public Role getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(Role selectedRole) {
		this.selectedRole = selectedRole;
	}
    
}
