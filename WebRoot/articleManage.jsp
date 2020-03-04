<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>博文管理</title>
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
  <body id="top" class="page-2">
		<!-- 导航栏 -->
		<div class="tm-navbar-container tm-navbar-container-dark">
		<s:if test="#session.session_user!=null">
			<jsp:include page="header_lg.jsp"></jsp:include>
		</s:if>
		<s:else>
			<jsp:include page="header_unreg.jsp"></jsp:include>
		</s:else>
		</div>
  
    <div class="row">
		<div class="tm-section" id="tm-section-5">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
				<h3 class="blue-text">博文管理</h3>
				<h3 class="blue-text"><a href="categoryAction-getCategoryListByUserId?iid=${session_user.userId}">添加博文</a></h3>
				<table class="table table-striped tm-full-width-large-table">
					<thead>
						<tr>
							<th>博文名称</th>
							<th>发表时间</th>
							<th>查看博文</th>
							<th>删除博文</th>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="articlelist" var="article">
						<tr>
						<s:hidden value="#article.articleId"></s:hidden>
							<td><s:property value="#article.articleTitle"/></td>
							<td><s:property value="#article.publishTime"/></td>
							<td><a href="articleAction-getArticleByArticleId?iid=<s:property value="#article.articleId"/>">查看</a>
							<td><a href="articleAction-deleteArticle?iid=<s:property value="#article.articleId"/>">删除</a></td>
						</tr>
					</s:iterator>
					</tbody>        
				</table>
			</div>
		</div> <!-- tm-section -->        
	</div>
	</div>
  </body>
</html>
