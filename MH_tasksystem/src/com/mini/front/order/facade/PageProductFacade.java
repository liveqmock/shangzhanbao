package com.mini.front.order.facade;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.order.data.OrderProductData;
import com.mini.product.data.PageProductData;
import com.mini.product.service.IPageProductService;

/**
 * page服务中间表facade层
 * 
 * @author 林海鹏
 * @see PageProductFacade
 * @since
 * 
 */
@Component("pageProductFacade")
public class PageProductFacade extends FrmFacade {
    @Resource(name = "pageProductService")
    private IPageProductService pageProductService;

    public void setPageProductService(IPageProductService pageProductService) {
        this.pageProductService = pageProductService;
    }

    /**
     * 新增
     * 
     * @param data
     */
    public void addPageProduct(PageProductData data) {
        pageProductService.addPageProduct(data);
    }

    /**
     * 删除
     * 
     * @param ids
     */
    public void deletePageProduct(String[] ids) {
        pageProductService.deletePageProduct(ids);
    }

    /**
     * 修改
     * 
     * @param data
     */
    public void editPageProduct(PageProductData data) {
        pageProductService.editPageProduct(data);
    }

    /**
     * 通过条件查询返回对象
     * 
     * @param object
     * @return
     */
    public List<PageProductData> getPageProductDataByJson(JSONObject object) {
        return pageProductService.getPageProductDataByJson(object);
    }

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
     * @see PageProductFacade#getPageProductData(OrderProductData)
     * @since
     */
    public PageProductData getPageProductData(OrderProductData orderProductData) {
        return pageProductService.getPageProductData(orderProductData);
    }

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
     * @see PageProductFacade#editOrAddByPageIdAndProductId(PageProductData)
     * @since
     */
    public void editOrAddByPageIdAndProductId(PageProductData pageProductData) {
        pageProductService.editOrAddByPageIdAndProductId(pageProductData);
    }

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
     * @see PageProductFacade#delPageProduct(PageProductData)
     * @since
     */
    public void delPageProduct(PageProductData pageProductData) {
        pageProductService.delPageProduct(pageProductData);
    }
    
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
     * @see PageProductFacade#editTel()
     * @since
     */
    public void editTel(PageProductData pageProductData) {
        pageProductService.editTel(pageProductData);
    }

}
