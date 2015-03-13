package com.mini.product.business;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBusiness;
import com.mini.order.data.OrderProductData;
import com.mini.product.data.PageProductData;

/**
 * page服务中间表业务接口
 * 
 * @author 林海鹏
 * @see IPageProductBusiness
 * @since
 */
public interface IPageProductBusiness extends IBusiness {
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
     * @see IPageProductBusiness#getPageProductData(OrderProductData)
     * @since
     */
    public PageProductData getPageProductData(OrderProductData orderProductData);

    /**
     * 
     * 根据服务id和PageId 添加或修改服务<br>
     * 
     * @author 文东 <br>
     *         2014-4-28
     * @update
     * @param pageProductData page服务对象 内存放Page服务参数
     * @return void 无返回值
     * @exception/throws
     * @see IPageProductBusiness#editOrAddByPageIdAndProductId(PageProductData)
     * @since
     */
    public void editOrAddByPageIdAndProductId(PageProductData pageProductData);

    /**
     * 
     * 根据条件将查询到的Page服务删除<br>
     * 
     * @author 文东 <br>
     *         2014-4-28
     * @update
     * @param pageProductData page服务对象 内存放Page服务参数
     * @return void 无返回值
     * @exception/throws
     * @see IPageProductBusiness#delPageProduct(PageProductData)
     * @since
     */
    public void delPageProduct(PageProductData pageProductData);

    /**
     * 
     * 修改Page页面的电话号码<br>
     * 
     * @author 文东 <br>
     *         2014-4-29
     * @update
     * @param pageProductData Page服务中间表对象
     * @return void
     * @exception/throws
     * @see IPageProductBusiness#editTel()
     * @since
     */
    public void editTel(PageProductData pageProductData);

    /**
     * 
     * 根据条件查询Page服务<br>
     * 
     * @author 文东 <br>
     *         2014-4-29
     * @update
     * @param pageProductData 条件查询的参数
     * @return List<PageProductData> Page服务中间表集合
     * @exception/throws
     * @see IPageProductBusiness#searchPageProducts(PageProductData)
     * @since
     */
    public List<PageProductData> searchPageProducts(PageProductData pageProductData);
}
