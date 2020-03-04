<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
<!-- Templatemo style -->

<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body id="top" class="home">

	<div class="container-fluid">
		<div class="row">
			<s:if test="#session.session_user!=null">
			<jsp:include page="header_lg.jsp"></jsp:include>
			</s:if>
			<s:else>
			<jsp:include page="header_unreg.jsp"></jsp:include>
			</s:else>
		</div>

		<div class="row">
			<div class="tm-intro">
				<section id="tm-section-1">
				<div class="tm-container text-xs-center tm-section-1-inner">
					<img src="content-img/UI-img/logo.png" alt="Logo" class="tm-logo">
					<h1 class="tm-site-name">SleepingKnight</h1>
					<p class="tm-intro-text">欢迎进入SleepingKnight的博客</p>
					<a href="#tm-section-2" class="tm-intro-link">开始</a>
				</div>
				</section>
			</div>
		</div>

		<div class="row gray-bg">

			<div id="tm-section-2" class="tm-section">
				<div class="tm-container tm-container-wide">
					<div class="tm-news-item">

						<div
							class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-news-item-img-container">
							<img src="img/tm-600x300-01.jpg" alt="Image"
								class="img-fluid tm-news-item-img">
						</div>

						<div
							class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-news-container">
							<h2 class="tm-news-title dark-gray-text">我的博文</h2>
							<p class="tm-news-text">
								或许前路永夜<br> 即使如此<br> 我还是要充满信心、继续向前<br>
								因为星光即使微弱也会为我照亮前途<br>
							</p>
							<a href="articleAction-getArticleByPage"
								class="btn tm-light-blue-bordered-btn tm-news-link">进入</a>
						</div>
					</div>

					<div class="tm-news-item">

						<div
							class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 flex-order-2 tm-news-item-img-container">
							<img src="img/tm-600x300-02.jpg" alt="Image"
								class="img-fluid tm-news-item-img">
						</div>

						<div
							class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-news-container flex-order-1">
							<h2 class="tm-news-title dark-gray-text">问答版块</h2>
							<p class="tm-news-text">我想我永远也忘不了这一天 <br>
							本该匍匐在地的妖精<br>
							 在飞舞<br>
							就如同凛然绽放的绯色之花</p>
							<a href="#" class="btn tm-light-blue-bordered-btn tm-news-link">进入</a>
						</div>
					</div>

					<div class="tm-news-item">

						<div
							class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-news-item-img-container">
							<img src="img/tm-600x300-03.jpg" alt="Image"
								class="img-fluid tm-news-item-img">
						</div>

						<div
							class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-news-container">
							<h2 class="tm-news-title dark-gray-text">给我们留下你宝贵的意见吧。。</h2>
							<p class="tm-news-text"><br>万箭穿心终不悔<br> 相视一笑轻王权<br><br></p>
							<a href="#tm-section-4" class="btn tm-light-blue-bordered-btn tm-news-link">进入</a>
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- row -->

		<div class="row">

			<section id="tm-section-3" class="tm-section">
			<div class="tm-container text-xs-center">

				<h2 class="blue-text tm-title">世间精彩瞬间</h2>
				<p class="margin-b-5">
					立于浮华之世<br>奏响天籁之音
				</p>

				<div class="tm-img-grid">
					<div class="tm-gallery-img-container">
						<a href="img/tm-450x300-01.jpg" class="tm-gallery-img-link"> <img
							src="img/tm-450x300-01.jpg" alt="Image"
							class="img-fluid tm-gallery-img"> <!-- 300x200 -->
						</a>
					</div>
					<div class="tm-gallery-img-container">
						<a href="img/tm-450x300-07.jpg" class="tm-gallery-img-link"> <img
							src="img/tm-450x300-07.jpg" alt="Image"
							class="img-fluid tm-gallery-img">
						</a>
					</div>
					<div class="tm-gallery-img-container">
						<a href="img/tm-450x300-02.jpg" class="tm-gallery-img-link"> <img
							src="img/tm-450x300-02.jpg" alt="Image"
							class="img-fluid tm-gallery-img">
						</a>
					</div>
					<div class="tm-gallery-img-container">
						<a href="img/tm-450x300-09.jpg" class="tm-gallery-img-link"> <img
							src="img/tm-450x300-09.jpg" alt="Image"
							class="img-fluid tm-gallery-img">
						</a>
					</div>
					<div class="tm-gallery-img-container">
						<a href="img/tm-450x300-03.jpg" class="tm-gallery-img-link"> <img
							src="img/tm-450x300-03.jpg" alt="Image"
							class="img-fluid tm-gallery-img">
						</a>
					</div>
					<div class="tm-gallery-img-container">
						<a href="img/tm-450x300-08.jpg" class="tm-gallery-img-link"> <img
							src="img/tm-450x300-08.jpg" alt="Image"
							class="img-fluid tm-gallery-img">
						</a>
					</div>
					<div class="tm-gallery-img-container">
						<a href="img/tm-450x300-10.jpg" class="tm-gallery-img-link"> <img
							src="img/tm-450x300-10.jpg" alt="Image"
							class="img-fluid tm-gallery-img">
						</a>
					</div>
					<div class="tm-gallery-img-container">
						<a href="img/tm-450x300-04.jpg" class="tm-gallery-img-link"> <img
							src="img/tm-450x300-04.jpg" alt="Image"
							class="img-fluid tm-gallery-img">
						</a>
					</div>
					<div class="tm-gallery-img-container">
						<a href="img/tm-450x300-05.jpg" class="tm-gallery-img-link"> <img
							src="img/tm-450x300-05.jpg" alt="Image"
							class="img-fluid tm-gallery-img">
						</a>
					</div>
					<div class="tm-gallery-img-container">
						<a href="img/tm-450x300-11.jpg" class="tm-gallery-img-link"> <img
							src="img/tm-450x300-11.jpg" alt="Image"
							class="img-fluid tm-gallery-img">
						</a>
					</div>
					<div class="tm-gallery-img-container">
						<a href="img/tm-450x300-06.jpg" class="tm-gallery-img-link"> <img
							src="img/tm-450x300-06.jpg" alt="Image"
							class="img-fluid tm-gallery-img">
						</a>
					</div>
					<div class="tm-gallery-img-container">
						<a href="img/tm-450x300-12.jpg" class="tm-gallery-img-link"> <img
							src="img/tm-450x300-12.jpg" alt="Image"
							class="img-fluid tm-gallery-img">
						</a>
					</div>
				</div>
			</div>
			</section>

		</div>
		<!-- row -->

		<div class="row gray-bg">

			<section id="tm-section-4" class="tm-section">
			<div class="tm-container">

				<h2 class="blue-text tm-title text-xs-center">联系我们</h2>

				<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xl-8">
					<form action="messageAction-addMessage" method="post" class="tm-contact-form">
						<div
							class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 tm-form-group-left">
							<input type="text" id="message.messageUserName" name="message.messageUserName"
								class="form-control" placeholder="你的姓名" required />
						</div>
						<div
							class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 tm-form-group-right">
							<input type="email" id="message.messageEmail" name="message.messageEmail"
								class="form-control" placeholder="电子邮箱" required />
						</div>
						<div class="form-group">
							<input type="text" id="message.messageName" name="message.messageName"
								class="form-control" placeholder="请输入主题" required />
						</div>
						<div class="form-group">
							<textarea id="message.messageContent" name="message.messageContent"
								class="form-control" rows="6" placeholder="请输入留言内容" required></textarea>
						</div>

						<button type="submit"
							class="btn tm-light-blue-bordered-btn pull-xs-right">提交</button>
					</form>
				</div>
				<!-- col -->

				<div
					class="col-xs-12 col-sm-12 col-md-4 col-lg-4 col-xl-4 margin-top-xs-50">
					<h3 class="light-blue-text tm-subtitle">工作室简介</h3>
					<p>邹城市海岸线计算技术工作室</p>
					<p>
						手机号码: <a href="tel:15554951805">15554951805</a><br> 电子邮件: <a
							href="mailto:806636198@qq.com">806636198@qq.com</a>
					</p>
				</div>
			</div>
			</section>

			<!-- footer -->
			<footer class="tm-footer">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
				<p class="text-xs-center tm-footer-text">
					Copyright &copy; 2017.Company name All rights reserved.<a
						target="_blank" href="#">海岸线计算技术工作室</a>
				</p>
				<p class="text-xs-center tm-footer-text">
					<a target="_blank" href="http://www.miitbeian.gov.cn">鲁ICP备16024046号-1</a>
				</p>
			</div>
			</footer>

		</div>
		<!-- row -->

	</div>
	<!-- container-fluid -->

	<!-- 读取js -->
	<!-- 使用jquery后影响<a>标签的href事件 -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/tether.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.singlePageNav.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<!-- 模板js -->
	<%-- <script src="js/templatemo_scripts.js"></script> --%>

</body>
</html>