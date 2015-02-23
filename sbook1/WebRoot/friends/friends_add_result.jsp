<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>编写邮件结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/time.js" type="text/javascript"></script>

  </head>
  
  <body style=""><%--${requestScope.result } --%>
  <div style="margin: 0 auto;height: 130px;width: 400px;margin-top: 200px;">
  	<table border="0">
  		<tr><td rowspan="3"><img src="images/rabit.gif" height="90" width="73"></td><td colspan="2"><span style="color: green; font-size: 22px;text-align: center;line-height: 40px;">${requestScope.result }</span></td></tr>
  		<tr><td style="width: 120px;"><a href="friend!friends_list" style="color: green;">返回好友列表</a></td><td style="width: 120px;"><a href="friend!friends_search?ureadingschool=${ureadingschool }" style="color: green;">加其他好友</a></td></tr>
  	</table>
  	<hr style="border: 1px dashed green; width: 336px;padding-right:380px;"/>
  </div>
  </body>
</html>
