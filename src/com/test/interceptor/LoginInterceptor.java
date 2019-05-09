package com.test.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.test.pojo.Student;

public class LoginInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
	
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Student userName = (Student) getSession().getAttribute("student");
		if(userName!=null) {
			return invocation.invoke();
		}else {
			return "index";
		}
		
	}

}
