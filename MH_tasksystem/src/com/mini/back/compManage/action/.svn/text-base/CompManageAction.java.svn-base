package com.mini.back.compManage.action;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialException;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.mini.back.compManage.facade.CompManageFacade;
import com.mini.component.data.ComponentData;
import com.mini.componentClass.data.ComponentClassData;
import com.mini.componentClass.facade.ComponentClassFacade;
import com.mini.util.OutImgBlob;

/**
 * 组件管理action
 * 
 * @author 文东
 * @see CompManageAction
 * @since
 */
@Results(value = { @Result(name = "list", location = "view/pages/mini/back/compmanage/compList.jsp"),
        @Result(name = "add", location = "view/pages/mini/back/compmanage/addComp.jsp"),
        @Result(name = "editCom",  location = "/view/pages/mini/back/compmanage/editComp.jsp")
        
})
public class CompManageAction extends FrmAction {

    // 组件管理Facade接口 容器注入
    @Resource
    private CompManageFacade compManageFacade;
    @Resource(name="componentClassFacade")
    // 组件样式管理Facade接口 容器注入
    private ComponentClassFacade componentClassFacade;

    // 组件对象
    private ComponentData componentData = new ComponentData();

    // 组件对象集合
    private List<ComponentData> componentDatas = new ArrayList<ComponentData>();
    
    //组件样式集合
    private List<ComponentClassData> componentClassDatas=new ArrayList<ComponentClassData>();
    
    //组件样式实体
    ComponentClassData componentClassData=new ComponentClassData();

    // 分页
    private PageRoll pageRoll = new PageRoll();
    //组件样式帮组字段
    private String classHelp;  

    // 获取数据字典中组件类型

    @SuppressWarnings("unchecked")
	private TreeMap<Integer, String> compType = CacheUtil.getInstance().getCacheMap("compType");

    // 获取数据字典中组件是否可用重用

    @SuppressWarnings("unchecked")
	private TreeMap<Integer, String> compResue = CacheUtil.getInstance().getCacheMap("compResue");
    // 修改page的html类型

    @SuppressWarnings("unchecked")
	private TreeMap<Integer, String> editcode = CacheUtil.getInstance().getCacheMap("editcode");
    // 添加组件时  模板风格

    @SuppressWarnings("unchecked")
	private TreeMap<Integer, String> csstype = CacheUtil.getInstance().getCacheMap("csstype");

    // PC览图
    private File filePC;
    private String filePCFileName;

    /******************************************************************************************************************************************/

    /**
     * 
     * 查询所有组件<br>
     * 
     * @author 文东 <br>
     *         2014-3-11
     * @update
     * @param
     * @return list 返回组件显示页面
     * @exception/throws
     * @see CompManageAction#searchComp()
     * @since
     */
    public String searchComponent() {
        // 查询到所有可用组件
        componentDatas = compManageFacade.searchComponent(pageRoll, componentData);
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
        request.getSession().setAttribute("csstype", csstype);
        return "list";
    }

    /**
     * 
     * 跳转到添加页面<br>
     * 
     * @author 文东 <br>
     *         2014-3-11
     * @update
     * @param
     * @return add 返回添加组件页面
     * @exception/throws
     * @see CompManageAction#add()
     * @since
     */
    public String add() {
        request.getSession().setAttribute("compType", compType);
        request.getSession().setAttribute("compResue", compResue);
        request.getSession().setAttribute("editcode", editcode);
        request.getSession().setAttribute("csstype", csstype);
        return "add";
    }

