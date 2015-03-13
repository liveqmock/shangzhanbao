package com.mini.front.tempmanage.action;

import java.io.File;
import java.io.IOException;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.common.util.ResouceUtil;
import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.JsonWithPageRoll;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.front.tempmanage.facade.TempManageFacade;
import com.mini.page.data.PageData;
import com.mini.page.data.PageHelpData;
import com.mini.page.data.PageTemplateData;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateHelpData;
import com.mini.tempmanage.data.TemplateThumbnailData;
import com.mini.util.OutClobFile;
import com.mini.util.OutImgBlob;
import com.sys.user.data.UserData;

/**
 * 模板管理Action
 * 
 * @author 文东
 * @see TempManageFacade
 * @since
 */
@Results(value = { @Result(name = "ownlist", location = "view/pages/mini/front/tempmanage/ownTempList.jsp"),
        @Result(name = "list", location="view/pages/mini/commonality/SelectTmplate.jsp"),
        @Result(name = "adminList", location = "view/pages/mini/back/tempmanage/tempList.jsp"),
        @Result(name = "tempView", location = "/view/pages/mini/back/tempmanage/tempView.jsp"),
        @Result(name = "pageCountAll", location = "/view/pages/mini/back/tempmanage/showCountPage.jsp"),
        @Result(name = "tempViewC", location = "/view/pages/mini/back/tempmanage/ctempView.jsp"),
        @Result(name = "tempViewF", location = "/view/pages/mini/back/tempmanage/ftempView.jsp"),
        @Result(name = "tempViewP", location = "/view/pages/mini/back/tempmanage/ptempView.jsp"),
        @Result(name = "tempInfo", location = "/view/pages/mini/front/template/tempInfo.jsp"),
        @Result(name = "tempMes", location = "/view/pages/mini/commonality/tempMes.jsp")

})
public class TempManageAction extends FrmAction {

    private String FBPATH = ResouceUtil.getProperty("domain.properties", "path");
    
    // 模板管理Facade 容器注入
    @Resource(name = "tempManageFacade")
    private TempManageFacade tempManageFacade;

    // 分页参数
    private PageRoll pageRoll = new PageRoll();

    // 分页参数
    private PageRoll pageRoll2 = new PageRoll();

    // 模板实体对象
    private TemplateData templateData = new TemplateData();

    // 模板实体对象集合
    private List<TemplateData> templateDatas = new ArrayList<TemplateData>();

    // 推荐模板
    private List<TemplateData> recommendTemplates = new ArrayList<TemplateData>();
    /* page 使用模板 对象 */
    PageTemplateData pageTemplateData = new PageTemplateData();

    // 模板缩略图对象
    private TemplateThumbnailData thumbnailData = new TemplateThumbnailData();

    // 模板缩略图对象集合
    private List<TemplateThumbnailData> thumbnailDatas = new ArrayList<TemplateThumbnailData>();

    // page个人实体集合
    private List<PageData> pageDatas = new ArrayList<PageData>();

    // 模板帮组集合
    private List<TemplateHelpData> templateHelpDatas = new ArrayList<TemplateHelpData>();

    // 主预览图
    private File fileMain;
    private String fileMainFileName;

    // PC览图
    private File filePC;
    private String filePCFileName;

    // 平板览图
    private File filePad;
    private String filePadFileName;

    // 手机览图
    private File filePhone;
    private String filePhoneFileName;

    private String tempIds[]; // 模板id。数组，可以删除多条数据

    private String type;// 排序传的参数
    //帮用户创建page功能下所需要的用户参数。
    private UserData userData;

    // 已过期的模板
    private List<TemplateData> limitTemplates = new ArrayList<TemplateData>();
    
    private PageHelpData pageHelpData=new PageHelpData();  //page帮组实体

    /********************************************************************************************************************************************/

