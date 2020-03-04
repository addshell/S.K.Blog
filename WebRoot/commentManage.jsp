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
<link rel="stylesheet"
	href="http://fonts.useso.com/css?family=Open+Sans:100,300,400">
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
				<h3 class="blue-text">评论管理</h3>
				<table class="table table-striped tm-full-width-large-table">
					<thead>
						<tr>
							<th>评论内容</th>
							<th>评论时间</th>
							<th>查看评论</th>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="commPage.list" var="comm">
						<tr>
						<s:hidden value="#comm.commentContent"></s:hidden>
							<td><s:property value="#comm.commentTime"/></td>
							<td><a href="/BlankPage.jsp">查看</a></td>
							<td><a href="commentAction-deleteComment?iid=<s:property value="#comm.commentId"/>">删除</a></td>
						</tr>
					</s:iterator>
					</tbody>        
				</table>
				<div class="row" style="margin-left: 900px;">
				<table>
					<span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>
					<span>
						<s:if test="currPage!=1">
							<a href="commentAction-getCommByPage?currPage=1">[首页]</a>
							<a href="messageAction-getCommByPage?currPage=<s:property value="currPage-1"/>">[上一页]</a>
						</s:if>
						<s:if test="currPage!=totalPage">
							<a href="messageAction-getCommByPage?currPage=<s:property value="currPage+1"/>">[下一页]</a>
							<a href="messageAction-getCommByPage?currPage=<s:property value="totalPage"/>">[尾页]</a>
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
