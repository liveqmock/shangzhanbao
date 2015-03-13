<%@ page language='java' pageEncoding='utf-8'%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>商站宝</title>
<link rel="stylesheet" type="text/css" href="/view/model/css/screen.css" media="screen">
<link rel="stylesheet" type="text/css" href="/view/model/css/grid.css" media="screen">
<link rel="stylesheet" type="text/css" href="/view/model/css/normalize.css" media="screen">
<link rel="stylesheet" type="text/css" href="/view/css/mini/purchase/payFor.css">
<link rel="stylesheet" type="text/css" href="/view/css/bombBox/bombBox.css" />
<link rel="stylesheet" href="/view/uploadImgDemo/css/jquery.Jcrop.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="/view/css/uploadBtn/upload-btn.css">
<link rel="stylesheet" type="text/css" href="/view/uploadImgDemo/css/uploadImg.css">
<script type="text/javascript" src="/view/easyUI/jquery1.7.1/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="/view/uploadImgDemo/js/jquery.Jcrop.min.js"></script>
<script type="text/javascript" src="/view/js/bombBox/bombBoxUtil.js"></script>
<script type="text/javascript" src="/view/js/product/ajaxfileupload.js"></script>
<script type="text/javascript" src="/view/uploadImgDemo/js/uploadImg.js"></script>
<script type="text/javascript" src="/view/js/purchase/area.js"></script>
<script type="text/javascript" src="/view/js/purchase/payFor.js"></script>
<script src="/view/js/temp2/temp.js"></script>
<script src="/view/js/temp2/goumai.js"></script>
</head>
<body>
<input type="hidden" id="objectRoot" value="">
<input type="hidden" id="cssType" value="1">

<div class="wraper">
  <div id="daohang">
    <div class="container clearfix">
      <div class="top"> <a id="menu_btn" href="javascript:;">≡</a>
        <div class="line_logo  logo update" line-data="图片"> <img id="logoImage" src="/file/logo-movecity.png">
          <input id="" type="hidden" class="component" name="" value="ff8080814618b95b014618bbcaa20010">
        </div>
          <div id="phone" class="update" align="right" style=" ">400-000-0000</div>
        <div class="nav">
          <ul class="navigate">
            <li><a href="javascript:;" onclick="getMaodian('nav_0')">
              <lable id="first_navigate" style="">首页</lable>
              </a></li>
            <li class="nav1"><a href="javascript:;" onclick="getMaodian('nav1')">
              <lable id="graphic_navigate" class="navName" style="">服务介绍</lable>
              </a></li>
            <li class="nav7"><a href="javascript:;" onclick="getMaodian('nav7')">
              <lable id="leftPicscri_navigate" class="navName" style="">关于收费</lable>
              </a></li>
            <li class="nav4"><a href="javascript:;" onclick="getMaodian('nav4')">
              <lable id="about_navigate" class="navName" style="">温馨小提醒</lable>
              </a></li>
            <li class="nav9"><a href="javascript:;" onclick="getMaodian('nav9')">
              <lable id="wen_navigate" class="navName" style="">联系我们</lable>
              </a></li>
            <li class="nav8"><a href="javascript:;" onclick="getMaodian('nav8')">
              <lable id="graphic2_navigate" class="navName" style="">车辆展示</lable>
              </a></li>
          </ul>
        </div>
        
      </div>
    </div>
  </div>
</div>
<!--导航结束-->
<div class="wraper">
<a id="nav_0"></a>
  <div id="Banerlider">
    <div class="container clearfix update">
      <div class="BanerText grid_4">
        <div class="line_banner" line-data="广告语">
        <span id="banner_slogan">告诉我地址，剩下的事情就交给我们</span>
        </div>
        <div class="line_banner copy" id="line_content" line-data="简介" style=""><span>(请在这里输入详细描述信息，将鼠标移入时，会显示“修改”两个字，点击修改后，即可在左侧填写响应的描述)</span></div>
      </div>
      <div id="banner_imgDiv" class="line_banner" line-data="图片">
      <img id="banner_img"  data-original src="/file/1400660802650.png"/></div>
      <input type="hidden" id="" class="component" name="" value="ff808081461c6aa601461c78854d0015">
    </div>
  </div>
</div>


