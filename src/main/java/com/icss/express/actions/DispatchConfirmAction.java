package com.icss.express.actions;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.service.OrderInfoService;

/**
 * @author sunwhut(孙长洪)
 *dat2015,2015年1月12日,下午3:20:28
 *function:发货确认
 * 
 */
public class DispatchConfirmAction extends ActionSupport {
	@Autowired
	private OrderInfoService orderService;
	private String msg;
	private String ordersId;
	
	public String execute(){
		Date dispathTime = new Date();
		ordersId = ServletActionContext.getRequest().getParameter("ordersId");
		String[] orders = ordersId.split("\\\\n");
		for(int i=0 ; i<orders.length ; i++){
			orderService.modifyOrderOriDotOutTime(Integer.valueOf(orders[i]), dispathTime);
		}
		msg = "已发货";
		return msg;
	}
}
