<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>编辑信息</title>
<style type="text/css">
#preview_wrapper {
	display: inline-block;
	width: 160px;
	height: 200px;
	background-color: #CCC;
}

#preview_fake { /* 该对象用于在IE下显示预览图片
*/
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale
		);
}
#preview_size_fake { /* 该对象只用来在IE下获得图片的原始尺寸，无其它用途
*/
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image
		);
	visibility: hidden;
}
#preview { /* 该对象用于在FF下显示预览图片
*/
	width: 160px;
	height: 200px;
}
</style>
<script type="text/javascript">
	function onUploadImgChange(sender) {
		if (!sender.value.match(/.jpg|.gif|.png|.bmp/i)) {
			alert('图片格式无效！');
			return false;
		}

		var objPreview = document.getElementById('preview');
		var objPreviewFake = document.getElementById('preview_fake');
		var objPreviewSizeFake = document.getElementById('preview_size_fake');
		if (sender.files && sender.files[0]) {
			objPreview.style.display = 'block';
			//objPreview.style.width = 'auto';
			//objPreview.style.height = 'auto';

			// Firefox 因安全性问题已无法直接通过input[file].value
			objPreview.src=window.URL.createObjectURL(sender.files[0])
			//objPreview.src = sender.files[0].getAsDataURL();
		} else if (objPreviewFake.filters) {
			// IE7,IE8 在设置本地图片地址为 img.src 时出现莫名其妙的后果
			//（相同环境有时能显示，有时不显示），因此只能用滤镜来解决

			// IE7, IE8因安全性问题已无法直接通过 input[file].value 获取完整的文件路径
			sender.select();
			var imgSrc = document.selection.createRange().text;
			objPreviewFake.filters
					.item('DXImageTransform.Microsoft.AlphaImageLoader').src = imgSrc;
			objPreviewSizeFake.filters
					.item('DXImageTransform.Microsoft.AlphaImageLoader').src = imgSrc;
			autoSizePreview(objPreviewFake, objPreviewSizeFake.offsetWidth,
					objPreviewSizeFake.offsetHeight);
			objPreview.style.display = 'none';
		}
	}

	function onPreviewLoad(sender) {
		autoSizePreview(sender, sender.offsetWidth, sender.offsetHeight);
	}

	function autoSizePreview(objPre, originalWidth, originalHeight) {
		var zoomParam = clacImgZoomParam(300, 300, originalWidth,
				originalHeight);
		objPre.style.width = zoomParam.width + 'px';
		objPre.style.height = zoomParam.height + 'px';
		objPre.style.marginTop = zoomParam.top + 'px';
		objPre.style.marginLeft = zoomParam.left + 'px';
	}

	function clacImgZoomParam(maxWidth, maxHeight, width, height) {
		var param = {
			width : width,
			height : height,
			top : 0,
			left : 0
		};
		if (width > maxWidth || height > maxHeight) {
			rateWidth = width / maxWidth;
			rateHeight = height / maxHeight;
			if (rateWidth > rateHeight) {
				param.width = maxWidth;
				param.height = height / rateWidth;
			} else {
				param.width = width / rateHeight;
				param.height = maxHeight;
			}
		}

		param.left = (maxWidth - param.width) / 2;
		param.top = (maxHeight - param.height) / 2;
		return param;
	}
</script>
<link rel="stylesheet" type="text/css" href="css/muban.css">
<link rel="stylesheet" type="text/css" href="css/log1.css">
<link rel="stylesheet" type="text/css" href="css/mail.css">
<script src="js/time.js" type="text/javascript"></script>
</head>

