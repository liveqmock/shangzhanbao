package com.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 截取从数据库获取的组件源码  得到合适的组件代码<br> 
 * 〈功能详细描述〉
 *
 * @author 冯鑫
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CutStringUtil {
    /**
     * 
     * 格局组件源码 截取到多余的div 值保留<div class="update">内部的组件代码<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-6-13
     * @update 
     * @param String str 从数据库获取的组件源码
     * @return  String 截取到合适的组件代码
     */
    public static String cutUseDivTag(String str,String conid){
        str = replaceBlank(str);
        String bufferUpdateTag = str.substring(0, str.indexOf("update")+8).substring(0,str.substring(0, str.indexOf("update")+8).lastIndexOf("<div"));
        String buffer = str.substring(str.substring(0, str.indexOf("update")+8).lastIndexOf("<div"));
        String str1  = buffer.substring(0, buffer.toString().length()-queryDivTagNum(bufferUpdateTag, 0)*6);
        str1 = str1.substring(0, str1.lastIndexOf("</div>"));
        str1=str1.concat("<input type='hidden' id='' class='component' name  value='"+conid+"'></div>");
        return str1;
    }
    /**
     * 
     * 获取组件代码中<div class="update">标签之前div标签的数量<br>
     * 
     * @author fengxin <br> 
     *		   2014-6-13
     * @update 
     * @param String str,int num
     * @return  int div标签数量
     */
    public static int queryDivTagNum(String str,int num){
        if(str.indexOf("</div")!=-1){
            str = str.replaceFirst("</div", "");
            num--;
        }
        if(str.indexOf("<div")==-1){
            return num;
        }else{
            num++;
            return queryDivTagNum(str.substring(str.indexOf("<div")+4),num);
        }
        
    }
    /**
     * 
     * 去除字符串中的换行<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-6-13
     * @update 
     * @param String str
     */
    public static String replaceBlank(String str){
        Pattern p = Pattern.compile("\n"); 
        Matcher m = p.matcher(str); 
        return str.trim();
    }
    /**
     * 
     * 修改可复用组件的id串<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-6-16
     * @update 
     * @param String idStr, String divString
     * @return  String
     */
    public static String changeDivID(String idStr, String divString){
        //组件中id后所拼接的时间戳
        String idFlag = String.valueOf(new Date().getTime());
        String[] str =idStr.trim().split(",");
        for (int i = 0; i < str.length; i++) {
            String oldId=str[i].substring(str[i].indexOf(":")+1).trim();
            String newId =oldId.concat(""+idFlag);
            divString = divString.replace(oldId, newId);
        }
        return divString;
    }
    
    public static String random(){
        String[] beforeShuffle = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",  
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
                "W", "X", "Y", "Z" };  
        List list = Arrays.asList(beforeShuffle);  
        Collections.shuffle(list);  
        StringBuilder sb = new StringBuilder();  
        for (int i = 0; i < list.size(); i++) {  
            sb.append(list.get(i));  
        }  
        String afterShuffle = sb.toString();  
        String result = afterShuffle.substring(5, 9);  
        return result;
    }
    public static void main(String[] args) {
        String str  = "<div class='slide5' style=''>"+
                       "<div class='explanation update'>"+
                        "<div class='explanation_title'>"+
                        "<span id='table_titleOne'>标题</span>"+
                        "</div><div id='table_contentOne' class='explanation_content'>"+
                         "标题内容"+
                        "</div></div></div>";
        str = replaceBlank(str);
        String bufferUpdateTag = str.substring(0, str.indexOf("update")+8).substring(0,str.substring(0, str.indexOf("update")+8).lastIndexOf("<div"));
        String buffer = str.substring(str.substring(0, str.indexOf("update")+8).lastIndexOf("<div"));
        String str1  = buffer.substring(0, buffer.toString().length()-queryDivTagNum(bufferUpdateTag, 0)*6);
        System.out.println(str1);
    }
}
