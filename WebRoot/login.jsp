<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<script type="text/javascript">
	$(document).ready(function () {
		$('#email').focusin(function () {
			/*$(this).css('border','1px solid #CB2027');*/
			/*$('#login').height($('#login').height()+50);*/
			$('#msg').show();
		});
		$('#email').focusout(function () {
			$('#msg').hide();
			/*$('#login').height($('#login').height()-50);*/
		});
	});
	
	</script>
  </head>
  
<body>
	<div id="content">
		<h1>登录图游</h1>
		<form name="" action="" method="post">
			<input type="text" id="email" placeholder="电子邮箱" name="" />
			<input type="password" id="psw" placeholder="密码" name="" />
			<div id="msg" style="display:none;">请填写正确的邮箱!</div>
			<input type="submit" id="loginbtn" value="登录" name="" />
			<div id="bottom">
				<ul>
					<li id="forget"><a href="forgetpass.html">忘记密码？</a></li>
					<li id="register"><a href="register.html">注册</a></li>
				</ul>
			</div>
		</form>
	</div>
</body>
</html>
