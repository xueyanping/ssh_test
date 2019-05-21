package com.test.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import org.apache.commons.io.FileUtils;
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
import com.test.utils.UploadUtils;

@Controller
@Scope("prototype")
public class DemoAction extends ActionSupport implements ModelDriven<Student> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ITestService testService;

	@Autowired
	private ISurveyService surveyService;

	// 上传文件属性驱动
	private File[] upload;
	private String[] uploadContentType;
	private String[] uploadFileName;

	// 下载
	//private InputStream inputStream;
	//private String filename;
	
	//获取到流后自动调用getFilename方法，以返回的字符串作为要下载的文件的文件名
	public String getFilename() {
		String filename=ServletActionContext.getRequest().getParameter("filename");
		return filename;
	}

	public InputStream getInputStream() throws FileNotFoundException {
		String filename=ServletActionContext.getRequest().getParameter("filename");
		String webappsDir = ServletActionContext.getServletContext().getRealPath("");
		webappsDir = webappsDir.substring(0, webappsDir.lastIndexOf("\\"));
		//要使用此方法获取输入流需要 要下载的文件要位于Webcontent目录下，否则用new FileInputStream新建流
		//inputStream = ServletActionContext.getServletContext().getResourceAsStream(webappsDir+"\\upload\\"+filename);
		InputStream inputStream = new FileInputStream(new File(webappsDir+"\\upload\\"+filename));		
		return inputStream;		
	}

//	public void setInputStream(InputStream inputStream) {
//		this.inputStream = inputStream;
//	}

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
		System.out.println("result===" + surveyService.vote("Macile", 20));
		try {
			testService.get();
		} catch (ServiceException e) {
			throw new ActionException("action出现异常" + e.getMessage());
		}
		// System.out.println(testService.get());
		// shiro认证成功后保存上传的文件
		for (int i = 0; i < upload.length; i++) {
			// 生成文件唯一名称
			String uuidName = UploadUtils.getUUIDName(uploadFileName[i]);
			// 保存文件至upload文件夹
			FileInputStream fis = null;
			FileOutputStream fos = null;
//			InputStreamReader reader = null;
//			BufferedReader bfr = null;
			try {
				// fis = new FileInputStream(upload[i]);
//				reader = new InputStreamReader(fis);
//				bfr = new BufferedReader(reader);
				ServletContext context = ServletActionContext.getServletContext();
				// 获取webpps目录路径
				String path = context.getRealPath("");
				// 去掉项目名，将上传文件的文件夹放在与项目平级的目录中
				path = path.substring(0, path.lastIndexOf("\\"));
				// 上传文件的文件夹路径
				path = path + "\\" + "upload";
				File file = new File(path);
				if (!file.exists()) {
					file.createNewFile();
				}
				System.out.println(file.getPath());
				FileUtils.moveFile(upload[i], new File(path, uuidName));
				// fos = new FileOutputStream(new File(path+"\\"+uuidName));
//				byte[] b = new byte[1024];
//				int bt = -1;
//				while((bt = fis.read(b))!=-1) {
//				fos.write(b, 0, bt);	
//				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
//				if(fos!=null) {
//					try {
//						fos.close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}

//				if(fis!=null) {
//					try {
//						fis.close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
			}
		}
		return "success";
	}

	// @RequiresPermissions("list")
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
		s.setTeacher(teacher);
		context.put("s", s);
		return "list";
	}

	// 下载
	public String doDownload() {

		return "downloadStart";
	}


	public String testInterceptor() {
		return "success";
	}

	@Override
	public Student getModel() {
		return student;
	}

}
