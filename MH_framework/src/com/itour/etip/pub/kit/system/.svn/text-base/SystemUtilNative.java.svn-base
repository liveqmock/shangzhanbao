/*************************************************
  Copyright (C), 2009-2010,www.itour.cn

  File name: SystemUtilNative.java     
  Author: zhangjj 
  Version: 1.0.0.0   
  Date: 2008-1-22
  Description:    
  Others:         
  Function List: 
    1. ....
  History:    
	1. Date:    
       Author:
       Modification:
    2. ...
 *************************************************/

package com.itour.etip.pub.kit.system;

import java.util.Calendar;

/**
 * <b>描述: 系统信息读取的JNI接口函数</b><br>
 * <br>
 * <b>示例:</b><br>
 * <br>
 * 
 * @author zhangjj
 * @version 1.00 created on 2008-1-22
 */
public class SystemUtilNative {
    private static final String SILIB = "JNIImpl";

    static {
        // loading a native lib in a static initializer ensures that it is
        // available done before any method in this class is called:
        try {
            System.loadLibrary(SILIB);
        } catch (UnsatisfiedLinkError e) {
            System.out.println("native lib '" + SILIB
                    + "' not found in 'java.library.path': "
                    + System.getProperty("java.library.path"));
            throw e; // re-throw
        }
    }

    /**
     * UTM使用的接口,读取磁盘可用空间
     * 
     * @param pszDrive
     *            磁盘名, 如A:\
     * @return 磁盘容量, 以 byte计算 author zhangjj created on 2008-1-24
     */
    public static native long myGetDiskFreeSpace(String pszDrive);

    /**
     * UTM使用的接口,获取内存使用率
     * 
     * @return 内存使用率1--100 author zhangjj created on 2008-1-24
     */
    public static native int myGetMemUsage();

    /**
     * UTM使用的接口,获取CPU使用率
     * 
     * @return CPU使用率1--100 author zhangjj created on 2008-1-24
     */
    public static native int myGetCpuUsage();

    /**
     * 读取内存使用率
     * 
     * @param memoryUsageBean
     *            内存使用率 author zhangjj created on 2008-1-22
     */
    public static native void getMemoryUsage(MemoryUsageBean memoryUsageBean);

    /**
     * 读取CPU使用率
     * 
     * @param cpuUsageBean
     *            CPU使用率 author zhangjj created on 2008-1-22
     */
    public static native void getCpuUsage(CpuUsageBean cpuUsageBean);

    /**
     * 读取操作系统信息
     * 
     * @param osInfoBean
     *            操作系统信息 author zhangjj created on 2008-1-22
     */
    public static native void getOsInfomation(OsInfoBean osInfoBean);

    /**
     * 读取磁盘使用率
     * 
     * @param diskUsageBean
     *            磁盘使用率 author zhangjj created on 2008-1-22
     */
    public static native void getDiskUsage(DiskUsageBean diskUsageBean);

    /**
     * 读取全部磁盘的使用情况, 本函数有个缺陷,最多只能读取A-Z个盘符
     * 
     * @param diskSummaryBean
     *            磁盘统计 author zhangjj created on 2008-1-23
     */
    public static native void getDiskSummary(DiskSummaryBean diskSummaryBean);

    /**
     * 设置服务器的时间
     * 
     * @param calendar
     *            时间 author zhangjj created on 2036-2-8
     */
    public static native void setServerTime(Calendar calendar);

    /**
     * 读取服务器的时间
     * 
     * @param calendar
     *            时间 author zhangjj created on 2036-2-8
     */
    public static native void getServerTime(Calendar calendar);

    /**
     * 设置服务器的时区
     * 
     * @param calendar
     *            时区 author zhangjj created on 2036-2-8
     */
    public static native void setServerTimeZone(Calendar calendar);

    /**
     * 读取服务器的时区
     * 
     * @param calendar
     *            时区 author zhangjj created on 2036-2-8
     */
    public static native void getServerTimeZone(Calendar calendar);

    /**
     * 从NTP服务器读取时间,并设置服务器的时间
     * 
     * @param ntpTimeBean
     *            author zhangjj created on 2008-1-28
     */
    public static native void setServerTimeFromNtp(NtpTimeBean ntpTimeBean);

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, 10);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 22);
        calendar.set(Calendar.SECOND, 33);

        SystemUtilNative.setServerTime(calendar);
        Calendar calendar2 = Calendar.getInstance();
        SystemUtilNative.getServerTime(calendar2);
        System.out.println(calendar2.get(Calendar.YEAR));

    }
}
