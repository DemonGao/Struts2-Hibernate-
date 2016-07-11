package com.mblog.Po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.apache.struts2.json.annotations.JSON;


@Entity
public class UserInfo {

	private int user_id;
	private String uiNickname;
	private String uiBrithdate;
	private String uiBrithplace;
	private String uiEmail;
	private String uiTel;
	private String userImg;
	private User user;
	private Set<Articlescrap> article = new HashSet<Articlescrap>();
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUiNickname() {
		return uiNickname;
	}
	public void setUiNickname(String uiNickname) {
		this.uiNickname = uiNickname;
	}

	public String getUiBrithdate() {
		return uiBrithdate;
	}

	public void setUiBrithdate(String uiBrithdate) {
		this.uiBrithdate = uiBrithdate;
	}

	public String getUiBrithplace() {
		return uiBrithplace;
	}

	public void setUiBrithplace(String uiBrithplace) {
		this.uiBrithplace = uiBrithplace;
	}

	public String getUiEmail() {
		return uiEmail;
	}

	public void setUiEmail(String uiEmail) {
		this.uiEmail = uiEmail;
	}

	public String getUiTel() {
		return uiTel;
	}

	public void setUiTel(String uiTel) {
		this.uiTel = uiTel;
	}
	
	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	@JSON(serialize=false)
	@OneToOne(mappedBy = "userinfo")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@JSON(serialize=false)//此字段将不转换成Json
	@OneToMany(mappedBy="userinfo",cascade=CascadeType.ALL)
	public Set<Articlescrap> getArticle() {
		return article;
	}
	public void setArticle(Set<Articlescrap> article) {
		this.article = article;
	}
}
