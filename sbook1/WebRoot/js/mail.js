// JavaScript Document
/*下面两个分别为未读邮件和已读邮件js*/
function f1()
{
	mail_botton_systeminfor_yes_content.style.display='none';
	mail_no_read_content.style.display='none'
	//下面是鼠标双击的事件，进行隐藏和显示的替换
	
	if(mail_no_read_content.style.display=='block'){
		mail_no_read_content.style.display='none'
	}
	if(mail_no_read_content.style.display!='block'){
		mail_no_read_content.style.display='block'
	}
}
function f2()
{
	mail_botton_systeminfor_yes_content.style.display='none';
	mail_no_read_content.style.display='none'
	//下面是鼠标双击的事件，进行隐藏和显示的替换
	
	if(mail_botton_systeminfor_yes_content.style.display=='block'){
		mail_botton_systeminfor_yes_content.style.display='none'
	}
	if(mail_botton_systeminfor_yes_content.style.display!='block'){
		mail_botton_systeminfor_yes_content.style.display='block'
	}
}