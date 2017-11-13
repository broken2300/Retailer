package com.Retailer.model;

import java.sql.Date;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity
@Table( name = "product")
public class Product {
	
	@Id  
    @Column(name = "pid")  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	int id;
	
    @Column(name = "name")  
    String name;
  
    @Column(name = "brand")  
    int brand;
    
    @Column(name = "type")  
    int type;
    
    @Column(name = "price")  
    double price;
    
    @Column(name = "store")
    int store;
    
    @Column(name = "size")
    int size;
    
    @Column(name = "UPC")
    String UPC;

    
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


	public int getBrand() {
		return brand;
	}


	public void setBrand(int brand) {
		this.brand = brand;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
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


	public String getUPC() {
		return UPC;
	}


	public void setUPC(String uPC) {
		UPC = uPC;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand
				+ ", type=" + type + ", price=" + price + ", store=" + store
				+ ", size=" + size + ", UPC=" + UPC + "]";
	}

    
}




