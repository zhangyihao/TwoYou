<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>" />
    <title>TwoYou</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/basic.css"  />
	<link type="text/css" rel="stylesheet" href="css/registersuccess.css"  />
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
		<div id="logo"><a href="index.html"></a></div>
		<div id="rightHeader">
			<dl id="login">
				<dd><a href="register.html">注册</a></dd>
				<dd><a href="login.html">登录</a></dd>
			</dl>
		</div>
	</div>
	<div id="content">
		<h1>邮箱验证</h1>
		<hr/>
		<div id="checkemail">
			<dl>
				<dt>邮件已发送至邮箱<span>zyh5540@163.com</span></dt>
				<dt><a href="">立即查收邮件</a></dt>
				<dt>没有收到邮件？</dt>
				<dd>1、查看下您的垃圾邮件</dd>
				<dd>2、还是没有，重新发送邮件<a href="">重新发送邮件</a></dd>
				<dd>3、看来是被拒收了，用其它邮箱试试</dd>
			</dl>
		</div>
	</div>

</body>
</html>