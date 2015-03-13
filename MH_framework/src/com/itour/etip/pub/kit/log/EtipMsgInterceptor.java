package com.itour.etip.pub.kit.log;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.itour.etip.pub.kit.jms.JMSLog;
import com.itour.etip.pub.kit.jms.JMSUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * <p>
 * Title: 日志信息JavaBean
 * </p>
 * <p>
 * Description: 本拦截器是缺省的拦截器，所有Action执行时都需要执行本拦截器。 通过本拦截器执行后记录日志信息
 * </p>
 * <p>
 * Copyright: Copyright (C), 2009-2010, eTIP
 * </p>
 * 
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-03-20
 */
public class EtipMsgInterceptor implements Interceptor {

    /**
	 * 
	 */
    private static final long serialVersionUID = -8958251714340050657L;
    
    @SuppressWarnings("unchecked")
	private static TreeMap<Integer, String> errorHtml = CacheUtil.getInstance().getCacheMap("errorHtml");

    /**
     * 拦截器日志，主要是拦截struts请求时，自动保存日志，此拦截器日志，仅仅记录错误日志，即当 应用系统请求发生例外时，就记录日志，该日志记录到错误文件中。
     * 
     * @param invocation 当前调用的方法。
     */
    public String intercept(ActionInvocation invocation) throws Exception {

        Object action = invocation.getAction();

        /* 如果不是框架action,那么不执行本拦截器。 */
        if (!(action instanceof FrmAction)) {
            String result = invocation.invoke();
            return result;
        }
        FrmAction myAction = (FrmAction) invocation.getAction();
        String uri = myAction.getRequest().getRequestURI();
        String root = myAction.getRequest().getContextPath();
      
        if (
        // 登录
        uri.startsWith(root + "/user_login/key/userLogin")
                // 模板商店
                || uri.startsWith(root + "/temp_manage/key/searchOpenTemp")
                // 喜欢的模板
                || uri.startsWith(root + "/temp_manage/key/searchByLike")
                // 查看模板详情
                || uri.startsWith(root + "/temp_manage/key/ajaxSearhTempImg")
                // 用户注册
                || uri.startsWith(root + "/user/key/register")
                // 用户注册同名校验
                || uri.startsWith(root + "/user/key/ajaxCheckUser" ) ||uri.startsWith(root + "/user/key/checkUserId")
                // 模板商店头部
                || uri.startsWith(root + "/page_manage/key/top")
                // 跳转到留言板页面
                || uri.startsWith(root + "/page_messageboard/key/toPageMessageboard")
                // 添加留言吧信息
                || uri.startsWith(root + "/page_messageboard/key/addPageMessageboard")
                // 跳转到注册成功的页面
                || uri.startsWith(root + "/user/key/regSucessful")
                 // 模板商店详情
                || uri.startsWith(root + "/temp_manage/key/ajaxSearchTempById")
                // minitop头部静态页面的跳转链接
                || uri.startsWith(root + "/frame/key/methodL") || uri.startsWith(root + "/frame/key/client")
                || uri.startsWith(root + "/frame/key/productShop") || uri.startsWith(root + "/frame/key/help")
                || uri.startsWith(root + "/frame/key/about") || uri.startsWith(root + "/frame/key/toIndex")
                //留言添加
                || uri.startsWith(root + "/message/key/addMessageData")
                //邮件
                || uri.startsWith(root + "/user/key/resetPasswordMail")  || uri.startsWith(root + "/user/key/toresetPassword") 
                || uri.startsWith(root + "/user/key/resetPassword")  || uri.startsWith(root + "/client_manage/key/resetPasswordMail")
                || uri.startsWith(root + "/client_manage/key/clientManageResertPassword") || uri.startsWith(root + "/user/key/topFindPwdSu")
                //模板留言板
                ||uri.startsWith(root + "/temp_manage/key/totempMes")
                //帮组页面左侧链接
                ||uri.startsWith(root + "/frame/key/topHelp1")
                ||uri.startsWith(root + "/frame/key/topHelp2")
                ||uri.startsWith(root + "/frame/key/topHelp3")
                ||uri.startsWith(root + "/frame/key/topHelp4")
                ||uri.startsWith(root + "/frame/key/topHelp5")
                //外网访问page，修改页面title
                 ||uri.startsWith(root + "/page/key/searchByPageInfoExtraData")
                 //帮助与支持
                 ||uri.startsWith(root+"/help_manager/key/turnFrontHelpHelpArticleJSP")
                 ||uri.startsWith(root+"/help_manager/key/viewHelpArticleData")
                 ||uri.startsWith(root+"/help_manager/key/queryListHelpArticleByCate")
                 ||uri.startsWith(root+"/help_manager/key/searchListHelpArticle")
                 ||uri.startsWith(root+"/help_manager/key/turnHelpPage")
                 ||uri.startsWith(root+"/help_manager/key/tohelpmini")
                 ||uri.startsWith(root+"/help_manager/key/tohelpmini1")
                 ||uri.startsWith(root+"/help_manager/key/tohelpmini2")
                 //用户访问page 选择购买 不需要登陆操作
                 ||uri.startsWith(root+"/order_manager/key/toPayOrder")
                 ||uri.startsWith(root+"/order_manager/key/paySuccessWithOrderChangeState")
                 //规格切换
                 ||uri.startsWith(root+"/commodity_config/key/getCommodityById")
                 //page页面购买查询用户的常用地址
                 ||uri.startsWith(root+"/order_manager/key/payfor_orderGood")
                 //红包管理访问
                 ||uri.startsWith(root+"/page_manage/key/getPageListByUserId")
                 ||uri.startsWith(root+"/order_manager/key/payOrclosed_weixin")
                 ||uri.startsWith(root+"/order_manager/key/paySuccess_weixin")
                 //商品订单数据微信访问接口
                 ||uri.startsWith(root+"/goods_order/key/queryGoodsOrder")
                 //查询订单物流接口
                 ||uri.startsWith(root+"/logistics_infmation/key/queryLogistics")
                 //商品品类切换
                 ||uri.startsWith(root+"/commodity_config/key/getAllByParentId")
                 //购买流程查询红包
                 ||uri.startsWith(root+"/siims/vmaque/snatchPackage/getGoumaiSnatchPackageUserData.jspx")
                 //红包使用
                 ||uri.startsWith(root+"/siims/vmaque/snatchPackage/goumaiUpdateSaveSnatchPackageUserData.jspx")
                 //微信id和电话号码绑定接口
                 ||uri.startsWith(root+"/bind_wechat_phone/key/bindWechatPhone")
                 ||uri.startsWith(root+"/to_wx_pay/key/wxPay")
                 //查询当前用户与微信是否绑定
                 ||uri.startsWith(root+"/bind_wechat_phone/key/selectBindBindWechatPhone")
                  //购买查询支付方式
                 ||uri.startsWith(root+"/order_manager/key/selectaccountNumber")
                  //获取微信openId
                 ||uri.startsWith(root+"/get_open_id/key/getWeixinOpenId")
                 //微信支付生成订单
                 ||uri.startsWith(root+"/order_manager/key/toweixinPayOrder")
                  //微信支付
                 ||uri.startsWith(root+"/to_wx_pay/key/wxPay")
                  //跳转订单支付成功页面
                 ||uri.startsWith(root+"/order_manager/key/topayForSuccess_order")
                 //获取微信xml
                 ||uri.startsWith(root+"/weixin_notify/key/WeiXinNotify_url")
        		) {
            String result = invocation.invoke();
          
            return result;
        }else{
        	
        	myAction.getRequest().getSession().setAttribute("oldurl", uri);//如果被拦截了就把访问的路径放到session里面
        	
        	/*************遍历请求里面的参数属性，存放到map对象里面 把map放到session***************/
        	Enumeration parameterNames = myAction.getRequest().getParameterNames();
        	int count =0;
        	String parameterName = null;
        	String parameterValue = null;
        	Map map = new HashMap();
        	
        	while (parameterNames.hasMoreElements()) {
        		parameterName = (String) parameterNames.nextElement();
        		parameterValue = myAction.getRequest().getParameter(parameterName);
        		if(parameterValue==null) parameterValue="";
        		map.put(parameterName, parameterValue);
        		count++;
        	}
        	myAction.getRequest().getSession().setAttribute("paramsmap", map);
        	/***************************end*****************************************/
        	
        	//如果和配置文件中定义的路径相符合，就跳转到首页
        	for (Entry<Integer, String> entry : errorHtml.entrySet()) {
    					 if(uri.equals(entry.getValue())){
    						 uri="/frame/key/toIndex";
    						 myAction.getRequest().getSession().setAttribute("oldurl", uri);//如果被拦截了就把访问的路径放到session里面
    						 map.clear();
    						 myAction.getRequest().getSession().setAttribute("paramsmap", map);
    						 break;
    					 }
    		}
        }

        /**
         * 构造actionName,用于在DesktopRegistry中搜索对应的消息注册表。
         */
        // System.out.println("etipMsgInterceptor.actionName:" + actionName);
        FrmUser user = myAction.getFrmUser();

        /* 以下处理消息 */
        try {

            /* 执行正常的业务逻辑 */
            String result = invocation.invoke();

            // 这是一个协议，从myAction的sessionMap中获取参数，这些参数的用途待定。
            Map<String, String> parameters = (Map<String, String>) myAction.getSessionMap().get("parameters");
            // 目前这句话只能记录日志
            sendMessage(user, invocation, parameters);

            return result;
        } catch (Exception ex) {
            // 例外消息拦截
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("exception", ex.toString());
            sendMessage(user, invocation, parameters);
            throw ex;
        }
    }

