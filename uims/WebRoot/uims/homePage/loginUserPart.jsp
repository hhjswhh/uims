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

<title>My JSP 'loginUserPart.jsp' starting page</title>

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
			<!-- 这儿是用户头像 -->
			<!-- 用户头像向后台请求得到，现在还不知道怎么实现 -->
			<!--  
			<img alt="userPage" src="uims/images/default.jpg">
			-->
		</div>
		<div class="user_nicknames">
		<br/>
		<br/>
		这是昵称
		</div>
		<div class="userLink">
			<!-- 这儿是链接，发布信息，到个人中心和管理员后台的链接 -->
			<a href="uims/pages/add/publish.jsp" target="right">发布信息</a> 
			<a href="uims/pages/personalCenter/personalCenter.jsp" target="_top">个人中心</a> 
			<a href="umis/pages/admin/.jsp" target="_top">后台</a>
		</div>
	</div>
</body>
</html>
