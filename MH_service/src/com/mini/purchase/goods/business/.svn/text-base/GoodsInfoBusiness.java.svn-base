package com.mini.purchase.goods.business;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.purchase.goods.data.GoodsInfoData;
import com.mini.purchase.goods.persistence.IGoodsInfoPersistence;

/**
 * 
 * 商品信息Business实现类<br> 
 *          2014-9-9
 * @author 侯杨
 * @see GoodsInfoBusiness
 * @since vmaque1.5
 */
@Component("goodsInfoBusiness")
public class GoodsInfoBusiness extends FrmBusiness implements IGoodsInfoBusiness{
    /**
     * 商品信息持久化层接口 容器注入
     */
    @Resource(name="goodsInfoPersistence")
    private IGoodsInfoPersistence goodsInfoPersistence;
    /**
     * 
     *查询所有的商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param pageRoll    分页
     *        data        商品信息实体
     * @return  商品信息list集合
     * @see GoodsInfoBusiness#getAll
     * @since vmaque1.5
     */
    @Override
    public List<GoodsInfoData> getAll(PageRoll pageRoll, GoodsInfoData data) {
        return null;
    }
    /**
     * 
     *添加商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实体
     * @see GoodsInfoBusiness#addGoodsInfoData
     * @since vmaque1.5
     */
    @Override
    public void addGoodsInfoData(GoodsInfoData data) {
        data.setCreateTime(new Date());
        data.setIsDelete(1);
        goodsInfoPersistence.add(data);
        
    }
    /**
     * 
     *删除商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实体
     * @see GoodsInfoBusiness#deleteGoodsInfoData
     * @since vmaque1.5
     */
    @Override
    public void deleteGoodsInfoData(GoodsInfoData data) {
        if(data!=null){
            goodsInfoPersistence.delete(data);
        }
    } 
    /**
     * 
     *修改商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实
     * @see GoodsInfoBusiness#updateGoodsInfoData
     * @since vmaque1.5
     */
    @Override
    public void updateGoodsInfoData(GoodsInfoData data) {
        if(data!=null){
            GoodsInfoData infoData= goodsInfoPersistence.retrieve(data.getId());
           /* if(data.getPostage()!=null && !"".equals(data.getPostage())){
                infoData.setPostage(data.getPostage());
            }*/
            if(data.getGoodsExpress()!=null && !"".equals(data.getGoodsExpress())){
                infoData.setGoodsExpress(data.getGoodsExpress());
            }
            if(data.getPromotion()!=null && !"".equals(data.getPromotion())){
                infoData.setPromotion(data.getPromotion());
            }
            if(data.getGoodsDes()!=null && !"".equals(data.getGoodsDes())){
                infoData.setGoodsDes(data.getGoodsDes());
            }
            if(data.getGoodsName()!=null && !"".equals(data.getGoodsName())){
                infoData.setGoodsName(data.getGoodsName());
            }
            if(data.getGoodsImg()!=null && !"".equals(data.getGoodsImg())){
                infoData.setGoodsImg(data.getGoodsImg());
            }
            goodsInfoPersistence.update(infoData);
        }
            
    }
    /**
     *查询商品信息<br>
     * @author 侯杨 <br> 
     *         2014-9-9
     * @update 
     * @param data   商品信息实体
     * @return GoodsInfoData实体
     * @see GoodsInfoBusiness#getGoodsInfoData
     * @since vmaque1.5
     */
    @Override
    public GoodsInfoData getGoodsInfoData(GoodsInfoData data) {
        return  goodsInfoPersistence.retrieve(data.getId());
    }

}
