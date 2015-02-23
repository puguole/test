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
    
    <title>编辑邮件</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/muban.css">
<link rel="stylesheet" type="text/css" href="css/log1.css">
<link rel="stylesheet" type="text/css" href="css/mail.css">
<script src="js/time.js" type="text/javascript"></script>
<script type="text/javascript">
	function passValue(){//点击下拉框传值
		var val=document.getElementById("f_name").value;
		var input=document.getElementById("getf_name").value=val;
	}
	function checkNull(){//判断是否为空
		var topeople=document.getElementById("getf_name").value;
		if(topeople==''){
			document.getElementById("getf_name").style.backgroundColor='pink';
			alert("接受者未知！");
			return false;
		}
	}
</script>
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
	<!--写邮件界面-->
    <link rel="stylesheet" type="text/css" href="css/log1.css">
    <script src="FCKeditor_2.6.4.1/fckeditor/fckeditor.js"></script>
    <script src="js/mail_write.js" type="text/javascript"></script>
	<div class="log_top">
    	<div class="log_top_picture"><img src="images/photo1.png" height="60" width="60"/></div>
        <div class="log_top_content">
        <p><b>[${sessionScope.UserName }]的邮件-编辑邮件</b></p>
        <hr/>
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
                <li  style="background-color:white; border-left:1px solid green; border-right:1px solid green; border-top:1px solid green;"><a href="mail!mailgowrite" style="color:black;">写　信</a></li>
                <li><a href="mail/mail_system_info.jsp">系统通知</a></li>
            </ul>
        </div>
        <hr color="#8CDA5C"/>
        <!--下面的样式基本和写日志样式差不多，直接用-->
       <div class="log3_write">
        	<div class="log3_write_in">
            <form action="mail!mailto?type=mailwrite" method="post"  enctype="multipart/form-data" onsubmit="return checkNull();">
            	<table>
                	<tr><td style="width:100px;">收 件 人 ：</td><td><input id="getf_name" name="to_peole" type="text" size="30" value="${requestScope.fname }"/> 输入账号！<a href="#" style="color:green;" onmouseover="show('show')">移动此处查看好友账号</a>
                    <div class="showfriends" id="showfriends">
                    <select id="f_name" size="7" name="friends_list" style="width:111px;" onclick="passValue();"><!--下面的option可以循环得到--><!--选中其中的一个则左边将自动填写-->
                    	<c:forEach items="${requestScope.list }" var="vo">
                    		<option value="${vo.fName }" style="border-bottom:1px gray dotted;">${vo.fName }</option>
                        </c:forEach>
                    </select>
                    </div>
                    </td></tr>
                    <tr><td style="width:100px;">邮件标题：</td><td><input name="title" type="text" size="30" onmouseover="show('noshow')" value="${requestScope.etitle }"/> 日志标题不可超过15个字！</td></tr>
                    <tr><td style="float:left;">邮件内容：</td><td>
                    	<!--用到fckeditor-->
                        <script>
							var editor = new FCKeditor('content'); //content是textarea的name，有这个了就不需要textarea了
							editor.Value='${requestScope.inviteinfo}';//设置内容
							editor.BasePath = 'FCKeditor_2.6.4.1/fckeditor/';//路径
							editor.Heigth = 400;
							editor.Width=600;
							editor.ToolbarSet = 'Basic'; //还可以使用'Default'  Basic
							editor.Create();
						</script>
                    </td></tr>
                    <tr><td>附加文件：</td><td><input type="file" name="image"/></td></tr>
                    <tr><td><input type="submit" value="发送"/></td><td><input type="reset" value="重置"/></td></tr>
            	</table>
            </form>	
            </div>
        </div>
        <!--在这里停止-->
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
