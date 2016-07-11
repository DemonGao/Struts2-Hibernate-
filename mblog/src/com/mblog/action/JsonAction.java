package com.mblog.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.json.annotations.JSON;

import com.mblog.Po.User;

public class JsonAction extends SuperAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String,Object> dataMap;
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String json() {  
        // dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据  
        dataMap = new HashMap<String, Object>();  
//        User user1 = new User();  
//        user1.setUsername(user.getUsername());  
//        user1.setPassword(user.getPassword());  
//        dataMap.put("user", user1);  
        // 放入一个是否操作成功的标识  
        dataMap.put("success", true);  
        // 返回结果  
        return SUCCESS;  
    }
	
	public Map<String, Object> getDataMap() {  
        return dataMap;  
    }
}