<div class="wraper">
  <div id="slide1" style="">
    <div id="reason_div" class="container clearfix latest update">
        <div class="line_onehalfimg one_half lastcolumn" line-data="图片">
      		<img style="opacity:30" id="reason_img1" src="/file/1400661458698.jpg" data-original="">
      	</div>
     	<div class="one_half TXright">
       	 <div class="line_onehalf title" line-data="标题"><span id="reason_title1" style="">2小时内到达</span></div>
        <div class="line_onehalf content" line-data="简介">
          <span id="reason_content1" style="">（请在这里输入详细描述信息，将鼠标移入时，会显示“修改”两个字，点击修改后，即可在左侧填写响应的描述）</span>
        </div>
      </div>
      <div class="xuxian" style="display:none"></div>
      <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618bffb67001f">
    </div>
    <div id="reason_div" class="container clearfix latest update">
      <div class="one_half1 TXright1">
       <div class="line_onehalf title1" line-data="标题"><span id="reason_title2" style="">专业车队</span></div>
        <div class="line_onehalf content1" line-data="简介">
          <span id="reason_content2" style="">（请在这里输入详细描述信息，将鼠标移入时，会显示“修改”两个字，点击修改后，即可在左侧填写响应的描述）</span>
        </div>
      </div>
       <div class="line_onehalfimg1 one_halfimg lastcolumn" line-data="图片">
        <img id="reason_img2" src="/file/1400661842155.jpg" data-original="" style="display: inline;">
       </div>
          <div class="xuxian" style="display:none"></div>
      <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618be4a04001a">
    </div>
    <div id="reason_div" class="container clearfix latest update">
      <div class="line_onehalfimg one_half lastcolumn" line-data="图片">
       <img id="reason_img3" src="/file/1400661989096.jpg" data-original="" style="display: inline;">
       </div>
      <div class="one_half TXright">
        <div class="line_onehalf title" line-data="标题"><span id="reason_title3" style="">服务到家</span></div>
          <div class="line_onehalf content" line-data="简介">
          <span id="reason_content3" style="">（请在这里输入详细描述信息，将鼠标移入时，会显示“修改”两个字，点击修改后，即可在左侧填写响应的描述）</span>
        </div>
      </div>
         <div class="xuxian" style="display:none"></div>
      <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618bffb67001f">
    </div>
    <button copy="copyComp" class="Btn_Td" onclick="copyComp('',this)" style="display: none;">添加</button>
  </div>
</div>
<div class="wraper">
  <div id="slide2" style="">
    <div class="container clearfix">
      <div class="sepContainer"></div>
      <div class="clear"></div>
      <a id="nav1">
      <h2>
        <lable id="graphic_navigate">服务介绍</lable>
      </h2>
      </a>
      <div class="one_third rightD update">
        <div class="boxthreeleft">
          <div class="line_rightD upImgDiv"  line-data="图片">
           <img id="graphic_img" src="/file/1400662919696.jpg" data-original="" style="display: inline;">
          </div>
          <div class="line_rightD title" line-data="标题">
           <span id="graphic_title"  style="">家庭搬家</span>
          </div>
          <div id="graphic_content" class="line_rightD ellipsis content" line-data="简介">
           <span>（请在这里输入详细描述信息，将鼠标移入时，会显示“修改”两个字，点击修改后，即可在左侧填写响应的描述）</span>
          </div>
        </div>
        <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618c2c2230029">
      </div>
      <div class="one_third rightD update">
        <div class="boxthreeleft">
         <div class="line_rightD upImgDiv"  line-data="图片">
          <img id="graphic_img2" src="/file/1400662957829.jpg" data-original="" style="display: inline;">
         </div>
         <div class="line_rightD title" line-data="标题">
          <span id="graphic_title2"  >企业搬迁</span>
         </div>
         <div id="graphic_content" class="line_rightD  content" line-data="简介">
          <span>（请在这里输入详细描述信息，将鼠标移入时，会显示“修改”两个字，点击修改后，即可在左侧填写响应的描述）</span>
         </div>
        </div>
        <input type="hidden" id="" class="component"  value="ff8080814618b95b014618c2c2230029">
      </div>
      <div class="one_third rightD update">
        <div class="boxthreeleft">
         <div class="line_rightD upImgDiv"  line-data="图片">
          <img id="graphic_img3" src="/file/1400663036000.jpg" data-original="" style="display: inline;">
         </div>
         <div class="line_rightD title" line-data="标题">
          <span id="graphic_title3"  >大型设备</span>
         </div>
         <div id="graphic_content" class="line_rightD ellipsis content" line-data="简介">
          <span>（请在这里输入详细描述信息，将鼠标移入时，会显示“修改”两个字，点击修改后，即可在左侧填写响应的描述）</span>
         </div>
        </div>
        <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618c2c2230029">
      </div>
    </div>
    <button copy="copyComp" class="Btn_Td" onclick="copyComp('ff8080814618b95b014618c2c2230029',this)" style="display: none;">添加</button>
  </div>
