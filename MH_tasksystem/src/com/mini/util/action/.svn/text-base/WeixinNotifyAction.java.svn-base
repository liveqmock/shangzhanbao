package com.mini.util.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.common.util.ResouceUtil;
import com.itour.etip.pub.frame.FrmAction;
import com.mini.purchase.orderManager.data.ConSumerOrderData;
import com.mini.purchase.orderManager.facade.OrderManagerFacade;
/**
 * 
 * <br> 
 * 微信接收参数action
 * 2015-1-16
 * @author 侯杨
 * @see WeixinNotifyAction
 * @since vmaque2.0
 */

public class WeixinNotifyAction extends FrmAction{
    @Resource(name = "orderManagerFacade")
    private OrderManagerFacade orderManagerFacade;
    private ConSumerOrderData conSumerOrderData=new ConSumerOrderData();
    /**
     * 
     * <br> 
     * 获取微信返回的xml
     * 2015-1-16
     * @author 侯杨
     * @see WeixinNotifyAction#WeiXinNotify_url()
     * @since vmaque2.0
     */
    public void WeiXinNotify_url() throws IOException, DocumentException{
        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine())!=null){
            sb.append(line);
        }
        if(sb.toString()!="" && !"".equals(sb.toString())){
            Document dom=DocumentHelper.parseText(sb.toString());
            Element root=dom.getRootElement();
            //微信返回成功值
            String return_code=root.element("return_code").getText();
            if(return_code.equals("SUCCESS")){
                //订单编号 
                String orderCode=root.element("out_trade_no").getText();
                if(orderCode!=null && !"".equals(orderCode)){
                    conSumerOrderData.setOrderCode(orderCode);
                    conSumerOrderData.setState(1);
                    orderManagerFacade.paySuccessWithOrderChangeState(conSumerOrderData);  //订单标记为已使用
                    //获取 红包参数  跳转到支付成功页面
                    String attach=root.element("attach").getText();
                    if(!attach.equals("1")){
                        String[] s=attach.split(",");
                        //红包数据完整时，表示有使用红包的数据
                        if(s.length>=3){
                        String rid=s[0];
                        String cid=s[1];
                        String sid=s[2];
                        String fileName = "domain.properties";
                        String redPackageListPath = ResouceUtil.getProperty(fileName, "redPackageListPath");// 读取红包系统的路径
                        String weixinurl = redPackageListPath+"/siims/vmaque/snatchPackage/goumaiUpdateSaveSnatchPackageUserData.jspx?"
                                + "snatchPackageUserData.collarPackageUserId="+cid+"&snatchPackageUserData.redpackageId="+rid+
                                "&snatchPackageUserData.id="+sid;
                        URL url1 = new URL(weixinurl);
                        HttpURLConnection urlConnection = (HttpURLConnection) url1.openConnection();
                        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        String inputLine = in.readLine().toString();
                        inputLine= new String(inputLine.getBytes(),"utf-8");
                        System.out.println(inputLine);
                        }
                    }
                }
            }
        }
    }
   
    
}
