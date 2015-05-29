package com.icss.express.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.service.UserTypeService;
import com.icss.express.vo.UserTypeVO;

public class UserAddFormAction extends ActionSupport {

	@Autowired
	private UserTypeService service;
	
	private List<UserTypeVO> list;
	
	public String execute(){
		list = service.listAll();
		return SUCCESS;
	}

	public List<UserTypeVO> getList() {
		return list;
	}
	
}
