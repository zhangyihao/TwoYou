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
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title>TwoYou</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/basic.css"  />
	<link type="text/css" rel="stylesheet" href="css/login.css"  />
  </head>
  
<body>
	<div id="content">
		<h1>登录图游</h1>
		<s:form action="send_login_msg" method="post" namespace="/" >
			<input type="text" id="email" placeholder="电子邮箱" name="email" value="${email }" />
			<input type="password" id="psw" placeholder="密码" name="password" />
			<s:actionerror id="msg" />
			<input type="submit" id="loginbtn" value="登录" name="" />
			<div id="bottom">
				<ul>
					<li id="rember"><input type="checkbox" id="" name="remember" value="remember" />下次自动登录</li>
					<li id="forget"><a href="password/forgetpass.action">忘记密码？</a></li>
					<li id="register"><a href="register.action">注册</a></li>
				</ul>
			</div>
		</s:form>
	</div>
</body>
</html>
