package com.icss.express.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月8日,下午3:31:09
 *function:表-网点的内容
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="dot_info")
public class DotInfo implements Serializable {
//	@GenericGenerator(name = "generator", strategy = "increment")
//	@GeneratedValue(generator = "generator")
	@Id
	@Column(name="dot_id",nullable=false,unique=true)
	private Integer dotId;
	
	
	@Column(name="dot_qu",nullable=false,unique=true)
	private String dotQu;     //网点的县
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dot_storage_id")//定义对一的时候，一端在本表中的列名
	private StationInfo stationInfo;


	public Integer getDotId() {
		return dotId;
	}


	public void setDotId(Integer dotId) {
		this.dotId = dotId;
	}


	public String getDotQu() {
		return dotQu;
	}


	public void setDotQu(String dotQu) {
		this.dotQu = dotQu;
	}


	public StationInfo getStationInfo() {
		return stationInfo;
	}


	public void setStationInfo(StationInfo stationInfo) {
		this.stationInfo = stationInfo;
	}


	public DotInfo() {
		super();
	}


	public DotInfo(Integer dotId) {
		super();
		this.dotId = dotId;
	}


	public DotInfo(Integer dotId, String dotQu, StationInfo stationInfo) {
		super();
		this.dotId = dotId;
		this.dotQu = dotQu;
		this.stationInfo = stationInfo;
	}

	
	

}
