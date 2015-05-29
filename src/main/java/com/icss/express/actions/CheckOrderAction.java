package com.icss.express.actions;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.service.OrderInfoService;
import com.icss.express.vo.OrderInfoVO;

/**
 * @author sunwhut(孙长洪)
 *dat2015,2015年1月12日,下午3:40:04
 *function:游客查询订单
 * 
 */
public class CheckOrderAction extends ActionSupport{
	@Autowired
	private OrderInfoService orderService;
	private OrderInfoVO orderInfo;
	private StringBuilder orderState;  //订单的物流状态
	private String tmp;
	private String orderId,checkNumber,msg;
	private int expressState;
	
	public String execute(){
		if(!CheckAction.check(checkNumber)){
			msg="验证码错误";
			return JSON;
//			return "aa";
		}
		orderId = ServletActionContext.getRequest().getParameter("orderId");
		orderInfo = orderService.getOrderInfo(Integer.valueOf(orderId));
		expressState = orderInfo.getExpressState();
		tmp = orderInfo.getOrderOriginalDotInTime().toString() + "\t订单在" + 
		orderInfo.getDotOriginalInfo().getStationName() + "网点已下单";
		orderState.append(tmp+"\n");
		switch(expressState){
		case 1: {
					if(orderInfo.getOrderOriginalDotOutTime().after(orderInfo.getOrderOriginalDotInTime())){
						tmp = orderInfo.getOrderOriginalDotOutTime().toString() + "\t订单在" + 
								orderInfo.getDotOriginalInfo().getStationName() + "网点已发货";
						orderState.append(tmp+"\n");
					}
				}
		case 2:{
					if(orderInfo.getOrderOriginalStorageInTime().after(orderInfo.getOrderOriginalDotInTime()) &&
							orderInfo.getOrderOriginalStorageOutTime().equals(orderInfo.getOrderOriginalDotInTime())){
						tmp = orderInfo.getOrderOriginalStorageInTime().toString()+"\t订单在"+
								orderInfo.getStorageOriginalInfo().getStationName()+"仓库已收货";
						orderState.append(tmp+"\n");								
					}else if(orderInfo.getOrderOriginalStorageOutTime().after(orderInfo.getOrderOriginalDotInTime())){
						tmp = orderInfo.getOrderOriginalStorageOutTime().toString() + "\t订单在"+
								orderInfo.getStorageOriginalInfo().getStationName() + "仓库已发货";
						orderState.append(tmp+"\n");
					}
				}
		case 3:{
					if(orderInfo.getOrderGoalStorageInTime().after(orderInfo.getOrderOriginalDotInTime())&&
							orderInfo.getOrderGoalStorageOutTime().equals(orderInfo.getOrderOriginalDotInTime())){
						tmp = orderInfo.getOrderGoalStorageInTime().toString() + "\t订单在" +
								orderInfo.getStorageGoalInfo().getStationName() + "仓库已收货";
						orderState.append(tmp+"\n");
					}else if(orderInfo.getOrderGoalStorageOutTime().after(orderInfo.getOrderOriginalDotInTime())){
						tmp = orderInfo.getOrderGoalStorageOutTime().toString()+"\t订单在"+
								orderInfo.getStorageGoalInfo().getStationName() + "仓库已发货";
						orderState.append(tmp+"\n");
					}
			   }
		case 4:{
					if(orderInfo.getOrderGoalDotInTime().after(orderInfo.getOrderOriginalDotInTime())&&
							orderInfo.getOrderGoalDotOutTime().equals(orderInfo.getOrderOriginalDotInTime())){
						tmp = orderInfo.getOrderGoalDotInTime().toString() + "\t订单在" +
							orderInfo.getDotGoalInfo().getStationName() + "网点已收货";
						orderState.append(tmp+"\n");
					}else if(orderInfo.getOrderGoalDotOutTime().after(orderInfo.getOrderOriginalDotInTime())){
						tmp = orderInfo.getOrderGoalDotOutTime().toString() + "\t订单在"+
								orderInfo.getDotGoalInfo().getStationName()+"网点已收货";
						orderState.append(tmp+"\n");
					}
				}
		}
		Map<String,String> order = new HashMap<String,String>();
		order.put("orderState", orderState.toString());
		order.put("orderId", orderId);
		return json(order);
	}
	
}
