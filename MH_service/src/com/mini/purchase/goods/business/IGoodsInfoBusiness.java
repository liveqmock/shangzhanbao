package com.mini.purchase.goods.business;

import java.util.List;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.purchase.goods.data.GoodsInfoData;

/**
 * 
 * 商品信息Business接口<br> 
 * @author 侯杨
 *    2014-9-9
 * @see IGoodsInfoBusiness
 * @since vmaque1.5
 */
public interface IGoodsInfoBusiness extends IBusiness{
    /**
     * 
     *查询所有的商品信息<br>
     * @author 侯杨 <br> 
     *		   2014-9-9
     * @update 
     * @param pageRoll    分页
     *        data        商品信息实体
     * @return  商品信息list集合
     * @see IGoodsInfoBusiness#getAll
     * @since vmaque1.5
     */
    public List<GoodsInfoData> getAll(PageRoll pageRoll,GoodsInfoData data);
    /**
     * 
     *添加商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实体
     *  @see IGoodsInfoBusiness#addGoodsInfoData
     * @since vmaque1.5
     */
    public void addGoodsInfoData(GoodsInfoData data);
    /**
     * 
     *删除商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实体
     * @see IGoodsInfoBusiness#deleteGoodsInfoData
     * @since vmaque1.5
     */
    public void deleteGoodsInfoData(GoodsInfoData data);
    /**
     * 
     *修改商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实
     * @see IGoodsInfoBusiness#updateGoodsInfoData
     * @since vmaque1.5
     */
    public void updateGoodsInfoData(GoodsInfoData data);
    /**
     *查询商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实体
     * @return GoodsInfoData实体
     * @see IGoodsInfoBusiness#getGoodsInfoData
     * @since vmaque1.5
     */
    public GoodsInfoData getGoodsInfoData(GoodsInfoData data);
   
}
