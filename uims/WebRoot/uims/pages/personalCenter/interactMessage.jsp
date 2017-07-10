<%@page import="com.sdu.uims.vo.Message"%>
<%@page import="com.sdu.uims.vo.Info"%>
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
	<link rel="stylesheet" type="text/css" href="uims/css/interactMessage.css">

  </head>
  
  <body>
  		<div id="title">用户消息</div>
		<div id="container">
			<%!
				List list;
				Message message;
			 %>
			 <%
			 	list = (List)request.getAttribute("message");
			 %>
			 <%for(int i=0; i<list.size(); i++){%>
			<div class="message">
					<%
						message = (Message)list.get(i);
					 %>
					<div id="contentContainer"><div>消息内容:</div><div class="content">&nbsp&nbsp&nbsp&nbsp&nbsp<%=message.getMessageContext()%></div></div>
					<div id="timeContainer"><%=message.getDate().substring(0, 10) %></div>
			</div><hr/>
			<%} %>
			
			
			<!-- <div class="message">
					<%
						message = (Message)list.get(0);
					 %>
					<div id="contentContainer"><div>消息内容:</div><div class="content">&nbsp&nbsp&nbsp&nbsp&nbsp<%=message.getMessageContext()%></div></div>
					<div id="timeContainer"><%=message.getDate().substring(0, 10) %></div>
			</div><hr/>
			<div class="message">
					<%
						message = (Message)list.get(0);
					 %>
					<div id="contentContainer"><div>消息内容:</div><div class="content">&nbsp&nbsp&nbsp&nbsp&nbsp<%=message.getMessageContext()%></div></div>
					<div id="timeContainer"><%=message.getDate().substring(0, 10) %></div>
			</div><hr/>
			<div class="message">
					<%
						message = (Message)list.get(0);
					 %>
					<div id="contentContainer"><div>消息内容:</div><div class="content">&nbsp&nbsp&nbsp&nbsp&nbsp<%=message.getMessageContext()%></div></div>
					<div id="timeContainer"><%=message.getDate().substring(0, 10) %></div>
			</div><hr/>
			<div class="message">
					<%
						message = (Message)list.get(0);
					 %>
					<div id="contentContainer"><div>消息内容:</div><div class="content">&nbsp&nbsp&nbsp&nbsp&nbsp<%=message.getMessageContext()%></div></div>
					<div id="timeContainer"><%=message.getDate().substring(0, 10) %></div>
			</div><hr/>
			 -->
			 
			 <% //String page = request.getAttribute("");
			
			int pages = Integer.parseInt((String)request.getAttribute("page")); 
			int pagenum = (Integer)request.getAttribute("pagenum");
			
			%>
			<div id="options">
				<div id="previousPage"><a href="servlet/PersonalServlet?methodNum=5&page=<%= --pages %>" target="right">上一页</a></div>
				<div id="nextPage"><a href="servlet/PersonalServlet?methodNum=5&page=<%= pages+=2 %>" target="right">下一页</a></div>
				<div id="jumpPage">跳转到<input type="text" style="width: 22px;height: 22px; border: 1px solid black"/>/<%= pagenum %>页</div>
			</div>
		</div>
  </body>
</html>
