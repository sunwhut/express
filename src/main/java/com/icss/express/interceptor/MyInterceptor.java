package com.icss.express.interceptor;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;






import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.Const;
import com.icss.express.actions.ActionSupport;
import com.icss.express.service.UserInfoService;
import com.icss.express.vo.UserInfoVO;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class MyInterceptor implements Interceptor {
	

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
	}

	@Autowired
	private UserInfoService service;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		HttpServletRequest request= (HttpServletRequest) arg0.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		
		request.setCharacterEncoding("UTF-8");
		HttpServletResponse response = (HttpServletResponse) arg0.getInvocationContext().get(StrutsStatics.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");


		
		if("GET".equals(request.getMethod().toUpperCase())){
			@SuppressWarnings("unchecked")
			Iterator<String[]> iter=request.getParameterMap().values().iterator();
		      while(iter.hasNext()){
			       String[] parames=iter.next();
			       for (int i = 0; i < parames.length; i++) {
				       try {
				        	parames[i]=new String(parames[i].getBytes("iso8859-1"),"UTF-8");
				       } catch (UnsupportedEncodingException e) {
				         e.printStackTrace();
				       }
			       } 
		      }
		}
		
		
		if(arg0.getAction() instanceof ActionSupport){
			UserInfoVO userVO = (UserInfoVO)request.getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY);
			/**
			 * 开发阶段加的测试登录的用户
			 */
			if(userVO==null){
				userVO = service.getUserByUserName("admin");
				request.getSession().setAttribute(Const.LOGIN_USER_SESSION_KEY, userVO);
			}
			((ActionSupport)arg0.getAction()).setUser(userVO);
		}
		
		
		
		return arg0.invoke();
	}


	

}
