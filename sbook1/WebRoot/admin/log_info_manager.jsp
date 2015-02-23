<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%--引入标签库 --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理</title>
    
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
        	<div class="top_link"><span>您好[${admin }]，欢迎使用同学录管理系统！&nbsp;<a href="login.jsp">[网站前台]</a><a href="login.jsp">[退出登录]</a><a href="login.jsp">[注销登录]</a></span></div>
            <div class="top_menu">
            	<ul>
                	<li><a href="user!usersinfogo">用户管理</a></li>
                    <li><a href="mood!adminmoodlist">心情管理</a></li>
                    <li><a href="log!adminloglist" style="background-color:#226411;">日志管理</a></li>
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
        <div class="left_splite"></div>
        <div class="content" style="overflow-y:auto; overflow-x:auto; height:480px;"><%--style="overflow:scroll;" --%>
        	<div class="user_info_title">
            	<span>&nbsp;&nbsp;&nbsp;用户日志列表</span>
                <table border="1" cellspacing="0" bordercolor="#D1DDAA" width = "80%" style="border-collapse:collapse;"  >
                	<tr bgcolor="#ffffff"><td>选择</td><td>用户名</td><td>日志id</td><td>日志标题</td><td>日志权限</td><td>日志类型</td><td>发表时间</td><td>修改</td><td>删除</td></tr>
                    <c:forEach items="${requestScope.list }" var="vo">
                    <tr style="font-size: 13px;"><td><input type="checkbox"/></td><td>${vo.uName }</td><td>${vo.lId }</td><td>${vo.lTitle}</td><td>${vo.lPower }</td><td>${vo.lStyle }</td><td>${vo.lTotime }</td><td><a href="usersinfoupdate?uname=${vo.uName }">修改</a></td><td><a href="usersinfodelete?uname=${vo.uName}" onclick="return window.confirm('您确定要删除吗？')">删除</a></td></tr>
                    </c:forEach>
                    <tr><td colspan="12">&nbsp;<input style="background-color:#EFF7D0;" type="button" value="全选"/>&nbsp;<input style="background-color:#EFF7D0;" type="button" value="取消"/>&nbsp;<input style="background-color:#EFF7D0;" type="button" value="删除"/><span style="float:right; margin-right:50px;"></td></tr>
                </table>
                </div>
                </div><div style="padding-top: 11px;">
                <div class="content_bottom" style=""><div class="content_search">
                <span style="margin-left:2px;line-height: 25px;height: 25px; font-size: 14px;">搜索条件：</span>
                <form method="post" action="user!usersinfosearch">
                <select>
                	<option>选择类型</option>
                    <option>名称</option>
                </select>
               		 &nbsp;关键字：<input type="text" name="search" value="${requestScope.search }"/>
               		 &nbsp;发布时间：
                <select>
                	<option>排序</option>
                    <option>发布时间</option>
                </select>
                &nbsp;<input type="submit" value="搜索"/>
                </form>
                </div>
          </div>
          
        </div>
    </div>
  </body>
</html>
