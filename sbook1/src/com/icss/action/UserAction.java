package com.icss.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.icss.Const;
import com.icss.commons.FileUtil;
import com.icss.dao.UsersDAO;
import com.icss.service.AdminService;
import com.icss.service.UsersService;
import com.icss.vo.AdminVO;
import com.icss.vo.UsersVO;
//ServletActionContext.getRequest().getRequestDispatcher
@Results({
	@Result(name="user_fail",location="/login.jsp"),
	@Result(name="user_success",location="/index/index.jsp"),
	@Result(name="user_info_go",location="/index/index.jsp"),
	@Result(name="admini_manager",location="/admin/user_info_manager.jsp"),
	@Result(name="register_result",location="/register/register_result.jsp"),
	@Result(name="register_error",location="/register/register.jsp"),
	@Result(name="personalshow",location="/personal_info/personalshow.jsp"),
	@Result(name="personaleidit2",location="/personal_info/personaleidit2.jsp"),
	@Result(name="user_info_update2",location="/admin/user_info_update2.jsp"),
	@Result(name="user_info_manager",location="/admin/user_info_manager.jsp")
})
public class UserAction {
	private AdminService adminService=new AdminService();
	private UsersService usersService=new UsersService();
	private File image; //上传的文件
	private String imageFileName; //文件名称
    private String imageContentType; //文件类型
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	private String uname;
	private String upassword;
	private String admin;
	private String loginself;
	private String repwd;
	private String login_fail_info;//返回错误信息
	private String logi_failnname;
	private String upwd;
	private String uemail;
	
