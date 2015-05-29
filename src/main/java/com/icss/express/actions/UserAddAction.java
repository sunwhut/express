package com.icss.express.actions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.service.UserInfoService;
import com.icss.express.vo.UserInfoVO;
import com.opensymphony.xwork2.ModelDriven;

public class UserAddAction extends ActionSupport implements ModelDriven<UserInfoVO> {

	@Autowired
	private UserInfoService service;
	
	private UserInfoVO info = new UserInfoVO();
	
	private String msg;

	
	public String execute(){
		try{
			service.add(info);
		}catch(Exception ex){
			msg = "用户名已存在";
		}
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("msg", msg);
		return json(json);
	}



	@Override
	public UserInfoVO getModel() {
		return info;
	}



	public String getMsg() {
		return msg;
	}
	

}
