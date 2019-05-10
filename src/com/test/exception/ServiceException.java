package com.test.exception;

public class ServiceException extends SysException {
	public ServiceException() {
		// 业务层的默认错误信息
		super("业务操作错误！");
	}

	public ServiceException(String message) {
		super(message);
	}

}
