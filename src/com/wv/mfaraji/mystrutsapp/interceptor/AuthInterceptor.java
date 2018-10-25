package com.wv.mfaraji.mystrutsapp.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.wv.mfaraji.mystrutsapp.model.User;
import com.opensymphony.xwork2.Action;

public class AuthInterceptor implements  Interceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {}

	@Override
	public void init() {}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
//		Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().get("session");
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		User authenticateUser = (User) session.get("authenticatedUser");
		
		if(authenticateUser == null) 
		{
			return Action.LOGIN;
		}
//		else 
//		{
//			Action action = (Action) actionInvocation.getAction();
//			if(action instanceof UserAware){
//				((UserAware) action).setUser(user);
//			}
//			return actionInvocation.invoke();
//		}
		
		return actionInvocation.invoke();
	}

}
