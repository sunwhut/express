package com.icss.express.service;

import java.util.List;

import com.icss.express.po.UserInfo;
import com.icss.express.vo.UserInfoVO;

/**
 * 
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月12日,上午10:40:26
 *function:跟用户相关的操作接口
 */
public interface UserInfoService {

	/**
	 * 添加用户
	 * @param userInfo
	 */
	void add(UserInfoVO userInfo);
	
	void modify(UserInfo userInfo);
	
	void delete(Integer userId);
	
	
	/**
	 * 根据用户主键获取用户信息
	 * @param userId
	 * @return
	 */
	UserInfoVO get(int userId);
	/**
	 * 根据用户名获取用户
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	UserInfoVO getUserByUserName(String userName) throws Exception;
	/**
	 * 
	 * @param userName
	 * @param userPwd
	 * @return
	 * @throws Exception
	 */
	UserInfoVO login(String userName,String userPwd)throws Exception;
	
	/**
	 * 修改用户密码
	 * @param userId
	 * @param userPwdOld
	 * @param userPwdNew
	 * @throws Exception
	 */
	void modifyUserPwd(int userId,String userPwdOld,String userPwdNew)throws Exception;
	
	/**
	 * 重设用户密码
	 * @param userId
	 * @param userPwd
	 */
	void modifyUserPwd(int userId,String userPwd);
	
	/**
	 * 获取分页数据
	 * @param key
	 * @param userTypeId
	 * @param pagination
	 * @param rowMax
	 * @return
	 */
	List<UserInfoVO> list(String key,int userTypeId,int pagination,int rowMax);
	
	/**
	 * 获取统计数据
	 * @param key
	 * @param userTypeId
	 * @return
	 */
	Long count(String key,int userTypeId);
	
	/********************新增部分*********************/
	/**
	 * 根据用户类型获取用户信息
	 * @param userTypeId
	 * @return
	 */
	List<UserInfoVO> getUserByUserType(int userTypeId);
}
