<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>登录</title>
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
	<div class="content-web">
		<!-- 导航栏 -->
		<div class="tm-navbar-container tm-navbar-container-dark">
			<jsp:include page="header_unreg.jsp"></jsp:include>
		</div>

		<div class="nav-login"></div>

		<div class="content-login">
			<div class="nav-cont">
				<div class="nav-tit">
					<img alt="登录" src="content-img/UI-img/nav-cont.png">
				</div>
			</div>

			<div class="content">
				<div class="content-left">
					<div class="content-left-cont"></div>
					<div class="content-left-img">
						<img alt="图片" src="content-img/UI-img/2233login.png">
					</div>
				</div>

				<!--   登录表单部分 -->
				<div class="content-right">
					<div class="login_load">
						<img alt="登录" src="content-img/UI-img/loadTV.gif">
					</div>
					<form action="userAction-getUserLogin" method="post">
						<div class="form-control-login">
							<input type="text" id="login_username" name="login_username"
								class="form-control" placeholder="请输入用户名" required /> <input
								type="password" id="login_userpass" name="login_userpass"
								class="form-control" placeholder="请输入密码" required />
							<!-- <div class="form-control-vercode">
								<input type="text" id="login_vercode" name="login_vercode"
									class="form-control" placeholder="请输入验证码" required> <img
									alt="刷新验证码" src="img/test-img.jpg">&nbsp; <a href="#">换一张</a>
							</div> -->
							<br>
							<a href="#">忘记密码？></a>
							<button type="reset"
								class="btn tm-light-blue-bordered-btn pull-xs-right">重置</button>
							<button type="submit"
								class="btn tm-light-blue-bordered-btn pull-xs-right">登录</button>
						</div>
					</form>
				</div>
			</div>
		</div>
</body>
</html>