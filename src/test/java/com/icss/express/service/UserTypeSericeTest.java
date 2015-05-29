package com.icss.express.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.TestSupport;
import com.icss.express.po.UserInfo;
import com.icss.express.po.UserType;
import com.icss.express.vo.UserTypeVO;

public class UserTypeSericeTest extends TestSupport {

	@Autowired
	private UserTypeService service;
	
	@Test
	public void testGet(){
		UserTypeVO userType = service.get(1);
		Assert.assertNotNull(userType);
		System.out.println(userType.getUserTypeName());

//		userType = service.get(0);
//		Assert.assertNotNull(userType);
//		System.out.println(userType.getUserTypeName());
	}
	
	@Test
	public void testListAll(){
		List<UserTypeVO> list = service.listAll();
		Assert.assertNotNull(list);
		for(UserTypeVO vo : list){
			System.out.println(vo.getUserTypeId()+"\t"+vo.getUserTypeName());
		}
	}
}
