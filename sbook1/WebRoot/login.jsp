<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<link rel="stylesheet" type="text/css" href="css/commons.css">
	
	<script type="text/javascript">
		function checklogindata(){
			var a=document.getElementById("p1").value;
			var b=document.getElementById("p2").value;
			if(a==""||b==""){
				document.getElementById("id_fail").innerHTML="不能为空！";
				return false;
			}else{
				return true;
			}
		}
		function changep1_Text(){
			var a=document.getElementById("p1").value;
			if(a=="输入用户名"){
				document.getElementById("p1").value="";
			}else if(a==""){
				document.getElementById("p1").value="输入用户名";
			}
		}
		function changep2_Text(){
			var a=document.getElementById("p2").value;
			if(a=="输入密码"){
				document.getElementById("p2").value="";
				document.getElementById("p2").type="password";
			}else if(a==""){
				document.getElementById("p2").type="text";
				document.getElementById("p2").value="输入密码";
			}
		}
	</script>
  </head>
  
  <body>
    <c:if test="${sessionScope.loginself!=null}"><c:redirect url="index/index.jsp"></c:redirect></c:if>
    <!-- 总的容器 -->
    <div class="all">
    <!-- 上部 -->
    	<div class="top">
      <span><img src="images/login_logo.jpg" height="44" align="absmiddle"/></span><div class="font_style1">同学录之我的青春</div>
    		<div class="tomail">
    			<ul>
    			<li><a href="javascript:void(0)">用户名登录&nbsp;</a></li>
    			<li><a href="javascript:void(0)">邮箱登录 </a></li>
    			<li><a href="javascript:void(0)">手机登录 </a></li>
    			</ul>
    		</div>
    	</div>
    	<!-- 中部 -->
    	<div class="middle">
    		<div class="middle_form">
    		<form action="user!logincheck.action" method="post" onsubmit="return checklogindata();">
    			<table cellpadding="6";>
    				<tr><td><span style="margin-top: 4px; font-size: 22px; font-weight: bold;">用户名登录</span> <span id="id_fail" style="color: red; font-size: 12px;">${requestScope.login_fail_info }</span></td></tr>
    				<tr><td><input id="p1" type="text" name="uname" <c:choose><c:when test="${requestScope.logi_failnname!=null}">value="${requestScope.logi_failnname}"</c:when><c:when test="${cookie.runame!=null}">value="${cookie.runame.value}"</c:when><c:otherwise></c:otherwise></c:choose> placeholder="请输入用户名" style="color: gray;"/></td></tr>
    				<tr><td><input id="p2" type="password" name="upassword" <c:choose><c:when test="${cookie.rupwd !=null}">value="${cookie.rupwd.value }"</c:when><c:otherwise></c:otherwise></c:choose> placeholder="请输入密码" style="color: gray;"/></td></tr>
    				<tr><td><input type="checkbox" name="loginself" style="width:10px;height:11px;"/><font class="font_style2">下次自动登录</font><input <c:choose><c:when test="${cookie.runame!=null}">checked="checked"</c:when><c:otherwise></c:otherwise></c:choose> type="checkbox" name="repwd" style="width:10px;height:11px;"/><font class="font_style2">记住密码</font> <font class="font_style2"><a href="#" style="color: #7697C4;">忘记密码？</a></font></td></tr>
    				<tr><td><input type="text" name="safe" readonly value="建议在网吧或公共电脑上取消保持登录选项。" style="color: gray;background-color:#FEFEC1 ;"/></td></tr>
    				<tr><td><input type="submit" value="登录" style="width:88px;height:30px;float:left;margin-left: 10px;background-color: #045FA8;color: white;"/><font class="font_style2" style="color: #7697C4;"> &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<input type="checkbox" value="admin" name="admin"  style="width:10px;height:11px; "/>我是管理员</font></td></tr>
    				<tr><td><font class="font_style4">登录太慢？</font><a href="#" style="color: #7697C4;font-size: 13px;">立即更换更快的服务器</a><hr style="color: #7697C4;width:260px; margin:0px; padding:0px;"/></td></tr>
    				<tr><td height="38"><font class="font_style4">还没有同学录用户名？</font><a href="register/register.jsp" style="color: red;font-weight: bold;font-size: 14px;">立即注册</a></td></tr>
    			</table>
    		</form>
    		</div>
    	</div>
    	<!-- 下部 -->
    	<div class="botton">
    		<span class="botton_font">Copyright &copy; 2014 吉首大学软件外包学院Java二班3组版权所有</span>
    		<div class="toservice">
    			<ul>
    			<li><a href="javascript:void(0)">同学录首页</a></li>
    			<li><a href="javascript:void(0)">官方同学录</a></li>
    			<li><a href="javascript:void(0)">意见反馈</a></li>
    			<li><a href="javascript:void(0)">不良信息举报</a></li>
    			<li><a href="javascript:void(0)">帮助</a></li>
    			</ul>
    		</div>
    	</div>
    </div>
  </body>
</html>