</div>
<div class="wraper">
  <div id="slide1" style="">
    <div class="container clearfix ">
      <div class="sepContainer"></div>
      <a id="nav7">
      <h2>
        <lable id="leftPicscri_navigate">关于收费</lable>
      </h2>
      </a>
      <div class="container clearfix latest update">
        <div class="line_onehalfimg   one_half lastcolumn" line-data="图片">
        <img id="leftPicscri_img" src="/file/1400664874679.jpg" data-original="" style="display: inline;">
         </div>
        
        <div class="one_half TXright">
         <div class="line_onehalf title" line-data="标题"><span id="leftPicscri_title" style="">小型家庭搬迁</span></div>
         <div class="line_onehalf content" line-data="简介">
            <span id="leftPicscri_content" style="">
                                      四环外起步价：400元<br>
		              四环内起步价：300元<br>
		              二环内起步价：180元</span>
          </div>
        </div>
           <div class="xuxian" style="display:none"></div>
        <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618c5a3e28231">
      </div>
      <div class="container clearfix latest update">
        <div class="line_onehalfimg   one_half lastcolumn" line-data="图片">
          <img id="leftPicscri_img3" src="/file/1400667525918.jpg" data-original="" style="display: inline;">
        </div>
        <div class="one_half TXright">
          <div class="line_onehalf title" line-data="标题"><span id="leftPicscri_title3" style="">企业级搬迁</span></div>
          <div class="line_onehalf content" line-data="简介">
            <span id="leftPicscri_content3" style="">
			            一车：1280元<br>
			              二车：2300元<br>
			              三车：3000元<br>
			              四车以上请电话咨询
              </span>
          </div>
        </div>
           <div class="xuxian" style="display:none"></div>
        <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618c5a3e28231">
      </div>
      <div class="container clearfix latest update">
        <div class="line_onehalfimg   one_half lastcolumn" line-data="图片">
         <img id="leftPicscri_img4" src="/file/1400667572904.jpg" data-original="" style="display: inline;">
        </div>
        <div class="one_half TXright">
          <div class="line_onehalf title" line-data="标题"><span id="leftPicscri_title4" style="">大型设备搬迁</span></div>
          <div class="line_onehalf content" line-data="简介">
            <span id="leftPicscri_content4" style="">请电话咨询：400-000-0000</span>
          </div>
        </div>
           <div class="xuxian" style="display:none"></div>
        <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618c5a3e28231">
      </div>
    </div>
     <button copy="copyComp" class="Btn_Td" onclick="copyComp('ff8080814618b95b014618c5a3e28231',this)" style="display: none;">添加</button>
  </div>
</div>
<div class="wraper">
  <div id="slide5" style="">
    <div class="container clearfix">
      <div class="sepContainer"></div>
      <div class="clear"></div>
      <a id="nav4">
      <h2>
        <lable id="about_navigate">温馨小提醒</lable>
      </h2>
      </a>
      <div class="one_fifth update">
        <div class="line_fifth content" line-data="简介">
          <span id="about_content" style="">1. 列一个清单<br>
            （请在这里输入详细描述信息，将鼠标移入时，会显示“修改”两个字，点击修改后，即可在左侧填写响应的描述）<br>
            <br>
            2. 还需要什么工具<br>
            （请在这里输入详细描述信息，将鼠标移入时，会显示“修改”两个字，点击修改后，即可在左侧填写响应的描述）<br>
            <br>
            3. 利用衣柜、现有的盒子<br>
            （请在这里输入详细描述信息，将鼠标移入时，会显示“修改”两个字，点击修改后，即可在左侧填写响应的描述）<br>
            <br>
            4. 指定一个摆放策略，利用好衣柜、盒子这些<br>
            （请在这里输入详细描述信息，将鼠标移入时，会显示“修改”两个字，点击修改后，即可在左侧填写响应的描述）<br>
            <br>
            5. 以有颜色的便签来做标记<br>
            （请在这里输入详细描述信息，将鼠标移入时，会显示“修改”两个字，点击修改后，即可在左侧填写响应的描述）</span>
        </div>
        <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618c6a7270035">
      </div>
    </div>
  </div>
</div>
<div class="wraper">
  <div id="slide1">
    <div class="container clearfix">
      <div class="sepContainer"></div>
      <a id="nav9">
      <h2>
        <lable id="wen_navigate">联系我们</lable>
      </h2>
      </a>
      <div class="container clearfix update">
        <div class="one_half1 TXright1">
           <div class="line_onehalf title1" line-data="标题"><span id="rightPicscriHave_title" style="">北京同城搬家公司</span></div>
             <div class="line_onehalf content1" line-data="简介">
            <span id="rightPicscriHave_content" style="">（请在这里输入详细描述信息，将鼠标移入时，会显示“修改”两个字，点击修改后，即可在左侧填写相应的描述。请在这里输入详细描述信息，将鼠标移入时，会显示“修改”两个字，点击修改后，即可在左侧填写相应的描述。）</span>
          </div>
        </div>
       <div class="line_onehalfimg1 one_halfimg lastcolumn"  line-data="图片">
         <img id="rightPicscriHave_img" src="/file/1400727899968.jpg" data-original="" style="display: inline;">
         </div>
            <div class="xuxian" style="display:none"></div>
        <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618c5a3e28952">
      </div>
    </div>
  </div>
