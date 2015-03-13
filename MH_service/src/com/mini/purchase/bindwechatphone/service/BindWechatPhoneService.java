package com.mini.purchase.bindwechatphone.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.mini.purchase.bindwechatphone.business.IBindWechatPhoneBusiness;
import com.mini.purchase.bindwechatphone.data.BindWechatPhoneData;

/**
 * 微信和电话号码绑定  Service 实现类
 * @author  侯杨
 * @see     BindWechatPhoneService
 * @since   vmaque2.0
 */
@Component("bindWechatPhoneService")
public class BindWechatPhoneService extends FrmService implements IBindWechatPhoneService{
    /**
     * 微信和电话号码绑定  Business层注入
     */
    @Resource(name="bindWechatPhoneBusiness")
    private IBindWechatPhoneBusiness bindWechatPhoneBusiness;
    /**
     * 
     *根据openid查询列表<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月30日
     * @update 
     * @param openId 微信id
     * @return  list 微信和电话号码绑定的中间表集合
     * @see   BindWechatPhoneService#getBindWechatPhoneDataByOpenid(String)
     * @since vmaque2.0
     */
    public List<BindWechatPhoneData> getBindWechatPhoneDataByOpenid(String openId){
        return bindWechatPhoneBusiness.getBindWechatPhoneDataByOpenid(openId);
    }
    /**
     * 
     *根据openid 和电话号码查询实体<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月30日
     * @update 
     * @param openId 微信id
     * @param   data 微信和电话号码绑定实体
     * @return  data 微信和电话号码绑定实体
     * @see   BindWechatPhoneBusiness#getBindWechatPhoneData(String,String)
     * @since vmaque2.0
     */
    public BindWechatPhoneData getBindWechatPhoneData(BindWechatPhoneData data){
           return bindWechatPhoneBusiness.getBindWechatPhoneData(data);
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
     * @see   BindWechatPhoneService#addBindWechatPhoneData(data)
     * @since vmaque2.0
     */
    public void addBindWechatPhoneData(BindWechatPhoneData data){
        bindWechatPhoneBusiness.addBindWechatPhoneData(data);
    }
}
