package com.mblog.Do.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mblog.Do.AdminDAO;
import com.mblog.Do.BaseHibernateDAO;
import com.mblog.Po.Admin;
import com.opensymphony.xwork2.ActionContext;

public class AdminDAOImpl extends BaseHibernateDAO implements AdminDAO {

	private Session session;
	private Transaction transaction;
	private Query query;

	@Override
	public Admin adminLogin(Admin a) throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> sessionMap = actionContext.getSession();
		String hql = "from Admin where username='" + a.getUsername() + "'";
		List list = findByHQL(hql);
		if (!list.isEmpty()) {
			Admin admin = (Admin) list.get(0);
			if (admin.getPassword().equals(a.getPassword())) {
				if (sessionMap.get("login_msg") != null) {
					sessionMap.remove("login_msg");
				}
				return admin;
			} else {
				sessionMap.put("login_msg", "密码错误!");
				return null;
			}
		}
		sessionMap.put("login_msg", "用户名不存在!");
		return null;
	}
}
