package com.mini.purchase.pagegoodsinfo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.mini.purchase.pagegoodsinfo.business.IPageGoodsInfoBusiness;
import com.mini.purchase.pagegoodsinfo.data.PageGoodsInfoData;

/**
 *〈page和商品信息的service层实现类〉
 * @author    侯杨
 * @date    2014.09.10
 * @see PageGoodsInfoService
 * @since vmaque1.5
 */
@Component("pageGoodsInfoService")
public class PageGoodsInfoService extends FrmService implements IPageGoodsInfoService{
    /**
     * page商品信息business层注入
     */
    @Resource(name="pageGoodsInfoBusiness")
     public IPageGoodsInfoBusiness pageGoodsInfoBusiness;
    /**
     *添加<br>
     * @author 侯杨 <br> 
     *         2014-9-10
     * @update 
     * @param data     page和商品信息实体
     * @see PageGoodsInfoService#addPageGoodsInfoData
     * @since vmaque1.5
     */
    @Override
    public void addPageGoodsInfoData(PageGoodsInfoData data) {
        pageGoodsInfoBusiness.addPageGoodsInfoData(data);
    }
    /**
     *根据pageid查询信息<br>
     * @author 侯杨 <br> 
     *         2014-9-10
     * @update 
     * @param data     page和商品信息实体
     * @return 商品信息和page中间表实体集合 list
     * @see PageGoodsInfoService#getAllByPageId
     * @since vmaque1.5
     */
    @Override
    public List<PageGoodsInfoData>  getAllByPageId(PageGoodsInfoData data){
      return pageGoodsInfoBusiness.getAllByPageId(data);
    }
    /**
     *根据pageid删除信息<br>
     * @author 侯杨 <br> 
     *         2014-9-12
     * @update 
     * @param data     page和商品信息实体
     * @see PageGoodsInfoService#deletePageGoodsInfoData
     * @since vmaque1.5
     */
    @Override
    public void  deletePageGoodsInfoData(PageGoodsInfoData data){
      //查询中间表信息
        List<PageGoodsInfoData> list=pageGoodsInfoBusiness.getAllByPageId(data);
        if(list!=null && list.size()>0){
            //循环删除page和商品信息中间表
            for (int i = 0; i < list.size(); i++) {
                pageGoodsInfoBusiness.deletePageGoodsInfoData(list.get(i));
            }
        }
    }
  
}
