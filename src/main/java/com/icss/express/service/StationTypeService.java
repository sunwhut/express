package com.icss.express.service;

import java.util.List;

import com.icss.express.vo.StationTypeVO;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月12日,上午9:05:05
 *function:
 * 
 */
public interface StationTypeService {
	
	/**
	 * 根据站点id获取站点类型
	 * @param statinTypeId
	 * @return
	 */
	StationTypeVO getStationType(Integer statinTypeId);
	
	/**
	 * 列出所有站点类型信息
	 * @return
	 */
	List<StationTypeVO> listAll();

}
