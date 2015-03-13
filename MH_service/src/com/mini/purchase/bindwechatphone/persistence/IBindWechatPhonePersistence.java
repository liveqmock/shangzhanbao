package com.mini.purchase.bindwechatphone.persistence;

import java.util.List;

import com.itour.etip.pub.base.IBasePersistence;
import com.mini.purchase.bindwechatphone.data.BindWechatPhoneData;

/**
 * 微信和电话号码绑定  Persistence 层接口
 * @author  侯杨
 * @see     IBindWechatPhonePersistence
 * @since   vmaque2.0
 */
public interface IBindWechatPhonePersistence  extends IBasePersistence<BindWechatPhoneData>{
    /**
     * 
     *根据openid查询列表<br>
     * 
     * @author 侯杨 <br> 
     *		   2014年12月30日
     * @update 
     * @param openId 微信id
     * @return  list 微信和电话号码绑定的中间表集合
     * @see   IBindWechatPhonePersistence#getBindWechatPhoneDataByOpenid(String)
     * @since vmaque2.0
     */
    public List<BindWechatPhoneData> getBindWechatPhoneDataByOpenid(String openId);
    /**
     * 
     *根据openid 和电话号码查询实体<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月30日
     * @update 
     * @param   data 微信和电话号码绑定实体
     * @return  data 微信和电话号码绑定实体
     * @see   IBindWechatPhonePersistence#getBindWechatPhoneData(data)
     * @since vmaque2.0
     */
    public BindWechatPhoneData getBindWechatPhoneData(BindWechatPhoneData data);
    /**
     * 
     *添加<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月30日
     * @update 
     * @param   data 微信和电话号码绑定实体
     * @return  void 
     * @see   IBindWechatPhonePersistence#addBindWechatPhoneData(data)
     * @since vmaque2.0
     */
    public void addBindWechatPhoneData(BindWechatPhoneData data);
   
}
