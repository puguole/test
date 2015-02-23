// JavaScript Document
function show_photo(val){
	eval(val).style.display='none'
	//下面是鼠标双击的事件，进行隐藏和显示的替换
	if(eval(val).style.display=='block'){
		eval(val).style.display='none'
	}else if(eval(val).style.display=='none'){
		eval(val).style.display='block'
	}
}
function noshow_photo(val){
	eval(val).style.display='none';
}
/*下面的是相册预览的js*/
function show_photo2(){
	showphoto.style.display='none'
	//下面是鼠标双击的事件，进行隐藏和显示的替换
	
	if(showphoto.style.display=='block'){
		showphoto.style.display='none'
	}
	if(showphoto.style.display=='none'){
		showphoto.style.display='block'
	}
}
function noshow_photo2(){
	showphoto.style.display='none';
}