package com.mini.tempmanage.business;

import java.io.File;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import com.common.util.RandomString;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.page.data.PageData;
import com.mini.page.data.PageHelpData;
import com.mini.page.data.PageTemplateData;
import com.mini.page.persistence.IPageTemplatePersistence;
import com.mini.page.persistence.PagePersistence;
import com.mini.tempmanage.data.TemplateComponentData;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateHelpData;
import com.mini.tempmanage.data.TemplateThumbnailData;
import com.mini.tempmanage.persistence.ITempManagePersistence;
import com.mini.tempmanage.persistence.ITemplateComponentPersistence;
import com.mini.tempmanage.persistence.ITemplateThumbnailPersistence;
import com.sys.user.data.UserData;

/**
 * 模板管理业务接口实现类
 * 
 * @author 文东
 * @see TempManageBusiness
 * @since
 */
@Component("tempManageBusiness")
public class TempManageBusiness extends FrmBusiness implements ITempManageBusiness {

    // 模板与组件关系持久化层接口 容器注入
    @Resource(name = "templateComponentPersistence")
    private ITemplateComponentPersistence templateComponentPersistence;

    // 模板管理持久化层接口 容器注入
    @Resource(name = "tempManagePersistence")
    private ITempManagePersistence tempManagePersistence;

    // 模板缩略图持久化层接口 容器注入
    @Resource(name = "templateThumbnailPersistence")
    private ITemplateThumbnailPersistence templateThumbnailPersistence;
    // page使用模板持久化层接口 容器注入
    @Resource(name = "pageTemplatePersistence")
    private IPageTemplatePersistence pageTemplatePersistence;
    // page个人持久化层接口 容器注入
    @Resource(name = "pagePersistence")
    private PagePersistence pagePersistence;

    @Override
    public List<TemplateData> searchAllTempByUser(PageRoll pageRoll, TemplateData templateData, String userId) {
        // 查询用户所拥有的模板
        List<TemplateData> templateDatas = tempManagePersistence.searchAllTempByUser(pageRoll, templateData, userId);
        return templateDatas;
    }

    @Override
    public List<TemplateData> searchRecommend(String userId) {
        // 查询推荐模板
        List<TemplateData> recommendTemplates = tempManagePersistence.searchRecommend(userId);
        return recommendTemplates;
    }

    @Override
    public List<TemplateData> searchAllTemp(PageRoll pageRoll, TemplateData templateData) {
        // 查询所有的模板
        List<TemplateData> templateDatas = tempManagePersistence.searchAllTemp(pageRoll, templateData);
        return templateDatas;
    }

    @Override
    public void addTemp(TemplateData templateData, File fileMain, File filePad, File filePC, File filePhone) {
        // 模板缩略图
        TemplateThumbnailData thumbnailData = new TemplateThumbnailData();
        boolean b = false;
        // 模板编码
        String tempSn;
        do {
            // 获取模板编码
            tempSn = RandomString.randomString(6);
            // 查看生成的模板编码是否可用 若为true 表示可用 false表示不可用
            List<TemplateData> datas = tempManagePersistence.searchSn(tempSn);
            if (datas.size() > 0) {
                b = true;
            }
        } while (b);
        Clob clob = Hibernate.createClob(templateData.getStringContent());
        templateData.setContent(clob);
        templateData.setUploadingTime(new Date());
        templateData.setStatus("OPEN");
        templateData.setSn(tempSn);
        templateData.setCreateTime(new Date());
        templateData.setIsDelete(1);
        templateData.setPrice("0");
        templateData.setOpenTime(new Date());
        tempManagePersistence.add(templateData);
        if (templateData.getId() != null && templateData.getTemplateComponentDatas().size() > 0) {
            for (int i = 0; i < templateData.getTemplateComponentDatas().size(); i++) {
                TemplateComponentData templateComponentData = new TemplateComponentData();
                templateComponentData = templateData.getTemplateComponentDatas().get(i);
                templateComponentData.setTemplateid(templateData.getId());
                templateComponentPersistence.add(templateComponentData);
            }
        }
        // 获取刚才添加的模板
        List<TemplateData> datas = tempManagePersistence.searchSn(tempSn);
        // 将添加的模板的id赋值给缩略图对象的模板id
        thumbnailData.setTemplateId(datas.get(0).getId());
        // 将文件流放入集合
        Map<String, File> map = new HashMap<String, File>();
        map.put("main", fileMain);
        map.put("phone", filePhone);
        map.put("pc", filePC);
        map.put("pad", filePad);
        templateThumbnailPersistence.addThumbnail(thumbnailData, map);
    }