    /**
     * 
     * 查询所有模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-18
     * @update
     * @param
     * @return String类型的值 用于返回前端页面
     * @exception/throws
     * @see TempManageAction#searchAllTemp()
     * @since
     */
    public String searchAllTempByUser() {
        // 获取登录用户的id
        String userId = getFrmUser().etipUserID;
        // 查询用户所拥有模板信息
        templateDatas = tempManageFacade.searchAllTempByUser(pageRoll, templateData, userId);
        for (int i = 0; i < templateDatas.size(); i++) {
            if(templateDatas.get(i).getDomain()!=null && !"".equals(templateDatas.get(i).getDomain())){
                templateDatas.get(i).setDomain(FBPATH+templateDatas.get(i).getDomain());
            }
        }
        templateDatas = getList(templateDatas);
        // 获取已过期的模板 分页问题 暂时没查
        // 获取推荐模板
        recommendTemplates = tempManageFacade.searchRecommend(userId);
        recommendTemplates = getList(recommendTemplates);
        request.setAttribute("menuNum", 4);
        return "ownlist";
    }

    /**
     * 
     * 查询所有已经启用的模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-19
     * @update
     * @param
     * @return String 返回前端模板商店页面
     * @exception/throws
     * @see TempManageAction#searchOpenTemp()
     * @since
     */
    public String searchOpenTemp() {
        // 获取排序方式
        String esc = templateData.getEsc();
        // 查询所有模板
        if (esc.equals("like")) {
         // 根据喜欢程度排序 查询模板
            templateDatas = tempManageFacade.searchByLike(pageRoll, templateData);
        }else{
            templateDatas = tempManageFacade.searchAllTemp(pageRoll, templateData, 4);
        }
        templateDatas = getList(templateDatas);
        request.setAttribute("param", esc);
        request.setAttribute("temp", "selected");
        return "list";
    }

    
    /**
     * 
     * 根据模板集合。查询图片。获取到新的模板集合对象<br>
     * 
     * @author 文东 <br>
     *         2014-4-12
     * @update
     * @param datas 模板集合
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see TempManageAction#getList(List)
     * @since
     */
    private List<TemplateData> getList(List<TemplateData> datas) {
        for (int i = 0; i < datas.size(); i++) {
            if (datas.get(i).getImgpath() == null || "".equals(datas.get(i).getImgpath())) {
                // 获取模板ID
                String id = datas.get(i).getId();
                // 获取模板缩略图
                thumbnailData = tempManageFacade.getThumbnailData(id, type);
                // 图片保存的路径
                String filePath = request.getRealPath("") + File.separator + "img" + File.separator + "edit";
                // 图片的名称
                String filename = "main_" + datas.get(i).getId();
                String myPath = "";
                // 获取图片地址
                try {
                    // 生成图片文件
                    OutImgBlob.outImg(thumbnailData.getContent(), filePath, filename);
                    // 获取图片地址
                    myPath = File.separator + "img" + File.separator + "edit" + File.separator + filename + ".jpg";
                    
                } catch (Exception e) {
                    myPath = "\\img\\editor\\erro.jpg";
                }
                datas.get(i).setImgpath(myPath);
                tempManageFacade.updateTemp(datas.get(i).getId(), datas.get(i));
            }
        }
        return datas;
    }

    /**
     * 
     * 查询所有模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-20
     * @update
     * @param
     * @return adminList 后台模板管理页面
     * @exception/throws
     * @see TempManageAction#searchAllToAdmin()
     * @since [起始版本]
     */
    public String searchAllToAdmin() {
        int sort = 0;
        if ("pcount".equals(type)) {
            sort = Integer.parseInt(request.getParameter("sortPage"));
            if(sort != 0) {
                request.setAttribute("sortPage", 0);
            }else{
                request.setAttribute("sortPage", 1);
            }
        }
        if ("Openpcount".equals(type)) {
            sort = Integer.parseInt(request.getParameter("sortUse"));
            if(sort != 0) {
                request.setAttribute("sortUse", 0);
            }else{
                request.setAttribute("sortUse", 1);
            }
        }
        if ("uploadingtime".equals(type)) {
            sort = Integer.parseInt(request.getParameter("sortTime"));
            if(sort != 0) {
                request.setAttribute("sortTime", 0);
            }else{
                request.setAttribute("sortTime", 1);
            }
        }
        templateHelpDatas = tempManageFacade.searchAllTempType(pageRoll, templateData, 0, type, sort);
        request.setAttribute("templateHelpDatas", templateHelpDatas);
        return "adminList";
    }

