package com.test.exception;

public class SysException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//错误信息
		private String errorMsg;
		
		public String getErrorMsg() {
			return errorMsg;
		}
	 
	 
		public void setErrorMsg(String errorMsg) {
			this.errorMsg = errorMsg;
		}
		
		//下面几个全是不同的构造方法
		public SysException() {
			super();
			// TODO Auto-generated constructor stub
		}
	 
	 
		public SysException(String message, Throwable cause,
				boolean enableSuppression, boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
			// TODO Auto-generated constructor stub
		}
	 
	 
		public SysException(String message, Throwable cause) {
			super(message, cause);
			errorMsg=message;
		}
	 
	 
		public SysException(String message) {
			super(message);
			errorMsg=message;
		}
	 
	 
		public SysException(Throwable cause) {
			super(cause);
		}

	
}
