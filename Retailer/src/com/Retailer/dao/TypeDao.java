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

import com.Retailer.model.Type;

@Repository("TypeDao")
public class TypeDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void addType(Type Type)  {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.save(Type);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void delType(int TypeId) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        Type u = new Type();
        u.setId(TypeId);
        session.delete(u);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void updateType(Type Type) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.update(Type);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        session.close();  
          
    }
    
    public List<Type> selectBookByString(String param, String value)  {  
        List<Type> Types = new ArrayList<Type>();  
        
    	Session session = sessionFactory.openSession();

    	Transaction tc = (Transaction) session.beginTransaction();  
        //tc.begin();
        String hqlString = " From BooksModel u where u."+ param + "='" + value+"'";
        if(session.createQuery(hqlString) != null){
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	Type u = (Type) iterator.next();  
	        	Types.add(u);  
	        }  
	        tc.commit();
	        session.close();  
	        return Types;  
        }
        else 
        {
        	tc.commit();
        	return null;
        }

    }
    
    public List<Type> selectBookByInt(String param, int value)  {  
        List<Type> Types = new ArrayList<Type>();  
        
    	Session session = sessionFactory.openSession();
    	//Transaction tc = (Transaction) session.beginTransaction();  
        
        String hqlString = "From BooksModel u where u."+ param + "='" + value +"'";
        List list = session.createQuery(hqlString).list();  
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
        	Type u = (Type) iterator.next();  
        	Types.add(u);  
        }  
       
        session.close();  
        return Types;  
    }  
    
}
