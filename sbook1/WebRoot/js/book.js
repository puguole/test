// JavaScript Document
/*下面两个分别为已有同学录和未有的好友js*/
function f1()
{
	book_unread_content.style.display='none';
	book_read_content.style.display='none'
	//下面是鼠标双击的事件，进行隐藏和显示的替换
	
	if(book_unread_content.style.display=='block'){
		book_unread_content.style.display='none'
	}
	if(book_unread_content.style.display!='block'){
		book_unread_content.style.display='block'
	}
}
function f2()
{
	book_unread_content.style.display='none';
	book_read_content.style.display='none'
	//下面是鼠标双击的事件，进行隐藏和显示的替换
	
	if(book_read_content.style.display=='block'){
		book_read_content.style.display='none'
	}
	if(book_read_content.style.display!='block'){
		book_read_content.style.display='block'
	}
}
/*下面是显示大图风格的js*/
function styleshow1(val){
	eval(val).style.display='none';
	if(eval(val).style.display=='block'){
		eval(val).style.display='none'
	}
	if(eval(val).style.display!='block'){
		eval(val).style.display='block';
	}
}
function stylenoshow1(val){
	eval(val).style.display='none';
}
/*下面是皮肤样式*/
function changestyle(val){
	if(val=='1'){
		book_write_content.style.fontFamily='方正舒体';
		book_write_content.style.color='#FF6600';
		book_write_content.style.backgroundImage="url('book_styles/book_style5.jpg')";
	}else if(val=='0'){
		book_write_content.style.fontFamily='仿宋';
		book_write_content.style.color='red';
		book_write_content.style.backgroundImage='none'
	}
}