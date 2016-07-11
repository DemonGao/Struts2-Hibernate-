package com.mblog.Do.impl;


import java.util.List;

import com.mblog.Do.ArticlescrapDAO;
import com.mblog.Do.BaseHibernateDAO;
import com.mblog.Po.Articlescrap;
import com.mblog.Po.User;


public class ArticlescrapDAOImpl extends BaseHibernateDAO implements ArticlescrapDAO{

	@Override
	public boolean addArticle(User u) throws Exception {
		// TODO Auto-generated method stub
		add(u);
		//getSession().beginTransaction().commit();
		return true;
	}

	@Override
	public List<Articlescrap> queryArticle(int id,int index,int num) throws Exception {
		// TODO Auto-generated method stub
		String hql="from Articlescrap where user_id='"+id+"' order by time desc";
		List<Articlescrap> list=(List<Articlescrap>) findByHQL(hql,index,num);
		return list;
	}

	@Override
	public List<Articlescrap> queryArticle() throws Exception {
		// TODO Auto-generated method stub
		String hql="from Articlescrap order by time desc";
		@SuppressWarnings("unchecked")
		List<Articlescrap> list=(List<Articlescrap>) findByHQL(hql);
		return list;
	}

	@Override
	public List<Articlescrap> queryArticle(int index, int num) throws Exception {
		// TODO Auto-generated method stub
		String hql="from Articlescrap order by time desc";
		@SuppressWarnings("unchecked")
		List<Articlescrap> list=(List<Articlescrap>) findByHQL(hql,index,num);
		return list;
	}

	@Override
	public int getArticleNum() throws Exception {
		// TODO Auto-generated method stub
		String hql="from Articlescrap";
		return findByHQL(hql).size();
	}

	@Override
	public int getArticleNum(String arg, String arg1) throws Exception {
		// TODO Auto-generated method stub
		//String hql="from Articlescrap where '"+arg+"'='"+arg1+"'";
		String hql="from Articlescrap where "+arg+"='"+arg1+"'";
		return findByHQL(hql).size();
	}

	
}
