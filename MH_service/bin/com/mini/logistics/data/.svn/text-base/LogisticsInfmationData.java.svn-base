package com.mini.logistics.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

/**
 * 
 * 物流信息实体类
 * 
 * @author 左香勇
 */
@Entity
@Table(name = "MINI_LOGISTICSINFORMATION")
public class LogisticsInfmationData extends FrmData {

    private static final long serialVersionUID = 7871221501268776263L;

    /**
     * 物流时间
     */
    @Column(name = "TIME")
    private Date time;

    /**
     * 物流信息
     */
    @Column(name = "CONTEXT")
    private String context;

    /**
     * 订单id
     */
    @Column(name = "CONSUMERORDERID")
    private String consumerOrderId;
    
    /**
     * 创建时间
     */
    @Column(name = "CREATETIME")
    private Date createTime;

    /**
     * 最后更新时间
     */

    @Column(name = "UPDATETIME")
    private Date updateTime;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getConsumerOrderId() {
        return consumerOrderId;
    }

    public void setConsumerOrderId(String consumerOrderId) {
        this.consumerOrderId = consumerOrderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }    

}
