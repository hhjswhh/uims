<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="uims/css/top.css">

  </head>
  
  <body>
   			<div id="navigateBar">
  				<div id="logo">logo</div>
  				<div id="homePage" class="classifedPart">a</div>
  				<div id="cruit" class="classifedPart">b</div>
  				<div id="teach" class="classifedPart">c</div>
  				<div id="transction" class="classifedPart">d</div>
  				<div id="employee" class="classifedPart">e</div>
  				<div id="search" class="classifedPart">f</div>
  				<div id="investment" class="classifedPart">g</div>
  			</div>
  			<div id="advertiseBar">
  				advertisement
  			</div>
  			<div id="emergentBar">
  				<div id="emergence">我老公最近有点奇怪.....</div>
  			</div>
  </body>
</html>
