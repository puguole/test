<%@page import="com.icss.Const"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>显示资料</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
	<!--显示个人信息-->
	<link rel="stylesheet" type="text/css" href="css/log1.css">
    <link rel="stylesheet" type="text/css" href="css/book.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script src="js/book.js" type="text/javascript"></script>
    <script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
    <style>
    .index_content input{
		border:0px;
		border-bottom:1px solid gray;
	
		
		
	}
    </style>
	<div class="log_top">
    	<div class="log_top_picture"><img src="images/photo1.png" width="60" height="60" style="float:left;"/></div>
        <div class="log_top_content">
        <p><b>[${vo.uName }]的同学录-个人资料显示</b></p><%HttpSession s=request.getSession();String name=(String)s.getAttribute(Const.LOGINUNAME);%>
        <hr/>
        <a href="index/index.jsp">
        <p style="color:green">进入${vo.uName }的首页</p></a>
        </div>
    </div>
    <div class="log_botton">
        <hr color="#8CDA5C"/>
        
        <div class="log_botton_freindslog">
            <!--如果有的话，就显示下面的内容-->
            <div class="log_botton_mylog_yes">
            	<div class="index_content" style="padding:0px; color:#000; font-family:'Courier New', Courier, monospace; font-size:17px; ">
                <form action="user!PersonalinforgoEditServlet" method="post">
                <div style="height:450px; "> 
                <div style="height:450px; width:300px; border:1px solid #FFF; float:left;">
                <table  style="width:300px; height:450px " >
  					<tr><td height="200px"><div style=" height:200px; width:160px ; border:1px solid #CCC; margin:auto" ><img  src="${vo.uHead }"  width="160px" height="200px"/><br/><br/><br/><br/><span style="font-size:18px;color:#060; font-family:'华文楷体';" ></span></div></td></tr>
  					<tr>
  					  <td></td></tr>
  					<tr>
  					  <td height="50px">&nbsp;就读院校：<input name="" type="text" readonly="readonly"  value="${vo.uReadingschool }"/></td></tr>
                    <tr>
                      <td height="50px">&nbsp;曾读院校：<input name="" type="text" readonly="readonly"  value="${vo.uReadschool }"/></td></tr>
                    <tr>
                      <td height="50px">&nbsp;</td></tr>
                    <tr>
                      <td height="50px">&nbsp;</td></tr>
     
				</table>
</div>

                <div style="height:500px; width:450px; float:right;border:1px solid #FFF">
                <table style="height:450px;width:450px">
                <tr><td style="height:40px; width:100px" >用户名：</td><td style="height:40px;" ><input name="uname" value="${vo.uName }" type="text" readonly="readonly" /></td></tr>
                <tr><td style="height:40px; width:100px" >真实姓名：</td><td style="height:40px;"><input name="" type="text" readonly="readonly" value="${vo.uNickname }"/></td></tr>
                <c:if test="${vo.uAge ==0}">
                <tr><td style="height:40px; width:100px" >年龄：</td><td style="height:40px;"><input name="" type="text" value="" readonly="readonly"/></td></tr>
                </c:if>
                <c:if test="${vo.uAge !=0}">
                <tr><td style="height:40px; width:100px" >年龄：</td><td style="height:40px;"><input name="" type="text" value="${vo.uAge }" readonly="readonly"/></td></tr>
                </c:if>
                <tr><td style="height:40px; width:100px" >性别：</td><td style="height:40px;">
                <c:if test="${vo.uSex eq'男'}"><input name="sex" type="radio" value=""  checked="checked" disabled="disabled" />男<input name="sex" type="radio" value="" disabled="disabled"/>女</c:if>
                <c:if test="${vo.uSex eq'女'}"><input name="sex" type="radio" value=""  disabled="disabled" />男<input name="sex" type="radio" checked="checked" value="" disabled="disabled"/>女</c:if>
                <c:if test="${vo.uSex ==null or vo.uSex ==''}"><input name="sex" type="radio" value=""  disabled="disabled" />男<input name="sex" type="radio"  value="" disabled="disabled"/>女</c:if>
               </td> </tr>
                 <tr><td style="height:40px; width:100px" >出生日期：</td><td style="height:40px;" ><input type="text" id="len"  readonly="readonly" value="${vo.uBirth}"></td></tr>
                 <tr><td style="height:40px; width:100px ">QQ号：</td><td style="height:40px;" ><input name="" type="text" readonly="readonly" value="${vo.uQq}" /></td></tr>
                 <tr><td style="height:40px; width:100px" >手机号码：</td><td style="height:40px;" ><input name="" type="text" readonly="readonly" value="${vo.uTelphone}" /></td></tr>
                 <tr><td style="height:40px; width:100px" >邮箱：</td><td style="height:40px;" ><input name="" type="text" readonly="readonly" value="${vo.uEmail }"/></td></tr>
                 <tr><td style="height:100px; width:100px" >座右铭：</td><td style="height:100px;" ><textarea name="" cols="" rows="" readonly="readonly" style="width:320px; height:60px" >${vo.uMotto}</textarea></td></tr>
                  <tr><td style="height:20px; width:100px" ></td><td style="height:20px; text-align:center" >　　　　　　　　<c:if test="${vo.uName==UserName}"><input type="submit" value="　修改信息　"/></c:if></td></tr>
                </table>
                </div>
                </div>
                </form>
                <div></div>
                <div></div> 
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
