package com.icss.express.actions;

/**
 * @author sunwhut(孙长洪)
 *dat2015,2015年1月12日,下午3:40:04
 *function:下单网点删除订单
 * 
 */
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.service.OrderInfoService;
import com.icss.express.vo.OrderInfoVO;

public class OrderInfoAction extends ActionSupport{
	@Autowired
	private OrderInfoService service;
	private String orderId;

	public String execute(){
		orderId = ServletActionContext.getRequest().getParameter("orderId");
		OrderInfoVO order = service.getOrderInfo(Integer.valueOf(orderId));
		return json(order);
	}
}
