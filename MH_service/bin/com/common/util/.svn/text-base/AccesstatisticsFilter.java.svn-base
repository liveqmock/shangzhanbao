package com.common.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.kit.exception.ETIPException;

/**
 * @author li
 * 数据分析拦截类
 * @date 2014-3-25
 */
public class AccesstatisticsFilter implements Filter {
    private FilterConfig filterConfig;
    public static final String fileName = "domain.properties";
    public static final String PATH = ResouceUtil.getProperty(fileName, "path");// 读取文件中的路径

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        //暂时注释 勿删
      /*  String wgateid="oXwlNuN8-Y3CiIhplqfhkjiJa_8M";
        String weixinurl = "http://www.weixingate.com/wgate_user.php?wgateid="+wgateid;
        URL url1 = new URL(weixinurl);
        HttpURLConnection urlConnection = (HttpURLConnection) url1.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine = in.readLine().toString();
        inputLine= new String(inputLine.getBytes(),"utf-8");
        System.out.println(inputLine);*/
    
//        String local = ((HttpServletRequest) servletRequest).getServerName();
//        System.out.println(local+"------------------------------------------this is localname");
        /*
         * 修改人：文东 修改时间：2014/06/23 下午6点 修改内容：此拦截器只针对pagehtml 目录下的html 页面
         */
//        if (local.indexOf("vmaque.com") < 0){//如果访问的路径不是以vmaque的域名访问的
//            //则取数据库查看是否存在该独立域名
//            if(!"".equals(AccPageUtil.checkLocal(local))){
//                uri = AccPageUtil.checkLocal(local);
//            }
//            //如果存在，则把文件的地址拼接在独立域名后面给用户访问
//        }
        if (uri.indexOf("/pagehtml/") < 0) {
            chain.doFilter(servletRequest, servletResponse);// 若访问的该页面不属于pagehtml目录下。则直接跳过该拦截器
            return;
        }
        /* 文东修改结束 */

        String url = uri.substring(uri.indexOf("/pagehtml/") + 10); // 截取URL 如‘9999.html’
        String ip = AccesstatisticsFilter.getRemortIP(((HttpServletRequest) servletRequest)); // 获取到ip
        String b = "";
        if (uri.startsWith("/pagehtml") || uri.startsWith("//pagehtml")) { // 如果地址是由 "/pagehtml" 就执行以下方法添加数据， 不是就拦截

            // 获取当前访问的page的域名是否可以访问
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            // 获取用户信息
            FrmUser user = null;
            String userid = "";
            try {
                user = getFrmUser(httpRequest);

            } catch (Exception e) {

            }
            if (user != null) {
                // 获取用户id
                userid = user.etipUserID;

            }
            // 判断page是否可以访问
            b = AccPageUtil.checkPage(userid, url);
        }
        if (b != null) {
            if (b.equals("1")) {
                // 可以访问
                // 入库
                // String accesstatisticsName=PATH+url;//只存名称不存路径
                AccesstatisticsUtil.sendDBLog(ip, url, true);
                chain.doFilter(servletRequest, servletResponse);
            } else if (b.equals("0")) {
                ((HttpServletResponse) servletResponse).sendRedirect("/lanjie.jsp");// 重定向到new.jsp
            } else if (b.equals("2")) { // 禁用页面
                ((HttpServletResponse) servletResponse).sendRedirect("/disablePage.jsp");// 重定向到禁用页面
            } else if (b.equals("3")) { // 禁用页面
                ((HttpServletResponse) servletResponse).sendRedirect("/expiredJsp.jsp");// 重定向到禁用页面
            }else {
                chain.doFilter(servletRequest, servletResponse);
            }
        }

    }

    /**
     * 从acegi容器中获取用户身份信息，可能存在session的问题。
     * 
     * @return frmUser.
     */
    private FrmUser getFrmUser(HttpServletRequest request) {
        FrmUser frmUser = null;
        if (request.getSession().getAttribute("ETIP_FRAME_USER") != null) {
            frmUser = (FrmUser) request.getSession().getAttribute("ETIP_FRAME_USER");
        } else {
            frmUser = FrmUser.getUser();
        }

        if (frmUser == null || frmUser.etipUserID == null || frmUser.etipUserID.equals("")) {
            throw new ETIPException("NoSession");
        }
        return frmUser;
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
        System.out.println("销毁了");
    }

    /**
     * 获取ip
     * 
     * @param request
     * @return
     */
    public static String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

}
