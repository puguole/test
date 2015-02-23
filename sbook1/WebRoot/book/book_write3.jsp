<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>填写同学录信息</title>
    
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
//检测是否有没有填的地方
var checkNull2=function(){
	for(var i=0;i<document.getElementById("formall").length;i++){
		var form=document.getElementById("formall")[i];
		if(form.value==""||form.value==null){
			form.style.backgroundColor="#FAF1D4";
			alert("你的好友想要你填完全部哦！");
			form.focus();
			return false;
		}
		if(form.value!=""&&form.value!=null){
			form.style.backgroundColor="white";
		}
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
	<!--填写同学录-->
	<link rel="stylesheet" type="text/css" href="css/log1.css">
    <link rel="stylesheet" type="text/css" href="css/book.css">
    <script src="js/book.js" type="text/javascript"></script>
    <script language="javascript" type="text/javascript" src="book/My97DatePicker/WdatePicker.js"></script>
	<div class="log_top">
    	<div class="log_top_picture"><img src="images/photo1.png" width="60" height="60" style="float:left;"/></div>
        <div class="log_top_content">
        <p><b>[${sessionScope.UserName }]的同学录-给${requestScope.fname }的同学录</b></p><hr/>
        <a href="user!PersonalinforgetServlet?name=${UserName}">
        <p style="color:green">进入${sessionScope.UserName }的个人资料</p></a>
        </div>
    </div>
    <div class="log_botton">
    	<div class="log_menu">
        	<ul>
            	<li><a href="sbook!bookgomine">我的同学录</a></li>
                <li><a href="sbook!bookgowritestyle">给好友写同学录</a></li>
                <li><a href="sbook!bookgoinvite">邀请好友填写</a></li>
            </ul>
        </div>
        <hr color="#8CDA5C"/>
        <div class="log_botton_freindslog">
            <!--如果有的话，就显示下面的内容-->
            <div class="log_botton_mylog_yes">
				<div class="book_write_content">
				<form action="sbook!bookwrite" method="post" onsubmit="return checkNull2();" id="formall">
                	<table align="center"  style="color: black;">
                		<input type="hidden" name="fname" value="${requestScope.fname }"/>
				    	<tr><td width="120" height="64">你的大名：</td><td width="217"><input type="text" name="uBigname"/></td><td width="134">你的昵称：</td><td width="209"><input type="text" name="bNickname"/></td></tr>
				        <tr><td height="51">破蛋日期：</td><td><input class="Wdate" type="text" onClick="WdatePicker()" id="len" name="bBirth"></td><td>QQ　号：</td><td><input type="text" name="bQq"/></td></tr>
				        <tr><td height="57">电话号码：</td><td><input type="text" name="bTelphone1"/></td><td>手机号码：</td><td><input type="text" name="bTelphone2"/></td></tr>
				        <tr><td height="56">家庭住址：</td><td><input type="text" name="bAddress"/></td><td>爱　好：</td><td><input type="text" name="bHobby"/></td></tr>
				        <tr><td height="55">星座：</td><td><input type="text" name="bConstellation"/></td><td>最喜欢的人：</td><td><input type="text" name="bLovepeople"/></td></tr>
				        <tr><td height="58">最喜欢的食物：</td><td><input type="text" name="bLovefood"/></td><td>最喜欢的一句话：</td><td><input type="text" name="bLovesay"/></td></tr>
				        <tr><td height="59">最喜欢的水果：</td><td><input type="text" name="bLovefruit"/></td><td>最喜欢的国家：</td><td><input type="text" name="bLovecountry"/></td></tr>
				        <tr><td height="51">最喜欢的老师：</td><td><input type="text" name="bLoveteacher"/></td><td>座右铭：</td><td><input type="text" name="bMotto"/></td></tr>
				        <tr><td style="float:left;">给我留言：</td><td colspan="3"><textarea style="width:440px; height:80px;color: gray;" name="bLeaveword"></textarea></td></tr>
				        <tr><td></td><td><input type="submit" value="提交" style="border:1px solid gray;"/></td><td><input type="reset" value="重置" style="border:1px solid gray;"/></td></tr>
    				</table>
    			</form>
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
