package com.util.mail;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.common.util.ResouceUtil;

/**
 * 发送简单邮件
 * 
 * @author 左香勇
 * 
 */
public class MailUtil implements Runnable {

    public static final String fileName = "mail.properties";

    public static final String mailServerHost = ResouceUtil.getProperty(fileName, "mailServerHost");// 从配置文件获取邮箱服务器地址或ip

    public static final String mailServerPort = ResouceUtil.getProperty(fileName, "mailServerPort");// 从配置文件获取邮箱服务器端口

    public static final String fromAddress = ResouceUtil.getProperty(fileName, "fromAddress");// 从配置文件获取发件人邮箱

    public static final String fromName = ResouceUtil.getProperty(fileName, "fromName");// 从配置文件获取发件人名称

    public static final String userName = ResouceUtil.getProperty(fileName, "userName");// 从配置文件获取登录用户名

    public static final String password = ResouceUtil.getProperty(fileName, "password");// 从配置文件获取登录密码

    public static final String validate = ResouceUtil.getProperty(fileName, "validate");// 从配置文件获取是否需要服务器验证

    private String toAddress;

    private Map<String, String> contentMap;

    private int type;

    public MailUtil(String toaddress, Map<String, String> contentmap, int mailtype) {
        
        this.toAddress = toaddress;
        this.contentMap = contentmap;
        this.type = mailtype;
        
    }

    public void run() {
        sendMail();
    }

    /**
     * 发送邮件的方法
     * 
     * @param toAddress 收件人邮箱
     * @param contentStr 存储链接，账户，密码等邮件动态信息
     * @param type 邮件类型
     * 
     * @return 发送是否成功
     */
    public boolean sendMail() {
        // 这个类主要是设置邮件
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost(mailServerHost);
        mailInfo.setMailServerPort(mailServerPort);
        mailInfo.setValidate("true".equals(validate) ? true : false);
        mailInfo.setUserName(userName);
        mailInfo.setPassword(password);// 您的邮箱密码
        mailInfo.setFromAddress(fromAddress);
        mailInfo.setFromName(fromName);
        mailInfo.setToAddress(toAddress);
        mailInfo.setSubject(getSubject());
        mailInfo.setContent(getContent());
        // 发送邮件
        SimpleMailSender sms = new SimpleMailSender();
        // sms.sendTextMail(mailInfo);// 发送文体格式
        return sms.sendHtmlMail(mailInfo);// 发送html格式

    }

    /**
     * 
     * 〈获取邮件正文〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-6-11
     * @update
     * @return [邮件正文]
     * @exception/throws
     * @see
     * @since
     */
    private String getContent() {
        String content = ResouceUtil.getProperty(fileName, "content" + type);

        for (String dataKey : contentMap.keySet()) {
            content = replaceAll(content, "${" + dataKey + "}", contentMap.get(dataKey));
        }

        return content;
    }

    /**
     * 
     * 从配置文件中获取邮件标题
     * 
     * @author 左香勇 <br>
     *         2014-6-11
     * @update
     * @return [邮件标题]
     * @exception/throws
     * @see
     * @since
     */
    private String getSubject() {
        return ResouceUtil.getProperty(fileName, "subject" + type);
    }

    /**
     * 
     * 判断邮箱是否合法
     * 
     * @author 左香勇 <br>
     *         2014-6-12
     * @update
     * @param [mailStr] [邮箱地址]
     * @return [是否合法]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public static boolean exactnessMail(String mailStr) {
        Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");
        Matcher m = p.matcher(mailStr);
        return m.matches();
    }

    /**
     * 
     * 替换字符串中所有子字符串
     * 
     * @author 左香勇 <br>
     *         2014-6-11
     * @update
     * @param [replaceStr] [要替换的字符串]
     * @param [oldStr] [旧的子符串]
     * @param [newStr] [新的字符串]
     * @return
     * @exception/throws
     * @see
     * @since
     */
    private String replaceAll(String replaceStr, String oldStr, String newStr) {
        String newReplaceStr = replaceStr.replace(oldStr, newStr);
        if (replaceStr.indexOf(oldStr) > -1) {
            return replaceAll(newReplaceStr, oldStr, newStr);
        } else {
            return newReplaceStr;
        }
    }
}
