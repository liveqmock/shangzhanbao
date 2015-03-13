package com.mini.purchase.orderManager.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.mini.purchase.commodityConfig.data.CommodityConfigData;
import com.mini.purchase.goods.data.GoodsInfoData;

/**
 * 
 * 订单商品关联信息实体<br> 
 *
 * @author 左香勇
 * @see [相关类/方法]
 * @since vmaque2.0
 */
@Entity
@Table(name = "MINI_CONSUMERORDER_GOODSINFO")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class ConsumerOrderGoodsinfoData extends FrmData {

    private static final long serialVersionUID = 1L;

    /**
     * 订单表id
     */
    @Column(name="CONSUMERORDERID")
    private String consumerOrderId;
    
    /**
     * 数量
     */
    @Column(name="GOODSNUM")
    private Integer goodsNum;
    
    /**
     * 规格表id
     */
    @Column(name="COMMODITYCONFIGID")
    private String commodityConfigId;
    
    /**
     * 订单商品信息id
     */
    @Column(name="GOODSINFID")
    private String goodsInfId;
    
    /**
     * 订单是否删除  0 － 已删除  1 － 未删除
     */
    @Column(name="ISDELETE")
    private Integer isdelete;
    
    private ConSumerOrderData conSumerOrderData;
    
    private CommodityConfigData commodityConfigData;
    
    private GoodsInfoData goodsInfoData;

    public String getConsumerOrderId() {
        return consumerOrderId;
    }

    public void setConsumerOrderId(String consumerOrderId) {
        this.consumerOrderId = consumerOrderId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getCommodityConfigId() {
        return commodityConfigId;
    }

    public void setCommodityConfigId(String commodityConfigId) {
        this.commodityConfigId = commodityConfigId;
    }

    public String getGoodsInfId() {
        return goodsInfId;
    }

    public void setGoodsInfId(String goodsInfId) {
        this.goodsInfId = goodsInfId;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    @Transient
    public ConSumerOrderData getConSumerOrderData() {
        return conSumerOrderData;
    }

    public void setConSumerOrderData(ConSumerOrderData conSumerOrderData) {
        this.conSumerOrderData = conSumerOrderData;
    }

    @Transient
    public CommodityConfigData getCommodityConfigData() {
        return commodityConfigData;
    }

    public void setCommodityConfigData(CommodityConfigData commodityConfigData) {
        this.commodityConfigData = commodityConfigData;
    }
    
    @Transient
    public GoodsInfoData getGoodsInfoData() {
        return goodsInfoData;
    }

    public void setGoodsInfoData(GoodsInfoData goodsInfoData) {
        this.goodsInfoData = goodsInfoData;
    }
    
}
