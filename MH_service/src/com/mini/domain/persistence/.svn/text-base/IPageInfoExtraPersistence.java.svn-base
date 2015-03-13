package com.mini.domain.persistence;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBasePersistence;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.data.PageInfoExtraData;

/**
 * 域名管理持久化层接口
 * 
 * @author 林海鹏
 * @see IPageInfoExtraPersistence
 * @since
 */

public interface IPageInfoExtraPersistence extends IBasePersistence<PageInfoExtraData> {
    /**
     * 新增Page信息
     */
    public void addPageInfoExtra(PageInfoExtraData pageInfoExtraData);

    /**
     * 删除Page信息
     */
    public void deletePageInfoExtra(String[] ids);

    /**
     * 编辑Page信息信息
     */
    public void editPageInfoExtra(PageInfoExtraData pageInfoExtraData);

    /**
     * 根据条件获取对象信息
     */
    public List<PageInfoExtraData> getPageInfoExtraData(JSONObject json);

    /**
     * 查询Page信息(分页显示)
     */
    public List<PageInfoExtraData> getAllPageInfoExtraInfo(PageRoll pageRoll, JSONObject json);

    /**
     * 
     * 根据条件查询Page域名信息对象<br>
     * 
     * @author 文东 <br>
     *         2014年3月23日
     * @update
     * @param pageInfoExtraData Page域名对象 存放条件查询的参数
     * @return PageInfoExtraData Page域名信息对象
     * @exception/throws
     * @see IPageInfoExtraPersistence#searchByPageInfoExtraData(PageInfoExtraData)
     * @since
     */
    public PageInfoExtraData searchByPageInfoExtraData(PageInfoExtraData pageInfoExtraData);
    
    /**
     * 连表获取page名称，page域名
     * @param json
     * @return
     */
    public Map<String,String> getPageInfoExtra(JSONObject json);
    
    /**
     * 
     * 根据用户id查询page域名信息
     * 
     * @author 左香勇
     *		   2014年11月28日
     * @update 
     * @param userId     登录用户id
     * @return  已发布的page域名信息
     * @see   IPageInfoExtraPersistence#getPageInfoExtraDatasByUserId(String)
     * @since vmaque 2.0
     */
    public List<PageInfoExtraData> getPageInfoExtraDatasByUserId(String userId);
}