    /**
     * 
     * 添加组件<br>
     * 
     * @author 文东 <br>
     *         2014-3-11
     * @update
     * @param
     * @return void 无返回
     * @throws SQLException
     * @throws SerialException
     * @exception/throws
     * @see CompManageAction#addComp()
     * @since
     */
    public void addComp() throws SerialException, SQLException {
        // 将html内容转换成clob类型存储到对象中
        if (componentData.getClob() != null) {
            //componentData.setCode(Hibernate.createClob(componentData.getClob()));
            componentData.setCode(componentData.getClob());
        }
        // 获取当前登录用户的名称
        String name = getFrmUser().etipNowLoginName;
        componentData.setCreator(name);
        StringBuffer buffer=new StringBuffer();  //从新组合的修改pagehtml
        String code=null;
           if(componentData.getEditcode()!=null && !"".equals(componentData.getEditcode())){
	        String editCode []=componentData.getEditcode().split(",");  //分割
	        String editCou []=componentData.getEditcon().split(",");
	        
	        for (int i = 0; i < editCou.length; i++) {  
	        	
				buffer.append(editCode[i].trim()+":"+editCou[i].trim()+",");
			}
	        code=buffer.toString().substring(0,buffer.toString().lastIndexOf(",")); //把最后逗号截取掉
           }
        componentData.setEditcode(code);  //重新赋值
        componentData.setModifyTime(new Date()); //修改时间
        // 向数据库中添加模板 以及模板缩略图
        
        
        componentData.setIsNewOrOld(1);
        componentData.setCssType("4");
        componentData.setUploadbgimg(1);
        json=compManageFacade.add(componentData);
    }

    
    /**
     * 组件删除
     * @author 侯杨
     * date 2014-5-20
     * @param componentData
     * @return
     */
    public void deleteComponents(){
        componentClassData.setComponentid(componentData.getId());
        componentClassFacade.deleteCom(componentClassData);
    	json=compManageFacade.deleteComponent(componentData);
    }
    /**
     * 根据id 查询组件 信息
     * @author 侯杨
     * date 2014-5-20
     * @param componentData
     * @return
     */
    public String getComponentByid() {
    	   request.getSession().setAttribute("compType", compType);
           request.getSession().setAttribute("compResue", compResue);
           request.getSession().setAttribute("editcode", editcode);
           request.getSession().setAttribute("csstype", csstype);
           componentClassDatas=componentClassFacade.getAllCompId(componentData);
    	   componentData=compManageFacade.getComponentByid(componentData.getId());
    	   componentData.setClassDatas(componentClassDatas);
    	   return "editCom";
    }
    /**
     * 根据id  修改组件
     * @author 侯杨
     * @date 2014-5-20
     * @param data
     * @param filePC
     * @return
     */
	public void editComponent() {
		  // 将html内容转换成clob类型存储到对象中
        if (componentData.getClob() != null) {
            componentData.setCode(componentData.getClob());
        }
        // 获取当前登录用户的名称
        String name = getFrmUser().etipNowLoginName;
        componentData.setModifyName(name);  //修改人
      // 向数据库中添加模板 以及模板缩略图
        json= compManageFacade.editComponent(componentData);
	}
	
	public void ajaxFindComponentClassData(){
	    componentData=compManageFacade.getComponentByid(componentData.getId());
	    componentClassData.setComponentData(componentData);
	    json=componentClassFacade.ajaxFindComponentClassData(componentClassData);
	}
	
	public void deleteComponentClassData(){
	    json=componentClassFacade.componentClassDatadelete(componentClassData);
	}
    /******************************************************************************************************************************************/

    public ComponentData getComponentData() {
        return componentData;
    }

    public void setComponentData(ComponentData componentData) {
        this.componentData = componentData;
    }

    public List<ComponentData> getComponentDatas() {
        return componentDatas;
    }

    public void setComponentDatas(List<ComponentData> componentDatas) {
        this.componentDatas = componentDatas;
    }

    public PageRoll getPageRoll() {
        return pageRoll;
    }

    public void setPageRoll(PageRoll pageRoll) {
        this.pageRoll = pageRoll;
    }

    public TreeMap<Integer, String> getCompType() {
        return compType;
    }

    public void setCompType(TreeMap<Integer, String> compType) {
        this.compType = compType;
    }

    public TreeMap<Integer, String> getCompResue() {
        return compResue;
    }

    public void setCompResue(TreeMap<Integer, String> compResue) {
        this.compResue = compResue;
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

	public TreeMap<Integer, String> getEditcode() {
		return editcode;
	}

	public void setEditcode(TreeMap<Integer, String> editcode) {
		this.editcode = editcode;
	}

	public TreeMap<Integer, String> getCsstype() {
		return csstype;
	}

	public void setCsstype(TreeMap<Integer, String> csstype) {
		this.csstype = csstype;
	}

    public ComponentClassData getComponentClassData() {
        return componentClassData;
    }

    public void setComponentClassData(ComponentClassData componentClassData) {
        this.componentClassData = componentClassData;
    }

    public String getClassHelp() {
        return classHelp;
    }

    public void setClassHelp(String classHelp) {
        this.classHelp = classHelp;
    }
    
}
