/**
 * com.gomai.person.tutor.tag
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2012-12-26 	王启乾
 *
 * Copyright (c) 2012, gomai
 */

package com.mini.util;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.common.util.FileUpload;
import com.common.util.UploadPath;

/**
 * 读取研究方向的详情写到页面
 * 
 * @author 王启乾
 * @version
 * @Date 2012 2012-12-26 上午10:29:18
 */

public class ReadDetailed extends TagSupport {
    private static final long serialVersionUID = 1L;

    private String path;

    @Override
    public int doStartTag() throws JspException {
        StringBuffer html = new StringBuffer();
        try {
            html.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            String[] str = path.split("/");
            String basepath = UploadPath.getPath(str[0]);
            path = path.replace(str[0], basepath);
            html.append(FileUpload.readFile(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JspWriter out = pageContext.getOut();
        try {
            out.write(html.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
