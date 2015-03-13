package com.mini.product.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.order.data.OrderProductData;
import com.mini.product.data.PageProductData;
import com.mini.product.persistence.IPageProductPersistence;

/**
 * page服务中间表业务接口实现类
 * 
 * @author 林海鹏
 * @see PageProductBusiness
 * @since
 */
@Component("pageProductBusiness")
public class PageProductBusiness extends FrmBusiness implements
		IPageProductBusiness {
	@Resource(name = "pageProductPersistence")
	private IPageProductPersistence pageProductPersistence;

	public void setPageProductPersistence(
			IPageProductPersistence pageProductPersistence) {
		this.pageProductPersistence = pageProductPersistence;
	}

	/**
	 * 新增
	 */
	@Override
	public void addPageProduct(PageProductData data) {
		if (data != null) {
			if (data.getExpireTime() == null
					&& (data.getYeraNum() != null)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.YEAR, data.getYeraNum());
				data.setExpireTime(cal.getTime());
			}
		}
		pageProductPersistence.add(data);
	}

	@Override
	public void deletePageProduct(String[] ids) {
		pageProductPersistence.delete(ids);
	}

	@Override
	public void editPageProduct(PageProductData data) {
		pageProductPersistence.editPageProduct(data);
	}

	 /**
     * 根据Page服务中间表id查询实体信息
     * @param id
     * @return
     */
    public PageProductData getPageProductByid(String id){
    	return pageProductPersistence.getPageProductByid(id);
    }
	
	@Override
	public List<PageProductData> getPageProductDataByJson(JSONObject object) {
		return pageProductPersistence.getPageProductDataByJson(object);
	}

	/* (non-Javadoc)
	 * @see com.mini.product.business.IPageProductBusiness#getPageProductData(com.mini.order.data.OrderProductData)
	 * 根据pageid和productid查询中间表数据
	 */
	@Override
	public PageProductData getPageProductData(OrderProductData orderProductData) {
		return pageProductPersistence.getPageProductData(orderProductData);
	}

    @Override
    public void editOrAddByPageIdAndProductId(PageProductData pageProductData) {
        // 根据PageId和服务Id 查询获取服务信息
        PageProductData data = pageProductPersistence.getPageProductData(pageProductData);
        if(data != null){// 若该Page已经拥有这个服务则执行更新操作
            data.setProductContent(pageProductData.getProductContent());
            pageProductPersistence.update(data);
        }else{// 若该Page没有这项服务则执行添加操作
            pageProductData.setIsdelete(1);
            pageProductData.setCreateTime(new Date());// 服务开始时间
            pageProductData.setStatus(1);// 由于是免费服务 所以状态默认为开启状态
            pageProductData.setYeraNum(1);// 年限默认为1年
            this.addPageProduct(pageProductData);
        }
    }

    @Override
    public void delPageProduct(PageProductData pageProductData) {
        // 获取查询结果
        if(pageProductData.getPageId() !=null &&
                pageProductData.getProductId()!=null && 
                !pageProductData.getPageId().equals("")  && 
                !pageProductData.getProductId().equals("")){
            List<PageProductData> pageProductDatas = this.searchPageProducts(pageProductData);
            for (int i = 0; i < pageProductDatas.size(); i++) {
                pageProductPersistence.delete(pageProductDatas.get(i));
            }
        }
    }

    @Override
    public void editTel(PageProductData pageProductData) {
        // 获取条件查询结果
        List<PageProductData> pageProductDatas = this.searchPageProducts(pageProductData);
        for (int i = 0; i < pageProductDatas.size(); i++) {
            PageProductData data = new PageProductData();
            data = pageProductDatas.get(i);
            if(null != pageProductData.getProductContent() && !"".equals(pageProductData.getProductContent())){
	            data.setProductContent(pageProductData.getProductContent());
	            pageProductPersistence.update(data);// 更新电话号码
            }
        }
    }

    @Override
    public List<PageProductData> searchPageProducts(PageProductData pageProductData) {
     // 定义条件查询HQL语句
        StringBuffer hql = new StringBuffer("from PageProductData where 1=1");
        // 定义查询参数
        List<Object> objects = new ArrayList<Object>();
        if(pageProductData.getPageId()!=null && !pageProductData.getPageId().equals("")){
            hql.append(" and pageId = ?");
            objects.add(pageProductData.getPageId());
        }
        if(pageProductData.getProductId()!=null && !pageProductData.getProductId().equals("")){
            hql.append(" and productId = ?");
            objects.add(pageProductData.getProductId());
        }
        // 查询得到结果
        return pageProductPersistence.search(hql.toString(), objects);
    }

}
