package com.icss.express.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月8日,下午3:17:13
 *function:表-仓库的内容
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="station_info")
public class StationInfo implements Serializable {
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Id
	@Column(name="station_id",nullable=false,unique=true)
	private Integer stationId;
	
	@Column(name="station_name",length=40)
	private String stationName;
	
	@Column(name="station_sheng")
	private String stationSheng;
	
	@Column(name="station_shi")
	private String stationShi;
	
	@Column(name="station_addr",length=80)
	private String stationAddr;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "station_admin_id")
	private UserInfo userInfo;
	
	/**
	 * 对一
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "station_type_id")//定义对一的时候，一端在本表中的列名
	private StationType stationType;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "stationInfo")
	private Set<DotInfo> dotInfos = new HashSet<DotInfo>(0);

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
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

	public Set<DotInfo> getDotInfos() {
		return dotInfos;
	}

	public void setDotInfos(Set<DotInfo> dotInfos) {
		this.dotInfos = dotInfos;
	}

	public StationInfo() {
		super();
	}

	public StationInfo(Integer stationId) {
		super();
		this.stationId = stationId;
	}

	public StationInfo(Integer stationId, String stationName,
			String stationSheng, String stationShi, String stationAddr,
			UserInfo userInfo, StationType stationType, Set<DotInfo> dotInfos) {
		super();
		this.stationId = stationId;
		this.stationName = stationName;
		this.stationSheng = stationSheng;
		this.stationShi = stationShi;
		this.stationAddr = stationAddr;
		this.userInfo = userInfo;
		this.stationType = stationType;
		this.dotInfos = dotInfos;
	}
	
	


	

}
