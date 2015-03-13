package com.mini.purchase.bindwechatphone.business;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.purchase.bindwechatphone.data.BindWechatPhoneData;
import com.mini.purchase.bindwechatphone.persistence.IBindWechatPhonePersistence;


/**
 * 微信和电话号码绑定  Business 实现类
 * @author  侯杨
 * @see     BindWechatPhoneBusiness
 * @since   vmaque2.0
 */
@Component("bindWechatPhoneBusiness")
public class BindWechatPhoneBusiness extends FrmBusiness implements IBindWechatPhoneBusiness{
    /**
     * 微信和电话号码绑定  Persistence层注入
     */
    @Resource(name="bindWechatPhonePersistence")
    private IBindWechatPhonePersistence bindWechatPhonePersistence;
    /**
     * 
     *根据openid查询列表<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月30日
     * @update 
     * @param openId 微信id
     * @return  list 微信和电话号码绑定的中间表集合
     * @see   BindWechatPhoneBusiness#getBindWechatPhoneDataByOpenid(String)
     * @since vmaque2.0
     */
    @Override
    public List<BindWechatPhoneData> getBindWechatPhoneDataByOpenid(String openId) {
        return bindWechatPhonePersistence.getBindWechatPhoneDataByOpenid(openId);
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
     * @see   IBindWechatPhoneBusiness#getBindWechatPhoneData(data)
     * @since vmaque2.0
     */
    @Override
    public BindWechatPhoneData getBindWechatPhoneData(BindWechatPhoneData data){
      return bindWechatPhonePersistence.getBindWechatPhoneData(data);
    }
    /**
     * 
     *添加<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月30日
     * @update 
     * @param   data 微信和电话号码绑定实体
     * @return   void 
     * @see   IBindWechatPhoneBusiness#addBindWechatPhoneData(data)
     * @since vmaque2.0
     */
    @Override
    public void addBindWechatPhoneData(BindWechatPhoneData data){
        data.setBindTime(new Date());
        bindWechatPhonePersistence.add(data);
    }
}
