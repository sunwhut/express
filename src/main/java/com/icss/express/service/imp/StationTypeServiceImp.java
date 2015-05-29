package com.icss.express.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icss.express.dao.BaseDAO;
import com.icss.express.po.StationType;
import com.icss.express.service.StationTypeService;
import com.icss.express.vo.StationTypeVO;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月13日,下午3:36:26
 *function:
 * 
 */
@Service
public class StationTypeServiceImp implements StationTypeService {
	
	@Autowired
	private BaseDAO<StationType> baseDAO;

	@Override
	public StationTypeVO getStationType(Integer stationTypeId) {
		// TODO Auto-generated method stub
		StationType stationType = null;
		stationType = baseDAO.get(StationType.class, stationTypeId);
		StationTypeVO vo = new StationTypeVO();
		BeanUtils.copyProperties(stationType,vo);
		return vo;
	}

	@Override
	public List<StationTypeVO> listAll() {
		// TODO Auto-generated method stub
		List<StationType> list = baseDAO.find("from StationType");
		List<StationTypeVO> listVO = new ArrayList<StationTypeVO>();
		for(StationType stationType:list) {
			StationTypeVO vo = new StationTypeVO();
			BeanUtils.copyProperties(stationType,vo);
			listVO.add(vo);
		}
		return listVO;
	}

}
