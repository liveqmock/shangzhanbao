/***
 * list页面选项卡
 * @author 戴黎民
 * @date 2013-8-16
 */
//function nTabs(thisObj,Num){
//	if(thisObj.className == "active")return;
//	var tabObj = thisObj.parentNode.id;
//	var tabList = $('#'+tabObj+' li');
//	for(i=0; i <tabList.length; i++)
//	{
//	  if (i == Num)
//	  {
//	   thisObj.className = "active"; 
//	      $("#"+tabObj+"_Content"+i).show();
//	  }else{
//	   tabList[i].className = "normal"; 
//	   	  $("#"+tabObj+"_Content"+i).hide();
//	  }
//	} 
//	}

$(function(){
	//已开通服务
	$('#yesFinish').click(function(){
		 var form = document.getElementById('myAppsForm');
		 form.action=root+"/my_apps/key/getMyAppsMsg?orderProductData.state=1";
   	     form.submit();
	});
	
	//未开通服务
	$('#noFinish').click(function(){
		 var form = document.getElementById('myAppsForm');
		 form.action=root+"/my_apps/key/getMyAppsMsg?orderProductData.state=0";
   	     form.submit();
	});
	
});
