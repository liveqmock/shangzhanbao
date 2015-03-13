/** @serializedParams looks like "prop1=value1&prop2=value2".   
 Nested property like 'prop.subprop=value' is also supported **/ 
function paramString2obj (serializedParams) { 
     
    var obj={};  

    function evalThem (str) {  

        var attributeName = str.split("=")[0];  

        var attributeValue = str.split("=")[1];  

        if(!attributeValue){  

            return ;  

         }  

         var array = attributeName.split(".");  

         for (var i = 1; i < array.length; i++) {  

             var tmpArray = Array();  

            tmpArray.push("obj");  

            for (var j = 0; j < i; j++) {  

                 tmpArray.push(array[j]);  

           };  

            var evalString = tmpArray.join(".");  



             if(!eval(evalString)){  

                 eval(evalString+"={};");                  

             }  

         };  

        

         eval("obj."+attributeName+"='"+attributeValue+"';");  

            

     };  

    

     var properties = serializedParams.split("&");  

     for (var i = 0; i < properties.length; i++) {  

         evalThem(properties[i]);  

     };  

    

     return obj;  

 }  

    

    

 $.fn.form2json = function(){  

     var serializedParams = this.serialize();  

     var obj = paramString2obj(serializedParams);  

//     return JSON.stringify(obj);  //报JSOn错误??????
     return obj2str(obj);  

 } 
 
 function obj2str(o){
	   var r = [];
	   if(typeof o == "string" || o == null) {
	     return o;
	   }
	   if(typeof o == "object"){
	     if(!o.sort){
	       r[0]="{"
	       for(var i in o){
	    	 r[r.length]="'";
	         r[r.length]=i;
	         r[r.length]="'";
	         r[r.length]=":";
	         r[r.length]="'";
	         r[r.length]=obj2str(o[i]);
	         r[r.length]="'";
	         r[r.length]=",";
	       }
	       if(r.length > 1){
	    	   r[r.length-1]="}"
	       }else{
	    	   r[1]="}"
	       }
	       
	     }else{
	       r[0]="["
	       for(var i =0;i<o.length;i++){
	         r[r.length]=obj2str(o[i]);
	         r[r.length]=",";
	       }
	       r[r.length-1]="]"
	     }
	     return r.join("");
	   }
	   return o.toString();
}


