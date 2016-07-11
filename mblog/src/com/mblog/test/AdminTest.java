package com.mblog.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.mblog.Do.AdminDAO;
import com.mblog.Do.impl.AdminDAOImpl;
import com.mblog.Po.Admin;

public class AdminTest {

	@Test
	public void adminlogin() throws Exception{
		AdminDAO admindao=new AdminDAOImpl();
		Admin a =new Admin();
		a.setPassword("1");
		a.setUsername("1");
		if(admindao.adminLogin(a)!=null){
			System.out.println("登陸成功!");
		}else{
			System.out.println("登陸失敗!");
		}
	}
//	@Test
	public void save(){
		Admin a =new Admin();
		a.setUsername("1");
		a.setPassword("1");
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
