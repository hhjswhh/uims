<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>用户注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		//注册用户
		function register(){
			alert("注册");
			document.getElementById("regformid").submit();
		}
		
		function to(){
			alert("提交");
			document.getElementById("regformid").submit();
		}
	</script>
  </head>
  <body>
    <form  action="userServlet" id="regformid" method="post" onsubmit="return to();">
    	<table>
    		<tr><td>用户名:</td><td><input type="text" name="username"  id = "username" /></td></tr>
    		<tr><td>电话：</td><td><input type="text" name="phone" id="phone" /></td></tr>
    		<tr><td>地址：</td><td><input type="text" name="address" id="address" /></td></tr>
    		<tr><td>密码：</td><td><input type="password" name="password" id="password" /></td></tr>
    		<tr>
    		<td><input type="button" value="注册" onclick="register();" /></td>
    		<td><input type="submit" value="提交" /></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
