package com.mini.componentClass.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.common.util.StringUtil;
import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.component.data.ComponentData;
import com.mini.componentClass.data.ComponentClassData;
import com.mini.componentClass.persistence.IComponentClassPersistence;
/**
 * 〈组件表样式business层实现类〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @date 2014-08-14
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component("componentClassBusiness")
public class ComponentClassBusiness extends FrmBusiness implements IComponentClassBusiness{
    // 组件样式持久化层接口  容器注入
   @Resource(name="componentClassPersistence")
    private IComponentClassPersistence componentClassPersistence;
   /**
    * 
    *根据主键id查询主键样式表 查询<br>
    * 
    * @author 侯杨 <br> 
    *         2014-8-14
    * @update 
    * @param [data]     [主键实体]
    * @return  [返回主键样式集合]
    * @see   [类、类#方法、类#成员]
    * @since [起始版本]
    */
   public List<ComponentClassData> getAllCompId(ComponentData data){
       List<ComponentClassData> list=new ArrayList<ComponentClassData>();
       String hql="from ComponentClassData t  where t.isDelete <> 1 and t.componentid = ?";
        if(data!=null){
            list=componentClassPersistence.search(hql, new Object[]{data.getId()});
        }
       return  list;
   }
   /**
    * 
    *classname 名称必须是唯一的，检查数据库是否存在<br>
    * 
    * @author 侯杨 <br> 
    *         2014-8-14
    * @update 
    * @param [ComponentClassData]     [组件实体]
    * @return  [返回不为null  表示此方法查询成功没有异常  返回null 有异常]
    * @see   [类、类#方法、类#成员]
    * @since [起始版本]
    */
   @Override
   public String ajaxFindComponentClassData(ComponentClassData data){
       StringBuffer  msg=new StringBuffer();
       StringBuffer  he=new StringBuffer();
       try {
           String classHelp=data.getPcclassCon();
           if(classHelp!=null && !"".equals(classHelp)){
               classHelp.trim();
               classHelp= classHelp.replaceAll("\n","");
               classHelp= classHelp.replaceAll("\r","");
              /* classHelp= classHelp.replaceAll(" ","");*/
               //把页面获取的class内容按“}”分割
               String[] conSP=classHelp.split("}");
               List<String> list=StringUtil.returnList(data.getComponentData().getCode());
               for (int j = 0; j < list.size(); j++) {
                   he.append(list.get(j)+",");
                 
             }
           for (int i = 0; i < conSP.length; i++) {
                       //截取class名称
               if(!" ".equals(conSP[i])){
                   String className;
                   int n = conSP[i].indexOf(",");
                   if(n>=0){
                       conSP[i]=conSP[i].substring(conSP[i].indexOf(",")+1).trim(); 
                   }
                      if(conSP[i].indexOf("{")>0){
                          conSP[i]=conSP[i].trim();
                      className=(conSP[i]+"}".trim()).substring(1, (conSP[i]+"}").indexOf("{")).trim();
                      //当class是用的双引号
                      if(className.indexOf(" ")!=-1){
                          String[] c=className.split(" ");
                          for (int j = 0; j < c.length; j++) {
                            if(j==0){
                                if(he.toString().indexOf(c[j])==-1){
                                    msg.append(className);
                                    break;
                                }
                            }
                        }
                      }else if(className.indexOf(":")!=-1){
                          String[] c=className.split(":");
                          for (int j = 0; j < c.length; j++) {
                            if(j==0){
                                if(he.toString().indexOf(c[j])==-1){
                                    msg.append(className);
                                    break;
                                }
                            }
                        }
                      }else{
                          int a=he.toString().indexOf(className);
                          if(he.toString().indexOf(className)==-1){
                             
                              msg.append(className);
                          }
                      }
                      
                      }   
                     
                
                         }
                   }
             }
                    
           
    } catch (Exception e) {
        msg.append("1");
    }
       return msg.toString();
   }
   /**
    * 
    *增加修改组件样式表<br>
    * 
    * @author 侯杨 <br> 
    *		   2014-8-14
    * @update 
    * @param [ComponentClassData]     [组件实体]
    * @return  [返回1  表示此方法查询成功没有异常  返回0 有异常]
    * @see   [类、类#方法、类#成员]
    * @since [起始版本]
    */
   @Override
   public String componentClassDataAddUpdate(ComponentClassData data){
       String pcclassHelp=data.getPcclassCon();
       String ipadClassHelp=data.getIpadClassCon();
       String phoneClassHelp=data.getPhoneClassCon();
       String msg="0";
       try {
          
         if(data!=null){
                 pcclassHelp= pcclassHelp.replaceAll("\n","");
                 pcclassHelp= pcclassHelp.replaceAll("\r","");
                 ipadClassHelp= ipadClassHelp.replaceAll("\n","");
                 ipadClassHelp= ipadClassHelp.replaceAll("\r","");
                 phoneClassHelp= phoneClassHelp.replaceAll("\n","");
                 phoneClassHelp= phoneClassHelp.replaceAll("\r","");
                
                   StringBuffer name=new StringBuffer();
               //把页面获取的class内容按“}”分割
               String[] conSP=pcclassHelp.split("}");
               for (int j = 0; j < conSP.length; j++) {
                   if(!" ".equals(conSP[j])){
                     //截取class名称
                       if(conSP[j].indexOf("{")>0){
                     String className=(conSP[j]+"}").substring(0, (conSP[j]+"}").indexOf("{")).trim();
                     className.trim();
                     //拼接样式名称
                     name.append(className);
                       }
                   }
               }
                  
                 if(data.getId()!=null && !"".equals(data.getId())){
                     data.setId(data.getId());
                     data.setIsDelete(0);
                     data.setCreateTime(new Date());
                     data.setClassName(name.toString());
                     data.setPcclassCon(pcclassHelp);
                     data.setPhoneClassCon(phoneClassHelp);
                     data.setIpadClassCon(ipadClassHelp);
                     data.setClassType(data.getClassType());
                     componentClassPersistence.update(data);
                 }else{
                     data.setIsDelete(0);
                     data.setCreateTime(new Date());
                     data.setClassName(name.toString());
                     data.setPcclassCon(pcclassHelp);
                     data.setPhoneClassCon(phoneClassHelp);
                     data.setIpadClassCon(ipadClassHelp);
                     data.setClassType(data.getClassType());
                     componentClassPersistence.add(data);
                 }
               
     
               msg="1";
                }
            } catch (Exception e) {
                msg="0";
            }
       
            return msg;
     }
   /**
    * 
    *删除组件样式表<br>
    * 
    * @author 侯杨 <br> 
    *          2014-8-18
    * @update 
    * @param [ComponentClassData]     [组件实体]
    * @return  [返回1  表示此方法查询成功没有异常  返回0 有异常]
    * @see   [类、类#方法、类#成员]
    * @since [起始版本]
    */
   public String componentClassDatadelete(ComponentClassData data){
       String msg="0";
       try {
           if(data!=null){
               if(!data.getId().trim().equals("1")){
                   componentClassPersistence.delete(data);
               }
           }
           msg="1";
        
    } catch (Exception e) {
        msg="0";
    }
       return msg;
   }
   /**
    * 
    *删除主键的时候，删除主键样式相关联的数据<br>
    * 
    * @author 侯杨 <br> 
    *         2014-8-18
    * @update 
    * @param [componentClassData]     [组件样式实体]
    * @return  [返回类型说明]
    * @exception/throws [异常类型] [异常说明]
    * @see   [类、类#方法、类#成员]
    * @since [起始版本]
    */
   public String deleteCom(ComponentClassData data){
       String msg="0";    
         try {
             if(data!=null){
                 JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
                //如果外键id不是空   就代表是在删除组件的时候  一起删除组件样式，是空就是在单独删除主键样式
                  if(data.getComponentid()!=null && !"".equals(data.getComponentid())){
                      String sql="update MINI_COMPONENT_CLASS c set c.isdelete=1 where c.componentid = ?";
                      dao.executeSQL(sql, new Object[]{data.getComponentid()});
                  }else{
                      String sql="update MINI_COMPONENT_CLASS c set c.isdelete=1 where c.id = ?";
                      dao.executeSQL(sql, new Object[]{data.getId()});
                  }
                 msg="1";
             }
        } catch (Exception e) {
           msg="0";
        }
       return msg;
   }
   /**
    * 
    *  根据主键查询信息<br>
    * 
    * @author 侯杨 <br> 
    *         2014-8-20
    * @update 
    * @param [data]     [主键样式实体]
    * @return  [实体]
    * @see   [类、类#方法、类#成员]
    * @since [起始版本]
    */
   public ComponentClassData getComponentClassDataById(ComponentClassData data){
       if(data!=null){
       data=componentClassPersistence.retrieve(data.getId());
       }
       return data;
   }
}

