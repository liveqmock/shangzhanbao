package com.mini.purchase.commodityConfig.business;

import java.util.List;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.purchase.commodityConfig.data.CommodityConfigData;

/**
 * 
 * 商品规格business接口<br> 
 *           2014-9-9
 * @author 侯杨
 * @see ICommodityConfigBusiness
 * @since vmaque1.5 
 */
public interface ICommodityConfigBusiness extends IBusiness{
    /**
    * 
    *查询所有的规格信息<br>
    * 
    * @author 侯杨 <br> 
    *         2014-9-9
    * @update 
    * @param pageRoll     分页
    *        data         商品规格信息实体
    * @return  商品规格信息list集合
    * @see ICommodityConfigBusiness#getAll
    * @since vmaque1.5 
    */
    public List<CommodityConfigData> getAll(PageRoll pageRoll,CommodityConfigData data);
    /**
     * 
     *添加规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品规格信息实体
     * @see ICommodityConfigBusiness#addCommodityConfigData
     * @since vmaque1.5 
     */
    public void addCommodityConfigData(CommodityConfigData data);
    /**
     * 
     *删除规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品规格信息实体
     * @see ICommodityConfigBusiness#deleteCommodityConfigData
     * @since vmaque1.5 
     */
    public void deleteCommodityConfigData(CommodityConfigData data);
    /**
     * 
     *修改规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品规格信息实体
     * @see ICommodityConfigBusiness#updateCommodityConfigData
     * @since vmaque1.5 
     */
    public void updateCommodityConfigData(CommodityConfigData data);
    /**
     * 
     *查询规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品规格信息实体
     * @return CommodityConfigData
     * @see ICommodityConfigBusiness#getCommodityConfigData
     * @since vmaque1.5 
     */
    public CommodityConfigData getCommodityConfigData(CommodityConfigData data);
    
    /**
     * 
     *根据商品id查询规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-10
     * @update 
     * @param  data         商品规格信息实体
     * @return 商品规格信息list集合
     * @see ICommodityConfigBusiness#getAllByGoodsId
     * @since vmaque1.5 
     */
    public List<CommodityConfigData>   getAllByGoodsId(CommodityConfigData data);   
    /**
     * 
     *根据父亲id查询规格信息 <br>
     * @author 侯杨 <br> 
     *         2014-12-11
     * @update 
     * @param  data         商品规格信息实体
     * @return 商品规格信息list集合
     * @see ICommodityConfigBusiness#getAllByParentId(CommodityConfigData)
     * @since vmaque2.0
     */
    public List<CommodityConfigData> getAllByParentId(CommodityConfigData data);
       
}
