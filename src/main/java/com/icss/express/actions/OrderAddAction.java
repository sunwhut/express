package com.icss.express.actions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.Const;
import com.icss.express.po.StationInfo;
import com.icss.express.service.OrderInfoService;
import com.icss.express.service.StationInfoService;
import com.icss.express.service.UserInfoService;
import com.icss.express.vo.OrderInfoVO;
import com.icss.express.vo.StationInfoVO;

/**
 * @author sunwhut(孙长洪)
 *dat2015,2015年1月12日,下午3:02:05
 *function:网点管理处，订单录入
 * 
 */
public class OrderAddAction extends ActionSupport {
	@Autowired
	private OrderInfoService orderService;
	@Autowired
	private StationInfoService stationService;
	private String senderName;
	private String senderTel;
	private String senderAddr;
	private String receiverName;
	private String receiverTel;
	private String receiverAddr;
	private String itemName;
	private float itemWeight;
	private String msg;
	private float price;
	
	public String execute(){
		OrderInfoVO orderVO = new OrderInfoVO();
		int orderId;
		HttpServletRequest request= ServletActionContext.getRequest();
		senderName = request.getParameter("senderName");
		senderTel = request.getParameter("senderTel");
		senderAddr = request.getParameter("senderAddr");
		receiverName = request.getParameter("receiverName");
		receiverTel = request.getParameter("receiverTel");
		receiverAddr = request.getParameter("receiverAddr");
		itemName = request.getParameter("itemName");
		itemWeight = Float.valueOf(request.getParameter("itemWeight"));
		price = getPrice(itemWeight);
		orderVO.setOrderSenderName(senderName);
		orderVO.setOrderSenderTel(senderTel);
		orderVO.setOrderSenderAddr(senderAddr);
		orderVO.setOrderReceiverName(receiverName);
		orderVO.setOrderReceiverTel(receiverTel);
		orderVO.setOrderReceiverAddr(receiverAddr);
		orderVO.setOrderGoodsName(itemName);
		orderVO.setOrderGoodsWeight(itemWeight);
		orderVO.setOrderPrice(price);
		orderVO.setDotOriginalInfo(new StationInfo(stationService.getStationIdByTypeAndShi(senderAddr, 2)));
		orderVO.setDotGoalInfo(new StationInfo(stationService.getStationIdByTypeAndShi(receiverAddr, 2)));
		orderVO.setStorageOriginalInfo(new StationInfo(stationService.getStationIdByTypeAndShi(senderAddr, 1)));
		orderVO.setStorageGoalInfo(new StationInfo(stationService.getStationIdByTypeAndShi(receiverAddr, 1)));
		Date current = new Date();
		orderVO.setOrderOriginalDotInTime(current);
		orderVO.setOrderOriginalDotOutTime(current);
		orderVO.setOrderOriginalStorageInTime(current);
		orderVO.setOrderOriginalStorageOutTime(current);
		orderVO.setOrderGoalDotInTime(current);
		orderVO.setOrderGoalDotOutTime(current);
		orderVO.setOrderGoalStorageInTime(current);
		orderVO.setOrderGoalStorageOutTime(current);
		orderVO.setExpressState(1);
		orderVO.setOrderState(1);
		orderId = (int)orderService.count()+1 ;
		orderVO.setOrderId(orderId);
		orderService.add(orderVO);
		Map<String,Integer> order = new HashMap<String,Integer>();
		order.put("orderId", orderId);
		ServletActionContext.getRequest().getSession().setAttribute("orderId", orderId);
		return json(order);
	}
	
	public float getPrice(float weight){
		float price = 10;
		if(weight > 5){
			price += (weight-5)*5;
		}
		return price;
		}
	
}
