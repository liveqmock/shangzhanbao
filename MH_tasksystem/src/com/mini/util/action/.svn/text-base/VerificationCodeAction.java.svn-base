package com.mini.util.action;

import com.mini.util.RandomValidateCode;

/**
 * 产生验证码action 
 * @author wendong
 * @date 2013-9-4
 * @update
 */
public class VerificationCodeAction extends CommonAction {
	
	/**
	 * 获取到产生的验证码
	 * @author wendong
	 * @date 2013-9-4
	 * @update
	 */
	public void index(){
		response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//输出图片方法
        } catch (Exception e) {
//            e.printStackTrace();
        }
	}
}	
