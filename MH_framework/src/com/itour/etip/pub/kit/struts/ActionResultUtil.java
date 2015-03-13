package com.itour.etip.pub.kit.struts;


/**
 * Action 处理结果对象(为easyui分页控件服务)
 * for JSON
 * 
 * @author wangsw
 * @version 1.00
 * @date 2010-9-7
 */
public class ActionResultUtil {
	
	/** result 取值--正常结果 */
	public static String RESULT_SUCCESS = "success";

	/** result 取值--异常结果 */
	public static String RESULT_ERROR = "error";
	
	/** 处理结果,默认结果为success */
	String result = RESULT_SUCCESS ;
	
	/** 处理结果信息 */
	String message = "";
	
	/** 封装数据对象 */
	Object data = null;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public static String getRESULT_SUCCESS() {
		return RESULT_SUCCESS;
	}

	public static void setRESULT_SUCCESS(String rESULTSUCCESS) {
		RESULT_SUCCESS = rESULTSUCCESS;
	}

	public static String getRESULT_ERROR() {
		return RESULT_ERROR;
	}

	public static void setRESULT_ERROR(String rESULTERROR) {
		RESULT_ERROR = rESULTERROR;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