    /**
     * 
     * 添加模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-18
     * @update
     * @param
     * @return void
     * @exception/throws
     * @see TempManageAction#addTemp()
     * @since
     */
    public void addTemp() {
        // 获取当前登录用户的名称
        String name = getFrmUser().etipUserLoginName;
        String creator = "wendong";
        templateData.setCreator(creator);
        templateData.setUploadingName(name);
        // 判断是否添加成功 初始值为fail
        String status = "fail";
        try {
            // 向数据库中添加模板 以及模板缩略图
            tempManageFacade.addTemp(templateData, fileMain, filePC, filePad, filePhone);
            status = "success";
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            // 将是否添加成功的状态传到前台
            json = status;
        }
    }


    /**
     * 更具模板id查询模板信息 后台模板管理
     * 
     * @author hy
     * @date 2014-2-22
     * @param templateId 模板id
     * @return
     */
    public String getTemplateDataView() {
        templateData = tempManageFacade.getTemplateData(templateData.getId());
        int sum = tempManageFacade.statisticsTempPage(templateData.getId(), "0");   //使用page总数
               pageHelpData.setTempId(templateData.getId());
               pageHelpData.setPageState("0");
        int sum1= tempManageFacade.countTempPage(pageRoll,pageHelpData).size();  //正在使用page数
        int sum2 = tempManageFacade.statisticsTempPage(templateData.getId(), "1");  //已发布的page数
        
      
        List<TemplateThumbnailData> thumbnailDatas = templateData.getThumbnailDatas();
        for (int i = 0; i < thumbnailDatas.size(); i++) {
            if (thumbnailDatas.get(i).getType().equals("main")) {

                // 获取模板缩略图

                String filePath = request.getRealPath("") + File.separator + "img" + File.separator + "template";
                String filename = "main_" + thumbnailDatas.get(i).getId();
                String myPath = "";
                // 获取图片地址
                try {
                    OutImgBlob.outImg(thumbnailDatas.get(i).getContent(), filePath, filename);
                    myPath = request.getContextPath() + File.separator + "img" + File.separator + "template"
                            + File.separator + filename + ".jpg";
                } catch (Exception e) {
                    myPath = "\\img\\editor\\erro.jpg";
                }
                templateData.setEsc(myPath);
            }
            if (thumbnailDatas.get(i).getType().equals("pc")) {

                // 获取模板缩略图

                String filePath = request.getRealPath("") + File.separator + "img" + File.separator + "template";
                String filename = "pc_" + thumbnailDatas.get(i).getId();
                String myPath = "";
                // 获取图片地址
                try {
                    OutImgBlob.outImg(thumbnailDatas.get(i).getContent(), filePath, filename);
                    myPath = request.getContextPath() + File.separator + "img" + File.separator + "template"
                            + File.separator + filename + ".jpg";
                } catch (Exception e) {
                    myPath = "\\img\\editor\\erro.jpg";
                }
                templateData.setComputerImg(myPath);
            }
            if (thumbnailDatas.get(i).getType().equals("phone")) {

                // 获取模板缩略图

                String filePath = request.getRealPath("") + File.separator + "img" + File.separator + "template";
                String filename = "phone_" + thumbnailDatas.get(i).getId();
                String myPath = "";
                // 获取图片地址
                try {
                    OutImgBlob.outImg(thumbnailDatas.get(i).getContent(), filePath, filename);
                    myPath = request.getContextPath() + File.separator + "img" + File.separator + "template"
                            + File.separator + filename + ".jpg";
                } catch (Exception e) {
                    myPath = "\\img\\editor\\erro.jpg";
                }
                templateData.setPhoneImg(myPath);
            }
            if (thumbnailDatas.get(i).getType().equals("pad")) {

                // 获取模板缩略图

                String filePath = request.getRealPath("") + File.separator + "img" + File.separator + "template";
                String filename = "pad_" + thumbnailDatas.get(i).getId();
                String myPath = "";
                // 获取图片地址
                try {
                    OutImgBlob.outImg(thumbnailDatas.get(i).getContent(), filePath, filename);
                    myPath = request.getContextPath() + File.separator + "img" + File.separator + "template"
                            + File.separator + filename + ".jpg";
                } catch (Exception e) {
                    myPath = "\\img\\editor\\erro.jpg";
                }
                templateData.setFpdImg(myPath);
            }
        }
        request.setAttribute("sum", sum);
        request.setAttribute("sum1", sum1);
        request.setAttribute("sum2", sum2);
        return "tempView";
    }

