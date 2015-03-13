package com.mini.purchase.pagegoodsinfo.service;

import java.util.List;

import com.itour.etip.pub.base.IService;
import com.mini.purchase.pagegoodsinfo.data.PageGoodsInfoData;

/**
 * 
 *〈page和商品信息的service层接口〉
 * @author    侯杨
 *         2014-9-10
 * @see IPageGoodsInfoService
 * @since vmaque1.5
 */
public interface IPageGoodsInfoService extends IService{
    /**
     *添加<br>
     * @author 侯杨 <br> 
     *         2014-9-10
     * @update 
     * @param data     page和商品信息实体
     * @see IPageGoodsInfoService#addPageGoodsInfoData
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
     * @see IPageGoodsInfoService#getAllByPageId
     * @since vmaque1.5
     */
    public List<PageGoodsInfoData>  getAllByPageId(PageGoodsInfoData data);
    /**
     *根据pageid删除信息<br>
     * @author 侯杨 <br> 
     *         2014-9-12
     * @update 
     * @param data     page和商品信息实体
     * @see IPageGoodsInfoService#deletePageGoodsInfoData
     * @since vmaque1.5
     */
    public void  deletePageGoodsInfoData(PageGoodsInfoData data);
}
