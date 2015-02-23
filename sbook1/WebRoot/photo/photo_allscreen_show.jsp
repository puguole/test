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
    
    <title>全屏浏览</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/global.css">
	<script src="js/time.js" type="text/javascript"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/slides.min.jquery.js"></script>
	<script>
		$(function(){
			$('#slides').slides({
				preload: true,
				preloadImage: 'img/loading.gif',
				play: 5000,
				pause: 2500,
				hoverPause: true,
				animationStart: function(current){
					$('.caption').animate({
						bottom:-35
					},100);
					if (window.console && console.log) {
						// example return of current slide number
						console.log('animationStart on slide: ', current);
					};
				},
				animationComplete: function(current){
					$('.caption').animate({
						bottom:0
					},200);
					if (window.console && console.log) {
						// example return of current slide number
						console.log('animationComplete on slide: ', current);
					};
				},
				slidesLoaded: function() {
					$('.caption').animate({
						bottom:0
					},200);
				}
			});
		});
	</script>

  </head>
  
  <body>
	<div id="container">
		<div id="example">
			<img src="img/new-ribbon.png" width="112" height="112" alt="New Ribbon" id="ribbon">
			<div id="slides">
				<div class="slides_container">
					<c:forEach items="${requestScope.list }" var="vo">
					<div class="slide">
						<a href="http://www.flickr.com/photos/jliba/4665625073/" title="145.365 - Happy Bokeh Thursday! | Flickr - Photo Sharing!" target="_blank"><img src="${vo.p_path }" width="570" height="270" alt="Slide 1"></a>
						<div class="caption" style="bottom:0">
							<p>${vo.p_explain }</p>
						</div>
					</div>
					</c:forEach>
				</div>
				<a href="#" class="prev"><img src="img/arrow-prev.png" width="24" height="43" alt="Arrow Prev"></a>
				<a href="#" class="next"><img src="img/arrow-next.png" width="24" height="43" alt="Arrow Next"></a>
			</div>
			<img src="img/example-frame.png" width="739" height="341" alt="Example Frame" id="frame">
		</div>
		<div id="footer">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="window.history.back()" style="color:#8E7E2E;"><b>返回</b></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="photo!photogoallscreen?uname=${requestScope.uname }&pname=${requestScope.pname}" style="color:#8E7E2E;"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="photo!photogomine"  style="color:#8E7E2E;"><b>我的相册</b></a>
			<p>吉首大学同学录之我的青春 <a href="#" target="_blank">首页 GO</a>.</p>
			<p>吉首大学张家界校区 软件服务外包学院 软件工程 Java2班3组 版权所有</p>
			<p>&copy; 2014 JiShouDaXueZhangJiaJieXiaoQu. All rights reserved. Java 2 class is licensed under the pache license.</p>
		</div>
	</div>
</body>
</html>
