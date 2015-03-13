/*************************************************
  Copyright (C), 2009-2010,www.itour.cn

  File name: OSInfomation.java     
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
 * <b>描述: 操作系统信息</b><br>
 * <br>
 * <b>示例:</b><br>
 * <br>
 * 
 * @author zhangjj
 * @version 1.00 created on 2008-1-22
 */
public class OsInfoBean {
    private int majorVersion; // 主版本
    private int minorVersion; // 此版本
    private int buildNumber; // 编译号
    private int platfromId; // 平台ID
    private String servicePack; // 补丁
    private String osName; // 操作系统名字

    /**
     * get majorVersion
     * 
     * @return majorVersion author zhangjj created on 2008-1-23
     */
    public int getMajorVersion() {
        return majorVersion;
    }

    /**
     * set majorVersion
     * 
     * @param majorVersion
     *            the majorVersion to set author zhangjj created on 2008-1-23
     */
    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    /**
     * get minorVersion
     * 
     * @return minorVersion author zhangjj created on 2008-1-23
     */
    public int getMinorVersion() {
        return minorVersion;
    }

    /**
     * set minorVersion
     * 
     * @param minorVersion
     *            the minorVersion to set author zhangjj created on 2008-1-23
     */
    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    /**
     * get buildNumber
     * 
     * @return buildNumber author zhangjj created on 2008-1-23
     */
    public int getBuildNumber() {
        return buildNumber;
    }

    /**
     * set buildNumber
     * 
     * @param buildNumber
     *            the buildNumber to set author zhangjj created on 2008-1-23
     */
    public void setBuildNumber(int buildNumber) {
        this.buildNumber = buildNumber;
    }

    /**
     * get platfromId
     * 
     * @return platfromId author zhangjj created on 2008-1-23
     */
    public int getPlatfromId() {
        return platfromId;
    }

    /**
     * set platfromId
     * 
     * @param platfromId
     *            the platfromId to set author zhangjj created on 2008-1-23
     */
    public void setPlatfromId(int platfromId) {
        this.platfromId = platfromId;
    }

    /**
     * get servicePack
     * 
     * @return servicePack author zhangjj created on 2008-1-23
     */
    public String getServicePack() {
        return servicePack;
    }

    /**
     * set servicePack
     * 
     * @param servicePack
     *            the servicePack to set author zhangjj created on 2008-1-23
     */
    public void setServicePack(String servicePack) {
        this.servicePack = servicePack;
    }

    /**
     * get osName
     * 
     * @return osName author zhangjj created on 2008-1-23
     */
    public String getOsName() {
        return osName;
    }

    /**
     * set osName
     * 
     * @param osName
     *            the osName to set author zhangjj created on 2008-1-23
     */
    public void setOsName(String osName) {
        this.osName = osName;
    }
}
