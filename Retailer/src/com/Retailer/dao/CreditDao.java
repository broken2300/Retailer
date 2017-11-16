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

import com.Retailer.model.Credit;

@Repository("CreditDao")
public class CreditDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void addCredit(Credit Credit)  {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.save(Credit);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void delCredit(int CreditId) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        Credit u = new Credit();
        u.setId(CreditId);
        session.delete(u);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void updateCredit(Credit Credit) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.update(Credit);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        session.close();  
          
    }
    
    public List<Credit> selectCreditByString(String param, String value)  {  
        List<Credit> Credits = new ArrayList<Credit>();  
        
    	Session session = sessionFactory.openSession();

    	Transaction tc = (Transaction) session.beginTransaction();  
        //tc.begin();
        String hqlString = " From Credit u where u."+ param + "='" + value+"'";
        if(session.createQuery(hqlString) != null){
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	Credit u = (Credit) iterator.next();  
	        	Credits.add(u);  
	        }  
	        tc.commit();
	        session.close();  
	        return Credits;  
        }
        else 
        {
        	tc.commit();
        	return null;
        }

    }
    
    public List<Credit> selectCreditByInt(String param, int value)  {  
        List<Credit> credits = new ArrayList<Credit>();  
        
    	Session session = sessionFactory.openSession();
    	//Transaction tc = (Transaction) session.beginTransaction();  
        
        String hqlString = "From Credit u where u."+ param + "='" + value +"'";
        List list = session.createQuery(hqlString).list();  
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
        	Credit u = (Credit) iterator.next();  
        	credits.add(u);  
        }  
       
        session.close();  
        return credits;  
    }  
    
}
