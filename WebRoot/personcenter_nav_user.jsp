<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'personcenter_nav.jsp' starting page</title>
	<link rel="stylesheet" type="text/css" href="css/menu_nav.css">
	<link rel="stylesheet" type="text/css" href="css/templatemo-style.css">
</head>
<body>
	<ul class="menu">
		<li class="nav-item"><div><a class="nav-link" href="">${ session_user.userName }</a></div>
			<ul>
				<li><a class="root-nav1" href="userAction-getUserUpdate?iid=${ session_user.userId }">个人信息</a>
					<!-- <ul>
						<li><a href="">Item 11</a></li>

						<li><a href="">Item 12</a></li>
						<li><a href="">Item 13</a></li>
						<li><a href="">Item 14</a></li>
					</ul>-->
					</li> 
				<li><a class="root-nav5" href="userAction-exitUser">退出</a>
					<!-- <ul>
						<li><a href="">Item 41</a></li>
						<li><a href="">Item 42</a></li>
						<li><a href="">Item 43</a></li>
						<li><a href="">Item 44</a></li>
					</ul> -->
				</li>
			</ul>
		</li>
	</ul>
</body>
</html>
