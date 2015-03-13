package com.mini.component.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.common.util.RandomString;
import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.component.data.ComponentData;
import com.mini.component.persistence.IComponentPersistence;
import com.mini.componentThumbnail.data.ComponentThumbnailData;
import com.mini.componentThumbnail.persistence.IComponentThumbnailPersistence;

/**
 * 
 * 〈组件操作Business层接口〉<br>
 * 〈功能详细描述〉
 * 
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("componentBusiness")
public class ComponentBusiness extends FrmBusiness implements IComponentBusiness {

    @Resource(name = "componentPersistence")
    private IComponentPersistence componentPersistence;
    
    // 组件缩略图持久化层接口  容器注入
    @Resource(name = "componentThumbnailPersistence")
    private IComponentThumbnailPersistence componentThumbnailPersistence;

  

    /**
     * 
     * 〈删除组件信息〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-19
     * @update
     * @param [id] [要删除的组件实体的id]
     * @return [无返回值]
     * @exception/throws
     * @see
     * @since [起始版本]
     */
    public void deleteComponent(String id) {

        componentPersistence.deleteComponent(id);

    }

    /**
     * 
     * 〈编辑组件信息〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-19
     * @update
     * @param [ComponentData] [组件实体信息]
     * @return [无返回值]
     * @exception/throws
     * @see
     * @since [起始版本]
     */
    public void editComponent(ComponentData data) {

        componentPersistence.editComponent(data);

    }

    /**
     * 
     * 
     * 〈根据组件id查询组件信息〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-19
     * @update
     * @param [id] [要查询的组件实体的id]
     * @return [无返回值]
     * @exception/throws
     * @see
     * @since [起始版本]
     */
    public ComponentData getComponentByid(String id) {
    	ComponentData data=componentPersistence.getComponentByid(id);
    	//根据组件id 查询组件缩略图信息
    	String con=null;
    	//如果code字段不为空，就取出来 转化为string类型
    	if(data.getCode()!=null){
    		//con=ClobFile.clobToString(data.getCode());
    	    con = data.getCode();
    }
    	data.setClob(con);
    	data.setThumbnailData(getComponentThumbnailData(data.getId()));
        return data;

    }
    
    /**
	 * 
	 * 〈根据pageid查询组件信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-3-10
	 * @update
	 * @param [参数1] [参数1说明]
	 * @return [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public List getComponent(String pageid){
		return componentPersistence.getComponent(pageid);
	}

    @Override
    public List<ComponentData> searchComponentAndPic(ComponentData componentData) {
        // 存放查询结果
        List<ComponentData> componentDatas = new ArrayList<ComponentData>();
        // 定义查询参数
        List<Object> list = new ArrayList<Object>();
        // 定义可拼接的查询语句
        StringBuffer hql = new StringBuffer("from ComponentData c,ComponentThumbnailData t where 1=1 and c.id = t.componentid and t.type = 'pc'");
        // 是否需要查某些特定类型的组件 若客户端有传来类型值 则按类型查询
        if (componentData.getType() != null) {
            hql.append(" and c.type = ?");
            list.add(componentData.getType());
        }
        // 获取查询结果
        List<Object[]> objects = componentPersistence.searchAny(hql.toString(), new Object[]{componentData.getType()});
        // 循环获取对象值
        for (int i = 0; i < objects.size(); i++) {
            ComponentData data = new ComponentData();
            data = (ComponentData)objects.get(i)[0];
            data.setThumbnailData((ComponentThumbnailData)objects.get(i)[1]);
            componentDatas.add(data);
        }
        return componentDatas;
    }
    
    public List<ComponentData> searchComponent(ComponentData componentData) {
        // 存放查询结果
        List<ComponentData> componentDatas = new ArrayList<ComponentData>();
        // 定义查询参数
        List<Object> list = new ArrayList<Object>();
        // 定义可拼接的查询语句
        StringBuffer hql = new StringBuffer("from ComponentData c where 1=1 and");
        if(componentData.getType()!=null && !"".equals(componentData.getType())){
            hql.append(" c.type = ?");
            list.add(componentData.getType());
        }
        if(componentData.getCssType()!=null && !"".equals(componentData.getCssType())){
            hql.append(" and c.cssType = ?");
            list.add(componentData.getCssType());
        }
        componentDatas = componentPersistence.search(hql.toString(), list);
        return componentDatas;
    }

    @Override
    public ComponentData searchComponentById(String id) {
        
        return componentPersistence.retrieve(id);
    }

    @Override
    public String addComponent(ComponentData componentData) {
        String msg="0";
        
        try {
            boolean b = false;
            // 组件编码
            String tempSn;
            do {
                // 获取组件编码
                tempSn = RandomString.randomString(6);
                // 查看生成的组件编码是否可用 若为true 表示可用 false表示不可用
                List<ComponentData> datas = componentPersistence.searchBySn(tempSn);
                if (datas.size() > 0) {
                    b = true;
                }
            } while (b);
            componentData.setSn(tempSn);
            componentData.setCreateTime(new Date());
            componentPersistence.add(componentData);
            msg="1";
        } catch (Exception e) {
            msg="0";
        }
        return msg;
   /*     ComponentThumbnailData componentThumbnailData = new ComponentThumbnailData();
        componentThumbnailData.setType("pc");
        componentThumbnailData.setName(componentData.getName());
        componentThumbnailData.setMemo(componentData.getName());
        componentThumbnailData.setComponentid(componentData.getId());
        componentThumbnailPersistence.addThumbnail(componentThumbnailData, filePC);*/
    }

    @Override
    public List<ComponentData> searchComponent(PageRoll pageRoll, ComponentData componentData) {
        // 用来存储查询到的所有组件集合
        List<ComponentData> componentDatas = new ArrayList<ComponentData>();
        // 定义hql查询所有模板
        StringBuffer hqlComp = new StringBuffer( "from ComponentData c   where 1=1 ");
      //定义根据条件查询  集合
      		List<Object> objects=new ArrayList<Object>();
      	//条件查询开始
      		if(componentData.getCssType()!=null && !"".equals(componentData.getCssType()) && !"0".equals(componentData.getCssType())){   //组件风格
      			hqlComp.append(" and c.cssType like ?");
      			objects.add("%"+componentData.getCssType()+"%");
      		}
      		if(componentData.getCreateTime()!=null && !"".equals(componentData.getCreateTime())){   //创建时间开始时间
      			hqlComp.append(" and c.createTime >= ?");
      			objects.add(componentData.getCreateTime());
      		}
      		if(componentData.getModifyTime()!=null && !"".equals(componentData.getModifyTime())){   //创建时间截止时间
      			hqlComp.append(" and c.createTime <= ?");
      			objects.add(componentData.getModifyTime());
      		}
      		hqlComp.append(" order by c.createTime desc");  //按创建时间排序
    	//分页查询
		pageRoll.setCountSQL("select count(*) " + hqlComp.toString());
		pageRoll.setSearchSQL(hqlComp.toString());
        // 获取查询结果
        
		List<ComponentData> componentDatas2 = componentPersistence.search(pageRoll,objects).getList();   //获取查询出来的组件集合
        List<ComponentData> list=new ArrayList<ComponentData>();  //定义新的组件集合
        //遍历查询出来的集合，取出id查询组件的预览图对象
        for (int i = 0; i < componentDatas2.size(); i++) {
        	ComponentData data=componentDatas2.get(i);
			data.setThumbnailData(getComponentThumbnailData(componentDatas2.get(i).getId()));  //查询缩略图
			list.add(data);
		}
        return list;
    }
    
    /**
     * 组件删除
     * @author 侯杨
     * date 2014-5-20
     * @param componentData
     * @return
     */
    public String deleteComponent(ComponentData componentData){
    	String mes="0";
    	try {
    		if(componentData.getId()!=null && !"".equals(componentData.getId())){
        		componentPersistence.delete(componentData);   //删掉组件
        		//根据组件id删除组件缩略图
        		String sql="delete mini_component_thumbnail t where  t.componentid='"+componentData.getId()+"'";
        		componentThumbnailPersistence.executeSQL(sql);
        		mes="1";
        	}
		} catch (Exception e) {
			mes="0";
		}
    	return mes;
    }
    /**
     * 根据组件id 查询  组件的略缩图信息
     * @author 侯杨
     * @date 2014-5-20
     * @param thumbnailId
     * @return
     */
    public ComponentThumbnailData getComponentThumbnailData(String thumbnailId){
    	//根据组件id 查询组件缩略图信息
    	ComponentThumbnailData data=null;
    	String hql="from ComponentThumbnailData t where t.type='pc' and  t.componentid='"+thumbnailId+"'";
		List<ComponentThumbnailData> list=componentThumbnailPersistence.search(hql);
		 if(list.size()>0){
			 data=list.get(0);
		 }
		 return data;
    }
    /**
     * 根据id  修改组件
     * @author 侯杨
     * @date 2014-5-20
     * @param data
     * @param filePC
     * @return
     */
	@Override
	public String editComponentFile(ComponentData data) {
		String mes="0";
		try {
				ComponentData componentData=componentPersistence.retrieve(data.getId());
				data.setCreateTime(componentData.getCreateTime());  //创建时间
				data.setEditcode(componentData.getEditcode());  //修改page html
				data.setSn(componentData.getSn());
				data.setModifyTime(new Date()); //修改时间
				data.setCreatorName(componentData.getCreatorName());  //创建人
		        componentPersistence.update(data);
		        ComponentThumbnailData componentThumbnailData = getComponentThumbnailData(data.getId());  //查询略缩图信息
		/*		// 存储图片
				Blob img = null;
				FileInputStream inputStream = null;
				if (files != null) {
					// 将图片读入输入流
					try {
						inputStream = new FileInputStream(files);
					} catch (FileNotFoundException e) {
						// 文件流异常
						e.printStackTrace();
					}
				}
				try {
					img = Hibernate.createBlob(inputStream);
				} catch (IOException e) {
					// IO流异常
					e.printStackTrace();
				}*/
			/*	componentThumbnailData.setContent(img);*/
			/*	componentThumbnailPersistence.update(componentThumbnailData);*/
		        mes="1";
		} catch (Exception e) {
			mes="0";
		}
	    return mes;
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
    public List<ComponentData> ajaxSearchComponentByComponentType(ComponentData componentData){
        // 存放查询结果
        List<ComponentData> componentDatas = new ArrayList<ComponentData>();
        // 定义查询参数
        List<Object> list = new ArrayList<Object>();
        // 定义可拼接的查询语句
        StringBuffer hql = new StringBuffer("from ComponentData c where 1=1 and c.isNewOrOld = 1 and ");
        if(componentData.getType()!=null && !"".equals(componentData.getType())){
            if("0".equals(componentData.getType())){
                hql.append(" c.type not in(1,2,3,4,6)");
            }else{
                hql.append(" c.type = ?");
                list.add(componentData.getType());
            }
        }
       /* if(componentData.getCssType()!=null && !"".equals(componentData.getCssType())){
            hql.append(" and c.cssType = ?");
            list.add(componentData.getCssType());
        }*/
        componentDatas = componentPersistence.search(hql.toString(), list);
        return componentDatas;
    }
    /**
     * 
     *根据主键类型查询主键信息<br>
     * 
     * @author 侯杨<br> 
     *         2014-9-19
     * @update 
     * @see   IComponentBusiness#getComponentData
     * @since vmaque1.6
     */
    public ComponentData getComponentData(ComponentData data){
        String hql="from ComponentData c where c.type = ?";
        List<ComponentData> list=componentPersistence.search(hql, new Object[]{data.getType()});
        if(list!=null && list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

}
