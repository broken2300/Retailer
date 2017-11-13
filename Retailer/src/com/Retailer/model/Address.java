package com.Retailer.model;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity
@Table( name = "address")
public class Address {
	
	@Id  
    @Column(name = "aid")  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	int id;
	
    @Column(name = "address")  
    String address;
    
    @Column(name = "uid")  
    int uid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
    
    
}




