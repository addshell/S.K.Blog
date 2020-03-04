<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title></title>
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
<script type="text/javascript">
window.onload = function()
{
var oFCKeditor = new FCKeditor( 'comment.commentContent' ) ;
oFCKeditor.BasePath = "fckeditor/" ;
oFCKeditor.ToolbarSet = 'Default' ;
oFCKeditor.Height=400;
oFCKeditor.ReplaceTextarea();
}
</script>
  </head>
  <body>
    <!-- 评论发表区 -->
		<s:form action="articleAction-addArticle" method="post">
		  <table class="articleaddtable">
		  <tr>
		  	<td>
				<s:textarea name="comment.commentContent" cols="100" width="800px" height="80px"
				rows="5" id="comment.commentContent" label="评论"></s:textarea>
			</td>
		  </tr>
		  <s:submit class="btn tm-light-blue-bordered-btn pull-xs-right" value="发表"></s:submit>
		  </table>
		</s:form>
  </body>
</html>
