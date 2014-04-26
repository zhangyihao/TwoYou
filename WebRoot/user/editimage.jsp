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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>编辑图像信息</title>
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/basic.js"></script>
		<link type="text/css" rel="stylesheet" href="css/basic.css"  />
		<link type="text/css" rel="stylesheet" href="css/editalbum.css"  />
		<style type="text/css">
			#content {
				float:left;
				margin-left:250px;
				margin-right:50px;
				background:none;
			}
			#content .submit {
				background:none;
			}
			#content #modalbody .formitem select {
				width: 440px;
				height: 26px;
				background-color: #FFF;
				border: 1px solid #CCC;
			}
			#content #modalbody .formitem a {
				width: 80px;
				height: 30px;
				line-height: 30px;
				display:inline-block;
				border-radius: 3px 3px 3px 3px;
				border: 1px solid #D6D3CE;
				color: #444;
				background: #F3F3F3;
			}
			#content #modalbody .formitem a:hover {
				background: #FEFEFE;
			}
			#showimg {
				float:left;
				width:216px;
				height:200px;
				background:#fff;
				margin-top: 75px;
			}
		</style>
	</head>
<body>
<%@ include file="/head.jsp" %>
<div id="content">
	<h1>编辑图片信息</h1>
	<s:form action="send_editImage_msg" namespace="/user/image" method="post" >
	<s:hidden name="img.id"></s:hidden>
	<div id="modalbody">
		<div class="formitem">
			<strong>标签：</strong>
			<s:textfield name="img.tags" cssClass="txtinput"></s:textfield>
		</div>
		<div class="formitem">
			<strong>描述：</strong>
			<s:textarea name="img.description"></s:textarea>
		</div>
		<div class="formitem">
			<strong>相册：</strong>
			<s:select name="albumId" list="albumList" listKey="id" listValue="name" multiple="false" value="img.album.id">
			</s:select>
		</div>
		<div class="formitem">
			<strong>删除：</strong>
			<a href="user/image/delimg.action?imageIds=${img.id }&albumId=${img.album.id }" class="cancel">删除图片</a>
		</div>
	</div>
	<div class="submit">
		<input type="submit" value="确定" />	
		<s:actionerror cssClass="errorMsg" />
	</div> 
	</s:form>
</div>
<div id="showimg">
	<img src="${img.path }" width="216px" height="200px"/>
</div>
<%@ include file="/foot.jsp" %>
</body>
</html>
