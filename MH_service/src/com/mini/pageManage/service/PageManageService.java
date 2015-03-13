package com.mini.pageManage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.util.FileUtil;
import com.mini.component.business.IComponentBusiness;
import com.mini.component.data.ComponentData;
import com.mini.componentClass.business.IComponentClassBusiness;
import com.mini.componentClass.data.ComponentClassData;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.page.data.PageData;
import com.mini.pageManage.business.IPageManageBusiness;
import com.mini.product.data.ProductData;
import com.mini.tempmanage.data.TemplateThumbnailData;

@Component("pageManageService")
public class PageManageService extends FrmService implements IPageManageService {

	@Resource(name = "pageManageBusiness")
	private IPageManageBusiness pageManageBusiness;
	@Resource(name="componentClassBusiness")
	private IComponentClassBusiness componentClassBusiness;
	@Resource(name="componentBusiness")
    private IComponentBusiness componentBusiness;
	/**
	 * 用户：查找改用的所有配置
	 * 
	 * @author 郭井超
	 * @param pageRoll
	 * @param pageData
	 * @return
	 */
	@Override
	public List<PageData> getAllPageData(PageRoll pageRoll, PageData pageData) {
		pageRoll = PageRoll.set(5, pageRoll);// 得到页面的翻页控件信息
		return pageManageBusiness.getAllPageData(pageRoll, pageData);
	}

	/**
	 * 用户：用户删除page
	 * 
	 * @author 郭井超
	 * @param pageData
	 */
	@Override
	public void deletePageDataById(PageData pageData) {
		pageManageBusiness.deletePageDataById(pageData);
	}

	
	/**
	 * 用户： 设置域名
	 * 
	 * @author 郭井超
	 * @param pageData
	 */
	@Override
	public void updatePageInfoExtraData(PageInfoExtraData pageInfoExtraData,PageData pageData) {
		pageManageBusiness.updatePageInfoExtraData(pageInfoExtraData, pageData);
	}

	
	/**
	 * 用户： 是否有 升级发布权限
	 * 
	 * @author 郭井超
	 * @param pageData
	 */
	@Override
	public int getPrivilegeData(String userId){
		return pageManageBusiness.getPrivilegeData(userId);
	}
	
	
	/**
	 * 用户： 执行升级操作
	 * @author 郭井超
	 * @param pageData
	 */
	@Override
	public PageData doPrivilegeData(PageData pagaData){
		return pageManageBusiness.doPrivilegeData(pagaData);
	}
	
	/**
	 * 用户： 发布page
     * @author 郭井超  
	 * @param pageData
	 */
	@Override
	public String updatePageData(PageData pagaData){
		return pageManageBusiness.updatePageData(pagaData);
	}
	
	/**
	 * 用户： 查找独立域名 ---判断是否存在
	 * @author   郭井超 
	 * @param pageData
	 * @return
	 */
	@Override
	public String getPageInfoExtraData(PageData pageData){
		return pageManageBusiness.getPageInfoExtraData(pageData);
	}
	@Override
	public String getPageInfoExtraDatas(PageData pageData){
		return pageManageBusiness.getPageInfoExtraDatas(pageData);
	}
	
	/**
	 * 
	 * 用户：if独立域名不存在 执行添加
	 * @author   郭井超 
	 * @param pageData
	 * @return
	 */
	@Override
	public void addPageInfoExtraData(PageInfoExtraData pageInfoExtraData){
		pageManageBusiness.addPageInfoExtraData(pageInfoExtraData);
	}
	
	/**
	 * 
	 * 用户： 查找用户有多少可用权限
	 * @author   郭井超 
	 * @param userId
	 * @return
	 */
	@Override
	public int getUserPrivateNumber(String userId){
		return  pageManageBusiness.getUserPrivateNumber(userId);
	}

	
	
	@Override
	public void addPageData(PageData pageData) {
		pageManageBusiness.addPageData(pageData);
	}

	@Override
	public void editPageData(PageData pageData) {
		pageManageBusiness.editPageData(pageData);
		
	}

	@Override
	public PageData findPageDataById(PageData pageData) {
		return pageManageBusiness.findPageDataById(pageData);
	}
	/**
	 * 获取禁用page个数
	 * @author hy
	 * @param userId
	 * @return
	 */
	 public  int getAllDisablePage(String userId){
		 return pageManageBusiness.getAllDisablePage(userId);
	 }
	 /**
      * 
      * 所有需要查看未付款服务的方法<br>
      * 
      * @author fengxin <br> 
      *         2014-4-28
      * @update 
      * @param String Pageid
      * @return  List<ProductData>
      */
     public List<ProductData> findNoPayProductData(String pageid){
         return pageManageBusiness.findNoPayProductData(pageid);
     }

    @Override
    public TemplateThumbnailData getTempPicByPageId(String pageId) {
      
        return pageManageBusiness.getTempPicByPageId(pageId);
    }
    /**
     * 
     *根据pageid查询page实体，二维码是否存在，不存在就生成<br>
     * 
     * @author 侯杨 <br> 
     *         2014-7-15
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public PageData getPageZing(PageData pageData){
        return pageManageBusiness.getPageZing(pageData);
        
    }
    /**
     * 
     *修改page<br>
     * 
     * @author 侯杨 <br> 
     *         2014-7-15
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void  updatePage(PageData data){
        pageManageBusiness.updatePage(data);
    }

    /**
     * 
     *在购买的时候  创建的css文件<br>
     * @author 侯杨 <br> 
     *         2014-9-23
     * @update 侯杨 2014-11-13
     * @param  data         page信息实体
     *         cssFilePath  css文件路径
     *         cssPath      html页面css引入文件路径
     * @see PageManageService#createGoodsCss
     * @since vmaque1.6
     */
     public String createGoodsCss(PageData data,String cssFilePath,String cssPath){
         String msg="0";
             //根据主键类型查询主键信息，购买主键
         ComponentData d=new ComponentData();
         d.setType("7");
         ComponentData componentData=componentBusiness.getComponentData(d);
         //根据主键信息  查询主键样式内容
         List<ComponentClassData> list=componentClassBusiness.getAllCompId(componentData);
         String ipClassCon=""; //平板样式
         String pcclassCon="";  //电脑样式
         String phoneClassCon=""; //手机样式
         if(list!=null  && list.size()>0){
             pcclassCon=list.get(0).getPcclassCon();  
             phoneClassCon=list.get(0).getPhoneClassCon();
             ipClassCon=list.get(0).getIpadClassCon();
         }
         //添加CSS3  平板自适应   
         ipClassCon="@media ( max-width : 768px) {"+ipClassCon+"}";
         //添加CSS3  手机自适应   
         phoneClassCon="@media ( max-width : 480px) {"+phoneClassCon+"}";
         //购买主键的所以样式
         String  conClass=pcclassCon+ipClassCon+phoneClassCon;
        
         try {
             //创建购买样式
             FileUtil.createFile(cssFilePath, conClass);
             msg="1";
        } catch (Exception e) {
            msg="0";
            pageManageBusiness.createGoodsCss(data, cssFilePath, cssPath);
        }
         return msg;
     }
     /**
      * 
      *page 另存<br>
      * 
      * @author 侯杨 <br> 
      *        2014-10-20
      * @update 
      * @param data   page实体
      * @return  pagedata page实体
      * @see   PageManageService#copyPage(PageData)
      * @since vmaque1.7
      */
    @Override
    public PageData copyPage(PageData data) {
        return pageManageBusiness.copyPage(data);
    }
   
}