</div>
<div class="wraper">
  <div id="slide2" style="">
    <div class="container clearfix">
      <div class="sepContainer"></div>
      <div class="clear"></div>
      <a id="nav8">
      <h2>
        <lable id="graphic2_navigate">车辆展示</lable>
      </h2>
      </a>
      <div class="one_third rightD update">
        <div class="boxthreeleft">
          <div class="line_rightD upImgDiv"  line-data="图片">
          <img id="wen_img1" src="/file/1400669733055.jpg" data-original="" style="display: inline;">
          </div>
          <div class="line_rightD title" line-data="标题"><span id="wen_title1"  style="">1.5吨封闭厢式货车</span></div>
          <div id="wen_content1" class="line_rightD  content"  line-data="简介">
          	<span>
			          载重量：2吨<br>
			            车厢尺寸：长=4.2米 宽=1.8米 高=1.85米
			      </span>
		      </div>
        </div>
        <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618c5a3e28qwe">
      </div>
      <div class="one_third rightD update">
        <div class="boxthreeleft">
           <div class="line_rightD upImgDiv"  line-data="图片">
             <img id="wen_img2" src="/file/1400669733055.jpg" data-original="" style="display: inline;">
             </div>
            <div class="line_rightD title" line-data="标题">
            <span id="wen_title2"  style="">1041敞篷车</span></div>
          <div id="wen_content1" class="line_rightD  content" line-data="简介">
          	<span>
          		载重量：1.5吨<br>
           		 车厢尺寸：长=4.2米 宽=1.8米
            </span>
            </div>
          </div>
        <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618c5a3e28qwe">
      </div>
      <div class="one_third rightD update">
        <div class="boxthreeleft">
         <div class="line_rightD upImgDiv"  line-data="图片">
           <img id="wen_img3" src="/file/1400669733055.jpg" data-original="" style="display: inline;">
           </div>
              <div class="line_rightD title" line-data="标题">
              <span id="wen_title3"  >东风多利卡（封闭厢式货车）</span>
              </div>
          <div id="wen_content1" class="line_rightD  content" line-data="简介">
           <span>     
                  载重量：3吨 (带起重装置)<br>
                    车厢尺寸：长=5.5米 宽=2.0米 高=2.1米
            </span>  
            </div>
          </div>
        <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618c5a3e28qwe">
      </div>
      <div class="one_third rightD update">
        <div class="boxthreeleft"> 
           <div class="line_rightD upImgDiv"  line-data="图片">
           <img id="wen_img4" src="/file/1400669947165.jpg" data-original="" style="display: inline;">
             </div>
          <div class="line_rightD title" line-data="标题">
            <span id="wen_title4"  >金杯车</span>
          </div>
          </a> <a name="wen_content4">
          <div id="wen_content1" class="line_rightD  content" line-data="简介">
               <span>       
                  载重量：12吨
          </span>
          </div>
          </a> </div>
        <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618c5a3e28qwe">
      </div>
      <div class="one_third rightD update">
        <div class="boxthreeleft">
          <div class="line_rightD upImgDiv"  line-data="图片">
            <img id="wen_img5" src="/file/1400669982492.jpg" data-original="" style="display: inline;">
            </div>
            <div class="line_rightD title" line-data="标题">
            <span id="wen_title5" >叉车</span>
          </div>
            <div id="wen_content1" class="line_rightD  content" line-data="简介">
		   	<span>       
		   	1吨-1.5吨
		   	</span>
		   	</div>
          </div>
        <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618c5a3e28qwe">
      </div>
      <div class="one_third rightD update">
        <div class="boxthreeleft">
          <div class="line_rightD upImgDiv"  line-data="图片">
           <img id="wen_img6" src="/file/1400670005855.jpg" data-original="" style="display: inline;">
            </div>
           <div class="line_rightD title" line-data="标题">
            <span id="wen_title6" >地牛</span>
          </div>
 			<div id="graphic_content" class="line_rightD  content" line-data="简介">
		   	<span>
		   	1吨
		   	</span>
		   	</div>
          </div>
        <input type="hidden" id="" class="component" name="" value="ff8080814618b95b014618c5a3e28qwe">
      </div>
      
    </div>
    <button copy="copyComp" class="Btn_Td" onclick="copyComp('ff8080814618b95b014618c5a3e28qwe',this)" style="display: none;">添加</button>
  </div>
</div>
<div id="messageBoardDiv" style="width:100%;"></div>
<%@include file="/temp_end.jsp"%>
</body>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            