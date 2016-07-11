package com.mblog.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.mblog.Do.ArticlescrapDAO;
import com.mblog.Do.BaseHibernateDAO;
import com.mblog.Do.impl.ArticlescrapDAOImpl;
import com.mblog.Po.Articlescrap;
import com.mblog.Po.User;

public class UserArticleTest extends BaseHibernateDAO {

//	@Test
	public void save(){
		Articlescrap a1=new Articlescrap();
		Articlescrap a2=new Articlescrap();
		Set<Articlescrap>set=new HashSet<Articlescrap>();
		a1.setTime("2016-06-16 23:01");
		a1.setTitle("六一");
		a1.setType("个人日志");
		a1.setText("高世超,男,一个90后程序员,从小学的时候,我就对计算机比较感兴趣,当时参加了学校组织的网页制作校本课程,那时候用的是dreamweaver,都是些托拉拽的操作,那时候还不知道js,只会从网站上赋值粘贴以下代码,然后鼠标后面有了小尾巴,页面上下起了雪花,各种特效...页面布局的时候,还是用table来规划布局,");
		a2.setTime("2016-06-16 23:03");
		a2.setTitle("五一");
		a2.setType("个人日志");
		a2.setText("通信时代，无论是初次相见还是老友重逢，交换联系方式，常常是彼此交换名片，然后郑重或是出于礼貌用手机记下对方的电话号码。在快节奏的生活里，我们不知不觉中就成为住在别人手机里的朋友。又因某些意外，变成了别人手机里匆忙的过客，这种快餐式的友谊 ...");
		set.add(a1);
		set.add(a2);
		
		
		
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		User user=(User)session.get(User.class, 2);
		a1.setUserinfo(user.getUserinfo());
		a2.setUserinfo(user.getUserinfo());
		a1.setUser(user);
		a2.setUser(user);
		user.setArticle(set);
		session.save(user);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public void select(){
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String queryString="select new User(u.username,u.password,ui,article) from User u,UserInfo ui,Articlescrap article where u.username='admin'";
		List list=session.createQuery(queryString).list();
		session.close();
		sf.close();
		for(int i=0;i<list.size();i++){
			User user=(User)list.get(i);
			System.out.println(user.getUsername());
			Set<Articlescrap>set=(HashSet<Articlescrap>)user.getArticle();
			for (Articlescrap a : set) {
			      System.out.println(a.getTitle());
			      System.out.println(a.getType());
			      System.out.println(a.getTime());
			}
		}
		
	}
//	@Test
	public void select1(){
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		User user=(User)session.get(User.class, 3);
		Set<Articlescrap>set =user.getArticle();
		for (Articlescrap a : set) {
		      System.out.println(a.getTitle());
		      System.out.println(a.getType());
		      System.out.println(a.getTime());
		}
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	
	public void query() throws Exception{
		User user=new User();
		Set<Articlescrap> article = new HashSet<Articlescrap>();
		Articlescrap articlescrap=new Articlescrap();
		String hql="from Articlescrap order by time desc";
		List list=findByHQL(hql);
		for(int i=0;i<list.size();i++){
			articlescrap=(Articlescrap)list.get(i);
			System.out.println(articlescrap.getAid());
			System.out.println(articlescrap.getTime());
			article.add(articlescrap);
		}
		Iterator it=article.iterator();
		while(it.hasNext()){
			Articlescrap a=(Articlescrap) it.next();
			System.out.println(a.getTime());
			System.out.println(a.getAid());
		}
//		for (Articlescrap a : article) {
//		      System.out.println(a.getTitle());
//		      System.out.println(a.getType());
//		      System.out.println(a.getTime());
//		      System.out.println(a.getUserinfo().getUiNickname());
//			System.out.println(a.getAid());
//		}
	}
	
	public void testt() throws Exception{
		String hql="from Articlescrap order by time desc";
		List list=findByHQL(hql,0,1);
		Articlescrap articlescrap=new Articlescrap();
		for(int i=0;i<list.size();i++){
			articlescrap=(Articlescrap)list.get(i);
			System.out.println(articlescrap.getAid());
			System.out.println(articlescrap.getTime());
//			article.add(articlescrap);
		}
	}
//	@Test
	public void gettime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	}
	@Test
	public void teee() throws Exception{
		int id=1;
		
		ArticlescrapDAO aDAO=new ArticlescrapDAOImpl();
		System.out.println(aDAO.getArticleNum("user_id", "1"));
	}
}
