package it.ecommerce.business;

import java.util.List;

import javax.ejb.Local;

import it.ecommerce.entity.Role;

@Local
public interface RoleLocal {

	public void addRole(Role r);
	
	public void updateRole(Role r);
	
	public void deleteRole(Integer id);
	
	public Role getRole(Integer id);
	
	public List<Role> getRoles();
}
