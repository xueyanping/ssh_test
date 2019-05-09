package com.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.test.dao.ITestDao;
import com.test.pojo.Student;
@Repository
public class TestDao extends HibernateDaoSupport implements ITestDao {

	@Resource	
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public Student get() {		
		List<Student> list = this.getHibernateTemplate().loadAll(Student.class);
		return list.get(0);
	}

}
