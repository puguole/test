<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="register/register.css" rel="stylesheet" type="text/css" />

<script src="SpryAssets/SpryValidationTextField.js" type="text/javascript"></script>
<script src="SpryAssets/SpryValidationPassword.js" type="text/javascript"></script>
<link href="SpryAssets/SpryValidationTextField.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryValidationPassword.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function checkNUll(){
	var uname=document.getElementById("uName").value;
	var pwd=document.getElementById("uPwd").value;
	var cpwd=document.getElementById("uPwdConfirm").value;
	var email=document.getElementById("uEmail").value;
	var checkbox=document.getElementsByName("checkbox");
	if(uname==null||uname==''){
	    alert("用户名不能为空！");
		document.getElementById("uName").style.backgroundColor='pink';
		document.getElementById("uName").focus();
		return false;
	}
	else if(pwd==null||pwd==''){
	alert("密码不能为空！");
		document.getElementById("uPwd").style.backgroundColor='pink';
		document.getElementById("uPwd").focus();
		return false;
	}
	else if(cpwd==null||cpwd==''){
		document.getElementById("uPwdConfirm").style.backgroundColor='pink';
		document.getElementById("uPwdConfirm")
		return false;
	}
	else if(pwd!=null&&pwd!=''&&uPwdConfirm!=null&&uPwdConfirm!=''){
		if(cpwd!=pwd){
			alert("密码输入不一致！");
			document.getElementById("uPwdConfirm").style.backgroundColor='pink';
			return false;
		}
	else if(email==null||email==''){
	    alert("邮箱不能为空！");
		document.getElementById("uEmail").style.backgroundColor='pink';
		document.getElementById("uEmail").focus();
		return false;
	}
	else if(email!=null&&email!=''){
		//在这里验证格式，格式错了就返回false
		var pattern=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
		//var pattern="\\w+[@](\\w+[.]+[a-z|A-Z]{2,10})";
		var cheFlag=pattern.test(email);
		
		if(cheFlag){
			return true;
		}
		else{
			alert("邮箱地址格式不正确");
			return  false;
		}
	}
	else if(checkbox[0].checked==false)
		return false;
	}
}
</script>
  </head>
  
<body>
 <div id="container">
  <div id="background">
   <div id="smallimage"><img src="images/index_clip_image002.gif" width="264" height="90" /></div>
   <div id="form">
   <form action="user!register" method="get"><table width="341" border="0">
  <tr>
    <td width="111" height="25">用户名：</td>
    <td width="220"><span id="sprytextfield1">
      <label for="user"></label>
      <input type="text" name="uname" id="uName" value="${requestScope.vo.uName }" />
    </span><span style="color:red;font-size: 8px;">${requestScope.erro }</span></td>
  </tr>
  <tr>
    <td height="27">密　码：</td>
    <td width="220"><span id="sprypassword1">
      <label for="mima"></label>
      <input type="password" name="upwd"  id="uPwd"/>
    </span></td>
  </tr>
  <tr>
    <td height="27">确认密码：</td>
    <td width="220"><span id="sprypassword2">
      <label for="querenmima"></label>
      <input type="password" name="uPwdConfirm" id="uPwdConfirm"/>
    </span></td>
  </tr>
  <tr>
    <td height="26">电子邮箱：</td>
    <td width="220"><span id="sprytextfield2">
      <label for="email"></label>
      <input type="text" name="uemail" id="uEmail" />
    </span></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="checkbox" name="checkbox" value="已选" id="checkbox" />
      <label for="checkbox">我已阅读并同意相关条款 </label></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" name="reg" id="reg" value="立即注册" onclick="return checkNUll();" />&nbsp;<a href="#" style="color:#CCCCCC;">相关协议</a></td>
  </tr>
</table>
</form></div>
   
  </div>
</div>
<script type="text/javascript">
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytextfield1");
var sprypassword1 = new Spry.Widget.ValidationPassword("sprypassword1");
var sprypassword2 = new Spry.Widget.ValidationPassword("sprypassword2");
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytextfield2");
</script>
</body>
</html>
