<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>个人信息修改</title>
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
		<s:form action="userAction-updateUser" method="post">
		  <table class="articleaddtable">
		  <tr>
		  	<td>
		  		<s:hidden name="user.userId"></s:hidden>
		  		<s:hidden name="user.userPass"></s:hidden>
		  		<s:hidden name="user.root"></s:hidden>
		  		<s:hidden name="user.commentPower"></s:hidden>
		  		<s:textfield name="user.userName" size="30" label="用户名">
		  		</s:textfield>
		  	</td>
		  </tr>
		  <tr>
		  	<td>
		  	  	<s:textfield name="user.userPhone" size="30" label="绑定手机号">
		  		</s:textfield>
		  	</td>
		  </tr>
		  <tr>
		  <td colspan="100" align="right">
		  <button type="submit" class="btn tm-light-blue-bordered-btn pull-xs-right">修改</button>
		  <td>
		  </tr>
		  </table>
		</s:form>
		</div>
  </body>
</html>
