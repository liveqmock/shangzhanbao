package com.mini.purchase.commodityConfig.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.mini.purchase.goods.data.GoodsInfoData;
import com.mini.purchase.pagegoodsinfo.business.PageGoodsInfoBusiness;

/**
 * 商品规格实体对象
 * 
 * @author 侯杨
 * @see PageGoodsInfoBusiness
 * @since vmaque1.5 
 */
@Entity
@Table(name="MINI_COMMODITYCONFIG")
public class CommodityConfigData extends FrmData{
    /**
     */
    private static final long serialVersionUID = -25052829008970091L;
    /**
     * 规格名称
     */
    @Column(name="CONFIGNAME")
    private String configName;
   /**
    * 规格价格
    */
    @Column(name="CONFIGPRICE")
    private double configPrice;
    /**
     * 市场价格
     */
    @Column(name="CONFIGMARKETPRICE")
    private double congigMarketPrice;
    /**
     * 创建时间
     */
    @Column(name="CREATETIME")
    private Date   createTime;
    /**
     * 商品信息id
     */
    @Column(name="GOODSINFOID")
    private String goodsInfoId;
    /**
     * 删除 0已删除  1 未删除
     */
    @Column(name="ISDELETE")
    private Integer isDelete;
    /**
     * 父亲id
     */
    @Column(name="PARENTID")
    private String parentId;
    /**
     * 类型  1品类  2规格
     */
    @Column(name="TYPE")
    private Integer type;
    /**
     * 商品信息实体对象  
     */
    @Transient
     private GoodsInfoData goodsInfoData=new GoodsInfoData();
    
    /**
     * 
     *〈规格名称的get方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @return  String
     */
    public String getConfigName() {
        return configName;
    }
    /**
     * 
     *〈规格名称的set方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @param configName
     */
    public void setConfigName(String configName) {
        this.configName = configName;
    }
    /**
     * 
     *〈规格价格的get方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @return double
     */
    public double getConfigPrice() {
        return configPrice;
    }
    /**
     * 
     *〈规格价格的set方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @param configPrice
     */
    public void setConfigPrice(double configPrice) {
        this.configPrice = configPrice;
    }
    /**
     * 
     *〈上市场价格的get方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @return double
     */
    @Column(name="CONFIGMARKETPRICE")
    public double getCongigMarketPrice() {
        return congigMarketPrice;
    }
    /**
     * 
     *〈上市场价格的set方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @param congigMarketPrice
     */
    public void setCongigMarketPrice(double congigMarketPrice) {
        this.congigMarketPrice = congigMarketPrice;
    }
    /**
     * 
     *〈创建时间的get方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @return Date
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 
     *〈创建时间的set方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * 
     *〈商品信息id的get方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @return String
     */
    public String getGoodsInfoId() {
        return goodsInfoId;
    }
    /**
     * 
     *〈商品信息id的set方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @param goodsInfoId
     */
    public void setGoodsInfoId(String goodsInfoId) {
        this.goodsInfoId = goodsInfoId;
    }
    /**
     * 
     *<删除标识的get方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @return Integer
     */
    public Integer getIsDelete() {
        return isDelete;
    }
    /**
     * 
     *<删除标识的set方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @param isDelete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    /**
     * 
     *<商品实体对象的get方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @return GoodsInfoData
     */
    @Transient
    public GoodsInfoData getGoodsInfoData() {
        return goodsInfoData;
    }
    /**
     * 
     *<商品实体对象的set方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @param goodsInfoData
     */
    public void setGoodsInfoData(GoodsInfoData goodsInfoData) {
        this.goodsInfoData = goodsInfoData;
    }
    public String getParentId() {
        return parentId;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
/*    public List<CommodityConfigData> getList() {
        return list;
    }
    public void setList(List<CommodityConfigData> list) {
        this.list = list;
    }*/
    
    
    
}
