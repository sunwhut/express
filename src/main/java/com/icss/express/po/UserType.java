package com.icss.express.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="user_type")
public class UserType implements Serializable {

	@Id
	@Column(name="user_type_id",nullable=false,unique=true)
	private Integer userTypeId;
	
	@Column(name="user_type_name",length=32)
	private String userTypeName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userType")
	private Set<UserInfo> userInfos = new HashSet<UserInfo>(0);

	public UserType() {
		super();
	}

	public UserType(Integer userTypeId) {
		super();
		this.userTypeId = userTypeId;
	}



	public UserType(Integer userTypeId, String userTypeName,
			Set<UserInfo> userInfos) {
		super();
		this.userTypeId = userTypeId;
		this.userTypeName = userTypeName;
		this.userInfos = userInfos;
	}

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public Set<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(Set<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}
	
	
}
