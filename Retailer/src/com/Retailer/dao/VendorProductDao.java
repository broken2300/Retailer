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

import com.Retailer.model.VendorProduct;

@Repository("VendorProductDao")
public class VendorProductDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void addVendorProduct(VendorProduct VendorProduct)  {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.save(VendorProduct);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void delVendorProduct(int VendorProductId) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        VendorProduct u = new VendorProduct();
        u.setId(VendorProductId);
        session.delete(u);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void updateVendorProduct(VendorProduct VendorProduct) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.update(VendorProduct);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        session.close();  
          
    }
    
    public List<VendorProduct> selectVendorProductByString(String param, String value)  {  
        List<VendorProduct> VendorProducts = new ArrayList<VendorProduct>();  
        
    	Session session = sessionFactory.openSession();

    	Transaction tc = (Transaction) session.beginTransaction();  
        //tc.begin();
        String hqlString = " From VendorProduct u where u."+ param + "='" + value+"'";
        if(session.createQuery(hqlString) != null){
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	VendorProduct u = (VendorProduct) iterator.next();  
	        	VendorProducts.add(u);  
	        }  
	        tc.commit();
	        session.close();  
	        return VendorProducts;  
        }
        else 
        {
        	tc.commit();
        	return null;
        }

    }
    
    public List<VendorProduct> selectVendorProductByInt(String param, int value)  {  
        List<VendorProduct> VendorProducts = new ArrayList<VendorProduct>();  
        
    	Session session = sessionFactory.openSession();
    	//Transaction tc = (Transaction) session.beginTransaction();  
        
        String hqlString = "From VendorProduct u where u."+ param + "='" + value +"'";
        List list = session.createQuery(hqlString).list();  
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
        	VendorProduct u = (VendorProduct) iterator.next();  
        	VendorProducts.add(u);  
        }  
       
        session.close();  
        return VendorProducts;  
    }  
    
}
