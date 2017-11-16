package com.Retailer.action;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.apache.commons.validator.Msg;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.Retailer.model.Customer;
import com.Retailer.model.StoreLog;
import com.Retailer.service.LogService;
import com.Retailer.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.core.ReturnInstruction.Return;

@Action(value = "UserAction", results = {
		@Result(name = "index", location = "/index.jsp"),
		@Result(name = "customerMenu", location = "/customermenu.jsp"),
		
		//error information
		@Result(name = "loginFalse", location = "/loginerror.jsp")
		}
)
public class UserAction {
	
	@Resource
	UserService userService;
	@Resource
	LogService logService;
	//param
	Customer user;
	
	//LOGIN
	public String login(){
		System.out.println(user.getUsername());
		Customer customer = userService.GetCustomerByLogin(user.getUsername(), user.getPassword());
		if(customer != null){
			ServletActionContext.getRequest().getSession()
			.setAttribute("user", customer);
			return "menu";
		}
		else{
			return "loginFalse";
		}		
	}
	
	//REGISTER
	public String registerUser(){
		int flag = userService.RegisterUserAsCustomer(user);
		Customer customer = userService.GetCustomerByLogin(user.getUsername(), user.getPassword());
		if(flag == 0){
			ServletActionContext.getRequest().getSession()
			.setAttribute("user", customer);
			return "menu";
		}
		else{
			return "registerFalse";
		}
	}
	
	//CHECK LOG
	public String checkByUser(){
		List<StoreLog> list = logService.getStoreLogByUser(user.getId());
		ServletActionContext.getRequest().getSession()
		.setAttribute("list", list);
		return "userCheck";
	}
}
