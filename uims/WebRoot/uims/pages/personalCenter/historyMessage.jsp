<%@page import="com.sdu.uims.vo.Info"%>
<%@page import="com.sdu.uims.vo.Message"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'historyMessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="uims/css/historyMessage.css">

  </head>
  
  <body>
  		<div id="title">历史信息</div>
		<div id="container">
			<%!
  			List list;
  			Info info;
  			 %>
  			 <%
  			 	list = (List)request.getAttribute("info");
  			 	System.out.println("list size: "+list.size());
  			 %>
  			 <%for(int i=0; i<list.size(); i++){%>
			<div class="message">
				<%
					info = (Info)list.get(i);
				 %>
				<div id="titleContainer"><div>标题:</div><div id="messageTitle"><%=info.getTitle()%></div></div>
				<div id="contentTimeContainer">
					<div id="contentContainer"><div>内容:</div><div id="content"><%=info.getContext() %></div></div>
					<div id="timeContainer"><%=info.getDate().substring(0, 10)%></div>
				</div>
			</div><hr/>
			<%} %>
			
			<!-- 
			<div class="message">
				<%
					info = (Info)list.get(0);
				 %>
				<div id="titleContainer"><div>标题:</div><div id="messageTitle"><%=info.getTitle()%></div></div>
				<div id="contentTimeContainer">
					<div id="contentContainer"><div>内容:</div><div id="content"><%=info.getContext() %></div></div>
					<div id="timeContainer"><%=info.getDate().substring(0, 10)%></div>
				</div>
			</div><hr/>
			<div class="message">
				<%
					info = (Info)list.get(0);
				 %>
				<div id="titleContainer"><div>标题:</div><div id="messageTitle"><%=info.getTitle()%></div></div>
				<div id="contentTimeContainer">
					<div id="contentContainer"><div>内容:</div><div id="content"><%=info.getContext() %></div></div>
					<div id="timeContainer"><%=info.getDate().substring(0, 10) %></div>
				</div>
			</div><hr/>
			<div class="message">
				<%
					info = (Info)list.get(0);
				 %>
				<div id="titleContainer"><div>标题:</div><div id="messageTitle"><%=info.getTitle()%></div></div>
				<div id="contentTimeContainer">
					<div id="contentContainer"><div>内容:</div><div id="content"><%=info.getContext() %></div></div>
					<div id="timeContainer"><%=info.getDate().substring(0, 10)%></div>
				</div>
			</div><hr/>
			<div class="message">
				<%
					info = (Info)list.get(0);
				 %>
				<div id="titleContainer"><div>标题:</div><div id="messageTitle"><%=info.getTitle()%></div></div>
				<div id="contentTimeContainer">
					<div id="contentContainer"><div>内容:</div><div id="content"><%=info.getContext() %></div></div>
					<div id="timeContainer"><%=info.getDate().substring(0, 10)%></div>
				</div>
			</div><hr/>
			 -->
			
			<% //String page = request.getAttribute("");
			
			int pages = Integer.parseInt((String)request.getAttribute("page")); 
			int pagenum = (Integer)request.getAttribute("pagenum");
			%>
			<div id="options">
				<div id="previousPage"><a href="servlet/PersonalServlet?methodNum=4&page=<%= --pages %>" target="right">上一页</a></div>
				<div id="nextPage"><a href="servlet/PersonalServlet?methodNum=4&page=<%= pages+=2 %>" target="right">下一页</a></div>
				<div id="jumpPage">跳转到<input type="text" style="width: 22px;height: 22px; border: 1px solid black"/>/<%= pagenum %>页</div>
			</div>
		</div>
  </body>
</html>
