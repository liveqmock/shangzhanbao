<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>

<%@ page language="java" pageEncoding="utf-8"%>
<%@ page contentType="application/msword" %> 
<%@include file="/baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:x="urn:schemas-microsoft-com:office:office">
<head>
<%
		String time = null;
		String name="用户认证信息";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		time = dateFormat.format(Calendar.getInstance().getTime());
		response.addHeader("Content-Disposition",
				"attachment;filename=\""+new String((name+time+".xls").getBytes("GBK"),"ISO8859_1")+ "\" ");
%>
</head>

<body>

	<center>

				<span  align="left" style="font-size: 23px; font-weight:bold  ;border-color: #00CED1 ;height: 50px;text-align:left;">用户认证信息</span>
					
		<table cellpadding="0" border="1"
			style="border-color: black; border-collapse: collapse; border-style: solid; width: 100%; height: 100%; font-size: 14px; text-align: center;">
		
			<tr>
				<td  width="140" style="height:20px;background-color:deepskyblue; "><span class="right">公司名称： </span></td>
				<td  width="140" style="height:20px;background-color:deepskyblue; "><span class="right">网站名称： </span></td>
				<td  width="140" style="height:20px;background-color:deepskyblue; "><span class="right">网站域名：</span></td>
				<td  width="140" style="height:20px;background-color:deepskyblue; "><span class="right">网站备案号：</span></td>
				<td  width="140" style="height:20px;background-color:deepskyblue; "><span class="right">备案时间：</span></td>
				<td  width="140" style="height:20px;background-color:deepskyblue; "><span class="right">IP地址：</span></td>
				<td  width="140" style="height:20px;background-color:deepskyblue; "><span class="right">联系人：</span></td>
				<td  width="140" style="height:20px;background-color:deepskyblue; "><span class="right">手机： </span></td>
				<td  width="140" style="height:20px;background-color:deepskyblue; "><span class="right">座机：</span></td>
				<td  width="140" style="height:20px;background-color:deepskyblue; "><span class="right">邮箱： </span></td>
	        	<td width="140" style="height:20px;background-color:deepskyblue; "><span class="right">工商注册号：</span></td>
				<td width="140" style="height:20px;background-color:deepskyblue; "><span class="right">住所： </span></td>
				<td width="140" style="height:20px;background-color:deepskyblue; "><span class="right">法定代表人：</span></td>
				<td width="140" style="height:20px;background-color:deepskyblue; "><span class="right">注册资本： </span></td>
				<td width="140" style="height:20px;background-color:deepskyblue; "><span class="right">公司类型：</span></td>
				<td width="300" style="height:20px;background-color:deepskyblue; "><span class="right">营业期限： </span></td>
				<td width="140" style="height:20px;background-color:deepskyblue; "><span class="right">经营范围：</span></td>
			</tr>
				<tr style="height: 30px;">
				<td width="400"><span class="left">${orderData.businessUserData.companyChName}</span></td>
				<td width="400"><span class="left">${orderData.businessUserData.webName}</span></td>
				<td><span class="left">${orderData.businessUserData.domainName}</span></td>
				<td><span class="left">${orderData.businessUserData.icp}</span></td>
				<td><span class="left">${orderData.businessUserData.icpTime}</span></td>
				<td><span class="left">${orderData.businessUserData.ipAddr}</span></td>
				<td><span class="left">${orderData.businessUserData.linkManName}</span></td>
				<td><span class="left">${orderData.businessUserData.linkManMoble}</span></td>
				<td><span class="left">${orderData.businessUserData.hrPhone}</span></td>
				<td><span class="left">${orderData.businessUserData.linkManMail}</span></td>
			
			
			 
	          <td><span class="left">${orderData.businessUserData.gszch}</span></td>
	         
	          <td><span class="left">${orderData.businessUserData.addr}</span></td>
	    
	          <td><span class="left">${orderData.businessUserData.fddbr}</span></td>
	          
	          <td><span class="left">${orderData.businessUserData.zczb}</span></td>
	       
	          <td><span class="left">${orderData.businessUserData.gslx}</span></td>
	         
	          <td><span class="left">  
	       
	              <fmt:formatDate value="${orderData.businessUserData.yyqxBegin}" type="date"/>
	               <c:if test="${orderData.businessUserData.yyqxBegin!=null}">
	              至 
	              </c:if>
	              <fmt:formatDate value="${orderData.businessUserData.yyqxEnd}" type="date"/></span></td>
	       
	          <td><span class="left">${orderData.businessUserData.jyfw}</span></td>
	        
	        </tr>
			
</table>

	</center>

</body>
</html>