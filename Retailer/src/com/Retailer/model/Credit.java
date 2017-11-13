package com.Retailer.model;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity
@Table( name = "credit")
public class Credit {
	
	@Id  
    @Column(name = "cid")  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	int id;
	
    @Column(name = "number")  
    String number;
    
    @Column(name = "number")  
    String CVS;
    
    @Column(name = "uid")  
    int uid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCVS() {
		return CVS;
	}

	public void setCVS(String cVS) {
		CVS = cVS;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}


    
}