    /**
     * 更具模板id查询模板信息 后台模板管理
     * 
     * @author hy
     * @date 2014-2-22
     * @param templateId 模板id
     * @return
     */
    public TemplateData getTemplateData(String templateId) {
        TemplateData templateData = null; // 模板变
        List<PageTemplateData> pageTemplateDatas = null; // page使用模板对象
        List<TemplateThumbnailData> thumbnailDatas = null; // 模板略缩图集合
        /* 如果模板id 不为空，就查询数据 */
        if (templateId != null && !"".equals(templateId)) {
            templateData = tempManagePersistence.retrieve(templateId);
        } else {
            templateData = new TemplateData(); // 如果是个空，new 一个新对象
        }
        /* 如果模板id 不为空，就查询page使用模板信息 */
        if (templateId != null && !"".equals(templateId)) {
            String hql = "from PageTemplateData pt where pt.templateId = ?"; // 根据模板主键查询
            pageTemplateDatas = pageTemplatePersistence.search(hql, new Object[] { templateId });
        }
        /* 根据模板id 查询 模板缩略图实体对象 */
        /* 如果模板id 不为空，就查询模板缩略图使用模板信息 */
        if (templateId != null && !"".equals(templateId)) {
            String t_hql = "from TemplateThumbnailData td where td.templateId = ?";
            thumbnailDatas = templateThumbnailPersistence.search(t_hql, new Object[] { templateId });

        }
        templateData.setPageTemplateDatas(pageTemplateDatas); // 把page使用模板添加到模板实体中
        templateData.setThumbnailDatas(thumbnailDatas); // 吧模板略缩图集合添加到模板中
        return templateData;
    }

    /**
     * page页面统计
     * 
     * @param templateId 模板id
     * @param state page状态
     * @return
     */
    @Override
    public int statisticsTempPage(String templateId, String state) {
        int count = 0;
        String sql=null;
          if(state.equals("0")){
        	  //所以的page数
        	   sql = "select count(*) sums  from mini_page_template p,mini_page page  where p.page_id=page.id and p.template_id= ? ";
          }else if(state.equals("1")){
        	   sql = "select count(*) sums  from mini_page_template p,mini_page page  where p.page_id=page.id and p.template_id= ? and page.isdelete= 1 and page.status = '1'";
          }
      
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询
        List<ETIPResultSet> resultSet = dao.queryForList(sql.toString(),new Object[]{templateId} );
        if (resultSet != null && resultSet.size() > 0) {
            for (int i = 0; i < resultSet.size(); i++) {
                ETIPResultSet rs = resultSet.get(i);
                count = rs.getInt("SUMS");
            }
        }
        return count;

    }

    /**
     * 后台 模板管理 启用 停用操作
     * 
     * @author hy
     * @date 2014-2-22
     * @param tempId
     * @param state
     */
    public void updateTempState(String tempId, String state) {
        TemplateData data = null;
        if (tempId != null && !"".equals(tempId)) {
            data = tempManagePersistence.retrieve(tempId);
        }
        data.setStatus(state); // 修改模板状态
        tempManagePersistence.update(data);
    }

    /**
     * 后台模板管理 删除模板 假删
     * 
     * @author hy
     * @date 2014-2-23
     * @param tempId
     */
    @Override
    public void delete(String tempId) {
        TemplateData templateData = null;
        if (tempId != null && !"".equals(tempId)) {
            templateData = tempManagePersistence.retrieve(tempId);
        }
        templateData.setIsDelete(0); // 修改模板 删除的状态 是否假删
        tempManagePersistence.update(templateData);
    }

    @Override
    public List<TemplateData> searchByLike(PageRoll pageRoll, TemplateData templateData) {
        // 根据模板受喜欢的程度排序查询模板
        List<TemplateData> templateDatas = tempManagePersistence.searchByLike(pageRoll, templateData);
        return templateDatas;
    }

