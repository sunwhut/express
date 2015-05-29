package com.icss.express.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.TestSupport;
import com.icss.express.vo.DotInfoVO;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月13日,下午1:32:55
 *function:
 * 
 */
public class DotInfoServiceTest extends TestSupport {
	
	@Autowired
	private DotInfoService service;
	
	@Test
	public void testGet() {
		//fail
		DotInfoVO dotInfo = service.getDotInfo(2);
		System.out.println(dotInfo.getDotQu());
	}

}
