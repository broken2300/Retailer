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

import com.Retailer.model.VendorLog;

@Repository("VendorLogDao")
public class VendorLogDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void addVendorLog(VendorLog VendorLog)  {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.save(VendorLog);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void delVendorLog(int VendorLogId) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        VendorLog u = new VendorLog();
        u.setId(VendorLogId);
        session.delete(u);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void updateVendorLog(VendorLog VendorLog) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.update(VendorLog);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        session.close();  
          
    }
    
    public List<VendorLog> selectVendorLogByString(String param, String value)  {  
        List<VendorLog> VendorLogs = new ArrayList<VendorLog>();  
        
    	Session session = sessionFactory.openSession();

    	Transaction tc = (Transaction) session.beginTransaction();  
        //tc.begin();
        String hqlString = " From VendorLog u where u."+ param + "='" + value+"'";
        if(session.createQuery(hqlString) != null){
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	VendorLog u = (VendorLog) iterator.next();  
	        	VendorLogs.add(u);  
	        }  
	        tc.commit();
	        session.close();  
	        return VendorLogs;  
        }
        else 
        {
        	tc.commit();
        	return null;
        }

    }
    
    public List<VendorLog> selectVendorLogByInt(String param, int value)  {  
        List<VendorLog> VendorLogs = new ArrayList<VendorLog>();  
        
    	Session session = sessionFactory.openSession();
    	//Transaction tc = (Transaction) session.beginTransaction();  
        
        String hqlString = "From VendorLog u where u."+ param + "='" + value +"'";
        List list = session.createQuery(hqlString).list();  
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
        	VendorLog u = (VendorLog) iterator.next();  
        	VendorLogs.add(u);  
        }  
       
        session.close();  
        return VendorLogs;  
    }  
    
}
