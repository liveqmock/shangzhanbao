<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>MiniPage</title>
<!-- viewport for mobile devices -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" type="text/css" href="css/screen.css" media="screen">
<link rel="stylesheet" type="text/css" href="css/grid.css" media="screen">
<link rel="stylesheet" type="text/css" href="css/normalize.css" media="screen">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/jquery.stellar.min.js"></script>
<script type="text/javascript" src="js/waypoints.min.js"></script>
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
</head>
<body>
<div class="Header">
  <div class="container clearfix">
    <header>
      <a name="logoImage">
      <div id="logo" class="grid_1"><img id="logoImage" src="images/Logo.gif" width="64" height="79"></div>
      </a>
      <div id="nav" class="grid_2">
        <ul class="navigation" id="ul_menu">
        
        <#list nav as data>
          <a name="ul_menu${data_index + 1}">
          <li data-slide="<#if (data_index+1>=7)>7<#else>${data_index+1}</#if>" id="ul_menu${data_index + 1}">${data}</li>
          </a>
         </#list>
         
        </ul>
      </div>
    </header>
  </div>
</div>
<!--导航结束-->
<!--banner-->
<div class="wraper">
  <div id="Banerlider">
    <div class="container clearfix">
      <div class="BanerText grid_4">
      	<a name="div1_title">
        <h2 id="div1_title">${div1_title}</h2>
        </a>
        <a name="div1_content">
        <p class="copy" id="div1_content">${div1_content}</p>
        </a>
        
        <#list banerText as data>
        <div class="BanerText1 bg${data_index+1}">
          <ul>
            <li>服务名称</li>
            <li>原价：1998元/年</li>
            <li>折扣价：16898元/年</li>
            <li><a href="#" class="btn">购 买</a></li>
          </ul>
        </div>
        </#list>
        
      </div>
      <a name="div1_image">
      <img id="div1_image" src="${div1_image}"> </div>
      </a>
  </div>
</div>
<!--banner END-->
<!--slide1 独立卖点-->
<div class="wraper">
  <div id="slide1" class="slide" data-slide="1" data-stellar-background-ratio="0.5">
    <div class="container clearfix latest">
      <div class="one_half TXright">
      	<a name="div2_title">
        <h3 id="div2_title">${div2_title}</h3>
        </a>
        <a name="div2_content">
        <p id="div2_content">${div2_content}</p>
        </a>
      </div>
      <a name="div2_image">
      <div class="one_half lastcolumn"><img id="div2_image" src="${div2_image}"></div>
      </a>
    </div>
    <div class="container clearfix latest">
    <a name="div3_image">
      <div class="one_half lastcolumn"><img id="div3_image" src="${div3_image}"></div>
      </a>
      <div class="one_half TXright">
      <a name="div3_title">
        <h3 id="div3_title">${div3_title}</h3>
        </a>
        <a name="div3_content">
        <p id="div3_content">${div3_content}</p>
          </a>
      </div>
    </div>
    <div class="container clearfix latest">
      <div class="one_half TXright">
      <a name="div4_title">
        <h3 id="div4_title">${div4_title}</h3>
        </a>
        <a name="div4_content">
        <p id="div4_content">${div4_content}</p>
          </a>
      </div>
      <a name="div4_image">
      <div class="one_half lastcolumn"><img id="div4_image" src="${div4_image}"></div>
      </a>
    </div>
    <div class="container clearfix latest">
    <a name="div5_image">
      <div class="one_half lastcolumn"><img id="div5_image" src="${div5_image}"></div>
      </a>
      <div class="one_half TXright">
      <a name="div5_title">
        <h3 id="div5_title">${div5_title}</h3>
        </a>
         <a name="div5_content">
        <p id="div5_content">${div5_content}</p>
          </a>
      </div>
    </div>
  </div>
</div>
<!--产品购买-->
<div class="wraper">
  <div id="slide2" class="slide" data-slide="7" data-stellar-background-ratio="0.5">
    <div class="container clearfix">
      <div class="sepContainer"></div>
       <a name="div6_title">
      <h2 id="div6_title">${div6_title}</h2>
      </a>
      
      <#list buybox as data>
      <div class="one_third rightD">
        <div class="buybox">
        <a name="div6_title${data_index+1}">
          <h3 id="div6_title${data_index+1}">课程一</h3>
          </a>
          <a name="div6_price${data_index+1}">
          <span class="price" id="div6_price${data_index+1}">￥4.99<span>/月</span></span>
          </a>
           <a href="#" title="购买" class="flt-btn flt-btn-orng">购买</a>
          <div class="details">
          <a name="div6_content${data_index+1}">
            <ul id="div6_content${data_index+1}">
              <li><strong>课程内容</strong>测试内容</li>
              <li><strong>课程内容</strong>测试内容</li>
            </ul>
            </a>
          </div>
        </div>
      </div>
      </#list>
      
    </div>
  </div>
