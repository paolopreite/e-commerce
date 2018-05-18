package it.ecommerce.business;

import java.util.List;

import javax.ejb.Local;

import it.ecommerce.entity.Role;

@Local
public interface RoleBeanLocal {

	public void addRole(Role r);
	public void updateRole(Long id);
	public void deleteRole(Long id);
	public Role getRoleByID(Long id);
	public List<Role> findAllRole();
}
