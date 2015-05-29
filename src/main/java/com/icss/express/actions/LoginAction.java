package com.icss.express.actions;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.Const;
import com.icss.express.po.UserInfo;
import com.icss.express.service.UserInfoService;
import com.icss.express.vo.UserInfoVO;

public class LoginAction extends ActionSupport {
	
	private String userName,userPwd,checkNumber;
	
	private String msg;
	@Autowired
	private UserInfoService service;
	
	public String execute(){
		if(!CheckAction.check(checkNumber)){
			msg="验证码错误";
			return JSON;
//			return "aa";
		}
		try{
			System.out.println("1, userName= " + userName + " userPwd= " + userPwd);
			UserInfoVO userInfo= service.login(userName, userPwd);
			System.out.println("2, userName= " + userName + " userPwd= " + userPwd);

			ServletActionContext.getRequest().getSession().setAttribute(Const.LOGIN_USER_SESSION_KEY, userInfo);
		
			
//			System.out.println("登陆成功");
//			return "bb";
//			return this.redirect("main.html");
		}catch(Exception ex){
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
			msg = ex.getMessage();
		}
//		return "aa";
		return JSON;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	
	

}
