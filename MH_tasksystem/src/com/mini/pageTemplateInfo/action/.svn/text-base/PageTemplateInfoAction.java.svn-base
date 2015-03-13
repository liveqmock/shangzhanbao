package com.mini.pageTemplateInfo.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.ResultPath;

import com.itour.etip.pub.frame.FrmAction;
import com.mini.pageTemplateInfo.data.PageTemplateInfoData;
import com.mini.pageTemplateInfo.facade.PageTemplateInfoFacade;

/**
 * 
 * 〈page内容管理信息〉<br>
 * 
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@ResultPath("/")
/* @Results({ @Result(name = "", location = "") }) */
public class PageTemplateInfoAction extends FrmAction {

	@Resource(name = "pageTemplateInfoFacade")
	private PageTemplateInfoFacade pageTemplateInfoFacade;

	private PageTemplateInfoData pageTemplateInfoData = new PageTemplateInfoData();

	/**
	 * 
	 * 〈添加Page内容信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-2-20
	 * @update
	 * @param [参数1] [参数1说明]
	 * @return [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public void addPageTemplateInfo() {
		if (pageTemplateInfoData != null) {
			pageTemplateInfoFacade.addPageTemplateInfo(pageTemplateInfoData);
			json = pageTemplateInfoData.getId();
		} else {
			json = "0";
		}
	}

	
	/**
	 * 
	 * 〈批量添加page信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-2-20
	 * @update
	 * @param [参数1] [参数1说明]
	 * @return [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public void batchAdd() throws Exception {
		String datajson = "";
		try {
			datajson = URLDecoder.decode(request.getParameter("dataJson"),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			json = "0";
		}
		if (!"".equals(datajson)) {
			JSONArray array = JSONArray.fromObject(datajson);
			for (int i = 0; i < array.size(); i++) {
				JSONObject object = (JSONObject) array.get(i);
				PageTemplateInfoData data = (PageTemplateInfoData) JSONObject
						.toBean(object, PageTemplateInfoData.class);
				if (data != null) {
					pageTemplateInfoFacade.addPageTemplateInfo(data);
				}
			}
			json = "1";
		} else {
			json = "0";
		}
	}

	/**
	 * 
	 * 〈修改Page内容信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-2-20
	 * @update
	 * @param [参数1] [参数1说明]
	 * @return [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public void editPageTemplateInfo() {
		if (pageTemplateInfoData != null) {
			pageTemplateInfoFacade.editPageTemplateInfo(pageTemplateInfoData);
			json = pageTemplateInfoData.getId();
		} else {
			json = "0";
		}
	}

	/**
	 * 
	 * 〈添加Page内容信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-2-20
	 * @update
	 * @param [参数1] [参数1说明]
	 * @return [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public void deletePageTemplateInfo() {
		String id = request.getParameter("id");
		pageTemplateInfoFacade.deletePageTemplateInfo(id);
	}

	/**
	 * 
	 * 〈查询所有page内容信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-2-20
	 * @update
	 * @param [参数1] [参数1说明]
	 * @return [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public String getAllPageTemplateInfo() {

		List<PageTemplateInfoData> list = pageTemplateInfoFacade
				.getAllPageTemplateInfo();

		request.setAttribute("pageAllList", list);

		return "getAllPageTemplateInfo";
	}

	/**
	 * 
	 * 〈根据模板id查询Page内容信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-2-20
	 * @update
	 * @param [pageTemplateId] [模板id]
	 * @return [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public String getAllPageTemplateInfoByPageTemplateId() {

		String pageTemplateId = request.getParameter("pageTemplateId");

		List<PageTemplateInfoData> list = pageTemplateInfoFacade
				.getAllPageTemplateInfoByPageTemplateId(pageTemplateId);

		request.setAttribute("pageList", list);

		return "toPageTemplateInfo";
	}

}
