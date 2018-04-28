package it.ecommerce.view;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import it.ecommerce.business.RoleLocal;
import it.ecommerce.entity.Role;


@ManagedBean(name="rolemanager")
@RequestScoped
public class RoleManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private RoleLocal roleBusinnes;
	private Role role;
	
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
		return roleBusinnes.getRoles();
	}
	
	public void saveRole () {
		roleBusinnes.addRole(role);
	}
	
	public void deleteRole(Integer id) {
		roleBusinnes.deleteRole(id);
    }
}
