package com.mini.purchase.pagegoodsinfo.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.purchase.pagegoodsinfo.data.PageGoodsInfoData;
import com.mini.purchase.pagegoodsinfo.service.IPageGoodsInfoService;

/**
 *〈page和商品信息的facade层〉
 * @author    侯杨
 * @date    2014.09.10
 * @see PageGoodsInfoFacade
 * @since vmaque1.5
 */
@Component("pageGoodsInfoFacade")
public class PageGoodsInfoFacade extends FrmFacade{
    /**
     * page商品信息service层注入
     */
    @Resource(name="pageGoodsInfoService")
     public IPageGoodsInfoService pageGoodsInfoService;
    /**
     *添加<br>
     * @author 侯杨 <br> 
     *         2014-9-10
     * @update 
     * @param data     page和商品信息实体
     * @see PageGoodsInfoFacade#addPageGoodsInfoData
     * @since vmaque1.5
     */
    public void addPageGoodsInfoData(PageGoodsInfoData data) {
        pageGoodsInfoService.addPageGoodsInfoData(data);
    }
    /**
     *根据pageid查询信息<br>
     * @author 侯杨 <br> 
     *         2014-9-10
     * @update 
     * @param data     page和商品信息实体
     * @return 商品信息和page中间表实体集合 list
     * @see PageGoodsInfoFacade#getAllByPageId
     * @since vmaque1.5
     */
    public List<PageGoodsInfoData>  getAllByPageId(PageGoodsInfoData data){
      return pageGoodsInfoService.getAllByPageId(data);
    }
    /**
     *根据pageid删除信息<br>
     * @author 侯杨 <br> 
     *         2014-9-12
     * @update 
     * @param data     page和商品信息实体
     * @see PageGoodsInfoFacade#deletePageGoodsInfoData
     * @since vmaque1.5
     */
    public void  deletePageGoodsInfoData(PageGoodsInfoData data){
        pageGoodsInfoService.deletePageGoodsInfoData(data);
    }
}
