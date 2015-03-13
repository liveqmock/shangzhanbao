package com.mini.componentClass.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.common.util.FileUpload;
import com.common.util.ResouceUtil;
import com.common.util.UploadPath;
import com.itour.etip.pub.frame.FrmAction;
import com.mini.back.compManage.facade.CompManageFacade;
import com.mini.component.data.ComponentData;
import com.mini.componentClass.data.ComponentClassData;
import com.mini.componentClass.facade.ComponentClassFacade;
/**
 * 
 * 主键样式<br> 
 * 〈功能详细描述〉
 *
 * @author 侯杨
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
    @Results(value = { 
            @Result(name = "addComClass", location = "/view/pages/mini/back/compmanage/addClassComp.jsp"),
            @Result(name = "comList", type = "redirect", location = "comp_manage/key/searchComponent"),
            @Result(name = "toeditComClass", location = "/view/pages/mini/back/compmanage/editClassComp.jsp"),
            @Result(name = "selectComClassBuComId", location = "/view/pages/mini/back/newAddTemp/addTemp_left_class.jsp"),
            @Result(name = "error", location = "/view/pages/mini/back/compmanage/error.jsp")
    
    })
public class ComponentClassAction extends FrmAction{
        // 组件管理Facade接口 容器注入
        @Resource
        private CompManageFacade compManageFacade;
        @Resource(name="componentClassFacade")
        // 组件样式管理Facade接口 容器注入
        private ComponentClassFacade componentClassFacade;
        
        //组件样式实体
        ComponentClassData componentClassData=new ComponentClassData();
        // 组件对象
        private ComponentData componentData = new ComponentData();
        private List<ComponentClassData> list_comClass = new ArrayList<ComponentClassData>();
        // PC样式览图
        private File filePC;
        private String filePCFileName;
        /**
         * 
         *去添加页面<br>
         * 
         * @author 侯杨 <br> 
         *         2014-8-20
         * @since [起始版本]
         */
        public  String toAddComClass(){
            componentData=compManageFacade.getComponentByid(componentData.getId());
            return "addComClass";
        }
        /**
         * 
         *添加<br>
         * 
         * @author 侯杨 <br> 
         *         2014-8-20
         * @since [起始版本]
         */
        public String addupdateComponentClassData(){
            String imgPath="";
            if(filePC!=null){
                 imgPath = FileUpload.createFile(UploadPath.IMG_CLASS, getFrmUser().etipUserID, filePCFileName, filePC);
            }
            componentClassData.setImgPath(imgPath);
            json=componentClassFacade.componentClassDataAddUpdate(componentClassData);
              if(json=="1"){
                  return "comList";
              }else{
                  return "error";
              }
         
        }
        /**
         * 
         *删除<br>
         * 
         * @author 侯杨 <br> 
         *         2014-8-20
         * @since [起始版本]
         */
        public void  deleteComClass(){
            json=componentClassFacade.deleteCom(componentClassData);
        }
        /**
         * 
         *去修改页面<br>
         * 
         * @author 侯杨 <br> 
         *		   2014-8-20
         * @since [起始版本]
         */
        public String toeditComClass(){
            componentClassData=componentClassFacade.getComponentClassDataById(componentClassData);
            componentData=compManageFacade.getComponentByid(componentClassData.getComponentid());
            return "toeditComClass";
        }
        /**
         * 
         * 根据组件id查看组件的所有样式<br>
         * 
         * @author 冯鑫 <br> 
         *		   2014-8-22
         * @update 
         */
        public void findComClassBuComId(){
            list_comClass = componentClassFacade.getAllCompId(componentData);
            if(list_comClass.size()>0){
                list_comClass.get(0).setImgPath(ResouceUtil.getProperty("uploadpath.properties", "img_class")+list_comClass.get(0).getImgPath());
                componentClassData = list_comClass.get(0);
            }
            json = JSONObject.fromObject(componentClassData);
        }
        /**
         * 
         * 选择组件跳转到组件样式选择页面<br>
         * 
         * @author 冯鑫 <br> 
         *		   2014-8-25
         * @update 
         */
        public String selectComClassBuComId(){
            list_comClass = componentClassFacade.getAllCompId(componentData);
            if(list_comClass.size()>0){
                for (int i = 0; i < list_comClass.size(); i++) {
                    list_comClass.get(0).setImgPath(ResouceUtil.getProperty("uploadpath.properties", "img_class")+list_comClass.get(0).getImgPath());
                }
            }
            return "selectComClassBuComId";
        }
        /************************************************************************************/
        public ComponentClassData getComponentClassData() {
            return componentClassData;
        }

        public void setComponentClassData(ComponentClassData componentClassData) {
            this.componentClassData = componentClassData;
        }

        public ComponentData getComponentData() {
            return componentData;
        }

        public void setComponentData(ComponentData componentData) {
            this.componentData = componentData;
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
        public List<ComponentClassData> getList_comClass() {
            return list_comClass;
        }
        public void setList_comClass(List<ComponentClassData> list_comClass) {
            this.list_comClass = list_comClass;
        }
        
        /************************************************************************************/
        

}
