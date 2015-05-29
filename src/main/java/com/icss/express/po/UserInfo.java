package com.icss.express.po;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 用户基本信息
 * @author J.L.Zhou
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="user_info")
public class UserInfo implements Serializable {
	
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Id
	@Column(name="user_id",nullable=false,unique=true)
	private Integer userId;
	@Column(name="user_name",nullable=false,unique=true,length=20)
	private String userName;
	@Column(name="user_pwd",length=32)
	private String userPwd;
	@Column(name="user_real_name",length=16)
	private String userRealName;
	@Column(name="user_sex")
	private Boolean userSex;
	@Column(name="user_tel",length=32)
	private String userTel;
	@Column(name="create_time")
	private Date createTime;
	@Column(name="is_pass")
	private Boolean isPass=false;
	@Column(name="is_delete")
	private Boolean isDelete=false;
	
	/**
	 * 对一
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_type_id")//定义对一的时候，一端在本表中的列名
	private UserType userType;
	
	
	
	
	
	
	public UserInfo() {
		super();
	}

	public UserInfo(Integer userId) {
		super();
		this.userId = userId;
	}
	
	



	public UserInfo(Integer userId, String userName, String userPwd,
			String userRealName, Boolean userSex, String userTel,
			Date createTime, Boolean isPass, Boolean isDelete, UserType userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userRealName = userRealName;
		this.userSex = userSex;
		this.userTel = userTel;
		this.createTime = createTime;
		this.isPass = isPass;
		this.isDelete = isDelete;
		this.userType = userType;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public Boolean getUserSex() {
		return userSex;
	}
	public void setUserSex(Boolean userSex) {
		this.userSex = userSex;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getIsPass() {
		return isPass;
	}

	public void setIsPass(Boolean isPass) {
		this.isPass = isPass;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	
	

}
