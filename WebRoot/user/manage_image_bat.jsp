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
    <title>相册图片批量管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/basic.js"></script>
	<link type="text/css" rel="stylesheet" href="css/basic.css"  />
	<link type="text/css" rel="stylesheet" href="css/album.css"  />
	<link type="text/css" rel="stylesheet" href="css/albumdetail.css"  />
	<style type="text/css">
	#content #album .album_pics label {
		float:right;
		margin:5px 10px 0 0;
	}
	#content #album .album_pics label input {
		margin-right:5px;
	}
#dialog {
    width:600px;
    position:fixed !important; /* 浮动对话框 */
    left:45%;
    top:50%;
    margin:-200px 0 0 -200px;
    padding:1px;
    z-index:5;
    display:none;
    background:#FFF;
	border: 1px solid #F7F5F5;
	box-shadow: 0px 2px 5px rgba(34, 25, 25, 0.4);
}
#dialog h1 {
	width:100%;
	font-size: 16px;
	text-indent: 10px;
	border-bottom: 1px solid #ccc;
	height: 35px;
	line-height: 35px;
}
#dialog h1 a {
	float:right;
	color:#000;
	margin-right:10px;
}
#dialog #modalbody {
	width: 100%;
	height: 170px;
	border-bottom: 1px solid #ccc;
}
#dialog #modalbody select {
	width:540px;
	border:1px solid #ccc;
	height:26px;
	float:left;
	line-height:26px;
	margin-top:10px;
	margin-left:30px;
}
#dialog .submit {
	width: 100%;
	height: 40px;
	line-height: 40px;
	background-color: #F5F5F5;
}
#dialog .submit input {
	font-size: 14px;
	border-radius: 3px 3px 3px 3px;
	border: 1px solid #D6D3CE;
	color: #fff;
	background: #FB6964;
	cursor: pointer;
	float: right;
	margin-top: 5px;
	margin-right: 20px;
	width: 60px;
	height: 30px;
}
#content .submit input:hover{
	background: #D65955;
}
	</style>
	<script type="text/javascript">
	var select = false;
	function selectAll() {
		var check = document.getElementsByTagName("input");
		for(var i=0; i<check.length; i++) {
			if(check[i].type=='checkbox') {
				check[i].checked = !select;
			}
		}
		select = !select;
	}
	//显示灰色 jQuery 遮罩层
    function showBg() {
        var bh = $("body").height();
        var bw = $("body").width();
        $("#fullbg").css({
            height:bh,
            width:bw,
            display:"block"
        });
        $("#dialog").show();
    }
    //关闭灰色 jQuery 遮罩
    function closeBg() {
        $("#fullbg,#dialog").hide();
    }
    function delAction() {
    	document.movimg.action='/TwoYou/user/image/delimg.action';
    	document.movimg.submit();
    }
    
	</script>
</head>
<body>
<%@ include file="/head.jsp" %>
<div id="content">
	<h1>${requestScope['albumName'] }<span>(${fn:length(images) }张照片)</span></h1>
	<h2>${description }</h2>
	<div id="title">
		<dl>
			<dt><a href="user/album/seeAlbum.action">返回相册</a></dt>
			<dd><a href="user/album/albumdetail.action?albumId=${albumId }">完成</a></dd>
			<dd><a href="javascript:void(0);" onclick="delAction();return false;">删除</a></dd>
			<dd><a href="javascript:void(0);" onclick="showBg();return false;">移至</a></dd>
			<dd><a href="javascript:void(0);" onclick="selectAll();return false;">全选</a></dd>
		</dl>
	</div>
	<div id="album">
		<s:form namespace="/user/image" action="movimg" name="movimg" method="post" >
			<s:hidden name="albumId"></s:hidden>
			<s:iterator value="images" status="sta" >
				<div class="album_pics" style="height:240px;">
					<a href="#"><img src="<s:property value="path" />" alt="<s:property value="description" />" /></a>
					<span><s:property value="description" /></span>
					<label for="sel_${sta.index }"><input type="checkbox" name="imageIds" value="<s:property value="id" />" id="sel_${sta.index }" />选择</label>
				</div>
			</s:iterator>
			<div id="dialog">
				<h1>移动到<a href="javascript:void(0);" onclick="closeBg();">关闭</a></h1>
				<div id="modalbody">
					<s:select name="toAlbumId" list="albumList" listKey="id" listValue="name" multiple="false" value="albumId">
					</s:select>
				</div>
				<div class="submit">
					<input type="submit" value="确定" />
				</div> 
			</div>
		</s:form>
	</div>
</div>
<%@ include file="/foot.jsp" %>
<div id="fullbg">
</div>
</body>
</html>
