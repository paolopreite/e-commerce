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
@Table(name="prodotto")
public class Prodotto {
	
	private Long id;
	private String nome;
	private String descrizione; 
	private String prezzo;
	private String produttore;
	private String foto;
	private Company company;
	private Categoria categoria;
	
	public Prodotto() {
	}

	@Column(name="nome_prodotto",nullable=false,length=100)
	public final String getNome() {
		return nome;
	}

	public final void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="descrizione_prodotto",nullable=false,length=100)
	public final String getDescrizione() {
		return descrizione;
	}

	public final void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Column(name="prezzo_prodotto",nullable=false,length=100)
	public final String getPrezzo() {
		return prezzo;
	}

	public final void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	@Column(name="produttore_prodotto",nullable=false,length=100)
	public final String getProduttore() {
		return produttore;
	}

	public final void setProduttore(String produttore) {
		this.produttore = produttore;
	}

	@Column(name="foto_prodotto",nullable=false,length=150)
	public final String getFoto() {
		return foto;
	}

	public final void setFoto(String foto) {
		this.foto = foto;
	}

	@ManyToOne()
	@JoinColumn(name="id_company")
	public final Company getCompany() {
		return company;
	}

	public final void setCompany(Company c) {
		company = c;
	}
	
	@ManyToOne()
	@JoinColumn(name="id_categoria")
	public final Categoria getCategoria() {
		return categoria;
	}

	public final void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Id
	@Column(name="id",nullable=false,updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}




	


	



}