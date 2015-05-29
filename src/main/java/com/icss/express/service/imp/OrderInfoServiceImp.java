package com.icss.express.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.metadata.HsqlTableMetaDataProvider;
import org.springframework.stereotype.Service;

import com.icss.express.dao.BaseDAO;
import com.icss.express.po.OrderInfo;
import com.icss.express.service.OrderInfoService;
import com.icss.express.vo.OrderInfoVO;

/**
 * @author jokhan（徐晓龙） dat2015,2015年1月9日,上午10:38:57 function:
 * 
 */
@Service
public class OrderInfoServiceImp implements OrderInfoService {

	@Autowired
	private BaseDAO<OrderInfo> baseDAO;

	@Override
	public void add(OrderInfoVO orderInfoVO) {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = new OrderInfo();
		System.out.println("sender:" + orderInfoVO.getOrderSenderName());
		BeanUtils.copyProperties(orderInfoVO, orderInfo);
		System.out.println("receiver:" + orderInfo.getOrderReceiverName());
		baseDAO.save(orderInfo);
	}

	@Override
	public void modify(OrderInfoVO orderInfoVO) {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = new OrderInfo();
		BeanUtils.copyProperties(orderInfoVO, orderInfo);
		baseDAO.update(orderInfo);

	}

	@Override
	public void delete(Integer orderId) {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = baseDAO.get(OrderInfo.class, orderId);
		orderInfo.setIsDelete(true);
		baseDAO.update(orderInfo);

	}

	@Override
	public OrderInfoVO getOrderInfo(int orderId) {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = baseDAO.get(OrderInfo.class, orderId);
		OrderInfoVO vo = new OrderInfoVO();
		BeanUtils.copyProperties(orderInfo, vo);
		return vo;
	}

	// @Override
	// public OrderInfoVO getOrderInfoByState(String state) {
	// // TODO Auto-generated method stub
	// return null;
	// }

