package com.Retailer.model;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity
@Table( name = "storelog")
public class StoreLog {
	
	@Id  
    @Column(name = "lid")  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	int id;
    
    @Column(name = "customer")  
    int customer;
    
    @Column(name = "store")
    int store;
    
    @Column(name = "product")
    int product;
    
    @Column(name = "amount")
    int amount;
    
    @Column(name = "total")
    double total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomer() {
		return customer;
	}

	public void setCustomer(int customer) {
		this.customer = customer;
	}

	public int getStore() {
		return store;
	}

	public void setStore(int store) {
		this.store = store;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
    
    
}




