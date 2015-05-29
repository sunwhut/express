package com.icss.express.vo;

import javax.persistence.Column;

public class UserTypeVO {
	
	private Integer userTypeId;
	private String userTypeName;
	
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
	
	
}
