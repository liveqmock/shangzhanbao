package com.mini.purchase.bindwechatphone.facade;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.purchase.bindwechatphone.data.BindWechatPhoneData;
import com.mini.purchase.bindwechatphone.service.IBindWechatPhoneService;

/**
 * 微信和电话号码绑定  Facade 层
 * @author  侯杨
 * @see     BindWechatPhoneFacade
 * @since   vmaque2.0
 */
@Component("bindWechatPhoneFacade")
public class BindWechatPhoneFacade extends FrmFacade{
    /**
     * 微信和电话号码绑定  Service层注入
     */
    @Resource(name="bindWechatPhoneService")
    private IBindWechatPhoneService bindWechatPhoneService;
   
    /**
     * 
     *根据openid 和电话号码查询实体<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月30日
     * @update 
     * @param   data 微信和电话号码绑定实体
     * @return  data 微信和电话号码绑定实体
     * @see   BindWechatPhoneFacade#getBindWechatPhoneData(data)
     * @since vmaque2.0
     */
    public BindWechatPhoneData getBindWechatPhoneData(BindWechatPhoneData data){
        return bindWechatPhoneService.getBindWechatPhoneData(data);
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
     * @see   BindWechatPhoneFacade#addBindWechatPhoneData(data)
     * @since vmaque2.0
     */
    public void addBindWechatPhoneData(BindWechatPhoneData data){
        bindWechatPhoneService.addBindWechatPhoneData(data);
    }
    
}
