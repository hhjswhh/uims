<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="uims/css/personalLeft.css">

  </head>
  
  <body>
    		<div id="personalInfo">
  				<img id="personalImage" src="uims/images/image.JPG"></img>
  				<div id="basicInfo">
  					<div id="name" class="basicInfoAttribute"><div>昵称:</div><div>么么哒</div></div>
  					<div id="sex" class="basicInfoAttribute"><div>性别:</div><div>男</div></div>
  					<div id="age" class="basicInfoAttribute"><div>年龄:</div><div>21岁</div></div>
  				</div>
  				<button id="logOut">注销</button>
  			</div>
  			<div id="options">
  				<div id="modifyInfo" class="option">
  					<div class="optionsButton">
  						<a href="uims/pages/personalCenter/modifyPersonalInfo.jsp" target="right">修改个人资料</a>
  					</div>
  				</div>
  				<div id="modifyPsd" class="option">
  					<div class="optionsButton">
  						<a href="uims/pages/personalCenter/modifyPassword.jsp" target="right">修改密码</a>
  					</div>
  				</div>
  				<div id="published" class="option">
  					<div class="optionsButton">
  						<a href="uims/pages/personalCenter/historyMessage.jsp" target="right">历史信息</a>
  					</div>
  				</div>
  				<div id="messageList" class="option">
  					<div class="optionsButton">
  						<a href="uims/pages/personalCenter/interactMessage.jsp" target="right">消息列表</a>
  					</div>
  				</div>
  			</div>
  </body>
</html>
