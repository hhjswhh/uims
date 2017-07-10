<%@page import="com.sdu.uims.vo.User"%>
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
	<!--<script type="text/javascript" src="uims/js/modifyPersonalInfo.js"></script>-->
	<script type="text/javascript">
		function saveInfo(){
				if(document.getElementById("userName").value==""){
					alert("用户名不能为空！");
				}else if(document.getElementById("userMail").value==""){
					alert("邮箱不能为空！");
				}else if(document.getElementById("userAddr").value==""){
					alert("地址不能为空！");
				}
				var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
				if(!reg.test(document.getElementById("userMail").value)){
					alert("邮箱格式不正确！");
				}
		}
	</script>
  </head>
  
  <body>
  		<%!
  			User user;
  		 %>
  		 <%
  		 	user = (User)request.getAttribute("userdata");
  		  %>
  		<div id="title">修改个人资料</div>
  		<div id="container">
  		  <form action="servlet/PersonalServlet" method="POST">
  		  		<div id="name" class="longAttribute">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp昵称:&nbsp&nbsp&nbsp&nbsp&nbsp<input id="userName" type="text" name="userName" value="<%=user.getName()%>" /></div>
	   			<div id="sexAndAge">
	   				<% int sex = Integer.parseInt(user.getSex()); %>
	   				<div class="shortAttribute">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp性别:&nbsp&nbsp&nbsp&nbsp&nbsp
	   					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input id="male" type="radio" name="userSex" <%= sex==0?"Checked":"" %>  value="0"/>男&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	   					<input id="female" type="radio" name="userSex" <%= sex==1?"Checked":"" %> value="1"/>女
	   				</div>
	   			</div>
	   			<div id="telAndEmail">
	   				<div>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp邮箱:&nbsp&nbsp&nbsp&nbsp&nbsp
	   					<input id="userMail" type="text" name="userMail" value="<%=user.getMail() %>" /><label>*此处按照邮箱的固定格式填写</label>
	   				</div>
	   			</div>
	   			
   				<div id="address" class="longAttribute">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp地址:&nbsp&nbsp&nbsp&nbsp&nbsp
   					<input id="userAddr" type="text" name="userAddr" value="<%=user.getAddr() %>" />
   					<label>*XXXX小区XX号楼XX单元XXX室</label>
   				</div>
   				
	   			<div id="options">
	   				<div id="saveOption" class="option"><input type="submit" value="保存" onclick="saveInfo()"/></div>
	   					<input type="hidden" name="methodNum" value="2"/>
	   				<div id="returnOption" class="option"><a href="uims/pages/personalCenter/default.jsp" target="right">返回</a></div>
	   			</div>
  		  </form>		
  			
  		</div>
   		
  </body>
</html>
