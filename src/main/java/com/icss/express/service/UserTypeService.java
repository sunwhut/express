package com.icss.express.service;

import java.util.List;

import com.icss.express.po.UserInfo;
import com.icss.express.po.UserType;
import com.icss.express.vo.UserTypeVO;

public interface UserTypeService {

	/**
	 * 根据用户类型标识获取用户信息
	 * @param userTypeId
	 * @return
	 */
	UserTypeVO get(int userTypeId);
	
	/**
	 * 返回所有用户类型信息
	 * @return
	 */
	List<UserTypeVO> listAll();
}
