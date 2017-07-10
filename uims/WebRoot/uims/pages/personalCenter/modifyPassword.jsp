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
	<script type="text/javascript">
		function savePassword(){
			if(document.getElementById("oldPwd").value==""){
				alert("旧密码不得为空!");
			}else if(document.getElementById("newPwd1").value==""){
				alert("新密码不能为空!");
			}else if(document.getElementById("newPwd2").value==""){
				alert("确认密码不能为空!");
			}else{
				if(document.getElementById("newPwd1").value==document.getElementById("oldPwd").value){
					alert("旧密码和新密码不能相同");
				}
				if(document.getElementById("newPwd1").value!=document.getElementById("newPwd2").value){
					alert("两次输入的新密码必须相同");
				}
			}
		}
	</script>
  </head>
  
  <body>
  		<div id="title">修改密码</div>
  		<div id="container">
  		<form action="servlet/PersonalServlet" method="post">
  			<div id="oldPassword" class="attribute">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp旧密码:&nbsp&nbsp&nbsp&nbsp&nbsp<input id="oldPwd" type="password" name="oldPwd"/></div>
  			<div id="newPassword" class="attribute">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp新密码:&nbsp&nbsp&nbsp&nbsp&nbsp<input id="newPwd1" type="password"  name="newPwd1"/></div>
  			<div id="confirmPassword" class="attribute">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp确认密码:&nbsp&nbsp&nbsp&nbsp&nbsp<input id="newPwd2" type="password"  name="newPwd2"/></div>
  			<div id="options">
  				<div id="saveOption" class="option"><input type="submit" value="保存" onclick="savePassword()"/></div>
  					<input type="hidden" name="methodNum" value="3"/>
   				<div id="returnOption" class="option"><a href="uims/pages/personalCenter/default.jsp" target="right">返回</a></div>
  			</div>
  			
  			<%  String result = (String)request.getAttribute("changeResult"); 
  				if(result==null){
  				
  				}else if("WrongPwd".equals(result)){ %>
  					<script>alert("旧密码填写错误")</script>
  			<% }
  			%>
  			
  		</form>
  		</div>
  </body>
</html>
