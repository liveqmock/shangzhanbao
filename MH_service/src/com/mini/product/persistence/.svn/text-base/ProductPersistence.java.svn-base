package com.mini.product.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.common.util.CTNProductUtil;
import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.domain.persistence.IPageInfoExtraPersistence;
import com.mini.page.data.PageData;
import com.mini.page.persistence.IPagePersistence;
import com.mini.product.data.ProductData;
import com.mini.shoppingCart.data.ShoppingCartData;
import com.mini.shoppingCart.persistence.IShoppingCartPersistence;

/**
 * 服务产品Persistence实现类 date 2014-03-06
 * 
 * @author hy
 * 
 */
@Component("productPersistence")
public class ProductPersistence extends BasePersistence<ProductData> implements
		IProductPersistence {

	@Resource(name = "pagePersistence")
	private IPagePersistence pagePersistence;

	@Resource(name = "pageInfoExtraPersistence")
	private IPageInfoExtraPersistence pageInfoExtraPersistence;
	@Resource(name = "shoppingCartPersistence")
	private IShoppingCartPersistence shoppingCartPersistence;
	@Resource(name = "productPersistence")
	private IProductPersistence productPersistence;

	/**
	 * 查找所有产品名称 -- 在添加或者修改的时候服务名称不能相同
	 * 
	 * @author hy
	 * @date 2014-03-06
	 * @return
	 */
	public List<ProductData> getAllProductName(String productName) {
		String sql = " select p.name as pname from mini_product p where p.name = ?";
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> list = dao.queryForList(sql,
				new Object[] { productName });
		List<ProductData> productDatas = new ArrayList<ProductData>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				ProductData productData = new ProductData();
				productData.setName(list.get(i).getString("PNAME"));
				productDatas.add(productData);
			}
		}
		return productDatas;
	}

	/**
	 * 
	 * 〈根据id查询实体信息〉<br>
	 * 
	 * @author wendong <br>
	 *         2014-4-14
	 * @update
	 * @param [参数1] [参数1说明]
	 * @return [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public ProductData getProductDataByid(String id) {
		return this.retrieve(id);
	}

	/**
	 * 自主拼接条件
	 * 
	 * @param json
	 * @return
	 */
	private String getInquiresTheConditions(JSONObject json) {
		StringBuffer whereSQL = new StringBuffer();
		if (json != null && !json.isNullObject()) {
			if (null != json.get("id")) {
				String id = json.getString("id");
				if (id != null && !"".equals(id))
					whereSQL.append(" AND bd.id = '").append(id).append("'");
			}
			if (null != json.get("name")) {
				String name = json.getString("name");
				if (name != null && !"".equals(name))
					whereSQL.append(" AND bd.name = '").append(name)
							.append("'");
			}
			if (null != json.get("sign")) {
				String sign = json.getString("sign");
				if (sign != null && !"".equals(sign))
					whereSQL.append(" AND bd.sign = '").append(1).append("'");
			}
		}
		return whereSQL.toString();
	}

	/**
	 * 读取cookie数据中的id 获取在数据库中对应的集合
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mini.product.persistence.IProductPersistence#getProductDataByCookie
	 * (java.lang.String)
	 */
	@Override
	public List<PageData> getProductDataByCookie(String goods) {

		String id = FrmUser.getUser().etipUserID;// 用户id
		List<PageData> pageDatas = new ArrayList<PageData>();
		List<ShoppingCartData> list = new ArrayList<ShoppingCartData>();

		List<ShoppingCartData> shoppingCartDatas = new ArrayList<ShoppingCartData>();

		String hql = "from ShoppingCartData t  where t.userId = ? ";

		/* 如果 用户id 不为空 查询出数据 */
		if (id != null && !"".equals(id)) {
			list = shoppingCartPersistence.search(hql, new Object[] { id });
		}

		// 如果 list 集合不是空的 遍历 出服务id 查询 出服务数据
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				ShoppingCartData shoppingCartData = new ShoppingCartData();
				ProductData productData = new ProductData();
				if (list.get(i).getProductId() != null
						&& !"".equals(list.get(i).getProductId())) {
					shoppingCartData = list.get(i);
					productData = productPersistence.retrieve(list.get(i)
							.getProductId());
				}
				shoppingCartData.setProductData(productData);
				shoppingCartDatas.add(shoppingCartData);
			}

		}
		/* JSONArray array = new JSONArray(); */
		if (shoppingCartDatas.size() > 0) {
			/*
			 * for (int i = 0; i < shoppingCartDatas.size(); i++) {// 不属于当前用户的商品
			 * 踢掉 if (id.equals(shoppingCartDatas.get(i).getUserId())) {
			 * array.add(arr.get(i)); } }
			 */
			List<String> pageids = new ArrayList<String>();
			for (int i = 0; i < shoppingCartDatas.size(); i++) { // 因
																	// 购物车里的数据较少，这里直接采用for循环中查询数据库
				boolean flag = true;
				// 获取PAGEID
				String pageid = shoppingCartDatas.get(i).getPageId();
				if (pageid != null && !pageid.equals("")) {
					if (pageids.size() > 0) {
						for (int j = 0; j < pageids.size(); j++) {
							if (pageid.equals(pageids.get(j))) {
								flag = false;
							}
						}
						if (flag) {
							pageids.add(pageid);
						}
					} else {
						pageids.add(pageid);
					}
				}
			}
			if (pageids.size() > 0) {
				pageDatas = this.getPageInfoList(pageids);
			}
			for (int i = 0; i < shoppingCartDatas.size(); i++) {
				for (int j = 0; j < pageDatas.size(); j++) {
					// 获取服务ID
					String productId = shoppingCartDatas.get(i).getProductId();
					ProductData data = this.retrieve(productId);
					// 若没有服务则表示是ctn的服务
					if (data == null) {
						ProductData data2 = new ProductData();
						data2.setId(productId);
						if (shoppingCartDatas.get(i).getPageId()
								.equals(pageDatas.get(j).getId())) {
							pageDatas.get(j).getListProduct().add(data2);
						}
					} else if (shoppingCartDatas.get(i).getPageId()
							.equals(pageDatas.get(j).getId())) {
						pageDatas.get(j).getListProduct().add(data);
					}
				}
			}
		}
		return pageDatas;
	}

	/**
	 * 
	 * 根据ID获取Page信息和域名<br>
	 * 
	 * @author 文东 <br>
	 *         2014-4-3
	 * @update
	 * @param List
	 *            <String> pageids 多个ID的集合
	 * @return List<PageData>
	 * @exception/throws
	 * @see ProductPersistence#getPageInfoList(pageids)
	 * @since
	 */
	private List<PageData> getPageInfoList(List<String> pageids) {
		List<PageData> datas = new ArrayList<PageData>();
		for (int i = 0; i < pageids.size(); i++) {
			PageData data = pagePersistence.retrieve(pageids.get(i));
			if (data != null) {
				PageInfoExtraData infoExtraData = new PageInfoExtraData();
				infoExtraData.setPageId(pageids.get(i));
				infoExtraData.setType("2");
				infoExtraData = pageInfoExtraPersistence
						.searchByPageInfoExtraData(infoExtraData);
				data.setPageInfoExtra(infoExtraData);
				datas.add(data);
			}
		}
		return datas;
	}

	@Override
	public List<List<ProductData>> getProductNoDomain(String decode) {
		JSONArray arr = JSONArray.fromObject(decode);
		List<List<ProductData>> list1 = new ArrayList<List<ProductData>>();
		String id = FrmUser.getUser().etipUserID;// 用户id
		JSONArray array = new JSONArray();
		if (arr.size() > 0) {
			for (int i = 0; i < arr.size(); i++) {// 不属于当前用户的商品 踢掉
				if (id.equals(arr.getJSONObject(i).getString("userid"))) {
					array.add(arr.get(i));
				}
			}
			Map<String, String> pageinfo = null;
			for (int i = 0; i < array.size(); i++) { // 因
														// 购物车里的数据较少，这里直接采用for循环中查询数据库
				String json = "{'id':'"
						+ array.getJSONObject(i).getString("pid") + "'}";
				// 获取PAGEID
				String pageid = array.getJSONObject(i).getString("pageid");
				if (!"".equals(pageid)) {
					pageinfo = getPgaeInfo(array.getJSONObject(i).getString(
							"pageid"));// 获取域名和，page名称
				}
				ProductData data = new ProductData();
				if (pageinfo != null) {
					if (pageinfo.get("DOMAIN") == null
							|| pageinfo.get("DOMAIN").equals("")) {
						// 获取服务ID
						String productId = JSONObject.fromObject(json)
								.getString("id");
						data = this.retrieve(productId);
						data.setPageName(pageinfo.get("NAME"));// page名称
						data.setDomain(pageinfo.get("DOMAIN") == null ? ""
								: pageinfo.get("DOMAIN"));// 域名
						data.setPageId(array.getJSONObject(i).getString(
								"pageid"));//
						data.setPagestatus(getpageStatus(pageid));// page状态
						data.setGoodNum(array.getJSONObject(i).getInt("num"));// 商品数量
						// list1.add(data);
					}

				}
			}
		}
		return list1;
	}

	@Override
	public List<List<ProductData>> getProductNoPage(String decode) {
		JSONArray arr = JSONArray.fromObject(decode);
		List<List<ProductData>> list1 = new ArrayList<List<ProductData>>();
		String id = FrmUser.getUser().etipUserID;// 用户id
		JSONArray array = new JSONArray();
		if (arr.size() > 0) {
			for (int i = 0; i < arr.size(); i++) {// 不属于当前用户的商品 踢掉
				if (id.equals(arr.getJSONObject(i).getString("userid"))) {
					array.add(arr.get(i));
				}
			}
			Map<String, String> pageinfo = null;
			for (int i = 0; i < array.size(); i++) { // 因
														// 购物车里的数据较少，这里直接采用for循环中查询数据库
				String json = "{'id':'"
						+ array.getJSONObject(i).getString("pid") + "'}";
				// 获取PAGEID
				String pageid = array.getJSONObject(i).getString("pageid");
				if ("".equals(pageid) || pageid == null) {
					ProductData data = new ProductData();
					String productId = JSONObject.fromObject(json).getString(
							"id");
					data = this.retrieve(productId);
					data.setPagestatus(getpageStatus(pageid));// page状态
					data.setGoodNum(array.getJSONObject(i).getInt("num"));// 商品数量
					// list1.add(data);
				}
			}
		}
		return list1;
	}

	/**
	 * 获取page名称 域名 page状态
	 * 
	 * @param pageid
	 * @return
	 */
	private Map<String, String> getPgaeInfo(String pageid) {
		Map<String, String> map = new HashMap<String, String>();
		String sql = "select bd.name,b.domain from mini_page bd, mini_page_info_extra b where  bd.id = b.page_id and bd.id = '"
				+ pageid + "' and b.status='OPEN'";
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> list = dao.queryForList(sql, null);
		for (int i = 0; i < list.size(); i++) {
			map.put("NAME", list.get(i).getString("NAME"));
			map.put("DOMAIN", list.get(i).getString("DOMAIN"));
		}
		return map;
	}

	/**
	 * 获取page状态
	 * 
	 * @return
	 */
	private String getpageStatus(String pageid) {
		String str = "";
		String sql = "select bd.status from mini_page bd where   bd.id = '"
				+ pageid + "'";
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> list = dao.queryForList(sql, null);
		if (null != list && list.size() > 0)
			str = list.get(0).getString("STATUS");
		return str;
	}

	/**
	 * 根据自定义条件返回对象集合
	 * 
	 * @author 林海鹏
	 * @date 2014-03-06
	 * @param id
	 * @return
	 */
	@Override
	public List<ProductData> getProductDataByJson(JSONObject json) {
		StringBuffer querySQL = new StringBuffer(
				"FROM ProductData bd WHERE 1=1");
		querySQL.append(this.getInquiresTheConditions(json));
		return search(querySQL.toString());
	}

	/**
	 * 
	 * 根据json串查询所有的Product
	 * 
	 * @author 冯鑫 <br>
	 *         2014-4-16
	 * @update
	 * @param JSONObject
	 *            json 中为多个id
	 */
	public List<ProductData> getProductDataByIdStr(String str) {
		StringBuffer querySQL = new StringBuffer(
				"FROM ProductData bd WHERE 1=1 AND bd.id in (");
		JSONArray jsonarray = JSONArray.fromObject(str);
		for (int i = 0; i < jsonarray.size(); i++) {

			if (i + 1 == jsonarray.size()) {
				querySQL.append("'"
						+ jsonarray.getJSONObject(i).getString("productId")
						+ "')");
			} else {
				querySQL.append("'"
						+ jsonarray.getJSONObject(i).getString("productId")
						+ "',");
			}
		}
		return search(querySQL.toString());
	}

	/**
	 * 购物车查询 跟用用户
	 * 
	 * @author hy
	 * @date 2014-4-09
	 * @param userId
	 * @return
	 */
	@Override
	public List<PageData> getShoppingCartData(String userId) {
		List<PageData> pageDatas = new ArrayList<PageData>();
		List<ShoppingCartData> list = new ArrayList<ShoppingCartData>();
		List<PageData> pageDataList = new ArrayList<PageData>();
		List<ShoppingCartData> shoppingCartDatas = new ArrayList<ShoppingCartData>();
		List<ShoppingCartData> shoppingCartDatas1 = new ArrayList<ShoppingCartData>();
		StringBuffer hql = new StringBuffer();
		hql.append("from ShoppingCartData t where t.userId = ? and t.isDelete = 1 and t.price is  null  ");
		String pageHql = "from PageData t where t.userId = ? and t.isDelete = 1";

		/* 如果 用户id 不为空 查询出数据 */
		if (userId != null && !"".equals(userId)) {
			shoppingCartDatas1 = shoppingCartPersistence.search(hql.toString(),
					new Object[] { userId });
			pageDataList = pagePersistence.search(pageHql,
					new Object[] { userId });
		}
		for (int i = 0; i < pageDataList.size(); i++) {
			String pageId = pageDataList.get(i).getId();
			for (int j = 0; j < shoppingCartDatas1.size(); j++) {
				ShoppingCartData cartData = new ShoppingCartData();
				if (pageId.equals(shoppingCartDatas1.get(j).getPageId())) {
					cartData = shoppingCartDatas1.get(j);
					list.add(cartData);
				}
			}

		}

		// 如果 list 集合不是空的 遍历 出服务id 查询 出服务数据
		if (list != null && list.size() > 0) {
			StringBuffer strbuf = new StringBuffer();
			strbuf.append("[");
			for (int i = 0; i < list.size(); i++) {
				ProductData productData = new ProductData();
				ShoppingCartData shoppingCartData = null;
				// 如果 服务id不为空查询 出 服务数据
				if (list.get(i).getProductId() != null
						&& !"".equals(list.get(i).getProductId())) {
					shoppingCartData = list.get(i);
					productData = productPersistence.retrieve(shoppingCartData
							.getProductId());
				}
				// 如果服务是null 就说明服务在minipage 没有此服务。拼接服务id
				if (productData == null) {
					if (list.size() == i + 1) {
						strbuf.append("{productId:\""
								+ shoppingCartData.getProductId() + "\"}");
					} else {
						strbuf.append("{productId:\""
								+ shoppingCartData.getProductId() + "\"},");
					}

				}
				// 服务不为空 把服务实体set到 购物车信息中
				if (productData != null) {
					shoppingCartData.setProductData(productData);
				}
				strbuf.append("]");
				// 根据接口去ctn查询minipage不存在的服务
				List<ProductData> productData2 = null;
				try {
					productData2 = CTNProductUtil.getCtnJSON(strbuf.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
				// list集合不为空 把服务实体set到 购物车信息中
				if (productData2 != null && productData2.size() > 0) {
					for (int j = 0; j < productData2.size(); j++) {
						shoppingCartData.setProductData(productData2.get(j));
					}
				}
				shoppingCartDatas.add(shoppingCartData);
			}

		}

		if (shoppingCartDatas.size() > 0) {

			List<String> pageids = new ArrayList<String>();
			for (int i = 0; i < shoppingCartDatas.size(); i++) { // 因
																	// 购物车里的数据较少，这里直接采用for循环中查询数据库
				boolean flag = true;
				// 获取PAGEID
				String pageid = shoppingCartDatas.get(i).getPageId();
				if (pageid != null && !pageid.equals("")) {
					if (pageids.size() > 0) {
						for (int j = 0; j < pageids.size(); j++) {
							if (pageid.equals(pageids.get(j))) {
								flag = false;
							}
						}
						if (flag) {
							pageids.add(pageid);
						}
					} else {
						pageids.add(pageid);
					}
				}
			}
			if (pageids.size() > 0) {
				pageDatas = this.getPageInfoList(pageids);
			}
			for (int i = 0; i < shoppingCartDatas.size(); i++) {
				for (int j = 0; j < pageDatas.size(); j++) {

					// 获取服务ID
					String productId = shoppingCartDatas.get(i).getProductId();
					ProductData data = this.retrieve(productId);
					// 若没有服务则表示是ctn的服务
					if (data == null) {
						ProductData data2 = new ProductData();
						data2.setId(productId);
						if (shoppingCartDatas.get(i).getPageId()
								.equals(pageDatas.get(j).getId())) {
							pageDatas.get(j).getListProduct().add(data2);
						}
					} else if (shoppingCartDatas.get(i).getPageId()
							.equals(pageDatas.get(j).getId())) {
						pageDatas.get(j).getListProduct().add(data);
					}
				}

			}
		}
		return pageDatas;
	}

	@Override
	public ProductData findBySign(int i) {
		String hql = "from ProductData p where p.sign=" + i; // 如果是 查询出 官方发布权限
																// 这款服务
		return productPersistence.search(hql).get(0);
	}

}
