package com.mini.order.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.mini.order.data.AttenInfoData;

/**
 * 订单联系信息持久层实现类
 *
 * @author     文东
 * @see        AttenInfoPersistence
 * @since      
 */
@SuppressWarnings("unchecked")
@Component("atteninfoPersistence")
public class AttenInfoPersistence extends BasePersistence<AttenInfoData> implements IAttenInfoPersistence{

    @Override
    public List<AttenInfoData> searchByAttenInfo(AttenInfoData attenInfoData) {
        //定义hql语句
        StringBuffer hql = new StringBuffer("from AttenInfoData where 1=1");
        //参数集合
        List<Object> objects = new ArrayList<Object>();
        if(attenInfoData.getUserId()!=null){
            hql.append(" and userId = ?");
            objects.add(attenInfoData.getUserId());
        }
        hql.append(" order by createTime desc");
        return this.search(hql.toString(), objects);
    }
    
}
