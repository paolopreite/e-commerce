package it.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
	
	private Long id;
	private String ragione_sociale; 
	private String partita_iva;
	private String codice_fiscale;
	private String descrizione;
	
	public Company() {
//		this.setId(PrimaryKey.generateId());
	}

	@Id
	@Column(name="id_company",nullable=false,updatable=false)
	public Long getId() {
		return id;
	}

/*	public void setId(Long id) {
		this.id = id;
	}*/
	
	@Column(name="rs_company",nullable=false,length=50)
	public String getRagione_sociale() {
		return ragione_sociale;
	}

	public void setRagione_sociale(String ragione_sociale) {
		this.ragione_sociale = ragione_sociale;
	}

	@Column(name="pi_company",nullable=false,length=50)
	public String getPartita_iva() {
		return partita_iva;
	}

	public void setPartita_iva(String partita_iva) {
		this.partita_iva = partita_iva;
	}

	@Column(name="cf_company",nullable=false,length=30)
	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	@Column(name="desc_company",nullable=false,length=100)
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


/*	CREATE TABLE `e_commerce`.`company` (
			  `id_company` INT NOT NULL,
			  `rs_company` VARCHAR(45) NOT NULL,
			  `pi_company` VARCHAR(45) NOT NULL,
			  `cf_company` VARCHAR(45) NOT NULL,
			  `desc_company` VARCHAR(45) NOT NULL,
			  PRIMARY KEY (`id_company`))
			ENGINE = InnoDB
			DEFAULT CHARACTER SET = utf8mb4;*/

}
