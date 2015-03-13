package com.mini.purchase.commodityConfig.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.purchase.commodityConfig.data.CommodityConfigData;
import com.mini.purchase.commodityConfig.persistence.ICommodityConfigPersistence;

/**
 * 
 * 商品规格business实现类<br> 
 *          2014-9-9
 *
 * @author 侯杨
 * @see ICommodityConfigBusiness
 * @since vmaque1.5  
 */
@Component("commodityConfigBusiness")
public class CommodityConfigBusiness extends FrmBusiness implements ICommodityConfigBusiness{
    /**
     * 规格信息持久化层注入
     */
    @Resource(name="commodityConfigPersistence")
     private ICommodityConfigPersistence commodityConfigPersistence;
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
     * @see CommodityConfigBusiness#getAll
     * @since vmaque1.5 
     */
    @Override
    public List<CommodityConfigData> getAll(PageRoll pageRoll, CommodityConfigData data) {
        // TODO Auto-generated method stub
        return null;
    }
    /**
     * 
     *添加规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品规格信息实体
     * @see CommodityConfigBusiness#addCommodityConfigData
     * @since vmaque1.5 
     */
    @Override
    public void addCommodityConfigData(CommodityConfigData data) {
        data.setCreateTime(new Date());
        data.setIsDelete(1);
        commodityConfigPersistence.add(data);
        
    }
    /**
     * 
     *删除规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品规格信息实体
     * @see CommodityConfigBusiness#deleteCommodityConfigData
     * @since vmaque1.5 
     */
    @Override
    public void deleteCommodityConfigData(CommodityConfigData data) {
        if(data!=null){
            commodityConfigPersistence.delete(data);
        }
    }
    /**
     * 
     *修改规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品规格信息实体
     * @see CommodityConfigBusiness#updateCommodityConfigData
     * @since vmaque1.5 
     */
    @Override
    public void updateCommodityConfigData(CommodityConfigData data) {
        if(data!=null){
            CommodityConfigData configData=commodityConfigPersistence.retrieve(data.getId());
            data.setCreateTime(configData.getCreateTime());
            data.setIsDelete(configData.getIsDelete());
            commodityConfigPersistence.update(data);
        }
    }
    /**
     * 
     *查询规格信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param  data         商品规格信息实体
     * @return CommodityConfigData
     * @see CommodityConfigBusiness#getCommodityConfigData
     * @since vmaque1.5 
     */
    @Override
    public CommodityConfigData getCommodityConfigData(CommodityConfigData data) {
         return commodityConfigPersistence.retrieve(data.getId());
    }
    /**
     * 
     *根据商品id查询商品品类<br>
     * @author 侯杨 <br> 
     *         2014-9-10
     * @update 
     * @param  data         商品规格信息实体
     * @return 商品规格信息list集合
     * @see CommodityConfigBusiness#getAllByGoodsId
     * @since vmaque1.5 
     */
    @Override
    public List<CommodityConfigData>   getAllByGoodsId(CommodityConfigData data){
        List<CommodityConfigData> list=new ArrayList<CommodityConfigData>();
        if(data!=null){
            String hql="from CommodityConfigData c where c.goodsInfoId = ? and c.isDelete = 1 and c.type=1 ";
            list=commodityConfigPersistence.search(hql, new Object[]{data.getGoodsInfoId()});
        }
        return list;
    }
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
    @Override
    public List<CommodityConfigData> getAllByParentId(CommodityConfigData data){
        List<CommodityConfigData> list=new ArrayList<CommodityConfigData>();
        if(data.getParentId()!=null && !"".equals(data.getParentId())){
            String hql="from CommodityConfigData c where  c.parentId = ? and c.isDelete = 1 and c.type=2  order by c.configPrice asc";
            list=commodityConfigPersistence.search(hql, new Object[]{data.getParentId()});
        }
        return list;
    }
   
}
