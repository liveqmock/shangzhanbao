package com.mini.pageMessageboard.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.front.order.facade.PageProductFacade;
import com.mini.order.data.OrderProductData;
import com.mini.pageMessageboard.data.PageMessageboardData;
import com.mini.pageMessageboard.facade.PageMessageboardFacade;
import com.mini.product.data.PageProductData;

/**
 * page留言板信息Action层
 * 
 * @author 左香勇 2014-3-31
 * @see PageMessageboardAction
 * @since
 */
@ResultPath("/")
@Results({
		@Result(name = "toPageMessageboard", location = "/view/pages/mini/page/messageBoard/messageBoard.jsp"),
		@Result(name = "topageMessageboardManage", location = "/view/pages/mini/page/messageBoard/messageBoardManage.jsp") })
public class PageMessageboardAction extends FrmAction {

	@Resource(name = "pageMessageboardFacade")
	private PageMessageboardFacade pageMessageboardFacade;
	@Resource(name = "pageProductFacade")
	private PageProductFacade pageProductFacade;//page服务关联表

	private PageMessageboardData pageMessageboardData = new PageMessageboardData();

	private PageRoll pageRoll = new PageRoll(); // 分页

	/**
	 * 添加留言板信息
	 * 
	 * @author 左香勇 2014-3-31
	 * @update
	 * 
	 */
	public void addPageMessageboard() {
		pageMessageboardData.setCreatetime(new Date());
		pageMessageboardData.setIsread(0);// 未阅读
		pageMessageboardFacade.addPageMessageboard(pageMessageboardData);
	}
	
	/**
	 * 根据id删除留言板信息
	 * 
	 * @author 左香勇 2014-4-11
	 * @update
	 * @param pageMessageBoardData
	 * 
	 */
	public void deletePageMessageboard(){
		String id = request.getParameter("id");
		pageMessageboardFacade.deletePageMessageboardByid(id);
	}

	/**
	 * 
	 * 修改留言板信息
	 * 
	 * @author 左香勇 2014-4-9
	 * @update
	 * @param pageMessageboardData
	 */
	public void editPageMessageboard() {
		pageMessageboardData.setIsread(1);// 已阅读
		pageMessageboardFacade.editPageMessageboard(pageMessageboardData);
	}

	/**
	 * 跳转到page留言板管理页面
	 * 
	 * @return
	 */
	public String topageMessageboardManage() {
		String pageid = request.getParameter("pageid");// 获取pageid
		String read = request.getParameter("isread");// 获取是否阅读
	
		Integer isread = null;
		if (read != null && !"".equals(read)) {
			isread = Integer.parseInt(read);
		}

		List<PageMessageboardData> pmDatalist = pageMessageboardFacade
				.getAllPageMessageboard(pageRoll, pageid, isread);

		request.setAttribute("pmDatalist", pmDatalist);
		request.setAttribute("pageid", pageid);
		request.setAttribute("isread", isread);
     
        String productId=request.getParameter("productId");  //服务id
        request.setAttribute("productId", productId);
        String pageName=request.getParameter("pageName"); //page名称
        request.setAttribute("pageName", pageName);
        /*查询page使用服务状态*/
        OrderProductData orderProductData=new OrderProductData();
        orderProductData.setPageId(pageid);
        orderProductData.setProductId(productId);
        PageProductData data=pageProductFacade.getPageProductData(orderProductData);
        request.setAttribute("messtatus",data.getStatus() );  //留言状态
		return "topageMessageboardManage";

	}

	/**
	 * 根据id查询留言板信息
	 * 
	 * @return
	 */
	public void getPageMessageboardByid() {
		String id = request.getParameter("id");// 获取留言板主键id

		pageMessageboardData = pageMessageboardFacade
				.getPageMessageboardByid(id);
		request.setAttribute("pageMessageboardData", pageMessageboardData);

		editPageMessageboard();// 调用修改方法
	}

	/**
	 * 跳转到留言板信息页面
	 * 
	 * @author 左香勇 2014-3-31
	 * @update
	 * @param pageMessageBoardData
	 * 
	 */
	public String toPageMessageboard() {
		request.setAttribute("pageid", request.getParameter("pageid"));
		return "toPageMessageboard";
	}

	public PageMessageboardData getPageMessageboardData() {
		return pageMessageboardData;
	}

	public void setPageMessageboardData(
			PageMessageboardData pageMessageboardData) {
		this.pageMessageboardData = pageMessageboardData;
	}

	public PageRoll getPageRoll() {
		return pageRoll;
	}

	public void setPageRoll(PageRoll pageRoll) {
		this.pageRoll = pageRoll;
	}

}
