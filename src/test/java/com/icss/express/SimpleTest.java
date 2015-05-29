package com.icss.express;

import java.util.Date;
import java.util.UUID;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.icss.express.dao.BaseDAO;
import com.icss.express.po.UserInfo;
import com.icss.express.po.UserType;
import com.icss.express.service.UserInfoService;

public class SimpleTest extends TestSupport {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BaseDAO<UserInfo> baseDAO;
	
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 测试数据源是否连接成功
	 */
	@Test
	public void testDataSourceCreate(){
		System.out.println(UUID.randomUUID().toString());
//		System.out.println(dataSource);
		Assert.assertNotNull(dataSource);
		
	}
	
	/**
	 * 测试对用户信息的基本操作
	 */
	@Test
//	@Transactional
	public void testUserInfo(){
//		UserInfo userInfo = new UserInfo(1, "test3", "123", "超级管理员", true,null,null,null,null);
//		userInfo.setUserType(new UserType(2));
//		userInfo.setCreateTime(new Date());
//		//baseDAO.save(userInfo);
//		userInfoService.add(userInfo);
		
//		UserInfo info = baseDAO.get(UserInfo.class, 3);
//		System.out.println(info.getUserName());
//		System.out.println(info.getUserType().getUserTypeName());
	}

}
