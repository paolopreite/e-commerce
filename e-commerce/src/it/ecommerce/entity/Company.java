package it.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_company")
public class Company {

	private long _id;
	private String businessName;
	private String vatNumber;
	private String addressStreet;
	private String addressZip;
	private String addressCity;
	private String addressProvence;
	private String email;
	private String phone;
	
	@Id
	@Column(name="id", nullable=false, columnDefinition="integer")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long get_id() {
		return _id;
	}
	
	@Column(name="business_name", nullable=false, columnDefinition="varchar",length=45)
	public String getBusinessName() {
		return businessName;
	}
	
	@Column(name="vat_number", nullable=false, columnDefinition="varchar",length=45)
	public String getVatNumber() {
		return vatNumber;
	}
	
	@Column(name="address_street", nullable=false, columnDefinition="varchar",length=45)
	public String getAddressStreet() {
		return addressStreet;
	}
	
	@Column(name="address_zip", nullable=false, columnDefinition="varchar",length=45)
	public String getAddressZip() {
		return addressZip;
	}
	
	@Column(name="address_city", nullable=false, columnDefinition="varchar",length=45)
	public String getAddressCity() {
		return addressCity;
	}
	
	@Column(name="address_provence", nullable=false, columnDefinition="varchar",length=45)
	public String getAddressProvence() {
		return addressProvence;
	}
	
	@Column(name="email", nullable=true, columnDefinition="varchar",length=45)
	public String getEmail() {
		return email;
	}
	
	@Column(name="phone", nullable=true, columnDefinition="varchar",length=45)
	public String getPhone() {
		return phone;
	}
	public void set_id(long _id) {
		this._id = _id;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
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
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
}
