package com.mini.message.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.message.data.MessageData;

/**
 * 〈留言 persistence 实现类〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@SuppressWarnings("unchecked")
@Component("messagePersistence")
public class MessagePersistence  extends BasePersistence<MessageData> implements IMessagePersistence {
	/**
	 * 分页查询  所有
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param pageRoll
	 * @param messageData
	 * @return
	 */
	@Override
	public List<MessageData> getAll(PageRoll pageRoll, MessageData messageData) {
		//定义hql语句
		StringBuffer hql=new StringBuffer("from MessageData mes where 1=1 and mes.isdelete='1'");
		
		//定义根据条件查询  集合
		List<Object> objects=new ArrayList<Object>();
		//条件查询
		if(messageData.getStatus()!=null && !"".equals(messageData.getStatus())){   //状态查询
			 if(messageData.getStatus().equals("1")){   //未查看
				 hql.append(" and mes.status='1'");
			 }
			 if(messageData.getStatus().equals("0")){   //已查看
				 hql.append(" and mes.status='0'");
			 }
			 if(messageData.getStatus().equals("2")){   //所以留言
			 }
		}
		if(messageData.getTitle()!=null && !"".equals(messageData.getTitle())){  //标题
			hql.append(" and mes.title like ?");
			objects.add("%"+messageData.getTitle()+"%");
		}
		if(messageData.getCreateTime()!=null){  //创建时间开始
			hql.append(" and mes.createTime >= ?");
			objects.add(messageData.getCreateTime());
		}
		if(messageData.getExaminerTime()!=null){  //创建时间截止（用examinerTime字段代替）
			hql.append(" and mes.createTime <= ?");
			objects.add(messageData.getExaminerTime());
		}
		hql.append(" order by mes.createTime desc");   //按创建时间排序
		//分页查询
		pageRoll.setCountSQL("select count(*) " + hql.toString());
		pageRoll.setSearchSQL(hql.toString());
		//返回查询出来的集合
		return this.search(pageRoll,objects).getList();
	}

}
