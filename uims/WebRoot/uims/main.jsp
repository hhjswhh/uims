<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>都市信息管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
  </head>
  <body>
    <div id="container">
    	<div id="top"><iframe src="uims/top.jsp" name="top"></iframe></div>
    	<div id = "left"><iframe src="uims/left.jsp" name="left"></iframe></div>
    	<div id="middle"><iframe src="uims/default.jsp" name="middle"></iframe></div>
    	<div id="right"><iframe src="uims/right.jsp" name="right"></iframe></div>
    	<div id="foot"><iframe src="uims/foot.jsp" name="foot"></iframe></div>
    </div>
  </body>
</html>
