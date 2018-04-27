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
	
	private Long id;
	private String nome;
	private String descrizione;

	public Role() {
		
	}
	
	@Id
	@Column(name="id_role",nullable=false,updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}


	@Column(name="nome_role",nullable=false,length=30)
	public String getNome() {
		return nome;
	}

	public  void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="descrizione_role",nullable=false,length=100)
	public  String getDescrizione() {
		return descrizione;
	}

	public  void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


/*	CREATE TABLE `e_commerce`.`role` (
			  `id_role` INT NOT NULL,
			  `nome_role` VARCHAR(45) NOT NULL,
			  `descrizione_role` VARCHAR(45) NOT NULL,
			  PRIMARY KEY (`id_role`))
			ENGINE = InnoDB
			DEFAULT CHARACTER SET = utf8mb4;*/
	

}
