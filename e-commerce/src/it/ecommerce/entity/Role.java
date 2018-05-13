package it.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_role")
public class Role {

	private long _id;
	private String name;
	private String description;
	
	@Id
	@Column(name="id", nullable=false, columnDefinition="integer")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long get_id() {
		return _id;
	}
	
	@Column(name="name", nullable=false, columnDefinition="varchar", length=45)
	public String getName() {
		return name;
	}
	
	@Column(name="description", nullable=true, columnDefinition="varchar", length=45)
	public String getDescription() {
		return description;
	}
	
	
	
	public void set_id(long _id) {
		this._id = _id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
