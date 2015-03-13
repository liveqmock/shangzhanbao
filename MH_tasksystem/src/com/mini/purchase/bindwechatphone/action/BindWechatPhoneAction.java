package com.mini.purchase.bindwechatphone.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.itour.etip.pub.frame.FrmAction;
import com.mini.purchase.bindwechatphone.data.BindWechatPhoneData;
import com.mini.purchase.bindwechatphone.facade.BindWechatPhoneFacade;

public class BindWechatPhoneAction extends FrmAction{
    /**
     * 微信和电话号码绑定  Facade层注入
     */
    @Resource(name="bindWechatPhoneFacade")
    private BindWechatPhoneFacade bindWechatPhoneFacade;
    
    private BindWechatPhoneData bindWechatPhoneData=new BindWechatPhoneData();
    
    /**
     * 
     *绑定接口<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月30日
     * @update 
     * @return   void 
     * @see   BindWechatPhoneFacade#bindWechatPhone()
     * @since vmaque2.0
     */
    public void bindWechatPhone(){
        String returnJsonStr = "";
        //获取微信用户的openid
        String openid = request.getParameter("openid");
        //获取电话号码
        String phone = request.getParameter("phone");
        //获取姓名
        String name= request.getParameter("name");
        String callback = request.getParameter("jsoncallback");
        if(openid == null || "".equals(openid)){
            returnJsonStr = "{\"SUCCESS\": false, \"MESSAGE\": \"微信用户的openid为空！\"}";
            printTopage(response, returnJsonStr, callback);
            return;
        }
        if(phone == null || "".equals(phone)){
            returnJsonStr = "{\"SUCCESS\": false, \"MESSAGE\": \"绑定电话号码为空！\"}";
            printTopage(response, returnJsonStr, callback);
            return;
        }
        if(name == null || "".equals(name)){
            returnJsonStr = "{\"SUCCESS\": false, \"MESSAGE\": \"绑定姓名不能为空！\"}";
            printTopage(response, returnJsonStr, callback);
            return;
        }
        //赋值
        BindWechatPhoneData data=new BindWechatPhoneData();
        data.setOpenId(openid);
        bindWechatPhoneData=bindWechatPhoneFacade.getBindWechatPhoneData(data);
        if(bindWechatPhoneData!=null){
            returnJsonStr = "{\"SUCCESS\": false, \"MESSAGE\": \"此微信openId与电话号码已绑定过！\"}";
            printTopage(response, returnJsonStr, callback);
            return;
        }
            data.setPhone(phone);
            data.setName(name);
            bindWechatPhoneFacade.addBindWechatPhoneData(data);
            returnJsonStr = "{\"SUCCESS\": true, \"MESSAGE\": \"绑定成功！\"}";
            printTopage(response, returnJsonStr, callback);
        
    }
    /**
     * 
     *查询当前用户是否已经和微信绑定<br>
     * 
     * @author 侯杨 <br> 
     *		   2015年1月4日
     * @return  void
     * @see   BindWechatPhoneAction#selectBindBindWechatPhone()
     * @since vmaque2.0
     */
    public void selectBindBindWechatPhone(){
        String returnJsonStr = "";
        //获取微信用户的openid
        String openid = request.getParameter("openid");
        String callback = request.getParameter("jsoncallback");
        if(openid == null || "".equals(openid)){
            returnJsonStr = "{\"status\": 0, \"MESSAGE\": \"微信用户的openid为空！\"}";
            printTopage(response, returnJsonStr, callback);
            return;
        }
        /*if(phone == null || "".equals(phone)){
            returnJsonStr = "{\"status\": 1, \"MESSAGE\": \"绑定电话号码为空！\"}";
            printTopage(response, returnJsonStr, callback);
            return;
        }
        if(name == null || "".equals(name)){
            returnJsonStr = "{\"status\": 2, \"MESSAGE\": \"绑定姓名不能为空！\"}";
            printTopage(response, returnJsonStr, callback);
            return;
        }*/
        //查询条件赋值
        BindWechatPhoneData data=new BindWechatPhoneData();
        data.setOpenId(openid);
        bindWechatPhoneData=bindWechatPhoneFacade.getBindWechatPhoneData(data);
        if(bindWechatPhoneData==null){
            returnJsonStr = "{\"status\": 3, \"MESSAGE\": \"此微信openId还未绑定！\"}";
            printTopage(response, returnJsonStr, callback);
        }else{
            returnJsonStr = "{\"status\": 4, \"MESSAGE\": \"此微信openId已绑定！\"}";
            printTopage(response, returnJsonStr, callback);
        }
    }
    private void printTopage(HttpServletResponse response, String msg, String callback){
        try {
            response.getWriter().write(callback + "(" +msg+ ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BindWechatPhoneData getBindWechatPhoneData() {
        return bindWechatPhoneData;
    }
    public void setBindWechatPhoneData(BindWechatPhoneData bindWechatPhoneData) {
        this.bindWechatPhoneData=bindWechatPhoneData;
    }
    
}
