<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyPersonalInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="uims/css/modifyPersonalInfoCss.css">

  </head>
  
  <body>
  		<div id="title">修改个人资料</div>
  		<div id="container">
  			<div id="name" class="longAttribute">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp昵称:&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text"/></div>
   			<div id="sexAndAge">
   				<div class="shortAttribute">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp性别:&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp年龄:&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text"/></div>
   			</div>
   			<div id="telAndEmail">
   				<div class="shortAttribute">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp电话:&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp邮箱:&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text"/></div>
   			</div>
   			<div id="address" class="longAttribute">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp地址:&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text"/></div>
   			<div id="options">
   				<div id="saveOption" class="option"><a>保存</a></div>
   				<div id="returnOption" class="option"><a href="uims/pages/personalCenter/default.jsp" target="right">返回</a></div>
   			</div>
  		</div>
   		
  </body>
</html>
