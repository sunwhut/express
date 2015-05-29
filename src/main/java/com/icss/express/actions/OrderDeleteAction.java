package com.icss.express.actions;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.service.OrderInfoService;

/**
 * @author sunwhut(孙长洪)
 *dat2015,2015年1月12日,下午3:40:04
 *function:下单网点删除订单
 * 
 */
public class OrderDeleteAction extends ActionSupport {
	@Autowired
	private OrderInfoService orderService;
	private String msg;
	private String orderId;
	
	public String execute(){
		orderId = ServletActionContext.getRequest().getParameter("orderId");
		orderService.delete(Integer.valueOf(orderId));
		msg = "已删除";
		return msg;
	} 
}
