package com.mini.order.persistence;

import java.util.List;

import com.itour.etip.pub.base.IBasePersistence;
import com.mini.order.data.AttenInfoData;

/**
 * 订单联系人信息持久化接口层
 * 
 * @author 文东
 * @see IAttenInfoPersistence
 * @since
 */
public interface IAttenInfoPersistence extends IBasePersistence<AttenInfoData> {

    /**
     * 
     * 根据条件查询订单联系人信息<br>
     * 
     * @author 文东 <br>
     *         2014年5月14日
     * @update
     * @param attenInfoData 订单联系人信息对象 内存放条件查询的参数
     * @return List<AttenInfoData> 获取条件查询结果
     * @exception/throws
     * @see IAttenInfoPersistence#searchByAttenInfo(AttenInfoData)
     * @since
     */
    public List<AttenInfoData> searchByAttenInfo(AttenInfoData attenInfoData);
    

}
