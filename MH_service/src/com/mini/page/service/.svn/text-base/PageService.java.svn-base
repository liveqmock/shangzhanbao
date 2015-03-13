package com.mini.page.service;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.common.util.Page;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.business.IPageInfoExtraBusiness;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.order.business.IOrderBusiness;
import com.mini.order.data.OrderProductData;
import com.mini.page.business.IPageBusiness;
import com.mini.page.data.PageData;
import com.mini.page.data.PageHelpData;
import com.sys.user.business.IUserBusiness;
import com.sys.user.data.UserData;

/**
 * 后台page管理服务接口实现类
 * 
 * @author 林海鹏
 * @see PageService
 * @since
 */
@SuppressWarnings("static-access")
@Component("pageService")
public class PageService extends FrmService implements IPageService {
    @Resource(name = "pageBusiness")
    private IPageBusiness pageBusiness;

    @Resource(name = "orderBusiness")
    private IOrderBusiness orderBusiness; // 订单
    @Resource(name="userBusiness")
    private IUserBusiness userBusiness;
    @Resource(name="pageInfoExtraBusiness")
    private IPageInfoExtraBusiness pageInfoExtraBusiness;


    public void setPageBusiness(IPageBusiness pageBusiness) {
        this.pageBusiness = pageBusiness;
    }

    /**
     * 新增Page
     */
    @Override
    public void addPage(PageData pageData) {
        pageBusiness.addPage(pageData);
    }

    /**
     * 删除Page
     */
    @Override
    public void deletePage(String[] ids) {
        pageBusiness.deletePage(ids);
    }

    /**
     * 编辑Page
     */
    @Override
    public void editPage(PageData orderData) {
        pageBusiness.editPage(orderData);
    }

    /**
     * 查询Page(分页显示)//连表分页查询 返回数组
     */
    @Override
    public List<Object[]> getAllPageInfo(PageRoll pageRoll, JSONObject json) {
        return pageBusiness.getAllPageInfo(pageRoll, json);
    }

    /**
     * 根据条件获取对象
     */
    @Override
    public List<PageData> getPageData(JSONObject json) {
        return pageBusiness.getPageData(json);
    }

    /**
     * //单对象分页查询 返回集合
     */
    @Override
    public List<PageData> getForpageRoll(PageRoll pageRoll, JSONObject json) {
        pageRoll = PageRoll.set(Page.SIZE_10, pageRoll);
        return pageBusiness.getForpageRoll(pageRoll, json);
    }

    /**
     * //连表分页查询 返回集合
     */
    @Override
    public List<PageData> getAllPages(PageRoll pageRoll, JSONObject json) {
        return pageBusiness.getAllPages(pageRoll, json);
    }

    /**
     * 后台查询 page管理 分页
     * 
     * @author 侯杨
     * @date 2014-2-19
     * @param pageRoll
     * @param helpData
     * @return
     */
    @Override
    public List<PageData> getAllPage(PageRoll pageRoll, PageHelpData helpData,Integer sort) {
        pageRoll = PageRoll.set(Page.SIZE_10, pageRoll);
        return pageBusiness.getAllPage(pageRoll, helpData,sort);
    }

    /**
     * 禁用 page 后台
     * 
     * @author 侯杨
     * @date 2014-2-19
     * @param pageId page 的id
     * @param pageData 实体
     */
    public void disabledPage(String id, PageData date) {
        pageBusiness.disabledPage(id, date);
    }

    /*
     * 启用 page 后台
     * @author 侯杨
     * @date 2014-2-20
     */
    public void startPage( PageData pageData) {
        pageBusiness.startPageState(pageData);
    }

    /**
     * 后台 page管理 查询详情
     * 
     * @param pageId
     * @return
     */
    public PageData getPageId(String pageId) {
        PageData data = pageBusiness.getPageId(pageId);
        OrderProductData orderProductData = new OrderProductData(); // 订单服务中间表
        String mes = "0"; // page用于在线客服 是否付款标识
        // 遍历查询出来的 服务，得到属于在线客服 这款服务的id
        if (data.getPageProductDatas() != null) {
            for (int i = 0; i < data.getPageProductDatas().size(); i++) {
                if (data.getPageProductDatas().get(i).getProductName().equals("在线咨询")) {
                    orderProductData.setPageId(pageId); // pageId
                    orderProductData.setProductId(data.getPageProductDatas().get(i).getProductId()); // 服务id
                    mes = orderBusiness.getOrderState(orderProductData); // 调用订单 查询的方法,返回2 正常 已付款且开通
                    data.setYmId(data.getPageProductDatas().get(i).getId()); // page服务中间表id
                    /**
                     * 修改人：文东<br>
                     * 修改时间：2014/05／20<br>
                     * 修改内容：由于data.getPageProductDatas().get(i).getStatus()存在空的情况，加了一个空判断
                     */
                    if (data.getPageProductDatas().get(i).getStatus() != null) {
                        data.setPageStatusCredible(data.getPageProductDatas().get(i).getStatus().toString());// page服务中间表状态
                    }
                    break; // 退出循环
                } else {
                    mes = "0";
                }
            }
        }
        data.setHasOrder(mes);
        return data;
    }

