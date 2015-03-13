<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/mini_top.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${root }/view/css/mini/UserCenter.css" rel="stylesheet" type="text/css" />
<title>流量趋势分析 - 商站宝</title>
</head>
<body style="overflow:auto;">
<div class="head"></div>
<div class="content">
<%@include file="/left.jsp"%> 
<script type="text/javascript" src="${root}/view/js/charts/jquery.1.9.1.min.js"></script>
<script type="text/javascript" src="${root}/view/js/charts/highcharts.js"></script>
<script type="text/javascript" src="${root}/view/js/minipage/front/analysis/pageanalysis.js"></script>
  <div class="UserCenter_Right">
  <div class="DataStatistics_4">
   
    <h1>
	    <c:if test="${empty pageDataName}">
	    <label style="color: red;font-size: px;">未设置名称</label>
	     </c:if>
    		${pageDataName}
    </h1>
    <h2><a href="${root }/page_manage/key/getAllPaga?menuNum=1">返回商站管理</a></h2>
    <ul>
      <li class="marR"><span>累计流量</span>
        <p id="allviewNum"></p>
      </li>
         <li class="marR"><span>近1周流量</span>
        <p id="oneeekviewNum"></p>
      </li>
         <li><span>近24小时流量</span>
        <p id="onlyyesterdayviewNum"></p>
      </li>
    </ul>
  </div>
    <div class="DataStatistics_1">
      <div class="DataStatistics_1Title">
        <h1>流量趋势</h1>
<%--         <h2><a href="${root}/frame/key/topHelp1?help=5&param=help" target="_blank">如何获得更多流量</a></h2> --%>
        <div class="DataStatistics_1Title_r">
          <div class="font_list" id="threeDIV"><a href="###" onclick="findByTime('threemouth','近3个月','1')" class="font_blue">近3个月</a></div>
          <div class="font_list" id="oneDIV"><a href="###" onclick="findByTime('onemouth','近1个月','2')" class="font_blue">近1个月</a></div>
          <div class="font_list_blue" id="oneweekDiv"><a href="###" onclick="findByTime('','近1周','3')" >近1周</a></div>
          <div class="font_list" id="onedayDiv"><a href="###" onclick="findByTime('hour','近一天','4')" class="font_blue">近24小时</a></div>
        <%--   <div class="font_form">自定义时间
            <input type="text" class="input_bg1" id="starttime" value="${starttime }" size="8">  至
            <input type="text" class="input_bg1" id="endtime" value="${endtime}" size="8">
            <input name="" onclick="findByTime();" value="确定" type="button" class="btn_confirm">
          </div> --%>
        </div>
      </div>
      <div class="DataStatistics_1_CL">
        <ul>
          <!--  <li><a href="#" >访客数<span id="visitNum"></span></a></li> -->
           <li><a href="#" class="font_blue"><span id="viewNum"></span><font id="showFont">近1周流量</font></a></li>
          <!-- <li><a href="#" class="font_blue">平均停留时间<span>02:50</span></a><p><font class="center"></font></p></li>
          <li><a href="#" class="font_blue">动作转化率<span>37.12%</span></a><p><font class="bottom"></font></p></li> -->
        </ul>
      </div>
          
      <div class="DataStatistics_1_CR">
<!--         <h1 id="showInfo">近一周数据趋势</h1> -->
<!--         <h2><a href="#" class="font_blue">查看变化趋势</a></h2> -->
        <div id="oneweek"  class="NubTab"></div>
      </div>
     <!--  <div class="DataStatistics_1_CR">
        <h1>按设备分析</h1>
         <h2><a href="#" class="font_blue" id="equipmentpie" onclick="qiehuan();" >查看变化趋势</a></h2>
        <div id="equipment" class="NubTab"></div>
      </div>
      <div class="DataStatistics_1_CR">
        <h1>按地域分析</h1>
         <h2><a href="#" class="font_blue">查看变化趋势</a></h2>
        <div class="NubTab"></div>
      </div>
      <div class="DataStatistics_1_CR">
        <h1>按page分析</h1>
         <h2><a href="#" class="font_blue">查看变化趋势</a></h2>
        <div class="NubTab"></div>
      </div> -->
    </div>
  </div>
</div>
<div class="footer"></div>
</body>
</html>