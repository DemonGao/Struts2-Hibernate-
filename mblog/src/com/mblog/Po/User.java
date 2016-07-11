package com.mblog.Po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.apache.struts2.json.annotations.JSON;


@Entity
public class User {
	private int user_id;
	private String username;
	private String password;
	private UserInfo userinfo;//关联联系
	private Set<Articlescrap> article = new HashSet<Articlescrap>();
	
	public User(){}
	public User(String username, String password/*, UserInfo userinfo*/) {
		this.username = username;
		this.password = password;
//		this.userinfo = userinfo;
	}
	
	
	
	public User(int user_id, String username, String password, UserInfo userinfo) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.userinfo = userinfo;
	}
	public User(String username, String password, UserInfo userinfo,
			Set<Articlescrap> article) {
		this.username = username;
		this.password = password;
		this.userinfo = userinfo;
		this.article = article;
	}
	@JSON(serialize=false)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)   //@GeneratedValue  一样
	@Column(name="user_id",length=11,unique=true)
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Column(name="username",length=20)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@JSON(serialize=false)
	@Column(name="password",length=20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
//	@OneToMany(mapped=“由One的一方指向Many的一方，并且，这个属性应该等于Many的一方中含有One类的属性的属性名，否则会出错啦 ”)
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	@OrderBy("time desc")//set排序注解  time  Articlescrap表中的属性
	public Set<Articlescrap> getArticle() {
		return article;
	}
	public void setArticle(Set<Articlescrap> article) {
		this.article = article;
	}
	
}
