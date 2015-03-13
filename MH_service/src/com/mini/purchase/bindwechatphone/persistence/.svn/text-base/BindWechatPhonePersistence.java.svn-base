package com.mini.purchase.bindwechatphone.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.mini.purchase.bindwechatphone.data.BindWechatPhoneData;

/**
 * 微信和电话号码绑定  Persistence 实现类
 * @author  侯杨
 * @see     IBindWechatPhonePersistence
 * @since   vmaque2.0
 */
@SuppressWarnings("unchecked")
@Component("bindWechatPhonePersistence")
public class BindWechatPhonePersistence extends BasePersistence<BindWechatPhoneData> implements IBindWechatPhonePersistence {

    /**
     * 
     *根据openid查询列表<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月30日
     * @update 
     * @param openId 微信id
     * @return  list 微信和电话号码绑定的中间表集合
     * @see   BindWechatPhonePersistence#getBindWechatPhoneDataByOpenid(String)
     * @since vmaque2.0
     */
    @Override
    public List<BindWechatPhoneData> getBindWechatPhoneDataByOpenid(String openId) {
        String hql="from BindWechatPhoneData b where b.openId = ?";
        List<BindWechatPhoneData> list=search(hql, new Object[]{openId});
        return list;
    }
    /**
     * 
     *根据openid 和电话号码查询实体<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月30日
     * @update 
     * @param   data 微信和电话号码绑定实体
     * @return  data 微信和电话号码绑定实体
     * @see   BindWechatPhonePersistence#getBindWechatPhoneData(String,String)
     * @since vmaque2.0
     */
    @Override
    public BindWechatPhoneData getBindWechatPhoneData(BindWechatPhoneData data){
        String hql="from BindWechatPhoneData b where b.openId = ?";
        List<BindWechatPhoneData> list=search(hql, new Object[]{data.getOpenId()});
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
        
    }
    /**
     * 
     *添加<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月30日
     * @update 
     * @param   data 微信和电话号码绑定实体
     * @return  void 
     * @see   BindWechatPhonePersistence#addBindWechatPhoneData(data)
     * @since vmaque2.0
     */
    @Override
    public void addBindWechatPhoneData(BindWechatPhoneData data){
        data.setBindTime(new Date());
        add(data);
    }
}
