package com.icss.express.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.json.JSONUtil;

import com.icss.express.vo.UserInfoVO;
import com.opensymphony.xwork2.ActionContext;





@SuppressWarnings("serial")
@ParentPackage("my-default")
public abstract class ActionSupport extends com.opensymphony.xwork2.ActionSupport {
	
	public static final String JSON = "json";
	
	protected UserInfoVO user;
	
	public void setUser(UserInfoVO user){
		this.user = user;
	}

	public String execute(){
		return JSON;
	}
	
	
	/**
	 * 格式化JSON list
	 * @param list
	 * @return null
	 * @throws IOException
	 * @throws Exception 
	 */
	public String json(List<?> list){
		try{
			ServletActionContext.getResponse().getWriter().print(JSONUtil.serialize(list));
			ServletActionContext.getResponse().getWriter().flush();
			return null;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

	
	
	/**
	 * 格式化输出JSON Object
	 * @param map
	 * @return null
	 * @throws Exception
	 */
	public String json(Object map){
		try{
			ServletActionContext.getResponse().getWriter().print(JSONUtil.serialize(map));
			return null;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public String json(){
		try{
			ServletActionContext.getResponse().getWriter().print("{}");
			return null;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 请求转发到Action
	 * @param uri
	 * @return
	 */
	public String forwardAction(String uri){
		uri = ("/"+uri).replaceAll("[\\\\/]+", "/");
		if(uri.indexOf("/")>-1){
			String actionName = uri.substring(uri.lastIndexOf("/")+1);
			String namespace = uri.substring(0,uri.lastIndexOf("/"));
			if("".equals(namespace)){
				namespace="/";
			}
			ActionContext.getContext().put("_actionName", actionName);
			ActionContext.getContext().put("_namespace", namespace);
		}else{
			ActionContext.getContext().put("_actionName", uri);
			ActionContext.getContext().put("_namespace", "/");
		}
		return "forwardAction";
	}

	/**
	 * 响应重定向到Action
	 * @param uri
	 * @return
	 */
	public String redirectAction(String uri){
		uri = ("/"+uri).replaceAll("[\\\\/]+", "/");
		if(uri.indexOf("/")>-1){
			String actionName = uri.substring(uri.lastIndexOf("/")+1);
			String namespace = uri.substring(0,uri.lastIndexOf("/"));
			if("".equals(namespace)){
				namespace="/";
			}
			ActionContext.getContext().put("_actionName", actionName);
			ActionContext.getContext().put("_namespace", namespace);
		}else{
			ActionContext.getContext().put("_actionName", uri);
			ActionContext.getContext().put("_namespace", "/");
		}
		return "redirectAction";
	}
	
	/**
	 * 响应重定向到某个资源
	 * @param uri
	 * @return
	 */
	public String redirect(String uri){
		ActionContext.getContext().put("_redirect", uri);
		return "redirect";
	}
	
	/**
	 * 请求转发到某个资源
	 * @param uri
	 * @return
	 */
	public String forward(String uri){
		ActionContext.getContext().put("_forward", uri);
		return "redirect";
	}
	
	
	/**
	 * 禁止浏览器缓存
	 */
	public void setExpires(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires",Integer.MIN_VALUE);
	}
	
	public String sendError(int errorCode){
		try {
			ServletActionContext.getResponse().sendError(errorCode);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return null;
	}
	
}
