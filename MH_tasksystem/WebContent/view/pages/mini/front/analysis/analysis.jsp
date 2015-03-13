<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/mini_top.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>MINIPage平台</title>
</head>
<body style="overflow:auto;">
<div class="head"></div>
<div class="content">
<%@include file="/left.jsp"%> 
<script type="text/javascript" src="${root}/view/js/charts/jquery.1.9.1.min.js"></script>
<script type="text/javascript" src="${root}/view/js/charts/highcharts.js"></script>
<script type="text/javascript" src="${root}/view/js/minipage/front/analysis/analysis.js"></script>

  <div class="UserCenter_Right">
    <div class="DataStatistics_1">
      <div class="DataStatistics_1Title">
        <h1>数据分析</h1>
        <div class="DataStatistics_1Title_r">
          <div class="font_list"><a href="###" onclick="findByTime('threemouth','近3个月')" class="font_blue">近3个月</a></div>
          <div class="font_list"><a href="###" onclick="findByTime('onemouth','近1个月')" class="font_blue">近1个月</a></div>
          <div class="font_list"><a href="###" onclick="findByTime('','近1周')" class="font_blue">近1周</a></div>
          <div class="font_list"><a href="###" onclick="findByTime('hour','近1天')" class="font_blue">近1天</a></div>
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
        <h1 id="showInfo">近一周数据趋势</h1>
        <h2><a href="#" class="font_blue">查看变化趋势</a></h2>
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