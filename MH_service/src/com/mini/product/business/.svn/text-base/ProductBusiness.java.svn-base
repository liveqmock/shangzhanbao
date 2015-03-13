package com.mini.product.business;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.common.util.CTNProductUtil;
import com.common.util.ClobFile;
import com.common.util.DateUtil;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.HibernateDao;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.domain.persistence.IPageInfoExtraPersistence;
import com.mini.page.data.PageData;
import com.mini.page.persistence.IPagePersistence;
import com.mini.pageManage.business.IPageManageBusiness;
import com.mini.product.data.PageProductData;
import com.mini.product.data.ProductData;
import com.mini.product.persistence.IPageProductPersistence;
import com.mini.product.persistence.IProductPersistence;
import com.mini.shoppingCart.data.ShoppingCartData;
import com.mini.shoppingCart.persistence.IShoppingCartPersistence;

/**
 * 〈服务 Business实现类〉 〈功能详细描述〉
 * 
 * @author [作者]（hy）
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("productBusiness")
public class ProductBusiness extends FrmBusiness implements IProductBusiness {
    
	/**
	 * 服务Persistence接口
	 */
	@Resource(name = "productPersistence")
	private IProductPersistence productPersistence;
	/**
	 * pageManageBusiness接口
	 */
	@Resource(name = "pageManageBusiness")
	private IPageManageBusiness pageManageBusiness;
	/**
	 * 购物车Persistence接口
	 */
	@Resource(name = "shoppingCartPersistence")
	private IShoppingCartPersistence shoppingCartPersistence;
	/**
	 * page使用服务Persistence接口
	 */
	@Resource(name = "pageProductPersistence")
	private IPageProductPersistence pageProductPersistence;
	
	/* page个人表 */
	@Resource(name = "pagePersistence")
	private IPagePersistence pagePersistence;
	
	@Resource(name = "pageInfoExtraPersistence")
	private IPageInfoExtraPersistence pageInfoExtraPersistence;

	/**
	 * @author 侯杨 date 2014-03-06 后台服务管理，分页查询所有
	 * @param pageRoll
	 *            分页
	 * @param productData
	 *            条件查询
	 * @return
	 */
	@Override
	public List<ProductData> getAll(PageRoll pageRoll, ProductData productData,Integer sort) {

		StringBuffer sqlStr = new StringBuffer(
				"select  * from mini_product p where 1=1 ");
		List<Object> objects = new ArrayList<Object>();
		/* 条件查询 */
		if (productData.getStatus() != null
				&& !"".equals(productData.getStatus())) { /* 根据状态查询 */
			if ("1".equals(productData.getStatus())) { // 待开通
				sqlStr.append("  ");

			}
			if ("2".equals(productData.getStatus())) { // 待开通
				sqlStr.append(" and p.status like '%WAIT%' ");

			}
			if ("3".equals(productData.getStatus())) { // 已开通
				sqlStr.append(" and p.status like '%OPEN%' ");

			}
			if ("4".equals(productData.getStatus())) { // 已关闭
				sqlStr.append(" and p.status like '%CLOSED%' ");

			}
		}
		if (productData.getName() != null && !"".equals(productData.getName())) { // 根据服务名称
			sqlStr.append("  and p.name like ?");
			objects.add("%" + productData.getName() + "%");
		}
		if (productData.getCreateTime() != null) { // 根据创建时间
			sqlStr.append("and p.createtime >= ?");
			objects.add(productData.getCreateTime());

		}
		if (productData.getOverTime() != null) { // 根据创建时间
			sqlStr.append("and p.createtime <= ?");
			objects.add(productData.getOverTime());

		}
		sqlStr.append(" order by p.createtime  "); // 按创建时间排序
		  if(sort==0){
		      sqlStr.append("  desc"); // 按创建时间排序
		  }else{
		      sqlStr.append("  asc"); // 按创建时间排序
		  }
		
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询
		pageRoll.setSearchSQL(sqlStr.toString());
		pageRoll.setCountSQL("select count(*) from (" + sqlStr + ")");
		List<ETIPResultSet> resultSet = dao.search(pageRoll, objects);// 分页查询
		List<ProductData> list = new ArrayList<ProductData>(); // 服务集合
		for (int i = 0; i < resultSet.size(); i++) {
			ETIPResultSet rs = resultSet.get(i);
			ProductData data = new ProductData(); // 服务实体
			data.setName(rs.getString("NAME")); // 服务名称
			data.setId(rs.getString("ID")); // 服务id
			data.setCreateTime(rs.getDate("CREATETIME")); // 服务创建时间
			data.setPrice(rs.getDouble("PRICE")); // 服务价格
			data.setStatus(rs.getString("STATUS")); // 服务状态
			data.setYearNum(rs.getInt("YEARNUM")); // 服务年限
			data.setType(rs.getString("TYPE")); // 服务年限
			list.add(data);
		}
		return list;
	}

	/**
	 * @author 侯杨 date 2014-03-06 后台服务管理增加服务
	 * @param productData
	 */
	@Override
	public void addProduct(ProductData productData, File fileMain) {

		// 存储图片
		Blob img = null;
		FileInputStream inputStream = null;
		if (fileMain != null) {
			// 将图片读入输入流
			try {
				inputStream = new FileInputStream(fileMain);
			} catch (FileNotFoundException e) {
				// 文件流异常
				e.printStackTrace();
			}
		}
		try {
			img = Hibernate.createBlob(inputStream);
		} catch (IOException e) {
			// IO流异常
			e.printStackTrace();
		}
		productData.setImg(img);
		productPersistence.add(productData);

	}

	/**
	 * @author 侯杨 date 2014-03-06 后台服务管理删除服务
	 * @param productData
	 */
	@Override
	public void deleteProduct(String id) {

		productPersistence.delete(id);

	}

	/**
	 * @author 侯杨 date 2014-03-06 后台服务管理修改服务
	 * @param productData
	 */
	@Override
	public void updateProduct(ProductData productData) {

		ProductData data = null;
		if (productData.getId() != null && !"".equals(productData.getId())) {
			data = productPersistence.retrieve(productData.getId());
		}
		data.setName(productData.getName());
		data.setPrice(productData.getPrice());
		data.setYearNum(productData.getYearNum());
		data.setOverTime(productData.getOverTime());
		productPersistence.update(data);

	}

	/**
	 * 查找所有产品名称 -- 在添加或者修改的时候服务名称不能相同
	 * 
	 * @author hy
	 * @date 2014-03-06
	 * @return
	 */
	public ProductData getAllProductName(String productName) {
		List<ProductData> list = productPersistence
				.getAllProductName(productName);// 查找产品名称
		ProductData productData = new ProductData();
		for (int i = 0; i < list.size(); i++) {
			productData = list.get(i);
			String pName = productData.getName();// 获取查询到的产品名称
			if (pName != null && pName.equals(productName)) {// 从页面获取到的产品名称和已经查询出来的产品名称比较
				productData.setRemark(1); // 表示数据库中已经存在 该 服务名称;
				break; // 跳出循环
			}
		}

		return productData;
	}

	/**
	 * 根据id查询服务详情
	 * 
	 * @author hy
	 * @date 2014-03-06
	 * @param id
	 * @return
	 */
	@Override
	public ProductData getProductData(String id) {

		if (id != null && !"".equals(id)) {
			return productPersistence.retrieve(id);
		}
		return null;
	}

	/**
	 * 根据用户id查询出数据，然后查询出page，在查询出服务 update 侯杨 dlm
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public List<PageProductData> getAll(String userId) {

		// 根据用户id查询用户所有的page
		String pageHql = "from PageData pa where pa.userId=? and pa.isDelete=1 ";
		List<PageData> pagelist = pagePersistence.search(pageHql,
				new Object[] { userId });

		List<PageProductData> list = new ArrayList<PageProductData>(); // 用来返回数据的集合
		List<PageInfoExtraData> pageInfolist=new ArrayList<PageInfoExtraData>();  //域名集合
		// 根据pageid查询page服务中间表page所拥有的服务
		for (PageData data : pagelist) {

			// 查询存在的且status不为空的page在服务中间表的数据（免费的服务status初始为1 付费的初始为null）
			String pageProductHql = "from PageProductData pa where pa.pageId=? and pa.isdelete=1 and pa.status is not null";
			List<PageProductData> pplist = pageProductPersistence.search(
					pageProductHql, new Object[] { data.getId() });
			
			//查询域名
			String peHql = " from PageInfoExtraData pe where pe.pageId=? and pe.status='OPEN'";
	    	 pageInfolist = pageInfoExtraPersistence.search(peHql, new Object[]{data.getId()});
	    	PageInfoExtraData pageInfoExtra=new PageInfoExtraData();
	    	if(pageInfolist.size()>0){
	    		pageInfoExtra=pageInfolist.get(0);
	    	}
			int count = getCountProduct(data.getId());// page里面服务的数量

			if (pplist != null && pplist.size() > 0) {

				for (int i = 0; i < pplist.size(); i++) {// 循环查询出来的中间表数据
					/**
					 * 修改人 文东 当服务为 免费时 过期 标示 为4
					 */
					ProductData data2 = new ProductData();
					data2=productPersistence.retrieve(pplist.get(i).getProductId());
					int decide = 1;// 0:过期了 1:正常 2:截至时间null 3:提示还有一个月到期
					if(data2.getPrice() == null || data2.getPrice() == 0){
					}else{
						decide = pageProductDataIfUse(pplist.get(i));
					};
					// 是否过期的标识
					pplist.get(i).setDecide(decide);
					pplist.get(i).setCount(count);// page里面服务的数量
					pplist.get(i).setPageData(data);
					pplist.get(i).getPageData().setPageInfoExtra(pageInfoExtra);   //page域名实体
					pplist.get(i).setProductData(data2);
					list.add(pplist.get(i));
				}
			}

		}

		return list;
	}

	/**
	 * 判断page是否是 试用 正常
	 * 
	 * @param pageProductData
	 * @return
	 */
	public int pageProductDataIfUse(PageProductData pageProductData) {

		// 30天
		SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currTime = new Date();// 当前系统时间;
		
		Date endTime = pageProductData.getExpireTime();// 获取服务到期时间
		String time = "";
		if(endTime!=null){
			 time = DateUtil.getSpecifiedDay(dff.format(endTime),
					"yyyy-MM-dd", -30);// 赠送的权限时间
		}
		long date = 0;
		try {
			if(time!=null && !time.equals("")){
				date = format.parse(time).getTime();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (endTime != null) {

			long currTimelong = currTime.getTime();
			long endTimeelong = endTime.getTime();

			if (currTimelong < endTimeelong && currTimelong < date) {
				return 1;// 正常
			} else if (currTimelong < endTimeelong && currTimelong >= date) {
				return 3;// 提示还有一个月到期
			} else {
				return 0;// 过期了
			}
		} else {
			return 2;// 截至时间null
		}

	}

	/**
	 * 根据pageid统计 该page有多少服务
	 * 
	 * @param id
	 * @return
	 */
	public int getCountProduct(String id) {
		int count = 0;
		String sql = "select count(*) pcount from mini_pageproduct t where t.pageid = ? and t.status=1";

		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> resultSets = dao.queryForList(sql,
				new Object[] { id }); // 执行sql语句查询出结果
		for (int i = 0; i < resultSets.size(); i++) {
			ETIPResultSet rs = resultSets.get(i);
			count = rs.getInt("PCOUNT");
		}
		return count;
	}

	/**
	 * 停用page所使用的服务
	 * 
	 * @update 文东 </br> 停用服务时 同时隐藏Page页面上的服务
	 *         冯鑫  第三套模板中电话号码不止出现在banner组件中，在其他组件上的电话号码也要隐藏！
	 * @author hy
	 * @date 2013-03-08
	 * @param pageProductData
	 * @param id
	 * @throws SQLException
	 */
	@Override
	public void stopPageProduct(PageProductData pageProductData) {
		pageProductData.setStopTime(new Date());
		pageProductPersistence.updateWithOutNullProp(pageProductData);
		PageProductData data = pageProductPersistence.retrieve(pageProductData.getId());
		String pageid = data.getPageId();// 获取需要停用服务的页面的id
		String domain = pageManageBusiness.getDomainByPage(pageid);
		PageData pageData = pagePersistence.retrieve(pageid);// 得到页面对象
		String content = "";
		try {
			content = ClobFile.clobToString(pageData.getContent());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String pagePath = "/pagehtml/";
		String realpath = ServletActionContext.getServletContext().getRealPath(pagePath); // 定义微页面的静态地址
		// 根据type来判断停用的服务
		if (pageProductData.getStatus() == 0) {// 0是表示停用
			if ("1".equals(pageProductData.getType())) {// 1是客服留言 把客服留言的div隐藏
				stopMsg(domain, pageData, content, realpath);
			}
			if ("2".equals(pageProductData.getType())) {// 2是销售电话 把销售电话的div隐藏
				stopPhone(domain, pageData, content, realpath);
			}
			/* 文东 添加 停用在线客服的的代码 */
			if ("5".equals(pageProductData.getType())) {
				stopTalk99(data, domain, pageData, content, realpath);
			}
			/* 文东 添加 停用购买服务*/
			if("6".equals(pageProductData.getType())){
			    stopBuy(domain, pageData, content, realpath);
			}
		}
		// 这个方法启用的是客户留 言，需要重新生成页面
		if (pageProductData.getStatus() == 1) {// 1是表示启用
		    if("1".equals(pageProductData.getType())){
		        openMsg(domain, pageData, content, realpath);
		    }
		    if("6".equals(pageProductData.getType())){
		        openBuy(domain, pageData, content, realpath);
		    }
			
		}
	}

	/**
     * 
     * 启用购买 更新数据库并重新生成文件<br>
     * 
     * @author 文东 <br> 
     *         2014年9月16日
     * @update 
     * @param domain 域名名称  文件名
     * @param pageData 微页面对象
     * @param content  页面内容
     * @param realpath 微站静态页面地址
     * @return  void
     * @exception/throws IOException 生成文件出错
     * @see   ProductBusiness#openBuy(String, PageData, String, String)
     * @since vmaque 1.5
     */
	private void openBuy(String domain, PageData pageData, String content, String realpath) {
	        // 若该页面的购买服务处于隐藏状态，则将隐藏状态去掉并启用
	        String buycontent = content.replace("<li class=\"nav_buy\" style=\"display: none;\">", "<li class=\"nav_buy\">");
            buycontent = buycontent.replace("id=\"goumaiwraper\" style=\"display:none\"","id=\"goumaiwraper\"");
            pageData.setContent(Hibernate.createClob(buycontent));
            pagePersistence.update(pageData);// 更新page信息
            File path = new File(realpath); // 判断目录是否存在，如果不存在则创建该目录
            if (!path.exists()) {
                path.mkdirs();
            }
            try {
                // 写入文件
                OutputStreamWriter isw = new OutputStreamWriter(new FileOutputStream(realpath + File.separator + domain),"UTF-8");
                BufferedWriter bw = new BufferedWriter(isw);
                bw.write(buycontent, 0, buycontent.length());
                bw.close();
                isw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        
    }
	
	

    /**
     * 
     * 启用留言板 更新数据库并重新生成文件<br>
     * 
     * @author 文东 <br> 
     *         2014年9月16日
     * @update 
     * @param domain 域名名称  文件名
     * @param pageData 微页面对象
     * @param content  页面内容
     * @param realpath 微站静态页面地址
     * @return  void
     * @exception/throws IOException 生成文件出错
     * @see   ProductBusiness#openMsg(String, PageData, String, String)
     * @since vmaque 1.5
     */
    private void openMsg(String domain, PageData pageData, String content, String realpath) {
        String msgcontentqy = content.replace(
        		"<div id=\"messageBoardhidden\" style=\"display:none;\" ",
        		"<div id=\"messageBoard\" ");
        pageData.setContent(Hibernate.createClob(msgcontentqy));
        pagePersistence.update(pageData);
        File path = new File(realpath); // 判断目录是否存在，如果不存在则创建该目录
        if (!path.exists()) {
            path.mkdirs();
        }
        try {
            // 写入文件
            OutputStreamWriter isw = new OutputStreamWriter(new FileOutputStream(realpath + File.separator + domain),"UTF-8");
            BufferedWriter bw = new BufferedWriter(isw);
            bw.write(msgcontentqy, 0, msgcontentqy.length());
            bw.close();
            isw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
	
	
	/**
     * 
     * 停用购买服务 更新数据库并重新生成文件<br>
     * 
     * @author 文东 <br> 
     *         2014年9月16日
     * @update 
     * @param domain 域名名称  文件名
     * @param pageData 微页面对象
     * @param content  页面内容
     * @param realpath 微站静态页面地址
     * @return  void
     * @exception/throws IOException 生成文件出错
     * @see   ProductBusiness#stopPhone(String, PageData, String, String)
     * @since vmaque 1.5
     */
	 private void stopBuy(String domain,PageData pageData,String content, String realpath) {
	     // 若该页面的购买服务处于隐藏状态，则直接返回。不用做任何操作
	     if(content.contains("id=\"goumaiwraper\" style=\"display:none\">")){
	         return;
	     }else{
	         // 反之 则将购买的div 隐藏
	         String buycontent = content.replace("<li class=\"nav_buy\">",
	                 "<li class=\"nav_buy\" style=\"display: none;\">");
	         buycontent = buycontent.replace("id=\"goumaiwraper\"",
	                 "id=\"goumaiwraper\" style=\"display:none\"");
	         pageData.setContent(Hibernate.createClob(buycontent));
	         pagePersistence.update(pageData);// 更新page信息
	         File path = new File(realpath); // 判断目录是否存在，如果不存在则创建该目录
	         if (!path.exists()) {
	             path.mkdirs();
	         }
	         try {
	             // 写入文件
	             OutputStreamWriter isw = new OutputStreamWriter(new FileOutputStream(realpath + File.separator + domain),"UTF-8");
	             BufferedWriter bw = new BufferedWriter(isw);
	             bw.write(buycontent, 0, buycontent.length());
	             bw.close();
	             isw.close();
	         } catch (IOException e1) {
	             e1.printStackTrace();
	         }
	     }
	 }
	
	/**
     * 
     * 停用电话号码 更新数据库并重新生成文件<br>
     * 
     * @author 文东 <br> 
     *         2014年9月16日
     * @update 
     * @param domain 域名名称  文件名
     * @param pageData 微页面对象
     * @param content  页面内容
     * @param realpath 微站静态页面地址
     * @return  void
     * @exception/throws IOException 生成文件出错
     * @see   ProductBusiness#stopPhone(String, PageData, String, String)
     * @since vmaque 1.5
     */
    private void stopPhone(String domain, PageData pageData, String content, String realpath) {
        String phonecontent = content.replace("<div id=\"phone\" ","<div id=\"phonehidden\" style=\"display: none;\" ");
        //在第三套模板中，电话号码在页面中不只有一个地方出现 要替换掉组件上的电话号码
        phonecontent = phonecontent.replace("<lable id=\"phone\" ","<lable id=\"phonehidden\" style=\"display: none;\" ");
        /**
         * 修改人：侯杨
         * 导航上带电话号码  修改
         */
        //以后所有的模板导航上的电话号码都用这个规则
        phonecontent = phonecontent.replace("<p id=\"phone\" ","<p id=\"phonehidden\" style=\"display: none;\" ");
        pageData.setContent(Hibernate.createClob(phonecontent));
        pagePersistence.update(pageData);// 更新page信息
        File path = new File(realpath); // 判断目录是否存在，如果不存在则创建该目录
        if (!path.exists()) {
            path.mkdirs();
        }
        try {
            // 写入文件
            OutputStreamWriter isw = new OutputStreamWriter(new FileOutputStream(realpath + File.separator + domain),"UTF-8");
            BufferedWriter bw = new BufferedWriter(isw);
            bw.write(phonecontent, 0, phonecontent.length());
            bw.close();
            isw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

	/**
     * 
     * 停用在线客服 更新数据库并重新生成文件<br>
     * 
     * @author 文东 <br> 
     *         2014年9月16日
     * @update 
     * @param domain 域名名称  文件名
     * @param pageData 微页面对象
     * @param content  页面内容
     * @param realpath 微站静态页面地址
     * @return  void
     * @exception/throws IOException 生成文件出错
     * @see   ProductBusiness#stopTalk99(String, PageData, String, String)
     * @since vmaque 1.5
     */
    private void stopTalk99(PageProductData data, String domain, PageData pageData, String content, String realpath) {
        String talkcontent = content.replaceAll(data.getProductContent(),"");
        pageData.setContent(Hibernate.createClob(talkcontent));
        pagePersistence.update(pageData);// 更新page信息
        File path = new File(realpath); // 判断目录是否存在，如果不存在则创建该目录
        if (!path.exists()) {
            path.mkdirs();
        }
        try {
            // 写入文件
            OutputStreamWriter isw = new OutputStreamWriter(new FileOutputStream(realpath + File.separator + domain),"UTF-8");
            BufferedWriter bw = new BufferedWriter(isw);
            bw.write(talkcontent, 0, talkcontent.length());
            bw.close();
            isw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

	
	/**
	 * 
	 * 停用客户留言板 并重新生成文件<br>
	 * 
	 * @author 文东 <br> 
	 *		   2014年9月16日
	 * @update 
	 * @param domain 域名名称  文件名
	 * @param pageData 微页面对象
	 * @param content  页面内容
	 * @param realpath 微站静态页面地址
	 * @return  void
	 * @exception/throws IOException 生成文件出错
	 * @see   ProductBusiness#stopMsg(String, PageData, String, String)
	 * @since vmaque 1.5
	 */
    private void stopMsg(String domain, PageData pageData, String content, String realpath) {
        String msgcontent = content.replace("<div id=\"messageBoard\" ","<div id=\"messageBoardhidden\" style=\"display:none;\" ");
        pageData.setContent(Hibernate.createClob(msgcontent));
        pagePersistence.update(pageData);// 更新page信息
        File path = new File(realpath); // 判断目录是否存在，如果不存在则创建该目录
        if (!path.exists()) {
            path.mkdirs();
        }
        try {
            // 写入文件
            OutputStreamWriter isw = new OutputStreamWriter(new FileOutputStream(realpath + File.separator + domain),"UTF-8");
            BufferedWriter bw = new BufferedWriter(isw);
            bw.write(msgcontent, 0, msgcontent.length());
            bw.close();
            isw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

	/**
	 * 处理cookie 读取cookie数据中的id 获取在数据库中对应的集合
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public List<PageData> getProductDataByCookie(String json) {

		return productPersistence.getProductDataByCookie(json);
	}

	/**
	 * @author hy
	 * @date 2014-3-12 后台服务管理 关闭服务或者启用服务
	 * @param productData
	 */
	@Override
	public void updateProductState(ProductData productData) {

		ProductData data = null;
		/* id不为空 就查询出数据 并更改数据 */
		if (productData.getId() != null && !"".equals(productData.getId())) {
			data = productPersistence.retrieve(productData.getId());
		}
		data.setStatus(productData.getStatus()); // 更改服务状态
		productPersistence.update(data);
	}

	/**
	 * 更新服务 更新page电话号码
	 * 
	 * @author hy
	 * @update dlm
	 * @date 2014-03-13
	 * @param productData
	 * @param pageId
	 */
	public String updateProductPagePhone(PageProductData pageProductData,
			String pageId, String phone) {
		String msg = "0";
		try {
			if (pageId != null && !"".equals(pageId)) { // 如果id不为空查询出数据
				String domain = pageManageBusiness.getDomainByPage(pageId);
				PageData pageData = pagePersistence.retrieve(pageId);// 得到页面对象

				String content = "";
				try {
					content = ClobFile.clobToString(pageData.getContent()); // 取出大字段并转化为String  类型
				} catch (SQLException e) {
					e.printStackTrace();
				}
				/*
				 * 截取字符串 替换掉旧的电话号码 启用时先替换回显示的div
				 */
				String phcontent = content.replace(
						"<div id=\"phonehidden\" style=\"display: none;\" ",
						"<div id=\"phone\" ");
				/**
                 * 修改人：侯杨
                 * 导航上带电话号码  修改
                 */
				phcontent = phcontent.replace(
                        "<p id=\"phonehidden\" style=\"display: none;\" ",
                        "<p id=\"phone\" ");
				String S2 = phcontent.substring(phcontent.indexOf("<div id=\"phone\" ")); // 获取后面的那段内容
				String S3 = S2.substring(0, S2.indexOf("</div>"));
				String S4 = S3.substring(S3.lastIndexOf(">"));
				String S5 = S4.substring(1);
				String main = phcontent.replaceAll(S5, phone);
				Clob c = Hibernate.createClob(main); // 把String 类型转化为CLOB类型
				pageData.setContent(c);
				pagePersistence.update(pageData); // 更新page表
				PageProductData data = null;
				/* id不为空 就查询出数据 并更改数据 */
				if (pageProductData.getId() != null && !"".equals(pageProductData.getId())) {
					data = pageProductPersistence.retrieve(pageProductData.getId());
				}
				data.setStatus(1);
				data.setProductContent(phone);
				pageProductPersistence.update(data); // 更新服务中间表
				// 如果查询出来的域名集合不为空，就查询到这个文件，并且用新修改的内容替换掉
				String pagePath = "/pagehtml/";
				String realpath = ServletActionContext.getServletContext().getRealPath(pagePath); // 获取根目录
				File path = new File(realpath); // 判断目录是否存在，如果不存在则创建该目录
	             if (!path.exists()) {
	                 path.mkdirs();
	             }
	             try {
	                 // 写入文件
	                 OutputStreamWriter isw = new OutputStreamWriter(new FileOutputStream(realpath + File.separator + domain),"UTF-8");// 重新生成文件
	                 BufferedWriter bw = new BufferedWriter(isw);
	                 bw.write(main, 0, main.length());
	                 bw.close();
	                 isw.close();
	             } catch (IOException e1) {
	                 e1.printStackTrace();
	             }
			}
			msg = "1";
		} catch (Exception e) {
			msg = "0";
		}
		return msg;
	}

	/**
	 * 修改page电话号码
	 * 
	 * @author 左香勇
	 * @date 2014-04-30
	 * @param productData
	 * @param pageId
	 */
	public void editProductPagePhone(PageProductData pageProductData,
			String pageId, String oldPhone, String phone) {

		if (pageId != null && !"".equals(pageId)) { // 如果id不为空查询出数据
			String domain = pageManageBusiness.getDomainByPage(pageId);
			PageData pageData = pagePersistence.retrieve(pageId);// 得到页面对象

			String content = "";
			try {
				content = ClobFile.clobToString(pageData.getContent()); // 取出大字段并转化为String
																		// 类型
			} catch (SQLException e) {
				e.printStackTrace();
			}
			/* 截取字符串 替换掉旧的电话号码 * */
			String newcontent = content.replaceAll(oldPhone, phone);

			Clob c = Hibernate.createClob(newcontent); // 把String 类型转化为CLOB类型

			pageData.setContent(c);
			pagePersistence.update(pageData); // 更新page表
			PageProductData data = null;

			/* id不为空 就查询出数据 并更改数据 */
			if (pageProductData.getId() != null
					&& !"".equals(pageProductData.getId())) {
				data = pageProductPersistence.retrieve(pageProductData.getId());
			}
			data.setStatus(1);
			data.setProductContent(phone);
			pageProductPersistence.update(data); // 更新服务中间表
			// 如果查询出来的域名集合不为空，就查询到这个文件，并且用新修改的内容替换掉
			String pagePath = "/pagehtml/";
			String realpath = ServletActionContext.getServletContext()
					.getRealPath(pagePath); // 获取根目录

			try {
			    HibernateDao hd = (HibernateDao) SpringContextHelper.getBean("hibernate");
	            Session session = hd.getHT().getSessionFactory().getCurrentSession();
	            session.refresh(pageData);
				ClobFile.generaFile(c, realpath, domain);
			} catch (Exception e) {
				e.printStackTrace();
			} // 重新生成文件
		}
	}

	/**
	 * 更新服务，启动 上传文件
	 * 
	 * @author 侯杨
	 * @date 2014-03-13
	 * @param pageProductData
	 */
	public String updateProductPageFile(PageProductData pageProductData) {
		String msg = "0";
		try {
			PageProductData data = null;
			/* id不为空 就查询出数据 并更改数据 */
			if (pageProductData.getId() != null
					&& !"".equals(pageProductData.getId())) {
				data = pageProductPersistence.retrieve(pageProductData.getId());
			}
			data.setStatus(1);
			data.setIsrz(1);
			pageProductPersistence.update(data); // 更新服务中间表
			msg = "1";
		} catch (Exception e) {
			msg = "0";
		}
		return msg;
	}

	@Override
	public List<ProductData> getAllProduct(ProductData productData) {
		String hql = "from ProductData where 1=1 and status = 'OPEN' and sign is null and type <> 3";
		return productPersistence.search(hql);
	}

	@Override
	public List<List<ProductData>> getProductNoDomain(String decode) {
		return productPersistence.getProductNoDomain(decode);
	}

	@Override
	public List<List<ProductData>> getProductNoPage(String decode) {
		return productPersistence.getProductNoPage(decode);
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
	public List<ProductData> getProductDataByJson(JSONObject object) {
		return productPersistence.getProductDataByJson(object);
	}

	// 根据特殊标识查询出发布权限的服务信息
	@Override
	public ProductData findBySign(int i) {
		return productPersistence.findBySign(i);
	}

	// 检查productid的来源，并返回product对象
	@Override
	public List<ProductData> checkProduct(String[] productid) {

		List<ProductData> productDatas = new ArrayList<ProductData>();
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("[");
		for (int i = 0; i < productid.length; i++) {

			ProductData productData = new ProductData();
			productData = productPersistence.retrieve(productid[i]); // 根据购物车信息的服务id
																		// 查询出服务实体

			if (productData == null) {
				strbuf.append("{productId:\"" + productid[i] + "\"}");
				if (i != (productid.length - 1)) {
					strbuf.append(",");
				}
			} else {
				productDatas.add(productData);
			}
		}
		strbuf.append("]");
		try {
			List<ProductData> datas = CTNProductUtil.getCtnJSON(strbuf
					.toString());
			if (datas != null && datas.size() > 0) {
				for (ProductData data : datas) {
					productDatas.add(data);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return productDatas;
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
		return productPersistence.getProductDataByIdStr(str);
	}

	/**
	 * 服务管理，启用在线客服这款服务，部署talk99
	 * 
	 * @author hy
	 * @date 2014-04-17
	 * @param contenu
	 * @param data
	 * @return
	 */
	@Override
	public String updatePageProductTak(String contenu, PageProductData data) {
		String msg = "0";
		List<PageInfoExtraData> pageInfoExtraDatas = null;
		/* 如果pageproduct实体不为空，取出page id，查询page实体 */
		PageData pageData = null;
		try {
			if (data != null) {
				pageData = pagePersistence.retrieve(data.getPageId());
				String hql = "from PageInfoExtraData pi where pi.pageId='"
						+ data.getPageId() + "'  and pi.type=2";
				pageInfoExtraDatas = pageInfoExtraPersistence.search(hql);
			}
			// 取出存在page里面的大字段 ，转化为String类型
			String con = null;
			try {
				con = ClobFile.clobToString(pageData.getContent()); // 取出大字段并转化为String
																	// 类型
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String S1 = con.substring(0, con.lastIndexOf("</head>")); // 获取</body>前一段
			String S2 = con.substring(con.indexOf("</head>")); // 获取</body>后一段
			String main = S1 + contenu.trim() + S2; // 拼接陈新的字符串

			Clob c = Hibernate.createClob(main); // 把String 类型转化为CLOB类型

			pageData.setContent(c);
			pagePersistence.update(pageData); // 更新page表
			PageProductData pageProductData = null;
			/* id不为空 就查询出数据 并更改数据 */
			if (data.getId() != null && !"".equals(data.getId())) {
				pageProductData = pageProductPersistence.retrieve(data.getId());
			}
			pageProductData.setStatus(1); // 状态为开启
			/**
			 * 修改人：文东 给服务内容赋值
			 */
			pageProductData.setProductContent(contenu);// 给服务内容赋值 是在线客服的js代码内容
			pageProductPersistence.update(pageProductData); // 更新服务中间表
			// 如果查询出来的域名集合不为空，就查询到这个文件，并且用新修改的内容替换掉
			if (pageInfoExtraDatas != null && pageInfoExtraDatas.size() > 0) {
				String dom = pageInfoExtraDatas.get(0).getDomain(); // 当前为‘OPEN’状态的域名
				String pagePath = "/pagehtml/";
				String realpath = ServletActionContext.getServletContext()
						.getRealPath(pagePath); // 获取根目录
		        File path = new File(realpath); // 判断目录是否存在，如果不存在则创建该目录
		        if (!path.exists()) {
		            path.mkdirs();
		        }
		        // 写入文件
		        OutputStreamWriter isw = new OutputStreamWriter(new FileOutputStream(realpath + File.separator + dom),
		                "UTF-8");
		        BufferedWriter bw = new BufferedWriter(isw);
		        bw.write(main, 0, main.length());
		        bw.close();
		        isw.close();
			}
			msg = "1";
		} catch (Exception e) {
			msg = "0";
		}
		return msg;
	}

	/**
	 * 根据pageid和userid查询shoppingcart里面的所有该page的服务的集合
	 * 
	 * @param id
	 * @param userid
	 * @return
	 */
	@Override
	public List<ProductData> getShopProductByPageId(String id, String userid) {

		String shopHql = " from ShoppingCartData sd where sd.pageId=? and sd.userId=? and sd.isDelete=1";// 根据pageid和userid查询购物车服务
		List<ShoppingCartData> shopList = shoppingCartPersistence.search(
				shopHql, new Object[] { id, userid });

		List<ProductData> list = new ArrayList<ProductData>();// 用来返回的服务集合

		// 循环购物车来查询服务对象
		if (shopList != null && shopList.size() > 0) {
			for (ShoppingCartData data : shopList) {
				ProductData productData = productPersistence.retrieve(data
						.getProductId());// 根据购物车里面的服务id来查询服务对象
				list.add(productData);
			}
		}
		return list;
	}

	@Override
	public List<ProductData> getProductByPageId(String pageId) {
		// 定义hql语句
		String hql = "from ProductData pd,PageProductData pp where pd.id=pp.productId and pp.isdelete=1 and pp.pageId=?";
		// 查询获取ProductData和PageProductData对象
		List<Object[]> objects = productPersistence.searchAny(hql,
				new Object[] { pageId });
		List<ProductData> productDatas = new ArrayList<ProductData>();
		// 取出查询结果中的ProductData 放到list集合中返回
		for (int i = 0; i < objects.size(); i++) {
			productDatas.add((ProductData) objects.get(i)[0]);
		}
		return productDatas;
	}

	/**
	 * 根据pageid查询page所拥有的域名
	 * 
	 * @author 侯杨
	 * @date 2014-04-30
	 * @param pageId
	 * @return
	 */
	public PageInfoExtraData getPageDomain(String pageId) {
		PageInfoExtraData pageInfoExtraData = new PageInfoExtraData();
		List<PageInfoExtraData> extraDatas = new ArrayList<PageInfoExtraData>();
		// 根据pageid 查询page域名
		String peHql = " from PageInfoExtraData pe where pe.pageId=? and pe.status='OPEN'";
		if (pageId != null && !"".equals(pageId)) {
			extraDatas = pageInfoExtraPersistence.search(peHql,
					new Object[] { pageId });
			if (extraDatas != null && extraDatas.size() > 0) {
				pageInfoExtraData = extraDatas.get(0);
			}
		}
		return pageInfoExtraData; // 返回域名值
	}

	/**
     * 修改在线客服的预览效果
     * @author 冯鑫
     * @date 2014-06-12
     * @param pageID
     * @return
     */
    public void editOnLineProduct(PageData pageData) {
        pageData = pagePersistence.retrieve(pageData.getId());// 得到页面对象
        String content = "";
        try {
            content = ClobFile.clobToString(pageData.getContent());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        content = content.replace("<div id=\"previewPro\" style=\"position: fixed;top:40%;left:90%; right: 20;\"><img src=\"/view/images/pages/zaixian.jpg\"></div>", "");
        pageData.setContent(Hibernate.createClob(content));
        pagePersistence.update(pageData); // 更新page表
        String domain = pageManageBusiness.getDomainByPage(pageData.getId());
        String realpath = ServletActionContext.getServletContext().getRealPath("/pagehtml/"); // 获取根目录
        try {
            HibernateDao hd = (HibernateDao) SpringContextHelper.getBean("hibernate");
        	Session session = hd.getHT().getSessionFactory().getCurrentSession();
            session.refresh(pageData);
            /*
             * 修改人：文东
             * 修改内容：避免文件生成出错 在生成文件时判断 文件是否存在 也就是域名是否存在 若域名不存在则不生成文件
             * 修改时间：2014/08/01 11:40
             */
            if(domain!=null && !domain.equals("")){
                ClobFile.generaFile(pageData.getContent(), realpath, domain);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    /**
     * 
     *根据productData  实体查询服务详情<br>
     * 
     * @author li <br> 
     *		   2014-7-14
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    @Override
    public  ProductData getPrdouct(ProductData productData){
        StringBuffer hql=new StringBuffer("from ProductData p where 1=1");
        List<Object> objects = new ArrayList<Object>();
        //根据服务名称查询
          if(productData.getName()!=null && !"".equals(productData.getName())){
              hql.append(" and p.name = ?");
              objects.add(productData.getName());
          }
          List<ProductData> list=productPersistence.search(hql.toString(),objects);
            if(list!=null && list.size()>0){
                return list.get(0);
            }else {
                return null;
            }
    }

    @Override
    public List<PageProductData> getAllProductPageRoll(String userId, PageRoll pageRoll) {
        
        // 定义sql 语句
        String sql = "select * from MINI_PAGEPRODUCT pa where pa.ISDELETE = 1 and pa.STATUS is not null "
                + "and pa.PAGEID in (select p.ID from MINI_PAGE p where p.USER_ID = ? and p.isDelete = 1   ) order by pa.pageid,pa.createtime desc";
        List<Object> objects = new ArrayList<Object>();
        objects.add(userId);
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询
        pageRoll.setSearchSQL(sql);
        pageRoll.setCountSQL("select count(*) from (" + sql + ")");
        List<ETIPResultSet> resultSet = dao.search(pageRoll, objects);// 分页查询
        List<PageProductData> list = new ArrayList<PageProductData>(); // 用来返回数据的集合
        for (int i = 0; i < resultSet.size(); i++) {
            ETIPResultSet rs = resultSet.get(i);
            PageProductData data = new PageProductData();
            data.setPageId(rs.getString("PAGEID"));
            data.setProductId(rs.getString("PRODUCTID"));
            data.setYeraNum(rs.getInt("YERANUM"));;
            data.setExpireTime(rs.getDate("EXPIRETIME"));
            data.setCreateTime(rs.getDate("CREATETIME")); 
            data.setIsdelete(rs.getInt("ISDELETE"));
            data.setId(rs.getString("ID"));
            data.setStopType(rs.getInt("STOPTYPE"));
            data.setStopDesc(rs.getString("STOPDESC"));
            data.setStopTime(rs.getDate("STOPTIME")); 
            data.setSignName(rs.getString("SIGNNAME"));
            data.setSignPath(rs.getString("SIGNPATH"));
            data.setSignTime(rs.getDate("SIGNTIME"));
            data.setProductName(rs.getString("PRODUCTNAME"));
            data.setStatus(rs.getInt("STATUS"));
            data.setProductContent(rs.getString("PRODUCTCONTENT"));
            list.add(data);
        }
        for (int i = 0; i < list.size(); i++) {
            //查询域名
            String peHql = " from PageInfoExtraData pe where pe.pageId=? and pe.status='OPEN'";
            List<PageInfoExtraData> pageInfolist = pageInfoExtraPersistence.search(peHql, new Object[]{list.get(i).getPageId()});
            PageInfoExtraData pageInfoExtra=new PageInfoExtraData();
            if(pageInfolist.size()>0){
                pageInfoExtra=pageInfolist.get(0);
            }
            PageData pageData = pagePersistence.retrieve(list.get(i).getPageId());
            /**
             * 修改人 文东 当服务为 免费时 过期 标示 为4
             */
            int decide = 1;// 0:过期了 1:正常 2:截至时间null 3:提示还有一个月到期
            ProductData data2 = new ProductData();
            if(list.get(i).getProductId()!=null && !list.get(i).getProductId().equals("")){
                data2=productPersistence.retrieve(list.get(i).getProductId());
                if(data2.getPrice() == null || data2.getPrice() == 0){
                }else{
                    decide = pageProductDataIfUse(list.get(i));
                };
            }
            int count = getCountProduct(list.get(i).getPageId());// page里面服务的数量
            // 是否过期的标识
            list.get(i).setDecide(decide);
            list.get(i).setCount(count);// page里面服务的数量
            list.get(i).setPageData(pageData);
            list.get(i).getPageData().setPageInfoExtra(pageInfoExtra);   //page域名实体
            list.get(i).setProductData(data2);
           
        }
        return list;
    }
    

}
