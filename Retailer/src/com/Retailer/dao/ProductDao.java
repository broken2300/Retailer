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

import com.Retailer.model.Product;

@Repository("ProductDao")
public class ProductDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void addProduct(Product Product)  {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.save(Product);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void delProduct(int ProductId) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        Product u = new Product();
        u.setId(ProductId);
        session.delete(u);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void updateProduct(Product Product) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.update(Product);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        session.close();  
          
    }
    
    public List<Product> selectBookByString(String param, String value)  {  
        List<Product> Products = new ArrayList<Product>();  
        
    	Session session = sessionFactory.openSession();

    	Transaction tc = (Transaction) session.beginTransaction();  
        //tc.begin();
        String hqlString = " From BooksModel u where u."+ param + "='" + value+"'";
        if(session.createQuery(hqlString) != null){
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	Product u = (Product) iterator.next();  
	        	Products.add(u);  
	        }  
	        tc.commit();
	        session.close();  
	        return Products;  
        }
        else 
        {
        	tc.commit();
        	return null;
        }

    }
 
    public List<Product> selectBookByInt(String param, int value)  {  
        List<Product> products = new ArrayList<Product>();  
        
    	Session session = sessionFactory.openSession();
    	//Transaction tc = (Transaction) session.beginTransaction();  
        
        String hqlString = "From BooksModel u where u."+ param + "='" + value +"'";
        List list = session.createQuery(hqlString).list();  
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
        	Product u = (Product) iterator.next();  
        	products.add(u);  
        }  
       
        session.close();  
        return products;  
    }  
}
