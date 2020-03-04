<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>博文目录</title>
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
		
		
		<!-- 博文内容列表 -->
		<div class="articlecontentlist">
		<s:iterator value="articlelist" var="article">
			<div class="articlelist">
				<h2 class="tm-news-title dark-gray-text"><s:property value="#article.articleTitle"/></h2>
				<a href="articleAction-getArticleByArticleId?iid=<s:property value="#article.articleId"/>"
				class="btn tm-light-blue-bordered-btn tm-news-link">进入</a>
				<hr color="#00ccff">
			</div>
		</s:iterator>
		<div class="row" style="margin-left: 700px; margin-top: -150px">
				<table>
					<span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>
					<span>
						<s:if test="currPage!=1">
							<a href="articleAction-getArticleByPage?currPage=1">[首页]</a>
							<a href="articleAction-getArticleByPage?currPage=<s:property value="currPage-1"/>">[上一页]</a>
						</s:if>
						<s:if test="currPage!=totalPage">
							<a href="articleAction-getArticleByPage?currPage=<s:property value="currPage+1"/>">[下一页]</a>
							<a href="articleAction-getArticleByPage?currPage=<s:property value="totalPage"/>">[尾页]</a>
						</s:if>
					</span>
				</table>
				</div>
		</div>
		
		<!-- 侧边栏 -->
		<div class="sidebar">
			<!-- Logo -->
			<div class="logo">
				<h1 class="">博文分类</h1>
			</div>
			<!-- Nav -->
			<nav id="nav" class="">
			<ul>
				<li><a href="articleAction-getArticleByPage">全部分类</a></li>
				<hr>
				<s:iterator value="categorylist" var="category">
				<li><a href="articleAction-getArticleListByCategoryId?iid=
				<s:property value="#category.categoryId"/>">
				<s:property value="#category.categoryName"/></a></li>
				<hr>
				</s:iterator>
			</ul>
			</nav>
		</div>
	</div>
</body>
</html>
