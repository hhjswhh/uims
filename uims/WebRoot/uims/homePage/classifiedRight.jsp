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

<title>rightPage</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="uims/css/rightArea.css">


</head>

<body>
	<div id="infoListContainer">
		<!-- 招商引资模块 -->
		<div class="module">
			<div class="title">招商引资</div>
			<div class="info_module">
			<a href="" target="right">1</a><br/>
			<a href="" target="right">2</a><br/>
			<a href="" target="right">3</a><br/>
			<a href="" target="right">4</a><br/>
			</div>
		</div>
		<!-- 求职模块 -->
		<div class="module">
			<div class="title">求职</div>
			<div class="info_module">2</div>
		</div>
		<!-- 培训信息模块 -->
		<div class="module">
			<div class="title">培训</div>
			<div class="info_module">3</div>
		</div>
		<!-- 购房信息模块 -->
		<div class="module">
			<div class="title">购房</div>
			<div class="info_module">4</div>
		</div>
		<!-- 交易信息模块 -->
		<div class="module">
			<div class="title">交易</div>
			<div class="info_module">5</div>
		</div>
		<!-- 汽车信息模块 -->
		<div class="module">
			<div class="title">汽车</div>
			<div class="info_module">6</div>
		</div>
		<!-- 招聘信息模块 -->
		<div class="module">
			<div class="title">招聘</div>
			<div class="info_module">7</div>
		</div>
		<!-- 寻找信息模块-->
		<div class="module">
			<div class="title">寻找</div>
			<div class="info_module">8</div>
		</div>

	</div>
</body>
</html>
