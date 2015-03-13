package com.mini.logistics;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class LogisticsTest {
    /**
     * 〈一句话功能简述〉 〈功能详细描述〉
     * 
     * @author [作者]（必须，使用汉语）
     * @see [相关类/方法]（可选）
     * @since vmaque2.0
     */
    public static void main(String[] agrs) {

        try {
            URL url = new URL("http://api.kuaidi100.com/api?id=b725e2109af337e1&com=shunfeng&nu=305608338451&show=0&muti=1&order=desc");
            URLConnection con = url.openConnection();
            con.setAllowUserInteraction(false);
            InputStream urlStream = url.openStream();
//            String type = con.guessContentTypeFromStream(urlStream);
//            String charSet = null;
//            if (type == null)
//                type = con.getContentType();
//
//            if (type == null || type.trim().length() == 0 || type.trim().indexOf("text/html") < 0)
//                return;
//
//            if (type.indexOf("charset=") > 0)
//                charSet = type.substring(type.indexOf("charset=") + 8);

            byte b[] = new byte[10000];
            int numRead = urlStream.read(b);
            String content = new String(b, 0, numRead);
            while (numRead != -1) {
                numRead = urlStream.read(b);
                if (numRead != -1) {
                     String newContent = new String(b, 0, numRead);
//                    String newContent = new String(b, 0, numRead, charSet);
                    content += newContent;
                }
            }
            System.out.println("content:" + content);
            urlStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
