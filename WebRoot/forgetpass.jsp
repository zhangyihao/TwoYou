<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
  	<base href="<%=basePath%>"/>
	<title>TwoYou</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/basic.css"  />
	<link type="text/css" rel="stylesheet" href="css/login.css"  />
	<style type="text/css">
		#content form #accpet {
			display:block;
			height:30px;
			line-height:30px;
		}
		#content form #accpet input {
			float:left;
			margin-top:9px;
		}
		#content form #accpet span {
			display:block;
			float:left;
			margin-left:5px;
		}
		#content form #accpet #accept_login {
			display:block;
			float:right;
			margin-right:5px;
		}
		#content form #accpet a {
			color:#225599;
		}
	</style>
</head>
<body>
	<div id="content" style="margin-top:100px;">
		<h1>图游</h1>
		<s:form action="send_forgetpas_msg" method="post" namespace="/password" >
			<input type="text" id="email" placeholder="请输入电子邮箱" name="email" />
			<s:actionerror id="msg" />
			<input type="submit" id="loginbtn" value="找回密码" />
		</s:form>
	</div>
</body>
</html>