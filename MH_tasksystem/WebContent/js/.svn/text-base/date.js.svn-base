// JScript 文件

//document.write("<iframe id=CalFrame name=CalFrame frameborder=0 width=286 Height=152px " +
//    " src='../common/time.htm' style=display:none;position:absolute;z-index:100;></iframe>");

document.write("<iframe id=CalFrame name=CalFrame frameborder=0 width=286 Height=152px " +
    " src='./time.htm' style=display:none;position:absolute;z-index:100;></iframe>");
var WithObj;
function ShowDate(Obj)
{
   
    document.getElementById("CalFrame").style.display="block";    
    var tbObj=document.getElementById(Obj);
    
     var date_posLib = {
    getClientLeft:function (el) {
     var r = el.getBoundingClientRect();
     return r.left- this.getBorderLeftWidth(this.getCanvasElement(el));
    },

    getClientTop:    function (el) {
     var r = el.getBoundingClientRect();
      return r.top - this.getBorderTopWidth(this.getCanvasElement(el));
    },

    getLeft:    function (el) {
      return this.getClientLeft(el) + this.getCanvasElement(el).scrollLeft;
    },

    getTop:    function (el) {
      return this.getClientTop(el) + this.getCanvasElement(el).scrollTop;
    },

    getInnerLeft:    function (el) {
      return this.getLeft(el) + this.getBorderLeftWidth(el);
    },

    getInnerTop:    function (el) {
      return this.getTop(el) + this.getBorderTopWidth(el);
    },

    getWidth:    function (el) {
      return el.offsetWidth;
    },

    getHeight:    function (el) {
      return el.offsetHeight;
    },

    getCanvasElement:    function (el) {
      var doc = el.ownerDocument || el.document;    // IE55 bug
      if (doc.compatMode == "CSS1Compat")
        return doc.documentElement;
      else
        return doc.body;
    },

    getBorderLeftWidth:    function (el) {
      return el.clientLeft;
    },

    getBorderTopWidth:    function (el) {
      return el.clientTop;
    },

    getScreenLeft:    function (el) {
      var doc = el.ownerDocument || el.document;    // IE55 bug
      var w = doc.parentWindow;
      return w.screenLeft + this.getBorderLeftWidth(this.getCanvasElement(el)) + this.getClientLeft(el);
    },

    getScreenTop:    function (el) {
      var doc = el.ownerDocument || el.document;    // IE55 bug
      var w = doc.parentWindow;
      return w.screenTop  + this.getClientTop(el);//+ this.getBorderTopWidth(this.getCanvasElement(el))
    }
  }
      //alert(date_posLib.getTop(tbObj)+20);
        document.getElementById("CalFrame").style.top = String(date_posLib.getTop(tbObj)+20)+"px";
        document.getElementById("CalFrame").style.left =String(date_posLib.getLeft(tbObj))+"px";
    
    var Frame = window.frames.CalFrame;
    if (Frame != null)
    {
        if (Frame.Object != null)
        {
            Frame.Object = Obj;
            Frame.ObjFrame = "CalFrame";
        }
    }
}

