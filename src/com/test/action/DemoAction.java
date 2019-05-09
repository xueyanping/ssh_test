package com.test.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.pojo.Student;
import com.test.service.ITestService;

@Controller
@Scope("prototype")
public class DemoAction extends ActionSupport implements ModelDriven<Student> {

	private static final long serialVersionUID = 1L;

	
	private ITestService testService;

	Student student = new Student();

	public String index() {

		// Student student = testService.get();
		System.out.println(student);

		if (student.getSex() == null || "".equals(student.getSex())) {
			return "error";
		}
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(student.getName(), student.getSex());
		try {
			// 执行认证操作.
			subject.login(token);
		} catch (AuthenticationException ae) {
			System.out.println("登陆失败: " + ae.getMessage());
			return "error";
		}

		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("student", student);
		System.out.println(testService.get());
		return "success";
	}

	@RequiresPermissions("list")
	public String list() {
		return "list";
	}
	
	
	public String testInterceptor() {
		return "success";
	}

	@Override
	public Student getModel() {
		return student;
	}

	@Autowired
	public void setTestService(ITestService testService) {
		this.testService = testService;
	}
	
	
	

}
