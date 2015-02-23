<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>上传照片</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="js/time.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/muban.css">
<link rel="stylesheet" type="text/css" href="css/log1.css">
<link rel="stylesheet" type="text/css" href="css/mail.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		var show_photo2=function() {
			console.info('a')
		}
	})
</script>
<script type="text/javascript">
	var checkNUll = function() {
		var p_path = document.getElementById("p_path").value;
		var p_name = document.getElementById("photo_border_newname").value;
		if (p_path == "" || p_path == null) {
			alert("要选择照片哦！");

			return false;
		}
		if (p_name == "" || p_name == null) {
			alert("要选择相框哦！");
			document.getElementById("photo_border_newname").focus();
			return false;
		}
	}
	function get() {
		var value = document.getElementById("select").value;
		if (value != "--选择相框--") {
			var text = document.getElementById("photo_border_newname");
			text.value = value;
		}
	}
	
</script>
</head>

<body>

	<div class="container">
		<div class="header">
			<div>
				<img src="images/logo.png" width="180" height="90"
					style="background: #C6D580; display:inline;" /><img
					src="images/logo2.png" width="780" usemap="#logo2" />
				<map name="logo2" id="planetmap">
					<area shape="rect" coords="577,50,610,65"
						href="register/register.jsp" />
					<area shape="rect" coords="627,50,658,65" href="login.jsp" />
					<area shape="rect" coords="675,50,704,65" href="login.jsp" />
					<area shape="rect" coords="719,50,765,65" href="#" />
				</map>
			</div>
			<!--这里将会进行session判断，如何存在session，就不要在移动-->
			<div
				style="color:black;  background-color:#E5DFD2; font-size:14px; width:960px; margin-bottom:3px; height:30px;">
				<hr />
				<marquee behavior="slide" direction="left">
					&nbsp;&nbsp;&nbsp;[${sessionScope.UserName }] 欢迎登录 <span id="time"><script>
						nowTime('time', 12);
					</script>
					</span>&nbsp;&nbsp;&nbsp;&nbsp; <img src="images/infor_img.png"
						height="27" align="absmiddle" />本站消息：欢迎访问我的同学录网站！在这里我们为你提供最好的沟通服务！
				</marquee>
			</div>
			<div class="header2">
				<ul>
					<li><a href="index/index.jsp">首页</a>
					</li>
					<li><a href="log/log_write.jsp">写日志</a>
					</li>
					<li><a href="mood!moodget">发心情</a>
					</li>
					<li><a href="photo!GouploadServlet">传照片</a>
					</li>
					<li><a href="mail!mailgowrite">发邮件</a>
					</li>
					<li><a href="sbook!bookgowritestyle">写同学录</a>
					</li>
					<li><a href="">好友</a>
						<ul>
							<li><a href="friend!friends_list">好友列表</a>
							</li>
							<li><a href="friend!friends_search">查找好友</a>
							</li>
							<li><a href="friend!friends_recommend">推荐好友</a>
							</li>
						</ul></li>
					<li><a href="">通讯助理</a>
						<ul>
							<li><a href="talk/talk_write.jsp">发悄悄话</a>
							</li>
							<li><a href="mail!mailgowrite">发送邮件</a>
							</li>
						</ul></li>
					<li><a href="">个人资料</a>
						<ul>
							<li><a href="user!PersonalinforgetServlet?name=${UserName}">查看资料</a>
							</li>
							<li><a href="user!PersonalinforgoEditServlet">编辑资料</a>
							</li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="sidebar1">
			<ul class="nav">
				<li><div
						style="text-align:center; background-color:#F7F7F7; margin-bottom:5px; font-weight:bold; height:30px; line-height:30px; border-bottom:none;">我的同学录</div>
				</li>
				<li><a href="sbook!bookgomine"><img
						src="images_icon/icon_students.png" width="28" height="23"
						align="absmiddle" />&nbsp;&nbsp;同学录</a>
				</li>
				<li><a href="mood!update_moodGet"><img
						src="images_icon/icon_trends.png" width="28" height="23"
						align="absmiddle" />&nbsp;&nbsp;动 态</a>
				</li>
				<li><a href="mood!moodget"><img
						src="images_icon/icon_mood.png" width="28" height="23"
						align="absmiddle" />&nbsp;&nbsp;心 情</a>
				</li>
				<li><a href="log!logfriends"><img
						src="images_icon/icon_log.png" width="28" height="23"
						align="absmiddle" />&nbsp;&nbsp;日 志</a>
				</li>
				<li><a href="photo!photogomine"><img
						src="images_icon/icon_photo.png" width="28" height="23"
						align="absmiddle" />&nbsp;&nbsp;照 片</a>
				</li>
				<li><a href="mail!mailto?type=mailget"><img
						src="images_icon/icon_mail.png" width="28" height="23"
						align="absmiddle" />&nbsp;&nbsp;邮 件</a>
				</li>
				<li><a href="talk/talk_mine.jsp"><img
						src="images_icon/icon_talk.png" width="28" height="23"
						align="absmiddle" />&nbsp;&nbsp;悄悄话</a>
				</li>
			</ul>
			<div style="margin-bottom:10px;">
				<img src="images/gg1.png" />
			</div>
			<div style="margin-bottom:10px;">
				<img src="images/gg2.png" />
			</div>
			<div style="margin-bottom:10px;">
				<img src="images/gg3.png" />
			</div>
			<div style="margin-bottom:10px;">
				<img src="images/gg4.png" />
			</div>
			<p>&nbsp;</p>
			<!-- end .sidebar1 -->
		</div>
		<div class="content">
			<!-- InstanceBeginEditable name="可编辑区域" -->
			<!--上传相册-->
			<link rel="stylesheet" type="text/css" href="css/log1.css">
			<link rel="stylesheet" type="text/css" href="css/photo.css">
			<script src="js/mail_write.js" type="text/javascript"></script>
			<script src="js/photo_js.js" type="text/javascript"></script>
			<div class="log_top">
				<div class="log_top_picture">
					<img src="images/photo1.png" width="60" height="60"
						style="float:left;" />
				</div>
				<div class="log_top_content">
					<p>
						<b>[${sessionScope.UserName }]的相册-上传相册</b>
					</p>
					<hr />
					<a href="user!PersonalinforgetServlet?name=${UserName}">
						<p style="color:green">进入${sessionScope.UserName }的个人资料</p>
					</a>
				</div>
			</div>
			<div class="log_botton">
				<div class="log_menu">
					<ul>
						<li><a href="photo!photogomine">我的相册</a>
						</li>
						<li><a href="photo!PhotoFriendsSearchSevlet">好友相册</a>
						</li>
						<li
							style="background-color:white; border-left:1px solid green; border-right:1px solid green; border-top:1px solid green;"><a
							href="photo!GouploadServlet" style="color:black;">上传相册</a>
						</li>
					</ul>
				</div>
				<hr color="#8CDA5C" />
				<div class="log_botton_freindslog">
					<div class="unload_photo">
						<span style="color:#8D8D8D; line-height:35px;">&nbsp;<b>上传新照片，可以新建相框(带*号的必填)</b>
						<hr style="padding:0px; margin:0px; color:silver;" />
						</span>
						<div class="unload_photo_content">
							<form action="photo!uploadServlet" method="post"
								enctype="multipart/form-data" onsubmit="return checkNUll();">
								<table>
									<tr>
										<td>*选择相片：</td>
										<td><input id="p_path" type="file" style="color:#8D8D8D"
											name="image" onclick="noshow_photo2()" /><!-- <span
											style="cursor:pointer;" onclick="javascript:show_photo2();">点击预览</span> -->
											<div class="showphoto" id="showphoto">
												<img src="images_photos/photo1.jpg" width="200" height="200" />
											</div></td>
									</tr>
									<tr>
										<td>*相框名称：</td>
										<td><input type="text" id="photo_border_newname"
											name="name" placeholder="请输入相框名" value="${requestScope.pname }"/> <select size="1"
											name="photo_border_oldname" id="select"
											onclick="return get();" style="width:111px; ">
												<option value="--选择相框--"
													style="border-bottom:1px gray dotted;">--选择相框--</option>
												<c:forEach items="${requestScope.list2}" var="vo">
													<option value="${vo.p_name}"
														style="border-bottom:1px gray dotted;">${vo.p_name}</option>

												</c:forEach>
										</select></td>
									</tr>
									<tr>
										<td>*相片隐私：</td>
										<td><select size="1" name="power" style="width:111px;">
												<option value="所有人可见" style="border-bottom:1px gray dotted;">所有人可见</option>
												<option value="我的好友可见"
													style="border-bottom:1px gray dotted;">我的好友可见</option>
												<option value="只允许我可见"
													style="border-bottom:1px gray dotted;">只允许我可见</option>
										</select></td>
									</tr>
									<tr>
										<td style="float:left;">&nbsp;相片说明：</td>
										<td><textarea name="explain"
												style="width:270px; height:65px;"></textarea>
										</td>
									</tr>
									<tr>
										<td><input type="submit" value="上传"
											style="color:#8D8D8D;" />
										</td>
										<td><input type="reset" value="重置" style="color:#8D8D8D;" />
										</td>
									</tr>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- InstanceEndEditable -->
			<!-- end .content -->
		</div>
		<div class="footer">
			<hr style="border:1px solid green;" />
			<span style="color:gray; margin-right:240px;">Copyright &copy;
				2014 吉首大学软件外包学院Java二班3组版权所有</span> <a
				href="http://images.5460.net/aboutus/index.htm" target="_blank">
				关于</a> | <a href="http://txl.5460.net/huiju/huodong.jsp" target="_blank">公益&amp;活动</a>
			| <a href="http://images.5460.net/pic/us/hr-2008/" target="_blank">招聘</a>
			| <a href="http://images.5460.net/pic/us/20070716/ad.jsp"
				target="_blank">广告</a> | <a href="/nofilter/help/privacy.jsp">用户隐私</a>
			| <a href="http://sns.5460.net/guestbook!showGuest.action">意见反馈</a> |
			<a href="/nofilter/help/help_lianxi.jsp">市场合作</a>
			<!-- end .footer -->
		</div>
		<!-- end .container -->
	</div>
</body>
</html>
