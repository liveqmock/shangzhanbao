package com.itour.etip.pub.kit.jms;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

/**
 * <p>
 * Title: 日志信息JavaBean
 * </p>
 * <p>
 * Description: 日志信息JavaBean
 * </p>
 * <p>
 * Copyright: Copyright (C), 2009-2010, eTIP
 * </p>
 * 
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-03-14
 */
@Entity()
@Table(name = "tb_sys_log")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class JMSLog extends FrmData implements Serializable {

	private static final long serialVersionUID = -8251806845431581771L;

	/**
	 * 日志时间
	 */
	@Column(name = "time")
	private Date time;

	/**
	 * 日志级别
	 */
	@Column(name = "loglevel")
	private String loglevel;

	/**
	 * 日志类型，方便查询及统计使用。
	 */
	@Column(name = "type")
	private String type;

	/**
	 * 日志发送者
	 */
	@Column(name = "userid")
	private String userid;

	/**
	 * 日志触发方法
	 */
	@Column(name = "method")
	private String method;

	/**
	 * 日志内容
	 */
	@Column(name = "content")
	private String content;
	
	/**
	 * 日志名称
	 */
	@Column(name = "title")
	private String title;
	
	/**
	 * 日志发送者姓名
	 */
	@Column(name = "valueToCreatorName")
	private String valueToCreatorName;

	/**
	 * 日志FATAL级别(致命错误)
	 */
	public final static String LEVEL_FATAL = "FATAL";

	/**
	 * 日志ERROR级别(逻辑错误)
	 */
	public final static String LEVEL_ERROR = "ERROR";

	/**
	 * 日志WARN级别(警告信息)
	 */
	public final static String LEVEL_WARN = "WARN";

	/**
	 * 日志INFO级别(提示信息)
	 */
	public final static String LEVEL_INFO = "INFO";

	/**
	 * 日志DEBUG级别(调试信息)
	 */
	public final static String LEVEL_DEBUG = "DEBUG";
	
	

	/**
	 * 获取日志内容的值
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置日志内容的值
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取日志触发方法的值
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * 设置日志触发方法的值
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * 获取日志时间的值
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * 设置日志时间的值
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * 获取日志类型的值
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置日志类型的值
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取日志级别的值
	 */
	public String getLoglevel() {
		return loglevel;
	}

	/**
	 * 设置日志级别的值
	 */
	public void setLoglevel(String loglevel) {
		this.loglevel = loglevel;
	}

	/**
	 * 获取日志发送者的值
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 设置日志发送者的值
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static boolean checkLevel(String level) {
		if ("INFO,DEBUG,WARN,ERROR,FATAL".indexOf(level) < 0)
			return false;
		else
			return true;
	}

	public String getValueToCreatorName() {
		return valueToCreatorName;
	}

	public void setValueToCreatorName(String valueToCreatorName) {
		this.valueToCreatorName = valueToCreatorName;
	}

}
