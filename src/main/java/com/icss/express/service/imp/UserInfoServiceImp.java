package com.icss.express.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icss.express.dao.BaseDAO;
import com.icss.express.po.UserInfo;
import com.icss.express.po.UserType;
import com.icss.express.service.UserInfoService;
import com.icss.express.vo.HqlVO;
import com.icss.express.vo.UserInfoVO;


/**
 * 
 * @author 
 *
 */
@Service
public class UserInfoServiceImp implements UserInfoService {

	@Autowired
	private BaseDAO<UserInfo> baseDAO;
	
	private UserInfoVO po2vo(UserInfo userInfo){
		UserInfoVO infoVO = new UserInfoVO();
		BeanUtils.copyProperties(userInfo, infoVO);
		BeanUtils.copyProperties(userInfo.getUserType(), infoVO);
		return infoVO;
	}
	
	
	
	@Override
	public void add(UserInfoVO userInfo){
		try{
			UserInfo userInfo1 = new UserInfo();
			BeanUtils.copyProperties(userInfo, userInfo1);
			userInfo1.setCreateTime(new Date());
			userInfo1.setUserType(new UserType(userInfo.getUserTypeId()));
			baseDAO.save(userInfo1);
		}catch(Throwable ex){
			ex.printStackTrace();
			//throw new Exception("用户名重复");
		}
	}

	@Override
	public UserInfoVO login(String userName, String userPwd) throws Exception {
		
		UserInfo userinfo = null;
		try {
			userinfo = baseDAO.get("from UserInfo as t where t.userName=?", userName);
		} catch (Throwable e) {
			throw new Exception("用户不存在", e);
		}
		
		if(userinfo.getUserPwd().equals(userPwd)){
			return po2vo(userinfo);
		}else{
			throw new Exception("密码错误");
		}
	}

	@Override
	public void modify(UserInfo userInfo) {
		baseDAO.update(userInfo);
	}

	@Override
	public void delete(Integer userId) {
		UserInfo userInfo = baseDAO.get(UserInfo.class, userId);
		userInfo.setIsDelete(true);
		baseDAO.update(userInfo);
	}
	

	@Override
	public void modifyUserPwd(int userId, String userPwdOld, String userPwdNew)
			throws Exception {
		UserInfo userInfo = baseDAO.get(UserInfo.class, userId);
		if(!userInfo.getUserPwd().equals(userPwdOld)){
			throw new Exception("旧密码不正确");
		}
		userInfo.setUserPwd(userPwdNew);
		baseDAO.update(userInfo);
	}

	@Override
	public UserInfoVO get(int userId) {
		return po2vo(baseDAO.get(UserInfo.class, userId));
	}

	@Override
	public UserInfoVO getUserByUserName(String userName) throws Exception {
		return po2vo(baseDAO.get("from UserInfo as t where t.userName=?", userName));
	}

	@Override
	public void modifyUserPwd(int userId, String userPwd) {
		UserInfo userInfo = baseDAO.get(UserInfo.class, userId);
		userInfo.setUserPwd(userPwd);
		baseDAO.update(userInfo);
	}

	@Override
	public List<UserInfoVO> list(String key, int userTypeId, int pagination,
			int rowMax) {
		HqlVO vo = formatHQL(key, userTypeId);
		List<UserInfo> list = baseDAO.find(vo.getHql()+" order by t.createTime desc", vo.getParams(), pagination, rowMax);
		List<UserInfoVO> list1 = new ArrayList<UserInfoVO>();
		for(UserInfo info : list){
			list1.add(po2vo(info));
		}
		return list1;
	}

	@Override
	public Long count(String key, int userTypeId) {
		HqlVO vo = formatHQL(key, userTypeId);
		return baseDAO.count("select count(*) "+vo.getHql(), vo.getParams());
	}
	
	/**
	 * 格式化基本的hql和参数
	 * @param key
	 * @param userTypeId
	 * @return 保存了基本的hql语句和map参数的vo对象
	 */
	public HqlVO formatHQL(String key, int userTypeId){
		HqlVO vo = new HqlVO();
		
		vo.add("from UserInfo as t where t.isDelete=false");
		
		if(key!=null&&(!"".equals(key))){
			vo.add("and (t.userName like :key or t.userRealName like :key)");
			vo.put("key", "%"+key+"%");
		}
		
		if(userTypeId>0){
			vo.add("and t.userType.userTypeId=:userTypeId");
			vo.put("userTypeId", userTypeId);
		}
		
		
		
		return vo;
	}

	/****************新增部分******************/

	@Override
	public List<UserInfoVO> getUserByUserType(int userTypeId) {
		// TODO Auto-generated method stub
		List<UserInfo> list = baseDAO.find("from UserInfo as t where t.userType.userTypeId=?", userTypeId);
		List<UserInfoVO> listVO = new ArrayList<UserInfoVO>();
		for(UserInfo info : list){
			listVO.add(po2vo(info));
		}
		return listVO;
	}
	
//	public static void main(String[] args){
//		System.out.println(new UserInfoServiceImp().formatHQL("", 1).getHql());
//	}
	

}
