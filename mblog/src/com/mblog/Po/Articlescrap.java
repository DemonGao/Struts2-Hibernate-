package com.mblog.Po;

import javax.persistence.*;

import org.apache.struts2.json.annotations.JSON;

@Entity
public class Articlescrap {

	private int aid; 			//文章id
	private int atype;			//0:说说 1:日志
	private String title;		//文章标题
	private String type;		//文章类型
	private String time;		//发表时间
	private String text;		//文章内容
	private String img;			//照片路径
	private User user;			//用户表关联
	
	
	private UserInfo userinfo;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="aid",length=11,unique=true)
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	@Column(length=30)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column(length=1)
	public int getAtype() {
		return atype;
	}
	public void setAtype(int atype) {
		this.atype = atype;
	}
	@Column(length=20)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
//	@Temporal(TemporalType.TIMESTAMP)  时间注解
//	@Transient 透明的 不创建到表中
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Column(length=2000)
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	@JSON(serialize=false)//此字段将不转换成Json
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")//设置外键字段为user_id
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userinfo_id")//设置外键字段为user_id
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
}
