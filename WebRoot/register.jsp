<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>注册</title>
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
<link rel="stylesheet" href="css/validform.css">

<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body id="top" class="page-2">
	<div class="content-web">
		<!-- 导航栏 -->
		<div class="tm-navbar-container tm-navbar-container-dark">
		<s:if test="#session.session_user!=null">
			<jsp:include page="header_lg.jsp"></jsp:include>
		</s:if>
		<s:else>
			<jsp:include page="header_unreg.jsp"></jsp:include>
		</s:else>
		</div>

		<div class="nav-login"></div>

		<div class="content-login">
			<div class="nav-cont">
				<div class="nav-tit">
					<img alt="注册" src="content-img/UI-img/nav_regist.png">
				</div>
			</div>

			<div class="content_reg">
				<form action="userAction-registUser" method="post" class="registerform">
					<div class="form-control-login">
						<input type="text" id="user.userName" name="user.userName"
							class="form-control" placeholder="请输入用户名" datatype="s4-18" errormsg="用户名至少4个字符,最多18个字符！"/> 
							<div class="Validform_checktip"></div>
						<input type="password" id="userPass" name="user.userPass" class="form-control"
							placeholder="请输入密码" datatype="s6-18" errormsg="密码至少6个字符,最多18个字符！"/> 
							<div class="Validform_checktip"></div>
						<input type="password" class="form-control" 
						datatype="*" recheck="userPass" nullmsg="请再输入一次密码！" errormsg="您两次输入的账号密码不一致！" placeholder="请再次输入密码" /> 
							<div class="Validform_checktip"></div>
						<select name="country_code" id="country_code" class="form-control-ccode">
							<option value="1" code="86">中国大陆</option>
							<option value="5" code="852">香港特别行政区</option>
							<option value="2" code="853">澳门特别行政区</option>
							<option value="3" code="886">台湾地区</option>
							<option value="4" code="1">美国</option>
							<option value="6" code="32">比利时</option>
							<option value="7" code="61">澳大利亚</option>
							<option value="8" code="33">法国</option>
							<option value="9" code="1">加拿大</option>
							<option value="10" code="81">日本</option>
							<option value="11" code="65">新加坡</option>
							<option value="12" code="82">韩国</option>
							<option value="13" code="60">马来西亚</option>
							<option value="14" code="44">英国</option>
							<option value="15" code="39">意大利</option>
							<option value="16" code="49">德国</option>
							<option value="18" code="7">俄罗斯</option>
							<option value="19" code="64">新西兰</option>
						</select>
						<input type="text" id="user.userPhone" name="user.userPhone" class="form-control-phone"
							placeholder="请输入手机号" datatype="m" errormsg="请输入正确的手机号码！" nullmsg="请输入手机号码!"/>
							<div class="Validform_checktip"></div>
						<%-- <div class="form-control-vercode">
							<input type="text" id="reg_vercode" name="reg_vercode"
								class="form-control" placeholder="请输入验证码" recheck="${ picCode }" nullmsg="请输入验证码！" errormsg="您输入的验证码错误！"> 
							<img alt="刷新验证码" src="img/test-img.jpg">&nbsp;
							<a href="#">换一张</a>
						</div> --%>
						<br>
						<button type="reset"
							class="btn tm-light-blue-bordered-btn pull-xs-right">重填</button>
						<button type="submit"
							class="btn tm-light-blue-bordered-btn pull-xs-right">注册</button>
					</div>
				</form>
			</div>
			
			<div class="logo22">
			<img alt="logo22" src="content-img/UI-img/22login.png">
			</div>
			<div class="logo33">
			<img alt="logo33" src="content-img/UI-img/33login.png">
			</div>
		</div>
		
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/Validform.js"></script>
<script type="text/javascript">
$(function(){
	$(".registerform:first").Validform();
	//调取公用方法显示信息提示框，可用于全站统一的弹出框提示效果;
	//$.Showmsg("Test Info here!");  //公用方法显示信息提示框;
})
</script>
</body>
</html>