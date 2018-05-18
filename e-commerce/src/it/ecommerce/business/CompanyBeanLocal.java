package it.ecommerce.business;

import java.util.List;

import javax.ejb.Local;

import it.ecommerce.entity.Company;

@Local
public interface CompanyBeanLocal {

	public void addCompany(Company c);
	public void updateCompany(Company c);
	public Company getCompanyByID(Long id);
	public void deleteCompany(Long id);
	public List<Company> findAllCompany();
}
