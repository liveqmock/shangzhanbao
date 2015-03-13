package com.mini.purchase.goods.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.purchase.goods.data.GoodsInfoData;
import com.mini.purchase.goods.service.IGoodsInfoService;

/**
 * 
 * 商品信息facade层<br> 
 *       2014-9-9
 * @author 侯杨
 * @see GoodsInfoFacade
 * @since vmaque1.5
 */
@Component("goodsInfoFacade")
public class GoodsInfoFacade extends FrmFacade{
    /**
     * 商品信息service层接口 容器注入
     */
    @Resource(name="goodsInfoService")
    private IGoodsInfoService goodsInfoService;
    /**
     * 
     *查询所有的商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param pageRoll    分页
     *        data        商品信息实体
     * @return  商品信息list集合
     * @see GoodsInfoFacade#getAll
     * @since vmaque1.5
     */
    public List<GoodsInfoData> getAll(PageRoll pageRoll, GoodsInfoData data) {
        pageRoll = PageRoll.set(10, pageRoll);
        return goodsInfoService.getAll(pageRoll, data);
    }
    /**
     * 
     *添加商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实体
     * @see GoodsInfoFacade#addGoodsInfoData
     * @since vmaque1.5
     */
    public void addGoodsInfoData(GoodsInfoData data) {
        goodsInfoService.addGoodsInfoData(data);        
    }
    /**
     * 
     *删除商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实体
     * @see GoodsInfoFacade#deleteGoodsInfoData
     * @since vmaque1.5
     */
    public void deleteGoodsInfoData(GoodsInfoData data) {
        goodsInfoService.deleteGoodsInfoData(data);
    } 
    /**
     * 
     *修改商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实
     * @see GoodsInfoFacade#updateGoodsInfoData
     * @since vmaque1.5
     */
    public void updateGoodsInfoData(GoodsInfoData data) {
        goodsInfoService.updateGoodsInfoData(data);        
    }
    /**
     *查询商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实体
     * @return GoodsInfoData实体
     * @see GoodsInfoFacade#getGoodsInfoData
     * @since vmaque1.5
     */
    public GoodsInfoData getGoodsInfoData(GoodsInfoData data) {
        return goodsInfoService.getGoodsInfoData(data);
    }

    
}
