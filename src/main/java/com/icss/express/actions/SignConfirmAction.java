package com.icss.express.actions;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.Const;
import com.icss.express.service.OrderInfoService;

/**
 * @author sunwhut(孙长洪)
 *dat2015,2015年1月12日,下午3:23:35
 *function:签收确认
 * 
 */
public class SignConfirmAction extends ActionSupport {
	@Autowired
	private OrderInfoService orderService;
	private String msg;
	private String orderId;
	
	public String execute(){
		Date signTime = new Date();
		orderId = ServletActionContext.getRequest().getParameter("orderId");
		orderService.modifyOrderGoalDotOutTime(Integer.valueOf(orderId) , signTime);		
		msg = "已签收";
		return msg;
	}
}
 