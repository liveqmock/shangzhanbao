package com.mini.util.logistics;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.common.util.ResouceUtil;

public class LogisticsUtil {
    
    /**
     * 查询链接
     */
    public static final String LOGISTICS_URL = ResouceUtil.getProperty("logistics.properties","url");
    
    /**
     * 三方接口提供的id
     */
    public static final String LOGISTICS_ID = ResouceUtil.getProperty("logistics.properties","id");

    /**
     * 三方接口提供的secret
     */
    public static final String LOGISTICS_SECRET = ResouceUtil.getProperty("logistics.properties","secret");

    /**
     * 返回数据类型
     */
    public static final String LOGISTICS_TYPE = ResouceUtil.getProperty("logistics.properties","type");
    
    /**
     * 返回数据排序
     */
    public static final String LOGISTICS_ORD = ResouceUtil.getProperty("logistics.properties","ord");
    
    /**
     * 返回数据编码方式
     */
    public static final String LOGISTICS_ENCODE = ResouceUtil.getProperty("logistics.properties","encode");
    
    /**
     * 
     * 查询物流信息<br>
     * 
     * @author 左香勇<br> 
     *		   2014-11-19
     * @param com     物流公司编号
     *        number  快递单号
     * @return  String json格式字符串
     * 
     * @see   LogisticsUtil#queryLogistics(String, String)
     * 
     * @since vmaque2.3
     */
    public static String queryLogistics(String com, String number){
        
        try {
           URL newUrl = new URL(LOGISTICS_URL+"?id="+LOGISTICS_ID+"&secret="+LOGISTICS_SECRET+"&com="+com+"&nu="+number+"&type="+LOGISTICS_TYPE+"&ord="+LOGISTICS_ORD+"&encode="+LOGISTICS_ENCODE+"&ver=2");
            //URL newUrl = new URL("http://api.ickd.cn/?id=107675&secret=06fe7b17c0e685025bc8ec5bad36f4ef&com=shunfeng&nu=305608338451&type=json&ord=desc&encode=gbk&ver=2&button=%CC%E1%BD%BB");
            URLConnection con = newUrl.openConnection();
            con.setAllowUserInteraction(false);
            InputStream urlStream = newUrl.openStream();
            byte b[] = new byte[10000];
            int numRead = urlStream.read(b);
            String content = new String(b, 0, numRead);
            while (numRead != -1) {
                numRead = urlStream.read(b);
                if (numRead != -1) {
                     String newContent = new String(b, 0, numRead);
                    content += newContent;
                }
            }
            System.out.println("content:" + content);
          
            return content;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
