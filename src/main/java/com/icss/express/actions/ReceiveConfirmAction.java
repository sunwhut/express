package com.icss.express.actions;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.service.OrderInfoService;

/**
 * @author sunwhut(孙长洪)
 *dat2015,2015年1月12日,下午3:22:39
 *function:收货确认
 * 
 */
public class ReceiveConfirmAction extends ActionSupport {
	@Autowired
	private OrderInfoService orderService;
	private String msg;
	private String ordersId;
	
	public String execute(){
		Date receiveTime = new Date();
		ordersId = ServletActionContext.getRequest().getParameter("ordersId");
		String[] orders = ordersId.split("\\\\n");
		for(int i=0 ; i<orders.length ; i++){
			orderService.modifyOrderGoalDotInTime(Integer.valueOf(orders[i]), receiveTime);
		}
		msg = "已收货";
		return msg;
	}
}
