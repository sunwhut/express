package com.icss.express.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.struts2.json.annotations.JSON;

import com.icss.express.po.DotInfo;
import com.icss.express.po.StationInfo;

/**
 * @author jokhan（徐晓龙） dat2015,2015年1月9日,上午9:26:11 function:
 * 
 */
public class OrderInfoVO {
	
	
	private Integer orderId;

	/**
	 * 物流的路线信息 the information of route
	 */
	private StationInfo dotOriginalInfo;
	private Date orderOriginalDotInTime;
	private Date orderOriginalDotOutTime;
	private StationInfo storageOriginalInfo;
	private Date orderOriginalStorageInTime;
	private Date orderOriginalStorageOutTime;
	private StationInfo storageGoalInfo;
	private Date orderGoalStorageInTime;
	private Date orderGoalStorageOutTime;
	private StationInfo dotGoalInfo;
	private Date orderGoalDotInTime;
	private Date orderGoalDotOutTime;
	private String orderSenderName;
	private String orderSenderTel;
	private String orderSenderAddr;
	private String orderReceiverName;
	private String orderReceiverTel;
	private String orderReceiverAddr;
	private String orderGoodsName;
	private float orderGoodsWeight;
	private float orderPrice;
	private int orderState;
	private int expressState;
	private String orderNote;
	private Boolean isDelete=false;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	
	
	public StationInfo getDotOriginalInfo() {
		return dotOriginalInfo;
	}
	public void setDotOriginalInfo(StationInfo dotOriginalInfo) {
		this.dotOriginalInfo = dotOriginalInfo;
	}
	public void setDotGoalInfo(StationInfo dotGoalInfo) {
		this.dotGoalInfo = dotGoalInfo;
	}
	public Date getOrderOriginalDotInTime() {
		return orderOriginalDotInTime;
	}
	public void setOrderOriginalDotInTime(Date orderOriginalDotInTime) {
		this.orderOriginalDotInTime = orderOriginalDotInTime;
	}
	public Date getOrderOriginalDotOutTime() {
		return orderOriginalDotOutTime;
	}
	public void setOrderOriginalDotOutTime(Date orderOriginalDotOutTime) {
		this.orderOriginalDotOutTime = orderOriginalDotOutTime;
	}
	public StationInfo getStorageOriginalInfo() {
		return storageOriginalInfo;
	}
	public void setStorageOriginalInfo(StationInfo storageOriginalInfo) {
		this.storageOriginalInfo = storageOriginalInfo;
	}
	public Date getOrderOriginalStorageInTime() {
		return orderOriginalStorageInTime;
	}
	public void setOrderOriginalStorageInTime(Date orderOriginalStorageInTime) {
		this.orderOriginalStorageInTime = orderOriginalStorageInTime;
	}
	public Date getOrderOriginalStorageOutTime() {
		return orderOriginalStorageOutTime;
	}
	public void setOrderOriginalStorageOutTime(Date orderOriginalStorageOutTime) {
		this.orderOriginalStorageOutTime = orderOriginalStorageOutTime;
	}
	public StationInfo getStorageGoalInfo() {
		return storageGoalInfo;
	}
	public void setStorageGoalInfo(StationInfo storageGoalInfo) {
		this.storageGoalInfo = storageGoalInfo;
	}
	public Date getOrderGoalStorageInTime() {
		return orderGoalStorageInTime;
	}
	public void setOrderGoalStorageInTime(Date orderGoalStorageInTime) {
		this.orderGoalStorageInTime = orderGoalStorageInTime;
	}
	public Date getOrderGoalStorageOutTime() {
		return orderGoalStorageOutTime;
	}
	public void setOrderGoalStorageOutTime(Date orderGoalStorageOutTime) {
		this.orderGoalStorageOutTime = orderGoalStorageOutTime;
	}
	
