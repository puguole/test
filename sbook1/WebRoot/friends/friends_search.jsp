<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/etc" prefix="etc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>好友查找</title>
    
<link rel="stylesheet" type="text/css" href="css/muban.css">
<link rel="stylesheet" type="text/css" href="css/log1.css">
<link rel="stylesheet" type="text/css" href="css/mail.css">
<link href="friends/friends_list1.css" rel="stylesheet" type="text/css" />
<script src="js/time.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-easyui-1.3.6_simple/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery-easyui-1.3.6_simple/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="js/jquery-easyui-1.3.6_simple/locale/easyui-lang-zh_CN.js"></script>
  <link rel="stylesheet" href="js/jquery-easyui-1.3.6_simple/themes/default/easyui.css" type="text/css"></link>
  <link rel="stylesheet" href="js/jquery-easyui-1.3.6_simple/themes/icon.css" type="text/css"></link>
  <script type="text/javascript">
  	var search;
  	$(function(){
  		//关键字
  		search=$('#search').combobox({ 
		    url:'friend!getAllUser.action',    
		    valueField:'uName',    
		    textField:'uName',
		    mode:'remote',
		    delay:500,
		    panelHeight:100,
		    onBeforeLoad:function(p){
		    	$.messager.progress({
		    		title:'提示',
		    		text:'数据加载中...'
		    	})
		    },
		    onLoadSuccess:function(){
		    	$.messager.progress('close');
		    }
		});
  	})
  	//点击添加好友
  	var goAdd=function(fname,ureadingschool){
  		location.href="friend!friends_add?fname="+fname+"&ureadingschool="+ureadingschool+"";
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

	<div id="peoplesearch" style="height: 600px;">
    <div id="searchhead" style="width:770px; height:40px;">
     <form id="form1" name="form1" method="post" action="friend!friends_search">
      <div id="searchlogo">
      
      </div>
      <table width="100%" border="0">
  <tr>
   <td style="font-family:微软雅黑; font-size:15px; color:#3E9900;">关键字：</td>
    <td width="82%"><table width="100%%" border="0"><td width="81%"><label for="search"></label><%--<img src="images/searchbutton1.png" width="108" height="36" border="1px" style="border-color:#4BAB00; float:none;" /> --%>
      <input placeholder="请输入用户名" autofocus name="fname" value="${fname }" type="text" id="search"  style="height:25px; font-size:21px; font-weight:100; font-style:normal; width:490px; color:#CCC;" /></td><td width="19%"><input type="submit" value="查找" style=" background-color:#1CB90B; color:#FFF; font-family:微软雅黑;"/></td></table></td>
    <td width="6%">
    
    </td>
  </tr>
  <tr>
    <td width="11%" height="27" style="font-family:微软雅黑; font-size:15px; color:#3E9900;">就读学校：</td>
    <td>
    <table width="100%%" border="0">
    <tr>
    <td width="23%" height="61"><label for="friendaddress"></label>
    
      <input name="ureadingschool" id="ureadingschool" value="${ureadingschool }" style="width: 130px;"/>
     </td>
     <td width="36%" style="font-family:微软雅黑; font-size:15px; color:#3E9900;">&nbsp;曾读学校：
       <label for="friendGrade"></label>
       <input type="text" name="ureadschool" id="ureadschool" value="${ureadschool }" style="width: 130px;"/>
       </td>
       <td width="41%" style="font-family:微软雅黑; font-size:15px; color:#3E9900;">&nbsp;性别：
         <label for="friendSex"></label>
         <select name="usex" id="friendSex">
           <option value="不限" selected="selected">不限</option>
           <option value="男">男</option>
           <option value="女">女</option>
         </select></td>
    </tr>
    </table>
    </form>
    </td>
    <td>&nbsp;</td>
     <tr>
     <td>&nbsp;</td>
     <td>
     <div style="height:480px;width: 600px;">
     <table style=" border-collapse:collapse;">
     <c:forEach items="${requestScope.list }" var="vo">
     <tr style="background-color:#D8FDAE;">
     <c:choose>
		<c:when test="${vo.uHead !=null}">
			<td width="69" height="46" ><img src="${vo.uHead }" width="47" height="44" /></td>
		</c:when>
		<c:otherwise>
			<td width="69" height="46" ><img src="images/photo1.png" width="47" height="44" /></td>
		</c:otherwise>
	</c:choose>
     <td width="69" style="font-family:微软雅黑; color:#388307;"><strong>${vo.uName }</strong></td>
     <td width="146" style="font-family:微软雅黑; color:#666; font-size:14px;">就读于：${vo.uReadingschool }</td>
     <td><span style="font-family:微软雅黑; color:#666; font-size:14px;">曾读于：${vo.uReadschool }</span></td>
     <td width="162">&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);" onclick="goAdd('${vo.uName}','${ureadingschool }')"><img src="images/addfriends.png" width="70" height="24" /></a></td>
     </tr>
     </c:forEach>
     
     <%-- <div class="log_botton_mylog_yes">
     	<p style="color:gray;">共${requestScope.page.total }篇日志</p>
     <etc:list list="${requestScope.page.rows }">
         <table>
         	<tr><td width="73" rowspan="3"><img src="images/photo1.png"  height="60" width="60"/></td><td width="615" style="background-color:#FCF9E6;"><span style="color:green;">${vo.lTitle } &nbsp;${vo.uName }</span> <span style="color:#666666;"> &nbsp;发表于${vo.lTotime }</span></td></tr>
             <tr><td><span style="color:#666666;" class="show_text1">${vo.lContent }</span><a href="log!logshow?title=${vo.lTitle }&uname=${vo.uName }"><span style="color:green;font-size: 12px;">[阅读全文]</span></a></td></tr>
             <tr><td><span style="color:#666666; border-bottom:none;">0次浏览 | 0次评价 |</span> <a href="log!logshow?title=${vo.lTitle }&uname=${vo.uName }"><span style="color:#666666;">发表评论</span></a> | <a href="log!logupdate?type=edit&uname=${vo.uName }&title=${vo.lTitle }"><span style="color:#666666;">编辑</span></a> | <a href="log!logupdate?type=delete&uname=${vo.uName }&title=${vo.lTitle }" onclick="javascript:return window.confirm('确定要删除吗？')"><span style="color:#666666;">删除</span></a> </td></tr>
         </table>
     </etc:list> --%>
    <!--  </div> -->
     </table>
     <%--下面的是显示上下一页 --%>
     <form method="post" action="friend!friends_search"><div style="font-size:13px; float: right;height:50px; padding-right: 60px;padding-top: 8px;"><a href="friend!friends_search?page=${page -1}"><img src="images_icon/04.gif"/></a>&nbsp;&nbsp;<a href="friend!friends_search?page=${page +1}"><img src="images_icon/03.gif"/></a>&nbsp;&nbsp;<div style="height: 50px;line-height: 28px;float: right;">跳到第 <input type="text" style="width: 30px;" name="page"/>页 <input type="submit" style="font-size: 13px;" value="确定"></div></div></form>
     </div>
     </td>
     <td>&nbsp;</td>
     </tr>
     </table>
     </tr>
</table>
     
     

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
