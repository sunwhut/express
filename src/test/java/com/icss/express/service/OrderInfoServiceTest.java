package com.icss.express.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.TestSupport;
import com.icss.express.po.DotInfo;
import com.icss.express.po.StationInfo;
import com.icss.express.vo.OrderInfoVO;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月13日,上午10:00:52
 *function:
 * 
 */
public class OrderInfoServiceTest extends TestSupport {
	
	@Autowired
	private OrderInfoService service;
	
	@Test
	public void testAdd(){
		//success
		OrderInfoVO orderInfoVO = new OrderInfoVO();
		orderInfoVO.setOrderId(1);
		orderInfoVO.setExpressState(1);
		orderInfoVO.setOrderOriginalDotInTime(new Date());
		orderInfoVO.setOrderGoodsName("笔记本");
		orderInfoVO.setOrderGoodsWeight((float) 23.4);
		orderInfoVO.setOrderPrice(20);
		orderInfoVO.setOrderReceiverAddr("升升公寓");
		orderInfoVO.setOrderReceiverName("小飞");
		orderInfoVO.setOrderReceiverTel("15827183110");
		orderInfoVO.setOrderSenderAddr("清华大学");
		orderInfoVO.setOrderSenderName("小冯");
		orderInfoVO.setOrderSenderTel("15967132431");
		orderInfoVO.setOrderState(1);
		orderInfoVO.setDotOriginalInfo(new StationInfo(2));
		
		
		
		service.add(orderInfoVO);
		
	}
	
	@Test
	public void testGet() {
		//success
		OrderInfoVO info = service.getOrderInfo(1);
		System.out.println("sender:" + info.getOrderSenderName());
	}
	
	@Test
	public void testModifyDate() {
		//success
		Date now = new Date();
		Date date = new Date(1001,0,1);
		int orderId = 1;
		service.modifyOrderOriDotInTime(orderId, now);
		service.modifyOrderOriDotOutTime(orderId, now);
		service.modifyOrderOriStorageInTime(orderId, now);
		service.modifyOrderOriStorageOutTime(orderId, now);
		service.modifyOrderOriStorageOutTime(orderId, now);
		service.modifyOrderGoalStorageInTime(orderId, now);
		service.modifyOrderGoalStorageOutTime(orderId, now);
		service.modifyOrderGoalDotInTime(orderId, now);
		service.modifyOrderGoalDotOutTime(orderId, now);
	}
	
	@Test
	public void testGetRelevantOrder() {
		//success
		List<OrderInfoVO> list = service.getRelevantOrderByStation(2);
		for(OrderInfoVO vo : list) {
			System.out.println(vo.getOrderId());
		}
	}
	
	@Test
	public void testGetRelevantOrderByDateAndState() {
		//success
		Date dateFirst = new Date(100,0,1);
		Date dateLast = new Date(300,0,1);
		List<OrderInfoVO> list = service.getRelevantOrderByDateAndState(dateFirst, dateLast, 1, 1);
		for(OrderInfoVO vo : list) {
			System.out.println(vo.getOrderId());
			System.out.println(vo.getOrderOriginalDotInTime());
		}
		
		System.out.println(dateFirst.toLocaleString());
		System.out.println(dateLast.toLocaleString());
		
	}
	
	@Test
	public void testCount() {
		System.out.println(service.count());
	}
	

}
