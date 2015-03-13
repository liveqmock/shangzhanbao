package com.mini.purchase.commodityConfig.service;

import java.util.List;

import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.purchase.commodityConfig.data.CommodityConfigData;
import com.mini.purchase.goods.data.GoodsInfoData;

/**
 * 
 * 商品规格service接口<br> 
 *         2014-9-9
 *
 * @author 侯杨
 * @see ICommodityConfigService
 * @since vmaque1.5 
 */
public interface ICommodityConfigService extends IService{
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
     * @see ICommodityConfigService#getAll
     * @since vmaque1.5 
     */
     public List<CommodityConfigData> getAll(PageRoll pageRoll,CommodityConfigData data);
     /**
      * 
      *添加规格信息<br>
      * @author 侯杨 <br> 
      *         2014-9-9
      * @update 
      * @param  list         商品规格信息实体集合
      *         data         商品信息实体
      * @see ICommodityConfigService#addCommodityConfigData
      * @since vmaque1.5 
      */
     public CommodityConfigData addCommodityConfigData(List<CommodityConfigData> list,GoodsInfoData data);
     /**
      * 
      *循环删除规格信息<br>
      * @author 侯杨 <br> 
      *         2014-9-9
      * @update 
      * @param  data         商品规格信息实体
      * @see ICommodityConfigService#deleteCommodityConfigData
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
      * @see ICommodityConfigService#updateCommodityConfigData
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
      * @see ICommodityConfigService#getCommodityConfigData
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
      * @see ICommodityConfigService#getAllByGoodsId
      * @since vmaque1.5 
      */
     public List<CommodityConfigData>   getAllByGoodsId(CommodityConfigData data);  
     
     /**
      * 
      *单个删除规格信息<br>
      * @author 侯杨 <br> 
      *         2014-9-15
      * @update 
      * @param  data         商品规格信息实体
      * @see ICommodityConfigService#deleteCommod
      * @since vmaque1.5 
      */
     public void  deleteCommod(CommodityConfigData data);
     
     /**
      * 
      *根据父亲id查询规格信息 <br>
      * @author 侯杨 <br> 
      *         2014-12-11
      * @update 
      * @param  data         商品规格信息实体
      * @return 商品规格信息list集合
      * @see ICommodityConfigService#getAllByParentId(CommodityConfigData)
      * @since vmaque2.0
      */
     public List<CommodityConfigData> getAllByParentId(CommodityConfigData data);
}
