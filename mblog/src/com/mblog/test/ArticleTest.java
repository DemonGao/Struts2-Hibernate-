package com.mblog.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.mblog.Do.ArticlescrapDAO;
import com.mblog.Do.impl.ArticlescrapDAOImpl;
import com.mblog.Po.Articlescrap;

public class ArticleTest {

	
	@Test
	public void del() throws Exception{
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session Ssession = sf.openSession();
		Ssession.beginTransaction();
		
		Articlescrap a=new Articlescrap();
		a.setAid(16);
		Ssession.delete(a);
		
		Ssession.getTransaction().commit();
		Ssession.close();
		sf.close();
	}
}
