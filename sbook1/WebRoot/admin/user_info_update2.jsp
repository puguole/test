<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%--引入标签库 --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理用户资料</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="admin/user_info_manager.css" type="text/css" rel="stylesheet" />

  </head>
  
  <body>
	<div class="all">
    	<div class="top">
        	<div class="top_link"><span>您好puguole，欢迎使用同学录管理系统！&nbsp;<a href="#">[网站前台]</a><a href="#">[退出登录]</a><a href="#">[注销登录]</a></span></div>
            <div class="top_menu">
            	<ul>
                	<li><a href="user!usersinfogo" style="background-color:#226411;">用户管理</a></li>
                    li><a href="mood!adminmoodlist">心情管理</a></li>
                    <li><a href="log!adminloglist">日志管理</a></li>
                    <li><a href="photo!adminphotolist">照片管理</a></li>
                    <li><a href="mail!adminmaillist">邮件管理</a></li>
                    <li><a href="javascript:void(0);">悄悄话管理</a></li>
                    <li><a href="javascript:void(0);">系统消息</a></li>
                </ul>
            </div>
        </div>
        <div class="left">
        	<div class="left1">
            	<div style="font-size:13px; padding-top:37px; padding-left:25px;"><a href="#">用户信息管理</a></div>
                <div style="font-size:13px; padding-top:6px; padding-left:25px;"><a href="#">发布系统消息</a></div>
                <div style="font-size:13px; padding-top:7px; padding-left:25px;"><a href="#">删除用户信息</a></div>
            </div>
            <div class="left2">
           	 	<div style="font-size:13px; padding-top:34px; padding-left:25px;"><a href="#">前台网站</a></div>
                <div style="font-size:13px; padding-top:7px; padding-left:25px;"><a href="#">使用说明</a></div>
            </div>
        </div>
        <div class="content">
        	<div class="user_info_title">
                <div class="content_search">
                <div class="user_info_update_content">
                	<form action="user!usersinforupdate2" method="post">
                	<br/>
                	<table>
                    	<tr><td>用户名：</td><td><input type="text" value="${vo.uName }" name="uname"/></td><td>用户密码</td><td><input type="text" value="${vo.uPassword }" name="upassword"/></td><td>用户邮件：</td><td><input type="text" value="${vo.uEmail}" name="uemail"/></td></tr>
                        <tr><td>用户昵称：</td><td><input type="text" value="${vo.uNickname }" name="unickname"/></td><td>年龄：</td><td><input type="text" value="${vo.uAge }" name="uage"/></td><td>性别：</td><td><input type="text" value="${vo.uSex }" name="usex"/></td></tr>
                        <tr><td>就读院校：</td><td><input type="text" value="${vo.uReadingschool }" name="ureadingschool"/></td><td>曾读院校：</td><td><input type="text" value="${vo.uReadschool }" name="ureadschool"/></td><td>生日：</td><td><input type="text" value="${vo.uBirth }" name="ubirth"/></td></tr>
                        <tr><td>QQ号：</td><td><input type="text" value="${vo.uQq }" name="uqq"/></td><td>手机号码：</td><td><input type="text" value="${vo.uTelphone }" name="utelphone"/></td><td></td><td></td></tr>
                        <tr><td><span>座右铭：</span></td><td colspan="3"><textarea style="width:400px; height:40px;" name="umotto">${vo.uMotto }</textarea></td></tr>
                        <tr><td colspan="4"><input style="background-color:#EFF7D0;" type="submit" value="确定"/>&nbsp;<input style="background-color:#EFF7D0;" type="reset" value="重置"/></td></tr>
                    </table>
                    </form>
                </div>
                </div>
          </div>
        </div>
    </div>
</body>
</html>
