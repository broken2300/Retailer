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

import com.Retailer.model.Vendor;

@Repository("VendorDao")
public class VendorDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void addVendor(Vendor Vendor)  {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.save(Vendor);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void delVendor(int VendorId) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        Vendor u = new Vendor();
        u.setId(VendorId);
        session.delete(u);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void updateVendor(Vendor Vendor) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.update(Vendor);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        session.close();  
          
    }
    
    public List<Vendor> selectVendorByString(String param, String value)  {  
        List<Vendor> Vendors = new ArrayList<Vendor>();  
        
    	Session session = sessionFactory.openSession();

    	Transaction tc = (Transaction) session.beginTransaction();  
        //tc.begin();
        String hqlString = " From Vendor u where u."+ param + "='" + value+"'";
        if(session.createQuery(hqlString) != null){
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	Vendor u = (Vendor) iterator.next();  
	        	Vendors.add(u);  
	        }  
	        tc.commit();
	        session.close();  
	        return Vendors;  
        }
        else 
        {
        	tc.commit();
        	return null;
        }

    }
    
    public List<Vendor> selectVendorByInt(String param, int value)  {  
        List<Vendor> Vendors = new ArrayList<Vendor>();  
        
    	Session session = sessionFactory.openSession();
    	//Transaction tc = (Transaction) session.beginTransaction();  
        
        String hqlString = "From Vendor u where u."+ param + "='" + value +"'";
        List list = session.createQuery(hqlString).list();  
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
        	Vendor u = (Vendor) iterator.next();  
        	Vendors.add(u);  
        }  
       
        session.close();  
        return Vendors;  
    }  
    
}
