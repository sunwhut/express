package com.icss.express.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.Const;
import com.icss.express.po.OrderInfo;
import com.icss.express.service.OrderInfoService;
import com.icss.express.service.StationInfoService;
import com.icss.express.vo.OrderInfoVO;
import com.icss.express.vo.UserInfoVO;

/**
 * @author sunwhut(孙长洪)
 *  *dat2015,2015年1月12日,下午3:38:58
 *function:网点界面，按日期搜索和其他条件搜索订单
 * 
 */
public class OrderSerachExAction extends ActionSupport {
	private static final long serialVersionUID = -1627921775953467290L;
	@Autowired
	private OrderInfoService orderService;
	@Autowired
	private StationInfoService stationService;
	private String orderState;
	
	public String execute(){
		Date firstDate = null , lastDate = null;
		UserInfoVO userVO =  (UserInfoVO) ServletActionContext.getRequest().getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY);
		int userId = userVO.getUserId();
		int stationId = stationService.getStationIdByUserId(userId);
		HttpServletRequest request= ServletActionContext.getRequest();
		orderState = request.getParameter("orderState");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		try {
			firstDate = sdf.parse(request.getParameter("firstDate"));
			lastDate = sdf.parse(request.getParameter("lastDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<OrderInfoVO> orderList = orderService.getRelevantOrderByDateAndState(firstDate, lastDate, Integer.valueOf(orderState), stationId);
		return json(orderList);
	}
}
