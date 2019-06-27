package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


import org.springframework.samples.petclinic.model.NamedEntity;

@Entity
@Table(name = "products")
public class Product extends NamedEntity{

	private static final long serialVersionUID = 1L;

	@Column(name = "description")
    
	private String description;
	
	@Column(name = "peso")
    
	private String peso;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}
}
