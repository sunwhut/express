package com.icss.express.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icss.express.dao.BaseDAO;
import com.icss.express.po.UserInfo;
import com.icss.express.po.UserType;
import com.icss.express.service.UserTypeService;
import com.icss.express.vo.UserTypeVO;

@Service
public class UserTypeServiceImp implements UserTypeService {

	@Autowired
	private BaseDAO<UserType> baseDAO;
	@Override
	public UserTypeVO get(int userTypeId) {
		UserType userType = null;
		userType = baseDAO.get(UserType.class, userTypeId);
//		userType = baseDAO.get("from UserType as a where a.userTypeId=?", userTypeId);
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("userTypeId", userTypeId);
//		userType = baseDAO.get("from UserType as a where a.userTypeId=:userTypeId", map);
	
		UserTypeVO vo = new UserTypeVO();
//		vo.setUserTypeId(userType.getUserTypeId());
//		vo.setUserTypeName(userType.getUserTypeName());
		BeanUtils.copyProperties(userType, vo);
		return vo;
	}

	@Override
	public List<UserTypeVO> listAll() {
		List<UserType> list = baseDAO.find("from UserType");
		List<UserTypeVO> list1 = new ArrayList<UserTypeVO>();
		for(UserType userType:list){
			UserTypeVO vo = new UserTypeVO();
			BeanUtils.copyProperties(userType, vo);
			list1.add(vo);
		}
		return list1;
	}

}
