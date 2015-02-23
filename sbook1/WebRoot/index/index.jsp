<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    
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
	<!--首页-->
	<link rel="stylesheet" type="text/css" href="css/log1.css">
    <link rel="stylesheet" type="text/css" href="css/book.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script src="js/book.js" type="text/javascript"></script>
	<div class="log_top">
    	<div class="log_top_picture"><img src="images/photo1.png" width="60" height="60" style="float:left;"/></div>
        <div class="log_top_content">
        <p><b>[${UserName}]的同学录-我的首页</b></p><hr/>
        <a href="user!PersonalinforgetServlet?name=${UserName}">
        <p style="color:green">进入${UserName}的个人资料</p></a>
        </div>
    </div>
    <div class="log_botton">
        <hr color="#8CDA5C"/>
        <div class="log_botton_freindslog">
            <!--如果有的话，就显示下面的内容-->
            <div class="log_botton_mylog_yes">
            	<div class="index_content">
                	<span style="font-weight:bold">亲爱的${sessionScope.UserName }同学：</span><br/>
                    <span>欢迎加入同学录之我的青春网站，在这里，您可以<a href="friend!friends_search" style="color:green;">查找</a>到已经注册了的自己的同班同学。</span><br/>
                    <span>可以给自己的同学<a href="mail!mailgowrite" style="color:green;">发邮件</a>，或者用<a href="talk/talk_write.jsp" style="color:green;">悄悄话</a>来发送一些私密的信息。</span><br/>
                    <span>还可以用<a href="log/log_write.jsp" style="color:green;">日志</a>形式，记录下自己生活的感悟。当您心情或愉快或悲伤，或怒，或痛，发表您的<a href="mood!moodget" style="color:green;">心情</a>，痛痛快快的诉说吧！</span><br/>
                    <span>当然，您还可以<a href="photo!GouploadServlet" style="color:green;">上传自己的照片</a>，向大家秀上一番。相框的动态效果，让您爱不释手！</span><br/>
                    <span>当好友有<a href="mood!update_moodGet" style="color:green;">最新动态</a>时，您可以及时关注，一起和他（她）分享愉快吧！</span><br/>
                     <span>您的资料我们也会妥善保管，您也可以进行查看<a href="user!PersonalinforgetServlet?name=${UserName}" style="color:green;">个人资料</a>或者<a href="user!PersonalinforgoEditServlet" style="color:green;">编辑自己的资料</a>！</span><br/>
                    <span>对了，关键的一步还是同学录。您是否想更加的了解你的同学呢？通过<a href="sbook!bookgowritestyle" style="color:green;">填写同学录</a>，您就会更加的清楚！</span><br/>
                    <span style="color:gray;">邀请好友填写同学录之前，需要有好友哦！<a href="friend!friends_search" style="color:green;">马上查找好友</a></span>
                </div>
            </div>
        </div>
    </div>
	<!-- InstanceEndEditable -->    <!-- end .content --></div>
  <div class="footer">
  <hr style="border:1px solid green;"/>
  <span style="color:gray; margin-right:240px;">Copyright &copy; 2014 吉首大学软件外包学院Java二班3组版权所有</span>
  <a href="photo!photogoallscreen"target="_blank"> 关于</a> |
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
