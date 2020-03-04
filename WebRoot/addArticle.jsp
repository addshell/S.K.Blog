<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>添加博文</title>
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
<script type="text/javascript" src="fckeditor/fckeditor.js"></script>
<script type="text/javascript">
	window.onload = function() {
		var oFCKeditor = new FCKeditor('article.articleContent');
		oFCKeditor.BasePath = "fckeditor/";
		oFCKeditor.ToolbarSet = 'Default';
		oFCKeditor.Height = 400;
		oFCKeditor.ReplaceTextarea();
	}
</script>
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

	<div class="form-control" align="center">
		<s:form action="articleAction-addArticle" method="post">
			<table class="articleaddtable">
				<tr>
					<td><s:textfield name="article.articleTitle" size="100"
							label="博文名称">
						</s:textfield></td>
				</tr>
				<tr>
					<td><s:select name="categoryId" list="categorylist"
							key="categoryId" listKey="categoryId" listValue="categoryName"
							label="博文分类">
						</s:select></td>
				</tr>
				<tr>
					<td><s:textarea name="article.articleContent" cols="500"
							width="500px" rows="15" id="article.articleContent" label="博文内容"></s:textarea>
					</td>
				</tr>
				<td align="right" colspan="100">
					<button class="btn tm-light-blue-bordered-btn pull-xs-right"
						type="submit">发布</button>
				</td>
			</table>
		</s:form>
	</div>
</body>
</html>
