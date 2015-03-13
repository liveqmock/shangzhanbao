package com.mini.back.tempmanage.action;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.JsonWithPageRoll;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.back.tempmanage.facade.BackTempManageFacade;
import com.mini.component.data.ComponentData;
import com.mini.tempmanage.data.TemplateComponentData;
import com.mini.tempmanage.data.TemplateData;
import com.mini.util.OutClobFile;
import com.mini.util.OutImgBlob;
import com.util.CutStringUtil;

/**
 * 后台模板管理
 * 
 * @author 文东
 * @see BackTempManageAction
 * @since
 */
@Results(value = { @Result(name = "componentPicList", location = "view/pages/mini/back/tempmanage/frameworkList.jsp")

})
public class BackTempManageAction extends FrmAction {

    // 后台模板管理facade 容器注入
    @Resource(name = "backTempManageFacade")
    private BackTempManageFacade backTempManageFacade;

    // 组件集合
    private List<ComponentData> componentDatas = new ArrayList<ComponentData>();

    // 组件信息
    private ComponentData componentData = new ComponentData();

    // 模板集合
    private List<TemplateData> templateDatas = new ArrayList<TemplateData>();

    // 模板对象
    TemplateData templateData = new TemplateData();

    // 组件与模板关系对象
    TemplateComponentData templateComponentData = new TemplateComponentData();

    // 分页
    private PageRoll pageRoll = new PageRoll();

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

    /*********************************************************************************************************************************************/

    public void ajaxAddTemp() {
        // 获取当前登录用户的名称
        String name = getFrmUser().etipUserLoginName;
        templateData.setCreator(name);
        templateData.setUploadingName(name);
        // 判断是否添加成功 初始值为fail
        String status = "fail";
        try {
            // 向数据库中添加模板 以及模板缩略图
            backTempManageFacade.addTemp(templateData, fileMain, filePC, filePad, filePhone);
            status = "success";
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            // 将是否添加成功的状态传到前台
            json = status;
        }
    }

    /**
     * 
     * ajax查询可用组件内容<br>
     * 
     * @author 文东 <br>
     *         2014-3-8
     * @update
     * @param
     * @return void
     * @exception/throws
     * @see ajaxSearchComponent
     * @since
     */
    public void ajaxSearchComponent() {
        // 查询类型为组件内容的组件
        componentDatas = backTempManageFacade.searchComponent(componentData);
        json = JsonWithPageRoll.toList(pageRoll, componentDatas);
    }

