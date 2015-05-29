package com.icss.express.actions;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.Const;
import com.icss.express.service.OrderInfoService;
import com.icss.express.service.StationInfoService;
import com.icss.express.vo.OrderInfoVO;
import com.icss.express.vo.UserInfoVO;

/**
 * @author sunwhut(孙长洪)
 *dat2015,2015年1月12日,下午3:48:34
 *function: 订单进入仓库
 * 
 */
public class StorageInAction extends ActionSupport {
	@Autowired
	private OrderInfoService orderService;
	@Autowired
	private StationInfoService stationService;
	private String ordersId;
	private static final long serialVersionUID = -1627921775953467290L;
	private UserInfoVO userVO;
	int userId;
	int stationId;
	private String receiveMsg;
	
	public String execute(){		
	    userVO =  (UserInfoVO) ServletActionContext.getRequest().getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY);
	    userId = userVO.getUserId();
		stationId = stationService.getStationIdByUserId(userId);
		ordersId = ServletActionContext.getRequest().getParameter("ordersId");
		String[] orders = ordersId.split("\\\\n");
		for(int i=0 ; i<orders.length ; i++){
			receive(orders[i]);
		}
		Map<String,String> receiveOrder = new HashMap<String,String>();
		receiveMsg = "收货成功";
		receiveOrder.put("receiveMsg", receiveMsg);
		return json(receiveOrder);
	}
	
	public void receive(String orderId){
		int type = orderService.getOrderStoregeTypeById(Integer.valueOf(orderId), stationId);
		if(type == 1){
			orderService.modifyOrderOriStorageInTime(Integer.valueOf(orderId), new Date());
		}else if(type == 2){
			orderService.modifyOrderGoalStorageInTime(Integer.valueOf(orderId), new Date());
		}
	}
}
