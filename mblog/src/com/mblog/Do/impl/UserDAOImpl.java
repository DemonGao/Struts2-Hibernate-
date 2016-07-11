package com.mblog.Do.impl;

import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mblog.Do.BaseHibernateDAO;
import com.mblog.Do.UserDAO;
import com.mblog.Po.User;
import com.mblog.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;

public class UserDAOImpl extends BaseHibernateDAO implements UserDAO {

	private Session session;
	private Transaction transaction;
	private Query query;

	@Override
	public User usersLogin(User u) throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> sessionMap = actionContext.getSession();
		String hql = "from User where username='" + u.getUsername() + "'";
		List list = findByHQL(hql);
		if (!list.isEmpty()) {
			User user = (User) list.get(0);
			if (user.getPassword().equals(u.getPassword())) {
				if (sessionMap.get("login_msg") != null) {
					sessionMap.remove("login_msg");
				}
				return user;
			} else {
				sessionMap.put("login_msg", "密码错误!");
				return null;
			}
		}
		sessionMap.put("login_msg", "用户名不存在!");
		return null;
		// String
		// hql="select new User(u.user_id,u.username,u.password,ui) from User u,UserInfo ui where u.username='"+u.getUsername()+"'";
		// List list=findByHQL(hql);
		// if(!list.isEmpty()) {
		// for(int i=0;i<list.size();i++){
		// User user=(User)list.get(i);
		// if(user.getPassword().equals(u.getPassword())){
		// System.out.println("userinfo"+user.getUserinfo());
		// if(sessionMap.get("login_msg")!=null){
		// sessionMap.remove("login_msg");
		// }
		// return user;
		// }else{
		// sessionMap.put("login_msg", "密码错误!");
		// return null;
		// }
		// }
		// }
	}

	// 用户注册方法
	@Override
	public boolean register(User u) {
		// TODO Auto-generated method stub
		try {
			session = getSession();
			transaction = session.beginTransaction();
			String queryString = "select count(*) from User where username='"
					+ u.getUsername() + "'";
			query = session.createQuery(queryString);
			Long ishas = (Long) query.uniqueResult();
			if (ishas > 0) {
				return false;
			}
			session.save(u);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean logoutUser() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public User findById(int id) throws Exception {
		// TODO Auto-generated method stub
		User user = (User) findById(User.class, id);
		return user;
	}

	@Override
	public boolean delUser(User u) throws Exception {
		// TODO Auto-generated method stub
		delete(u);
		return true;
	}

	@Override
	public List queryUser() throws Exception {
		// TODO Auto-generated method stub

		 List list=findByHQL("from User");
		
		 return list;

		// TODO Auto-generated method stub
//		try {
//			session = getSession();
//			transaction = session.beginTransaction();
//			String queryString = "from User";
//			query = session.createQuery(queryString);
//			List list = query.list();
//			transaction.commit();
//			HibernateSessionFactory.closeSession();
//			return list;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return null;
//		}

	}

}