    /**
     * 
     * 根据模板id查询所有模板缩略图<br>
     * 
     * @author 文东 <br>
     *         2014-2-21
     * @update
     * @param
     * @return imgs
     * @throws IOException
     * @exception/throws
     * @see TempManageAction#searhTempImg()
     * @since
     */
    public void ajaxSearhTempImg() throws IOException {
        String id = request.getParameter("id");// 模板id
        templateData.setId(id);
        // 查询模板缩略图
        thumbnailDatas = tempManageFacade.searhTempImg(templateData);
        for (int i = 0; i < thumbnailDatas.size(); i++) {
            // 图片保存的路径
            String filePath = request.getRealPath("") + File.separator + "img" + File.separator + "edit";
            // 图片的名称
            String filename = thumbnailDatas.get(i).getType() + "_" + thumbnailDatas.get(i).getId();
            String myPath = "";
            // 获取图片地址
            try {
                // 生成图片文件
                OutImgBlob.outImg(thumbnailDatas.get(i).getContent(), filePath, filename);
                // 获取图片地址
                myPath = File.separator + "img" + File.separator + "edit" + File.separator + filename + ".jpg";
            } catch (Exception e) {
                myPath = "\\img\\editor\\erro.jpg";
            }
            myPath = myPath.replace("\\", "\\\\");
            thumbnailDatas.get(i).setPath(myPath);
        }
        this.json = JsonWithPageRoll.toList(pageRoll, thumbnailDatas);
    }

    /**
     * 后台 模板管理 启用 停用操作
     * 
     * @author hy
     * @date 2014-2-22
     * @param tempId
     * @param state
     */
    public String updateTempState() {
        tempManageFacade.updateTempState(templateData.getId(), templateData.getStatus());
        return searchAllToAdmin();
    }

    /**
     * 后台模板管理 删除模板 假删
     * 
     * @author hy
     * @date 2014-2-23
     * @param tempId
     */

    public void delete() {
        /* String[] deleteId = request.getParameterValues("tempIds"); */
        tempManageFacade.delete(tempIds);

    }

    /**
     * 后台模板管理 修改模板
     * 
     * @author hy
     * @date 2014-2-23
     * @param tempId
     * @param templateData
     */

    public void updateTemp() {
        String id = request.getParameter("id");
        tempManageFacade.updateTemp(id, templateData);
        json = "yes";
    }

    public String getAll() {
        templateHelpDatas = tempManageFacade.searchAllTempType(pageRoll, templateData, 0, type, 0);
        return "adminList";
    }

    /**
     * 模板详情页面查看page列表
     * 
     * @author 侯杨  update  侯杨
     * @date 2014-2-25
     * @return
     */
    public String countTempPage() {
        pageDatas = tempManageFacade.countTempPage(pageRoll,pageHelpData);
        return "pageCountAll";
    }


    /**
     * 电脑图片
     * 
     * @author hy
     * @date 2014-2-22
     * @param templateId 模板id
     * @return
     */
    public String getTemplateDataViewC() {
        templateData = tempManageFacade.getTemplateData(templateData.getId());

        List<TemplateThumbnailData> thumbnailDatas = templateData.getThumbnailDatas();
        for (int i = 0; i < thumbnailDatas.size(); i++) {
            if (thumbnailDatas.get(i).getType().equals("pc")) {

                // 获取模板缩略图

                String filePath = request.getRealPath("") + File.separator + "img" + File.separator + "template";
                String filename = "pc_" + thumbnailDatas.get(i).getId();
                String myPath = "";
                // 获取图片地址
                try {
                    OutImgBlob.outImg(thumbnailDatas.get(i).getContent(), filePath, filename);
                    myPath = request.getContextPath() + File.separator + "img" + File.separator + "template"
                            + File.separator + filename + ".jpg";
                } catch (Exception e) {
                    myPath = "\\img\\editor\\erro.jpg";
                }
                templateData.setComputerImg(myPath);
            }

        }

        return "tempViewC";
    }

