package com.icss.express.actions;

public class LoginUserAction extends ActionSupport {

	public String execute(){
		
		return json(user);
	}
}
