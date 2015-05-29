package com.icss.express.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.icss.express.vo.DotInfoVO;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月9日,上午9:20:02
 *function:
 * 
 */
public interface DotInfoService {
	
	void addDot(DotInfoVO dotInfo);
	
	void modifyDot(DotInfoVO dotInfo);
	
	void deleteDot(DotInfoVO dotInfo);
	
	/**
	 * 根据网点id获取网点信息
	 * @param dotId
	 * @return
	 */
	DotInfoVO getDotInfo(Integer dotId);
	/**
	 * 获取所有网点信息
	 * @param stationType
	 * @return
	 */
	List<DotInfoVO> getDotByStationType();

}
