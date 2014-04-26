<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    <title>图游</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/jquery.masonry.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="js/basic.js"></script>
	<link type="text/css" rel="stylesheet" href="css/basic.css"  />
	<link type="text/css" rel="stylesheet" href="css/index.css"  />
	<style type="text/css">
	/*returnTop*/
	p#back-to-top{
		position:fixed;
		display:none;
		bottom:50px;
		right:5px;
	}
	p#back-to-top a{
		display:block;
		width:46px;
		height:45px;
		background:#B7B7B7;
		border-radius: 3px 3px 3px 3px;
		border:1px solid #ccc;
	}
	p#back-to-top a:hover{
		background:#959595;
	}
	p#back-to-top a span{
		display:block;
		height:35px;
		width:32px;
		margin:5px 7px;
		background:transparent url("images/arrow.png") no-repeat;
	}
	</style>
  </head>
  
  <body>
   <a name="top"></a>
	<%@ include file="head.jsp" %>
	<div id="main">
		<div id="masonry" class="container-fluid">
			<c:forEach items="${requestScope['images'] }" var="image" >
				<div class="box">
					<div class="img">
						<a href="#"><img src="pin/${image.path}" /></a>
						<div class="btns" style="display:none;">
							<a href="#" class="col">收藏</a>
							<a href="#" class="fav"><span></span></a>
						</div>
					</div>
					<div class="title">
						<div class="desc"><a href="#">${image.description }</a></div>
						<div class="favnum">喜欢(122)</div>
					</div>
					<div class="comment">
						<dl>
							<dt><a href="#"><img src="images/tx1.jpg"/></a></dt>
							<dd class="author"><a href="#">张益达</a></dd>
							<dd><a href="#">在北京的日子</a></dd>
						</dl>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<p id="back-to-top"><a href="#top" title="返回顶部"><span></span></a></p>
  </body>
</html>
