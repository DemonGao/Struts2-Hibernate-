package com.mblog.action.Articlescrap;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.mblog.Do.ArticlescrapDAO;
import com.mblog.Do.UserDAO;
import com.mblog.Do.impl.ArticlescrapDAOImpl;
import com.mblog.Do.impl.UserDAOImpl;
import com.mblog.Po.Articlescrap;
import com.mblog.Po.User;
import com.mblog.Util.uploadzp;
import com.mblog.action.SuperAction;

public class ArticlescrapAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UserDAO userDao = new UserDAOImpl();
	ArticlescrapDAO articleDAO = new ArticlescrapDAOImpl();
	private Articlescrap articlescrap;
	private File upload;
	private String uploadFileName;
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

//	public String addArticlescrap() throws Exception {
//		int user_id = Integer.parseInt(userid);
//		User user = userDao.findById(user_id);
//		Set<Articlescrap> set = new HashSet<Articlescrap>();
//		Articlescrap articlescrap_add = new Articlescrap();
//		String filename = "";
//
//		filename = (int) (Math.random() * 1000) + this.getUploadFileName();
//		String path = ServletActionContext.getServletContext().getRealPath(
//				"/upload");
//		path = path + "\\" + filename;
//		System.out.println(path);
//
//		System.out.println("---------------------------------------------"
//				+ user.getUser_id());
//		new uploadzp().upload(this.getUpload(), path);
//
//		articlescrap_add.setTitle(articlescrap.getTitle());
//
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
//		articlescrap_add.setTime(df.format(new Date()));
//		articlescrap_add.setImg(filename);
//
//		articlescrap_add.setType(articlescrap.getType());
//		articlescrap_add.setText(articlescrap.getText());
//		articlescrap_add.setAtype(articlescrap.getAtype());
//		articlescrap_add.setUser(user);
//		articlescrap_add.setUserinfo(user.getUserinfo());
//		set.add(articlescrap_add);
//		user.setArticle(set);
//		if (articleDAO.addArticle(user)) {
//			return SUCCESS;
//		} else {
//			return "input";
//		}
//	}

	public String addArticlescrap() throws Exception {
		int user_id = Integer.parseInt(userid);
		User user = userDao.findById(user_id);
		Set<Articlescrap> set = new HashSet<Articlescrap>();
		Articlescrap articlescrap_add = new Articlescrap();
		String filename = (int) (Math.random() * 1000)
				+ this.getUploadFileName();
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		path = path + "\\" + filename;
		System.out.println(path);

		System.out.println("---------------------------------------------"
				+ user.getUser_id());
		new uploadzp().upload(this.getUpload(), path);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
		articlescrap_add.setTime(df.format(new Date()));
		articlescrap_add.setImg(filename);
		articlescrap_add.setTitle(articlescrap.getTitle());
		articlescrap_add.setType(articlescrap.getType());
		articlescrap_add.setText(articlescrap.getText());
		articlescrap_add.setAtype(articlescrap.getAtype());
		articlescrap_add.setUser(user);
		articlescrap_add.setUserinfo(user.getUserinfo());
		set.add(articlescrap_add);
		user.setArticle(set);
		if (articleDAO.addArticle(user)) {
			return SUCCESS;
		} else {
			return "input";
		}
	}
}
