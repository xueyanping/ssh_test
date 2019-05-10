package com.test.service;

import com.test.exception.ServiceException;
import com.test.pojo.Student;

public interface ITestService {

	public Student get() throws ServiceException;

}
