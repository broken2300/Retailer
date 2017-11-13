package com.Retailer.model;

import java.sql.Date;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity
@Table( name = "vendorprodcut")
public class VendorProduct {
	
	@Id  
    @Column(name = "pid")  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	int id;
	
    @Column(name = "name")  
    String name;
  
    @Column(name = "brand")  
    String brand;
    
    @Column(name = "type")  
    String type;
    
    @Column(name = "price")  
    double price;
    
    @Column(name = "store")
    int store;
    
    @Column(name = "size")
    int size;
    
   	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand
				+ ", type=" + type + ", price=" + price + ", store=" + store
				+ ", size=" + size;
	}

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStore() {
		return store;
	}

	public void setStore(int store) {
		this.store = store;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

    
}




