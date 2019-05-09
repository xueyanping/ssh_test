package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.cxf.service.ISurveyService;
import com.test.pojo.Student;
import com.test.service.ITestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:applicationContext.xml"})
public class TextAutoWired {

	@Autowired
	private ITestService testService;
	
	@Autowired
	private ISurveyService surveyService;
	
	@Test
	public void testAAA() {
		Student student = testService.get();
		System.out.println(student);
	}
	
	@Test
	public void testBBB() {
		// 1、定义调查投票的变量与内容，用来发送给服务
				String username = "Test";
				int point = 88;
				// 调用方法进行服务消费
				String result = surveyService.vote(username, point);
				System.out.println("Result:" + result);
				// 2、传递不一样的调查投票内容
				username = "Michael";
				point = 100;
				// 再次调用方法进行服务消费，得到不一样的结果
				result = surveyService.vote(username, point);
				System.out.println("Result:" + result);
				// 3、第三次传递与调用
				username = "Jordan";
				point = 9;
				result = surveyService.vote(username, point);
				System.out.println("Result:" + result);
			}
	
}
