package com.mini.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

/**
 * 输出clob
 * 
 * @author 文东
 * @see OutClobFile
 * @since
 */
public class OutClobFile {

    /**
     * 
     * 〈把java.sql.Clob输出到文件〉<br>
     * 
     * @author 文东<br>
     *         2014-3-8
     * @update
     * @param [clob] [oracle大字段] [filePath] [存储文件目录] [fileName] [存储的文件名]
     * @return [void]
     * @exception/throws [异常类型] [异常说明]
     * @see OutClobFile#generaFile(Clob, String, String)
     * @since [起始版本]
     */
    public static void generaFile(Clob clob, String filePath, String fileName) throws Exception {
        String strNR = null;
        // 读取文件内容
        strNR = clob.getSubString((long) 1, (int) clob.length());
   
        File path = new File(filePath); // 判断目录是否存在，如果不存在则创建该目录
        if (!path.exists()) {
            path.mkdirs();
        }
        // 写入文件
        OutputStreamWriter isw = new OutputStreamWriter(new FileOutputStream(filePath + File.separator + fileName),
                "UTF-8");
        BufferedWriter bw = new BufferedWriter(isw);
        bw.write(strNR, 0, strNR.length());
        bw.close();
        isw.close();
    }

    /**
     * 
     * 将clob类型的数据转成String<br>
     * 
     * @author 文东 <br>
     *         2014-3-9
     * @update
     * @param clob clob类型的数据
     * @return String 转换成String类型的结果变量
     * @exception/throws SQLException
     * @see OutClobFile#clobToString(Clob)
     * @since
     */
    public static String clobToString(Clob clob) throws SQLException {
        Reader inStream = clob.getCharacterStream();
        char[] c = new char[(int) clob.length()];
        String content = null;
        try {
            inStream.read(c);
            content = new String(c);
            inStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
    
    /**
     * 
     * 〈把String输出到文件〉<br>
     * 
     * @author 文东<br>
     *         2014-3-8
     * @update
     * @param  [filePath] [存储文件目录] [fileName] [存储的文件名]
     * @return [void]
     * @exception/throws [异常类型] [异常说明]
     * @see OutClobFile#generaFile(Clob, String, String)
     * @since [起始版本]
     */
    public static void generaFile(String strNR, String filePath, String fileName) throws Exception {
        File path = new File(filePath); // 判断目录是否存在，如果不存在则创建该目录
        if (!path.exists()) {
            path.mkdirs();
        };
        OutputStreamWriter isw = new OutputStreamWriter(new FileOutputStream(filePath + File.separator + fileName), "UTF-8");
        BufferedWriter bw = new BufferedWriter(isw);
        bw.write(strNR, 0, strNR.length());
        bw.close();
        isw.close();
    }
}
