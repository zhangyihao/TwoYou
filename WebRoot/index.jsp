<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    <title>图游</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/jquery.masonry.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<link type="text/css" rel="stylesheet" href="css/basic.css"  />
	<link type="text/css" rel="stylesheet" href="css/index.css"  />
	<style type="text/css">
	/*returnTop*/
	p#back-to-top{
		position:fixed;
		display:none;
		bottom:50px;
		right:5px;
	}
	p#back-to-top a{
		display:block;
		width:46px;
		height:45px;
		background:#B7B7B7;
		border-radius: 3px 3px 3px 3px;
		border:1px solid #ccc;
	}
	p#back-to-top a:hover{
		background:#959595;
	}
	p#back-to-top a span{
		display:block;
		height:35px;
		width:32px;
		margin:5px 7px;
		background:transparent url("images/arrow.png") no-repeat;
	}
	</style>
  </head>
  
  <body>
   <a name="top"></a>
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
<!-- 登录样式
			<dl id="login">
				<dd><a href="">注册</a></dd>
				<dd><a href="">登录</a></dd>
			</dl>
-->
			<div id="add">
				<a href="" title="添加"><em></em></a>
				<ul style="display:none">
					<li><a href="user/publishimage.html">发布图片</a></li>
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

	<div id="main">
		<div id="masonry" class="container-fluid">
			<div class="box">
				<div class="img">
					<a href="#"><img src="images/2.jpg" /></a>
					<div class="btns" style="display:none;">
						<a href="#" class="col">收藏</a>
						<a href="#" class="fav"><span></span></a>
					</div>
				</div>
				<div class="title">
					<div class="desc"><a href="#">这是一只可爱的猫</a></div>
					<div class="favnum">喜欢(122)</div>
				</div>
				<div class="comment">
					<dl>
						<dt><a href="#"><img src="images/tx1.jpg"/></a></dt>
						<dd class="author"><a href="#">张益达</a></dd>
						<dd><a href="#">在北京的日子</a></dd>
					</dl>
				</div>
			</div>
		</div>
	</div>
	<p id="back-to-top"><a href="#top" title="返回顶部"><span></span></a></p>
  </body>
</html>
