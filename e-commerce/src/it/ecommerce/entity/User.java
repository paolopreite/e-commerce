package it.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_user")
public class User {

	private long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String addressStreet;
	private String addressZip;
	private String addressCity;
	private String addressProvence;
	private String phone;
	private String email;
	private long roleId;
	private long companyId;
	
	@Id
	@Column(name="id", nullable=false, columnDefinition="integer")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	
	@Column(name="username", nullable=false, columnDefinition="varchar", length=45)
	public String getUsername() {
		return username;
	}
	
	@Column(name="password", nullable=false, columnDefinition="varchar", length=45)
	public String getPassword() {
		return password;
	}
	
	@Column(name="first_name", nullable=false, columnDefinition="varchar", length=45)
	public String getFirstName() {
		return firstName;
	}
	
	@Column(name="last_name", nullable=false, columnDefinition="varchar", length=45)
	public String getLastName() {
		return lastName;
	}
	
	@Column(name="address_street", nullable=false, columnDefinition="varchar", length=45)
	public String getAddressStreet() {
		return addressStreet;
	}
	
	@Column(name="address_zip", nullable=false, columnDefinition="varchar", length=45)
	public String getAddressZip() {
		return addressZip;
	}
	
	@Column(name="address_city", nullable=false, columnDefinition="varchar", length=45)
	public String getAddressCity() {
		return addressCity;
	}
	
	@Column(name="address_provence", nullable=false, columnDefinition="varchar", length=45)
	public String getAddressProvence() {
		return addressProvence;
	}
	
	@Column(name="phone", nullable=true, columnDefinition="varchar", length=45)
	public String getPhone() {
		return phone;
	}
	
	@Column(name="email", nullable=false, columnDefinition="varchar", length=45)
	public String getEmail() {
		return email;
	}
	
	@Column(name="role_id", nullable=false, columnDefinition="integer")
	public long getRoleId() {
		return roleId;
	}
	
	@Column(name="company_id", nullable=false, columnDefinition="integer")
	public long getCompanyId() {
		return companyId;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public void setAddressProvence(String addressProvence) {
		this.addressProvence = addressProvence;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	
	
	
}
