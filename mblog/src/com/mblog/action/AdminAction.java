package com.mblog.action;

import com.mblog.Do.AdminDAO;
import com.mblog.Do.impl.AdminDAOImpl;
import com.mblog.Po.Admin;
import com.mblog.Po.User;

public class AdminAction extends SuperAction{

	AdminDAO admindao=new AdminDAOImpl();
	
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	

	public String adminLogin() throws Exception{
		Admin admin1=admindao.adminLogin(admin);
		if (admin1 != null) {
			session.put("admin", admin1);
			return "success";
		}
		return "input";
		
		
	}
	
	public String logoutUser(){
		session.remove("admin");
		return SUCCESS;
		
	}
}
