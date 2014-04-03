<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

	var imgNum = 0;//记录上传图片的总数
	function delImage() {
		imgNum--;
		$(this).parent().remove();
		if(imgNum>2) {
			$('#uploadImage').height($('#uploadImage').height()-130);
		}
		if(imgNum<1) {
			$('#showImage').hide();
			$('#tag').hide();
		}
		for(var i=0; i<$('#showImage').children().length; i++) {
			$('#showImage').children().eq(i).children('div').eq(0).children('img').eq(0).attr('id','imgs_'+(i+1));
			$('#showImage').children().eq(i).children('div').eq(1).children('textarea').eq(0).attr('id','imgs_text_'+(i+1));
		}
	}

	function showImages() {
		imgNum++;
		var $imgs = $('<div class="imgs">'+
			'<div class="imgs_img"><img id="imgs_'+imgNum+'" /></div>'+
			'<div class="imgs_desc"><textarea id="imgs_text_'+imgNum+'" placeholder="你有什么想说的"></textarea></div>'+
			'</div>');
		var $delImg = $('<div class="imgs_del"></div>');
		$delImg.click(delImage);
		$imgs.append($delImg);
		$('#showImage').append($imgs);
		var path = getPath(document.getElementById('file_upload'));
		$('#imgs_'+parseInt(imgNum)).attr('src', path);
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
<div id="top">
	<div id="leftHeader">
		<h1><em></em></h1>
		<form name="searchForm" action="#" method="get">
			<input type="text" name="key" id="searchInput" />
			<input type="submit" id="searchBtn" value="search" />
		</form>
	</div>
	<a href="index.html"><div id="logo"></div></a>
	<div id="rightHeader">
		<div id="add">
			<a href="" title="添加"><em></em></a>
			<ul style="display:none">
				<li><a href="#">发布图片</a></li>
				<li><a href="">添加相册</a></li>
			</ul>
		</div>
		<div id="message"><a href="" title="通知"><em></em></a></div>
		<div id="photo">
			<a href="" title="头像"><img src="images/tx.jpg"/></a>
			<div class="mytravel" style="display:none;">
				<ul>
					<li><a href="" class="self">我的图游</a></li>
					<li><a href="" class="album">我的相册</a></li>
					<li><a href="" class="attention">我的关注</a></li>
					<li><a href="" class="share">我的分享</a></li>
					<li><a href="" class="collect">我的收藏</a></li>
					<li><a href="" class="about">与我相关</a></li>
					<li><a href="" class="comment">我的评论</a></li>
					<li><a href="" class="setting">帐号设置</a></li>
					<li><a href="" class="logout">退出登录</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div id="content">
	<h1>发布照片</h1>
	<div id="uploadImage">
		<form name="" action="album.html" method="post" enctype="multipart/form-data">
			<div id="showImage">
			</div>
			<input id="file_upload" type="file" accept="image/*" multiple onchange="showImages();" />
			<div id="tag" style="display:none;">
				<h2>标签</h2>
				<input type="text" name="tags" />(请用逗“,”分割各个标签，如：北京,上海)
				<input id="img_submit" type="submit" name="publish" value="发布" />
			</div>
		</form>
	</div>
</div>
<div id="bottom">
	<center>dfsdffffffffffffff</center>
</div>
</body>
</html>