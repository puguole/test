package com.icss.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.icss.Const;
import com.icss.commons.FileUtil;
import com.icss.dao.MailDAO;
import com.icss.service.FriendsService;
import com.icss.service.MailService;
import com.icss.service.moodService;
import com.icss.vo.FriendsVO;
import com.icss.vo.MailVO;
import com.opensymphony.xwork2.ActionSupport;
@Results({
	@Result(name="mail_get",location="/mail/mail_get.jsp"),
	@Result(name="mail_to",location="/mail/mail_to.jsp"),
	@Result(name="mail_write_result",location="/mail/mail_write_result.jsp"),
	@Result(name="mail_show",location="/mail/mail_show.jsp"),
	@Result(name="mail_write",location="/mail/mail_write.jsp"),
	@Result(name="mail_info_manager",location="/admin/mail_info_manager.jsp")
})
public class MailAction extends ActionSupport{
	private MailDAO mailDAO=new MailDAO();
	private static final long serialVersionUID = -3543205882377582269L;
	private File image; //上传的文件
	private String uname;
	private String etitle;
	private String etotime;
	private String touname;
	private String title;
	private String content;
	private String to_peole;
	private String eTitle;
	private String eTotime;
	private String eTouname;
	private String uName;
	private String fname;
	private String file;
	private String type;
    public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEtitle() {
		return etitle;
	}
	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}
	public String getEtotime() {
		return etotime;
	}
	public void setEtotime(String etotime) {
		this.etotime = etotime;
	}
	public String getTouname() {
		return touname;
	}
	public void setTouname(String touname) {
		this.touname = touname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String geteTitle() {
		return eTitle;
	}
	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}
	public String geteTotime() {
		return eTotime;
	}
	public void seteTotime(String eTotime) {
		this.eTotime = eTotime;
	}
	public String geteTouname() {
		return eTouname;
	}
	public void seteTouname(String eTouname) {
		this.eTouname = eTouname;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
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
	private String imageFileName; //文件名称
    private String imageContentType; //文件类型
	public String execute(){
		return null;
	}
	/**
	 * 后台-列表
	 */
	public String doAdminmaillist(){
		try {
			ArrayList<MailVO> list= (ArrayList<MailVO>) mailDAO.findAll();
			ServletActionContext.getRequest().setAttribute("list", list);
			return "mail_info_manager";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("没有找到数据");
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 下载附件
	 * @throws IOException 
	 */
	public String doDown() throws IOException{
		String fileName =this.file;
		System.out.println("fileName="+fileName);
		String fileName1 = FileUtil.newInstance().getFileName(fileName).toString();
		System.out.println("fileName1="+fileName1);
		ServletActionContext.getResponse().reset(); 
		ServletActionContext.getResponse().setContentType("bin");
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().addHeader("Content-Disposition","attachment; filename=\"" + new String(fileName1.getBytes("utf-8"), "ISO8859-1" )  + "\"");
		
		
		File file = new File(ServletActionContext.getServletContext().getRealPath(fileName));
		OutputStream out = ServletActionContext.getResponse().getOutputStream();
		try {
			InputStream in = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
	            out.write(buffer, 0, bytesRead);
	        }
	        out.close();
	        in.close();
		} catch (Exception e) {
			System.out.println("没有获取到文件,upload文件夹没了0.0");
			// TODO: handle exception
		}
		return "";
	}
	/**
	 * 发送
	 * @throws UnsupportedEncodingException 
	 */
	public String doMailto() throws UnsupportedEncodingException{
		MailService mailService=new MailService();
		//获取uname，根据uname执行操作
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);
		String type=this.type;
		if(type.equals("mailget")){
			try {
				long count1=mailService.findCount(uname, "已读");
				long count2=mailService.findCount(uname, "未读");
				ServletActionContext.getRequest().setAttribute("count1", count1);
				ServletActionContext.getRequest().setAttribute("count2", count2);
				ArrayList list1;
				ArrayList list2;
				list1 = (ArrayList) mailService.findAll3(uname, "已读");
				list2 = (ArrayList) mailService.findAll3(uname, "未读");
				ServletActionContext.getRequest().setAttribute("list1", list1);
				ServletActionContext.getRequest().setAttribute("list2", list2);
				return "mail_get";
			} catch (Exception e) {e.printStackTrace();
			}
		}
		if(type.equals("maildelete")){//进行的是删除，但其实并未删除邮件写信，而是把u_show改为n
			String uName=(String) session.getAttribute(Const.LOGINUNAME);
			String eTouname;
			if(!this.uname.equals(uName)){
				uName=this.uname;
				eTouname=(String) session.getAttribute(Const.LOGINUNAME);
			}
			String eTitle=this.etitle;
			String eTotime=this.etotime;
			eTouname=this.touname;
			MailVO vo=new MailVO();
			vo.seteTitle(eTitle);
			vo.seteTotime(eTotime);
			vo.seteTouname(eTouname);
			vo.setuName(uName);
			//System.out.println(vo.getuName()+" "+vo.geteTitle()+" "+vo.geteTouname()+" "+vo.geteTotime());
			try {
				if(!this.uname.equals((String) session.getAttribute(Const.LOGINUNAME))){
					mailService.delete2(vo);
					ServletActionContext.getResponse().sendRedirect("mail!mailto?type=mailget");
					return null;
				}else{
					mailService.delete(vo);
					ServletActionContext.getResponse().sendRedirect("mail!mailto?type=mailto");
					return null;
				}
			} catch (Exception e) {System.out.println("删除失败");
			}
		}
		if(type.equals("mailto")){//如果类型是收件箱
			ArrayList list;
			try {
				list = (ArrayList) mailService.findAll2(uname);
				ServletActionContext.getRequest().setAttribute("list", list);
				return "mail_to";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(type.equals("mailwrite")){//写日志
			//System.out.println(request.getParameter("title"));//这种方法得不到值
			String uName=uname;
			String eTitle=this.title;
			String eContent = this.content;
			String eFile="";
			String eStyle="正式";//默认正式
			String eTotime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			String eTouname=ServletActionContext.getRequest().getParameter("to_peole");
			String eState="未读";//默认未读
			String uShow="y";
			String tShow="y";
			
			
			//eFile = "upload/" + new SimpleDateFormat("yyyy/MM/dd/").format(new Date())+UUID.randomUUID().toString()+"/";
			String realpath = ServletActionContext.getServletContext().getRealPath("upload/" + new SimpleDateFormat("yyyy/MM/dd/hhmmss").format(new Date()).toString()+"/");
			String savepath="upload/" + new SimpleDateFormat("yyyy/MM/dd/hhmmss").format(new Date()).toString()+"/";//把该图片放在upload下的用户编号下
			//D:\apache-tomcat-6.0.18\webapps\struts2_upload\\upload\ss0
	        if (image != null) {
	            File savefile = new File(new File(realpath), imageFileName);//savename即为需要保存的路径
	            if (!savefile.getParentFile().exists())
	                savefile.getParentFile().mkdirs();
	            try {
					FileUtils.copyFile(image, savefile);
					eFile=savepath+imageFileName;
					System.out.println("上传成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
			//进行存储到数据库中
			MailVO vo=new MailVO();
			vo.seteContent(eContent);
			vo.seteFile(eFile);
			vo.seteState(eState);
			vo.seteStyle(eStyle);
			vo.seteTitle(eTitle);
			vo.seteTotime(eTotime);
			vo.seteTouname(eTouname);
			vo.setuName(uName);
			vo.settShow(tShow);
			vo.setuShow(uShow);
			boolean b=false;
			try {
				mailService.add(vo);b=true;
			} catch (Exception e) {e.printStackTrace();
			}
			//解析请求，获取文件项列表
			//request.getRequestDispatcher("show.jsp").forward(request, response);
			if(b){
				ServletActionContext.getRequest().setAttribute("result", "邮件已成功发出！");
			}else{
				ServletActionContext.getRequest().setAttribute("result", "邮件发送失败！可能出在服务器高峰期，请稍后再试！");
			}
			ServletActionContext.getRequest().setAttribute("vo", vo);
			System.out.println("vo.content="+vo.geteContent());
			return "mail_write_result";
		}
		if(type.equals("mailshow")){
			String uName=(String) session.getAttribute(Const.LOGINUNAME);
			System.out.println("uname="+uname);
			String eTitle=ServletActionContext.getRequest().getParameter("eTitle");
			String eTotime=ServletActionContext.getRequest().getParameter("eTotime");
			String eTouname=ServletActionContext.getRequest().getParameter("eTouname");
			MailVO vo=new MailVO();
			vo.seteTitle(eTitle);
			vo.seteTotime(eTotime);
			vo.seteTouname(eTouname);
			vo.setuName(uName);
			//System.out.println(vo.getuName()+" "+vo.geteTitle()+" "+vo.geteTouname()+" "+vo.geteTotime());
			try {
				MailVO mvo=mailService.findEmail(vo);
				//System.out.println(mvo.geteContent());
				ServletActionContext.getRequest().setAttribute("vo", mvo);
				return "mail_show";
			} catch (Exception e) {
			}
		}
		if(type.equals("mailshow2")){//在收件箱链接过来的
			//说明，这个事收件箱链接过来的。所以，当点击查看，则应该把邮件状态改为已读
			String eTouname=(String) session.getAttribute(Const.LOGINUNAME);
			System.out.println("uname="+uname);
			String eTitle=ServletActionContext.getRequest().getParameter("eTitle");
			String eTotime=ServletActionContext.getRequest().getParameter("eTotime");
			String uName=ServletActionContext.getRequest().getParameter("uName");
			MailVO vo=new MailVO();
			vo.seteTitle(eTitle);
			vo.seteTotime(eTotime);
			vo.seteTouname(eTouname);
			vo.setuName(uName);
			//System.out.println(vo.getuName()+" "+vo.geteTitle()+" "+vo.geteTouname()+" "+vo.geteTotime());
			try {
				MailVO mvo=mailService.findEmail(vo);
				//设置状态为已读
				mailService.modify(mvo);
				//System.out.println(mvo.geteContent());
				ServletActionContext.getRequest().setAttribute("vo", mvo);
				return "mail_show";
			} catch (Exception e) {
			}
		}
		return "";
	}
	public String doMailgowrite(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		FriendsService friendsService=new FriendsService();
		ArrayList<FriendsVO> list=new ArrayList<FriendsVO>();
		try {
			list=(ArrayList<FriendsVO>) friendsService.findAll2((String)session.getAttribute(Const.LOGINUNAME));
			//获取从邀请好友填写同学录界面传过来的值
			if(this.fname!=null){
				ServletActionContext.getRequest().setAttribute("fname", this.fname);
				ServletActionContext.getRequest().setAttribute("etitle", "invite");
				ServletActionContext.getRequest().setAttribute("inviteinfo", "please give me a ybook！");
			}
		} catch (Exception e) {e.printStackTrace();System.out.println("没有得到好友列表");
		}
		ServletActionContext.getRequest().setAttribute("list", list);
		return "mail_write";
	}
}
