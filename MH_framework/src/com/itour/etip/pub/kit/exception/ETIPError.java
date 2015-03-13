package com.itour.etip.pub.kit.exception;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.itour.etip.pub.kit.cache.CacheUtil;

public class ETIPError extends RuntimeException implements IETIPException {
	/**
	 * 自定义错误编码
	 */
	protected String errorCode = null;

	/**
	 * 供应商错误
	 */
	protected String rootError = null;

	/**
	 * 系统错误
	 */
	protected transient Exception errorRoot = null;

	/**
	 * 错误提示信息参数表
	 */
	protected transient HashMap<String, String> parameters = new HashMap<String, String>();

	/**
	 * 错误名称
	 */
	protected String errorName = null;

	/**
	 * 错误原因
	 */
	protected String errorCause = null;

	/**
	 * 错误解决方案
	 * 
	 */
	protected String errorSolution = null;

	/**
	 * 根据错误编码生成错误
	 * 
	 * @param errorCode
	 */
	public ETIPError(String errorCode) {
		this.errorCode = errorCode;
		make();
	}

	/**
	 * 根据错误编码及参数生成错误
	 * 
	 * @param errorCode
	 * @param parameters
	 */
	public ETIPError(String errorCode, String parameters) {
		this.errorCode = errorCode.trim();
		parameters = parameters + ";";
		java.util.StringTokenizer tokens = new java.util.StringTokenizer(parameters.trim(), ";");
		String element = null;
		int colonIndex = -1;
		while (tokens.hasMoreElements()) {
			element = tokens.nextToken();
			colonIndex = element.indexOf(":");
			this.parameters.put(element.substring(0, colonIndex), element.substring(colonIndex + 1));
		}
		make();
	}

	/**
	 * 根据错误编码及系统错误生成错误
	 * 
	 * @param errorCode
	 * @param errorRoot
	 */
	public ETIPError(String errorCode, Exception errorRoot) {
		// this.printStackTrace();
		this.errorCode = errorCode.trim();
		this.errorRoot = errorRoot;
		make();
	}

	/**
	 * 根据错误编码、参数、系统错误生成。
	 * 
	 * @param errorCode
	 * @param parameters
	 * @param errorRoot
	 */
	public ETIPError(String errorCode, String parameters, Exception errorRoot) {
		this.errorCode = errorCode.trim();
		this.errorRoot = errorRoot;
		java.util.StringTokenizer tokens = new java.util.StringTokenizer(parameters.trim(), ";");
		String element = null;
		int colonIndex = -1;
		while (tokens.hasMoreElements()) {
			element = tokens.nextToken();
			colonIndex = element.indexOf(":");
			this.parameters.put(element.substring(0, colonIndex), element.substring(colonIndex));
		}
		make();
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public HashMap getParameters() {
		return this.parameters;
	}

	public Exception getErrorRoot() {
		return this.errorRoot;
	}

	public String getErrorName() {
		return this.errorName;
	}

	public String getErrorCause() {
		return this.errorCause;
	}

	public String getErrorSolution() {
		return this.errorSolution;
	}

	public String toString() {
		StringBuffer rv = new StringBuffer();
		// rv.append(errorCode);
		rv.append("{errorCode:");
		if (errorCode != null) {
			rv.append("'" + errorCode.replace(':', '-') + "'");
		} else {
			rv.append("'***'");
		}
		rv.append(",");

		rv.append("errorName:");
		if (errorName != null) {
			rv.append("'" + errorName.replace(':', '-') + "'");
		} else {
			rv.append("'***'");
		}
		rv.append(",");
		rv.append("errorCause:");
		if (errorCause != null) {
			rv.append("'" + errorCause.replace(':', '-') + "'");
		} else {
			rv.append("'***'");
		}
		rv.append(",");
		rv.append("errorSolution:");
		if (errorSolution != null) {
			rv.append("'" + errorSolution.replace(':', '-') + "'");
		} else {
			rv.append("'***'");
		}
		// 检查是否有errorRoot
		rv.append(",");
		rv.append("errorRoot:");
		if (errorRoot != null) {
			rv.append("'" + rootError.replace(':', '-') + "'");
		} else {
			rv.append("''");
		}
		rv.append("}");
		// 此处设置字符集
		String rvStr = rv.toString();
		return rvStr;
	}

	public String getMessage() {
		return toString();
	}

	/**
	 * 根据缓冲区构造错误实例。
	 * 
	 */
	private void make() {
		// 此处肯定有errorMap返回，如果没有，将自动进行配置
		// ExceptionCache exCache = (ExceptionCache) SpringContextHelper
		// .getBean("exceptionCache");

		Map errorMap = CacheUtil.errorCache.getException(errorCode);
		errorName = (String) errorMap.get("name");
		errorCause = (String) errorMap.get("cause");
		errorSolution = (String) errorMap.get("solution");
		/*
		 * 参数处理，如果parameters!=null
		 */
		if (parameters != null) {
			Object[] keys = parameters.keySet().toArray();
			for (int i = 0; i < keys.length; i++) {
				Object value = parameters.get(keys[i]);
				String indexStr = "[" + keys[i] + "]";
				if(errorCause.equals("*")){
					errorCause = value.toString();
				}
				int index = errorCause.indexOf(indexStr);

				while (index != -1) {
					errorCause = errorCause.substring(0, index) + value
							+ errorCause.substring(index + indexStr.length());
					index = errorCause.indexOf(indexStr);
				}
				
				index = errorSolution.indexOf(indexStr);
				while (index != -1) {
					errorSolution = errorSolution.substring(0, index) + value + errorSolution.substring(index + indexStr.length());
					index = errorSolution.indexOf(indexStr);
				}

			}
		}

		// 系统错误处理
		if (errorRoot != null) {
			errorRoot.printStackTrace();
			// String rootErrorCode =null;
			if (errorRoot instanceof DataAccessException) {
				Throwable root = (((DataAccessException) errorRoot).getMostSpecificCause());
				if (root instanceof SQLException) {
					String rootErrorCode = String.valueOf(((SQLException) root).getErrorCode());
					// 此处要将供应商错误码转换为特定错误提示
					if (rootErrorCode.length() < 5) {
						rootErrorCode = "ORA-0" + rootErrorCode;
					} else {
						rootErrorCode = "ORA-" + rootErrorCode;
					}
					// 此处都datadic中取出对应的配置项目
					rootError = (String) CacheUtil.dataCache.getDataMap("OracleErrorCode").get(rootErrorCode);
					// 如果未找到错误编码，那么直接将rootError设置为错误码。
					if (rootError == null) {
						rootError = rootErrorCode;
					}
				} else {
					rootError = root.getMessage();
				}
			} else {
				// errorRootStr = errorRoot.toString();
				rootError = errorRoot.getMessage();
			}
			if (rootError == null) {
				rootError = errorRoot.toString();
			}
		}

	}
}
