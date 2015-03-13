/*******************************************************************************
 * @author txc
 * @date 2009-5-29
 * @version 1.0
 ******************************************************************************/

 function ETIPPageBar(){
 	this.hasNextPage = false;
 	this.hasPrePage = false;
 	this.start = 0;
 	this.pageSize = 3;
 	this.totalPage = 0;
 	this.curPage = 0;
 	this.totalRows = 0;
 	this.searchCondition = null;
 	this.setHasNextPage = function(e){
 		this.hasNextPage = e;
 	}
 	this.isHasNextPage = function(){
 		return this.hasNextPage;
 	}
 	this.setHasPrePage = function(e){
 		this.hasPrePage = e;
 	}
 	this.isHasPrePage = function(e){
 		return this.hasPrePage;
 	}
 	this.setStart = function(e){
 		if(e<0){
			this.start = 0; 		
 		}
 		this.start = e;
 	}
 	this.getStart = function(){
 		return this.start;
 	}
 	this.setPageSize = function(e){
 		this.pageSize = e;
 	}
 	this.getPageSize = function(){
 		return this.pageSize;
 	}
 	this.setTotalPage = function(e){
 		this.totalPage = e;
 			if(this.curPage>=this.totalPage){
 				this.setCurPage(this.totalPage);
 			}else if(this.curPage<=0 && this.totalPage>=0){
 				this.setCurPage(1);
 			}
 	}
 	this.getTotalPage = function(){
 		return this.totalPage;
 	}
 	this.setCurPage = function(e){
 		this.curPage = e;
 		if(this.curPage<this.totalPage){
 			this.setHasNextPage(true);
 		}else{
 			this.setHasNextPage(false);
 		}
 		if(this.curPage>1){
 			this.setHasPrePage(true);
 		}else{
 			this.setHasPrePage(false);
 		}
 		
 		
 		if(this.pageSize<=0){
 			this.setStart(0);
 		}else{
 			this.setStart((this.curPage-1)*this.pageSize);
 		}
 	}
 	this.getCurPage = function(){
 		return this.curPage;
 	}
 	this.setTotalRows = function(e){
 		this.totalRows = e;
 		if(this.totalRows<=this.pageSize){
 			this.setTotalPage(1);
 			this.romancePageDiv();
 		}else{
 			this.setTotalPage(parseInt((this.totalRows+this.pageSize-1)/this.pageSize));
 			this.romancePageDiv();
 		}
 	}
 	this.getTotalRows = function(){
 		return this.totalRows;
 	}
 	this.setSearchCondition = function(e){
 		this.searchCondition = e;
 	}
 	this.getSearchCondition = function(){
 		return this.searchCondition;
 	}
 	
 	this.romancePageDiv = function(){
 		
 		if(this.hasPrePage){
 			$("a[firstPage=true]").show();
 			$("a[prePage=true]").show();
 		}else{
 			$("a[firstPage=true]").hide();
 			$("a[prePage=true]").hide();
 		}
 		
 		if(this.hasNextPage){
 			$("a[nextPage=true]").show();
 			$("a[lastPage=true]").show();
 		}else{
 			$("a[nextPage=true]").hide();
 			$("a[lastPage=true]").hide();
 		}
 		
 		var curPageArr = $("span[curPage=true]");
 		for(var i=0;i<curPageArr.length;i++){
 			curPageArr[i].innerHTML = this.curPage;
 		}
 		var totalPageArr = $("span[totalPage=true]");
 		for(var j=0;j<totalPageArr.length;j++){
 			totalPageArr[j].innerHTML = this.totalPage;
 		}
 		var totalRowsArr = $("span[totalRows=true]");
 		for(var k=0;k<totalRowsArr.length;k++){
 			totalRowsArr[k].innerHTML = this.totalRows;
 		}
 		var psArr = $("span[pageSize=true]");
 		for(var l=0;l<totalRowsArr.length;l++){
 			psArr[l].innerHTML = this.pageSize;
 		}
 	}
 	
 	this.rollAction = function(action){
 		if(action == 'first'){
 			this.setCurPage(1);
 			submitSearchForm(true);
 			this.romancePageDiv();
 		}
 		else if(action == 'pre'){
 			if(this.curPage>1){
 				this.setCurPage(this.curPage-1);
 			}
 			submitSearchForm(true);
 			this.romancePageDiv();
 		}
 		else if(action == 'next'){
 			if(this.curPage<this.totalPage){
 				this.setCurPage(this.curPage+1);
 			}
 			submitSearchForm(true);
 			this.romancePageDiv();
 		}
 		else if(action == 'last'){
 			this.setCurPage(this.totalPage);
 			submitSearchForm(true);
 			this.romancePageDiv();
 		}
 	}
 }