    /**
     * 平板
     * 
     * @author hy
     * @date 2014-2-22
     * @param templateId 模板id
     * @return
     */
    public String getTemplateDataViewF() {
        templateData = tempManageFacade.getTemplateData(templateData.getId());

        List<TemplateThumbnailData> thumbnailDatas = templateData.getThumbnailDatas();
        for (int i = 0; i < thumbnailDatas.size(); i++) {

            if (thumbnailDatas.get(i).getType().equals("pad")) {

                // 获取模板缩略图

                String filePath = request.getRealPath("") + File.separator + "img" + File.separator + "template";
                String filename = "pad_" + thumbnailDatas.get(i).getId();
                String myPath = "";
                // 获取图片地址
                try {
                    OutImgBlob.outImg(thumbnailDatas.get(i).getContent(), filePath, filename);
                    myPath = request.getContextPath() + File.separator + "img" + File.separator + "template"
                            + File.separator + filename + ".jpg";
                } catch (Exception e) {
                    myPath = "\\img\\editor\\erro.jpg";
                }
                templateData.setFpdImg(myPath);
            }
        }

        return "tempViewF";
    }

    /**
     * 手机
     * 
     * @author hy
     * @date 2014-2-22
     * @param templateId 模板id
     * @return
     */
    public String getTemplateDataViewP() {
        templateData = tempManageFacade.getTemplateData(templateData.getId());
        List<TemplateThumbnailData> thumbnailDatas = templateData.getThumbnailDatas();
        for (int i = 0; i < thumbnailDatas.size(); i++) {
            if (thumbnailDatas.get(i).getType().equals("phone")) {
                // 获取模板缩略图

                String filePath = request.getRealPath("") + File.separator + "img" + File.separator + "template";
                String filename = "phone_" + thumbnailDatas.get(i).getId();
                String myPath = "";
                // 获取图片地址
                try {
                    OutImgBlob.outImg(thumbnailDatas.get(i).getContent(), filePath, filename);
                    myPath = request.getContextPath() + File.separator + "img" + File.separator + "template"
                            + File.separator + filename + ".jpg";
                } catch (Exception e) {
                    myPath = "\\img\\editor\\erro.jpg";
                }
                templateData.setPhoneImg(myPath);
            }

        }

        return "tempViewP";
    }

