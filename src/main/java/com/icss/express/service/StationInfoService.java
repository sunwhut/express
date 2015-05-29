package com.icss.express.service;

import java.util.List;

import com.icss.express.vo.StationInfoVO;


/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月9日,上午9:19:42
 *function:
 * 
 */
public interface StationInfoService {
	
	void addStation(StationInfoVO stationInfo);
	
	void modifyStation(StationInfoVO stationInfo);
	
	void deleteStation(StationInfoVO stationInfo);
	
	/**
	 * 根据仓库id获取仓库信息
	 * @param stationId
	 * @return
	 */
	StationInfoVO getStationInfo(Integer stationId);
	/**
	 * 获取所有仓库信息
	 * @param StationType
	 * @return
	 */
	List<StationInfoVO> getStotageByStationType();
	
	int getStationIdByTypeAndShi(String shi,int stationTypeId);
	
	int getStationIdByUserId(int userId);

}
