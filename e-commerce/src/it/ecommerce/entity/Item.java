//Author:Vanore

package it.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	private Long id;
	private String descrizione; 
	private String idCompany;

	
	public Item() {
	}

	@Id
	@Column(name="id",nullable=false,updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="descrizione",nullable=false,length=50)
	public final String getDescrizione() {
		return descrizione;
	}

	public final void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Column(name="id_company",nullable=false,updatable=false)
	public final String getIdCompany() {
		return idCompany;
	}

	public final void setIdCompany(String idCompany) {
		this.idCompany = idCompany;
	}


	
	

}
