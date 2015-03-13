package com.mini.product.persistence;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBasePersistence;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.order.data.OrderProductData;
import com.mini.page.data.PageData;
import com.mini.product.data.PageProductData;

/**
 * page服务中间表久化层接口
 * 
 * @author 林海鹏
 * @see IPageProductPersistence
 * @since
 */
public interface IPageProductPersistence extends IBasePersistence<PageProductData> {
    /**
     * 增加服务使用page
     * 
     * @param data
     */
    void addPageProduct(PageProductData data);

    /**
     * 修改
     * 
     * @param data
     */
    void editPageProduct(PageProductData data);

    /**
     * 删除
     * 
     * @param ids
     */
    void deletePageProduct(String[] ids);

    /**
     * 根据Page服务中间表id查询实体信息
     * @param id
     * @return
     */
    public PageProductData getPageProductByid(String id);
    
    /**
     * 通过条件查询返回对象
     * 
     * @param object
     * @return
     */
    public List<PageProductData> getPageProductDataByJson(JSONObject object);

    /**
     * 
     * 获取Page服务中间表<br>
     * 
     * @author 文东 <br>
     *         2014-4-8
     * @update
     * @param orderProductData 订单服务中间表
     * @return PageProductData Page所包含的服务对象
     * @exception/throws
     * @see IPageProductPersistence#getPageProductData(OrderProductData)
     * @since
     */
    public PageProductData getPageProductData(OrderProductData orderProductData);

    /**
     * 
     * 根据PageID获取Page服务中间表对象集合<br>
     * 
     * @author 文东 <br>
     *         2014-4-15
     * @param pageInfoExtraData 
     * @update
     * @param pageId PageId
     * @return List<PageProductData> page服务中间表集合
     * @exception/throws
     * @see IPageProductPersistence#getPageProductByPageId(String)
     * @since
     */
    public List<PageProductData> getPageProductByPageId(PageInfoExtraData pageInfoExtraData, PageData data,String pageId);

    /**
     * 
     * 获取Page服务中间表信息<br>
     * 
     * @author 文东 <br>
     *         2014-4-28
     * @update
     * @param pageProductData Page服务中间表 存放条件查询参数
     * @return PageProductData Page服务中间表
     * @exception/throws
     * @see IPageProductPersistence#getPageProductData(pageProductData)
     * @since
     */
    public PageProductData getPageProductData(PageProductData pageProductData);
}
