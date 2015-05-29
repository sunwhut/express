package com.icss.express.actions;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.icss.express.vo.OrderInfoVO;

public class GetCurrentOrderAction extends ActionSupport{
	
	public String execute(){
		Map<String,String> order = new HashMap<String,String>();
		String orderId = (String) ServletActionContext.getRequest().getSession().getAttribute("orderId");
		ServletActionContext.getRequest().getSession().removeAttribute("orderId");
		order.put("orderId", orderId);
		return json(order);
	}
}
