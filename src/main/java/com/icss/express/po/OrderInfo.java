package com.icss.express.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月8日,下午4:16:29
 *function:
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="order_info")
public class OrderInfo {
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Id
	@Column(name="order_id",nullable=false,unique=true)
	private Integer orderId;
	
	
	
	/**
	 * 物流的路线信息
	 * the information of route
	 */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_original_dot_id")//定义对一的时候，一端在本表中的列名
	private StationInfo dotOriginalInfo;
	
	@Column(name="order_original_dot_in_time")
	private Date orderOriginalDotInTime;
	
	@Column(name="order_original_dot_out_time")
	private Date orderOriginalDotOutTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_original_storage_id")//定义对一的时候，一端在本表中的列名
	private StationInfo storageOriginalInfo;
	
	@Column(name="order_original_storage_in_time")
	private Date orderOriginalStorageInTime;
	
	@Column(name="order_original_storage_out_time")
	private Date orderOriginalStorageOutTime;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_goal_storage_id")//定义对一的时候，一端在本表中的列名
	private StationInfo storageGoalInfo;
	
	@Column(name="order_goal_storage_in_time")
	private Date orderGoalStorageInTime;
	
	@Column(name="order_goal_storage_out_time")
	private Date orderGoalStorageOutTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_goal_dot_id")//定义对一的时候，一端在本表中的列名
	private StationInfo dotGoalInfo;
	
	@Column(name="order_goal_dot_in_time")
	private Date orderGoalDotInTime;
	
	@Column(name="order_goal_dot_out_time")
	private Date orderGoalDotOutTime;
	
	
	@Column(name="order_sender_name",length=20)
	private String orderSenderName;
	
	@Column(name="order_sender_tel",length=11)
	private String orderSenderTel;
	
	@Column(name="order_sender_addr",length=60)
	private String orderSenderAddr;
	
	
	@Column(name="order_receiver_name",length=20)
	private String orderReceiverName;
	
	@Column(name="order_receiver_tel",length=11)
	private String orderReceiverTel;
	
	@Column(name="order_receiver_addr",length=60)
	private String orderReceiverAddr;
	
	@Column(name="order_goods_name",length=20)
	private String orderGoodsName;
	
	@Column(name="order_goods_weight")
	private float orderGoodsWeight;
	
	@Column(name="order_price")
	private float orderPrice;
	
	@Column(name="order_state")
	private int orderState;
	
	@Column(name="express_state")
	private int expressState;
	
	@Column(name="order_note")
	private String orderNote;
	
	@Column(name="is_delete")
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

	public StationInfo getStorageOfiginalInfo() {
		return storageOriginalInfo;
	}

	public void setStorageOfiginalInfo(StationInfo storageOfiginalInfo) {
		this.storageOriginalInfo = storageOfiginalInfo;
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

	public void setDotGoalInfo(StationInfo dotGoalInfo) {
		this.dotGoalInfo = dotGoalInfo;
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


	

	public StationInfo getStorageOriginalInfo() {
		return storageOriginalInfo;
	}

	public void setStorageOriginalInfo(StationInfo storageOriginalInfo) {
		this.storageOriginalInfo = storageOriginalInfo;
	}

	public String getOrderNote() {
		return orderNote;
	}

	public void setOrderNote(String orderNote) {
		this.orderNote = orderNote;
	}

	
	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public OrderInfo() {
		super();
	}

	public OrderInfo(Integer orderId) {
		super();
		this.orderId = orderId;
	}

	public OrderInfo(Integer orderId, StationInfo dotOriginalInfo,
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

