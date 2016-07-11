package com.mblog.action.Articlescrap;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.mblog.Do.ArticlescrapDAO;
import com.mblog.Do.UserDAO;
import com.mblog.Do.impl.ArticlescrapDAOImpl;
import com.mblog.Do.impl.UserDAOImpl;
import com.mblog.Po.Articlescrap;
import com.mblog.Po.User;
import com.mblog.Util.uploadzp;
import com.mblog.action.SuperAction;

public class ArticleAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UserDAO userDao=new UserDAOImpl();
	ArticlescrapDAO articleDAO=new ArticlescrapDAOImpl();
	private Articlescrap articlescrap;

	private String userid;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Articlescrap getArticlescrap() {
		return articlescrap;
	}

	public void setArticlescrap(Articlescrap articlescrap) {
		this.articlescrap = articlescrap;
	}
	
	public String addArticlescrap() throws Exception{
		int user_id=Integer.parseInt(userid);
		User user=userDao.findById(user_id);
		Set<Articlescrap>set=new HashSet<Articlescrap>();
		Articlescrap articlescrap_add=new Articlescrap();
		String filename="";
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
		articlescrap_add.setTime(df.format(new Date()));
		articlescrap_add.setImg(filename);
		
		articlescrap_add.setType(articlescrap.getType());
		articlescrap_add.setText(articlescrap.getText());
		articlescrap_add.setAtype(articlescrap.getAtype());
		articlescrap_add.setUser(user);
		articlescrap_add.setUserinfo(user.getUserinfo());
		set.add(articlescrap_add);
		user.setArticle(set);
		if(articleDAO.addArticle(user)){
			return SUCCESS;
		}else{
			return "input";
		}
	}
	
	
	public String del() throws Exception{
		int aid=Integer.parseInt(request.getParameter("aid").toString());
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session Ssession = sf.openSession();
		Ssession.beginTransaction();
		Articlescrap a=new Articlescrap();
		a.setAid(aid);
		Ssession.delete(a);
		Ssession.getTransaction().commit();
		Ssession.close();
		sf.close();
		return SUCCESS;
	}
}
