<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>用户管理</title>
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
				<h3 class="blue-text">用户管理</h3>
				<table class="table table-striped tm-full-width-large-table" align="center">
					<thead>
						<tr>
							<th>用户名</th>
							<th>手机号</th>
							<th>管理权限</th>
							<th>发言权限</th>
							<th>删除用户</th>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="userPage.list" var="user">
						<tr>
						<s:hidden value="#user.userId"></s:hidden>
							<td><s:property value="#user.userName"/></td>
							<td><s:property value="#user.userPhone"/></td>
							<td>
							<s:if test="#user.root==true">
							<a href="userAction-updateUserRoot?iid=<s:property value="#user.userId"/>">取消管理员权限</a>	
							</s:if>
							<s:else>
							<a href="userAction-updateUserRoot?iid=<s:property value="#user.userId"/>">设为管理员</a>
							</s:else>			
							</td>
							<td>
							<s:if test="#user.commentPower==true">
							<a href="userAction-updateUComPower?iid=<s:property value="#user.userId"/>">禁言</a>
							</s:if>
							<s:else>
							<a href="userAction-updateUComPower?iid=<s:property value="#user.userId"/>">关闭禁言</a>
							</s:else>
							</td>
							<td><a href="userAction-deleteUser?iid=<s:property value="#user.userId"/>">删除</a></td>
						</tr>
					</s:iterator>
					</tbody>        
				</table>
				<div class="row" style="margin-left: 900px;">
				<table>
					<span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>
					<span>
						<s:if test="currPage!=1">
							<a href="userAction-getUserByPage?currPage=1">[首页]</a>
							<a href="userAction-getUserByPage?currPage=<s:property value="currPage-1"/>">[上一页]</a>
						</s:if>
						<s:if test="currPage!=totalPage">
							<a href="userAction-getUserByPage?currPage=<s:property value="currPage+1"/>">[下一页]</a>
							<a href="userAction-getUserByPage?currPage=<s:property value="totalPage"/>">[尾页]</a>
						</s:if>
					</span>
				</table>
				</div>
			</div>
		</div> <!-- tm-section -->        
	</div>
	</div>
  </body>
</html>
