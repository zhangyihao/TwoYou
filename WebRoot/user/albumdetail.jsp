<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>" />
    <title>相册</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/basic.js"></script>
	<link type="text/css" rel="stylesheet" href="css/basic.css"  />
	<link type="text/css" rel="stylesheet" href="css/album.css"  />
	<link type="text/css" rel="stylesheet" href="css/albumdetail.css"  />
</head>
<body>
<%@ include file="/head.jsp" %>
<div id="content">
	<h1>${requestScope['albumName'] }<span>(${fn:length(images) }张照片)</span></h1>
	<h2>${description }</h2>
	<div id="title">
		<dl>
			<dt><a href="user/album/seeAlbum.action">返回相册</a></dt>
			<dd><a href="user/album/editAlbum.action?albumId=${albumId } ">编辑相册</a></dd>
			<dd><a href="user/album/albummanage.action?albumId=${albumId } ">批量管理</a></dd>
		</dl>
	</div>
	<div id="album">
		<s:iterator value="images" >
			<div class="album_pics">
				<a href="#"><img src="<s:property value="path" />" alt="<s:property value="description" />" /></a>
				<span><s:property value="description" /></span>
				<a href="user/image/editimg.action?img.id=<s:property value="id" />" class="edit">编辑</a>
			</div>
		</s:iterator>
	</div>
</div>
<%@ include file="/foot.jsp" %>
</body>
</html>
