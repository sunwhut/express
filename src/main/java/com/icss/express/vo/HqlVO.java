package com.icss.express.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * 保存基本的hql语句和map参数的vo对象
 * @author J.L.Zhou
 *
 */
public class HqlVO {

	private String hql="";
	private Map<String, Object> params = new HashMap<String, Object>(0);
	
	public void add(String hql){
		this.hql += hql+" ";
	}
	public void put(String key,Object value){
		params.put(key, value);
	}
	
	public String getHql() {
		return hql.trim();
	}
	public void setHql(String hql) {
		this.hql = hql;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
}
