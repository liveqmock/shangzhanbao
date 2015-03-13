package com.mini.purchase.goods.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;




import com.itour.etip.pub.frame.FrmData;
import com.mini.purchase.commodityConfig.data.CommodityConfigData;

/**
 * 商品信息实体对象
 * 
 * @author 侯杨
 * @see GoodsInfoData
 * @since vmaque1.5
 */
@Entity
@Table(name="MINI_GOODSINFO")
public class GoodsInfoData extends FrmData{
    /**
     */
    private static final long serialVersionUID = -7141074946634696430L;
    /**
     * 商品名称
     */
    @Column(name="GOODSNAME")
    private String goodsName;
    /**
     * 商品描述
     */
    @Column(name="GOODSDES")
    private String goodsDes;
    /**
     * 商品图片
     */
    @Column(name="GOODSIMG")
    private String goodsImg;
    /**
     * 创建时间
     */
    @Column(name="CREATETIME")
    private Date createTime;
    /**
     * 0已删除  1未删除
     */
    @Column(name="ISDELETE")
    private Integer isDelete;
    /**
     * 邮费
     */
    @Column(name="PROMOTION")
    private String promotion;
    /**
     * 促销信息
     */
    @Column(name="POSTAGE")
    private String postage;
    
    /**
     * 商品快递信息
     */
    @Column(name="GOODSEXPRESS")
    private String goodsExpress;
    /**
     * pageid
     */
    @Transient
    private String pageId;
    /**
     * 商品品类集合
     */
    @Transient
    private List<CommodityConfigData> configDatas=new ArrayList<CommodityConfigData>();;

    
    
    /**
     * 
     *〈商品名称的get方法〉<br>
     * 
     * @author 侯杨 <br> 
     *		   2014-9-9
     * @return  String
     */
    public String getGoodsName() {
        return goodsName;
    }
    
    /**
     * 
     *〈商品名称的set方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @param goodsName
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    /**
     * 
     *〈商品描述的get方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @return  String]
     */
    public String getGoodsDes() {
        return goodsDes;
    }
    /**
     * 
     *〈商品描述的set方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @param goodsDes
     */
    public void setGoodsDes(String goodsDes) {
        this.goodsDes = goodsDes;
    }
    
    /**
     * 
     *〈商品图片的get方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @return String
     */
    public String getGoodsImg() {
        return goodsImg;
    }
    /**
     * 
     *〈商品图片的set方法〉<br>
     * 
     * @author 侯杨 <br> 
     *         2014-9-9
     * @param goodsImg
     */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }
    /**
     * 
     *〈商品创建时间的get方法〉<br>
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
     *〈商品创建时间的set方法〉<br>
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
     *〈商品是否删除的get方法〉<br>
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
     *〈商品是否删除的set方法〉<br>
     *
     * @author 侯杨 <br> 
     *         2014-9-9
     * @param isDelete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    @Transient
    public List<CommodityConfigData> getConfigDatas() {
        return configDatas;
    }

    public void setConfigDatas(List<CommodityConfigData> configDatas) {
        this.configDatas = configDatas;
    }
    /**
     * 
     *〈pageid的get方法〉<br>
     *
     * @author 侯杨 <br> 
     *         2014-9-9
     * @return string
     */
    @Transient
    public String getPageId() {
        return pageId;
    }
    /**
     * <pageid的set方法〉<br>
     *
     * @author 侯杨 <br> 
     *         2014-9-9
     * @param pageId
     */
    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
    /**
     * 
     *  商品邮费的get方法<br>
     *
     * @author 侯杨 <br> 
     *         2014-10-29
     * @return string
     */
    public String getPromotion() {
        return promotion;
    }
    /**
     * 商品邮费的set方法<br>
     *
     * @author 侯杨 <br> 
     *         2014-10-29
     * @param pageId
     */
    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }
    /**
     * 
     *  商品促销的get方法<br>
     *
     * @author 侯杨 <br> 
     *         2014-10-29
     * @return string
     */
    public String getPostage() {
        return postage;
    }
    /**
     * 商品促销的set方法<br>
     *
     * @author 侯杨 <br> 
     *         2014-10-29
     * @param pageId
     */
    public void setPostage(String postage) {
        this.postage = postage;
    }
    /**
     * 
     *  商品快递信息的get方法<br>
     *
     * @author 侯杨 <br> 
     *         2014-11-07
     * @return string
     */

    public String getGoodsExpress() {
        return goodsExpress;
    }

   
    /**
     * 商品快递信息的set方法<br>
     *
     * @author 侯杨 <br> 
     *         2014-11-07
     * @param pageId
     */
    public void setGoodsExpress(String goodsExpress) {
        this.goodsExpress = goodsExpress;
    }

    
    
   
}
