<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>相似消息列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/specificMessageLeft.css">

  </head>
  
  <body>
  <div id="specificMessageLeft">
  <center>
    <table  style="font-size:12px;" style="table-layout:fixed;" width="100%" border="1" cellspacing="0" cellpadding="25">
    
  
   <tr height="20"> 
   <td  "word-wrap:break-word;" width="70%" style="text-indent:5" valign="bottom"><font color="#004790"> <a href="pages/show/specificMessageRight.jsp" target="specificMessageRight"> 料峭春风吹酒醒，微冷。 </a></font>
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2017.06.08</p>
   </td> 
   </tr>
   <tr>
   <td><a href="pages/show/specificMessageRight.jsp" target="specificMessageRight"> 两情若是久长时，又岂在朝朝暮暮。 </a>
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2017.06.08</p>
   </td>
   </tr>
    
   <tr>
  <td ><a href="pages/show/specificMessageRight.jsp" target="specificMessageRight"> 无言独上西楼，月如钩 </a>
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2017.06.08</p>
  </td>
   </tr>
   <tr>
   <td><a href="pages/show/specificMessageRight.jsp" target="specificMessageRight"> 衣带渐宽终不悔，为伊消得人憔悴 </a>
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2017.06.08</p>
   </td>
   </tr>
  
   </table>
   </center>
   </div>
  </body>
</html>
