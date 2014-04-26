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
   	<title>编辑个人资料</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/basic.js"></script>
	<link type="text/css" rel="stylesheet" href="css/basic.css"  />
	<link type="text/css" rel="stylesheet" href="css/edituserinfo.css"  />
	<script type="text/javascript">
	$(document).ready(function () {
		$('.up').hide();
		$('.hideInfo').hide();
		
		$('.down a').click(showEdit);
		$('.up a').click(hideEdit);
		
	});
	
	function showEdit() {
		$('.hideInfo').hide();
		$('.up').hide();
		$('.down').show();
		var $showinfo = $(this).parent().parent();
		$showinfo.children('span').eq(1).hide();
		$showinfo.children('span').eq(2).hide();
		$showinfo.children('span').eq(3).show();
		var $info = $(this).parent().parent().parent();
		$info.children().eq(1).show()
	}
	
	function hideEdit() {
		var $showinfo = $(this).parent().parent();
		$showinfo.children('span').eq(1).show();
		$showinfo.children('span').eq(2).show();
		$showinfo.children('span').eq(3).hide();
		var $info = $(this).parent().parent().parent();
		$info.children().eq(1).hide()
	}
	
	</script>
</head>
<body>
<%@ include file="/head.jsp" %>
<s:actionerror cssClass="errorMsg" />
<div id="content">
	<h1>编辑个人资料</h1>
	<div class="info">
		<div class="showInfo">
			<span class="title">基本信息</span>
			<span class="_value"><s:property value="#session['USER'].username" /></span>
			<span class="down"><a href="javascript:void(0);">编辑</a></span>
			<span class="up"><a href="javascript:void(0);">收起</a></span>
		</div>
		<div class="hideInfo" id="hide_1">
			<s:form action="editbasic" namespace="/user" method="post">
			<table>
				<tr>
					<td class="name">登录帐号：</td>
					<td><s:property value="#session['USER'].email" /></td>
				</tr>
				<tr>
					<td class="name">昵称：</td>
					<td><s:textfield name="username" value="%{#session['USER'].username}" ></s:textfield></td>
				</tr>
				<tr>
					<td class="name"></td>
					<td><input class="submitbtn" type="submit" value="保存" /></td>
				</tr>
			</table>
			</s:form>
		</div>
	</div>
	<div class="info">
		<div class="showInfo">
			<span class="title">登录邮箱</span>
			<span class="_value"><s:property value="#session['USER'].email" /></span>
			<span class="down"><a href="javascript:void(0);">编辑</a></span>
			<span class="up"><a href="javascript:void(0);">收起</a></span>
		</div>
		<div class="hideInfo" id="hide_2">
			<s:form action="editemail" namespace="/user" method="post">
			<table>
				<tr>
					<td class="name">当前邮箱：</td>
					<td><s:property value="#session['USER'].email" /></td>
				</tr>
				<tr>
					<td class="name">新邮箱：</td>
					<td><s:textfield name="email" /></td>
				</tr>
				<tr>
					<td class="name">登录密码：</td>
					<td><s:password name="password" /></td>
				</tr>
				<tr>
					<td class="name"></td>
					<td><input class="submitbtn" type="submit" value="保存" /></td>
				</tr>
			</table>
			</s:form>
		</div>
	</div>
	<div class="info">
		<div class="showInfo">
			<span class="title">密码</span>
			<span class="_value">*******</span>
			<span class="down"><a href="javascript:void(0);">编辑</a></span>
			<span class="up"><a href="javascript:void(0);">收起</a></span>
		</div>
		<div class="hideInfo" id="hide_3">
		<s:form action="editpassword" namespace="/user" method="post">
			<table>
				<tr>
					<td class="name">当前密码：</td>
					<td><s:password name="password" /></td>
				</tr>
				<tr>
					<td class="name">新密码：</td>
					<td><s:password name="newPassword" /></td>
				</tr>
				<tr>
					<td class="name">确认密码：</td>
					<td><s:password name="rePassword" /></td>
				</tr>
				<tr>
					<td class="name"></td>
					<td><input class="submitbtn" type="submit" value="保存" /></td>
				</tr>
			</table>
			</s:form>
		</div>
	</div>
	<div class="info last">
		<div class="showInfo">
			<span class="title">头像</span>
			<span class="_img"><img src="${headImg75 }" width="40px" height="40px" /></span>
			<span class="down"><a href="javascript:void(0);">编辑</a></span>
			<span class="up"><a href="javascript:void(0);">收起</a></span>
		</div>
		<div class="hideInfo" id="hide_4">
			<s:form action="editheadimg" namespace="/user" method="post" enctype="multipart/form-data">
			<dl>
				<dd class="avatar">
					<img src="${headImg192 }" alt="" width="192px" height="144px" />
				</dd>
				<dd class="buttons"><input type="file" name="headImg" value="上传头像" /></dd>
				<dd><input class="submitbtn" type="submit" value="保存" /></dd>
			</dl>
			</s:form>
		</div>
	</div>
</div>
</body>
<s:if test="%{model!=null}">
	<script type="text/javascript">
	$(document).ready(function () {
		var $hideinfo = $('#hide_<s:property value="model" />');
		$hideinfo.show();
		var $showinfo = $hideinfo.parent().children('div').eq(0);
		$showinfo.children('span').eq(1).hide();
		$showinfo.children('span').eq(2).hide();
		$showinfo.children('span').eq(3).show();
	});
	</script>
</s:if>
</html>

