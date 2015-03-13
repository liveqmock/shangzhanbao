package com.mini.purchase.pagegoodsinfo.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.purchase.pagegoodsinfo.data.PageGoodsInfoData;
import com.mini.purchase.pagegoodsinfo.persistence.IPageGoodsInfoPersistence;

/**
 *〈page和商品信息的business层实现类〉
 * @author    侯杨
 *         2014-9-10
 * @see PageGoodsInfoBusiness
 * @since vmaque1.5 
 */
@Component("pageGoodsInfoBusiness")
public class PageGoodsInfoBusiness extends FrmBusiness implements IPageGoodsInfoBusiness{
    
    /**
     * page商品信息持久化层注入
     */
    @Resource(name="pageGoodsInfoPersistence")
     public IPageGoodsInfoPersistence pageGoodsInfoPersistence;
    /**
     *添加或者修改<br>
     * @author 侯杨 <br> 
     *         2014-9-10
     * @update 
     * @param data     page和商品信息实体
     * @see PageGoodsInfoBusiness#addPageGoodsInfoData
     * @since vmaque1.5
     */
    @Override
    public void addPageGoodsInfoData(PageGoodsInfoData data){
              pageGoodsInfoPersistence.add(data);
    }
    /**
     *根据pageid查询信息<br>
     * @author 侯杨 <br> 
     *         2014-9-10
     * @update 
     * @param data     page和商品信息实体
     * @return 商品信息和page中间表实体集合 list
     * @see PageGoodsInfoBusiness#getAllByPageId
     * @since vmaque1.5
     */
    @Override
    public List<PageGoodsInfoData> getAllByPageId(PageGoodsInfoData data){
        List<PageGoodsInfoData> list=null;
        if(data!=null){
            String hql="from PageGoodsInfoData p where p.pageId = ?";
            list=pageGoodsInfoPersistence.search(hql, new Object[]{data.getPageId()});
        }
        return list;
    }
    /**
     *根据pageid删除信息<br>
     * @author 侯杨 <br> 
     *         2014-9-12
     * @update 
     * @param data     page和商品信息实体
     * @see PageGoodsInfoBusiness#deletePageGoodsInfoData
     * @since vmaque1.5
     */
    public void  deletePageGoodsInfoData(PageGoodsInfoData data){
       pageGoodsInfoPersistence.delete(data);
    }  
    /**
     * 
     * 根据商品信息id查询此商品所对应的pageid<br>
     * 
     * @author 冯鑫<br> 
     *		   2014-9-13
     * @update ［更改人，更改时间，更改内容描述，更改位置 n行－m行］
     * @param data
     * @return  PageGoodsInfoData
     * @exception/throws 
     * @see   PageGoodsInfoBusiness#findPageGoodsInfoDataByGoodsInfoId
     * @since vmaque1.5
     */
    public PageGoodsInfoData findPageGoodsInfoDataByGoodsInfoId(PageGoodsInfoData data){
        List<PageGoodsInfoData> list=null;
        if(data!=null){
            String hql="from PageGoodsInfoData p where p.goodsInfoId = ?";
            list=pageGoodsInfoPersistence.search(hql, new Object[]{data.getId()});
        }
        return list.get(0);
    }

}
