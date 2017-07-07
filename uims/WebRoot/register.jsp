<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <center>
    <form action="registerServlet" method="post">
     <table>
         <tr>
             <th colspan="2">注册界面</th>
         </tr>
         <tr>
             <td>手机号</td>
             <td><input type="text" name="registerPhone" ></td>
         </tr>
         <tr>
            <td>密码</td>
            <td><input type="text"  name="registerPassword" ></td>
        </tr>
        <tr>
             <td>昵称</td>
             <td><input type="text" name="registerName" ></td>
         </tr>
         <tr>
            <td>性别</td>
            <td><input type="text" name="registerSex" ></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="registerMail" ></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="registerAddr" ></td>
        </tr>
         <tr>
            <td>头像</td>
            <td><input type="file" name="registerHead"></td>
        </tr>
    </table>
     <input type="submit" value="提交">
     </center>
 	</form>
  </body>
</html>
