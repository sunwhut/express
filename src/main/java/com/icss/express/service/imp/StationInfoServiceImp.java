package com.icss.express.service.imp;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icss.express.dao.BaseDAO;
import com.icss.express.po.StationInfo;
import com.icss.express.service.StationInfoService;
import com.icss.express.vo.StationInfoVO;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月9日,上午10:40:08
 *function:
 * 
 */
@Service
public class StationInfoServiceImp implements StationInfoService {
	
	@Autowired 
	private BaseDAO<StationInfo> baseDAO;
	
//	private StationInfo vo2po(StationInfoVO stationInfoVO) {
//		StationInfo stationInfo = new StationInfo();
//		BeanUtils.copyProperties(stationInfoVO, stationInfo);
//		return stationInfo;
//	}
//	
//	private StationInfoVO po2vo(StationInfo stationInfo) {
//		StationInfoVO stationInfoVO = new StationInfoVO();
//		BeanUtils.copyProperties(stationInfo, stationInfoVO);
//		return stationInfoVO;
//	}

	@Override
	public void addStation(StationInfoVO stationInfoVO) {
		// TODO Auto-generated method stub
		StationInfo stationInfo = new StationInfo();
		BeanUtils.copyProperties(stationInfoVO,stationInfo);
		baseDAO.save(stationInfo);
		
	}

	@Override
	public void modifyStation(StationInfoVO stationInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStation(StationInfoVO stationInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StationInfoVO getStationInfo(Integer stationId) {
		// TODO Auto-generated method stub
		StationInfoVO stationInfoVO = new StationInfoVO();
		StationInfo stationInfo = baseDAO.get(StationInfo.class, stationId);
		System.out.println("我取到了" + stationInfo.getStationName());
		BeanUtils.copyProperties(stationInfo,stationInfoVO);
		System.out.println("我变形了");
		return stationInfoVO;
	}

	@Override
	public List<StationInfoVO> getStotageByStationType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStationIdByTypeAndShi(String shi, int stationTypeId) {
		// TODO Auto-generated method stub
		String hql = "from StationInfo as t where t.stationShi='" + shi
				+ "' and t.stationType.stationTypeId=" + stationTypeId;
		StationInfo stationInfo = baseDAO.get(hql);
		StationInfoVO stationInfoVO = new StationInfoVO();
		BeanUtils.copyProperties(stationInfo,stationInfoVO);
		return stationInfoVO.getStationId();
	}

	@Override
	public int getStationIdByUserId(int userId) {
		// TODO Auto-generated method stub
		String hql = "from StationInfo as t where t.userInfo.userId=?";
		StationInfo stationInfo = baseDAO.get(hql, userId);
		return stationInfo.getStationId();
	}

}
