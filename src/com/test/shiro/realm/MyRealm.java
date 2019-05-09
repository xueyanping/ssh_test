package com.test.shiro.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.test.pojo.Student;
import com.test.service.ITestService;

@Component("myRealm")
public class MyRealm extends AuthorizingRealm {

	@Autowired
	@Lazy
	private ITestService testService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("授权方法");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Object principal = SecurityUtils.getSubject().getPrincipal();
		 
		if(principal.equals("小李子")||principal.equals("邓学文")) {
			info.addStringPermission("list");
		}		
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("认证方法");
		UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
		String username = passwordToken.getUsername();
		if(username.equals("邓学文")) {
			AuthenticationInfo info = new SimpleAuthenticationInfo(username, "male", this.getName());
			return info;
		}
		return null;
	}

}
