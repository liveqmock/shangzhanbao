package com.mini.product.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IService;
import com.mini.order.data.OrderProductData;
import com.mini.product.data.PageProductData;
/**
 * page服务中间表服务接口
 * 
 * @author 林海鹏
 * @see IPageProductService
 * @since
 */
public interface IPageProductService extends IService{
	/**
	 * 增加服务使用page
	 * @param data
	 */
	void addPageProduct(PageProductData data);
	/**
	 * 修改
	 * @param data
	 */
	void editPageProduct(PageProductData data);
	/**
	 * 删除
	 * @param ids
	 */
	void deletePageProduct(String [] ids);
	/**
	 * 通过条件查询返回对象
	 * @param object
	 * @return
	 */
	public  List<PageProductData> getPageProductDataByJson(JSONObject object);
	
	 /**
     * 根据Page服务中间表id查询实体信息
     * @param id
     * @return
     */
    public PageProductData getPageProductByid(String id);
    
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
     * @see IPageProductService#getPageProductData(OrderProductData)
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
     * @see IPageProductService#editOrAddByPageIdAndProductId(PageProductData)
     * @since
     */
    public void editOrAddByPageIdAndProductId(PageProductData pageProductData);
    
    /**
     * 
     * 删除编辑或创建Page时选中的服务<br>
     * 
     * @author 文东 <br>
     *         2014-4-28
     * @update
     * @param pageProductData Page服务中间表对象 内存放条件参数
     * @return void
     * @exception/throws
     * @see IPageProductService#delPageProduct(PageProductData)
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
     * @see IPageProductService#editTel()
     * @since
     */
    public void editTel(PageProductData pageProductData);
}
