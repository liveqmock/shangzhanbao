/*************************************************
    Copyright (C), 1996-2008, www.itour.cn

  File name: DiskUsageBean.java     
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

/**
 * <b>描述: 磁盘使用率</b><br>
 * <br>
 * <b>示例:</b><br>
 * <br>
 * 
 * @author zhangjj
 * @version 1.00 created on 2008-1-22
 */
public class DiskUsageBean {
    private String diskName; // 磁盘名
    private String diskTypeName; // 磁盘类型名字
    private int diskType; // 磁盘类型
    private long totalSpace; // 全部空间,以byte为单位
    private long freeSpace; // 可用空间,以byte为单位

    public DiskUsageBean() {
        diskType = -1;
        totalSpace = -1;
        freeSpace = -1;
    }

    /**
     * get totalSpace
     * 
     * @return totalSpace author zhangjj created on 2008-1-23
     */
    public long getTotalSpace() {
        return totalSpace;
    }

    /**
     * set totalSpace
     * 
     * @param totalSpace
     *            the totalSpace to set author zhangjj created on 2008-1-23
     */
    public void setTotalSpace(long totalSpace) {
        this.totalSpace = totalSpace;
    }

    /**
     * get freeSpace
     * 
     * @return freeSpace author zhangjj created on 2008-1-23
     */
    public long getFreeSpace() {
        return freeSpace;
    }

    /**
     * set freeSpace
     * 
     * @param freeSpace
     *            the freeSpace to set author zhangjj created on 2008-1-23
     */
    public void setFreeSpace(long freeSpace) {
        this.freeSpace = freeSpace;
    }

    /**
     * get diskName
     * 
     * @return diskName author zhangjj created on 2008-1-23
     */
    public String getDiskName() {
        return diskName;
    }

    /**
     * set diskName
     * 
     * @param diskName
     *            the diskName to set author zhangjj created on 2008-1-23
     */
    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }

    /**
     * get diskType
     * 
     * @return diskType author zhangjj created on 2008-1-24
     */
    public int getDiskType() {
        return diskType;
    }

    /**
     * set diskType
     * 
     * @param diskType
     *            the diskType to set author zhangjj created on 2008-1-24
     */
    public void setDiskType(int diskType) {
        this.diskType = diskType;
    }

    /**
     * get diskTypeName
     * 
     * @return diskTypeName author zhangjj created on 2008-1-24
     */
    public String getDiskTypeName() {
        return diskTypeName;
    }

    /**
     * set diskTypeName
     * 
     * @param diskTypeName
     *            the diskTypeName to set author zhangjj created on 2008-1-24
     */
    public void setDiskTypeName(String diskTypeName) {
        this.diskTypeName = diskTypeName;
    }

}
