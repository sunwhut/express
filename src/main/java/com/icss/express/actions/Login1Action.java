package com.icss.express.actions;

import com.icss.express.vo.UserInfoVO;
import com.opensymphony.xwork2.ModelDriven;

public class Login1Action extends ActionSupport implements ModelDriven<UserInfoVO> {
	
	private String userName;
	private String userPwd;
	
	private UserInfoVO vo = new UserInfoVO();
	
	public String execute(){
		System.out.println(this);
		System.out.println(userName);
		System.out.println(userPwd);
		System.out.println(vo.getUserName());
		System.out.println(vo.getUserPwd());
		return null;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public UserInfoVO getModel() {
		return vo;
	}
	
	

}
