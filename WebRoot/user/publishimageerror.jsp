<%@page import="org.apache.struts2.components.Include"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<title>发布图片</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/basic.css" />
<style type="text/css">
#content {
	width: 800px;
	margin: 0 auto;
	padding-top: 25px;
}

#content h1 {
	font-family: "Helvetica Neue", Helvetica, Arial, "Hiragino Sans GB",
		"Microsoft YaHei", STHeiti, SimHei, sans-serif;
	color: #333;
	font-size: 30px;
	margin-bottom: 5px;
	font-weight: bold;
}
#content #errorMsg {
	width: 800px;
	background: #fff;
	height: 300px;
	border-radius: 3px 3px 3px 3px;
	margin-top: 5px;
	padding-top: 3px;
}
#content #errorMsg .err {
	color:red;
	margin:10px;
}
</style>
</head>
<body>
	<%@ include file="/head.jsp"%>
	<div id="content">
		<h1>出错啦！</h1>
		<div id="errorMsg">
			<s:fielderror cssClass="err" />
			&nbsp;&nbsp;&nbsp;<a href="user/image/pubimg.action">返回，重新上传图片</a>
		</div>
	</div>
	<%@ include file="/foot.jsp"%>
</body>
</html>
