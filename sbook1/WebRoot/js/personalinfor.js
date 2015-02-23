// JavaScript Document
function check(){
	//先进行验证修改密码，如果修改密码框没值，就不处理，若有值，就进行判断确认密码是否和上面的一样（保存到数据库的密码通过修改密码框的值）
	var pwd1=document.getElementById("updatepwd1").value;
	var pwd2=document.getElementById("updatepwd2").value;
	var qq=document.getElementById("qq").value;
	var tel=document.getElementById("tel").value;
	var flag=1;
	if(pwd1!=''&&pwd2=='')//密码判断，若修改密码框为空
	{
		var pwd2erro=document.getElementById("pwd2erro");
				pwd2erro.innerHTML='*';
				 alert("您若要修改密码，请填写确认密码框中的内容");
				flag=0;
	}
		if(pwd1==''&&pwd2!='')//密码判断，若确认密码框为空
	{
		var pwd1erro=document.getElementById("pwd1erro");
				pwd1erro.innerHTML='*';
	            alert("您若要修改密码，请填写修改密码框中的内容");
				flag=0;
	}
	if((pwd1!=''&&pwd2!='')&&pwd1!=pwd2)
	{
			var pwd1erro=document.getElementById("pwd1erro");
				var pwd2erro=document.getElementById("pwd2erro");
				pwd1erro.innerHTML='*';
				pwd2erro.innerHTML='*';
				alert("密码不一致！");
				flag=0;
	}
	if(qq!='')
	{
		var me=false;
		var p1=/^\d/;
		if(p1.test(qq))
		me=true;
		var pwd3erro=document.getElementById("pwd3erro");
		if(!me)
		{
			pwd3erro.innerHTML='*格式错误';
			flag=0;
		}
		else{
			pwd3erro.innerHTML='';
		}
	}
	if(tel!='')
	{
		var me=false;
		var p1=/^1[3|4|5|8][0-9]\d{4,8}$/;
		if(p1.test(tel))
		me=true;
		var pwd4erro=document.getElementById("pwd4erro");
		if(!me)
		{	
			pwd4erro.innerHTML='*格式不正确';
			flag=0;
		}
		else
		{
			pwd4erro.innerHTML='';
		}
	}
	if(flag==0)
	{
		return false;
	}
/*if(pwd1!=null&&pwd1!=''){
			if(pwd2==null||pwd2=='')
			{
				var pwd1erro=document.getElementById("pwd1erro");
				var pwd2erro=document.getElementById("pwd2erro");
				pwd1erro.innerHTML='*';
				pwd2erro.innerHTML='*';
				alert("密码不一致！");
				return false;
			}
		if(pwd2!=null&&pwd2!=''){
			if(pwd1!=pwd2){
				var pwd1erro=document.getElementById("pwd1erro");
				var pwd2erro=document.getElementById("pwd2erro");
				pwd1erro.innerHTML='*';
				pwd2erro.innerHTML='*';
				alert("密码不一致！");
				return false;
			}
		}
	}
	else{
			if(pwd2!=null||pwd2!=''){
				var pwd1erro=document.getElementById("pwd1erro");
				pwd1erro.innerHTML='*';
	            alert("您若要修改密码，请填写修改密码框中的内容");
				return false;
			}	     
	}*/

}


