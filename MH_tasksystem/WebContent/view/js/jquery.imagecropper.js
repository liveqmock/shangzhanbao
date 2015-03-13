; (function($) {
    $.fn.extend({
        imageCropper: function(options) {
            if (!this.is('img') || typeof this.attr('src') == 'undefined' || this.attr('src') == '') {
                throw 'Please notice that this jquery plguin only could be applied to img and the src of img could not be null!';
            }
            var defaults = {
                //原图路径
                imagePath: this.attr('src'),
                //缩放级别
                zoomLevel: 1,
                //图片相对于截取框是否居中
                center: false,
                //截取框与图片的相对位置
                left: 100, top: 100,
                //截取框的大小
                width: 200, height: 200,
                //是否初始放大图片
                initial : false,
                //工作区大小
                cropWorkAreaSize: { width: 0, height: 0 },
                //截取框相对于工作区的位置
                cropFrameRect: { center: false, top: 100, left: 0 },
                //缩放范围
                zoom: { min: 0, max: 10, step: 0.1 },
                //回调函数
                callbacks: {
                    //移动图片后
                    dragging: false,
                    //缩放后
                    zoomed: false
                }
            };
            if (options) {
                defaults = $.extend(defaults, options);
            }
            return new imageCropper(this, defaults);
        }
    });

    function imageCropper(image, settings) {
        this.init(image, settings);
    };
    
    function GetCurrentStyle (obj, prop)
    {
       if (obj.currentStyle) //IE
       {
           return obj.currentStyle[prop];
       }
       else if (window.getComputedStyle) //非IE
       {
           return document.defaultView.getComputedStyle(obj,null)[prop];
       }
      return null;
    }

    imageCropper.prototype = {
        settings: false,
        wrapper: $('<div id="screenshotDiv" class="image-cropper-wrapper"/>'),
//        zoomWrapper: $('<div class="zoom-wrapper"><div class="zoom-out-button"/><div class="zoom-scrollbar"><div class="zoom-scroller"/></div><div class="zoom-in-button"/></div>'),
        img: false,
        init: function(image, settings) {
            var context = this;
            this.settings = settings;
            
            var mt = settings.oldImg ? parseInt(GetCurrentStyle(settings.oldImg,"marginTop") || 0) : 0,
            	mb = settings.oldImg ? parseInt(GetCurrentStyle(settings.oldImg,"marginBottom") || 0) : 0;
            var img = $(settings.oldImg) || image;
            this.wrapper.css({
            	position: 'absolute',
            	top: (img.offset().top - ((settings.cropWorkAreaSize.height - settings.height) / 2))<0?0:(img.offset().top - ((settings.cropWorkAreaSize.height - settings.height) / 2)) + "px",
            	left: (img.offset().left) + 'px',
            	zIndex:2
            });
            
            image.addClass('background-img');
            //生成html
            image.wrap(this.wrapper).wrap('<div class="crop-work-area"/>').wrap('<div class="crop-background"/>');
            this.wrapper = $('.image-cropper-wrapper');
            $('.crop-work-area', this.wrapper).append('<div class="crop-frame"><img style="'+image.attr('style')+'" class="foreground-img" src="" /></div><div class="drag-containment"/>');
//            this.wrapper.append(this.zoomWrapper);

            $('.image-cropper-wrapper', this.wrapper).disableSelection();
            this.reset();

            //图片的拖动
	        $('.crop-background', this.wrapper).draggable({
	            containment: $('.drag-containment', this.wrapper),
	            cursor: 'move',
	            drag: function(event, ui) {
	                //同时移动前景图
	                $('.foreground-img', this.wrapper).css({
	                    left: (parseInt($(this).css('left')) - context.settings.cropFrameRect.left - 1) + 'px',
	                    top: (parseInt($(this).css('top')) - context.settings.cropFrameRect.top - 1) + 'px'
	                });
	                //得到截图左上点坐标
	                context.settings.left = context.settings.cropFrameRect.left - parseInt($(this).css('left'));
	                context.settings.top = context.settings.cropFrameRect.top - parseInt($(this).css('top'));
	                //移动图片的callback
	                context.fireCallback(context.settings.callbacks.dragging);
	            }
	        });
	        $('.foreground-img', this.wrapper).draggable({
	            containment: $('.drag-containment', this.wrapper),
	            cursor: 'move', 
	            drag: function(event, ui) {
	                //同时移动背景
	                $('.crop-background', this.wrapper).css({
	                    left: (parseInt($(this).css('left')) + context.settings.cropFrameRect.left + 1) + 'px',
	                    top: (parseInt($(this).css('top')) + context.settings.cropFrameRect.top + 1) + 'px'
	                });
	                //得到截图左上点坐标
	                context.settings.left = context.settings.cropFrameRect.left - parseInt($('.crop-background', this.wrapper).css('left'));
	                context.settings.top = context.settings.cropFrameRect.top - parseInt($('.crop-background', this.wrapper).css('top'));
	                //移动图片的callback
	                context.fireCallback(context.settings.callbacks.dragging);
	            }
	        });
            //点击缩放
            $('.zoom-out-button,.zoom-in-button', parent.frames['frame_left'].document).click(function() {
                var step = $(this).hasClass('zoom-in-button') ? context.settings.zoom.step : -context.settings.zoom.step;
                var tempZoomLevel = context.formatNumber(context.settings.zoomLevel + step, 3);
                //如果缩放级别超出范围 或者 缩放导致图片右下角没在截取框内 则取消缩放
                if (tempZoomLevel >= context.settings.zoom.min
                    && tempZoomLevel <= context.settings.zoom.max
                    && parseInt($('.crop-background', this.wrapper).css('left')) + tempZoomLevel * context.img.width > context.settings.cropFrameRect.left + context.settings.width
                    && parseInt($('.crop-background', this.wrapper).css('top')) + tempZoomLevel * context.img.height > context.settings.cropFrameRect.top + context.settings.height
                ) {
                    context.settings.zoomLevel = tempZoomLevel;
                    context.zoom(context.img.width * context.settings.zoomLevel, context.img.height * context.settings.zoomLevel);
                    var scllzoom = $('#zoom', parent.frames['frame_left'].document);
                    if($(this).hasClass('zoom-in-button')){
                    	scllzoom.css('top', (parseInt(scllzoom.css('top'))+380 * context.settings.zoom.step/(context.settings.zoom.max-context.settings.zoom.min))>370?370:(parseInt(scllzoom.css('top'))+380 * context.settings.zoom.step/(context.settings.zoom.max-context.settings.zoom.min)) + 'px');
                    } else {
                    	scllzoom.css('top', (parseInt(scllzoom.css('top'))-380 * context.settings.zoom.step/(context.settings.zoom.max-context.settings.zoom.min))<-10?-10:(parseInt(scllzoom.css('top'))-380 * context.settings.zoom.step/(context.settings.zoom.max-context.settings.zoom.min)) + 'px');
                    }
                } else {
                	var scllzoom = $('#zoom', parent.frames['frame_left'].document);
                    if($(this).hasClass('zoom-in-button')){
                    	scllzoom.css('top', '370px');
                    } else {
                    	scllzoom.css('top', '-10px');
                    }
                }
                context.fireCallback(context.settings.callbacks.zoomed);
            });
        },
        reset: function() {
            this.img = new Image();
            this.img.src = this.settings.imagePath;
            //截取框大于工作区，则放大工作区
            var tempSize = {
                width: Math.max(this.settings.cropWorkAreaSize.width, this.settings.width),
                height: Math.max(this.settings.cropWorkAreaSize.height, this.settings.height)
            };
            //如果截取框在工作区中居中，则重新设置截取框的位置
            if (this.settings.cropFrameRect.center) {
                this.settings.cropFrameRect.left = (tempSize.width - this.settings.width) / 2;
                this.settings.cropFrameRect.top = (tempSize.height - this.settings.height) / 2;
            }
            //如果截取框在图片中居中，则重新设置图片与截取框的相对位置
            if (this.settings.center) {
                this.settings.left = (this.img.width * this.settings.zoomLevel - this.settings.width) / 2;
                this.settings.top = (this.img.height * this.settings.zoomLevel - this.settings.height) / 2;
            }
            //如果图片小于截取框，则放大图片
            if(this.img.width<this.settings.width || this.img.height<this.settings.height){
            	this.img.width = this.img.width * this.settings.zoom.max;
            	this.img.height = this.img.height * this.settings.zoom.max;
            	this.settings.zoomLevel = this.settings.zoom.max;
            	this.settings.initial = true;
            }
          
            this.wrapper.width(tempSize.width + 2).height(tempSize.height + 25);
            $('.foreground-img,.background-img', this.wrapper).attr('src', this.settings.imagePath);
            $('.crop-work-area', this.wrapper).width(tempSize.width).height(tempSize.height);
            $('.crop-frame', this.wrapper).css({
                left: this.settings.cropFrameRect.left + 'px',
                top: this.settings.cropFrameRect.top + 'px',
                width: this.settings.width + 'px',
                height: this.settings.height + 'px'
            });
            $('.foreground-img', this.wrapper).css({
                left: (-this.settings.cropFrameRect.left - 1) + 'px',
                top: (-this.settings.cropFrameRect.top - 1) + 'px'
            });
            $('.zoom-scroller', this.wrapper).css('left', this.settings.zoomLevel * 200 / (this.settings.zoom.max - this.settings.zoom.min) + 'px');
            $('.crop-background', this.wrapper).css({
                opacity: 0.3,
                left: this.settings.cropFrameRect.left - this.settings.left + 'px',
                top: this.settings.cropFrameRect.top - this.settings.top + 'px'
            });
            $('.foreground-img', this.wrapper).css({
                left: -this.settings.left + 'px',
                top: -this.settings.top + 'px'
            });
            this.settings.left = this.settings.cropFrameRect.left - parseInt($('.crop-background', this.wrapper).css('left'));
            this.settings.top = this.settings.cropFrameRect.top - parseInt($('.crop-background', this.wrapper).css('top'));

            this.zoom(this.img.width * this.settings.zoomLevel, this.img.height * this.settings.zoomLevel);
        },
        zoom: function(width, height) {
            $('.crop-background, .background-img, .foreground-img', this.wrapper).width(width).height(height);
            //调整拖动限制框
            $('.drag-containment', this.wrapper).css({
                left: this.settings.cropFrameRect.left + this.settings.width - this.settings.zoomLevel * this.img.width + 1 + 'px',
                top: this.settings.cropFrameRect.top + this.settings.height - this.settings.zoomLevel * this.img.height + 1 + 'px',
                width: 2 * this.settings.zoomLevel * this.img.width - this.settings.width + 'px',
                height: 2 * this.settings.zoomLevel * this.img.height - this.settings.height + 'px'
            });
        },
        formatNumber: function(number, bit) {
            return Math.round(number * Math.pow(10, bit)) / Math.pow(10, bit);
        },
        fireCallback: function(fn) {
            if ($.isFunction(fn)) {
                fn.call(this);
            };
        }
    };
})(jQuery);