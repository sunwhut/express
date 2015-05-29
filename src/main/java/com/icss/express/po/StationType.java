package com.icss.express.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月9日,下午10:46:38
 *function:
 * 
 */

@SuppressWarnings("serial")
@Entity
@Table(name="station_type")
public class StationType  implements Serializable{
	
	@Id
	@Column(name="station_type_id",nullable=false,unique=true)
	private Integer stationTypeId;
	
	@Column(name="station_type_name",length=32)
	private String stationTypeName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "stationType")
	private Set<StationInfo> stationInfos = new HashSet<StationInfo>(0);

	public Integer getStationTypeId() {
		return stationTypeId;
	}

	public void setStationTypeId(Integer stationTypeId) {
		this.stationTypeId = stationTypeId;
	}

	public String getStationTypeName() {
		return stationTypeName;
	}

	public void setStationTypeName(String stationTypeName) {
		this.stationTypeName = stationTypeName;
	}

	public Set<StationInfo> getStationInfos() {
		return stationInfos;
	}

	public void setStationInfos(Set<StationInfo> stationInfos) {
		this.stationInfos = stationInfos;
	}

	public StationType() {
		super();
	}

	public StationType(Integer stationTypeId) {
		super();
		this.stationTypeId = stationTypeId;
	}

	public StationType(Integer stationTypeId, String stationTypeName,
			Set<StationInfo> stationInfos) {
		super();
		this.stationTypeId = stationTypeId;
		this.stationTypeName = stationTypeName;
		this.stationInfos = stationInfos;
	}
	
	

}
