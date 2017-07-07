<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'unLogUserPart.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="uims/css/login.css">


</head>

<body>
    <div class="loginContainer">
		<div class="userImg">
			<!-- 这里是头像 	-->
			<!--  
			<img alt="头像" src="uims/images/default.jpg" width="50" height="50">
			-->
		</div>
		<div class="user_nicknames">
		<br/>
		这是昵称hhhh<br/><br/><br/>
			<!-- 这儿是链接，用于登录或者注册-->
			<form action="" name="login" method="post">
			用户名： <input type="text" name="username"/>
			<br/><br/>
			密&nbsp;&nbsp;码： &nbsp;<input type="password" name="password"/>
			<br/><br/>
			 <input type="submit" name="login" value="登录"/>
			</form>
		</div>
		<div class="userLink">
		<br/><br/>
			<a href="uims/pages/signUp.jsp" target="_black">注册</a>
		</div>
	</div>

</body>
</html>
