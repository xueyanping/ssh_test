package com.test.exception;

public class ActionException extends SysException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionException() {
		super("请求发生错误!");
	}

	public ActionException(String message) {
		super(message);
	}

}
