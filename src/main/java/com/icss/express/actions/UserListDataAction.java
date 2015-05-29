package com.icss.express.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.actions.ActionSupport;
import com.icss.express.service.UserInfoService;
import com.icss.express.service.UserTypeService;
import com.icss.express.vo.UserInfoVO;
import com.icss.express.vo.UserTypeVO;

public class UserListDataAction extends ActionSupport {

	@Autowired
	private UserInfoService service;
	
	private List<UserInfoVO> list;
	private String key;
	private int userTypeId;
	private int p=1;
	private long a;
	
	public String execute(){
		if(p<1)p=1;
		list = service.list(key, userTypeId, p, 10);
		a = service.count(key, userTypeId);
		return SUCCESS;
	}
	
	

	public List<UserInfoVO> getList() {
		return list;
	}



	public int getP() {
		return p;
	}



	public void setP(int p) {
		this.p = p;
	}



	public long getA() {
		return a;
	}



	public void setList(List<UserInfoVO> list) {
		this.list = list;
	}



	public void setKey(String key) {
		this.key = key;
	}



	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	
	
}
