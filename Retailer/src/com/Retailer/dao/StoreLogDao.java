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

import com.Retailer.model.StoreLog;

@Repository("StoreLogDao")
public class StoreLogDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void addStoreLog(StoreLog StoreLog)  {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.save(StoreLog);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void delStoreLog(int StoreLogId) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        StoreLog u = new StoreLog();
        u.setId(StoreLogId);
        session.delete(u);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void updateStoreLog(StoreLog StoreLog) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.update(StoreLog);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        session.close();  
          
    }
    
    public List<StoreLog> selectBookByString(String param, String value)  {  
        List<StoreLog> StoreLogs = new ArrayList<StoreLog>();  
        
    	Session session = sessionFactory.openSession();

    	Transaction tc = (Transaction) session.beginTransaction();  
        //tc.begin();
        String hqlString = " From BooksModel u where u."+ param + "='" + value+"'";
        if(session.createQuery(hqlString) != null){
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	StoreLog u = (StoreLog) iterator.next();  
	        	StoreLogs.add(u);  
	        }  
	        tc.commit();
	        session.close();  
	        return StoreLogs;  
        }
        else 
        {
        	tc.commit();
        	return null;
        }

    }
    
    public List<StoreLog> selectBookByInt(String param, int value)  {  
        List<StoreLog> storeLogs = new ArrayList<StoreLog>();  
        
    	Session session = sessionFactory.openSession();
    	//Transaction tc = (Transaction) session.beginTransaction();  
        
        String hqlString = "From BooksModel u where u."+ param + "='" + value +"'";
        List list = session.createQuery(hqlString).list();  
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
        	StoreLog u = (StoreLog) iterator.next();  
        	storeLogs.add(u);  
        }  
       
        session.close();  
        return storeLogs;  
    }  
    
}
