<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>具体消息界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/styles.css">

  </head>
  
  <body>
   <div id="container">
     <div id="top">  <iframe src="pages/show/top.jsp" name="top"> </iframe></div>  
     <div id="left">  <iframe src="pages/show/specificMessageLeft.jsp" name="specificMessageLeft"></iframe></div>
     <div id="right"> <iframe src="pages/show/specificMessageRight.jsp" name="specificMessageRight"></iframe></div>
     <div id="foot"> <iframe src="pages/show/end.jsp" name="end"></iframe> </div>
     </div>
  </body>
</html>