    /**
     * 
     * 查询组件。并将组件内容返回<br>
     * 
     * @author 文东 <br>
     *         2014-3-9
     * @update 冯鑫
     *         2014-06-24
     *         在创建模板的时候，如果是理由组件或者是普通组件  就要修改html代码中id值
     * @param
     * @return void
     * @exception/throws
     * @see BackTempManageAction#ajaxSearchComponentById()
     * @since
     */
    public void ajaxSearchComponentById() {
        // 获取前端传来的id
        String id = componentData.getId();
        // 根据ID查询模板内容
        componentData = backTempManageFacade.searchComponentById(id);
        String content = null;
        // 将查询到的组件内容转换成String 传到前台
        /*try {
            content = OutClobFile.clobToString(componentData.getCode());
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        content = componentData.getCode();
        if("5".equals(componentData.getType())||"4".equals(componentData.getType())){
            if(!"".equals(componentData.getEditcode())&&null!=componentData.getEditcode()){
                content = CutStringUtil.changeDivID(componentData.getEditcode(), content);
            }
            
        }
        json = content;
    }
    /**
     * 
     * 查询到组件的源码，截取到只有<div class="update">内部的组件代码<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-6-13
     * @update 
     */
    public void ajaxSearchUseComponentById() {
        // 获取前端传来的id
        String id = componentData.getId();
        // 根据ID查询模板内容
        componentData = backTempManageFacade.searchComponentById(id);
        String content = null;
        // 将查询到的组件内容转换成String 传到前台
        /*try {
            content = OutClobFile.clobToString(componentData.getCode());
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        content = componentData.getCode();
        //如果Editcode不为空，则说明此组件为可重复组件  则每次添加的时候需要修改id值
        if(!"".equals(componentData.getEditcode())&&null!=componentData.getEditcode()){
            json =CutStringUtil.changeDivID(componentData.getEditcode(), CutStringUtil.cutUseDivTag(content,componentData.getId()));
        }else{
            json =CutStringUtil.cutUseDivTag(content,componentData.getId());
        }
        
    }

    /**
     * 
     * 进入编辑模板<br>
     * 
     * @author 文东 <br>
     *         2014-3-5
     * @update
     * @param
     * @return
     * @exception/throws
     * @see editTemp
     * @since
     */
    public void editTemp() {
        String id = request.getParameter("id");
        // 根据ID查询模板内容
        componentData = backTempManageFacade.searchComponentById(id);
        // 文件路径
        String filePath = null;
        // 文件名称
        String fileName = null;
        if (templateData != null) {
            filePath = request.getRealPath("") + File.separator + "temp" + File.separator + "pagetemp";
            fileName = "pageModel_" + componentData.getId() + ".jsp";
            try {
                OutClobFile.generaFile(componentData.getCode(), filePath, fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 获取生成jsp文件的地址
        String jspPath = File.separator + "temp" + File.separator + "pagetemp" + File.separator + fileName;
        json = jspPath;
    }

    /**
     * 
     * 查询所有可用模板的架构<br>
     * 
     * @author 文东 <br>
     *         2014-3-5
     * @update
     * @param
     * @return frameList 模板结合
     * @exception/throws
     * @see BackTempManageAction#searchTempFrame()
     * @since
     */
    public String searchTempFrame() {
        // 查询所有模板
        templateDatas = backTempManageFacade.searchTempFrame(templateData);
        return "frameList";
    }

    /**
     * 
     * 查询所有组件<br>
     * 
     * @author 文东 <br>
     *         2014-3-7
     * @update
     * @param
     * @return 返回模板架构页面
     * @exception/throws
     * @see BackTempManageAction#searchComponent()
     * @since
     */
    public String searchComponentAndPic() {
        componentDatas = backTempManageFacade.searchComponentAndPic(componentData);
        for (int i = 0; i < componentDatas.size(); i++) {
            // 图片保存的路径
            String filePath = request.getRealPath("") + File.separator + "img" + File.separator + "compoent";
            // 图片的名称
            String filename = "pc_" + componentDatas.get(i).getId();
            String myPath = "";
            // 获取图片地址
            try {
                // 生成图片文件
                OutImgBlob.outImg(componentDatas.get(i).getThumbnailData().getContent(), filePath, filename);
                // 获取图片地址
                myPath = File.separator + "img" + File.separator + "compoent" + File.separator + filename + ".jpg";
            } catch (Exception e) {
                myPath = "\\img\\editor\\erro.jpg";
            }
            componentDatas.get(i).setPcJpgPath(myPath);
        }
        return "componentPicList";
    }

    /**
     * 
     * 根据组件样式类别查询组件<br>
     * 
     * @author 文东 <br>
     *         2014-4-23
     * @update
     * @return json
     * @exception/throws
     * @see BackTempManageAction#ajaxSearchComponentBycssType()
     * @since
     */
    public void ajaxSearchComponentBycssType() {
        // 查询类型为组件内容的组件
        componentDatas = backTempManageFacade.searchComponent(componentData);
        json = JsonWithPageRoll.toList(pageRoll, componentDatas);
    }
    /**
     * 
     * 更具组件的四种类型分别过滤组件<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-5-26
     * @update 
     * @param 
     * @return  
     */
    public void ajaxSearchComponentByComponentType() {
        // 查询类型为组件内容的组件
        componentDatas = backTempManageFacade.ajaxSearchComponentByComponentType(componentData);
        json = JsonWithPageRoll.toList(pageRoll, componentDatas);
    }
   
    /*********************************************************************************************************************************************/

    public List<ComponentData> getComponentDatas() {
        return componentDatas;
    }

    public void setComponentDatas(List<ComponentData> componentDatas) {
        this.componentDatas = componentDatas;
    }

    public ComponentData getComponentData() {
        return componentData;
    }

    public void setComponentData(ComponentData componentData) {
        this.componentData = componentData;
    }

    public PageRoll getPageRoll() {
        return pageRoll;
    }

    public void setPageRoll(PageRoll pageRoll) {
        this.pageRoll = pageRoll;
    }

    public List<TemplateData> getTemplateDatas() {
        return templateDatas;
    }

    public void setTemplateDatas(List<TemplateData> templateDatas) {
        this.templateDatas = templateDatas;
    }

    public TemplateData getTemplateData() {
        return templateData;
    }

    public void setTemplateData(TemplateData templateData) {
        this.templateData = templateData;
    }

    public TemplateComponentData getTemplateComponentData() {
        return templateComponentData;
    }

    public void setTemplateComponentData(TemplateComponentData templateComponentData) {
        this.templateComponentData = templateComponentData;
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

}
