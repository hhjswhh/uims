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

<title>My JSP 'search.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="uims/css/login.css">


</head>

<body>
	<div id="searchContainer">
	 <p>信息快速检索</p>
	 <div id="search_form">
		<form action="" method="post" name="search">
		   
			<p>
				关键字：<input type="text" name="keyword" />
			</p>
			<p>
				条&nbsp;&nbsp;&nbsp;件：&nbsp;<select name="search_keyword">
					<option value="ID值">ID值</option>
					<option value="E-mail地址">E-mail地址</option>
					<option value="信息标题">信息标题</option>
					<option value="信息内容">信息内容</option>
					<option value="联系人">联系人</option>
					<option value="联系电话">联系电话</option>
				</select>
				<input type="submit" value="查询"/>
			</p>
			<p>
				搜索方式：<input type="radio" name="searchType" value="全局搜索" />全局搜索 
				<input type="radio" name="searchType" value="模糊搜索" />模糊搜索
			</p>
		</form>
		</div>
	</div>
</body>
</html>
