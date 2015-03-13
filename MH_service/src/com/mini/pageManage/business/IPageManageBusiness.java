package com.mini.pageManage.business;

import java.util.List;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.page.data.AccesstatisticsData;
import com.mini.page.data.PageData;
import com.mini.product.data.ProductData;
import com.mini.tempmanage.data.TemplateThumbnailData;

public interface IPageManageBusiness extends IBusiness {

    /**
     * 用户：查找改用的所有配置
     * 
     * @author 郭井超
     * @param pageRoll
     * @param pageData
     * @return
     */
    public List<PageData> getAllPageData(PageRoll pageRoll, PageData pageData);

    /**
     * 用户：用户删除page
     * 
     * @author 郭井超
     * @param pageData
     */
    public void deletePageDataById(PageData pageData);

    /**
     * 用户： 设置域名
     * 
     * @author 郭井超
     * @param pageData
     */
    public void updatePageInfoExtraData(PageInfoExtraData pageInfoExtraData, PageData pageData);

    /**
     * 用户： 是否有 升级发布权限
     * 
     * @author 郭井超
     * @param pageData
     */

    public int getPrivilegeData(String userId);

    /**
     * 用户： 执行升级
     * 
     * @author 郭井超
     * @param pageData
     */

    public PageData doPrivilegeData(PageData pagaData);

    /**
     * 用户： 发布服务
     * 
     * @author 郭井超
     * @param pageData
     */
    public String updatePageData(PageData pagaData);

    /**
     * 用户： 查找独立域名 ---判断是否存在
     * 
     * @author 郭井超
     * @param pageData
     * @return
     */
    public String getPageInfoExtraData(PageData pageData);

    public String getPageInfoExtraDatas(PageData pageData);

    /**
     * 用户： 该配置的访问数、访问量、平均访问停留时间、动态转换率
     * 
     * @author 郭井超
     * @param pageId
     * @return
     */
    public AccesstatisticsData getAccesstatisticsDataByPageId(String pageId);

    /**
     * 
     * 用户：if独立域名不存在 执行添加
     * 
     * @author 郭井超
     * @param pageInfoExtraData
     * @return
     */
    public void addPageInfoExtraData(PageInfoExtraData pageInfoExtraData);

    /**
     * 
     * 用户： 查找用户有多少可用权限
     * 
     * @author 郭井超
     * @param userId
     * @return
     */
    public int getUserPrivateNumber(String userId);

    /**
     * 
     * 用户： 查找用户有多少可用权限
     * 
     * @author 郭井超
     * @param userId
     * @return
     */

    /**
     * 代理
     * 
     * @param pageDate
     */
    public void addPageData(PageData pageData);

    /**
     * 代理
     * 
     * @param pageDate
     */
    public void editPageData(PageData pageData);

    /**
     * 代理
     * 
     * @param pageDate
     * @param pageRoll
     * @return
     */
    public PageData findPageDataById(PageData pageData);

    /**
     * 获取禁用page个数
     * 
     * @author hy
     * @param userId
     * @return
     */
    public int getAllDisablePage(String userId);

    /**
     * 
     * 所有需要查看未付款服务的方法<br>
     * 
     * @author fengxin <br>
     *         2014-4-28
     * @update
     * @param String Pageid
     * @return List<ProductData>
     */
    public List<ProductData> findNoPayProductData(String pageid);

    /**
     * 得到page的二级域名信息
     * 
     * @param pageid
     * @return
     */
    public String getDomainByPage(String pageid);

    /**
     * 
     * 根据微站的id查看微站所使用的模板的主缩略图<br>
     * 
     * @author 文东 <br>
     *         2014年6月25日
     * @update
     * @param pageId 微站的id
     * @return 微站所使用的模板的主缩略图
     * @exception/throws
     * @see IPageManageBusiness#getTempPicByPageId(String)
     * @since
     */
    public TemplateThumbnailData getTempPicByPageId(String pageId);
    /**
     * 
     *根据pageid查询page实体，二维码是否存在，不存在就生成<br>
     * 
     * @author 侯杨 <br> 
     *		   2014-7-15
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public PageData getPageZing(PageData pageData);
    /**
     * 
     *修改page<br>
     * 
     * @author 侯杨 <br> 
     *		   2014-7-15
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void  updatePage(PageData data);
    /**
     * 
     *在购买的时候  创建的css文件<br>
     * @author 侯杨 <br> 
     *         2014-9-23
     * @update 
     * @param  data         page信息实体
     *         cssFilePath  css文件路径
     *         cssPath      html页面css引入文件路径
     * @see IPageManageBusiness#createGoodsCss
     * @since vmaque1.6
     */
     public void createGoodsCss(PageData data,String cssFilePath,String cssPath);
    
     /**
      * 
      *page 另存<br>
      * 
      * @author 侯杨 <br> 
      *        2014-10-20
      * @update 
      * @param data   page实体
      * @return   pagedata page实体
      * @see   IPageManageBusiness#copyPage(PageData)
      * @since vmaque1.7
      */
     public PageData copyPage(PageData data);
}
