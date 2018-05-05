//Author:Vanore

package it.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
  
	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String country;
	private String city;
	private String address;
	private String cap;
	private Role role;
	private Company company;

	
	public User() {
	}
	
	@Id
	@Column(name="id_user",nullable=false,updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	public  Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="nome",nullable=false,length=30)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="cognome",nullable=false,length=30)
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Column(name="username",nullable=false,length=20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="password",nullable=false,length=8)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="country",nullable=false,length=30)
	public final String getCountry() {
		return country;
	}

	public final void setCountry(String country) {
		this.country = country;
	}

	@Column(name="city",nullable=false,length=100)
	public final String getCity() {
		return city;
	}

	public final void setCity(String city) {
		this.city = city;
	}

	@Column(name="address",nullable=false,length=100)
	public final String getAddress() {
		return address;
	}

	public final void setAddress(String address) {
		this.address = address;
	}

	@Column(name="cap",nullable=false,length=10)
	public final String getCap() {
		return cap;
	}

	public final void setCap(String cap) {
		this.cap = cap;
	}

	@ManyToOne()//(cascade = CascadeType.ALL)*/
	@JoinColumn(name="id_role")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public final Role getRole() {
		return role;
	}

	public final void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne()//(cascade = CascadeType.ALL)
	@JoinColumn(name="id_company")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public final Company getCompany() {
		return company;
	}

	public final void setCompany(Company company) {
		this.company = company;
	}

	
}
