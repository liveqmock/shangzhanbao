package com.util;

import java.util.Random;

/**
 *生成随机字符串
 *
 * @author     文东
 * @see        RandomString
 * @since      
 */
public class RandomString {
    
    private static Random randGen = null;
    private static char[] numbersAndLetters = null;
    
    /**
     * 
     *生成随机字符串<br>
     * 
     * @author 文东 <br> 
     *		   2014-2-20
     * @update 
     * @param length 需要生成的字符串长度
     * @return  String类型的字符串
     * @exception/throws 
     * @see   RandomString#randomString(int)
     * @since [起始版本]
     */
    public static String randomString(int length) {
//             if (length < 1) {
//                 return null;
//             }
//             if (randGen == null) {
//                    randGen = new Random();
//                    numbersAndLetters = ("0123456789").toCharArray();
//                      //numbersAndLetters = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
//                     }
//             char [] randBuffer = new char[length];
//             randBuffer[0]='S';
//             randBuffer[1]='n';
//             for (int i=2; i<randBuffer.length; i++) {
//                 randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
//             }
//             return new String(randBuffer);
        Random ran = new Random();
        StringBuffer sb = new StringBuffer("Sn");
        int i = 0;
        while(i < length-2){
           int t = ran.nextInt(9);
           if(sb.indexOf(String.valueOf(t)) == -1){
              sb.append(t);
              i++;
           }
        }
        return sb.toString();
    }
}
