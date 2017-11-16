package com.Retailer.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Retailer.dao.AddressDao;
import com.Retailer.dao.CreditDao;
import com.Retailer.dao.CustomerDao;
import com.Retailer.dao.ProductDao;
import com.Retailer.dao.StaffDao;
import com.Retailer.dao.StoreDao;
import com.Retailer.dao.StoreLogDao;
import com.Retailer.model.Address;
import com.Retailer.model.Credit;
import com.Retailer.model.Customer;
import com.Retailer.model.Product;
import com.Retailer.model.Staff;
import com.Retailer.model.Store;
import com.Retailer.model.StoreLog;


@Service
@Transactional
public class UserService {

	@Resource
	CustomerDao customerDao;
	@Resource
	ProductDao productDao;
	@Resource
	StoreDao storeDao;
	@Resource
	StoreLogDao storeLogDao;
	@Resource
	AddressDao addressDao;
	@Resource
	CreditDao creditDao;
	@Resource
	StaffDao staffDao;
	
	
	/*
	 *	return value
	 *	0 :		normal
	 *	-1 :	model exists
	 * 
	 */
	
	/*USER*/
		//STAFF REGISTER
	public int RegisterUserAsStaff(Staff staff){
		try {
			if(staffDao.selectStaffByString("username", staff.getUsername()).isEmpty()){
				staffDao.addStaff(staff);
			}
			else{
				//staff exists
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
		//CUSTOMER REGISTER
	public int RegisterUserAsCustomer(Customer customer){
		try {
			if(customerDao.selectCustomerByString("username", customer.getUsername()).isEmpty()){
				customerDao.addCustomer(customer);				
			}
			else{
				//customer exists
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
		//CUTOMER CHECK
	public Customer GetCustomerByLogin(String username, String password){
		try {
			Customer customer = customerDao.selectCustomerByString("username", username).get(0);
			if(password.equals(customer.getPassword())){
				return customer;
			}
			else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	// CUTOMER CHECK
	public Staff GetStaffByLogin(String username, String password) {
		try {
			Staff staff = staffDao.selectStaffByString("username", username)
					.get(0);
			if (password.equals(staff.getPassword())) {
				return staff;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		//CUSTOMER UPDATE
	public int UpdateCostmer(Customer customer){
		try {
			customerDao.updateCustomer(customer);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
		//CHECK LOG
	public List<StoreLog> CheckRecordByCustomer(Customer cutomer){
		try{
			int cid = cutomer.getId();
			List<StoreLog> storeLogs= storeLogDao.selectStoreLogByInt("cutomer", cid);
			return storeLogs;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		//CHECK LOG BY STORE
	public List<StoreLog> CheckRecordByCustomerAndStore(Customer cutomer,Store store){
		try{
			List<StoreLog> storeLogs= storeLogDao.selectStoreLogByDoubleInt("cutomer", cutomer.getId(), "store", store.getId());
			return storeLogs;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
		

	/*ADDRESS*/
		//ADD
	public int AddAddress(Customer customer, Address address){
		try {
			address.setUid(customer.getId());
			addressDao.addAddress(address);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;		
	}
		//MMODIFY
	public int UpdateAddress(Address address){
		try {
			addressDao.updateAddress(address);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	

	/*CREDIT*/
		//ADD
	public int AddCredit(Customer customer, Credit credit) {
		try {
			credit.setUid(customer.getId());
			creditDao.addCredit(credit);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

		// MODIFY
	public int UpdateCredit(Credit credit) {
		try {
			creditDao.updateCredit(credit);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
}
