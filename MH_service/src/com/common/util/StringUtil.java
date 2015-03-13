package com.common.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class StringUtil {

	// private static Log logger = LogFactory.getLog(StringUtil.class);

	// 国标码和区位码转换常量
	public static int GB_SP_DIFF = 160;
	// 存放国标一级汉字不同读音的起始区位码
	public static int[] secPosValueList = { 1601, 1637, 1833, 2078, 2274, 2302,
			2433, 2594, 2787, 3106, 3212, 3472, 3635, 3722, 3730, 3858, 4027,
			4086, 4390, 4558, 4684, 4925, 5249, 5600 };

	// 存放国标一级汉字不同读音的起始区位码对应读音
	public static char[] firstLetter = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'w',
			'x', 'y', 'z' };

	public static char convert(String ch) {
		byte[] bytes = new byte[2];
		try {
			bytes = ch.getBytes("GB2312");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		char result = '-';
		int secPosValue = 0;
		int i;
		for (i = 0; i < bytes.length; i++) {
			bytes[i] -= GB_SP_DIFF;
		}
		secPosValue = bytes[0] * 100 + bytes[1];
		for (i = 0; i < 23; i++) {
			if (secPosValue >= secPosValueList[i]
					&& secPosValue < secPosValueList[i + 1]) {
				result = firstLetter[i];
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(StringUtil.toLetters("哈哈哈哈是的发生的"));
	}

	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}
	
	public static String toLetters(String str){
		char[] chars = str.toCharArray();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			if(isChinese(chars[i])){
				stringBuffer.append(convert(chars[i]+""));
			}else{
				stringBuffer.append((chars[i]+""));
			}
		}
		
		return stringBuffer.toString();
	}
	
	public static String returnString(String con,String b){
	  //要被替换的class名称数组
        List<String> list1=new ArrayList<String>();
        //要被替换成的class名称数组
        List<String> list2=new ArrayList<String>();
        String classcon=con;
        //分割
        String[] conSP=classcon.split(">");
        for (int i = 0; i < conSP.length; i++) {
            //class内容
            String classCon=conSP[i]+">";
            //当html标签当中有class的时候
            if(classCon.indexOf("class")!=-1){
                String  a=classCon.substring(classCon.indexOf("class"));
                //当class是用的双引号
                if(a.indexOf('"')!=-1){
                int index=a.indexOf('"')+1;
                int index1=a.indexOf('"', index+1);
                String e=a.substring(index,index1);
              
                //当修改的时候，编号已存在  就不在添加编号
                if(e.indexOf(b)==-1){
                //当class有多个名称的时候
                if(e.indexOf(" ")!=-1){
                    String [] s=e.split(" ");
                    StringBuffer sb=new StringBuffer();
                    StringBuffer sb1=new StringBuffer();
                    for (int j = 0; j < s.length; j++) {
                        if(j+1==s.length){
                         sb1.append(s[j]);
                        }else{
                         sb1.append(s[j]+" ");
                        }
                        if(s[j].indexOf("update")==-1){
                            if(j+1==s.length){
                                sb.append(s[j]+"_"+b);  
                                }else{
                                sb.append(s[j]+"_"+b+" "); 
                                }
                            }else{
                                if(j+1==s.length){
                                sb.append(s[j]);  
                                }else{
                                sb.append(s[j]+" "); 
                                }
                            }
                  }
                    list1.add("class="+'"'+sb1.toString()+'"');
                    list2.add("class="+'"'+sb.toString()+'"');
                    
                } else{
                    list1.add("class="+'"'+e+'"');
                    if(e.indexOf("update")==-1){
                    list2.add("class="+'"'+e+"_"+b+'"');
                    }
                }
                
          }       
            }else if(classCon.indexOf("'")!=-1){   //当class是用的单引号
                int index=a.indexOf("'")+1;
                int index1=a.indexOf("'", index+1);
                String e=a.substring(index,index1);
                //当修改的时候，编号已存在  就不在添加编号
              if(e.indexOf(b)==-1){
                //当class有多个名称的时候
                if(e.indexOf(" ")!=-1){
                    String [] s=e.split(" ");
                    StringBuffer sb=new StringBuffer();
                    StringBuffer sb1=new StringBuffer();
                    for (int j = 0; j < s.length; j++) {
                        if(j+1==s.length){
                         sb1.append(s[j]);
                        }else{
                         sb1.append(s[j]+" ");
                        }
                        if(s[j].indexOf("update")==-1){
                            if(j+1==s.length){
                                sb.append(s[j]+"_"+b);  
                                }else{
                                sb.append(s[j]+"_"+b+" "); 
                                }
                       
                        }else{
                            if(j+1==s.length){
                            sb.append(s[j]);  
                            }else{
                                sb.append(s[j]+" "); 
                            }
                        }
                      list1.add("class="+'"'+sb1.toString()+'"');
                      list2.add("class="+'"'+sb.toString()+'"');
                  }
                }else{
                    list1.add("class="+'"'+e+'"');
                    if(e.indexOf("update")==-1){
                        list2.add("class="+'"'+e+"_"+b+'"');
                    }
                 }
            }
       }
             
    }
}
        /*替换*/
        for (int j = 0; j < list1.size(); j++) {
            int a=classcon.indexOf(list1.get(j));
            if(classcon.indexOf(list1.get(j))!=-1){
              
                classcon=classcon.replace(list1.get(j), list2.get(j));
        }
      }
        return classcon;
	}
	
	public static List<String> returnList(String con){
	    List<String> list=new ArrayList<String>();
	    String classcon=con;
        //分割
        String[] conSP=classcon.split(">");
        for (int i = 0; i < conSP.length; i++) {
            //class内容
            String classCon=conSP[i]+">";
            //当html标签当中有class的时候
            if(classCon.indexOf("class")!=-1){
                String  a=classCon.substring(classCon.indexOf("class"));
                //当class是用的双引号
                if(a.indexOf('"')!=-1){
                int index=a.indexOf('"')+1;
                int index1=a.indexOf('"', index+1);
                String e=a.substring(index,index1);
                list.add(e);

            }else if(classCon.indexOf("'")!=-1){   //当class是用的单引号
                int index=a.indexOf("'")+1;
                int index1=a.indexOf("'", index+1);
                String e=a.substring(index,index1);
                list.add(e);
                }
          
            }
        }
        return list;
	}
}
