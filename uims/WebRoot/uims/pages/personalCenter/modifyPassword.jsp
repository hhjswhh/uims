<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyPassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="uims/css/modifyPasswordCss.css">

  </head>
  
  <body>
  		<div id="title">修改密码</div>
  		<div id="container">
  			<div id="oldPassword" class="attribute">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp旧密码:&nbsp&nbsp&nbsp&nbsp&nbsp<input type="password"/></div>
  			<div id="newPassword" class="attribute">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp新密码:&nbsp&nbsp&nbsp&nbsp&nbsp<input type="password"/></div>
  			<div id="confirmPassword" class="attribute">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp确认密码:&nbsp&nbsp&nbsp&nbsp&nbsp<input type="password"/></div>
  			<div id="options">
  				<div id="saveOption" class="option"><a>保存</a></div>
   				<div id="returnOption" class="option"><a href="uims/pages/personalCenter/default.jsp" target="right">返回</a></div>
  			</div>
  		</div>
  </body>
</html>
