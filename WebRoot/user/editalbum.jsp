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
		<title>编辑相册信息</title>
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/basic.js"></script>
		<link type="text/css" rel="stylesheet" href="css/basic.css"  />
		<link type="text/css" rel="stylesheet" href="css/editalbum.css"  />
		<script type="text/javascript">
			function delAlbum(){
				if(confirm('你确定要永久删除该相册（不会删除图片）?')) {
					return true;
				}
				return false;
			}
		</script>
	</head>
<body>
<%@ include file="/head.jsp" %>
<div id="content">
	<h1>编辑相册信息</h1>
	<s:form action="send_editAlbum_msg" namespace="/user/album" method="post" >
	<s:hidden name="albumId" />
	<div id="modalbody">
		<div class="formitem">
			<strong>名称：</strong>
			<s:textfield name="albumName" cssClass="txtinput" ></s:textfield>
		</div>
		<div class="formitem">
			<strong>描述：</strong>
			<s:textarea name="description"></s:textarea>
		</div>
	</div>
	<div class="submit">
		<input type="submit" value="确定" />	
		<a href="user/album/seeAlbum.action" class="cancel">取消</a>
		<s:if test="#request['albumId']!=defaultAlbumId">
			<a href="user/album/send_delAlbum_msg.action?albumId=${requestScope['albumId'] }" onclick="javascript:return delAlbum();">删除相册</a>
		</s:if>
		<s:actionerror cssClass="errorMsg" />
	</div> 
	</s:form>
</div>
<%@ include file="/foot.jsp" %>
</body>
</html>
