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
    
    <title>显示日志</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/muban.css">
	<link rel="stylesheet" type="text/css" href="css/log1.css">
	<link rel="stylesheet" type="text/css" href="css/mail.css">
	<script type="text/javascript">
		function checknull(){//不允许评论内容为空
			var content=document.getElementById("dcontent").value;
			if(content==""){
				return false;
			}
		}
	</script>
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
	<!--显示日志-->
    <link rel="stylesheet" type="text/css" href="css/log1.css">
    
	<div class="log_top">
    	<div class="log_top_picture"><img src="images/photo1.png" height="60" width="60"/></div>
        <div class="log_top_content">
        <p><b>[${vo.uName }]的日志-${vo.lTitle }</b> 发表时间：${vo.lTotime }</p><hr/>
        <a href="user!PersonalinforgetServlet?name=${UserName}"><p style="color:green; display:inline; padding:2px;">返回${sessionScope.UserName }的个人资料</p>|</a><a href="log!loglist"><p style="color:green;display:inline;padding:2px;">返回${sessionScope.UserName }的日志列表</p>|</a><a href="log!logupdate?type=edit&uname=${vo.uName }&title=${vo.lTitle }"><p style="color:green; display:inline;padding:2px;">编辑</p>|</a><a href="log!logupdate?type=delete&uname=${vo.uName }&title=${vo.lTitle }" onclick="javascript:return window.confirm('确定要删除吗？')"><p style="color:green; display:inline;padding:2px;">删除</p></a>
        </div>
    </div>
    <div class="log_botton">
    	<div class="log_menu">
        	<ul>
            	<li><a href="log!logfriends">好友的最新日志</a></li>
                <li><a href="log!loglist">我的日志</a></li>
                <li><a href="log/log_write.jsp">发表日志</a></li>
            </ul>
        </div>
        <hr color="#8CDA5C"/>
        <span style="display:block; background-color:#ECECEC; margin-bottom:4px; font-weight:bold;">日志内容：</span>
       <div class="log_write_logcontent">
        ${vo.lContent }
       </div>
       <p>&nbsp;</p>
       <span style="background-color:#ECECEC; display:block; font-weight:bold;">文章评论：</span>
       <div class="log_write_logcontent" style="font-size:13px;"><!--评论的样式就直接用日志内容样式-->
       <!--如果没有评论，就直接这样写，否则，就直接打开下面的全部注释即可-->
       <!--<span>目前还没有人对该日志进行评论！</span>-->
       <c:forEach items="${requestScope.discusslist }" var="dlist">
       <textarea cols="92" rows="1" style="border:0px solid;" readonly="readonly">${dlist.dContent }</textarea>
       	<table width="600px">
        	<tr><td><span style="color:green;">评论人：${dlist.lDiscussname }</span></td><td><span style="color:green;">评论时间：${dlist.dDiscusstime }</span></td><td><a href="log!logupdate?type=discussdelet&lname=${dlist.uName}&dname=${dlist.lDiscussname }&dtime=${dlist.dDiscusstime }&dtitle=${vo.lTitle }"><span style="color:green;">删除评论</span></a></td></tr>
        </table><hr style="border:1px dotted #CCCCCC;"/>
       </c:forEach>
        <!--下面的table可以循环读取-->  
       </div>
       <div class="log_write_writecomment">
       	<div class="log_write_writecomment_in">
        	<span>我要评论：<br/></span><br/>
            <form action="log!logdiscuss" method="post">
            	<input type="hidden" name="name" value="${vo.uName }"/>
            	<input type="hidden" name="title" value="${vo.lTitle }"/>
            	<textarea cols="79" rows="4" name="discusscontent" id="dcontent"></textarea>
                <input type="submit" value="发表" onclick="return checknull();"/><input type="reset" value="重置"/>
            </form>
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
