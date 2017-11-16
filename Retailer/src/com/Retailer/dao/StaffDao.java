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

import com.Retailer.model.Staff;

@Repository("StaffDao")
public class StaffDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void addStaff(Staff Staff)  {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.save(Staff);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void delStaff(int StaffId) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        Staff u = new Staff();
        u.setId(StaffId);
        session.delete(u);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        session.close();  
    }  
  
    public void updateStaff(Staff Staff) {  
    	Session session = sessionFactory.openSession();
        Transaction tc = (Transaction) session.beginTransaction();  
        session.update(Staff);  
        try {  
            tc.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        session.close();  
          
    }
    
    public List<Staff> selectStaffByString(String param, String value)  {  
        List<Staff> Staffes = new ArrayList<Staff>();  
        
    	Session session = sessionFactory.openSession();

    	Transaction tc = (Transaction) session.beginTransaction();  
        //tc.begin();
        String hqlString = " From Staff u where u."+ param + "='" + value+"'";
        if(session.createQuery(hqlString) != null){
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	Staff u = (Staff) iterator.next();  
	        	Staffes.add(u);  
	        }  
	        tc.commit();
	        session.close();  
	        return Staffes;  
        }
        else 
        {
        	tc.commit();
        	return null;
        }

    }
    
    public List<Staff> selectStaffByInt(String param, int value)  {  
        List<Staff> Staffes = new ArrayList<Staff>();  
        
    	Session session = sessionFactory.openSession();
    	//Transaction tc = (Transaction) session.beginTransaction();  
        
        String hqlString = "From Staff u where u."+ param + "='" + value +"'";
        List list = session.createQuery(hqlString).list();  
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
        	Staff u = (Staff) iterator.next();  
        	Staffes.add(u);  
        }  
       
        session.close();  
        return Staffes;  
    }  
    
}
