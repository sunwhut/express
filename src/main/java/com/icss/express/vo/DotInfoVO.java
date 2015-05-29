package com.icss.express.vo;

import com.icss.express.po.StationInfo;
import com.icss.express.po.StationType;
import com.icss.express.po.UserInfo;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月12日,上午9:09:08
 *function:
 * 
 */
public class DotInfoVO {
	
	private Integer dotId;
	
	private String dotQu;
	
	private StationInfo stationInfo;  //所属仓库信息,dot_storage_id

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

	public DotInfoVO() {
		super();
	}

	public DotInfoVO(Integer dotId) {
		super();
		this.dotId = dotId;
	}

	public DotInfoVO(Integer dotId, String dotQu, StationInfo stationInfo) {
		super();
		this.dotId = dotId;
		this.dotQu = dotQu;
		this.stationInfo = stationInfo;
	}
	
	
	

}
