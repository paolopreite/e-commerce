package it.ecommerce.view;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
	
	public void saveRole () {
		Role role = new Role();
		role.setNome(getNome());
		role.setDescrizione(getDescrizione());

		roleBusinnes.addRole(role);
	}
	
	public void deleteRole(Long id) {
		roleBusinnes.deleteRole(id);
    }
}
