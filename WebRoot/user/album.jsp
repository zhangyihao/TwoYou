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
   <title>查看相册</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/basic.js"></script>
	<link type="text/css" rel="stylesheet" href="css/basic.css"  />
	<link type="text/css" rel="stylesheet" href="css/user.css"  />
	<link type="text/css" rel="stylesheet" href="css/album.css"  />
</head>
<body>
<%@ include file="/head.jsp" %>
<div id="content">
	<div id="user">
		<div id="back" style="position:absolute;z-index:-1;height:100%;width:100%;top:0px;left:0px;"><img src="images/cover_pic1.jpg" /></div>
		<div id="inner">
		 <div id="headphoto"><img src="${sessionScope['USER'].headImgMedium }" alt="头像" /></div>
		 <div id="username">${sessionScope['USER'].username }</div>
		 <div id="editinfo"><a href="user/editinfo.action">编辑个人资料</a></div>
		</div>
	</div>
	<div id="title">
		<ul>
			<li><a href="#" id="select">相册</a></li>
			<li><a href="#">收藏夹</a></li>
			<li><a href="#">喜欢</a></li>
			<li class="left"><a href="user/album/addAlbum.action">创建新相册</a></li>
		</ul>
	</div>
	<div id="album">
		<s:iterator value="albums" var="album" >
			<div class="album_pics">
				<span><s:property value="#album['ALBUM'].name" /></span>
				<a href="user/album/albumdetail.action?albumId=<s:property value="#album['ALBUM'].id"/>"><img src="<s:property value="#album['COVER']" />" alt="封面" /></a>
				<s:if test="#album['ALBUM'].id!=defaultAlbumId">
					<a href="user/album/editAlbum.action?albumId=<s:property value="#album['ALBUM'].id"/> " class="edit">编辑</a>
				</s:if>
			</div>
		</s:iterator>
	</div>
</div>
<%@ include file="/foot.jsp" %>
</body>
</html>
