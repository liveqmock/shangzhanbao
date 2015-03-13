$(function() {
	window.parent.closeBox();
	$("#showBox").click(function(){
		if($("#selectBox",parent.document).is(":hidden")){
			var msgBox = "<div style='margin:0 auto;width:450px;'>"+
			"<font class='createPage_tipInFo_Font'>营销动作是客户浏览页面后的操作，是整个页面的关键。设想一下客户对你的产品感兴趣，却联系不到你，那这个客户就流失了。所以，我们的原则是：<font style='color: #FF3300;'>至少要有一个营销动作。</font></font><br/>"+
			"</div></br>";
			window.parent.showBox(this,msgBox);
		}else{
			window.parent.closeBox();
		}
	});
	subSomething();
});

function subSomething() {
	setTimeout(function() {
		if (parent.frames['frame_main'].document.readyState == "complete") { // 当页面加载状态为完全结束时进入
			parent.frames['frame_main'].addCoverPlate(3);
			$(".Btn_next").removeAttr("disabled");
			$(".Btn_buy", parent.frames['frame_left'].document).removeAttr("disabled");
		} else {
			subSomething();
		}
	}, 200);
}

/**
 * 查看客户留言详情
 */
function selectInfo(){
	window.parent.selectBox();
}