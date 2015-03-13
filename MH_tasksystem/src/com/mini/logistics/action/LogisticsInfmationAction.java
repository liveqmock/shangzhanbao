package com.mini.logistics.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

import com.itour.etip.pub.frame.FrmAction;
import com.mini.back.orderManage.facade.OrderGoodsinfoFacade;
import com.mini.logistics.data.LogisticsInfmationData;
import com.mini.logistics.facade.LogisticsInfmationFacade;
import com.mini.purchase.goods.data.GoodsInfoData;
import com.mini.purchase.goods.facade.GoodsInfoFacade;
import com.mini.purchase.orderManager.data.ConSumerOrderData;
import com.mini.purchase.orderManager.data.ConsumerOrderGoodsinfoData;
import com.mini.purchase.orderManager.facade.OrderManagerFacade;
import com.mini.util.logistics.LogisticsUtil;

/**
 * 
 * 物流查询对外action
 *
 * @author 左香勇
 * @see [相关类/方法]
 * @since vmaque2.0
 */
public class LogisticsInfmationAction extends FrmAction {
    
    @Resource(name="logisticsInfmationFacade")
    private LogisticsInfmationFacade logisticsInfmationFacade;
    
    @Resource(name="orderManagerFacade")
    private OrderManagerFacade orderManagerFacade;
    
    @Resource(name="orderGoodsinfoFacade")
    private OrderGoodsinfoFacade orderGoodsinfoFacade; 
    
    @Resource(name="goodsInfoFacade")
    private GoodsInfoFacade goodsInfoFacade;
    
    /**
     * 
     * 根据订单id查询物流信息
     * 
     * @author 左香勇 
     *		   2014年12月15日
     * @see   LogisticsInfmationAction#queryLogistics()
     * @since vmaque2.0
     */
    public void queryLogistics(){
        
        //获取订单id
        String orderid = request.getParameter("orderid");
        
        ConSumerOrderData conSumerOrderData = orderManagerFacade.queryConSumerOrderDataById(orderid);
        
        String result = "";
        
        if(conSumerOrderData != null && conSumerOrderData.getLogisticsNumber() != null && !"".equals(conSumerOrderData.getLogisticsNumber())){
        
            //获取物流单号
            String number = conSumerOrderData.getLogisticsNumber();
            
            //获取物流公司的汉语拼音
            String com = hanyuToPinyin(conSumerOrderData.getLogisticsCompany().trim());
    
            //通过第三方接口查询快递信息
            String logisticsContent = LogisticsUtil.queryLogistics(com, number);
            
            JSONObject json = JSONObject.fromObject(logisticsContent);
            
            if(!json.get("status").equals("2")){//如果第三方接口查询数据成功
                //把查询到的信息解析后存入数据库
                for(int i = 0; i < json.getJSONArray("data").size(); i++){
                    
                    LogisticsInfmationData data = new LogisticsInfmationData();
                    
                    data.setConsumerOrderId(orderid);
                    String context = JSONObject.fromObject(json.getJSONArray("data").get(i)).getString("context");
                    data.setContext(context);
                    
                    String timeStr = JSONObject.fromObject(json.getJSONArray("data").get(i)).getString("time");
                    DateFormat dd=new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    Date date=null;
                    try {
                        date = dd.parse(timeStr);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    data.setTime(date);
                    
                    logisticsInfmationFacade.addLogisticsInfmationData(data);
                }
                
            }
            System.out.println("-------------------------------------------"+orderid+"---------------------------------");
            //根据订单编号查询订单物流信息
            List<LogisticsInfmationData> listLogistics = logisticsInfmationFacade.getLogisticsInfmationDataByOrderId(orderid);
            
            System.out.println("-------------------------------------------"+listLogistics.size()+"-----------------------------------------");
            
            //根据订单编号查询订单商品中间表信息
            ConsumerOrderGoodsinfoData cos = orderGoodsinfoFacade.queryConsumerOrderGoodsinfoDataByOrderid(orderid);
            
            //根据商品id查询商品表信息
            GoodsInfoData godata = new GoodsInfoData();
            godata.setId(cos.getGoodsInfId());
            
            System.out.println("--------------------------------------------"+godata.getId()+"---------------------------------------");
            
            GoodsInfoData goodsData = goodsInfoFacade.getGoodsInfoData(godata);
            
            
            if(goodsData != null && cos != null) {
                StringBuffer sbuff = new StringBuffer("{\"success\":\"true\",\"data\":[");
                
                for(int i=0 ;i < listLogistics.size(); i++){
                    LogisticsInfmationData logistics = listLogistics.get(i);
                    sbuff.append("{\"context\":\"");
                    sbuff.append(logistics.getContext());
                    sbuff.append("\",");
                    sbuff.append("\"time\":\"");
                    sbuff.append(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(logistics.getTime()));
                    sbuff.append("\"}");
                    if(i<listLogistics.size()-1){
                        sbuff.append(",");
                    }
                }
                sbuff.append("],\"com\":\"");
                sbuff.append(conSumerOrderData.getLogisticsCompany().trim());
                System.out.println("------"+conSumerOrderData.getLogisticsCompany().trim());
                sbuff.append("\",\"num\":\"");
                sbuff.append(conSumerOrderData.getLogisticsNumber());
                System.out.println("------"+conSumerOrderData.getLogisticsNumber());
                sbuff.append("\",\"goodsName\":\"");
                sbuff.append(goodsData.getGoodsName());
                System.out.println("------"+goodsData.getGoodsName());
                sbuff.append("\",\"price\":\"");
                sbuff.append(conSumerOrderData.getPrice());
                System.out.println("------"+conSumerOrderData.getPrice());
                sbuff.append("\",\"goodsNum\":\"");
                sbuff.append(cos.getGoodsNum());
                System.out.println("------"+cos.getGoodsNum());
                sbuff.append("\"}");
                result = sbuff.toString();
            } else {
                result = "{\"success\":\"false\",\"message\":\"未查询到该订单信息\"}";
            }
        } else {
            result = "{\"success\":\"false\",\"message\":\"未查询到该订单信息\"}";
        }
        System.out.println("----------------------"+result);
        try {
            String callback = request.getParameter("jsoncallback");
            response.setHeader("Content-type", "text/html;charset=UTF-8");  
            response.setCharacterEncoding("UTF-8");  
            response.getWriter().write(callback + "(" +result+ ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
    /**
     * 汉字转拼音的方法
     * @param name 汉字
     * @return 拼音
     */
     private String hanyuToPinyin(String name){
         StringBuffer pinyinName = new StringBuffer();
         char[] nameChar = name.toCharArray();
         HanyuPinyinOutputFormat defaultFormat =  new HanyuPinyinOutputFormat();
         defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
         defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
         for (int i = 0; i < nameChar.length; i++) {
             if (nameChar[i] > 128) {
                 try {
                     pinyinName.append(PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0]);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             } else {
                 pinyinName.append(nameChar[i]);
             }
         }
         return pinyinName.toString().toLowerCase();
     }
}
