/*************************************************
   Copyright (C), 2009-2010 www.itour.cn

  File name: CpuUsageBean.java     
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
 * <b>描述: CPU使用率的情况</b><br>
 * <br>
 * <b>示例:</b><br>
 * <br>
 * 
 * @author zhangjj
 * @version 1.00 created on 2008-1-22
 */
public class CpuUsageBean {
    // CPU总数
    private int cpuNumber;
    // CPU平均使用率
    private int cpuUsage;
    // CPU型号
    private int cpuType;

    public CpuUsageBean() {
        cpuNumber = -1;
        cpuUsage = -1;
        cpuType = -1;
    }

    /**
     * get cpuType
     * 
     * @return cpuType author zhangjj created on 2008-1-22
     */
    public int getCpuType() {
        return cpuType;
    }

    /**
     * set cpuType
     * 
     * @param cpuType
     *            the cpuType to set author zhangjj created on 2008-1-22
     */
    public void setCpuType(int cpuType) {
        this.cpuType = cpuType;
    }

    /**
     * get cpuNumber
     * 
     * @return cpuNumber author zhangjj created on 2008-1-22
     */
    public int getCpuNumber() {
        return cpuNumber;
    }

    /**
     * set cpuNumber
     * 
     * @param cpuNumber
     *            the cpuNumber to set author zhangjj created on 2008-1-22
     */
    public void setCpuNumber(int cpuNumber) {
        this.cpuNumber = cpuNumber;
    }

    /**
     * get cpuUsage
     * 
     * @return cpuUsage author zhangjj created on 2008-1-22
     */
    public int getCpuUsage() {
        return cpuUsage;
    }

    /**
     * set cpuUsage
     * 
     * @param cpuUsage
     *            the cpuUsage to set author zhangjj created on 2008-1-22
     */
    public void setCpuUsage(int cpuUsage) {
        this.cpuUsage = cpuUsage;
    }
}
