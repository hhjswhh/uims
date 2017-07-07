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

<title>signUp</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="uims/css/login.css">


</head>

<body>
	<div id="container">
		<div>
			<form action="" method="post">
				用户名：<input type="text" name="username" /><br /> 
				密         码：            <input type="password" name="password" /><br /> 
				<input type="submit" name="signUp" value="提交" /> 
				<a href="uims/homePage/homePage.jsp">登录</a>
			</form>
		</div>
	</div>
</body>
</html>
