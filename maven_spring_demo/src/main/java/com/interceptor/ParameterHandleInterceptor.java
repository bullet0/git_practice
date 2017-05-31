package com.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ParameterHandleInterceptor extends AbstractInterceptor {


	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("拦截器预处理：准备拦截器处理date日期转换，最后使用了s:date标签");
		//获取ActionContext
//		ActionContext context = arg0.getInvocationContext();
//		context.put("", "");
		String invoke = arg0.invoke();
		System.out.println("拦截器后处理：准备拦截器处理date日期转换，最后使用了s:date标签");
		return invoke;
	}

}
