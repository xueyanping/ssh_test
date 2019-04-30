package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.ITestDao;
import com.test.pojo.Student;
import com.test.service.ITestService;
@Service
public class TestService implements ITestService{

	@Autowired
	private ITestDao testDao;
	
	@Override
	public Student get() {		
		return testDao.get();
	}

	
	
	
}