</div>
<!--slide3 图文集合-->
<div class="wraper">
  <div id="slide3" class="slide" data-slide="2" data-stellar-background-ratio="0.5">
    <div class="container clearfix">
      <div class="sepContainer"></div>
      <a name="div7_title">
      <h2 id="div7_title">${div7_title}</h2>
      </a>
      
      <#list picText as data>
      <div class="one_third rightD">
        <div class="boxthreeleft">
        <a name="div7_image${data_index+1}"> <img id="div7_image${data_index+1}" src="${data.image}">
        </a>
        <a name="div7_title${data_index+1}">
          <h3 id="div7_title${data_index+1}">${data.title}</h3>
          </a>
          <a name="div7_content${data_index+1}">
          <p id="div7_content${data_index+1}">${data.content}</p>
          </a>
        </div>
      </div>
      </#list>
      
    </div>
  </div>
</div>
<!-- slide4 图片集合-->
<div class="wraper">
  <div id="slide4" class="slide" data-slide="3" data-stellar-background-ratio="0.5">
    <div class="container clearfix">
      <div class="sepContainer"></div>
      <a name="div8_title">
      <h2 id="div8_title">${div8_title}</h2>
      </a>
      
      <#list pic as data>
      <a name="div8_image${data_index+1}">
      <div class="one_sixth"><img id="div8_image${data_index+1}" src="${data}"></div>
      </a>
      </#list>
      
    </div>
  </div>
</div>
<!-- slide5 客户案例--------------客户logo------------>
<div class="wraper">
  <div id="slide5" class="slide" data-slide="4" data-stellar-background-ratio="0.5">
    <div class="container clearfix">
      <div class="sepContainer"></div>
       <a name="div9_title">
      <h2 id="div9_title">${div9_title}</h2>
      </a>
      
      <#list pic2 as data>
      <a name="div9_image${data_index+1}">
      <div class="one_two"><img id="div9_image${data_index+1}" src="${data}"></div>
      </a>
      </#list>
      
    </div>
  </div>
</div>
<!------------- slide6 关于我们------------>
<div class="wraper">
  <div id="slide6" class="slide" data-slide="5" data-stellar-background-ratio="0.5">
    <div class="container clearfix">
      <div class="sepContainer"></div>
      <a name="div10_title">
      <h2 id="div10_title">${div10_title}</h2>
      </a>
      <div class="one_fifth">
       <a name="div10_content">
        <p id="div10_content">${div10_content}</p>
        </a>
      </div>
    </div>
  </div>
</div>
<!--留言板--------------------联系方式----->
<footer id="footer">
  <div class="container clearfix">
    <div id="slide7" class="slide" data-slide="6" data-stellar-background-ratio="0.5">
      <!--留言板-->
      <div class="one_fourth">
        <h4>留言板</h4>
        <form action="" method="get" class="contactForm">
          <input type="text" class="formstyle" title="name" name="name" placeholder="填写姓名" />
          <input type="text" class="formstyle" title="Email" name="email" placeholder="电子邮箱" />
          <textarea name="message" title="Message" class="formstyle" placeholder="填写详细需求"></textarea>
          <input class="formstyletwo" type="submit" value="发布">
        </form>
      </div>
      <!-----关于我们----->
      <div class="one_seven clearfix">
        <h4>联系我们</h4>
        <p><strong>北京天威诚信电子商务服务有限公司(iTrusChina)</strong><br />
          地址：北京市海淀区知春路6号锦秋国际大厦A座 14层（100088）<br />
          电话：010-82800896<br />
          传真：010-82800636<br />
          网址：<a href="http://www.itrus.com.cn/">www.itrus.com.cn</a></p>
      </div>
      <div class="Subscribe grid_3">
        <p>请填写邮箱订阅内容。</p>
        <form action="" method="get">
          <input name="" type="text" class="input_1" placeholder="电子邮箱" >
          <input class="formstyletwo" type="submit" value="订阅">
        </form>
      </div>
    </div>
  </div>
</footer>
</body>
</html>