package it.ecommerce.view;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import it.ecommerce.business.RoleBeanLocal;
import it.ecommerce.business.UserBeanLocal;
import it.ecommerce.entity.Role;


@ManagedBean(name="rolemanager")
@RequestScoped
public class RoleManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private RoleBeanLocal roleBusiness;
	@EJB
	private UserBeanLocal userBusinnes;
	
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
		List<Role> r = roleBusiness.findAllRole();
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
			Role role = roleBusiness.getRoleByID(getIdRuolo());
			role.setNome(getNome());
			role.setDescrizione(getDescrizione());

			roleBusiness.updateRole(role);
		} else {
			Role role = new Role();
			role.setNome(getNome());
			role.setDescrizione(getDescrizione());

			roleBusiness.addRole(role);
		}
		
		cleanDialogRole();

	}
	
	public void deleteRole(Long id) {
		Role role = roleBusiness.getRoleByID(id);
		if (!(userBusinnes.getUsersByRole(role).size() > 0)) {
			roleBusiness.deleteRole(id);
		}
		else {
			RequestContext.getCurrentInstance().showMessageInDialog(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							"Attenzione", 
							"Non puoi cancellare il ruolo perchè è già stato assegnato a degli utenti"
			));
		}
    }
	
	public Role getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(Role selectedRole) {
		this.selectedRole = selectedRole;
	}
    
    public void onRowSelect(SelectEvent event) {
    	
    	Role role = (Role) event.getObject();
    	this.setIdRuolo(role.getId());
    	this.setNome(role.getNome());
    	this.setDescrizione(role.getDescrizione());
    }
    
    public void cleanDialogRole()
	{
		this.setNome(null);
		this.setDescrizione(null);
	}
}