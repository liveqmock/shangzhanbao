/*************************************************
  Copyright (C), 2009-2010,www.itour.cn

  File name: NtpTimeBean.java     
  Author: zhangjj 
  Version: 1.0.0.0   
  Date: 2008-1-28
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
 * <b>描述: 通过NTP来获取时间</b><br>
 * <br>
 * <b>示例:</b><br>
 * <br>
 * 
 * @author zhangjj
 * @version 1.00 created on 2008-1-28
 */
public class NtpTimeBean {
    private String server; // 服务器的名字或IP
    private int port; // 服务端口

    public NtpTimeBean() {
        server = "210.72.145.44"; // 国家授时中心NTP服务器
        port = 123; // 默认NTP端口
    }

    /**
     * get server
     * 
     * @return server author zhangjj created on 2008-1-28
     */
    public String getServer() {
        return server;
    }

    /**
     * set server
     * 
     * @param server
     *            the server to set author zhangjj created on 2008-1-28
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * get port
     * 
     * @return port author zhangjj created on 2008-1-28
     */
    public int getPort() {
        return port;
    }

    /**
     * set port
     * 
     * @param port
     *            the port to set author zhangjj created on 2008-1-28
     */
    public void setPort(int port) {
        this.port = port;
    }

}
