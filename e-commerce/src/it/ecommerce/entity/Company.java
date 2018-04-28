package it.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
	
	private Long id;
	private String ragioneSociale; 
	private String partitaIva;
	private String codiceFiscale;
	private String descrizione;
	
	public Company() {
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
	
	@Column(name="ragioneSociale",nullable=false,length=50)
	public String getRagione_sociale() {
		return ragioneSociale;
	}

	public void setRagione_sociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	@Column(name="partitaIva",nullable=false,length=50)
	public String getPartita_iva() {
		return partitaIva;
	}

	public void setPartita_iva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	@Column(name="codiceFiscale",nullable=false,length=30)
	public String getCodice_fiscale() {
		return codiceFiscale;
	}

	public void setCodice_fiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	@Column(name="descrizione",nullable=false,length=100)
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
