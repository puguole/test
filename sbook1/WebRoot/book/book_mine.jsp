<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的同学录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/muban.css">
<link rel="stylesheet" type="text/css" href="css/log1.css">
<link rel="stylesheet" type="text/css" href="css/mail.css">
<script src="js/time.js" type="text/javascript"></script>
  </head>
  
  <body>

<div class="container">
  <div class="header">
    <div><img src="images/logo.png"  width="180" height="90" style="background: #C6D580; display:inline;" /><img src="images/logo2.png" width="780" usemap="#logo2"/>
    <map name="logo2" id="planetmap">
    	<area shape="rect" coords="577,50,610,65" href ="register/register.jsp"/>
        <area shape="rect" coords="627,50,658,65" href ="login.jsp"/>
        <area shape="rect" coords="675,50,704,65" href ="login.jsp"/>
        <area shape="rect" coords="719,50,765,65" href ="#"/>
	</map>
    </div>
    <!--这里将会进行session判断，如何存在session，就不要在移动-->
    <div style="color:black;  background-color:#E5DFD2; font-size:14px; width:960px; margin-bottom:3px; height:30px;"><hr/><marquee behavior="slide" direction="left">&nbsp;&nbsp;&nbsp;[${sessionScope.UserName }] 欢迎登录 <span id="time"><script>nowTime('time',12);</script></span>&nbsp;&nbsp;&nbsp;&nbsp; <img src="images/infor_img.png" height="27" align="absmiddle"/>本站消息：欢迎访问我的同学录网站！在这里我们为你提供最好的沟通服务！</marquee></div>
