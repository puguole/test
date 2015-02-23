<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统通知</title>
    
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
	<!--显示系统消息-->
    <link rel="stylesheet" type="text/css" href="css/log1.css">
    
	<div class="log_top">
    	<div class="log_top_picture"><img src="images/photo1.png" height="60" width="60"/></div>
        <div class="log_top_content">
        <p><b>[${sessionScope.UserName }]的邮件-系统邮件</b></p><hr/>
        <a href="user!PersonalinforgetServlet?name=${UserName}">
        <p style="color:green">进入${sessionScope.UserName }的个人资料</p></a>
        </div>
    </div>
    <div class="log_botton">
    	<div class="log_menu">
        	<ul>
            	<li><a href="mail!mailto?type=mailget">收件箱</a></li>
                <li><a href="mail!mailto?type=mailto">发件箱</a></li>
                <li><a href="mail/mail_draft.jsp">草稿箱</a></li>
                <li><a href="mail!mailgowrite">写　信</a></li>
                <li style="background-color:white; border-left:1px solid green; border-right:1px solid green; border-top:1px solid green;"><a href="mail/mail_system_info.jsp" style="color:black;">系统通知</a></li>
            </ul>
        </div>
        <hr color="#8CDA5C"/>
        <div class="log_botton_freindslog">
        	<!--如果好友没有最新日志动态，就显示下面这个-->
            <!---样式一样，就直接用-->
            <div class="log_botton_freindslog_no">
            	<span><b>你没有收到新的系统通知！</b></span><br />
                <span style="color:gray; font-size:14px;">如果您有新留言或新回复,我们会发送一条系统消息来通知您.</span><br />
                <span><a href="mail!mailgowrite"  style="color:#6CC423; font-size:14px; text-decoration:underline;">去看看您的朋友,并问候他们吧!</a></span>
            </div>
            
            <%-- 
            <!--如果有的话，就显示下面的内容-->
            <div class="mail_botton_systeminfor_yes">
                <table>
                    <tr  style="color:gray;"><td width="83" style="font-size:14px;"><input type="checkbox" value="0" name="select_all"/>选择全部</td><td width="156" style="font-size:14px;">通知标题</td><td width="183" style="font-size:14px;">通知内容</td><td width="30" style="font-size:14px;">查看</td><td width="103" style="font-size:14px;">发布者</td><td width="136" style="font-size:14px;">发布时间</td><td width="33" style="font-size:14px;">删除</td></tr>
                    <tr><td colspan="7"><hr style="padding:0px; margin:0px;"/></td></tr>
                    <tr  style="color:gray;"><td ><input type="checkbox" value="0" name="select_one"/>选择</td><td><span class="show_text2">系统终端消息</span></td><td><span class="show_text1">水水水水水水水你好吗哈哈哈</span></td><td><a href="mail_show.jsp"  style="color:green;">查看</a></td>
                    <td style="color:green;">${sessionScope.UserName }</td><td width="136" style="font-size:10px;">2014-03-22 12:20:11</td><td><a href="#"  style="color:green;">删除</a></td><td width="10"></td></tr>
                    <tr><td colspan="7"><hr style=" border:1px dotted #CCCCCC;padding:0px; margin:0px;"/></td></tr> 
                    
                   <!--下面可以循环读取-->
					<tr  style="color:gray;"><td ><input type="checkbox" value="0" name="select_one"/>选择</td><td><span class="show_text2">系统终端消息</span></td><td><span class="show_text1">水水水水水水水你好吗哈哈哈</span></td><td><a href="#"  style="color:green;">查看</a></td>
                    <td style="color:green;">${sessionScope.UserName }</td><td width="136" style="font-size:10px;">2014-03-22 12:20:11</td><td><a href="#"  style="color:green;">删除</a></td><td width="10"></td></tr>
                    <tr><td colspan="7"><hr style=" border:1px dotted #CCCCCC;padding:0px; margin:0px;"/></td></tr>
                    <tr  style="color:gray;"><td ><input type="checkbox" value="0" name="select_one"/>选择</td><td><span class="show_text2">系统终端消息</span></td><td><span class="show_text1">水水水水水水水你好吗哈哈哈</span></td><td><a href="#"  style="color:green;">查看</a></td>
                    <td style="color:green;">${sessionScope.UserName }</td><td width="136" style="font-size:10px;">2014-03-22 12:20:11</td><td><a href="#"  style="color:green;">删除</a></td><td width="10"></td></tr>
                    <tr><td colspan="7"><hr style=" border:1px dotted #CCCCCC;padding:0px; margin:0px;"/></td></tr>
                    <tr  style="color:gray;"><td ><input type="checkbox" value="0" name="select_one"/>选择</td><td><span class="show_text2">系统终端消息</span></td><td><span class="show_text1">水水水水水水水你好吗哈哈哈</span></td><td><a href="#"  style="color:green;">查看</a></td>
                    <td style="color:green;">${sessionScope.UserName }</td><td width="136" style="font-size:10px;">2014-03-22 12:20:11</td><td><a href="#"  style="color:green;">删除</a></td><td width="10"></td></tr>
                    <tr><td colspan="7"><hr style=" border:1px dotted #CCCCCC;padding:0px; margin:0px;"/></td></tr>
                </table>
            </div>
            --%>
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
