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

import com.Retailer.model.Customer;

@Repository("CustomerDao")
public class CustomerDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void addCustomer(Customer Customer)  {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.save(Customer);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void delCustomer(int CustomerId) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        Customer u = new Customer();
        u.setId(CustomerId);
        session.delete(u);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void updateCustomer(Customer Customer) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.update(Customer);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        session.close();  
          
    }
    
    public List<Customer> selectBookByString(String param, String value)  {  
        List<Customer> Customers = new ArrayList<Customer>();  
        
    	Session session = sessionFactory.openSession();

    	Transaction tc = (Transaction) session.beginTransaction();  
        //tc.begin();
        String hqlString = " From BooksModel u where u."+ param + "='" + value+"'";
        if(session.createQuery(hqlString) != null){
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	Customer u = (Customer) iterator.next();  
	        	Customers.add(u);  
	        }  
	        tc.commit();
	        session.close();  
	        return Customers;  
        }
        else 
        {
        	tc.commit();
        	return null;
        }

    }
    
    public List<Customer> selectBookByInt(String param, int value)  {  
        List<Customer> customers = new ArrayList<Customer>();  
        
    	Session session = sessionFactory.openSession();
    	//Transaction tc = (Transaction) session.beginTransaction();  
        
        String hqlString = "From BooksModel u where u."+ param + "='" + value +"'";
        List list = session.createQuery(hqlString).list();  
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
        	Customer u = (Customer) iterator.next();  
        	customers.add(u);  
        }  
       
        session.close();  
        return customers;  
    }  
}
