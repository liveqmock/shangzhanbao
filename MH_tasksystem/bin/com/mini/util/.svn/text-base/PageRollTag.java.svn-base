/**
 * com.gomai.common.util
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2012-12-6 		何大勇
 *
 * Copyright (c) 2012, gomai.
*/
/**
 * com.gomai.common.util
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2012-12-6 何大勇
 *
 * Copyright (c) 2012, gomai
*/


package com.mini.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.itour.etip.pub.frame.PageRoll;

/**
 * @author   何大勇
 * @version  
 * @Date	 2012-12-6 下午5:31:02
 */

public class PageRollTag extends TagSupport {

	/**
	 *
	 */
	
	private static final long serialVersionUID = 8603551425853916121L;

	public int doStartTag() throws JspException {    
	    try {
	      JspWriter out = pageContext.getOut();
	      HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
	      PageRoll pageRoll = (PageRoll)pageContext.getAttribute("pageRoll");
	      StringBuffer pageRollText = new StringBuffer();
	      int currentPage = pageRoll.getCurrentPage();
	      int totalRows = pageRoll.getTotalRows();
	      int pageSize = pageRoll.getPageSize();
	      int totalPage = totalRows/pageSize;
	      if(totalRows%pageSize!=0||totalPage==0){
	    	  totalPage++;
	      }
	      String more = "<li><span>...</span></li>";
	      
    	  pageRollText.append( 
			    	"<div style=\"clear:both\"></div><div style=\"margin-left: 20px;\"  class=\"pagination \">" ).append( 
		    			"<ul>").append( 
							"<li><span>共 <font color=\"red\">").append( totalRows).append( "</font> 条记录</span></li>").append( 
							"<li><span>当前 <font color=\"red\">").append( (currentPage+1)).append( "</font> / <font color=\"red\">").append( totalPage).append( "</font> 页</span></li>").append( 
						"</ul>");
    	  
    	  pageRollText .append( 
    			  "<input type='hidden' name='pageRoll.currentPage' class='pageRollHidden' value='0' data-value='").append( currentPage).append( "'>" ).append( 
    					  "<ul>" );
    	  if(currentPage>3){
    		  pageRollText .append(  "<li ").append( (currentPage==0?"class='disabled'><a>":"><a href='javascript:void(0)' onclick='$(this).closest(\"form\").find(\"input.pageRollHidden\").val(0);$(this).closest(\"form\").submit();'>")).append( 1).append( "</a></li>");
    	  }
    	  
			    			
    	  int j=0;
    	  if(currentPage>=4){
    		  j=currentPage-3;
    	  }
    	  if(j>1){
    		  pageRollText.append( more);
    	  }
    	  
    	  while(j<totalPage&&j<=currentPage+3){
    		  pageRollText.append("<li "+(currentPage==j?"class='active'><a>":"><a href='javascript:void(0)' onclick='$(this).closest(\"form\").find(\"input.pageRollHidden\").val("+j+");$(this).closest(\"form\").submit();'>")).append( (j+1)).append( "</a></li>");	
    		  j++;
    	  }

    	  if(currentPage<totalPage-2 && j<totalPage-1){
    		  pageRollText .append( more);
    	  }
    	  if(currentPage<totalPage-4){
    		  pageRollText.append( "<li ").append( (currentPage==totalPage-1?"class='disabled'><a>":"><a href='javascript:void(0)' onclick='$(this).closest(\"form\").find(\"input.pageRollHidden\").val("+(totalPage-1)+");$(this).closest(\"form\").submit();'>")).append( totalPage).append( "</a></li>");
    		  
    	  }
    	  pageRollText .append("</ul>");
    	  pageRollText .append(
							"<ul >").append( 
								"<li><span>转到</span></li>").append( 
								"<li><span curr=\"").append( (currentPage+1)).append( "\" contentEditable=\"true\" onblur=\"if((parseInt(this.innerHTML)+'')=='NaN') this.innerHTML=this.getAttribute('curr'); $(this).closest('form').find('input.pageRollHidden').val(this.innerHTML-1);\" onkeyup=\"this.innerHTML = parseInt(this.innerHTML);if(this.innerHTML=='NaN' || this.innerHTML=='0') {this.innerHTML='';return;};if(parseInt(this.innerHTML)>parseInt(this.getAttribute('max'))){this.innerHTML=this.getAttribute('max');} $(this).closest('form').find('input.pageRollHidden').val(this.innerHTML-1);\" max=\"").append( totalPage).append( "\" class=\"currPageText\">").append( (currentPage+1)).append( "</span></li>").append( 
								"<li><a onclick=\"$(this).closest('form').find('input.pageRollHidden').val(parseInt($(this).closest('form').find('.currPageText').html())-1);$(this).closest('form').submit();\">确定</a></li>"+
							"</ul>").append( 
						  "</div>");	
    	  pageRollText.append("<script type=\"text/javascript\" src=\"").append( request.getContextPath()).append( "/view/js/common/pageRoll.js\"></script>");
	      out.print(pageRollText);
	    } catch (java.io.IOException e) {
	      throw new JspTagException(e.getMessage());
	    }
	    
	    return SKIP_BODY;
	  }
}

