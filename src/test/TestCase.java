package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.exception.ServiceException;
import com.test.pojo.Student;
import com.test.pojo.Teacher;
import com.test.service.ITestService;
import com.test.utils.HibernateUtil;

public class TestCase {
/*
	@Test
	public void insert() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student s1 = new Student();
		s1.setName("xue");
		s1.setAge(23);
		s1.setSex("male");
		Teacher teacher = session.get(Teacher.class,"297efa286a6278fb016a6278fd900000");
		s1.setTeacher(teacher);
		session.save(s1);
		//session.save(t1);
		transaction.commit();
		session.close();		
	}
	/*
	@Test
	public void insert2() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student s2 = new Student();
		s2.setName("马云");
		s2.setAge(48);
		s2.setSex("male");
		
		Teacher t2 = new Teacher();
		t2.setName("马老师");
		t2.setSex("male");
		t2.settCourse("English");		
		
		t2.getStudent().add(s2);
		session.save(t2);
		
		transaction.commit();
		session.close();		
	}
	
	@Test
	public void select() {
		Session session = HibernateUtil.getSession();
		//Transaction transaction = session.beginTransaction();
		//Query query = session.createQuery("from Student c order by c.id desc");
		Query query = session.createQuery("from Student s join fetch s.teacher order by s.id desc");
		List<Student> list = query.list();
		System.out.println("size=="+list.size());
		for (Student student : list) {
			System.out.println(student);
		}
		session.close();
	}
	*/
	
	@Test
	public void getBeanTest() throws ServiceException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ITestService testService = context.getBean(ITestService.class);
		System.out.println(testService.get());
	}
	
	
}
