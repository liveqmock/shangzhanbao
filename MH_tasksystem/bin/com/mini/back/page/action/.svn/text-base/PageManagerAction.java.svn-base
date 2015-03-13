package com.mini.back.page.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.common.util.ResouceUtil;
import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.cache.CacheUtil;
/**
 * 
 * 〈后台page管理〉<br> 
 * 〈功能详细描述〉
 * @author hy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
import com.mini.back.page.facade.PageManagerFacade;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.page.data.PageData;
import com.mini.page.data.PageHelpData;
import com.mini.page.persistence.IPagePersistence;
import com.sys.user.data.UserData;
import com.sys.user.facade.UserFacade;
import com.util.ReadDomain;
import com.util.mail.MailUtil;

@ResultPath("/")
@Results({ @Result(name = "getAllPage", location = "/view/pages/mini/back/pageManager/showAllPage.jsp"), // 查询所有
        @Result(name = "startPage", type = "redirectAction", location = "/page_manager/key/getAll"), // 禁用
        @Result(name = "pageView", location = "/view/pages/mini/back/pageManager/pageView.jsp") // 详情
})
public class PageManagerAction extends FrmAction {

    @Resource(name = "pageManagerFacade")
    private PageManagerFacade pageManagerFacade; // page管理Facade
    @Resource(name = "pagePersistence")
    private IPagePersistence pagePersistence;
    @Resource(name = "userFacade")
    private UserFacade userFacade;
    private PageHelpData pageHelpData = new PageHelpData(); // page帮组实体类
    private List<PageHelpData> list = new ArrayList<PageHelpData>();
    private PageRoll pageRoll = new PageRoll(); // 分页
    @SuppressWarnings("unchecked")
	private TreeMap<Integer, String> disabledType = CacheUtil.getInstance().getCacheMap("disabledType"); // 禁用类型
    @SuppressWarnings("unchecked")
	private TreeMap<Integer, String> stopType = CacheUtil.getInstance().getCacheMap("stopType"); // 服务停用用类型
    private PageData pageData = new PageData(); // 个人page对象
    private UserData userData = new UserData();
    private String pageId;
    private String pageInfoId;
    private List<PageData> pageDatas = new ArrayList<PageData>(); // page集合
    PageInfoExtraData pageInfoExtraData = new PageInfoExtraData(); // 域名对象
    
    private String[] ids;  //pageid 数组

    /****************************************************************************************************************************************************************************************/
    
    
    /**
     * 查询全部 page 后台
     * 
     * @author 侯杨
     * @date 2014-2-19
     */
    public String getAll() {
        int sort = 0;
        String s=request.getParameter("sortTime");
                if(s!=null && !"".equals(s)){
            sort = Integer.parseInt(s);
                }
            if(sort != 0) {
                request.setAttribute("sortTime", 0);
            }else{
                request.setAttribute("sortTime", 1);
            }
        String path = ReadDomain.readProperties();
        request.setAttribute("path", path);
        pageDatas = pageManagerFacade.getAllPage(pageRoll, pageHelpData,sort);
        request.getSession().setAttribute("disabledType", disabledType);
        request.getSession().setAttribute("pageHelpData", pageHelpData);
        return "getAllPage";
    }

   
    public String getAllType() {
        pageDatas = pageManagerFacade.getAllPage(pageRoll, pageHelpData,0);
        request.getSession().setAttribute("disabledType", disabledType);
        return "getAllPage";
    }

    /**
     * 禁用 page 后台
     * 
     * @author 侯杨
     * @date 2014-2-19
     */
    public void disabledPage() {
        pageData.setStatus("2");
        String type = request.getParameter("pageData.disabledType");
        String res = request.getParameter("pageData.disabledReason");
        pageData.setDisabledType(Integer.parseInt(type));
        pageData.setDisabledReason(res);
        pageData.setDisableTime(new Date());
        pageManagerFacade.disabledPage(pageHelpData.getPageId(), pageData);

        /**
         * 禁用page发送邮件
         */
       userData = userFacade.getUserDataByPageId(pageHelpData.getPageId());
       
       pageData = pageManagerFacade.getPageId(pageHelpData.getPageId());
       
       if(userData!=null){
           if(userData.getLoginMail()!=null && MailUtil.exactnessMail(userData.getLoginMail())){
               Map<String, String> contentmap = new HashMap<String, String>();
               if(userData.getUserName() == null || "".equals(userData.getUserName())){
                   contentmap.put("userName", userData.getLoginMail());
               } else {
                   contentmap.put("userName", userData.getUserName());
               }
               contentmap.put("pageName", pageData.getName());
       
               new MailUtil(userData.getLoginMail(), contentmap, 10).run();
           }
       }
        
    }

    /**
     * 启用 page 后台
     * 
     * @author 侯杨
     * @date 2014-2-20
     */
    public void startPageState() {
        pageManagerFacade.startPage(pageData);
    }

    /**
     * 后台 page管理 查询详情
     * 
     * @return
     */
    public String getPageView() {
        request.getSession().setAttribute("disabledType", disabledType);
        pageData = pageManagerFacade.getPageId(pageHelpData.getPageId());
		/********** 从配置文件里面获取停用理由拼接成下拉框传给页面 ************/
		StringBuffer buffer = new StringBuffer();
		buffer.append("<select style='width:150px;' name='pageProductData.stopType' id='stopType' onchange= 'bao(this.options[this.options.selectedIndex].value)'>");
		for (Entry<Integer, String> entry : stopType.entrySet()) {
			String op = "<option value='" + entry.getKey() + "'/>"
					+ entry.getValue() + "</option>";
			buffer.append(op);
		}
		buffer.append("</select>");
		//UserData userData = userFacade.getAllUserInfo(JSONObject.fromObject("{\"userID\":\"" + pageData.getUserId() + "\"}")).get(0);
		
		/********** 停用理由end **************/
		//pagePath = ResouceUtil.getProperty("domain.properties", "path");
		request.setAttribute("pagePath", ResouceUtil.getProperty("domain.properties", "path"));
        request.setAttribute("page", pageData);
        request.setAttribute("sel", buffer.toString());
        return "pageView";
    }

    /**
     * 
     * 后台详情页面 解绑域名
     * 
     * @author 侯杨
     * @date 2014 2-21
     */
    public void dahuaPageInfoExtraInfo() {
        pageManagerFacade.dahuaPageInfoExtraInfo(pageId);
        json = "1";

    }

    /**
     * 后台详情页面 绑定独立域名
     * 
     * @author 侯杨
     * @date 2014-2-21
     */
    public void boundPageInfoExtraInfo() {
        String str=request.getParameter("domain");;  //独立域名
        String domain=null;
        //如果独立域名不是以http://开头的,就把http://拼接上
        if(str.startsWith("http://")){
        	domain=str;
        }else{
        	domain="http://"+str;
        }
        json=pageManagerFacade.boundPageInfoExtraInfo(pageId, domain);
      
    }
    /**
     * 
     * 管理员赠送page给用户<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-5-21
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void powerPageByUserID(){
        try {
            pageManagerFacade.powerPageByUserID(userData,pageData);
        } catch (Exception e) {
            e.printStackTrace();
            json="false";
        }
        json="true";
        
    }
    /**
     * 删除多条page数据  假删
     * @author 侯杨
     *@date 2014-5-20
     * @param id
     * @return
     */
    public void deletePageData(){
     	json=pageManagerFacade.deletePageData(ids);
     }
    /******************************************************************************************************************************************/

    public PageHelpData getPageHelpData() {
        return pageHelpData;
    }

    public void setPageHelpData(PageHelpData pageHelpData) {
        this.pageHelpData = pageHelpData;
    }

    public List<PageHelpData> getList() {
        return list;
    }

    public void setList(List<PageHelpData> list) {
        this.list = list;
    }

    public TreeMap<Integer, String> getDisabledType() {
        return disabledType;
    }

    public void setDisabledType(TreeMap<Integer, String> disabledType) {
        this.disabledType = disabledType;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getPageInfoId() {
        return pageInfoId;
    }

    public void setPageInfoId(String pageInfoId) {
        this.pageInfoId = pageInfoId;
    }

    public PageRoll getPageRoll() {
        return pageRoll;
    }

    public void setPageRoll(PageRoll pageRoll) {
        this.pageRoll = pageRoll;
    }

    public PageData getPageData() {
        return pageData;
    }

    public void setPageData(PageData pageData) {
        this.pageData = pageData;
    }

    public List<PageData> getPageDatas() {
        return pageDatas;
    }

    public void setPageDatas(List<PageData> pageDatas) {
        this.pageDatas = pageDatas;
    }

    public PageInfoExtraData getPageInfoExtraData() {
        return pageInfoExtraData;
    }

    public void setPageInfoExtraData(PageInfoExtraData pageInfoExtraData) {
        this.pageInfoExtraData = pageInfoExtraData;
    }
    public UserData getUserData() {
        return userData;
    }
	public String[] getIds() {
		return ids;
	}

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	

}
