package com.icss.express.service;

import java.util.Date;


import java.util.List;

import com.icss.express.vo.OrderInfoVO;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月9日,上午9:19:29
 *function:
 * 
 */
public interface OrderInfoService {
	
	void add(OrderInfoVO orderInfo);
	
	void modify(OrderInfoVO orderInfo);
	
	/**
	 * 按订单号删除订单
	 * @param orderId
	 */
	void delete(Integer orderId);
	
	/**
	 * 根据单号查询订单
	 * @param orderInfoId
	 */
	OrderInfoVO getOrderInfo(int orderId);
	
	/**
	 * 根据状态返回订单信息
	 * get the information of orders by the sate
	 * @param state
	 * @return
	 */
	//OrderInfoVO getOrderInfoByState(String state);
	
	
	/***********下面八个大改，同时修改订单状态和物流状态！***********/
	//mark;
	//2015.01.14
	/**
	 * 修改订单的源网点入库时间
	 * 并修改物流状态和订单状态
	 * @param oderId
	 * @param inTime
	 */
	void modifyOrderOriDotInTime(int orderId,Date inTime);
	
	/**
	 * 修改订单的源网点出库时间
	 * 并修改物流状态和订单状态
	 * @param oderId
	 * @param outTime
	 */
	void modifyOrderOriDotOutTime(int orderId,Date outTime);
	
	/**
	 * 修改订单的源仓库入库时间
	 * 并修改物流状态和订单状态
	 * @param oderId
	 * @param inTime
	 */
	void modifyOrderOriStorageInTime(int orderId,Date inTime);
	
	/**
	 * 修改订单的源仓库出库时间
	 * 并修改物流状态和订单状态
	 * @param oderId
	 * @param outTime
	 */
	void modifyOrderOriStorageOutTime(int orderId,Date outTime);
	
	/**
	 * 修改目标仓库的入库时间
	 * 并修改物流状态和订单状态
	 * @param oderId
	 * @param outTime
	 */
	void modifyOrderGoalStorageInTime(int orderId,Date inTime);
	
	/**
	 * 修改目标仓库的出库时间
	 * 并修改物流状态和订单状态
	 * @param oderId
	 * @param outTime
	 */
	void modifyOrderGoalStorageOutTime(int orderId,Date outTime);
	
	/**
	 * 修改目标网点的入库时间
	 * 并修改物流状态和订单状态
	 * @param oderId
	 * @param intTime
	 */
	void modifyOrderGoalDotInTime(int orderId,Date intTime);
	
	/**
	 * 修改目标网点的出库时间，即为签收时间
	 * 并修改物流状态和订单状态
	 * @param oderId
	 * @param outTime
	 */
	void modifyOrderGoalDotOutTime(int orderId,Date outTime);
	/**
	 * 网点获取和自身有关的订单
	 * @param staionId
	 * @return
	 */
	List<OrderInfoVO> getRelevantOrderByStation(Integer stationId);
	/**
	 * 模糊查找与本站点相关的订单
	 * @param dateFirst
	 * @param dateLast
	 * @param orderState
	 * @param stationId
	 * @return
	 */
	List<OrderInfoVO> getRelevantOrderByDateAndState(Date dateFirst,Date dateLast,int orderState,int stationId);
	
	/**
	 * 计数
	 * @return
	 */
	long count();
	
	/**
	 * 根据订单和站点号来确定当前仓库是原始仓库还是目标仓库
	 * 1表示原始仓库，2表示目标仓库，0表示仓库与订单无关
	 * @param OrderId
	 * @param storageId
	 * @return
	 */
	int getOrderStoregeTypeById(int orderId, int storageId);
	

}
