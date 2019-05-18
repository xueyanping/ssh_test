package com.test.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.ActionError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.cxf.service.ISurveyService;
import com.test.exception.ActionException;
import com.test.exception.ServiceException;
import com.test.pojo.Student;
import com.test.pojo.Teacher;
import com.test.service.ITestService;

@Controller
@Scope("prototype")
public class DemoAction extends ActionSupport implements ModelDriven<Student> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ITestService testService;
	
	@Autowired
	private ISurveyService surveyService;
	
	//上传文件属性驱动
	private File[] upload;
	private String[] uploadContentType;
	private String[] uploadFileName;


	

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	Student student = new Student();

	public String index() throws ServiceException, ActionException {

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
		System.out.println("result==="+surveyService.vote("Macile", 20));
		try {
			testService.get();
		} catch (ServiceException  e) {
			throw new ActionException("action出现异常"+e.getMessage());
		}
		//System.out.println(testService.get());
		return "success";
	}

	//@RequiresPermissions("list")
	public String list() {
		ActionContext context = ActionContext.getContext();
		Student s = new Student();
		s.setName("李");
		s.setAge(23);
		s.setSex("female");
		Teacher teacher = new Teacher();
		teacher.setName("wang");
		teacher.setSex("female");
		teacher.settCourse("English");
		s.setTeacher(teacher );
		context.put("s",s);
		return "list";
	}
	
	
	public String testInterceptor() {
		return "success";
	}

	@Override
	public Student getModel() {
		return student;
	}

	
	

	
	
	
	
	

}
