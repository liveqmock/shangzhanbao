package com.mini.purchase.pagegoodsinfo.business;

import java.util.List;

import com.itour.etip.pub.base.IBusiness;
import com.mini.purchase.pagegoodsinfo.data.PageGoodsInfoData;

/**
 *〈page和商品信息的business层接口〉
 * @author    侯杨
 * @date    2014.09.10
 * @see IPageGoodsInfoBusiness
 * @since vmaque1.5
 */
public interface IPageGoodsInfoBusiness extends IBusiness{
    /**
     *添加<br>
     * @author 侯杨 <br> 
     *		   2014-9-10
     * @update 
     * @param data     page和商品信息实体
     * @see IPageGoodsInfoBusiness#addPageGoodsInfoData
     * @since vmaque1.5
     */
    public void addPageGoodsInfoData(PageGoodsInfoData data);
    /**
     *根据pageid查询信息<br>
     * @author 侯杨 <br> 
     *         2014-9-10
     * @update 
     * @param data     page和商品信息实体
     * @return 商品信息和page中间表实体集合 list
     * @see IPageGoodsInfoBusiness#getAllByPageId
     * @since vmaque1.5
     */
    public List<PageGoodsInfoData>  getAllByPageId(PageGoodsInfoData data);
    /**
     *根据pageid删除信息<br>
     * @author 侯杨 <br> 
     *         2014-9-12
     * @update 
     * @param data     page和商品信息实体
     * @see IPageGoodsInfoBusiness#deletePageGoodsInfoData
     * @since vmaque1.5
     */
    public void  deletePageGoodsInfoData(PageGoodsInfoData data);
    /**
     * 
     * 根据商品信息id查询此商品所对应的pageid<br>
     * 
     * @author 冯鑫<br> 
     *         2014-9-13
     * @update 
     * @param data
     * @return  PageGoodsInfoData
     * @exception/throws 
     * @see   PageGoodsInfoBusiness#findPageGoodsInfoDataByGoodsInfoId
     * @since vmaque1.5
     */
    public PageGoodsInfoData findPageGoodsInfoDataByGoodsInfoId(PageGoodsInfoData data);
}
