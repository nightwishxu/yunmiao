$(function(){
	$.fn.clearFileId = function(){
		var v_itemId = $(this).attr("id");
		$("#"+ v_itemId+"_hidden").val("");
		$("#"+ v_itemId + "_img_queue").html("");
	}
	
	$.fn.setFileId = function(fid,multi,showImage,show) {
		var v_itemId = $(this).attr("id");
		if(fid == null) fid = '';
		var ids = $("#"+ v_itemId+"_hidden").val();
		if(ids == undefined || ids == '' || !multi){
			$("#"+ v_itemId+"_hidden").val(fid);
		}else{
			if(fid.indexOf(",")>-1){
				$("#"+ v_itemId+"_hidden").val(fid);
			}else{
				$("#"+ v_itemId+"_hidden").val(ids+","+fid);
			}
		}
		if (!show) return;
		var width = $(this).attr("showWidth") || 110;
  		var height = $(this).attr("showHeight") || 110;
		if(fid.length>0){
			if(showImage == 1){
				if(multi){
					var array = fid.split(",");
					for ( var i = 0; i < array.length; i++) {
						$("#"+ v_itemId + "_img_queue").append("<li class='uploadify-img-queue-div'>" + 
							po.showImg({id:array[i],width:width,height:height,parent:true,uploadId:v_itemId}) +
							"<div style='width:"+width+"px'></div><a class='uploadify-img-queue-div-a' href='javascript:void(0)' onclick='$(\"#"+v_itemId+"\").delFileId(\""+array[i]+"\","+multi+");$(this).parent().remove();'></a></li>");
					}
				}else{
					$("#"+ v_itemId + "_img_queue").html("<li class='uploadify-img-queue-div'>" + 
							po.showImg({id:fid,width:width,height:height,parent:true,uploadId:v_itemId}) +
							"<div style='width:"+width+"px'></div><a class='uploadify-img-queue-div-a' href='javascript:void(0)' onclick='$(\"#"+v_itemId+"\").delFileId(\""+fid+"\","+multi+");$(this).parent().remove();'></a></li>");
				}
			}else if (showImage == 2){
				if(multi){
					var array = fid.split(",");
					for ( var i = 0; i < array.length; i++) {
						$("#"+ v_itemId + "_img_queue").append("<li class='uploadify-img-queue-div'>" + 
								"<video src='"+sy.basePath+"download?type=inline&id="+array[i]+"' preload controls height='"+height+"'></video>"+
							"<div style='width:"+width+"px'></div><a class='uploadify-img-queue-div-a' href='javascript:void(0)' onclick='$(\"#"+v_itemId+"\").delFileId(\""+array[i]+"\","+multi+");$(this).parent().remove();'></a></li>");
					}
				}else{
					$("#"+ v_itemId + "_img_queue").html("<li class='uploadify-img-queue-div'>" + 
							"<video src='"+sy.basePath+"download?type=inline&id="+fid+"' preload controls height='"+height+"'></video>" +
							"<div style='width:"+width+"px'></div><a class='uploadify-img-queue-div-a' href='javascript:void(0)' onclick='$(\"#"+v_itemId+"\").delFileId(\""+fid+"\","+multi+");$(this).parent().remove();'></a></li>");
				}
			}else{
				if(multi){
					var array = fid.split(",");
					for ( var i = 0; i < array.length; i++) {
						$("#"+ v_itemId + "_img_queue").append("<li class='uploadify-img-queue-div'>" + 
								"<img src=\""+sy.basePath+"/static/admin/js/webuploader/file.png\" style=\"width: "+width+"px; height: "+height+"px;\">"+
							"<div style='width:"+width+"px'></div><a class='uploadify-img-queue-div-a' href='javascript:void(0)' onclick='$(\"#"+v_itemId+"\").delFileId(\""+array[i]+"\","+multi+");$(this).parent().remove();'></a></li>");
					}
				}else{
					$("#"+ v_itemId + "_img_queue").html("<li class='uploadify-img-queue-div'>" + 
							"<img src=\""+sy.basePath+"/static/admin/js/webuploader/file.png\" style=\"width: "+width+"px; height: "+height+"px;\">"+
							"<div style='width:"+width+"px'></div><a class='uploadify-img-queue-div-a' href='javascript:void(0)' onclick='$(\"#"+v_itemId+"\").delFileId(\""+fid+"\","+multi+");$(this).parent().remove();'></a></li>");
				}
			}
			
		}
	};
	$.fn.delFileId = function(fid,multi) {
		var v_itemId = $(this).attr("id");
		var ids = $("#"+ v_itemId+"_hidden").val();
		if(ids == undefined || ids == '' || !multi){
			$("#"+ v_itemId+"_hidden").val("");
		}else{
			var array = ids.split(",");
			for ( var i = 0; i < array.length; i++) {
				if(array[i] == fid){
					array.splice(i,1);
					break;
				}
			}
			ids=array.join(",");
			$("#"+ v_itemId+"_hidden").val(ids);
		}
	};
	
	$.fn.getFileId = function() {
		var v_itemId = $(this).attr("id");
		var ids = $("#"+ v_itemId+"_hidden").val();
		if(ids == undefined || ids == ''){
			return '';
		}else{
			return ids;
		}
	};
	
	sy.initFileUpload();
});

