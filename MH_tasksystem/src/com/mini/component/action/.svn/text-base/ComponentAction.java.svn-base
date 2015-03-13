package com.mini.component.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.Hibernate;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.mini.component.data.ComponentData;
import com.mini.component.facade.ComponentFacade;
import com.mini.front.pageManage.facade.PageManageFacade;
import com.mini.page.data.PageData;

@Results({
		@Result(name = "toeditLeft", location = "/view/pages/mini/page/edit/templateLeft/template_left_info.jsp"),
		@Result(name = "turnTopJsp_addTemp", location = "/view/pages/mini/back/newAddTemp/addTemp_top.jsp"),
		@Result(name = "indexs", type = "redirectAction", location = "page_manage/key/getAllPaga") })
		
		
public class ComponentAction extends FrmAction {

	@Resource(name = "componentFacade")
	private ComponentFacade componentFacade;

	private ComponentData componentData = new ComponentData();

	// page信息facade对象
	@Resource(name = "pageManageFacade")
	private PageManageFacade pageManageFacade;

	private PageData pageData = new PageData();
	
	private List<ComponentData> list_componentData = new ArrayList<ComponentData>();
	
	@SuppressWarnings("unchecked")
    private TreeMap<Integer, String> compType = CacheUtil.getInstance().getCacheMap("compType");