<div class="header2">
    	<ul>
   			<li><a href="index/index.jsp">首页</a></li>
            <li><a href="log/log_write.jsp">写日志</a></li>
            <li><a href="mood!moodget">发心情</a></li>
            <li><a href="photo!GouploadServlet">传照片</a></li>
            <li><a href="mail!mailgowrite">发邮件</a></li>
    		<li><a href="sbook!bookgowritestyle">写同学录</a></li>
   		 	<li><a href="">好友</a>
  <ul>
                	<li><a href="friend!friends_list">好友列表</a></li>
                    <li><a href="friend!friends_search">查找好友</a></li>
                    <li><a href="friend!friends_recommend">推荐好友</a></li>
                </ul>
      </li>
   		 	<li><a href="">通讯助理</a>
            	<ul>
                	<li><a href="talk/talk_write.jsp">发悄悄话</a></li>
                    <li><a href="mail!mailgowrite">发送邮件</a></li>
                </ul>
      </li>
    		<li><a href="">个人资料</a>
            	<ul>
                	<li><a href="user!PersonalinforgetServlet?name=${UserName}">查看资料</a></li>
                    <li><a href="user!PersonalinforgoEditServlet">编辑资料</a></li>
                </ul>
            </li>
    	</ul>
    </div>
    </div>
  <div class="sidebar1">
    <ul class="nav" >
    <li><div style="text-align:center; background-color:#F7F7F7; margin-bottom:5px; font-weight:bold; height:30px; line-height:30px; border-bottom:none;">我的同学录</div></li>
      <li><a href="sbook!bookgomine"><img src="images_icon/icon_students.png" width="28" height="23" align="absmiddle" />&nbsp;&nbsp;同学录</a></li>
      <li><a href="mood!update_moodGet"><img src="images_icon/icon_trends.png" width="28" height="23" align="absmiddle" />&nbsp;&nbsp;动　态</a></li>
      <li><a href="mood!moodget"><img src="images_icon/icon_mood.png" width="28" height="23" align="absmiddle" />&nbsp;&nbsp;心　情</a></li>
      <li><a href="log!logfriends"><img src="images_icon/icon_log.png" width="28" height="23" align="absmiddle" />&nbsp;&nbsp;日　志</a></li>
      <li><a href="photo!photogomine"><img src="images_icon/icon_photo.png"width="28" height="23" align="absmiddle" />&nbsp;&nbsp;照　片</a></li>
      <li><a href="mail!mailto?type=mailget"><img src="images_icon/icon_mail.png" width="28" height="23" align="absmiddle" />&nbsp;&nbsp;邮　件</a></li>
      <li><a href="talk/talk_mine.jsp"><img src="images_icon/icon_talk.png" width="28" height="23" align="absmiddle" />&nbsp;&nbsp;悄悄话</a></li>
    </ul>
    <div style="margin-bottom:10px;"><img src="images/gg1.png"/></div>
    <div style="margin-bottom:10px;"><img src="images/gg2.png"/></div>
    <div style="margin-bottom:10px;"><img src="images/gg3.png"/></div>
    <div style="margin-bottom:10px;"><img src="images/gg4.png"/></div>
    <p>&nbsp;</p>
    <!-- end .sidebar1 --></div>
  <div class="content">
    <!-- InstanceBeginEditable name="可编辑区域" -->
	<!--我的同学录-->
	<link rel="stylesheet" type="text/css" href="css/log1.css">
    <link rel="stylesheet" type="text/css" href="css/book.css">
    <script src="js/book.js" type="text/javascript"></script>
	<div class="log_top">
    	<div class="log_top_picture"><img src="images/photo1.png" width="60" height="60" style="float:left;"/></div>
        <div class="log_top_content">
        <p><b>[${sessionScope.UserName }]的同学录-我的同学录</b></p>
        <hr/>
        <a href="user!PersonalinforgetServlet?name=${UserName}">
        <p style="color:green">进入${sessionScope.UserName }的个人资料</p></a>
        </div>
    </div>
    <div class="log_botton">
    	<div class="log_menu">
        	<ul>
            	<li style="background-color:white; border-left:1px solid green; border-right:1px solid green; border-top:1px solid green;"><a href="sbook!bookgomine" style="color:black;">我的同学录</a></li>
                <li><a href="sbook!bookgowritestyle">给好友写同学录</a></li>
                <li><a href="sbook!bookgoinvite">邀请好友填写</a></li>
            </ul>
        </div>
        <hr color="#8CDA5C"/>
        <div class="log_botton_freindslog">
        	
            <!--如果有的话，就显示下面的内容-->
            <div class="log_botton_mylog_yes">
            	<div class="book_unread">
                	<span style="display:block; background-color:#F2F4F6; color:green; padding:3px;"><img src="images_icon/icon_mail_unread.png" align="absmiddle" onclick="f1()"/>[已有同学录的好友] <span style="color:black;font-size: 14px;">共${requestScope.county }位</span></span>
                    <div class="book_unread_content" id="book_unread_content">
                    	<table>
                    	<c:forEach items="${requestScope.listy }" var="voy">
                        	<tr><td width="206">&nbsp;<span style="color:#CF9D81;">${voy.uName }</span></td><td width="482" style="font-size: 14px;font-family: '微软雅黑' ">&nbsp;&nbsp;&nbsp;&nbsp;<a href="sbook!bookshow?fname=${voy.uName }">查看同学录</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="sbook!bookdelete?fname=${voy.uName }" onclick="javascript:return window.confirm('你确定要删除吗？')">删除同学录</a></td></tr>
                        </c:forEach>
                        </table>
                    </div>
                </div>
                
                <div class="book_read">
                	<span style="display:block; background-color:#F2F4F6; color:green; padding:3px;"><img src="images_icon/icon_mail_unread.png" align="absmiddle" onclick="f2()"/>[未有同学录的好友] <span style="color:black;font-size: 14px;">共${requestScope.countn }位</span></span>
                    <div class="book_read_content" id="book_read_content">
                    	<table>
                    	<c:forEach items="${requestScope.listn }" var="von">
                        	<tr><td width="206">&nbsp;<span style="color:#CF9D81;">${von.fName }</span></td><td width="482" style="color: green;font-size: 14px;font-family: '微软雅黑'">&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: #000000;">邀请好友填写</span>&nbsp;(<a href="mail!mailgowrite?fname=${von.fName }">邮件形式</a>&nbsp;<a href="javascript:void(0);">悄悄话形式</a>)</td></tr>
                        </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<!-- InstanceEndEditable -->    <!-- end .content --></div>
  <div class="footer">
  <hr style="border:1px solid green;"/>
  <span style="color:gray; margin-right:240px;">Copyright &copy; 2014 吉首大学软件外包学院Java二班3组版权所有</span>
  <a href="http://images.5460.net/aboutus/index.htm"target="_blank"> 关于</a> |
  <a href="http://txl.5460.net/huiju/huodong.jsp" target="_blank">公益&amp;活动</a> |
  <a href="http://images.5460.net/pic/us/hr-2008/" target="_blank">招聘</a> |
  <a href="http://images.5460.net/pic/us/20070716/ad.jsp"target="_blank">广告</a> | 
  <a href="/nofilter/help/privacy.jsp">用户隐私</a> | 
  <a href="http://sns.5460.net/guestbook!showGuest.action">意见反馈</a> | 
  <a href="/nofilter/help/help_lianxi.jsp">市场合作</a>
        <!-- end .footer --></div>
  <!-- end .container --></div>
</body>
</html>
