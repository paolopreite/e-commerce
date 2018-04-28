package it.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	private Integer id;
	private String nome;
	private String descrizione;

	public Role() {
		
	}
	
	@Id
	@Column(name="id_role",nullable=false,updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	@Column(name="nome",nullable=false,length=45)
	public String getNome() {
		return nome;
	}

	public  void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="descrizione",length=255)
	public  String getDescrizione() {
		return descrizione;
	}

	public  void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
