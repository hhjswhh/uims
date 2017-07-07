<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看详细信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/specificMessageRight.css">


  </head>
  
  <body >
      <div id="specificMessageRight">
      <center>
        <table width="100%" border="0"  cellspacing="0" cellpadding="0"  >
            <tr height="20"><td style="text-indent:5" valign="bottom"><font color="#004790"><b>■查看详细信息</b></font></td></tr>            
            <tr height="10"><td> </td></tr>
            <tr bgcolor="#FAFCF5">
                <td style="border:1 solid black">
                    <table  border="1" width="100%" cellspacing="0" cellpadding="2" height="40">
                        
                            <tr height="40">
                                <td width="100%" style="text-indent:20"> 信息类别：招聘信息</td>
                               
                            </tr>
                            <tr height="40">
                                <td width="100%" style="text-indent:20"> 发布时间：2017-06-08</td>
                                 
                            </tr>
                            <tr height="40">
                                <td width="100%"  style="text-indent:20">信息标题：招聘一名服务员</td>
                                
                            </tr>
                            <tr height="40">
                            <td colspan="2" style="text-indent:20">信息内容：</td>
                            
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <table   style="table-layout:fixed"  border="0" width="657" cellspacing="0" cellpadding="10" rules="none" frame="below" bordercolor="black" bordercolorlight="black" bordercolordark="black" height="243">
                                        <tr style="text-indent:20" height="150%" bgcolor="white"><td  style="word-break:break-all" colspan="3" valign="top" style="border:1 solid">
                                          ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss
                                        </td>
                                       
                                        </tr>
                                        <tr height="20" align="center">
                                            <td>联系电话：<b>13333333333</b> </td>
                                            <td>联系人：<b>周五正</b></td>
                                            <td>E-mial：<b>ssgsaddaffe@dgaad.com</b></td>
                                        </tr>
                                    </table>                      
                                </td>
                            </tr>
                            <tr height="63"><td align="center" colspan="2"><a href="homePage/homePage.jsp" target="_parent">返回</a></td></tr>                              
                     
                    </table>
                </td>
            </tr>
        </table>
        <br>
    </center>
    </div>
  </body>
</html>
