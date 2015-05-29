package com.icss.express.vo;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.icss.express.po.StationType;
import com.icss.express.po.UserInfo;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月12日,上午9:02:06
 *function:
 * 
 */
public class StationInfoVO {
	
	private Integer stationId;
	
	private String stationName;
	
	private String stationSheng;
	
	private String stationShi;
	
	private String stationAddr;
	
	private UserInfo userInfo;
	
	private StationType stationType;

	public Integer getStationId() {
		return stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStationSheng() {
		return stationSheng;
	}

	public void setStationSheng(String stationSheng) {
		this.stationSheng = stationSheng;
	}

	public String getStationShi() {
		return stationShi;
	}

	public void setStationShi(String stationShi) {
		this.stationShi = stationShi;
	}

	public String getStationAddr() {
		return stationAddr;
	}

	public void setStationAddr(String stationAddr) {
		this.stationAddr = stationAddr;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public StationType getStationType() {
		return stationType;
	}

	public void setStationType(StationType stationType) {
		this.stationType = stationType;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public StationInfoVO() {
		super();
	}

	public StationInfoVO(Integer stationId) {
		super();
		this.stationId = stationId;
	}

	public StationInfoVO(Integer stationId, String stationName,
			String stationSheng, String stationShi, String stationAddr,
			UserInfo userInfo, StationType stationType) {
		super();
		this.stationId = stationId;
		this.stationName = stationName;
		this.stationSheng = stationSheng;
		this.stationShi = stationShi;
		this.stationAddr = stationAddr;
		this.userInfo = userInfo;
		this.stationType = stationType;
	}

	
	
	

}
