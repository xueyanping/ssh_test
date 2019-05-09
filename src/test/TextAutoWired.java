package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.pojo.Student;
import com.test.service.ITestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:applicationContext.xml"})
public class TextAutoWired {

	@Autowired
	private ITestService testService;
	
	@Test
	public void testAAA() {
		Student student = testService.get();
		System.out.println(student);
	}
}
