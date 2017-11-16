package com.Retailer.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.Retailer.model.Address;

@Repository("addressDao")
public class AddressDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void addAddress(Address address)  {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.save(address);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void delAddress(int addressId) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        Address u = new Address();
        u.setId(addressId);
        session.delete(u);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void updateAddress(Address Address) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.update(Address);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        session.close();  
          
    }
    
    public List<Address> selectAddressByString(String param, String value)  {  
        List<Address> Addresses = new ArrayList<Address>();  
        
    	Session session = sessionFactory.openSession();

    	Transaction tc = (Transaction) session.beginTransaction();  
        //tc.begin();
        String hqlString = " From Address u where u."+ param + "='" + value+"'";
        if(session.createQuery(hqlString) != null){
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	Address u = (Address) iterator.next();  
	        	Addresses.add(u);  
	        }  
	        tc.commit();
	        session.close();  
	        return Addresses;  
        }
        else 
        {
        	tc.commit();
        	return null;
        }

    }
    
    public List<Address> selectAddressByInt(String param, int value)  {  
        List<Address> addresses = new ArrayList<Address>();  
        
    	Session session = sessionFactory.openSession();
    	//Transaction tc = (Transaction) session.beginTransaction();  
        
        String hqlString = "From Address u where u."+ param + "='" + value +"'";
        List list = session.createQuery(hqlString).list();  
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
        	Address u = (Address) iterator.next();  
        	addresses.add(u);  
        }  
       
        session.close();  
        return addresses;  
    }  
    
}
