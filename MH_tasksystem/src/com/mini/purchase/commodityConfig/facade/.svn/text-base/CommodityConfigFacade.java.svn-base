package com.mini.purchase.commodityConfig.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.purchase.commodityConfig.data.CommodityConfigData;
import com.mini.purchase.commodityConfig.service.ICommodityConfigService;
import com.mini.purchase.goods.data.GoodsInfoData;
/**
 * 
 * 商品规格facade层<br> 
 * 〈功能详细描述〉
 *
 * @author 侯杨
 * @see CommodityConfigFacade
 * @since vmaque1.5
 */
@Component("commodityConfigFacade")
public class CommodityConfigFacade extends FrmFacade{
    /**
     * 规格信息service层注入
     */
    @Resource(name="commodityConfigService")
     private ICommodityConfigService  commodityConfigService;
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
     * @see CommodityConfigFacade#getAll
     * @since vmaque1.5 
     */
    public List<CommodityConfigData> getAll(PageRoll pageRoll, CommodityConfigData data) {
        pageRoll = PageRoll.set(10, pageRoll);
        return commodityConfigService.getAll(pageRoll, data);
    }
    /**
     * 
     *添加规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品信息实体
     *         list         商品规格信息集合
     * @see CommodityConfigFacade#addCommodityConfigData
     * @since vmaque1.5 
     */
   
    public CommodityConfigData addCommodityConfigData(List<CommodityConfigData> list,GoodsInfoData data) {
       return commodityConfigService.addCommodityConfigData(list,data);
    }

    /**
     * 
     *删除规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品规格信息实体
     * @see CommodityConfigFacade#deleteCommodityConfigData
     * @since vmaque1.5 
     */
    public void deleteCommodityConfigData(CommodityConfigData data) {
        commodityConfigService.deleteCommodityConfigData(data);        
    }

    /**
     * 
     *修改规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品规格信息实体
     * @see CommodityConfigFacade#updateCommodityConfigData
     * @since vmaque1.5 
     */
    public void updateCommodityConfigData(CommodityConfigData data) {
        commodityConfigService.updateCommodityConfigData(data);        
    }

    /**
     * 
     *查询规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品规格信息实体
     * @return CommodityConfigData
     * @see CommodityConfigFacade#getCommodityConfigData
     * @since vmaque1.5 
     */
    public CommodityConfigData getCommodityConfigData(CommodityConfigData data) {
        return commodityConfigService.getCommodityConfigData(data);
    }
    /**
     * 
     *根据商品id查询商品品类<br>
     * @author 侯杨 <br> 
     *         2014-9-10
     * @update 
     * @param  data         商品规格信息实体
     * @return 商品规格信息list集合
     * @see CommodityConfigFacade#getAllByGoodsId
     * @since vmaque1.5 
     */
    public List<CommodityConfigData>   getAllByGoodsId(CommodityConfigData data){
        return commodityConfigService.getAllByGoodsId(data);
    }
    /**
     * 
     *单个删除规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-15
     * @update 
     * @param  data         商品规格信息实体
     * @see CommodityConfigFacade#deleteCommod
     * @since vmaque1.5 
     */
    public void  deleteCommod(CommodityConfigData data){
        commodityConfigService.deleteCommod(data);
    }
    /**
     * 
     *根据父亲id查询规格信息 <br>
     * @author 侯杨 <br> 
     *         2014-12-11
     * @update 
     * @param  data         商品规格信息实体
     * @return 商品规格信息list集合
     * @see CommodityConfigFacade#getAllByParentId(CommodityConfigData)
     * @since vmaque2.0
     */
    public List<CommodityConfigData> getAllByParentId(CommodityConfigData data){
        return commodityConfigService.getAllByParentId(data);
    }
}