	@Override
	public void modifyOrderOriDotInTime(int orderId, Date inTime) {
		OrderInfo orderInfo = baseDAO.get(OrderInfo.class, orderId);
		orderInfo.setOrderOriginalDotInTime(inTime);
		orderInfo.setExpressState(1);
		orderInfo.setOrderState(1);
		baseDAO.update(orderInfo);
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyOrderOriDotOutTime(int orderId, Date outTime) {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = baseDAO.get(OrderInfo.class, orderId);
		orderInfo.setOrderOriginalDotOutTime(outTime);
		orderInfo.setExpressState(1);
		orderInfo.setOrderState(2);
		baseDAO.update(orderInfo);

	}

	@Override
	public void modifyOrderOriStorageInTime(int orderId, Date inTime) {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = baseDAO.get(OrderInfo.class, orderId);
		orderInfo.setOrderOriginalStorageInTime(inTime);
		orderInfo.setExpressState(2);
		orderInfo.setOrderState(3);
		baseDAO.update(orderInfo);

	}

	@Override
	public void modifyOrderOriStorageOutTime(int orderId, Date outTime) {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = baseDAO.get(OrderInfo.class, orderId);
		orderInfo.setOrderOriginalStorageOutTime(outTime);
		orderInfo.setExpressState(2);
		orderInfo.setOrderState(2);
		baseDAO.update(orderInfo);

	}

	@Override
	public void modifyOrderGoalStorageInTime(int orderId, Date inTime) {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = baseDAO.get(OrderInfo.class, orderId);
		orderInfo.setOrderGoalStorageInTime(inTime);
		orderInfo.setExpressState(3);
		orderInfo.setOrderState(3);
		baseDAO.update(orderInfo);

	}

	@Override
	public void modifyOrderGoalStorageOutTime(int orderId, Date outTime) {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = baseDAO.get(OrderInfo.class, orderId);
		orderInfo.setOrderGoalStorageOutTime(outTime);
		orderInfo.setExpressState(3);
		orderInfo.setOrderState(2);
		baseDAO.update(orderInfo);

	}

	@Override
	public void modifyOrderGoalDotInTime(int orderId, Date intTime) {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = baseDAO.get(OrderInfo.class, orderId);
		orderInfo.setOrderGoalDotInTime(intTime);
		orderInfo.setExpressState(4);
		orderInfo.setOrderState(3);
		baseDAO.update(orderInfo);

	}

	@Override
	public void modifyOrderGoalDotOutTime(int orderId, Date outTime) {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = baseDAO.get(OrderInfo.class, orderId);
		orderInfo.setOrderGoalDotOutTime(outTime);
		orderInfo.setExpressState(4);
		orderInfo.setOrderState(4);
		baseDAO.update(orderInfo);

	}

	@Override
	public List<OrderInfoVO> getRelevantOrderByStation(Integer stationId) {
		// TODO Auto-generated method stub
		String hql = "from OrderInfo as t where "
				+ " t.dotOriginalInfo.stationId=" + stationId
				+ " or t.dotGoalInfo.stationId=" + stationId
				+ " or t.storageOriginalInfo.stationId=" + stationId
				+ " or t.storageGoalInfo.stationId=" + stationId
				+ " and t.isDelete=false"
				+ " ORDER BY t.orderOriginalDotInTime";
		List<OrderInfo> list = baseDAO.find(hql);
//		System.out.println(hql);
		List<OrderInfoVO> listVO = new ArrayList<OrderInfoVO>();
		for (OrderInfo info : list) {
			OrderInfoVO vo = new OrderInfoVO();
			BeanUtils.copyProperties(info, vo);
			listVO.add(vo);
		}
		return listVO;
	}

	@Override
	public List<OrderInfoVO> getRelevantOrderByDateAndState(Date dateFirst,
			Date dateLast, int orderState, int stationId) {
		// TODO Auto-generated method stub
		String hqlHead = "from OrderInfo as t where ";
		String hqlStation = " t.dotOriginalInfo.stationId=" + stationId
				+ " or t.dotGoalInfo.stationId=" + stationId
				+ " or t.storageOriginalInfo.stationId=" + stationId
				+ " or t.storageGoalInfo.stationId=" + stationId;
//		String hqlDate = " and t.orderOriginalDotInTime >= '" + dateFirst.toLocaleString() + "' and "
//				+ "t.orderOriginalDotInTime <= '" + dateLast.toLocaleString() + "' ";
		String hqlState = "and t.orderState=" + orderState;
		String hqlTail = " ORDER BY t.orderOriginalDotInTime";
		String hql = hqlHead + hqlStation  + hqlState + "and t.isDelete=false" + hqlTail;
		List<OrderInfo> list = baseDAO.find(hql);
		System.out.println(hql);
		List<OrderInfoVO> listVO = new ArrayList<OrderInfoVO>();
		for (OrderInfo info : list) {
			OrderInfoVO vo = new OrderInfoVO();
			BeanUtils.copyProperties(info, vo);
			Date date = vo.getOrderOriginalDotInTime();
			System.out.println(date);
			if(date.after(dateFirst) && date.before(dateLast))   //剔除时间不满足的信息
				listVO.add(vo);
		}
		return listVO;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		long count = 0;
		count = baseDAO.count("select count(*) from OrderInfo");
		return count;
	}
	

@Override
	public int getOrderStoregeTypeById(int orderId, int storageId) {
		// TODO Auto-generated method stub
		int result = 0;
		OrderInfo orderInfo = baseDAO.get(OrderInfo.class, orderId);
		int oriStorageId = orderInfo.getStorageOriginalInfo().getStationId();
		int goalStorageId = orderInfo.getStorageGoalInfo().getStationId();
		if (storageId == oriStorageId) {
			result = 1;
		} else if(storageId == goalStorageId) {
			result = 2;
		}
		return result;
	}


}