	/**
	 * 
	 * 〈跳转到 修改页面〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-3-10
	 * @update
	 * @param [参数1] [参数1说明]
	 * @return [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public String toeditLeft() {

		String componentid = request.getParameter("componentid");// 组件id

		// 获取组件实体信息
		componentData = componentFacade.getComponentByid(componentid);

		// 获取修改组件类型和id
		String editcode = componentData.getEditcode();
		// 获取是否修改组件背景
		Integer isbgimg = componentData.getUploadbgimg();
		//获取是否添加超链接
		Integer isaddLink = componentData.getAddLink();

		String edithtml = "动态构建修改页面失败，请联系管理员！";

		try {
			edithtml = getContent(editcode, isbgimg, isaddLink);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("editcode", edithtml);
		request.setAttribute("divnum", request.getParameter("divNum"));
		request.setAttribute("id", request.getParameter("pageid"));

		return "toeditLeft";
	}

	/**
	 * 根据code 获取修改页面html代码
	 * 
	 * @param 数据库存储的组件类型
	 *            ，格式“input:xxxxid,textarea:xxxid,img:xxxid”
	 * @return
	 */
	private String getContent(String code, Integer isbgimg, Integer isaddLink) throws Exception {
		if (isbgimg == null) {
			isbgimg = 1;
		}
		
		if (isaddLink == null) {
		    isaddLink = 1;
		}

		String bgimgId = "";//修改背景的组件id
		
		String[] codes1 = code.split(":");
		// 动态拼接字符串（html代码）
		StringBuffer sbfhtml = new StringBuffer("");
		
		String linkAdd = "";
		if (!codes1[0].equals("navigation")) {// 如果不是导航组件

			String[] codes2 = code.split(",");

			// 存储编辑的组件类型
			List<String> codeType = new ArrayList<String>();
			// 存储编辑的组件的id
			List<String> codeid = new ArrayList<String>();
			// 是否存在要上传的组件，默认为false
			boolean isupload = false;

			// 解析传入的code
			for (int i = 0; i < codes2.length; i++) {
				String[] codes3 = codes2[i].split(":");
				for (int j = 0; j < codes3.length; j++) {
					if (j % 2 == 0) {
						codeType.add(codes3[j]);
					} else {
						codeid.add(codes3[j]);
					}
				}
			}
			
			sbfhtml.append("<div class=\"clear\"></div>\n");
			sbfhtml.append("<div id=\"Frma_Left_Starp1\">\n");
			sbfhtml.append("<div class=\"Frma_Left_Starp1_tab\">\n");
			sbfhtml.append("<div class=\"FormTab\">\n");

			// 构建组件编辑项
			for (int i = 0; i < codeType.size(); i++) {
				if ("input".equals(codeType.get(i))) {// 如果组件类型为input
					sbfhtml.append("<p>标题</p>\n");
					sbfhtml.append("<textarea class=\"textarea_bg\" style=\"width: 218px; height: 50px\" id=\"edit_"
							+ codeid.get(i) + "\"></textarea>\n");
				}

	            if(linkAdd.equals("")){
	                linkAdd = codeid.get(i);
	            }

				if ("textarea".equals(codeType.get(i))) {// 如果组件类型为textarea
					sbfhtml.append("<p>描述</p>\n");
					sbfhtml.append("<textarea class=\"textarea_bg\" style=\"width: 218px; height: 100px\" id=\"edit_"
							+ codeid.get(i) + "\"></textarea>\n");
				}

				if ("img".equals(codeType.get(i))) {// 如果组件类型为img
					sbfhtml.append("<p style='padding-top:20px;'>配图</p>\n");
					sbfhtml.append("<div class=\"upload_div\">");
					sbfhtml.append("<div class=\"line\">");
					sbfhtml.append("<span class=\"span\">");
					sbfhtml.append("<input name=\"\" type=\"text\" id=\"viewfile\" class=\"inputstyle\" />");
					sbfhtml.append("</span>");
					sbfhtml.append("<label for=\"unload\" class=\"file_btn\">浏览</label>");
					sbfhtml.append("<input type=\"file\" name=\"uploadImg\" accept=\"image/jpeg,image/png,image/gif\" onchange=\"changeFile(this)\" class=\"file\"  id=\"edit_" + codeid.get(i) + "\" />");
					sbfhtml.append("</div>");
					sbfhtml.append("</div>\n");
					isupload = true;
				}
			}

			// 需要修改背景功能
			if (isbgimg == 0) {
				bgimgId = codeid.get(0);
			}
			sbfhtml.append("</div>\n");

			// 如果存在要上传的组件类型
			if (isupload) {
				sbfhtml.append("<div class=\"FormBtn\">\n");
				sbfhtml.append("<div>\n");
				sbfhtml.append("<p><a href=\"###\" class=\"font_caijan\" style=\"display:none;\" onclick=\"showJietu()\">图片不合适？点击裁剪</a><a href=\"###\" id=\"Btn_upload\" class=\"Btn_Upload\">上传</a></p>\n");
				sbfhtml.append("</div>\n");
				sbfhtml.append("</div>\n");
			}
		} else {
			sbfhtml.append("<div class=\"clear\"></div>\n");
			sbfhtml.append("<div id=\"Frma_Left_Starp1\">\n");
			sbfhtml.append("<div class=\"Frma_Left_Starp1_tab\">\n");
			sbfhtml.append("<div class=\"FormTab\">\n");
			sbfhtml.append("<p><strong>logo</strong></p>\n");
			sbfhtml.append("<div class=\"upload_div\">");
			sbfhtml.append("<div class=\"line\">");
			sbfhtml.append("<span class=\"span\">");
			sbfhtml.append("<input name=\"\" type=\"text\" id=\"viewfile\" class=\"inputstyle\" />");
			sbfhtml.append("</span>");
			sbfhtml.append("<label for=\"unload\" class=\"file_btn\">浏览</label>");
			sbfhtml.append("<input type=\"file\" name=\"uploadImg\" onchange=\"changeFile(this)\" class=\"file\" accept=\"image/jpeg,image/png,image/gif\" id=\"edit_" + codes1[1]  + "\" />");
			sbfhtml.append("</div>");
			sbfhtml.append("</div>\n");
			// 需要修改背景功能
			if (isbgimg == 0) {
				bgimgId = codes1[1];
			}
			sbfhtml.append("<br/><br/>");
			sbfhtml.append("<p><a href=\"###\" id=\"Btn_upload\" class=\"Btn_next\">上传</a></p>\n");
			sbfhtml.append("<p><a href=\"###\" id=\"nologo\" class=\"blueLine\">我还没有logo怎么办？</a></p>\n");
			sbfhtml.append("</div>\n");

		}

		// 添加保存、取消按钮html
		sbfhtml.append("<div class=\"clear\"></div>\n");
		sbfhtml.append("<div class=\"FormBtn\">\n");
		sbfhtml.append("<div style=\"float: left; margin: 0 15px 0 0;\">\n");
        sbfhtml.append("<a href=\"###\" id=\"edit_cancel\" class=\"Btn_next\">取消</a>\n");
		sbfhtml.append("</div>\n");
		sbfhtml.append("<div style=\"float: right\">\n");
        sbfhtml.append("<a href=\"###\" id=\"edit_baocun\" class=\"Btn_next\">保存</a>\n");
		sbfhtml.append("</div>\n");
		sbfhtml.append("</div>\n");
		sbfhtml.append("</div>\n");
		sbfhtml.append("</div>");

		// 需要修改背景功能
		if (isbgimg == 0) {
			sbfhtml.append("<div class=\"clear\"></div>\n");
			sbfhtml.append("<div id=\"Frma_Left_Starp1\">\n");
			sbfhtml.append("<div class=\"Frma_Left_Starp1_tab\">\n");
			sbfhtml.append("<div class=\"FormTab\">\n");
			sbfhtml.append("<p>背景图&nbsp;&nbsp;<a href=\"###\" id=\"delete_bg\">清除背景</a></p>\n");
			sbfhtml.append("<div class=\"upload_div\">");
			sbfhtml.append("<div class=\"line\">");
			sbfhtml.append("<span class=\"span\">");
			sbfhtml.append("<input name=\"\" type=\"text\" id=\"viewfile\" class=\"inputstyle\" />");
			sbfhtml.append("</span>");
			sbfhtml.append("<label for=\"unload\" class=\"file_btn\">浏览</label>");
			sbfhtml.append("<input type=\"file\" name=\"uploadImg\" onchange=\"changeFile(this)\" accept=\"image/jpeg,image/png,image/gif\" id=\"edit_"
					+ bgimgId + "_bgimg\" class=\"file\" />");
			sbfhtml.append("</div>");
			sbfhtml.append("</div>\n");
			sbfhtml.append("</div>\n");
			sbfhtml.append("<div class=\"FormBtn\">\n");
			sbfhtml.append("<div>\n");
			sbfhtml.append("<p><a href=\"###\" id=\"Btn_back\" class=\"Btn_Upload\">上传</a></p>\n");
			sbfhtml.append("</div>\n");
			sbfhtml.append("</div>\n");
			sbfhtml.append("</div>\n");
			sbfhtml.append("</div>\n");
			sbfhtml.append("</div>");
		}
		
		//需要添加超链接功能
		if (isaddLink == 0) {
            sbfhtml.append("<div class=\"clear\"></div>\n");
            sbfhtml.append("<div id=\"Frma_Left_Starp1\">\n");
            sbfhtml.append("<div class=\"Frma_Left_Starp1_tab\">\n");
            sbfhtml.append("<div class=\"FormTab\">\n");
            sbfhtml.append("<p><input type=\"checkbox\" isre=\"false\" onclick=\"checkLink(this)\" />添加超链接</p>\n");
            sbfhtml.append("<p><input type=\"text\" isre=\"false\" id=\"edit_link\" placeholder=\"请填写超链接\" readonly=\"readonly\" class=\"inputstyle\" /></p>\n");
            sbfhtml.append("</div>\n");
            sbfhtml.append("<div class=\"FormBtn\">\n");
            sbfhtml.append("<div style=\"float: left; margin: 0 15px 0 0;\">\n");
            sbfhtml.append("<a href=\"###\" id=\"edit_link_cal\" onclick=\"linkCal('"+linkAdd+"')\" class=\"Btn_next\">取消</a>\n");
            sbfhtml.append("</div>\n");
            sbfhtml.append("<div style=\"float: right\">\n");
            sbfhtml.append("<a href=\"###\" id=\"edit_link_ok\" onclick=\"linkOk('"+linkAdd+"')\" class=\"Btn_next\">确定</a>\n");
            sbfhtml.append("</div>\n");
            sbfhtml.append("</div>\n");
            sbfhtml.append("</div>\n");
            sbfhtml.append("</div>\n");
            sbfhtml.append("</div>");
        }

		return sbfhtml.toString();
	}

