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

<title>homepage</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="uims/css/homePage.css">

</head>

<body>
	<div id="container">
		<div id="top"><iframe src="uims/homePage/top.jsp" name="top"></iframe></div>
		<div id="left">
				<!-- 此处应该有一个判断，已登陆加载loginUserPart。jsp，否则加载UnloginuserPart.jsp,多余，可以让用户在注册完成后在首页登陆完成页面跳转 -->
			<div id="leftUp"><iframe src="uims/homePage/loginUserPart.jsp" name="leftUp"></iframe></div>
			<div id="leftDown"><iframe src="uims/homePage/search.jsp" name="leftDown"></iframe></div>
		</div>
		<div id="right"><iframe src="uims/homePage/classifiedRight.jsp" name="right"></iframe></div>
		<div id="end"><iframe src="uims/homePage/end.jsp" name="end"></iframe></div>
	</div>
</body>
</html>
