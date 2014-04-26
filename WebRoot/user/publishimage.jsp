<%--@ page import="org.apache.struts2.components.Include"--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>" />
    <title>发布图片</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/basic.js"></script>
	<link type="text/css" rel="stylesheet" href="css/basic.css"  />
	<link type="text/css" rel="stylesheet" href="css/publishimage.css"  />
	<script type="text/javascript">
	/*获取上传图片的本地路径*/
	function getPath(obj) {
		var filepath;
		if(obj){
			if (window.navigator.userAgent.indexOf("MSIE")>=1){
				obj.select();
				filepath = document.selection.createRange().text;
			} else if(window.navigator.userAgent.indexOf("Firefox")>=1){
				filepath = window.URL.createObjectURL(obj.files[0]);
			} else {
				filepath = obj.value;
			}
		} else {
				filepath = obj.value;
		}
		return filepath;
	}

	var imgNum = 1;//记录上传图片的总数
	function delImage() {
		$(this).parent().remove();
		imgNum--;
		if(imgNum==1) {
			$('#tag').hide();
		} else if(imgNum>2) {
			$('#uploadImage').height($('#uploadImage').height()-130);
		}
		
		for(var i=0; i<$('#showImage').children().length; i++) {
			$('#showImage').children().eq(i).children('div').eq(0).children('img').eq(0).attr('id','imgs_'+(i+1));
			$('#showImage').children().eq(i).children('div').eq(1).children('textarea').eq(0).attr('id','imgs_text_'+(i+1));
			$('#showImage').children().eq(i).children('input').eq(0).attr('id','file_upload_'+(i+1));
		}
	}

	function showImages() {
		$('#file_upload_'+imgNum).hide();
		$('#imgs_del_'+imgNum).show();
		var path = getPath(document.getElementById('file_upload_'+imgNum));
		$('#imgs_'+parseInt(imgNum)).attr('src', path);
		
		imgNum++;
		var $imgs = $('<div class="imgs">'+
			'<div class="imgs_img"><img id="imgs_'+imgNum+'" /></div>'+
			'<div class="imgs_desc"><textarea id="imgs_text_'+imgNum+'" name="description" placeholder="你有什么想说的"></textarea></div></div>');
		var $delImg = $('<div class="imgs_del" id="imgs_del_'+imgNum+'"></div>');
		$delImg.click(delImage);
		$delImg.hide();
		var $fileUpload = $('<input class="file_upload" id="file_upload_'+imgNum+'" type="file" name="image" accept="image/*" onchange="showImages();" />');
		
		$imgs.append($delImg);
		$imgs.append($fileUpload);
		
		$('#showImage').append($imgs);
		
		if(imgNum>3) {
			$('#uploadImage').height($('#uploadImage').height()+130);
		}
		if(imgNum>0) {
			$('#showImage').show();
			$('#tag').show();
		}
	}
	</script>
</head>
<body>
<%@ include file="/head.jsp" %>
<div id="content">
	<h1>发布照片</h1>
	<div id="uploadImage">
		<s:form action="publish" method="post" namespace="/user/image" enctype="multipart/form-data" >
			<div id="showImage">
				<div class="imgs">
					<div class="imgs_img"><img id="imgs_1" /></div>
					<div class="imgs_desc"><textarea id="imgs_text_1" name="description" placeholder="你有什么想说的"></textarea></div>
					<div class="imgs_del" id="imgs_del_1"></div>
					<script type="text/javascript">$('#imgs_del_1').click(delImage);$('#imgs_del_1').hide();</script>
					<input class="file_upload" id="file_upload_1" type="file" name="image" accept="image/*" onchange="showImages();" />
				</div>
			</div>
			<div id="tag" style="display:none;">
				<h2>标签</h2>
				<input type="text" name="tags" />(请用逗“,”分割各个标签，如：北京,上海)
				<input id="img_submit" type="submit" name="publish" value="发布" />
			</div>
		</s:form>
		<s:fielderror></s:fielderror>
	</div>
</div>
<%@ include file="/foot.jsp" %>
</body>
</html>