    /**
     * 后台模板管理 修改模板
     * 
     * @author hy
     * @date 2014-2-23
     * @param tempId
     * @param templateData
     */
    @Override
    public void updateTemp(String tempId, TemplateData templateData) {
        TemplateData data = null;
        if (tempId != null && !"".equals(tempId)) {
            data = tempManagePersistence.retrieve(tempId);
        }
        data.setName(templateData.getName());
        data.setMemo(templateData.getMemo());
        data.setPrice(templateData.getPrice());
        if (templateData.getImgpath() != null && !"".equals(templateData.getImgpath())) {
            data.setImgpath(templateData.getImgpath());
        }
        tempManagePersistence.update(data);
    }

    /**
     * 
     * p排序查询所有的模板<br>
     * 
     * @author侯杨 <br>
     *           2014-2-14
     * 左香勇
     *           2014-6-6 添加排序参数sort
     * @param pageRoll 分页参数
     * @param templateData 模板对象
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see ITempManagePersistence#searchAllTemp(PageRoll, TemplateData)
     * @since
     */
    public List<TemplateHelpData> searchAllTempType(PageRoll pageRoll, TemplateData templateData, String Type, int sort) {
        return tempManagePersistence.searchAllTempType(pageRoll, templateData, Type, sort);
    }

    /**
     * 模板详情页面查看page列表
     * 
     * @author hy  update  侯杨
     * @date 2014-2-25   
     * @param pageRoll 分页
     * @param pageHelpData  帮组类 传值
     * @return
     */
    public List<PageData> countTempPage(PageRoll pageRoll,PageHelpData pageHelpData){
    	//自定义sql语句
    	StringBuffer buffer=new StringBuffer( "select page.name pagename, page.Status  sta,page.create_time ttime,users.loginmail username ,t.name tname,t.id tid" +
    			" from mini_page_template p, mini_page page,ctn_sysuser users,mini_template t " +
    			"where 1 = 1   and p.page_id = page.id and  users.id=page.user_id and t.id=p.template_id " +
    			" and t.isdelete='1' and p.template_id = ?  ");
    	 // 定义查询参数
    	List<Object> objects=new ArrayList<Object>();  
    	objects.add(pageHelpData.getTempId());  //模板id
    	//已发布的page
    	if(pageHelpData.getPageState().equals("1") ){
    		   buffer.append(" and page.isdelete= 1 and page.status = '1'");
    	   }
    	//正在使用的page
    	if(pageHelpData.getPageState().equals("0") ){
    		   buffer.append(" and page.isdelete= 1 and page.status <> '2'");
    	   }
    	buffer.append(" order by page.create_time desc");
    	JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询

    	//分页查询
    	pageRoll.setCountSQL("select count(*)  from (" + buffer.toString()+")");
    	pageRoll.setSearchSQL(buffer.toString());
    	 // 获取查询结果
    	List<ETIPResultSet> resultSet = dao.search(pageRoll,objects);//分页查询
    	List<PageData> list=new ArrayList<PageData>();  //定义 返回集合
    	 for (int i = 0; i < resultSet.size(); i++) {
    		 ETIPResultSet rs = resultSet.get(i);
    		 PageData data=new PageData();  //page实体
			 data.setName(rs.getString("PAGENAME"));  //page名称
			 data.setCreateTime(rs.getDate("TTIME"));  //创建时间
			 data.setStatus(rs.getString("STA"));  //page状态
			 UserData userData=new UserData(); //用户实体
			 userData.setLoginMail(rs.getString("USERNAME")); //用户账号
			 TemplateData templateData=new TemplateData();  //模板实体
			 templateData.setName(rs.getString("TNAME"));  //模板名称
			 data.setUserData(userData);
			 data.setTemplateData(templateData);
			 list.add(data);
		}
    	   return list;
    }

    @Override
    public List<TemplateData> searchTemp(TemplateData templateData) {
        // 定义查询语句
        String hql = "from TemplateData where 1=1 and isDelete = 1";
        // 获取查询结果
        List<TemplateData> list = tempManagePersistence.search(hql);
        return list;
    }

    @Override
    public TemplateData searchById(String tempId) {
        return tempManagePersistence.retrieve(tempId);
    }

}
