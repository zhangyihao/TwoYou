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
   	<title>查看图片</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/basic.js"></script>
	<link type="text/css" rel="stylesheet" href="css/basic.css"  />
	<link type="text/css" rel="stylesheet" href="css/showimage.css"  />
</head>
<body>
<%@ include file="/head.jsp" %>
<div id="content">
	<div id="img">
		<img src="aaa.jpg" width=658px height=500px />
	</div>
	<div id="comment">
		<div id="desc">xxxxxxxxxxx</div>
		<div id="">
			<span>喜欢(2030)</span>
			<span>收藏(2232)</span>
			<span>评论(23)</span>
		</div>
		<div id="replayform">
			<s:form cssClass="replay-form">
				<input type="hidden" name="imageId" value="2"/>
				<s:textarea name="content" value="评论一下" ></s:textarea>
				<input type="submit" value="发表" />
			</s:form>
		</div>
		<div id="commentlist">
			<div class="comment-item">
				<div class="comment-content">
					<p class="ui-avatar"><a target="_blank" href="#"><img src="" width="34px" height="34px" /></a></p>
					<p class="replay-content"><a href="#">张益达</a>：是否就是犯贱</p>
					<p class="replay-time"><span class="comment-time">2014-3-3 12:34</span><a href="#">回复</a></p>
				</div>
				<div class="comment-content-sub">
					<div class="replay-list">
						<p class="ui-avatar"><a target="_blank" href="#"><img src="" width="34px" height="34px" /></a></p>
						<p class="replay-content"><a href="#">张益达</a>回复<a href="#">张益达</a>：斯蒂芬斯蒂芬第三方的身份</p>
						<p class="replay-time"><span class="comment-time">2014-3-3 12:34</span><a href="#">回复</a></p>
					</div>
					<div class="replay-list">
						<p class="ui-avatar"><a target="_blank" href="#"><img src="" width="34px" height="34px" /></a></p>
						<p class="replay-content"><a href="#">张益达</a>回复<a href="#">张益达</a>：斯蒂芬斯蒂芬第三方的身份</p>
						<p class="replay-time"><span class="comment-time">2014-3-3 12:34</span><a href="#">回复</a></p>
					</div>
				</div>
				<s:form action="" cssClass="replay-form">
					<input type="hidden" name="commentId" value="2"/>
					<input type="hidden" id="replayto_1" name="toReplayer" value="2"/>
					<s:textarea name="content" ></s:textarea>
					<input type="submit" value="发表" />
				</s:form>
			</div>
			<div class="comment-item">
				<div class="comment-content">
					<p class="ui-avatar"><a target="_blank" href="#"><img src="" width="34px" height="34px" /></a></p>
					<p class="replay-content"><a href="#">张益达</a>：是否就是犯贱</p>
					<p class="replay-time"><span class="comment-time">2014-3-3 12:34</span><a href="#">回复</a></p>
				</div>
				<div class="comment-content-sub">
					<div class="replay-list">
						<p class="ui-avatar"><a target="_blank" href="#"><img src="" width="34px" height="34px" /></a></p>
						<p class="replay-content"><a href="#">张益达</a>回复<a href="#">张益达</a>：斯蒂芬斯蒂芬第三方的身份</p>
						<p class="replay-time"><span class="comment-time">2014-3-3 12:34</span><a href="#">回复</a></p>
					</div>
				</div>
				<s:form action="" cssClass="replay-form">
					<input type="hidden" name="commentId" value="2"/>
					<input type="hidden" id="replayto_1" name="toReplayer" value="2"/>
					<s:textarea name="content" ></s:textarea>
					<input type="submit" value="发表" />
				</s:form>
			</div>
			<div class="comment-item">
				<div class="comment-content">
					<p class="ui-avatar"><a target="_blank" href="#"><img src="" width="34px" height="34px" /></a></p>
					<p class="replay-content"><a href="#">张益达</a>：是否就是犯贱</p>
					<p class="replay-time"><span class="comment-time">2014-3-3 12:34</span><a href="#">回复</a></p>
				</div>
				<div class="comment-content-sub">
					<div class="replay-list">
						<p class="ui-avatar"><a target="_blank" href="#"><img src="" width="34px" height="34px" /></a></p>
						<p class="replay-content"><a href="#">张益达</a>回复<a href="#">张益达</a>：斯蒂芬斯蒂芬第三方的身份</p>
						<p class="replay-time"><span class="comment-time">2014-3-3 12:34</span><a href="#">回复</a></p>
					</div>
					<div class="replay-list">
						<p class="ui-avatar"><a target="_blank" href="#"><img src="" width="34px" height="34px" /></a></p>
						<p class="replay-content"><a href="#">张益达</a>回复<a href="#">张益达</a>：斯蒂芬斯蒂芬第三方的身份</p>
						<p class="replay-time"><span class="comment-time">2014-3-3 12:34</span><a href="#">回复</a></p>
					</div>
				</div>
				<s:form action="" cssClass="replay-form">
					<input type="hidden" name="commentId" value="2"/>
					<input type="hidden" id="replayto_1" name="toReplayer" value="2"/>
					<s:textarea name="content" ></s:textarea>
					<input type="submit" value="发表" />
				</s:form>
			</div>
		</div>
	</div>
</div>
<%@ include file="/foot.jsp" %>
</body>
</html>

