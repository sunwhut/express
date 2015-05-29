package com.icss.express.actions;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.service.OrderInfoService;

/**
 * @author sunwhut(孙长洪)
 *dat2015,2015年1月12日,下午3:37:55
 *function:按照订单号搜索和本站点相关的信息
 * 
 */
public class OrderSearchByIdAction extends ActionSupport {
	@Autowired
	private OrderInfoService orderService;
	private String orderId;
	
}
