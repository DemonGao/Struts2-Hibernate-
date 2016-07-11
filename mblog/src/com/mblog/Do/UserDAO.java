package com.mblog.Do;

import java.util.List;

import com.mblog.Po.User;

public interface UserDAO{

	//用户登录方法
	public User usersLogin(User u) throws Exception;
	//用户注册方法
	public boolean register(User u);
	
	/**
	 * 注销用户
	 */
	public boolean logoutUser();
	
	/**
	 * 根据id查询用户
	 * @throws Exception 
	 */
	public User findById(int id) throws Exception;
	
	/***
	 * 删除用户
	 */
	public boolean delUser(User u) throws Exception;
	
	/***
	 *查询所有用户 
	 * 
	 */
	public List queryUser() throws Exception;
}
