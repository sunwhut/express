package com.icss.express;

import java.util.ArrayList;
import java.util.List;

import com.icss.express.vo.OrderInfoVO;
import com.icss.express.vo.UserInfoVO;

/**
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月14日,下午8:55:18
 *function:
 * 
 */
public class Tools {
	
	/***********f分割数据用于分页************/
	public static List<UserInfoVO> userPaging(List<UserInfoVO> userList,int  pagination,int rowMax){
		List<UserInfoVO> userResult = new ArrayList<UserInfoVO>();
		int first = rowMax * (pagination - 1);
		int last = first + rowMax - 1;
		for (int i = first; i <= last && i < userList.size(); i++ ) {
			userResult.add(userList.get(i));
		}
		
		return userResult;		
	}
	
	public static List<OrderInfoVO> orderPaging(List<OrderInfoVO> orderList,int  pagination,int rowMax){
		List<OrderInfoVO> orderResult = new ArrayList<OrderInfoVO>();
		int first = rowMax * (pagination - 1);
		int last = first + rowMax - 1;
		for (int i = first; i <= last && i < orderList.size(); i++ ) {
			orderResult.add(orderList.get(i));
		}
		
		return orderResult;
	}

}
