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
	<div class="showmessage-body">
		<!-- 博文内容 -->
		<div class="messagecontentlist">
			<h1><s:property value="message.messageName"/></h1><br><hr><br>
			<span>留言用户：<s:property value="message.messageUserName"/></span><br><hr><br>
			<span>电子邮箱：<s:property value="message.messageEmail"/></span><br><hr><br>
			<span>留言时间：<s:property value="message.messageTime"/></span><br><hr><br>
			<span>留言内容：<s:property value="message.messageContent" escape="false"/></span><br><hr><br>
			<div align="right"><a href="messageAction-getMessByPage">-->返回</a></div><br><br>
		</div>
		<br>
	</div>
</body>
</html>