	public StationInfo getDotGoalInfo() {
		return dotGoalInfo;
	}
	public Date getOrderGoalDotInTime() {
		return orderGoalDotInTime;
	}
	public void setOrderGoalDotInTime(Date orderGoalDotInTime) {
		this.orderGoalDotInTime = orderGoalDotInTime;
	}
	public Date getOrderGoalDotOutTime() {
		return orderGoalDotOutTime;
	}
	public void setOrderGoalDotOutTime(Date orderGoalDotOutTime) {
		this.orderGoalDotOutTime = orderGoalDotOutTime;
	}
	public String getOrderSenderName() {
		return orderSenderName;
	}
	public void setOrderSenderName(String orderSenderName) {
		this.orderSenderName = orderSenderName;
	}
	public String getOrderSenderTel() {
		return orderSenderTel;
	}
	public void setOrderSenderTel(String orderSenderTel) {
		this.orderSenderTel = orderSenderTel;
	}
	public String getOrderSenderAddr() {
		return orderSenderAddr;
	}
	public void setOrderSenderAddr(String orderSenderAddr) {
		this.orderSenderAddr = orderSenderAddr;
	}
	public String getOrderReceiverName() {
		return orderReceiverName;
	}
	public void setOrderReceiverName(String orderReceiverName) {
		this.orderReceiverName = orderReceiverName;
	}
	public String getOrderReceiverTel() {
		return orderReceiverTel;
	}
	public void setOrderReceiverTel(String orderReceiverTel) {
		this.orderReceiverTel = orderReceiverTel;
	}
	public String getOrderReceiverAddr() {
		return orderReceiverAddr;
	}
	public void setOrderReceiverAddr(String orderReceiverAddr) {
		this.orderReceiverAddr = orderReceiverAddr;
	}
	public String getOrderGoodsName() {
		return orderGoodsName;
	}
	public void setOrderGoodsName(String orderGoodsName) {
		this.orderGoodsName = orderGoodsName;
	}
	public float getOrderGoodsWeight() {
		return orderGoodsWeight;
	}
	public void setOrderGoodsWeight(float orderGoodsWeight) {
		this.orderGoodsWeight = orderGoodsWeight;
	}
	public float getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(float orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public int getExpressState() {
		return expressState;
	}
	public void setExpressState(int expressState) {
		this.expressState = expressState;
	}
	
	
	
	
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getOrderNote() {
		return orderNote;
	}
	public void setOrderNote(String orderNote) {
		this.orderNote = orderNote;
	}
	public OrderInfoVO() {
		super();
	}
	public OrderInfoVO(Integer orderId) {
		super();
		this.orderId = orderId;
	}
	public OrderInfoVO(Integer orderId, StationInfo dotOriginalInfo,
			Date orderOriginalDotInTime, Date orderOriginalDotOutTime,
			StationInfo storageOriginalInfo, Date orderOriginalStorageInTime,
			Date orderOriginalStorageOutTime, StationInfo storageGoalInfo,
			Date orderGoalStorageInTime, Date orderGoalStorageOutTime,
			StationInfo dotGoalInfo, Date orderGoalDotInTime,
			Date orderGoalDotOutTime, String orderSenderName,
			String orderSenderTel, String orderSenderAddr,
			String orderReceiverName, String orderReceiverTel,
			String orderReceiverAddr, String orderGoodsName,
			float orderGoodsWeight, float orderPrice, int orderState,
			int expressState, String orderNote, Boolean isDelete) {
		super();
		this.orderId = orderId;
		this.dotOriginalInfo = dotOriginalInfo;
		this.orderOriginalDotInTime = orderOriginalDotInTime;
		this.orderOriginalDotOutTime = orderOriginalDotOutTime;
		this.storageOriginalInfo = storageOriginalInfo;
		this.orderOriginalStorageInTime = orderOriginalStorageInTime;
		this.orderOriginalStorageOutTime = orderOriginalStorageOutTime;
		this.storageGoalInfo = storageGoalInfo;
		this.orderGoalStorageInTime = orderGoalStorageInTime;
		this.orderGoalStorageOutTime = orderGoalStorageOutTime;
		this.dotGoalInfo = dotGoalInfo;
		this.orderGoalDotInTime = orderGoalDotInTime;
		this.orderGoalDotOutTime = orderGoalDotOutTime;
		this.orderSenderName = orderSenderName;
		this.orderSenderTel = orderSenderTel;
		this.orderSenderAddr = orderSenderAddr;
		this.orderReceiverName = orderReceiverName;
		this.orderReceiverTel = orderReceiverTel;
		this.orderReceiverAddr = orderReceiverAddr;
		this.orderGoodsName = orderGoodsName;
		this.orderGoodsWeight = orderGoodsWeight;
		this.orderPrice = orderPrice;
		this.orderState = orderState;
		this.expressState = expressState;
		this.orderNote = orderNote;
		this.isDelete = isDelete;
	}
	
	
	
	
	
	
	
	

}
