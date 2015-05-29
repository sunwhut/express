package com.icss.express.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.service.UserInfoService;

public class UserModifyPwdAction extends ActionSupport {

	private String userPwdOld,userPwdNew;
	private String msg;
	@Autowired
	private UserInfoService service;
	
	public String execute(){
		try {
			service.modifyUserPwd(user.getUserId(), userPwdOld, userPwdNew);
		} catch (Exception e) {
			msg = e.getMessage();
		}
		return JSON;
	}

	public String getMsg() {
		return msg;
	}

	public void setUserPwdOld(String userPwdOld) {
		this.userPwdOld = userPwdOld;
	}

	public void setUserPwdNew(String userPwdNew) {
		this.userPwdNew = userPwdNew;
	}
	
	
}
