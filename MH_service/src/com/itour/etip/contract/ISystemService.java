/*************************************************
  Copyright (C), 2009-2010,www.itour.cn

  File name: IHostInfoUtil.java     
  Author: zhangjj 
  Version: 1.0.0.0   
  Date: 2008-1-17
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

package com.itour.etip.contract;

import java.util.Date;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itour.etip.pub.kit.system.CpuUsageBean;
import com.itour.etip.pub.kit.system.DiskUsageBean;
import com.itour.etip.pub.kit.system.MemoryUsageBean;
import com.itour.etip.pub.kit.system.NtpTimeBean;
import com.itour.etip.pub.kit.system.OsInfoBean;

/**
 * <b>描述: 平台提供获取系统信息的能力,如获取CPU内存占用率,磁盘剩余空间等功能. 提供同步Web服务器时间的功能</b><br>
 * <p>
 * 对应的需求为:
 * <p>
 * <ol>
 * <li>Feature.OSInfo.001 获取CPU占用率</li>
 * <li>Feature.OSInfo.002 获取内存信息</li>
 * <li>Feature.OSInfo.003 获取磁盘剩余空间</li>
 * <li>Feature.OSInfo.004 获取操作系统版本</li>
 * <li>Feature.Time.002 设置本机系统时间</li>
 * <li>Feature.Time.003 获取本机系统时间,系统时区</li>
 * <li>Feature.Time.001 获取NTP/SNTP服务器时间</li>
 * </ol>
 * <p>
 * 分解成系统设计功能如下:
 * <ol>
 * <li>获取CPU信息 提供获取CPU占用率的接口。</li>
 * <li>获取物理内存信息 提供获取物理内存信息的接口，内存信息包括物理内存总数、当前占用内存数以及内存占用率。</li>
 * <li>获取磁盘剩余空间 提供获取指定磁盘剩余空间的接口</li>
 * <li>获取操作系统版本 提供获取操作系统版本的接口</li>
 * <li>设置本机系统时间 提供将本机系统时间设置为指定时间的接口。</li>
 * <li>获取本机系统时间,系统时区 提供获取本机系统时间和系统时区的接口。</li>
 * <li>获取NTP/SNTP服务器时间 提供从NTP/SNTP服务器获取数据（标准时间,服务器所在时区）的接口。</li>
 * </ol>
 * <p>
 * 当前支持windows系统,如windows 2000, xp. 目前只支持NTP,不支持SNTP <br>
 * <b>示例:</b><br>
 * <br>
 * 
 * @author zhangjj
 * @version 1.00 created on 2008-1-17
 */
@WebService
public interface ISystemService {
    /**
     * 读取磁盘可用空间
     * 
     * @param pszDrive
     *            磁盘名, 如A:\
     * @return 磁盘容量, 以 byte计算 author zhangjj created on 2008-1-24
     */
    public long getDiskFreeSpace(@WebParam(name = "pszDrive")String pszDrive);

    /**
     * 获取内存使用率
     * 
     * @return 内存使用率1--100 author zhangjj created on 2008-1-24
     */
    public int getMemUsage();

   
    /**
     * 读取内存使用率
     * 
     * @return 内存使用率 author zhangjj created on 2008-1-22
     */
    public MemoryUsageBean getMemoryUsage();

    /**
     * 读取CPU使用率
     * 
     * @return CPU使用率 
     */
    public CpuUsageBean getCpuUsage();

    /**
     * 读取操作系统信息
     * 
     * @return 操作系统信息 
     */
    public OsInfoBean getOsInfomation();

    /**
     * 读取磁盘使用情况
     * 
     * @return 磁盘使用情况 
     */
    public DiskUsageBean getDiskUsage();

    /**
     * 读取全部磁盘的使用情况, 本函数有个缺陷,最多只能读取A-Z个盘符
     * 
     * @return 磁盘使用情况的列表 
     */
    public List<DiskUsageBean> getAllDiskUsage();

    /**
     * 设置服务器的时间,需要web服务器的用户有设置时间的权力
     * 
     * @param date     时间 
     */
    public void setServerTime(Date date);

    /**
     * 读取服务器的时间
     * 
     * @return 时间 
     */
    public Date getServerTime();

    /**
     * 设置服务器的时区,需要web服务器的用户有设置时间的权力
     * 
     * @param timeZone 时区 
     */
    public void setServerTimeZone(@WebParam(name = "timeZone")int timeZone);

    /**
     * 读取服务器的时区
     * 
     * @return 时区 
     */
    public int getServerTimeZone();

    /**
     * 从NTP服务器读取时间,并设置服务器的时间,需要web服务器的用户有设置时间的权力
     * 
     * @param ntpTimeBean   NTP服务器的情况 
     */
    public void setServerTimeFromNtp(@WebParam(name = "ntpTimeBean")NtpTimeBean ntpTimeBean);

}
