<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function  login(){
			//alert("登录");
			var username = document.getElementById("username").value;
			var password = document.getElementById("loginPassword").value;
			if(username==""){
				alert("用户名不能为空");
				return;
			}else if(password==""){
				alert("密码不能为空");
				return;
			}else{
				document.getElementById("loginform").submit();
			}
		}
	</script>
  </head>
  <body>
  	<center>
  		<form action="loginServlet" name="loginform" id="loginform" method="post" >
  			<table>
  				<tr>
	  				<td>手机号：</td>
	  				<td>
	  					<input type="text" name="username" id="username" value="1"/>
	  				</td>
  				</tr>
  				<tr>
  					<td>密码：</td>
  					<td>
  						<input type="password" name="loginPassword" id="loginPassword" value="2"/>
  						<input type="hidden" name="action"  value="login"/>
  					</td>
  				</tr>
  				<tr>
	  				<td>
	  					<input type="submit"  value="提交"/>
	  				</td>
	  				<td>
	  					<input type="button" value="登录" onclick="login();" />
	  				</td>
  				</tr>
  			</table>
  		</form>
  	</center>
  </body>
</html>
