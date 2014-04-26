<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="top">
		<div id="leftHeader">
			<h1><em></em></h1>
			<form name="searchForm" action="#" method="get">
				<input type="text" name="key" id="searchInput" />
				<input type="submit" id="searchBtn" value="search" />
			</form>
		</div>
		<div id="logo"><a href="index.action"></a></div>
		<div id="rightHeader">
<!-- 登录样式-->
			<c:if test="${sessionScope['USER']==null}">
				<dl id="login">
					<dd><a href="register.action">注册</a></dd>
					<dd><a href="login.action">登录</a></dd>
				</dl>
			</c:if>
			<c:if test="${sessionScope['USER']!=null}">
				<div id="add">
					<a href="" title="添加"><em></em></a>
					<ul style="display:none">
						<li><a href="user/image/pubimg.action">发布图片</a></li>
						<li><a href="user/album/addAlbum.action">添加相册</a></li>
					</ul>
				</div>
				<div id="message"><a href="" title="通知"><em></em></a></div>
				<div id="photo">
				<a href="" title="头像"><img src="${sessionScope['USER'].headImgSmall }" width="40px" height="40px"/></a>
				<div class="mytravel" style="display:none;">
					<ul>
						<li><a href="" class="self">我的图游</a></li>
						<li><a href="user/album/seeAlbum.action" class="album">我的相册</a></li>
						<li><a href="" class="attention">我的关注</a></li>
						<li><a href="" class="share">我的分享</a></li>
						<li><a href="" class="collect">我的收藏</a></li>
						<li><a href="" class="about">与我相关</a></li>
						<li><a href="" class="comment">我的评论</a></li>
						<li><a href="user/editinfo.action" class="setting">个人资料</a></li>
						<li><a href="" class="logout">退出登录</a></li>
					</ul>
				</div>
			</div>
			</c:if>
		</div>
	</div>