/**
 * webUpload 删除
 * @param fileId
 */
function webUploadMoreRemove(fileId){
	 $("#" +fileId).remove();
}

sy.calsize = function(size){
	var s = 0;
	var fileSizeLimitBytes = parseInt(size) * 1.024;
    if (size.indexOf('KB') > -1) {
        s = fileSizeLimitBytes * 1000;
    } else if (size.indexOf('MB') > -1) {
        s = fileSizeLimitBytes * 1000000;
    } else if (size.indexOf('GB') > -1) {
        s = fileSizeLimitBytes * 1000000000;
    }
	return s;
};

sy.unFileUpload = function(target){
	 //文件上传控件
	  $.each($("div[type=file]"),function(index,obj){
		  	if(target!=undefined) {
		  		if($(obj).attr("id") != target){
		  			return true;
		  		}
		  	}
	  });
};

sy.initFileUpload = function(target){
	if (!WebUploader.Uploader.support()) {
		   var error = "上传控件不支持您的浏览器！请尝试升级flash版本或者使用Chrome引擎的浏览器。<a target='_blank' href='http://se.360.cn'>下载页面</a>";
		   if (window.console) {
			   window.console.log(error);
		   }
		   return;
	  }
	  //文件上传控件
	  $.each($("div[type=file]"),function(index,obj){
		  	if(target!=undefined) {
		  		if($(obj).attr("id") != target){
		  			return true;
		  		}
		  	}
		  	 var v_init = ("false" != $(obj).attr('init'));
		  	 if(!v_init)return;
	  		 var method = $(obj).attr('onUploadSuccess');
	  		 var showImage = ("true" == $(obj).attr("showImage"));
	  		 var o = obj;
	  		 var v_itemId = $(obj).attr("id");
	  		 var v_multi = ("true" == $(obj).attr('multi'));
	  		 var showBtn=$(obj).attr("showBtn")||'false';
	  		 var bestSize=$(obj).attr("bestSize")||'';
	  		 var v_uploader = $(obj).attr("url") || "fileUpload";
	  		 	
	  		$list = $('<ul id="' + v_itemId + '_img_queue" class="uploader-list" ></ul>');
	  		$(obj).before($list).before('<div style="clear:both;"></div>');
	  		//$progress = $('<div class="progress"><span class="text">0%</span><span class="percentage"></span></div>');
	  		//$progress = $('<p class="progress"><span></span></p>');
	  		var v_required = ("required" == $(obj).attr('required'));
	  		var v_missingMessage = $(obj).attr("missingMessage")||'请上传文件';
	  		$(obj).after("<input id='" + v_itemId + "_hidden' type=\"hidden\" name=\""+v_itemId+"\" "+(v_required?"required":"")+" missingMessage=\""+v_missingMessage+"\"></input>");
	  		//$("#" + v_itemId).after("<div id='" + v_itemId + "_queue'></div>");
	  		//$(obj).after($progress);
	  		//$percent = $(obj).parent().find('.progress span');
	  		var v_fileType = $(obj).attr('fileType') || "gif,jpg,jpeg,bmp,png";
	  		var v_fileSize = $(obj).attr('fileSize') || undefined;
	  		v_fileSize = sy.calsize(v_fileSize);
	  		var v_fileCountLimit = $(obj).attr("fileCountLimit") || undefined;
	  		var v_formData = $(obj).attr("formData") || "{}";
	  		v_formData = $.parseJSON(v_formData);
	  		var width = $(obj).attr("showWidth") || 110;
	  		var height = $(obj).attr("showHeight") || 110;
	  		if (!v_multi)v_fileCountLimit = 1;
	  		var uploader = WebUploader.create({
	  			auto : $(obj).attr('auto')||true,
	  			pick : {
	  				id:'#'+v_itemId,
	  				innerHTML:$(obj).attr('buttonText')|| "文件上传",
	  				multiple:v_multi
	  			},
	  			formData:v_formData,
	  			accept: {
	  		        title: 'Images',
	  		        extensions: v_fileType,
	  		       // mimeTypes: 'image/*'
	  		    },
	  			swf: sy.basePath+'static/admin/js/webuploader/Uploader.swf',  
	  			fileVal:'Filedata',              //和name属性配合使用
	  			server: sy.basePath+v_uploader,
	  			duplicate:true,
	  			formData: {
	            },  
	            thumb:{
	            	 width: width,
	            	 height: height,

            	    // 图片质量，只有type为`image/jpeg`的时候才有效。
            	    quality: 70,

            	    // 是否允许放大，如果想要生成小图的时候不失真，此选项应该设置为false.
            	    allowMagnify: false,

            	    // 是否允许裁剪。
            	    crop: true,
	            },
	            resize: false,
	            chunked: false,  //分片
	            chunkSize: 5 * 1024 * 1024,   //每片5M
	            chunkRetry:false,//如果失败，则不重试
	            threads:1,//上传并发数。允许同时最大上传进程数。
	           // fileNumLimit:v_fileCountLimit,//验证文件总数量, 超出则不允许加入队列
	            // runtimeOrder: 'flash',  
	            // 禁掉全局的拖拽功能。这样不会出现图片拖进页面的时候，把图片打开。  
	            disableGlobalDnd: true,
	            fileSingleSizeLimit:v_fileSize
	            //指定拖拽的容器
	            //dnd:''
	  		});
	  		
	  		 // 当有文件添加进来的时候
	  	     uploader.on( "fileQueued", function( file ) {
	  	    	var ids = $("#"+ v_itemId+"_hidden").val();
	        	var file_cnt = 0;
	    		if(ids == undefined || ids == ''){
	    			file_cnt = 0;
	    		}else{
	    			var array = ids.split(",");
	    			file_cnt = array.length;
	    		}
	    		
	    		var upload = true;
	    		
	  	    	if (v_fileCountLimit && v_fileCountLimit > 1){
		  	    	 if (file_cnt >= v_fileCountLimit){
		  	    		alert("文件上传数量超出限制(" + v_fileCountLimit + "个)");
		  	    		uploader.cancelFile(file);
		  	    		uploader.removeFile(file,true);
		  	    		uploader.reset();
		  	    		upload = false;
		  	    	 }
	  	    	 }
	  	    	if (upload){
	  	    		var html = "<li id='" + v_itemId + '_' + file.id + "' class='uploadify-img-queue-div'><img/><div style='width:"+width+"px'>"+file.name+"</div>" + 
					"<a class='uploadify-img-queue-div-a' href='javascript:void(0)'></a><div class=\"progressBar\"><p class=\"progress\"><span class=\"percentage\"></span></p><span class=\"percentageNum\"></span></div></li>";
	  	    		if (v_multi){
	  	    			$('#' + v_itemId + '_img_queue').append(html);
	  	    			/*$list.append("<div id='" + file.id + "' style=\"float: left;padding:3px\"><img/><div>"+file.name+"</div>" +
	  	    					"<div class=\"file-panel\" style=\"height: 20px;\"><a class=\"webremove\" href=\"javascript:webUploadMoreRemove('"+file.id+"')\">删除</a>" +
	  	    							"</div> <input type=\"hidden\" name='"+v_itemId+"'> <div style=\"height: 4px;\"></div><p class=\"progress\"><span class=\"percentage\"></span></p><span class=\"percentageNum\"></span></div>");*/
	  	    		}else{
	  	    			$('#' + v_itemId + '_img_queue').html('');
	  	    			$('#' + v_itemId + '_img_queue').html(html);
	  	    			/*$list.html("<li id='" + file.id + "' style=\"float: left;padding:3px\"><img/>" +
	  	    					"<div>"+file.name+"</div>" +
	  	    					"<div class=\"file-panel\" style=\"height: 20px;\"><a class=\"webremove\" href=\"javascript:webUploadMoreRemove('"+file.id+"')\">删除</a></div>" +
	  	    							" <input type=\"hidden\" name='"+v_itemId+"'> <div style=\"height: 4px;\"></div><p class=\"progress\"><span class=\"percentage\"></span></p><span class=\"percentageNum\"></span></li>");*/
	  	    		}
		  	    	// 制作缩略图
			          // error：不是图片，则有error
			          // src:代表生成缩略图的地址
			          uploader.makeThumb(file, function(error, src) {
			              if (error) {
			                 // $("#" + file.id).find("img").attr("src",sy.basePath+"/static/admin/js/webuploader/file.png").attr('width',width).attr('height',height);
			              } else {
			                //  $("#" + file.id).find("img").attr("src", src);
//			                  $("#" + file.id).find("img").replaceWith(po.showImg({id:src,width:width,height:height,parent:true,uploadId:v_itemId}));
			              }
			          });
	  	    	}
	  	    	
	  	     });
	  	     
	  	     // 文件上传过程中创建进度条实时显示。
	  	     uploader.on( 'uploadProgress', function( file, percentage ) {
	  		   //$percent.css( 'width', percentage * 100 + '%' );
	  		   $('#'+ v_itemId + '_'+file.id).find('.percentage').css( 'width', percentage * 100 + '%' );
	  		   $('#'+ v_itemId + '_'+file.id).find('.percentageNum').text(parseInt(percentage * 100 )+ '%');
	  	     });
	  	     uploader.on( "uploadStart", function(file) {
	  	    	//$progress.fadeIn();
	  	    	//$percent.css('width','0');
	  	    	$('#'+ v_itemId + '_'+file.id).find('.progressBar').fadeIn();
	  	    	$('#'+ v_itemId + '_'+file.id).find('.percentage').css('width','0');
	  	     });
	  	     
	  	   uploader.on( "uploadSuccess", function( file, ret) {
	           if(ret.error == '0'){
	        	   	if (file.type.indexOf('image') != -1){
	        	   		$('#'+ v_itemId).setFileId(ret.url,v_multi,showImage);
	        	   		$("#"+ v_itemId + '_' + file.id).find("img").replaceWith(po.showImg({id:ret.url,width:width,height:height,parent:true,uploadId:v_itemId}));
	        	   	}else if(file.type.indexOf('video')!= -1){
	        	   		$('#'+ v_itemId).setFileId(ret.url,v_multi,false);
	        	   		$("#"+ v_itemId + '_' + file.id).find("img").replaceWith("<video src='"+sy.basePath+"download?type=inline&id="+ret.url+"' preload controls height='"+height+"'></video>");
	        	   	}else{
	        	   		$('#'+ v_itemId).setFileId(ret.url,v_multi,false);
	        	   		$("#" + v_itemId + '_' + file.id).find("img").attr("src",sy.basePath+"/static/admin/js/webuploader/file.png").attr('width',width).attr('height',height);
	        	   	}
	        	   	$("#" + v_itemId + '_' + file.id).find('a').on('click',function(){
        	   			$('#'+ v_itemId).delFileId(ret.url,v_multi);
        	   			$("#" + v_itemId + '_' + file.id).remove();
        	   		});
	        	    if(method!='' && window[method]){
		        		window[method].call(window, ret, file);
		        	}
	  	      }else{
		  	        uploader.reset();
		  	        alert("error");
	  	      }
	       });
	  	   
		  	 uploader.on( "uploadError", function( file,reason  ) {
		           //多个文件
		  		 var fileArray = uploader.getFiles();
		  		 for(var i = 0 ;i<fileArray.length;i++){
	               //取消文件上传
	                uploader.cancelFile(fileArray[i]);
	                //从队列中移除掉
	                uploader.removeFile(fileArray[i],true);
		  		 }
		           //发生错误重置webupload,初始化变量
		  		 uploader.reset();
		       });
		  	 
		  	//当validate不通过时，会以派送错误事件的形式通知调用者
		     uploader.on("error",function(error){
		       uploader.reset();
		       fileSize = 0;
		         if ('F_EXCEED_SIZE' == error){
		        	 alert('文件大小超出限制');
		         }else if ('Q_TYPE_DENIED' == error){
		        	 alert('文件类型错误');
		         }else{
		        	 alert(error);
		         }
		     });
		     
		     uploader.on( 'uploadComplete', function( file ) {
		    	 //$progress.fadeOut();
		    	 //$('#'+file.id).find('.progress').fadeOut();
		    	 $('#'+ v_itemId + '_'+file.id).find('.percentageNum').text('完成');
		    	 setTimeout(function(){
		    		 $('#'+ v_itemId + '_'+file.id).find('.progressBar').fadeOut();
		    	 },'1000');
		    	 //webUploadMoreRemove(file.id);
		     });
	  		
		   //如果是在模态框里的上传按钮，点击file的时候不会触发控件
		     //修复model内部点击不会触发选择文件的BUG
		     /*    $("#multi .webuploader-pick").click(function () {
		            uploader.reset();
		            fileSize = 0;
		            fileName = [];
		            fileSizeOneByOne=[];
		                $("#multi :file").click();
		            });*/
	  });
}

function HtmlEditor(v_id, v_options) {
	if(!v_options)v_options ={};
	var fullItems = ['source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
			        'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
			        'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
			        'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
			        'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
			        'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image',
			         'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
			        'anchor', 'link', 'unlink'
			];
	var easyItems = ['source', '|', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                	'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                	'insertunorderedlist', '|', 'image', 'link', 'unlink', '|', 'fullscreen'];
	
	// 对外参数
	this.options = {
		uploadJson : 'fileUpload',
		newlineTag : "br",
		filePostName:"Filedata",
		afterUpload : function(url) {
        },
        resizeType : 1,
        pasteType:1,
        items : easyItems,
		formatUploadUrl:true,
		fillDescAfterUploadImage:true
	};
	$.extend(this.options, v_options);

	if (!KindEditor) {
		mini.alert("请先加载htmlEditor的JS文件!");
		return;
	}

	var v_loader = this;

	// 初始化
	this.options.editor = KindEditor.create('#' + v_id, this.options);

	return this;
}
HtmlEditor.prototype = {
	getHtml : function() {
		return this.options.editor.html();
	},
	setHtml : function(v_html) {
		if (v_html != null) {
			return this.options.editor.html(v_html);
		}
	}
};