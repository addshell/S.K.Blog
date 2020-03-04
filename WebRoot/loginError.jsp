<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="refresh" content="3;url=login.jsp" />
<title>跳转中...</title>
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
	<div class="row">
		<table width="600" height="84" border="0" align="center">
			<tr>
				<td style="font-size: 50px;">
					<s:text name=":)" /></br>
					<span>您还未登录，请登录后重试...</span>
				</td>
			</tr>
			<tr>
				<td>
				 	<s:text name="服务器正在加载数据。。。如果 10 秒内没有成功加载请" />&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="login.jsp">点击此处立即跳转</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
