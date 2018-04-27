package it.ecommerce.business;

import java.util.List;

import javax.ejb.Local;

import it.ecommerce.entity.Role;

@Local
public interface RoleBeanLocal {

	public void addeRole(Role r);
	public void updateRole(Role r);
	public void deleteRole(Role r);
	public Role getRoleByID(Long id);
	public List<Role> findAllRole();
}
