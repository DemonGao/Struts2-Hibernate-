package com.mblog.action;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;





import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.mblog.Do.UserDAO;
import com.mblog.Do.impl.UserDAOImpl;
import com.mblog.Po.Articlescrap;
import com.mblog.Po.User;
import com.mblog.Po.UserInfo;
import com.mblog.Util.uploadzp;
import com.mblog.hibernate.HibernateSessionFactory;

public class UserAction extends SuperAction {

	private User user;
	private UserInfo userinfo;
	UserDAO udao = new UserDAOImpl();

	private File upload;
	private String uploadFileName;
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	//用户登录
	public String login() throws Exception {
		User user1=udao.usersLogin(user);
		if (user1 != null) {
			session.put("user", user1);
			return "success";
		}
		return "input";
	}

	// 用户注册
	public String register() {
		String filename=(int)(Math.random()*1000)+this.getUploadFileName();
		String path=ServletActionContext.getServletContext().getRealPath("/upload/userInfo");
		path=path+"\\"+filename;
		System.out.println(path);
		new uploadzp().upload(this.getUpload(), path);
		
		User user_add = new User();
		UserInfo userinfo_add = new UserInfo();
		user_add.setUsername(user.getUsername());
		user_add.setPassword(user.getPassword());
		userinfo_add.setUiNickname(userinfo.getUiNickname());
		userinfo_add.setUiBrithdate(userinfo.getUiBrithdate());
		userinfo_add.setUiBrithplace(userinfo.getUiBrithplace());
		userinfo_add.setUiEmail(userinfo.getUiEmail());
		userinfo_add.setUiTel(userinfo.getUiTel());
		
		userinfo_add.setUserImg(filename);
		
		userinfo_add.setUser(user_add);
		user_add.setUserinfo(userinfo_add);
		if (udao.register(user_add)) {
			session.put("user", user_add);
			return "success";
		}
		return "input";
	}
	
	public String logoutUser(){
		session.remove("user");
		return SUCCESS;
	}
	
	public String delUser() throws Exception{
		int user_id=Integer.parseInt(request.getParameter("user_id").toString());
		User user=udao.findById(user_id);
		if(user!=null&&udao.delUser(user)){
			return SUCCESS;
		}
		return "input";
	}
	
	public String queryUser() throws Exception{
		
		List list=udao.queryUser();
		if(list.isEmpty()){
			return "input";
		}
		session.put("userList", list);
		return SUCCESS;
	}
	
	
	public String update() throws Exception{
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session Ssession = sf.openSession();
		Ssession.beginTransaction();
		User u=new User();
		
		
		u.setUser_id(user.getUser_id());
		u.setPassword(user.getPassword());
		u.setUsername(user.getUsername());
		Ssession.update(u);;
		Ssession.getTransaction().commit();
		Ssession.close();
		sf.close();
		return SUCCESS;
	}
}
