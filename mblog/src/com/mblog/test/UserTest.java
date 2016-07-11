package com.mblog.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.mblog.Do.BaseHibernateDAO;
import com.mblog.Po.User;
import com.mblog.Po.UserInfo;
import com.mblog.action.SuperAction;

public class UserTest extends BaseHibernateDAO{
//	@Test
	public void saveusertest(){
		User user=new User();
		UserInfo userinfo=new UserInfo();
		user.setUsername("gaoshichao1");
		user.setPassword("123456");
		userinfo.setUiNickname("高世超");
		userinfo.setUiBrithplace("1994-10-24");
		userinfo.setUiBrithdate("济南");
		userinfo.setUiEmail("750229099@qq.com");
		userinfo.setUiTel("17853593651");
		userinfo.setUser(user);
		user.setUserinfo(userinfo);
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public void del(){
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		User user=(User)session.get("com.mblog.Po.User", 1);
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
//	@Test
	public void select() throws Exception{
//		String hql="select new User(u.username,u.password,ui) from User u,UserInfo ui where u.username='shichaohhh'";
		String hql="from User where username='shichaohhh'";
		List list=findByHQL(hql);
		System.out.println(list.size());
		User user=(User) list.get(0);
		System.out.println(user.getUserinfo().getUiNickname());
		
//		if(!list.isEmpty()) {  
//			for(int i=0;i<list.size();i++){
//				User user=(User)list.get(i);
//				if(user.getPassword().equals("3216898")){
//					System.out.println("userinfo"+user.getUserinfo().getUiNickname());
//				}else{
//					
//				}
//			}
//        }

		
	}
	
	@Test
	public void UPDATE(){
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session Ssession = sf.openSession();
		Ssession.beginTransaction();
		User u=new User();
		
		
		u.setUser_id(4);
		u.setPassword("1234");
		u.setUsername("shichao");
		Ssession.update(u);;
		Ssession.getTransaction().commit();
		Ssession.close();
		sf.close();
	}
}
