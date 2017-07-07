<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发布信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="uims/css/publish.css">
	

  </head>
  
  <body id="publish">
  <div >发布信息</div>                                       <!-- 发布信息标题 -->
    <table id="table" border="1">                                    <!-- 创建表格 -->
    <tr id="tr1">
    <td id="信息类别">信息类别：</td>
    <td>
    
    <select id="code" name="plugin">
    <option value="1">招聘信息</option>
    <option value="2">培训信息</option>
    <option value="3">房屋信息</option>
    <option value="4">求购信息</option>
    <option value="5">招商引资</option>
    <option value="6">公寓信息</option>
    <option value="7">求职信息</option>
    <option value="8">家教信息</option>
    <option value="9">车辆信息</option>
    <option value="10">出售信息</option>
    <option value="11">寻找信息</option>
    </select>
     </td>
    <td>[信息标题最多不得超过60个字母]</td>
    </tr>
    <tr>
    <td>信息标题：</td>
    <td id="title"><input type="text" maxlength="60" /></td>
    </tr>
    <tr>
    <td>信息内容：</td>
    <td>
  
    <span id='textNum'>0</span>/500</span>
  
    </td>
    <td>[信息内容最多不得超过500个字符]</td>
    </tr>
    <tr>
    
    <td colspan="3"><textarea rows="20" maxlength="500"  id="content"></textarea>
    </td>
    
    </tr>
    <tr>
    <td>联系电话：</td>
    <td><input type="text" /></td>
    <td>[多个电话以逗号相隔!]</td>
    </tr>
    <tr>
    <td>联系人：</td>
    <td colspan="2"><input type="text"/></td>
    </tr>
    <tr>
    <td>E-mail:</td>
    <td colspan="2"><input type="text" /></td>
    </tr>
    </table> 
    <button id="pub" onclick="window.location.href='uims/pages/add/pub.jsp'">发布</button>
    <button id="refresh" onclick="window.location.href='uims/pages/add/publish.jsp'">重填</button><br>
  </body>
</html>
