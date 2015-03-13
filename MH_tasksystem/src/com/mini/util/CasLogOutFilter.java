package com.mini.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.util.ResouceUtil;

/**
 * cas登出拦截
 * @author     [作者]（必须，使用汉语）
 * @see        [相关类/方法]（可选）
 * @since      vmaque2.0
 */
public class CasLogOutFilter implements Filter{

    private FilterConfig filterConfig;
    public static final String fileName = "domain.properties";
    public static final String PATH = ResouceUtil.getProperty(fileName, "caspath");// 读取文件中的路径
    @Override
    public void destroy() {
        
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
            ServletException {
       ((HttpServletRequest)arg0).getSession().invalidate();
       ((HttpServletResponse) arg1).sendRedirect(PATH+"/logout");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        this.filterConfig = filterConfig;
        
    }
   
}
