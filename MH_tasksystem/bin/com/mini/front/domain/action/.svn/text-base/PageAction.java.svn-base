package com.mini.front.domain.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.common.util.ReadWriteFile;
import com.common.util.ResouceUtil;
import com.common.util.UploadPath;
import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.back.product.facade.ProductFacade;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.front.domain.facade.PageFacade;
import com.mini.front.domain.facade.PageInfoExtraFacade;
import com.mini.page.data.PageData;
import com.mini.util.ImageUtil;
import com.mini.util.OutClobFile;
import com.util.DateFormatUtil;

/**
 * 
 * 〈域名管理的控制层〉<br>
 * 〈功能详细描述〉
 * 
 * @author 林海鹏
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@ResultPath("/")
@Results({ @Result(name = "pageList", location = "view/pages/mini/front/domain/pageInfoExtraList.jsp"),
        @Result(name = "bindingDomain", location = "page/key/getAllPageInfo", type = "redirectAction")})
public class PageAction extends FrmAction {
    private PageRoll pageRoll = new PageRoll();// 分页对象
    @Resource(name = "pageFacade")
    private PageFacade pageFacade; // page表facade类
    @Resource(name = "pageInfoExtraFacade")
    private PageInfoExtraFacade pageInfoExtraFacade;// 域名管理facade类
    @Resource(name = "productFacade")
    private ProductFacade productFacade;// 服务facade 接口
    private List<PageData> secondLevelList = new ArrayList<PageData>();// 我的二级域名
    private List<PageData> independentList = new ArrayList<PageData>();// 我的独立域名
    private PageData pageData = new PageData();
    private PageInfoExtraData pageInfoExtraData = new PageInfoExtraData(); 

    public static final String fileName = "domain.properties";
    public static final String PATH = ResouceUtil.getProperty(fileName, "path");// 读取文件中的路径
    

    /**
     * 验证二级域名是否存在
     * 
     * @throws IOException
     */
    public void checktwoDomain() throws IOException {
        String dom = request.getParameter("lastName");
        String pagePath = "/pagehtml/";
        String realpath = ServletActionContext.getServletContext().getRealPath(pagePath);
        String Npath = realpath + dom + ".html";
        File file = new File(Npath);
        if (!file.exists()) {
            response.getWriter().print("0");
        } else {
            response.getWriter().print("1");
        }

    }

    /**
     * 
     * 发布page时候校验域名是否被占用<br>
     * 
     * @author 冯鑫 <br>
     *         2014-4-13
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @throws IOException
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void checkDomainIsUse() throws IOException {
        // pageDatadomain为前台传过来的域名 格式为 xxx
        String pageDatadomain = request.getParameter("pageDatadomain");
        // realpath为生成page文件的文件夹
        String realpath = ServletActionContext.getServletContext().getRealPath("/pagehtml/");
        if (pageDatadomain != null && !"".equals(pageDatadomain)) {
            List<PageInfoExtraData> list = new ArrayList<PageInfoExtraData>();
            list = pageInfoExtraFacade.getPageInfoExtraData(JSONObject.fromObject("{ \"domain\":\""
                    + pageDatadomain.concat(".html") + "\"}"));
            // 如果list>0则说明 此域名已经被占用
            if (list.size() > 0) {
                json = "1";
            } else {
                File file = new File(realpath);
                String str[] = file.list();
                if(str.length>0){
                    for (int i = 0; i < str.length; i++) {
                        // 如果list不大于0则 但是此域名的html文件已经被生成 则还是提示为被占用
                        if (str[i].equals(pageDatadomain.concat(".html"))) {
                            json = "1";
                            break;
                        } else {
                            json = "0";
                        }
                    }
                }else{
                    json = "0"; 
                }
            }
        }
    }

    /**
     * 添加二级域名方法
     * 
     * @throws IOException
     */
    public void addTwoDomain() throws Exception {
        String pagePath = "/pagehtml";
        String realpath = ServletActionContext.getServletContext().getRealPath(pagePath);
        String jObject = request.getParameter("json");
        Map<String, Object> map = new HashMap<String, Object>();// 返回前段的map
        JSONObject jsonObject = JSONObject.fromObject(jObject);
        if (null != jObject && !jsonObject.get("pageId").equals("")) {
            List<PageData> list = pageFacade.getPageData(JSONObject.fromObject("{ \"id\":\"" + jsonObject.get("pageId")
                    + "\"}"));// 通过pageid把load出来
            if (null != list && list.size() > 0) {
                PageData pageData = list.get(0);
                pageData.setName(URLDecoder.decode(jsonObject.get("pageName").toString(),"UTF-8"));// page名称
                pageData.setStatus("1");
                pageData.setState("0");
                pageData.setPublishTime(new Date());
                //设置发布权限试用期限  冯鑫
                pageData.setEndTime(DateFormatUtil.aFewDaysAfter(new Date(), Integer.parseInt(ReadWriteFile.readTxtFile(ServletActionContext.getServletContext().getRealPath("/configure") + "/file.txt"))));
                String domainname = jsonObject.get("lastName").toString().trim() + ".html";
                PageInfoExtraData pData = new PageInfoExtraData();
                pData.setPageId(jsonObject.get("pageId").toString());
                pData = pageInfoExtraFacade.searchByPageId(pData);
                // 查询此page是否已经有域名
                if (pData != null) {
                    pData.setPageId(jsonObject.get("pageId").toString());
                } else {
                    pData = new PageInfoExtraData();
                    pData.setPageId(jsonObject.get("pageId").toString());
                }
                pData.setBindingTime(new Date());// 创建时间
                pData.setCompany(URLDecoder.decode(jsonObject.get("pageName").toString(),"UTF-8"));// 公司名称
                pData.setDomain(domainname);// 二级域名名称
                // pageid
                pData.setStatus("OPEN");// 开启状态
                pData.setType("2");// 属于二级域名
                pageInfoExtraFacade.editPageInfoExtra(pData);
                map.put("noPayState", "0");
                map.put("pageName", jsonObject.get("pageName").toString());
                map.put("pageaddress", ResouceUtil.getProperty("domain.properties", "path").concat(domainname));
                try {
                    OutClobFile.generaFile(pageData.getContent(), realpath,
                            (jsonObject.get("lastName") + ".html").toString());
                    String fileName = File.separator + "pagehtml" + File.separator + domainname;
                    String imgPath = ImageUtil.createImg(ResouceUtil.getProperty("domain.properties", "pageTmp")
                            + fileName + "?abc=" + System.currentTimeMillis(),
                            UploadPath.REAL_PATH + ResouceUtil.getProperty("domain.properties", "realName"),
                            pageData.getId() + ".jpg");
                    if (imgPath != null && !"".equals(imgPath)) {
                        pageData.setPageImg(ResouceUtil.getProperty("domain.properties", "realName") + imgPath);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                pageFacade.editPage(pageData); // 把名称更新进去
            }
        }
        response.getWriter().write(JSONObject.fromObject(map).toString());
    }
    /**
     * 
     * page管理页面  只设置page域名和名称  不修改page状态<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-4-18
     * @throws UnsupportedEncodingException 
     * @update 
     */
    public void aloneSetTwoDomain() throws UnsupportedEncodingException{
        String pagePath = "/pagehtml";
        String realpath = ServletActionContext.getServletContext().getRealPath(pagePath);
        String jObject = request.getParameter("json");
        JSONObject jsonObject = JSONObject.fromObject(jObject);
        if (null != jObject && !jsonObject.get("pageId").equals("")) {
            List<PageData> list = pageFacade.getPageData(JSONObject.fromObject("{ \"id\":\"" + jsonObject.get("pageId")
                    + "\"}"));// 通过pageid把load出来
            PageData p = new PageData();
            p= list.get(0);
            p.setName(URLDecoder.decode(jsonObject.get("pageName").toString(),"UTF-8"));
            p.setState("0");
            pageFacade.editPage(p); 
            PageInfoExtraData pData = new PageInfoExtraData();
            pData.setPageId(jsonObject.get("pageId").toString());
            pData = pageInfoExtraFacade.searchByPageId(pData);
            if (pData != null) {
                pData.setPageId(jsonObject.get("pageId").toString());
            } else {
                pData = new PageInfoExtraData();
                pData.setPageId(jsonObject.get("pageId").toString());
                pData.setBindingTime(new Date());// 创建时间
            }
            pData.setStatus("OPEN");
            pData.setType("2");
            pData.setCompany(URLDecoder.decode(jsonObject.get("pageName").toString(),"UTF-8"));// 公司名称
            pData.setDomain(jsonObject.get("lastName").toString().trim().concat(".html"));// 二级域名名称
            pageInfoExtraFacade.editPageInfoExtra(pData);
            try {
                OutClobFile.generaFile(p.getContent(), realpath,
                        (jsonObject.get("lastName") + ".html").toString());
                String fileName = File.separator + "pagehtml" + File.separator + jsonObject.get("lastName").toString().trim() + ".html";
                String imgPath = ImageUtil.createImg(ResouceUtil.getProperty("domain.properties", "pageTmp")
                        + fileName + "?abc=" + System.currentTimeMillis(),
                        UploadPath.REAL_PATH + ResouceUtil.getProperty("domain.properties", "realName"),
                        p.getId() + ".jpg");
                if (imgPath != null && !"".equals(imgPath)) {
                    p.setPageImg(ResouceUtil.getProperty("domain.properties", "realName") + imgPath);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * //查询我的二级域名
     * 
     * @return
     */
    public String getAllPageInfo() {
        String json = "{ \"type\":\"2\" , \"status\":\"OPEN\"}";// type：1属于独立域名
        JSONObject jsonObject = JSONObject.fromObject(json);
        secondLevelList = pageFacade.getForpageRoll(pageRoll, jsonObject);// 我的二级域名记录
        //查询所有的独立域名
//        independentList = formatDate();// 我的独立域名
        request.setAttribute("menuNum", 6);
        for (int i = 0; i < secondLevelList.size(); i++) {
            secondLevelList.get(i).getPageInfoExtra().setDomain(PATH.concat(secondLevelList.get(i).getPageInfoExtra().getDomain()));
        }
        return "pageList";
    }

    /**
     * 
     * 〈绑定独立域名〉<br>
     * 
     * @author 林海鹏 <br>
     *         2014-2-19
     * @return [返回类型说明]
     */
    public String bindingDomain() {
        String id = request.getParameter("id");// 获取绑定的要绑定的独立域名的二级域名 id
        String domain = request.getParameter("domain");// 获取前台填写的独立域名名称
        json = "{ \"id\":\"" + id + "\"}";
        String pageId = request.getParameter("pageId");// 获取要绑定独立域名page 的id
        PageInfoExtraData pageInfoExtraData = new PageInfoExtraData();
        pageInfoExtraData.setPageId(pageId);
        pageInfoExtraData.setDomain(domain);
        pageInfoExtraData.setType("1");// 1 独立域名、2二级域名
        pageInfoExtraData.setStatus("OPEN");// OPEN=启用、CLOASED=禁用
        pageInfoExtraFacade.addPageInfoExtra(pageInfoExtraData);// 绑定一个独立域名及添加
        return "bindingDomain";
    }

    /**
     * 
     * 〈解绑独立域名〉<br>
     * 
     * @author linhp <br>
     *         2014-2-19
     */
    public String unBundlingDomain() {
        String oneid = request.getParameter("oneid");// 独立域名的记录的id
        String twoid = request.getParameter("twoid");// 二级域名的记录的id
        json = "{ \"id\":\"" + twoid + "\"}";
        JSONObject jsonObject = JSONObject.fromObject(json);
        List<PageInfoExtraData> list = pageInfoExtraFacade.getPageInfoExtraData(jsonObject);
        if (null != list && list.size() > 0) {
            PageInfoExtraData data = list.get(0);// 将要解绑独立域名的二级域名记录 改成启用状态
            data.setStatus("OPEN"); // 将二级域名的状态打开
            pageInfoExtraFacade.editPageInfoExtra(data);
        }

        String[] ids = new String[1];// 解绑独立域名 即删除独立域名记录
        ids[0] = oneid;
        pageInfoExtraFacade.deletePageInfoExtra(ids);
        return "bindingDomain";
    }

    /**
     * 切换绑定网页
     */
    public void switchBundling() {
        String ondid = request.getParameter("alongDomainId");// 获取当前独立域名的id
        String twoid = request.getParameter("twoLeaveid"); // 获取当前二级域名的id

        json = "{ \"id\":\"" + twoid + "\"}";
        JSONObject jsonObject = JSONObject.fromObject(json);
        List<PageInfoExtraData> list = pageInfoExtraFacade.getPageInfoExtraData(jsonObject);
        if (null != list && list.size() > 0) {
            PageInfoExtraData data = list.get(0);// 将要解绑独立域名的二级域名记录 改成启用状态
            data.setStatus("OPEN"); // 将二级域名的状态打开
            pageInfoExtraFacade.editPageInfoExtra(data);
        }

        // 弹层里面的pageid 和二级域名erid
        String pageid = request.getParameter("pageid");// 获取要绑定新的page的id
        String erid = request.getParameter("erid");//

        json = "{ \"id\":\"" + erid + "\"}";
        JSONObject jObject = JSONObject.fromObject(json);
        List<PageInfoExtraData> erlist = pageInfoExtraFacade.getPageInfoExtraData(jObject);
        if (null != erlist && erlist.size() > 0) {
            PageInfoExtraData data = erlist.get(0);// 将原有的二级域名记录 改成关闭状态
            data.setStatus("CLOSE"); //
            pageInfoExtraFacade.editPageInfoExtra(data);
        }

        json = "{ \"id\":\"" + ondid + "\"}";
        JSONObject jobject = JSONObject.fromObject(json);
        List<PageInfoExtraData> onelist = pageInfoExtraFacade.getPageInfoExtraData(jobject);
        if (null != onelist && onelist.size() > 0) {
            PageInfoExtraData data = onelist.get(0);// 将原有的二级域名记录 改成关闭状态
            data.setPageId(pageid);
            pageInfoExtraFacade.editPageInfoExtra(data);
        }
        json = "success";
    }
    /**
     * 
     *在发布页面，当有未付款服务时候，需要将page状态更改成暂存状态<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-4-23
     * @update 
     */
    public void changePageState(){
       pageData =pageFacade.getPageData(JSONObject.fromObject("{ \"id\":\"" + pageData.getId() + "\"}")).get(0);
       pageData.setStatus("0");
       pageData.setState("");
       pageFacade.editPage(pageData);
    }
    /**
     * 
     * 根据page域名查询 此page 的name<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-7-15
     * @update 
     * @return  json
     * @throws IOException 
     */
    public void searchByPageInfoExtraData() throws IOException{
        pageData = pageFacade.getPageDataByPageHtml(pageInfoExtraData);
        if(pageData!=null){
            String json ="{\"name\": \""+pageData.getName()+" \",\"id\": \""+pageData.getId()+"\",\"userId\": \""+pageData.getUserId()+"\"}";
                response.getWriter().print(json);
        }else{
            response.getWriter().print("1");
        }
    }

    public PageRoll getPageRoll() {
        return pageRoll;
    }

    public void setPageRoll(PageRoll pageRoll) {
        this.pageRoll = pageRoll;
    }

    public PageFacade getPageFacade() {
        return pageFacade;
    }

    public void setPageFacade(PageFacade pageFacade) {
        this.pageFacade = pageFacade;
    }

    public List<PageData> getIndependentList() {
        return independentList;
    }

    public void setIndependentList(List<PageData> independentList) {
        this.independentList = independentList;
    }

    public List<PageData> getSecondLevelList() {
        return secondLevelList;
    }

    public void setSecondLevelList(List<PageData> secondLevelList) {
        this.secondLevelList = secondLevelList;
    }

    public PageInfoExtraFacade getPageInfoExtraFacade() {
        return pageInfoExtraFacade;
    }

    public void setPageInfoExtraFacade(PageInfoExtraFacade pageInfoExtraFacade) {
        this.pageInfoExtraFacade = pageInfoExtraFacade;
    }

    public PageData getPageData() {
        return pageData;
    }

    public void setPageData(PageData pageData) {
        this.pageData = pageData;
    }

    public PageInfoExtraData getPageInfoExtraData() {
        return pageInfoExtraData;
    }

    public void setPageInfoExtraData(PageInfoExtraData pageInfoExtraData) {
        this.pageInfoExtraData = pageInfoExtraData;
    }
}