    /**
     * 后台查询 page管理 分页
     * 
     * @author 侯杨
     * @date 2014-2-19
     * @param pageRoll 分页
     * @param helpData page实体类
     * @return
     */
    public List<PageData> getAllPageList(PageRoll pageRoll, PageHelpData helpData) {
        pageRoll = pageRoll.set(Page.SIZE_10, pageRoll);
        return pageBusiness.getAllPageList(pageRoll, helpData);
    }

    /**
     * 
     * 根据pageid查询未付款的业务
     * 
     * @author 冯鑫 <br>
     *         2014-4-9
     * @update
     * @param JSONObject obj
     * @return List<ProductData>
     */
    public List<String> findNoPayProductDataByPage(String[] str) {
        return pageBusiness.findNoPayProductDataByPage(str);
    }

    /**
     * 
     * 根据pageid关联order表查询未付款业务
     * 
     * @author 冯鑫 <br>
     *         2014-4-9
     * @update
     * @param JSONObject obj
     * @return List<ProductData>
     */
    public List<String> findNoPayProductDataByOrderAndPage(String[] str) {
        return pageBusiness.findNoPayProductDataByOrderAndPage(str);
    }

    /**
     * 
     * 更具page主键和服务主键 查询 此page购买的此款服务时够已经付款<br>
     * 
     * @author Administrator <br>
     *         2014-4-24
     * @update
     * @param String pageId page主键 String productId 服务主键
     * @return boolean 未付款 返回true 已经出款 返回false
     */
    public boolean findNoPayStateByPageIDAndProudctID(String pageId, String productId) {
        return pageBusiness.findNoPayStateByPageIDAndProudctID(pageId, productId);
    }
    /**
     * 
     * 管理员赠送page给用户<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-5-21
     * @update 
     * @param UserData userData,PageData pageData
     * @return  void
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void powerPageByUserID(UserData userData,PageData pageData){
        userData = userBusiness.checkUser(userData);
        pageData = pageBusiness.getPageId(pageData.getId());
        pageData.setUserId(userData.getId());
        pageBusiness.editPage(pageData);
        //List<PageInfoExtraData> list = pageInfoExtraBusiness.getPageInfoExtraData(JSONObject.fromObject("{\"pageid\":\"" + pageData.getId() + "\"}"));
        
    }
    /**
     * 删除多条page数据  假删
     * @author 侯杨
     *@date 2014-5-20
     * @param id
     * @return
     */
    public String deletePageData(String id[]){
    	//如果数组不为空，执行删除方法
    	String mes=null;
    	if(id!=null){
    		for (int i = 0; i < id.length; i++) {
				mes=pageBusiness.deletePageData(id[i]);
			}
    	}
    	return mes;
    }
    /**
     * 
     *查询page实体,用于初始化加载page页面  替换title  和查询pageid<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月22日
     * @update 
     * @param data  域名实体
     * @return  pagedata  page实体
     * @see   IPageService#getPageDataByPageHtml(data)
     * @since vmaque 2.0
     */
    public PageData getPageDataByPageHtml(PageInfoExtraData data){
        PageData pageData=null;
        if(data.getDomain()!=null && !"".equals(data.getDomain())){
            //查询出域名集合
            List<PageInfoExtraData> list=pageInfoExtraBusiness.getPageInfoExtraDatasByName(data);
            if(list.size()>0){
                for (int i = 0; i < list.size(); i++) {
                    PageInfoExtraData pageInfoExtraData=new PageInfoExtraData();
                    pageInfoExtraData=list.get(i);
                    if(pageInfoExtraData.getPageId()!=null && !"".equals(pageInfoExtraData.getPageId())){
                        //返回page isdelete  为1的数据
                        if(pageBusiness.getPageDateById(pageInfoExtraData.getPageId()).getIsDelete()==1){
                            pageData=pageBusiness.getPageDateById(pageInfoExtraData.getPageId());
                        }
                    }
                }
            }
            return pageData;
        }else{
            return null;
        }
    }
}
