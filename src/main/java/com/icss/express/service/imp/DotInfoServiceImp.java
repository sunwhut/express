package com.icss.express.service.imp;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icss.express.dao.BaseDAO;
import com.icss.express.po.DotInfo;
import com.icss.express.po.StationInfo;
import com.icss.express.service.DotInfoService;
import com.icss.express.vo.DotInfoVO;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月9日,上午10:39:36
 *function:
 * 
 */
@Service
public class DotInfoServiceImp implements DotInfoService {
	
	/**
	 * 网点信息由StationInfo和DotInfo共同组成
	 */
	@Autowired
	private BaseDAO<StationInfo> baseDAOStation;
	private BaseDAO<DotInfo> baseDAODot;
	
	private DotInfoVO po2vo(StationInfo stationInfo,DotInfo dotInfo) {
		DotInfoVO dotInfoVO = new DotInfoVO();
		BeanUtils.copyProperties(stationInfo,dotInfoVO);
		dotInfoVO.setDotQu(dotInfo.getDotQu());
		dotInfoVO.setStationInfo(dotInfo.getStationInfo());
		return dotInfoVO;
	}
	@Override
	public void addDot(DotInfoVO dotInfo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void modifyDot(DotInfoVO dotInfo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteDot(DotInfoVO dotInfo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public DotInfoVO getDotInfo(Integer dotId) {
		// TODO Auto-generated method stub
		DotInfoVO dotInfo = new DotInfoVO();
		dotInfo = po2vo(baseDAOStation.get(StationInfo.class,dotId),baseDAODot.get(DotInfo.class, dotId));
		return dotInfo;
	}
	@Override
	public List<DotInfoVO> getDotByStationType() {
		// TODO Auto-generated method stub
		return null;
	}

}
