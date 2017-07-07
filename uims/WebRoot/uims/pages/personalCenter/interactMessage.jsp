<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'interactMessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="uims/css/historyMessageCss.css">

  </head>
  
  <body>
  		<div id="title">用户消息</div>
		<div id="container">
			<div class="message">
				<div id="titleContainer"><div>标题:</div><div id="messageTitle">我老公最近,有点奇怪.........</div></div>
				<div id="contentTimeContainer">
					<div id="contentContainer"><div>内容:</div><div id="content">最近老公总是打电话，还不让我听........</div></div>
					<div id="timeContainer">2017-07-05</div>
				</div>
			</div><hr/>
			<div class="message">
				<div id="titleContainer"><div>标题:</div><div id="messageTitle">我老公最近,有点奇怪.........</div></div>
				<div id="contentTimeContainer">
					<div id="contentContainer"><div>内容:</div><div id="content">最近老公总是打电话，还不让我听........</div></div>
					<div id="timeContainer">2017-07-05</div>
				</div>
			</div><hr/>
			<div class="message">
				<div id="titleContainer"><div>标题:</div><div id="messageTitle">我老公最近,有点奇怪.........</div></div>
				<div id="contentTimeContainer">
					<div id="contentContainer"><div>内容:</div><div id="content">最近老公总是打电话，还不让我听........</div></div>
					<div id="timeContainer">2017-07-05</div>
				</div>
			</div><hr/>
			<div class="message">
				<div id="titleContainer"><div>标题:</div><div id="messageTitle">我老公最近,有点奇怪.........</div></div>
				<div id="contentTimeContainer">
					<div id="contentContainer"><div>内容:</div><div id="content">最近老公总是打电话，还不让我听........</div></div>
					<div id="timeContainer">2017-07-05</div>
				</div>
			</div><hr/>
			<div class="message">
				<div id="titleContainer"><div>标题:</div><div id="messageTitle">我老公最近,有点奇怪.........</div></div>
				<div id="contentTimeContainer">
					<div id="contentContainer"><div>内容:</div><div id="content">最近老公总是打电话，还不让我听........</div></div>
					<div id="timeContainer">2017-07-05</div>
				</div>
			</div><hr/>
			<div id="options">
				<div id="previousPage"><a href="uims/pages/personalCenter/default.jsp" target="right">上一页</a></div>
				<div id="nextPage"><a href="uims/pages/personalCenter/default.jsp" target="right">下一页</a></div>
				<div id="jumpPage">跳转到<input type="text" style="width: 22px;height: 22px; border: 1px solid black"/>/5页</div>
			</div>
		</div>
  </body>
</html>
