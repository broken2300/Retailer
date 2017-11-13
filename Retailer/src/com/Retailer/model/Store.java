package com.Retailer.model;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity
@Table( name = "store")
public class Store {
	
	@Id  
    @Column(name = "sid")  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	int id;
	
    @Column(name = "name")  
    String name;
    
    @Column(name = "maxStock")  
    int maxStock;
    
    @Column(name = "stock")
    int stock;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxStock() {
		return maxStock;
	}

	public void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
    
    
}




