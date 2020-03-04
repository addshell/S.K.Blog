<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title><s:property value="article.articleTitle"/></title>
<!-- load stylesheets -->
<!-- <link rel="stylesheet"
	href="http://fonts.useso.com/css?family=Open+Sans:100,300,400"> -->
<!-- Google web font "Open Sans" -->
<link rel="stylesheet"
	href="font-awesome-4.5.0/css/font-awesome.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Bootstrap style -->
<link rel="stylesheet" href="css/templatemo-style.css">

</head>
<body>
	<!-- 导航栏 -->
	<div class="tm-navbar-container tm-navbar-container-dark">
		<s:if test="#session.session_user!=null">
			<jsp:include page="header_lg.jsp"></jsp:include>
		</s:if>
		<s:else>
			<jsp:include page="header_unreg.jsp"></jsp:include>
		</s:else>
	</div>
	<div class="articlelist-body">
		<!-- 博文内容 -->
		<div class="articlecontentlist">
			<h1><s:property value="article.articleTitle"/></h1>
			<span>发表时间：<s:property value="article.publishTime"/></span><br><hr><br>
			<div class="articleContent">
			<s:property value="article.articleContent" escape="false"/>
			</div>
			
			<!-- 评论区 -->
			<div class="commentDisplay">
			<h4>用户评论：</h4>
			<s:iterator value="commentlist" var="comment">
				<div>
				<span>用户名：<s:property value="#comment.commentUser"/></span>
					<h5>评论时间：<s:property value="#comment.commentTime" escape="false"/></h5>
					<h5>评论内容：<s:property value="#comment.commentContent" escape="false"/></h5>
				</div>
				<hr color="#00ccff">
			</s:iterator>
			</div>
			
		<!-- 评论发表区 -->
		<div class="commentContent">
		<s:form action="commentAction-addComment" method="post">
		  <table>
		  <tr>
		  	<td>
				<s:textarea name="comment.commentContent" cols="100" width="800px" height="80px"
				rows="5" id="comment.commentContent" label="发表评论"></s:textarea>
				<s:hidden name="iid" value="%{article.articleId}"></s:hidden>
			</td>
		  </tr>
		  <tr>
		  <td colspan="100" align="right">
		  	<button type="submit" class="btn tm-light-blue-bordered-btn tm-news-link">提交</button>
		  </td>
		  </tr>
		  </table>
		</s:form>
		</div>
		</div>
		<hr>
	
		<!-- 侧边栏 -->
		<div class="sidebar" style="margin-top: 60px">
			<!-- Logo -->
			<div class="logo">
				<h1 class="">博文分类</h1>
			</div>
			<!-- Nav -->
			<nav id="nav" class="">
			<ul>
				<li><a href="articleAction-getArticleByPage">博文列表</a></li>
				<hr>
				<li><a href="categoryAction-getCategoryListByUserId?iid=${session_user.userId}">添加博文</a></li>
				<hr>
				<li><a href="articleAction-deleteArticle?iid=<s:property value="article.articleId"/>">删除此博文</a></li>
				<hr>
				<li><a href="articleAction-getArticleUpdate?iid=<s:property value="article.articleId"/>">修改博文</a></li>
				<hr>
			</ul>
			</nav>
		</div>
	</div>
</body>
</html>
