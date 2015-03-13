package com.itour.etip.pub.kit.exception;


/**
 * 将该例外改为RuntimeException,目的是不用反复try,catch,throw
 * @author lishan
 *
 */
public class ETIPException extends  ETIPError {
	/**
	 * 根据错误编码生成错误
	 * 
	 * @param errorCode
	 */
	public ETIPException(String errorCode) {
		super(errorCode);
	}

	/**
	 * 根据错误编码及参数生成错误
	 * 
	 * @param errorCode
	 * @param parameters
	 */
	public ETIPException(String errorCode, String parameters) {
		super(errorCode,parameters);
	}

}
