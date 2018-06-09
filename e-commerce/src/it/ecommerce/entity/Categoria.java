package it.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {
	
	private Long id;
	private String nome;
	private String descrizione;

	public Categoria() {
		
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

	@Column(name="nome",nullable=false,length=30)
	public String getNome() {
		return nome;
	}

	public  void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="descrizione",length=100)
	public  String getDescrizione() {
		return descrizione;
	}

	public  void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}	
}
