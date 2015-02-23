<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>大图浏览</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/photo.css">
<script src="js/time.js" type="text/javascript"></script>
  </head>
  
  <body bgcolor="#000000">
<div class="photo_allscreen_all">
    <div class="photo_allscreen_content">
        <img src="${requestScope.src }" width="520px" height="500px"/>
    </div>
    <div class="photo_allscreen_page">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="window.history.back()" style="color:#8E7E2E;"><b>返回</b></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="photo!photogoallscreen?uname=${requestScope.uname }&pname=${requestScope.pname}" style="color:#8E7E2E;"><b>播放整个相框照片</b></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="photo!photogomine"  style="color:#8E7E2E;"><b>我的相册</b></a>
    </div>
</div>
</body>
</html>
