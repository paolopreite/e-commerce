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
	private Role role;
	private Long idRole;
	
	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public RoleManagedBean() {
		super();
		role = new Role();
	}

	public Role getRole() {
		return role;
	}
	
	public void setRole(Role r) {
		role = r;
	}
	
	public List<Role> getRolesList() {
		List<Role> r = roleBusinnes.findAllRole();
		
		return r;
		
	}
	
/*	public void saveRole () {
		roleBusinnes.addRole(role);
	}
	
	public void deleteRole(Integer id) {
		roleBusinnes.deleteRole(id);
    }*/
}
