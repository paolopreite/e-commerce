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
	
	private Long iditem;
	private String desc_item; 
	private String id_company;

	
	public Item() {
	}

	@Id
	@Column(name="id_item",nullable=false,updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIditem() {
		return iditem;
	}
	
	public void setiditem(Long id) {
		this.iditem = id;
	}

	@Column(name="desc_item",nullable=false,length=50)
	public final String getdesc_item() {
		return desc_item;
	}

	public final void setdesc_item(String desc_item) {
		this.desc_item = desc_item;
	}

	@Column(name="id_company",nullable=false,updatable=false)
	public final String getid_company() {
		return id_company;
	}

	public final void setid_company(String id_company) {
		this.id_company = id_company;
	}


	
	

}