<body>
<!-- <div id="preview_wrapper"> -->
		<!-- <div id="preview_fake">
			<img id="preview" onload="onPreviewLoad(this)" />
		</div> -->
	</div>
	<br />
	<!-- <input id="upload_img" type="file" onchange="onUploadImgChange(this)" /> -->
	<!-- <br /> -->
	<!-- <img id="preview_size_fake" /> -->



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
							<li><a href="friend!friends/friends_search.jsp">查找好友</a>
							</li>
							<li><a href="friend!friends/friends_recommend.jsp">推荐好友</a>
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
			<!--编辑个人信息-->
			<link rel="stylesheet" type="text/css" href="css/log1.css">
			<link rel="stylesheet" type="text/css" href="css/book.css">
			<link rel="stylesheet" type="text/css" href="css/index.css">
			<script src="js/book.js" type="text/javascript"></script>
			<script src="js/personalinfor.js" type="text/javascript"></script>
			<script language="javascript" type="text/javascript"
				src="personal_info/My97DatePicker/WdatePicker.js"></script>
			<div class="log_top">
				<div class="log_top_picture">
					<img src="images/photo1.png" width="60" height="60"
						style="float:left;" />
				</div>
				<div class="log_top_content">
					<p>
						<b>[${sessionScope.UserName }]的同学录-个人资料填写</b>
					</p>
					<a href="index/index.jsp">
						<p style="color:green">进入${sessionScope.UserName }的首页</p>
					</a>
					<hr />
				</div>
			</div>
			<div class="log_botton">
				<hr color="#8CDA5C" />

				<div class="log_botton_freindslog">
					<!--如果有的话，就显示下面的内容-->
					<div class="log_botton_mylog_yes">
						<div class="index_content"
							style="padding:0px; color:#000; font-family:'Courier New', Courier, monospace; font-size:17px; ">
							<form action="user!personalServlet" method="post"
								enctype="multipart/form-data">
								<div style="height:450px; ">
									<div
										style="height:450px; width:300px; border:1px solid #FFF; float:left;">
										<table style="width:300px; height:450px ">
											<tr>
												<td height="200px"><div id="preview_wrapper" style="width:160px;height: 200px;"><div id="preview_fake" onload="onPreviewLoad(this)"
														style="height:200px; width:160px;border:1px solid #CCC; margin:auto">
														<c:if test="${vo.uHead!=''}">
															<img src="${vo.uHead }" id="preview" style="height:200px; width:160px;" />
														</c:if>
														<br />
														<br />
														<br />
														<br />
														<span
															style="font-size:18px;color:#060; font-family:'华文楷体';"></span>
													</div></div>
												</td>
											</tr>
											<tr>
												<td>上传照片：<input name="image" type="file" id="upload_img" onchange="onUploadImgChange(this)"
													style="width:170px" />
												</td>
											</tr>
											<tr>
												<td height="35px">就读院校： <input name="ureadingschool"
													type="text" width="100px" value="${vo.uReadingschool }" />
												</td>
											</tr>
											<tr>
												<td height="35px">曾读院校： <input name="ureadsschool"
													type="text" width="100px" value="${vo.uReadschool }" />
												</td>
											</tr>
											<tr>
												<td height="35">原始密码： <input name="password"
													type="password" disabled="disabled" width="100px"
													value="${vo.uPassword }" />
												</td>
											</tr>
											<tr>
												<td height="35px">修改密码： <input name="password"
													type="password" width="100px" id="updatepwd1" /><span
													style="color:red;" id="pwd1erro"></span>
												</td>
											</tr>
											<tr>
												<td height="35px">确认密码： <input name="upassword"
													type="password" width="100px" id="updatepwd2" /><span
													style="color:red;" id="pwd2erro"></span>
												</td>
											</tr>
										</table>
									</div>

									<div
										style="height:500px; width:450px; float:right;border:1px solid #FFF">
										<table style="height:450px;width:450px">
											<tr>
												<td style="height:40px; width:100px">用户名：</td>
												<td style="height:40px;"><input name="uname"
													type="text" disabled="disabled" value="${vo.uName }" />
												</td>
											</tr>
											<tr>
												<td style="height:40px; width:100px">真实姓名：</td>
												<td style="height:40px;"><input name="unickname"
													type="text" value="${vo.uNickname }" />
												</td>
											</tr>


											<tr>
												<td style="height:40px; width:100px">年龄：</td>
												<td style="height:40px;"><input name="uage" type="text"
													value="${vo.uAge }" />
												</td>
											</tr>

											<tr>
												<td style="height:40px; width:100px">性别：</td>
												<td style="height:40px;"><c:if test="${vo.uSex =='男'}">
														<input name="usex" type="radio" checked="checked"
															value="男" />男<input name="usex" type="radio" value="女" />女</c:if>
													<c:if test="${vo.uSex =='女'}">
														<input name="usex" type="radio" value="男" />男<input
															name="usex" type="radio" checked="checked" value="女" />女</c:if>
													<c:if test="${vo.uSex ==null or vo.uSex ==''}">
														<input name="usex" type="radio" value="男"
															checked="checked" />男<input name="usex" type="radio"
															value="女" />女</c:if></td>
											</tr>

											<tr>
												<td style="height:40px; width:100px">出生日期：</td>
												<td style="height:40px;"><input class="Wdate"
													type="text" onClick="WdatePicker()" id="len"
													value="${vo.uBirth}" name="ubirth">
												</td>
											</tr>
											<tr>
												<td style="height:40px; width:100px ">QQ号：</td>
												<td style="height:40px;"><input name="uqq" type="text"
													id="qq" value="${vo.uQq}" /><span style="color:red;"
													id="pwd3erro"></span>
												</td>
											</tr>
											<tr>
												<td style="height:40px; width:100px">手机号码：</td>
												<td style="height:40px;"><input name="utelphone"
													type="text" id="tel" value="${vo.uTelphone}" /><span
													style="color:red;" id="pwd4erro"></span>
												</td>
											</tr>
											<tr>
												<td style="height:40px; width:100px">邮箱：</td>
												<td style="height:40px;"><input name="uemail"
													type="text" disabled="disabled" value="${vo.uEmail }" />
												</td>
											</tr>
											<tr>
												<td style="height:100px; width:100px">座右铭：</td>
												<td style="height:100px;"><textarea name="umotto"
														cols="" rows="" style="width:320px; height:60px">${vo.uMotto }</textarea>
												</td>
											</tr>
											<tr>
												<td style="height:20px; width:100px"></td>
												<td style="height:20px; text-align:center"><input
													name="" type="submit" value="　提交　"
													onclick="return check();" />
												</td>
											</tr>
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
