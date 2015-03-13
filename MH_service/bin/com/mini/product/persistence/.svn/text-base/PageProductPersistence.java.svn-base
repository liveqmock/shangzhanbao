package com.mini.product.persistence;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.common.util.CTNProductUtil;
import com.common.util.DateUtil;
import com.itour.etip.pub.frame.BasePersistence;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.order.data.OrderProductData;
import com.mini.page.data.PageData;
import com.mini.product.data.PageProductData;
import com.mini.product.data.ProductData;
import com.mini.shoppingCart.persistence.IShoppingCartPersistence;

/**
 * page服务中间表久化层接口实现类
 * 
 * @author 林海鹏
 * @see PageProductPersistence
 * @since
 */
@SuppressWarnings("unchecked")
@Component("pageProductPersistence")
public class PageProductPersistence extends BasePersistence<PageProductData>
		implements IPageProductPersistence {

	@Resource(name = "shoppingCartPersistence")
	private IShoppingCartPersistence shoppingCartPersistence;// 购物车持久化层接口 容器注入

	@Resource(name = "productPersistence")
	private IProductPersistence productPersistence; // 服务

	/**
	 * 新增方法
	 */
	@Override
	public void addPageProduct(PageProductData data) {
		add(data);
	}

	/**
	 * 通过pageid 和 productid 来获取中间的表的 一条记录
	 */
	@Override
	public List<PageProductData> getPageProductDataByJson(JSONObject json) {
		StringBuffer querySQL = new StringBuffer(
				"from PageProductData bd  where 1=1");
		querySQL.append(this.getInquiresTheConditions(json));
		return search(querySQL.toString());
	}

	/**
	 * 根据Page服务中间表id查询实体信息
	 * 
	 * @param id
	 * @return
	 */
	public PageProductData getPageProductByid(String id) {
		return this.retrieve(id);
	}

	/**
	 * 自主拼接条件
	 * 
	 * @param obj
	 * @return
	 */
	private String getInquiresTheConditions(JSONObject obj) {
		StringBuffer whereSQL = new StringBuffer();
		if (obj != null && !obj.isNullObject()) {
			if (null != obj.get("id")) {
				String id = obj.getString("id");
				if (null != id && !"".equals(id)) {
					whereSQL.append(" AND bd.id = '").append(id).append("'");
				}
			}
			if (null != obj.get("pageid")) {
				String pageid = obj.getString("pageid");
				if (null != pageid && !"".equals(pageid)) {
					whereSQL.append(" AND bd.pageid = '").append(pageid)
							.append("'");
				}
			}
			if (null != obj.get("productid")) {
				String productid = obj.getString("productid");
				if (null != productid && !"".equals(productid)) {
					whereSQL.append(" AND bd.productid = '").append(productid)
							.append("'");
				}
			}
		}
		return whereSQL.toString();
	}

	/**
	 * 删除page产品中间表数据
	 */
	@Override
	public void deletePageProduct(String[] ids) {
		delete(ids);
	}

	/**
	 * 修改page产品中间表数据
	 */
	@Override
	public void editPageProduct(PageProductData data) {
		/**
		 * 修改人 文东 若是要将page的服务变为已开通状态 则给page的服务到期时间 赋值
		 */
		if (data.getStatus() == 3) {
			SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
			int year = Integer.valueOf(dff.format(new Date()).substring(0, 4));
			int day;
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {// 计算当前系统时间是闰年还是平年
				day = 366;
			} else {
				day = 365;
			}
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String endtime = DateUtil.getSpecifiedDay(dff.format(new Date()),
					"yyyy-MM-dd", day);// 赠送的权限时间为一年

			try {
				data.setExpireTime(format.parse(endtime));// 截至时间;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		update(data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mini.product.persistence.IPageProductPersistence#getPageProductData
	 * (com.mini.order.data.OrderProductData) 根据页面和服务id查询中间表信息
	 */
	@Override
	public PageProductData getPageProductData(OrderProductData orderProductData) {
		// 定义HQL查询语句
		String hql = "from PageProductData ppt where ppt.productId=? and ppt.pageId=?";
		List<PageProductData> datas = this
				.search(hql, new Object[] { orderProductData.getProductId(),
						orderProductData.getPageId() });
		if (datas.size() > 0) {
			return datas.get(0);
		}
		return null;
	}

	/*
	 * (暂时不需要)dlm
	 */
	@Override
	public List<PageProductData> getPageProductByPageId(
			PageInfoExtraData pageInfoExtraData, PageData data, String pageId) {
		String serId = "";
		String crId = "";
		// 定义条件查询的hql语句
		String hql = "from PageProductData  pd where pd.pageId = ? and isdelete = 1";
		// 定义参数集合
		List<Object> objects = new ArrayList<Object>();
		objects.add(pageId);
		List<PageProductData> pageProductDatas = this.search(hql, objects);
		List<PageProductData> pageProductDatas2 = new ArrayList<PageProductData>();
		if (pageProductDatas != null && pageProductDatas.size() > 0) {
			for (int j = 0; j < pageProductDatas.size(); j++) {
				// 判断 是否存在实名网站认证
				if (pageProductDatas.get(j).getProductName().equals("实名网站认证")) {
					data.setOwnCredible("1");// 存在
					crId = pageProductDatas.get(j).getProductId();// 服务的id
					try {
						List<ProductData> list1 = CTNProductUtil
								.getCtnJSON("[{\"productId\":\"" + crId
										+ "\"}]");
						if (list1 != null
								&& list1.size() > 0
								&& "2".equals(list1.get(0)
										.getCtnProductStatus())) {
							data.setPageStatusCredible("1");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				// 是否拥有在线客服服务 1表示拥有 0表示未拥有
				if (pageProductDatas.get(j).getProductName().equals("在线客服")) {

					data.setOwmOnlineService("1");
					serId = pageProductDatas.get(j).getProductId();
					try {
						List<ProductData> list1 = CTNProductUtil
								.getCtnJSON("[{\"productId\":\"" + serId
										+ "\"}]");
						if (list1 != null
								&& list1.size() > 0
								&& "2".equals(list1.get(0)
										.getCtnProductStatus())) {
							data.setPageStatusService("1");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}

				}

				if (pageInfoExtraData != null) {
					// 是否拥有独立域名 1表示拥有 0表示未拥有
					if (pageInfoExtraData.getDomain() != null
							&& !"".equals(pageInfoExtraData.getDomain())
							&& pageInfoExtraData.getType().equals("1")) {
						data.setOwmIndependentDomain("1");
					} else {
						data.setOwmIndependentDomain("0");
					}
				}
				pageProductDatas2.add(pageProductDatas.get(j));
			}
		}
		// 循环查询服务实体信息
		for (int m = 0; m < pageProductDatas2.size(); m++) {
			if (pageProductDatas2.get(m) == null
					|| pageProductDatas2.get(m).getProductId() == null
					|| "".equals(pageProductDatas2.get(m).getProductId())) {
				continue;
			}
			ProductData pdata = productPersistence
					.getProductDataByid(pageProductDatas2.get(m).getProductId());
			pageProductDatas2.get(m).setProductData(pdata);
		}
		return pageProductDatas2;
	}

	@Override
	public PageProductData getPageProductData(PageProductData pageProductData) {
		// 定义HQL查询语句
		String hql = "from PageProductData ppt where ppt.productId=? and ppt.pageId=? and isdelete=1";
		// 查询获取结果集
		List<PageProductData> datas = this.search(hql, new Object[] {
				pageProductData.getProductId(), pageProductData.getPageId() });
		if (datas.size() > 0) {
			return datas.get(0);
		}
		return null;
	}

}
