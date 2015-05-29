package com.icss.express.service;

import java.util.List;

import org.apache.struts2.json.JSONUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.TestSupport;
import com.icss.express.po.UserInfo;
import com.icss.express.vo.UserInfoVO;

/**
 * 
 * @author J.L.Zhou
 *
 */
public class UserInfoServiceTest extends TestSupport {
	
	@Autowired
	private UserInfoService service;
	
	@Test
	public void testLogin(){
//		String userName="admin";
//		String userPwd="admin";
//		try {
//			UserInfo info = service.login(userName, userPwd);
//			Assert.assertNotNull(info);
//		} catch (Exception e) {
//			//Assert.assertEquals(e.getMessage(), "用户不存在");
//			e.printStackTrace();
//		}
//		
//		
//		userName="admin";
//		userPwd="admin1";
//		try {
//			UserInfo info = service.login(userName, userPwd);
//		} catch (Exception e) {
//			Assert.assertEquals(e.getMessage(), "密码错误");
//			e.printStackTrace();
//		}
//		
//		
//
//		
//		
//		userName="admin11";
//		userPwd="admin1";
//		try {
//			UserInfo info = service.login(userName, userPwd);
//		} catch (Exception e) {
//			Assert.assertEquals(e.getMessage(), "用户不存在");
//			e.printStackTrace();
//		}
		
	}
	
	@Test
	public void testCount(){
		System.out.println(service.count(null, 0));
		System.out.println(service.count("", 0));
		System.out.println(service.count("1", 0));
		System.out.println(service.count("零", 1));
	}

	@Test
	public void testList()throws Exception{
		List<UserInfoVO> list = service.list("零", 1, 1, 10);
		for(UserInfoVO vo : list){
			System.out.println(JSONUtil.serialize(vo));
		}
	}
	
	@Test
	public void testAdd()throws Exception {
		UserInfoVO userInfo = new UserInfoVO();
		userInfo.setUserName("admin");
		userInfo.setUserTypeId(1);
		service.add(userInfo);
	}
	
	
	/*********新增部分**********/
	@Test
	public void testGetUserByType() {
		//success
		List<UserInfoVO> list = service.getUserByUserType(2);
		for(UserInfoVO vo : list) {
			System.out.println(vo.getUserId());
		}
	}
	
	@Test
	public void testGetUserByName() {
		try {
			UserInfoVO userInfoVO = service.getUserByUserName("user02");
			System.out.println(userInfoVO.getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
