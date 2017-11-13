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

import com.Retailer.model.Brand;

@Repository("BrandDao")
public class BrandDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void addBrand(Brand Brand)  {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.save(Brand);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void delBrand(int BrandId) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        Brand u = new Brand();
        u.setId(BrandId);
        session.delete(u);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void updateBrand(Brand Brand) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.update(Brand);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        session.close();  
          
    }
    
    public List<Brand> selectBookByString(String param, String value)  {  
        List<Brand> Brands = new ArrayList<Brand>();  
        
    	Session session = sessionFactory.openSession();

    	Transaction tc = (Transaction) session.beginTransaction();  
        //tc.begin();
        String hqlString = " From BooksModel u where u."+ param + "='" + value+"'";
        if(session.createQuery(hqlString) != null){
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	Brand u = (Brand) iterator.next();  
	        	Brands.add(u);  
	        }  
	        tc.commit();
	        session.close();  
	        return Brands;  
        }
        else 
        {
        	tc.commit();
        	return null;
        }

    }
    
    public List<Brand> selectBookByInt(String param, int value)  {  
        List<Brand> brands = new ArrayList<Brand>();  
        
    	Session session = sessionFactory.openSession();
    	//Transaction tc = (Transaction) session.beginTransaction();  
        
        String hqlString = "From BooksModel u where u."+ param + "='" + value +"'";
        List list = session.createQuery(hqlString).list();  
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
        	Brand u = (Brand) iterator.next();  
        	brands.add(u);  
        }  
       
        session.close();  
        return brands;  
    }  
    
}