	/**
	 * 
	 * 〈修改page信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-3-13
	 * @update
	 */
	public void editPageInfo() {
		pageData.setContent(Hibernate.createClob(request
				.getParameter("content")));
		pageData.setCreateTime(new Date());
		pageManageFacade.editPageData(pageData);
	}

	public String toIndexs() {
		request.setAttribute("menuNum", 1);
		return "indexs";
	}
	/**
	 * 
	 * 增加模板中，查询所有组件和组件样式<br>
	 * 
	 * @author 冯鑫 <br> 
	 *		   2014-8-22
	 * @update 
	 *//*
	public void searchComponent_addTemp(){
	    list_componentData = componentFacade.searchComponent_addTemp(componentData);
	    json=JSONArray.fromObject(list_componentData);
	}*/
	/**
	 * 
	 * 增加模板，首页顶部页面跳转<br>
	 * 
	 * @author 冯鑫 <br> 
	 *		   2014-8-22
	 * @update 
	 */
	public String turnTopJsp_addTemp(){
	    compType.remove(1);
	    request.getSession().setAttribute("csstype", compType);
	    return "turnTopJsp_addTemp";
	}
	 /**
     * 
     *根据主键id查询主键信息<br>
     * 
     * @author 侯杨<br> 
     *         2014-9-19
	 * @throws IOException 
     * @update 
     * @see   ComponentAction#getCompData
     * @since vmaque1.6
     */
	public  void getCompData() throws IOException{
	            //type 为7  是购买主键
	          componentData.setType("7");
	          componentData=componentFacade.getComponentData(componentData);
	          if(componentData!=null){
	              JSONObject object = JSONObject.fromObject(componentData);
	              response.getWriter().print(object);
	          }else{
	              response.getWriter().print("1");
	          }
	}

	public ComponentData getComponentData() {
		return componentData;
	}

	public void setComponentData(ComponentData componentData) {
		this.componentData = componentData;
	}

	public PageData getPageData() {
		return pageData;
	}

	public void setPageData(PageData pageData) {
		this.pageData = pageData;
	}

    public List<ComponentData> getList_componentData() {
        return list_componentData;
    }

    public void setList_componentData(List<ComponentData> list_componentData) {
        this.list_componentData = list_componentData;
    }

    public TreeMap<Integer, String> getCompType() {
        return compType;
    }

    public void setCompType(TreeMap<Integer, String> compType) {
        this.compType = compType;
    }

}
