package com.Retailer.service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Retailer.dao.StoreLogDao;
import com.Retailer.model.StoreLog;

@Service
@Transactional
public class LogService {
	
	@Resource
	StoreLogDao storeLogDao;
	
	//BY CUSTOMER
	public List<StoreLog> getStoreLogByUser(int userid){
		return storeLogDao.selectStoreLogByInt("customer", userid);
	}
	
	//BY STAFF
	public List<StoreLog> getStoreLogByStore(int storeid){
		return storeLogDao.selectStoreLogByInt("store", storeid);
	}
	

}
