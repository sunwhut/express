package com.icss.express.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.TestSupport;
import com.icss.express.po.StationType;
import com.icss.express.po.UserInfo;
import com.icss.express.vo.StationInfoVO;
import com.icss.express.vo.StationTypeVO;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月13日,下午1:44:22
 *function:
 * 
 */
public class StationInfoServiceTest extends TestSupport {
	@Autowired
	private StationInfoService service;
	
	@Test
	public void testGet() {
		//fail
		//success
		StationInfoVO info = service.getStationInfo(1);
		Assert.assertNotNull(info);
		System.out.println("qian " + info.getStationName() + " hou");
	}
	
	@Test
	public void testAdd() {
		//success
		StationInfoVO infoVO = new StationInfoVO();
		infoVO.setStationId(100);
		infoVO.setStationType(new StationType(1));
		infoVO.setUserInfo(new UserInfo(11));
		service.addStation(infoVO);
	}
	
	@Test
	public void testGetStationIdByTypeAndShi() {
		//success
		System.out.println(service.getStationIdByTypeAndShi("天津", 2));
	}
	
	@Test
	public void testGetStationIdByUserId() {
		//success
		System.out.println(service.getStationIdByUserId(3));
	}
	

}
