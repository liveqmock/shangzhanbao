package com.mini.purchase.commodityConfig.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.purchase.commodityConfig.business.ICommodityConfigBusiness;
import com.mini.purchase.commodityConfig.data.CommodityConfigData;
import com.mini.purchase.goods.data.GoodsInfoData;

/**
 * 
 * 商品规格service实现类<br> 
 *          2014-9-9
 *
 * @author 侯杨
 * @see CommodityConfigService
 * @since vmaque1.5 
 */
@Component("commodityConfigService")
public class CommodityConfigService extends FrmService implements ICommodityConfigService{
    /**
     * 规格信息持久化层注入
     */
    @Resource(name="commodityConfigBusiness")
     private ICommodityConfigBusiness  commodityConfigBusiness;
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
     * @see CommodityConfigService#getAll
     * @since vmaque1.5 
     */
    @Override
    public List<CommodityConfigData> getAll(PageRoll pageRoll, CommodityConfigData data) {
        pageRoll = PageRoll.set(10, pageRoll);
        return commodityConfigBusiness.getAll(pageRoll, data);
    }
    /**
     * 
     *添加规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品信息实体
     *         list         商品规格信息集合
     * @see CommodityConfigService#addCommodityConfigData
     * @since vmaque1.5 
     */
    @Override
    public CommodityConfigData addCommodityConfigData(List<CommodityConfigData> list,GoodsInfoData data) {
      //添加商品信息规格
        CommodityConfigData  commodityConfigData=new CommodityConfigData();
        CommodityConfigData  commodityConfigData2=new CommodityConfigData();
        if(list.size()>0 && list!=null){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId()!=null && !"".equals(list.get(i).getId())){
                list.get(i).setGoodsInfoId(data.getId());
                //父亲id
                if(list.get(i).getType()==1){
                    commodityConfigData2.setParentId(list.get(i).getId());
                }
                //子级id
                if(list.get(i).getType()==2){
                    commodityConfigData2.setId(list.get(i).getId());
                }
                commodityConfigData2.setGoodsInfoId(data.getId());
                commodityConfigBusiness.updateCommodityConfigData( list.get(i));
            }else{
                if(list.get(i).getType()==1){
                  //添加品类
                    commodityConfigData=list.get(i);
                    commodityConfigData.setGoodsInfoId(data.getId());
                    commodityConfigBusiness.addCommodityConfigData(commodityConfigData);
                }else{
                    //添加规格
                    //当页面添加的规格名称不为空的时候执行添加
                    commodityConfigData2=list.get(i);
                    commodityConfigData2.setGoodsInfoId(data.getId());
                    if(commodityConfigData.getId()!=null && !"".equals(commodityConfigData.getId())){
                    commodityConfigData2.setParentId(commodityConfigData.getId());
                    }
                    if(list.get(i).getConfigName()!=null && !"".equals(list.get(i).getConfigName())){
                    commodityConfigBusiness.addCommodityConfigData(commodityConfigData2);
                   }
                }
            }
        }
      }
        return commodityConfigData2;
    }
    /**
     * 
     *循环删除规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品规格信息实体
     * @see CommodityConfigService#deleteCommodityConfigData
     * @since vmaque1.5 
     */
    @Override
    public void deleteCommodityConfigData(CommodityConfigData data) {
        List<CommodityConfigData> list1=commodityConfigBusiness.getAllByGoodsId(data);
        //循环删除规格信息
        if(list1!=null && list1.size()>0){
            for (int i = 0; i <list1.size(); i++) {
                commodityConfigBusiness.deleteCommodityConfigData(list1.get(i));
            }
        }
    }
    /**
     * 
     *修改规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品规格信息实体
     * @see CommodityConfigService#updateCommodityConfigData
     * @since vmaque1.5 
     */
    @Override
    public void updateCommodityConfigData(CommodityConfigData data) {
        commodityConfigBusiness.updateCommodityConfigData(data);        
    }
    /**
     * 
     *查询规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品规格信息实体
     * @return CommodityConfigData
     * @see CommodityConfigService#getCommodityConfigData
     * @since vmaque1.5 
     */
    @Override
    public CommodityConfigData getCommodityConfigData(CommodityConfigData data) {
        return commodityConfigBusiness.getCommodityConfigData(data);
    }
    /**
     * 
     *根据商品id查询商品品类<br>
     * @author 侯杨 <br> 
     *         2014-9-10
     * @update 
     * @param  data         商品规格信息实体
     * @return 商品规格信息list集合
     * @see CommodityConfigService#getAllByGoodsId
     * @since vmaque1.5 
     */
    @Override
    public List<CommodityConfigData>   getAllByGoodsId(CommodityConfigData data){
        return commodityConfigBusiness.getAllByGoodsId(data);
    }
    /**
     * 
     *单个删除规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-15
     * @update 
     * @param  data         商品规格信息实体
     * @see CommodityConfigService#deleteCommod
     * @since vmaque1.5 
     */
    public void  deleteCommod(CommodityConfigData data){
        commodityConfigBusiness.deleteCommodityConfigData(data);
    }
    /**
     * 
     *根据父亲id查询规格信息 <br>
     * @author 侯杨 <br> 
     *         2014-12-11
     * @update 
     * @param  data         商品规格信息实体
     * @return 商品规格信息list集合
     * @see CommodityConfigService#getAllByParentId(CommodityConfigData)
     * @since vmaque2.0
     */
    @Override
    public List<CommodityConfigData> getAllByParentId(CommodityConfigData data){
        return commodityConfigBusiness.getAllByParentId(data);
    }
}
