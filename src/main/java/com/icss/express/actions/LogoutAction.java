package com.icss.express.actions;

import org.apache.struts2.ServletActionContext;

public class LogoutAction extends ActionSupport {

	public String execute(){
		ServletActionContext.getRequest().getSession().invalidate();
		return redirect("login.html");
	}
}
