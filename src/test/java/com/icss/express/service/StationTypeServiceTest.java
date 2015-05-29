package com.icss.express.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.TestSupport;
import com.icss.express.vo.StationTypeVO;
import com.icss.express.vo.UserTypeVO;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月13日,下午3:41:56
 *function:
 * 
 */
public class StationTypeServiceTest extends TestSupport {
	@Autowired
	private StationTypeService service;
	
	@Test
	public void testGet() {
		//success
		StationTypeVO stationType = service.getStationType(1);
		Assert.assertNotNull(stationType);
		System.out.println(stationType.getStationTypeName());
	}
	
	@Test
	public void testListAll() {
		//success
		List<StationTypeVO> list = service.listAll();
		Assert.assertNotNull(list);
		for(StationTypeVO vo : list){
			System.out.println(vo.getStationTypeId()+"\t"+vo.getStationTypeName());
		}
	}

}
