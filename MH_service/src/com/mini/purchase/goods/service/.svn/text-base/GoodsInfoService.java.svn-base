package com.mini.purchase.goods.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.purchase.goods.business.IGoodsInfoBusiness;
import com.mini.purchase.goods.data.GoodsInfoData;

/**
 * 
 * 商品信息Servic实现类<br> 
 *       2014-9-9
 * @author 侯杨
 * @see GoodsInfoService
 * @since vmaque1.5
 */
@Component("goodsInfoService")
public class GoodsInfoService extends FrmService implements IGoodsInfoService{
    /**
     * 商品信息business层接口 容器注入
     */
    @Resource(name="goodsInfoBusiness")
    private IGoodsInfoBusiness goodsInfoBusiness;
    /**
     * 
     *查询所有的商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param pageRoll    分页
     *        data        商品信息实体
     * @return  商品信息list集合
     * @see #getAll
     * @since vmaque1.5
     */
    @Override
    public List<GoodsInfoData> getAll(PageRoll pageRoll, GoodsInfoData data) {
        pageRoll = PageRoll.set(10, pageRoll);
        return goodsInfoBusiness.getAll(pageRoll, data);
    }
    /**
     * 
     *添加商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实体
     *  @see #addGoodsInfoData
     * @since vmaque1.5
     */
    @Override
    public void addGoodsInfoData(GoodsInfoData data) {
        goodsInfoBusiness.addGoodsInfoData(data);        
    }
    /**
     * 
     *删除商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实体
     * @see #deleteGoodsInfoData
     * @since vmaque1.5
     */
    @Override
    public void deleteGoodsInfoData(GoodsInfoData data) {
        goodsInfoBusiness.deleteGoodsInfoData(data);
    }
    /**
     * 
     *修改商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实
     * @see #updateGoodsInfoData
     * @since vmaque1.5
     */
    @Override
    public void updateGoodsInfoData(GoodsInfoData data) {
        goodsInfoBusiness.updateGoodsInfoData(data);        
    }
    /**
     *查询商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实体
     * @return GoodsInfoData实体
     * @see #getGoodsInfoData
     * @since vmaque1.5
     */
    @Override
    public GoodsInfoData getGoodsInfoData(GoodsInfoData data) {
        return goodsInfoBusiness.getGoodsInfoData(data);
    }

    
   
}
