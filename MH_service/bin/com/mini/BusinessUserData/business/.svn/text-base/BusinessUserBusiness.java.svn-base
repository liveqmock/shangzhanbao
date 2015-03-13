package com.mini.BusinessUserData.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.BusinessUserData.data.BusinessUserData;
import com.mini.BusinessUserData.persistence.IBusinessUserPersistence;
import com.mini.order.data.OrderProductData;
import com.mini.order.persistence.IOrderProductPersistence;
import com.mini.product.data.PageProductData;
import com.mini.product.persistence.IPageProductPersistence;
/**
 * 〈服务 BusinessUser  business 实现类〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("businessUserBusiness")
public class BusinessUserBusiness extends FrmBusiness implements IBusinessUserBusiness{
	@Resource(name="businessUserPersistence")
	private IBusinessUserPersistence businessUserPersistence;    //businessUserPersistence层注入
	
	 @Resource(name = "orderProductPersistence")
	    private IOrderProductPersistence orderProductPersistence;  //订单服务
	 
	 @Resource(name = "pageProductPersistence")
		private IPageProductPersistence pageProductPersistence;  //page服务
	
	/**
	 * 添加实名认证信息
	 * @author 侯杨
	 * @date 2014-04-17
	 * @param data
	 * @return
	 */
	public String addBusinessUserData(BusinessUserData data){
		
		String msg="0";
		try {
			List<PageProductData> pageProductDatas=null;
			List<BusinessUserData> list=new ArrayList<BusinessUserData>();
			//根据订单id 和pageid 查询出orderpage实体，然后得到服务id
			String opHql="from OrderProductData op where op.orderId='"+data.getOrderId()+"' and op.pageId='"+data.getPageId()+"' and op.productName='实名网站认证'";
			List<OrderProductData> opList=orderProductPersistence.search(opHql);
			//如果list不为空，根据查询出来的服务id和pageid，然后查询出pageProductId
			if(opList!=null && opList.size()>0){
				
			String paHql="from PageProductData p where p.pageId='"+data.getPageId()+"' and p.productId='"+opList.get(0).getProductId()+"'";
			 pageProductDatas=pageProductPersistence.search(paHql);
			}
			if(pageProductDatas!=null && pageProductDatas.size()>0){
			//根据page服务id查询实名认证信息，如果信息存在就执行，更新操作，不存在 执行增加操作
			String hql="from BusinessUserData bu where bu.pageParoductId = '"+pageProductDatas.get(0).getId()+"'";
			 list=businessUserPersistence.search(hql);
			}
			if(list.size()>0 && list!=null){			
				data.setId(list.get(0).getId());
				data.setModifyTime(new Date());  //修改时间
				data.setIsDelete(1);             //未删除数据
				businessUserPersistence.updateWithOutNullProp(data);
			}else{
			data.setPageParoductId(pageProductDatas.get(0).getId());  //pageproduct中间表
			data.setCreateTime(new Date());  //创建时间
			data.setModifyTime(new Date());  //修改时间
			data.setIsDelete(1);             //未删除数据
			businessUserPersistence.add(data);
			}
			 msg="1";    //返回正常
		} catch (Exception e) {
			 msg="0";
		}
		return msg;
	}

}
