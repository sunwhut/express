package com.icss.express.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.Const;
import com.icss.express.Tools;
import com.icss.express.po.OrderInfo;
import com.icss.express.service.OrderInfoService;
import com.icss.express.service.StationInfoService;
import com.icss.express.vo.OrderInfoVO;
import com.icss.express.vo.UserInfoVO;

/**
 * @author sunwhut(孙长洪)
 *dat2015,2015年1月12日,下午3:36:47
 *function:网点页面，显示所有和本站点相关的订单
 * 
 */
public class OrderListAllAction extends ActionSupport {
	private static final long serialVersionUID = -1627921775953467290L;
	@Autowired
	private OrderInfoService orderService;
	@Autowired
	private StationInfoService stationService;
	private String page;
	private OrderInfoVO tmpOrder;
	
	public String execute(){		
		UserInfoVO userVO =  (UserInfoVO) ServletActionContext.getRequest().getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY);
		int userId = userVO.getUserId();
		int stationId = stationService.getStationIdByUserId(userId);
		List<OrderInfoVO> orderList = orderService.getRelevantOrderByStation(stationId);
		page =  ServletActionContext.getRequest().getParameter("pagination");
		List<OrderInfoVO> orderList2 = Tools.orderPaging(orderList, Integer.valueOf(page), 10);
		List<Map> finalList = new ArrayList<Map>();
		String tmpState = "";
		for(int i=0;i<orderList2.size();i++){
			tmpOrder = orderList2.get(i);
			Map<String,String> tmpMap = new HashMap<String,String>();
			tmpMap.put("orderId", tmpOrder.getOrderId().toString());
			tmpMap.put("orderOriginalDotInTime", tmpOrder.getOrderOriginalDotInTime().toString());
			tmpMap.put("orderSenderAddr", tmpOrder.getOrderSenderAddr());
			tmpMap.put("orderReceiverAddr", tmpOrder.getOrderReceiverAddr());
			switch(tmpOrder.getOrderState()){
			case 1:tmpState="已下单";break;
			case 2:tmpState="已发货";break;
			case 3:tmpState="已收货";break;
			case 4:tmpState="已签收";break;
			}
			tmpMap.put("orderState",tmpState);
			finalList.add(tmpMap);
		}
		return json(finalList);
	}
}
