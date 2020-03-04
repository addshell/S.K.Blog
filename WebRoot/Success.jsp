<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Success page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <div>
  <a href="articleAction-getArticleList">articleAction-getArticleList</a>
  <a href="commentAction-getCommentListByArticleId?iid=1">commentAction-getCommentById</a>
  <a href="categoryAction-getCategoryListByUserId?iid=25">categoryAction-getCategoryByUserId</a>
  <a href="userAction-registUser">userAction</a>
  </div>
    <table style="width: 500px; height: 800px; margin: 0; border: 2px solid red;">
    	<s:iterator value="userlist" var="user">
			<tr>
			<td>
			用户姓名
			</td>
			<td>
				<h1><s:property value="#user.userName"/></h1>
			</td>
			</tr>    	
    	</s:iterator>
    	</table>
    	
    	<div class="commentContent">
		<s:form action="commentAction-addComment" method="post">
		  <table>
		  <tr>
		  	<td>
				<s:textarea name="comment.commentContent" cols="100" width="800px" height="80px"
				rows="5" id="comment.commentContent" label="发表评论"></s:textarea>
			</td>
		  </tr>
		  <tr>
		  <td colspan="100" align="right">
		  <s:submit class="btn tm-light-blue-bordered-btn tm-news-link" value="发布"></s:submit>
		  </td>
		  </tr>
		  </table>
		</s:form>
    </body>
</html>
