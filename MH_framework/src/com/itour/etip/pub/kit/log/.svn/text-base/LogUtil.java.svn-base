package com.itour.etip.pub.kit.log;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * <p>Title: 异步JMS消息发送</p>
 * <p>Description: 异步JMS消息发送</p>
 * <p>Copyright: Copyright (C), 2009-2010, eTIP </p>
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-03-14
 */
public class LogUtil {

	
	/**
	 * 致命错误，导致系统中止。
	 * @param logName　配置的日志模块名称
	 * @param message　日志信息
	 * @throws 
	 */
	public static void fatal(String logName,Object message){
		Logger log = Logger.getLogger(logName);
		log.fatal(message);
	}
	
	/**
	 * 致命错误，导致系统中止。
	 * @param logName　配置的日志模块名称
	 * @param message　日志信息
	 * @param t 系统例外对象
	 * @throws 
	 */ 
	public static void fatal(String logName,Object message,Throwable t){
		Logger log = Logger.getLogger(logName);
		log.fatal(message,t);
	}
	
	
	/**
	 * 记录普通逻辑错误，但是不会导致系统中止。
	 * @param logName　日志实例名
	 * @param message　记录的日志信息对象
	 * @throws 
	 */
	public static void error(String logName,Object message) {
		Logger log = Logger.getLogger(logName);
		log.error(message);
	}
	/**
	 * 记录普通逻辑错误，不会导致系统中止
	 * @param logName　日志实例名
	 * @param message　日志信息
	 * @param t　例外对象
	 * @throws 
	 */ 
	public static void error(String logName,Object message,Throwable t){
		Logger log = Logger.getLogger(logName);
		log.error(message,t);
	}
	
	/**
	 * 记录警告信息
	 * @param logName　日志实例名
	 * @param message　日志信息
	 * @throws 
	 */
	public static void warn(String logName,Object message) {
		Logger log = Logger.getLogger(logName);
		log.warn(message);
	}
	/**
	 * 记录警告信息。
	 * @param logName　日志实例名
	 * @param message　日志信息
	 * @param t　例外实例
	 * @throws 
	 */
	public static void warn(String logName,Object message,Throwable t){
		Logger log = Logger.getLogger(logName);
		log.warn(message,t);
	}
	/**
	 * 记录提示信息，要求eTIP记录异步日志，即通过jms记录日志。
	 * @param logName　日志实例名称
	 * @param message　日志信息
	 * @throws 
	 */
	public static void info(String logName,Object message){
		Logger log = Logger.getLogger(logName);
		log.info(message);
	}
		
	/**
	 * 记录提示信息。
	 * @param logName　日志实例名称
	 * @param message　日志信息
	 * @param t　例外对象信息
	 * @throws 
	 */
	public static void info(String logName,Object message,Throwable t) {
		Logger log = Logger.getLogger(logName);
		log.info(message,t);
	}
	/**
	 * 记录调试信息
	 * @param logName 日志实例名称
	 * @param message　日志信息
	 * @throws 
	 */
	public static void debug(String logName,Object message){
		Logger log = Logger.getLogger(logName);
		log.debug(message);
	}
	/**
	 * 记录调试信息。
	 * @param logName　日志实例名称
	 * @param message　日志信息
	 * @param t　例外对象
	 * @throws 
	 */
	public static void debug(String logName,Object message,Throwable t) {
		Logger log = Logger.getLogger(logName);
		log.debug(message,t);
	}
	
	/**
	 * 记录日志
	 * @param logName
	 * @param message
	 */
	public static void logTime(String message){
		Logger log = Logger.getLogger("CONSOLE");
		log.warn("when :"+new Date()+":"+message);
	}
	
}
