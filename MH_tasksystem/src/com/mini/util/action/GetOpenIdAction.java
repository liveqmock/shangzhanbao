package com.mini.util.action;

import java.io.IOException;

import org.apache.struts2.convention.annotation.ResultPath;

import net.sf.json.JSONObject;

import com.common.util.ResouceUtil;
import com.itour.etip.pub.frame.FrmAction;
import com.mini.util.wxpay.tenpay.utils.CommonUtil;

@ResultPath("/")
public class GetOpenIdAction extends FrmAction {

    /**
     * 获取微信公众平台id
     */
    public static final String APPID = ResouceUtil.getProperty("wxPay.properties", "appid");

    /**
     * 获取微信公众平台密钥
     */
    public static final String APPSECRET = ResouceUtil.getProperty("wxPay.properties", "appsecret");

    // /**
    // * 获取微信商家平台id
    // */
    // public static final String PARTNER = ResouceUtil.getProperty("wxPay.properties", "partner");
    //
    // /**
    // * 获取微信商家平台密钥
    // */
    // public static final String PARTNERKEY = ResouceUtil.getProperty("wxPay.properties", "partnerkey");

    /**
     * 
     * 微信授权 获取微信openId<br>
     * 
     * @author 侯杨 <br>
     *         2015年1月12日
     * @update
     * @return void
     * @throws IOException
     * @exception/throws UnsupportedEncodingException
     * @see ToWxPayAction#getWeixinOpenId()
     * @since vmaque2.0
     */
    public void getWeixinOpenId() throws IOException {
         
        String  GetCodeRequest = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect"; 
        

  

            String result = null; 
  

            GetCodeRequest  = GetCodeRequest.replace("APPID", "wxb414d8cfd28ae3ed"); 
  

            GetCodeRequest  = GetCodeRequest.replace("REDIRECT_URI","http://192.168.5.55/get_open_id/key/getWeixinOpenId"); 
  

            GetCodeRequest = GetCodeRequest.replace("SCOPE", "snsapi_base"); 
  

            result = GetCodeRequest; 
  

  

  
        
        // 微信openid
        String openId = "";
        // 微信code
        String code = request.getParameter("code");
        if (code == "" || code == null) {
            openId = "0";
        } else {
            // 获取OpenId
            String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APPID + "&secret=" + APPSECRET
                    + "&code=" + code + "&grant_type=authorization_code";
            JSONObject jsonObject = CommonUtil.httpsRequest(URL, "GET", null);
            try {
                openId = jsonObject.getString("openid");
            } catch (Exception e) {
                openId = "1";
            }
        }
        json = openId;
    }
    
    
    public void toSendOpenId(){
        String openId = request.getParameter("openId");
        json = openId;
    }
    
}
