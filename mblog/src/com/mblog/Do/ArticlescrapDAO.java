package com.mblog.Do;

import java.util.List;
import java.util.Set;

import com.mblog.Po.Articlescrap;
import com.mblog.Po.User;

public interface ArticlescrapDAO {

	/**
	 * 发表文章
	 * @return
	 * @throws Exception
	 */
	public boolean addArticle(User u) throws Exception;
	
	/**
	 * 查询所有的Article
	 * 
	 */
	public List<Articlescrap> queryArticle() throws Exception;
	
	/**
	 * 分页查询Article
	 * 
	 */
	public List<Articlescrap> queryArticle(int index,int num) throws Exception;
	
	/**
	 * 根据用(user-id) 分页查询Article
	 * 
	 */
	public List<Articlescrap> queryArticle(int id,int index,int num) throws Exception;
	
	/**
	 * 获取数据库中文章总数
	 * @return (int)数据库总数
	 * @throws Exception
	 */
	public int getArticleNum() throws Exception;
	
	/***
	 * 
	 */
	public int getArticleNum(String arg,String arg1) throws Exception;
	
}