	private String search;
	public UsersService getUsersService() {
		return usersService;
	}
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getUnickname() {
		return unickname;
	}
	public void setUnickname(String unickname) {
		this.unickname = unickname;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUreadingschool() {
		return ureadingschool;
	}
	public void setUreadingschool(String ureadingschool) {
		this.ureadingschool = ureadingschool;
	}
	public String getUreadschool() {
		return ureadschool;
	}
	public void setUreadschool(String ureadschool) {
		this.ureadschool = ureadschool;
	}
	public String getUbirth() {
		return ubirth;
	}
	public void setUbirth(String ubirth) {
		this.ubirth = ubirth;
	}
	public String getUqq() {
		return uqq;
	}
	public void setUqq(String uqq) {
		this.uqq = uqq;
	}
	public String getUtelphone() {
		return utelphone;
	}
	public void setUtelphone(String utelphone) {
		this.utelphone = utelphone;
	}
	public String getUmotto() {
		return umotto;
	}
	public void setUmotto(String umotto) {
		this.umotto = umotto;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUreadsschool() {
		return ureadsschool;
	}
	public void setUreadsschool(String ureadsschool) {
		this.ureadsschool = ureadsschool;
	}
	private String unickname;
	private int uage;
	private String usex;
	private String ureadingschool;
	private String ureadschool;
	private String ubirth;
	private String uqq;
	private String utelphone;
	private String umotto;
	private String name;
	private String ureadsschool;
	public String getLogi_failnname() {
		return logi_failnname;
	}
	public void setLogi_failnname(String logi_failnname) {
		this.logi_failnname = logi_failnname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getLoginself() {
		return loginself;
	}
	public void setLoginself(String loginself) {
		this.loginself = loginself;
	}
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	public String execute(){
		System.out.println("a");
		return null;
	}
	/**
	 * 后台-搜索
	 */
	public String doUsersinfosearch(){
		String uname=this.search;
		try {
			if("".equals(uname)){
				ArrayList<UsersVO> list= (ArrayList<UsersVO>) usersService.findAll();
				ServletActionContext.getRequest().setAttribute("list", list);
				ServletActionContext.getRequest().setAttribute("search", uname);
				return "user_info_manager";
			}else{
				ArrayList<UsersVO> list= (ArrayList<UsersVO>) usersService.findByName_xf(uname);
				ServletActionContext.getRequest().setAttribute("list", list);
				ServletActionContext.getRequest().setAttribute("search", uname);
				return "user_info_manager";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 后台-删除
	 */
	public String doUsersinfodelete(){
		String uname=this.uname;
		UsersVO vo=new UsersVO();
		vo.setuName(uname);
		try {
			usersService.delete(vo);
			return doUsersinfogo();
		} catch (Exception e) {
			System.out.println("删除失败");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 后台-显示
	 */
	public String doUsersinfogo(){
		try {
			ArrayList<UsersVO> list= (ArrayList<UsersVO>) usersService.findAll();
			ServletActionContext.getRequest().setAttribute("list", list);
			return "user_info_manager";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("没有找到数据");
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 后台-修改
	 */
	public String doUsersinforupdate2(){
		String uname=this.uname;
		String upassword=this.upassword;
		String uemail=this.uemail;
		String unickname=this.unickname;
		int uage=this.uage;
		String usex=this.usex;
		String ureadingschool=this.ureadingschool;
		String ureadschool=this.ureadschool;
		String ubirth=this.ubirth;
		String uqq=this.uqq;
		String utelphone=this.utelphone;
		String umotto=this.umotto;
		
		UsersVO vo=new UsersVO();
		vo.setuAge(uage);
		vo.setuBirth(ubirth);
		vo.setuEmail(uemail);
		vo.setuMotto(umotto);
		vo.setuName(uname);
		vo.setuNickname(unickname);
		vo.setuPassword(upassword);
		vo.setuQq(uqq);
		vo.setuReadingschool(ureadingschool);
		vo.setuReadschool(ureadschool);
		vo.setuSex(usex);
		vo.setuTelphone(utelphone);
		try {
			usersService.modify_xf(vo);
			return doUsersinfogo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("修改失败");
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 后台-更新
	 */
	public String doUsersinfoupdate(){
		String uname=this.uname;
		try {
			ArrayList<UsersVO> list= (ArrayList<UsersVO>) usersService.findAll();
			 UsersVO usersVO=new UsersVO();
			  usersVO.setuName(uname); 
			  UsersVO vo2=new UsersVO();
			  try {
				  vo2=usersService.findByName(usersVO);
				  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ServletActionContext.getRequest().setAttribute("list", list);
			ServletActionContext.getRequest().setAttribute("vo", vo2);
			return "user_info_update2";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("没有找到数据");
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 确认编辑
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Action("personalServlet")
	public String doPersonalServlet() throws ServletException, IOException{
		UsersVO vo=new UsersVO();
		UsersVO vo2=new UsersVO();
		UsersService usersService=new UsersService();
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String)session.getAttribute(Const.LOGINUNAME);//通过session获取
		vo.setuName(uname);
		try {
			vo2=usersService.findByName(vo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		vo.setuReadingschool(ureadingschool);
		vo.setuReadschool(ureadsschool);
		vo.setuNickname(unickname);
		vo.setuAge(uage);
		vo.setuSex(usex);
		vo.setuBirth(ubirth);
		vo.setuQq(uqq);
		vo.setuTelphone(utelphone);
		vo.setuMotto(umotto);
		if(upassword.equals("")){
			vo.setuPassword(vo2.getuPassword());//如果密码项为空就在修改时设置它为原密码
		}else{
			vo.setuPassword(upassword);
		}
		String head="";
		String realpath = ServletActionContext.getServletContext().getRealPath("upload/" + new SimpleDateFormat("yyyy/MM/dd/hhmmss").format(new Date()).toString()+"/");
		String savepath="upload/" + new SimpleDateFormat("yyyy/MM/dd/hhmmss").format(new Date()).toString()+"/";//把该图片放在upload下的用户编号下
		//D:\apache-tomcat-6.0.18\webapps\struts2_upload\\upload\ss0
        if (image != null) {
            File savefile = new File(new File(realpath), imageFileName);//savename即为需要保存的路径
            if (!savefile.getParentFile().exists())
                savefile.getParentFile().mkdirs();
            try {
				FileUtils.copyFile(image, savefile);
				head=savepath+imageFileName;
				System.out.println("上传成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else{
        	head=vo2.getuHead();
        }
        vo.setuHead(head);
		UsersDAO udao=new UsersDAO();
		try {
			udao.modify(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletActionContext.getRequest().setAttribute("name", uname);
		return doPersonalinforgetServlet();
	}
	/**
	 * 编辑
	 */
	@Action("PersonalinforgoEditServlet")
	public String doPersonalinforgoEditServlet(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String)session.getAttribute(Const.LOGINUNAME);//通过session获取
		System.out.println(uname);
		UsersVO vo=new UsersVO();
		UsersVO vo2=new UsersVO();
		vo.setuName(uname);
		try {
			vo2=usersService.findByName(vo);
			ServletActionContext.getRequest().setAttribute("vo", vo2);
			System.out.println(vo.getuAge());
			return "personaleidit2";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("查找失败");
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 获取信息
	 */
	@Action("PersonalinforgetServlet")
	public String doPersonalinforgetServlet(){
		String uname="";
		if(this.name!=null){
			//通过request.getParam..得到name
			uname=this.name;
		}else{
			uname=(String) ServletActionContext.getRequest().getAttribute("name");
		}
		UsersVO vo=new UsersVO();
		UsersVO vo2=new UsersVO();
		vo.setuName(uname);
		try {
			vo2=usersService.findByName(vo);
			ServletActionContext.getRequest().setAttribute("vo", vo2);
			System.out.println(vo.getuAge());
			return "personalshow";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("查找失败");
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 登录验证
	 * @return
	 */
	public String logincheck(){
		if(admin==null){//说明不是管理员登录
			//处理逻辑
			UsersService uservice=new UsersService();
			boolean b=uservice.checkLogin(uname, upassword);
			//跳转
			if(b==false){
				login_fail_info="登录失败";//返回错误信息
				logi_failnname=uname;//返回用户名，不必重新输入用户名
				return "user_fail";
			}else{
				//保存session
				HttpSession s=ServletActionContext.getRequest().getSession();
				s.removeAttribute("admin");//移除后台session
				//加入新的
				s.setAttribute(Const.LOGINUNAME, uname);
				//在这里进行判断是否勾选
				if(loginself!=null){
					s.setAttribute("loginself", "下次自动登录");
				}
				if(repwd!=null){
					Cookie cookie=new Cookie("runame", uname);
					cookie.setMaxAge(3600);//一个小时
					ServletActionContext.getResponse().addCookie(cookie);
					Cookie cookie2=new Cookie("rupwd", upassword);
					cookie2.setMaxAge(3600);//一个小时
					ServletActionContext.getResponse().addCookie(cookie2);
				}
				return "user_success";
			}
		}else{
			AdminVO vo=new AdminVO();
			vo.setaName(uname);
			AdminVO vo2=null;
			try {
				vo2=adminService.findByName(vo);
				if(vo2.getaPwd().equals(upassword)){
					HttpSession s=ServletActionContext.getRequest().getSession();
					s.removeAttribute(Const.LOGINUNAME);//移除前台session
					//加入新的
					s.setAttribute("admin", vo.getaName());
					System.out.println("admin:"+vo.getaName());
					userinfogo();
					return "admini_manager";
				}else{
					login_fail_info= "密码错误";//返回错误信息
					logi_failnname= uname;//返回用户名，不必重新输入用户名
					return "user_fail";
				}
			} catch (Exception e) {
				login_fail_info= "没有此账号";//返回错误信息
				logi_failnname= uname;//返回用户名，不必重新输入用户名
				return "user_fail";
			}
		}
	}
	/**
	 * 跳转到后台用户列表
	 * @return
	 */
	public String userinfogo(){
		try {
			ArrayList<UsersVO> list = (ArrayList<UsersVO>) usersService.findAll();
			ServletActionContext.getRequest().setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "admini_manager";
	}
	/**
	 * 注册
	 * @return
	 */
	public String doRegister(){
		UsersVO usersVO=new UsersVO();
		usersVO.setuEmail(uemail);
		usersVO.setuPassword(upwd);
		usersVO.setuName(uname);
		System.out.println(uname+" "+upwd+" "+uemail);
		try {
			usersService.add(usersVO);
			System.out.println("插入成功");
			ServletActionContext.getRequest().setAttribute("result", "注册成功！");
			ServletActionContext.getRequest().setAttribute("uname", uname);
			ServletActionContext.getRequest().setAttribute("upassword", upwd);
			return "register_result";
		} catch (Exception e) {
			System.out.println("插入失败");
			// TODO Auto-generated catch block
			ServletActionContext.getRequest().setAttribute("erro", "用户名重复了!");
			e.printStackTrace();
			return "register_error";
		}
	}
	
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getuEmail() {
		return uemail;
	}
	public void setuEmail(String uEmail) {
		this.uemail = uEmail;
	}
	public String getLogin_fail_info() {
		return login_fail_info;
	}
	public void setLogin_fail_info(String login_fail_info) {
		this.login_fail_info = login_fail_info;
	}
}
