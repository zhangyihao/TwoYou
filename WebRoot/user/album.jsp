<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>" />
   <title>查看相册</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<link type="text/css" rel="stylesheet" href="css/basic.css"  />
	<link type="text/css" rel="stylesheet" href="css/user.css"  />
	<link type="text/css" rel="stylesheet" href="css/album.css"  />
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
	<div id="user">
		<div id="back" style="position:absolute;z-index:-1;height:100%;width:100%;top:0px;left:0px;"><img src="images/cover_pic1.jpg" /></div>
		<div id="inner">
		 <div id="headphoto"><img src="images/member_pic.png" alt="头像" /></div>
		 <div id="username">User Name</div>
		 <div id="editinfo"><a href="#">编辑个人资料</a></div>
		</div>
	</div>
	<div id="title">
		<ul>
			<li><a href="#" id="select">相册</a></li>
			<li><a href="#">收藏夹</a></li>
			<li><a href="#">喜欢</a></li>
		</ul>
	</div>
	<div id="album">
		<div class="album_pics">
			<span>我的相册</span>
			<a href="seealbum.html"><img src="images/36.jpg" alt="图片说明" /></a>
			<a href="editalbum.html" class="edit">编辑</a>
		</div>
		<div class="album_pics">
			<span>我的相册</span>
			<a href="seealbum.html"><img src="images/36.jpg" alt="图片说明" /></a>
			<a href="editalbum.html" class="edit">编辑</a>
		</div>
		<div class="album_pics">
			<span>我的相册</span>
			<a href="seealbum.html"><img src="images/36.jpg" alt="图片说明" /></a>
			<a href="editalbum.html" class="edit">编辑</a>
		</div>
		<div class="album_pics">
			<span>我的相册</span>
			<a href="seealbum.html"><img src="images/36.jpg" alt="图片说明" /></a>
			<a href="editalbum.html" class="edit">编辑</a>
		</div>
		<div class="album_pics">
			<span>我的相册</span>
			<a href="seealbum.html"><img src="images/36.jpg" alt="图片说明" /></a>
			<a href="editalbum.html" class="edit">编辑</a>
		</div>
		<div class="album_pics">
			<span>我的相册</span>
			<a href="seealbum.html"><img src="images/36.jpg" alt="图片说明" /></a>
			<a href="editalbum.html" class="edit">编辑</a>
		</div>
		<div class="album_pics">
			<span>我的相册</span>
			<a href="seealbum.html"><img src="images/36.jpg" alt="图片说明" /></a>
			<a href="editalbum.html" class="edit">编辑</a>
		</div>
	</div>
</div>
<div id="bottom" style="clear:both;">
	<center>dfsdffffffffffffff</center>
</div>
</body>
</html>
