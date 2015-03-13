/*************************************************
 Copyright (C), 2009-2010,www.itour.cn

 File name: SystemUtil.java     
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
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>描述: 提供系统信息的读取和设置</b><br>
 * <br>
 * <b>示例:</b><br>
 * <br>
 * 
 */
public class SystemUtil {

	public static List<DiskUsageBean> getAllDiskUsage() {
		List<DiskUsageBean> diskList = new LinkedList<DiskUsageBean>();
		DiskSummaryBean diskSummaryBean = new DiskSummaryBean();
		SystemUtilNative.getDiskSummary(diskSummaryBean);
		for (int i = 0; i < diskSummaryBean.getTotalDisk(); i++) {
			DiskUsageBean diskUsageBean = new DiskUsageBean();
			diskUsageBean.setDiskName(diskSummaryBean.getDiskList().get(i));
			SystemUtilNative.getDiskUsage(diskUsageBean);
			diskList.add(diskUsageBean);
		}
		return diskList;
	}

	public static CpuUsageBean getCpuUsage() {
		CpuUsageBean cpuUsageBean = new CpuUsageBean();
		SystemUtilNative.getCpuUsage(cpuUsageBean);
		return cpuUsageBean;
	}

	public static DiskUsageBean getDiskUsage() {
		DiskUsageBean diskUsageBean = new DiskUsageBean();
		SystemUtilNative.getDiskUsage(diskUsageBean);
		setDiskTypeName(diskUsageBean);
		return diskUsageBean;
	}

	/**
	 * 设置disk的类型名字
	 * 
	 * @param diskUsageBean
	 *            disk情况
	 */
	private static void setDiskTypeName(DiskUsageBean diskUsageBean) {
		final String[] driveName = new String[] { "UNKNOWN", "NO_ROOT_DIR",
				"REMOVABLE", "FIXED", "REMOTE", "CDROM", "RAMDISK" };
		if (diskUsageBean.getDiskType() >= 0) {
			diskUsageBean
					.setDiskTypeName(driveName[diskUsageBean.getDiskType()]);
		}
	}

	public static MemoryUsageBean getMemoryUsage() {
		MemoryUsageBean memoryUsageBean = new MemoryUsageBean();
		SystemUtilNative.getMemoryUsage(memoryUsageBean);
		return memoryUsageBean;
	}

	public static OsInfoBean getOsInfomation() {
		OsInfoBean osInfoBean = new OsInfoBean();
		SystemUtilNative.getOsInfomation(osInfoBean);
		setOsName(osInfoBean);
		return osInfoBean;
	}

	/**
	 * 设置操作系统的名字,因为从jni得到的只是数字,需要转换
	 * 
	 * @param osInfoBean
	 *            操作系统信息
	 */
	/**
	 * 
	 * @param osInfoBean
	 * 
	 */
	private static void setOsName(OsInfoBean osInfoBean) {
		final int win32s = 0;
		final int win32_windows = 1;
		final int win32_nt = 2;

		switch (osInfoBean.getPlatfromId()) {
		case win32s:
			osInfoBean.setOsName("Microsoft Win32s");
			break;
		case win32_windows:
			setWindowsOsName(osInfoBean);
			break;
		case win32_nt:
			setNtOsName(osInfoBean);
			break;
		}
	}

	/**
	 * 
	 * @param osInfoBean
	 *            OS信息
	 */
	private static void setWindowsOsName(OsInfoBean osInfoBean) {
		final int windows95 = 0;
		final int windows98 = 10;
		final int windowsme = 90;
		if (osInfoBean.getMajorVersion() == 4) {
			switch (osInfoBean.getMinorVersion()) {
			case windows95:
				osInfoBean.setOsName("Microsoft Windows 95");
				break;
			case windows98:
				osInfoBean.setOsName("Microsoft Windows 98");
				break;
			case windowsme:
				osInfoBean.setOsName("Microsoft Windows Millennium Edition");
			}
		}

	}

	/**
	 * 
	 * @param osInfoBean
	 *            OS信息
	 */
	private static void setNtOsName(OsInfoBean osInfoBean) {
		final int win2000xp2003 = 5;
		final int win2000 = 0;
		final int winxp = 1;
		final int win2003 = 2;

		if (osInfoBean.getMajorVersion() == win2000xp2003) {
			switch (osInfoBean.getMajorVersion()) {
			case win2000:
				osInfoBean.setOsName("Microsoft Windows 2000");
				break;
			case winxp:
				osInfoBean.setOsName("Microsoft Windows XP");
				break;
			case win2003:
				osInfoBean.setOsName("Microsoft Windows Server 2003 Family");
				break;
			}
		} else if (osInfoBean.getMajorVersion() < win2000xp2003) {
			osInfoBean.setOsName("Microsoft Windows NT");
		}

	}

	public static Date getServerTime() {
		Calendar calendar = Calendar.getInstance();
		SystemUtilNative.getServerTime(calendar);
		return calendar.getTime();
	}

	public static int getServerTimeZone() {
		Calendar calendar = Calendar.getInstance();
		SystemUtilNative.getServerTimeZone(calendar);
		int millis = calendar.get(Calendar.ZONE_OFFSET);
		int zone = -millis / 3600000;
		return zone;
	}

	public static long getDiskFreeSpace(String pszDrive) {
		return SystemUtilNative.myGetDiskFreeSpace(pszDrive);
	}

	public static int getMemUsage() {
		return SystemUtilNative.myGetMemUsage();
	}

	public static void setServerTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		SystemUtilNative.setServerTime(calendar);
	}

	public static void setServerTimeFromNtp(NtpTimeBean ntpTimeBean) {
		SystemUtilNative.setServerTimeFromNtp(ntpTimeBean);
	}

	public static void setServerTimeZone(int timeZone) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.ZONE_OFFSET, -timeZone * 3600000);
		SystemUtilNative.setServerTimeZone(calendar);
	}

}