    /**
     * 
     * ajax 获取模板页面<br>
     * 
     * @author 文东 <br>
     *         2014-3-20
     * @update 冯鑫 20140430
     *         增加页面所需要的参数
     * @param
     * @return void
     * @exception/throws
     * @see TempManageAction#ajaxSearhTempImg()
     * @since
     */
    public String ajaxSearchTempById() {
        // 获取模板ID
        String tempId = request.getParameter("id");
        // 获取模板
        templateData = tempManageFacade.searchById(tempId);
        // 文件路径
        String filePath = null;
        // 文件名称
        String fileName = null;
        if (templateData != null) {
            Clob clob = templateData.getContent();
            filePath = request.getRealPath("") + File.separator + "temp" + File.separator + "pagetemp";
            fileName = "pageModel_" + templateData.getId() + ".jsp";
            // 将模板内容生成页面
            try {
                OutClobFile.generaFile(clob, filePath, fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 获取生成jsp文件的地址
        String jspPath = File.separator + "temp" + File.separator + "pagetemp" + File.separator + fileName;
        request.setAttribute("template", jspPath);
        /***********************************************冯鑫begin******************************************************************/
        request.setAttribute("tempId", tempId);
        /***********************************************冯鑫end  *****************************************************************/
        return "tempInfo";
    }
    
    /**
     * 
     *模板留言跳转页面<br>
     * 
     * @author 侯杨<br> 
     *		   2014-6-18
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String totempMes(){
        return "tempMes";
    }

    /********************************************************************************************************************************************/

    public PageRoll getPageRoll() {
        return pageRoll;
    }

    public void setPageRoll(PageRoll pageRoll) {
        this.pageRoll = pageRoll;
    }

    public TemplateData getTemplateData() {
        return templateData;
    }

    public void setTemplateData(TemplateData templateData) {
        this.templateData = templateData;
    }

    public List<TemplateData> getTemplateDatas() {
        return templateDatas;
    }

    public void setTemplateDatas(List<TemplateData> templateDatas) {
        this.templateDatas = templateDatas;
    }

    public List<TemplateData> getRecommendTemplates() {
        return recommendTemplates;
    }

    public void setRecommendTemplates(List<TemplateData> recommendTemplates) {
        this.recommendTemplates = recommendTemplates;
    }

    public File getFileMain() {
        return fileMain;
    }

    public void setFileMain(File fileMain) {
        this.fileMain = fileMain;
    }

    public String getFileMainFileName() {
        return fileMainFileName;
    }

    public void setFileMainFileName(String fileMainFileName) {
        this.fileMainFileName = fileMainFileName;
    }

    public File getFilePC() {
        return filePC;
    }

    public void setFilePC(File filePC) {
        this.filePC = filePC;
    }

    public String getFilePCFileName() {
        return filePCFileName;
    }

    public void setFilePCFileName(String filePCFileName) {
        this.filePCFileName = filePCFileName;
    }

    public File getFilePad() {
        return filePad;
    }

    public void setFilePad(File filePad) {
        this.filePad = filePad;
    }

    public String getFilePadFileName() {
        return filePadFileName;
    }

    public void setFilePadFileName(String filePadFileName) {
        this.filePadFileName = filePadFileName;
    }

    public File getFilePhone() {
        return filePhone;
    }

    public void setFilePhone(File filePhone) {
        this.filePhone = filePhone;
    }

    public String getFilePhoneFileName() {
        return filePhoneFileName;
    }

    public void setFilePhoneFileName(String filePhoneFileName) {
        this.filePhoneFileName = filePhoneFileName;
    }

    public TemplateThumbnailData getThumbnailData() {
        return thumbnailData;
    }

    public void setThumbnailData(TemplateThumbnailData thumbnailData) {
        this.thumbnailData = thumbnailData;
    }

    public List<TemplateThumbnailData> getThumbnailDatas() {
        return thumbnailDatas;
    }

    public void setThumbnailDatas(List<TemplateThumbnailData> thumbnailDatas) {
        this.thumbnailDatas = thumbnailDatas;
    }

    public PageTemplateData getPageTemplateData() {
        return pageTemplateData;
    }

    public void setPageTemplateData(PageTemplateData pageTemplateData) {
        this.pageTemplateData = pageTemplateData;
    }

    public String[] getTempIds() {
        return tempIds;
    }

    public void setTempIds(String[] tempIds) {
        this.tempIds = tempIds;
    }

    public List<PageData> getPageDatas() {
        return pageDatas;
    }

    public void setPageDatas(List<PageData> pageDatas) {
        this.pageDatas = pageDatas;
    }

    public List<TemplateHelpData> getTemplateHelpDatas() {
        return templateHelpDatas;
    }

    public void setTemplateHelpDatas(List<TemplateHelpData> templateHelpDatas) {
        this.templateHelpDatas = templateHelpDatas;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TemplateData> getLimitTemplates() {
        return limitTemplates;
    }

    public void setLimitTemplates(List<TemplateData> limitTemplates) {
        this.limitTemplates = limitTemplates;
    }

    public PageRoll getPageRoll2() {
        return pageRoll2;
    }

    public void setPageRoll2(PageRoll pageRoll2) {
        this.pageRoll2 = pageRoll2;
    }

	public PageHelpData getPageHelpData() {
		return pageHelpData;
	}

	public void setPageHelpData(PageHelpData pageHelpData) {
		this.pageHelpData = pageHelpData;
	}

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
