<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>S.K.的博客</title>
<!-- load stylesheets -->
<!-- <link rel="stylesheet" href="http://fonts.useso.com/css?family=Open+Sans:100,300,400">  -->
<!-- Google web font "Open Sans" -->
<link rel="stylesheet" href="css/cyrillic-ext.css">
<link rel="stylesheet"
	href="font-awesome-4.5.0/css/font-awesome.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Bootstrap style -->
<link rel="stylesheet" href="css/magnific-popup.css">
<!-- Magnific pop up style -->
<link rel="stylesheet" href="css/templatemo-style.css">
</head>

<body>
	<div class="tm-navbar-container">

		<!-- navbar   -->
		<nav class="navbar navbar-full navbar-fixed-top"> <!-- 		<button class="navbar-toggler hidden-md-up" type="button"
			data-toggle="collapse" data-target="#tmNavbar">&#9776;</button> -->

		<div class="collapse navbar-toggleable-sm" id="tmNavbar">

			<ul class="nav navbar-nav">
				<li class="nav-item"><a class="nav-link" href="index.jsp#top">欢迎进入</a></li>
				<li class="nav-item"><a class="nav-link" href="index.jsp#tm-section-2">博客日志</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="index.jsp#tm-section-3">精彩瞬间</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="index.jsp#tm-section-4">雁过留声</a>
				</li>

				<!-- 个人中心部分 -->
				<li class="nav-item">
					<div class="portrait">
						<div class="nav-menu">
						<s:if test="#session.session_user.root==true">
							<jsp:include page="personcenter_nav.jsp"></jsp:include>
						</s:if>
						<s:else>
							<jsp:include page="personcenter_nav_user.jsp"></jsp:include>
						</s:else>
						</div>
				</li>
		</div>
		</li>

		</ul>
	</div>

	</nav>

	</div>
</body>
</html>