    /**
     * 根据注册表发送消息，这样的处理变成同步或异步消息了，如果同步处理，那么就不再发送消息，而是立即处理。
     * 
     * @param user
     * @param registry
     * @param ex
     */
    private void sendMessage(FrmUser user, ActionInvocation invocation, Map<String, String> parameters) {
        String handlerType = "1";// 消息处理者类型，DBLog,DesktopMsg,SMS,Email,Drools
        boolean synchronize = true;// 确定是同步还是异步消息。
        FrmAction myAction = (FrmAction) invocation.getAction();
        /*
         * 构造actionName,用于在DesktopRegistry中搜索对应的消息注册表。
         */
        String requestURI = myAction.getRequest().getRequestURI();
        requestURI = requestURI.substring(requestURI.lastIndexOf("/") + 1);
        String actionClassName = myAction.getClass().getSimpleName();
        String actionName = actionClassName + "." + requestURI;
        if (handlerType.equals("1")) {// 数据库日志
            JMSUtil.sendDBLog(user.etipUserID, user.chinseName, JMSLog.LEVEL_INFO, actionClassName, requestURI,
                    actionName, myAction.getContext(), synchronize, parameters);
        } else if (handlerType.equals("2")) {// 桌面消息
            // saveDesktopMsg(user, registry, invocation, synchronize,
            // parameters);
            // JMSUtil.saveDesktopMsg(user.etipUserID,
            // registry.getMessageName(),
            // "", registry.getHandlerType(), registry.getReceivers(),
            // synchronize, parameters);
        } else if (handlerType.equals("3")) {// 短消息
            // JMSUtil.sendSMS(user.etipUserID, "", registry.getHandlerType(),
            // registry.getReceivers(), synchronize, parameters);
        } else if (handlerType.equals("4")) {// 邮件
            // JMSUtil.sendEmail(user.etipUserID, "", registry.getHandlerType(),
            // registry.getReceivers(), synchronize, parameters);
        } else if (handlerType.equals("5")) {// drools规则
            // Map<String, String> factValues = parameters;
            // if (factValues == null) {
            // factValues = new HashMap<String, String>();
            // }
            // // 以下把user参数添加进去
            // factValues.put("userBaseID", user.userBaseID);
            // factValues.put("userBizRoleID", user.userBizRoleID);
            // factValues.put("etipUserCardNO", user.etipUserCardNO);
            // factValues.put("etipUserID", user.etipUserID);
            //
            // // 取得规则名称
            // String rules = registry.getReceivers();
            // // 获取指定的drools规则，如果没有指定规则，那么记录一个系统日志，直接返回。
            // if (rules == null || rules.trim().length() == 0) {
            // return;
            // }
            // rules = rules.trim();
            //
            // /*
            // * 从事件配置文件中获取规则包，以及事实名称。在配置项中的格式是：[规则包名:事实名]。
            // */
            // StringTokenizer tokens = new StringTokenizer(rules, ",");
            // if (tokens.countTokens() < 2)
            // return;
            //
            // JMSUtil.sendToDrools(tokens.nextToken(), tokens.nextToken(),
            // synchronize, factValues);
        } else if (handlerType.equals("6")) {// 自定义规则
            // JMSUtil.sendToEtipRules(user, registry.getReceivers(),
            // synchronize,
            // parameters);
        }
    }

    public void destroy() {

    }

    public void init() {

    }

}