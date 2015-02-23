package com.icss.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Action;

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
import com.icss.dao.PhotosDAO;
import com.icss.dao.UsersDAO;
import com.icss.dao.pframeDAO;
import com.icss.service.PframeService;
import com.icss.service.PhotoService;
import com.icss.service.update_photoService;
import com.icss.vo.UsersVO;
import com.icss.vo.pframeVO;
import com.icss.vo.photoVO;
import com.opensymphony.xwork2.ActionSupport;
@Results({
	@Result(name="photo_mine",location="/photo/photo_mine.jsp"),
	@Result(name="update_photo",location="/update/update_photo.jsp"),
	@Result(name="photo_big_look",location="/photo/photo_big_look.jsp"),
	@Result(name="photo_allscreen_show",location="/photo/photo_allscreen_show.jsp"),
	@Result(name="photo_show",location="/photo/photo_show.jsp"),
	@Result(name="photo_friends_show",location="/photo/photo_friends_show.jsp"),
	@Result(name="photo_unload",location="/photo/photo_unload.jsp"),
	@Result(name="photo_friends_search",location="/photo/photo_friends_search.jsp"),
	@Result(name="photo_friends",location="/photo/photo_friends.jsp"),
	@Result(name="photo_unload_result",location="/photo/photo_unload_result.jsp"),
	@Result(name="photo_info_manager",location="/admin/photo_info_manager.jsp")
})
public class PhotoAction extends ActionSupport{
	private static final long serialVersionUID = -3543205882377582269L;
	private PframeService pframeService=new PframeService();
	private update_photoService  upp=new update_photoService();
	private PhotoService photoService=new PhotoService();
	private PhotosDAO photosDAO=new PhotosDAO();
	private UsersDAO udao=new UsersDAO();
	private File image; //上传的文件
	private String imageFileName; //文件名称
    private String imageContentType; //文件类型
    private String name;
    private String power;
    private String explain;
    private String friend_search;
    private String p_id;
    private String type;
    private String uname;
    private String pname;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getFriend_search() {
		return friend_search;
	}
	public void setFriend_search(String friend_search) {
		this.friend_search = friend_search;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
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
	public String execute(){
		return null;
	}
	/**
	 * 后台-列表
	 */
	public String doAdminphotolist(){
		try {
			ArrayList<photoVO> list= (ArrayList<photoVO>) photosDAO.findAll();
			ServletActionContext.getRequest().setAttribute("list", list);
			return "photo_info_manager";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("没有找到数据");
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 上传
	 * @throws UnsupportedEncodingException 
	 */
	public String doUploadServlet() throws UnsupportedEncodingException{
		HttpSession session=ServletActionContext.getRequest().getSession();
		photoVO vo=new photoVO();//创建photovo对象
		String name=(String) session.getAttribute(Const.LOGINUNAME);//通过会话获取u_name的值
		vo.setU_name(name);
		pframeVO fvo=new pframeVO();//创建pframeVO 对象
		fvo.setU_name(name);
		String eFile="";
		vo.setP_name(this.name);
		fvo.setP_name(this.name);
		vo.setP_power(this.power);
		vo.setP_explain(this.explain);
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
				vo.setP_path(eFile);
				System.out.println("上传成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
		//解析请求，获取文件项列表
		pframeDAO fdao=new pframeDAO();
		try {
			fdao.add(fvo);                //增加到数据库pframe表格
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			
		}
		PhotosDAO dao=new PhotosDAO();
		try {
			dao.add(vo);                 //增加到数据库photo表格
		} catch (Exception e) {
			ServletActionContext.getRequest().setAttribute("result", "服务器高峰期，请稍后上传！");
			return "photo_unload_result";
		}
		//System.out.println("nania");
		ServletActionContext.getRequest().setAttribute("result", "上传成功！");
		return "photo_unload_result";
		
	}
	/**
	 * 搜索好友相册
	 */
	@org.apache.struts2.convention.annotation.Action("PhotoGOServlet")
	public String doPhotoGOServlet(){
		String uname=this.friend_search;
		//进行权限判断
		HttpSession session=ServletActionContext.getRequest().getSession();
		ArrayList<UsersVO> list3=null;
		try {
			list3= (ArrayList<UsersVO>) udao.findAll_lzx2((String)session.getAttribute(Const.LOGINUNAME), uname);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(list3.size()!=0){
			UsersVO vo=new UsersVO();                        
	        UsersDAO dao=new UsersDAO();
	        List<UsersVO> list=new ArrayList<UsersVO>();
	        try {
				list=dao.findAll();               //查询获得所有的用户信息     方便之后返回一个用户名到复选框
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        List<photoVO> list2=new ArrayList<photoVO>();
	        pframeDAO dao2=new pframeDAO();
	        try {
				list2=dao2.findPhotoOrderByPname_tt(uname);  //通过它返回一个固定用户的相册名、及相片信息
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //查找自己的好友列表
	        String uname2=(String) session.getAttribute(Const.LOGINUNAME);
	        List<UsersVO> list_hy=new ArrayList<UsersVO>();
	        try {
				list_hy=dao.findAll_lzx(uname2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        ServletActionContext.getRequest().setAttribute("list_hy", list_hy);
	        ServletActionContext.getRequest().setAttribute("list", list);
	        ServletActionContext.getRequest().setAttribute("list2", list2);
	        return "photo_friends";
		}
		else{
			ServletActionContext.getRequest().setAttribute("infor", "该用户设置了权限，您无法查看其照片!");
			 return "photo_friends";
		}
	}
	/**
	 * 好友相册
	 */
	@org.apache.struts2.convention.annotation.Action("PhotoFriendsSearchSevlet")
	public String doPhotoFriendsSearchSevlet(){
		UsersVO vo=new UsersVO();
        UsersDAO dao=new UsersDAO();
        HttpSession session=ServletActionContext.getRequest().getSession();
        String uname=(String) session.getAttribute(Const.LOGINUNAME);
        List<UsersVO> list=new ArrayList<UsersVO>();
        try {
			list=dao.findAll_lzx(uname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ServletActionContext.getRequest().setAttribute("list", list);
        return "photo_friends_search";
	}
	/**
	 * 上传相册
	 */
	@org.apache.struts2.convention.annotation.Action("GouploadServlet")
	public String doGouploadServlet(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);   //通过session获得用户名
		
        List<photoVO> list2=new ArrayList<photoVO>();
        pframeDAO dao2=new pframeDAO();
        try {
			list2=dao2.findPhotoOrderByPname_tt(uname);  //通过它返回一个固定用户的相册名、及相片信息
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        ServletActionContext.getRequest().setAttribute("list2", list2);
        return "photo_unload";
	}
	/**
	 * 删除照片
	 */
	@org.apache.struts2.convention.annotation.Action("PhotoDeleteServlet")
	public String doPhotoDeleteServlet(){
		int p_id=Integer.valueOf((this.p_id));
		System.out.println("p_id="+p_id);
		photoVO vo=new photoVO();
		photoVO vo2=new photoVO();
		vo.setP_id(p_id);
      //  System.out.println(p_id+"lsdjfoiewruett right");
		PhotosDAO dao=new PhotosDAO();
		try {
			vo2=dao.findById(vo);     //获得原对象
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String u_name=vo2.getU_name();
		String p_name=vo2.getP_name();
		System.out.println("查找到的："+u_name+" "+p_name);
		try {
			dao.delete(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ServletActionContext.getRequest().setAttribute("u_name", u_name);      //传递用户名的和密码
		ServletActionContext.getRequest().setAttribute("p_name", p_name);
		return doPhotogomine();
		//request.getRequestDispatcher("photogomine").forward(request, response);//刷新页面
		//response.sendRedirect("PhotoshowServlet?p_name="+p_name+"&u_name="+u_name+"");
	}
	/**
	 * 删除相框
	 */
	public String doPhotodelete_tt(){
		String type=this.type;
		if(type.equals("deleteall")){
			String uname=this.uname;
			boolean b=false;
			try {
				pframeService.delete_tt3(uname);b=true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(b){
				try {
					pframeService.delete_tt4(uname);
					doPhotogomine();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else if(type.equals("delete")){
			String uname=this.uname;
			String pname=this.pname;
			photoVO vo1=new photoVO();
			vo1.setP_name(pname);
			vo1.setU_name(uname);
			pframeVO vo2=new pframeVO();
			vo2.setP_name(pname);
			vo2.setU_name(uname);
			System.out.println(vo2.getP_name()+" "+vo2.getU_name());
			boolean b=false;
			try {
				pframeService.delete_tt1(vo1);
				b=true;
			} catch (Exception e) {
				System.out.println("删除相册失败");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(b){
				try {
					pframeService.delete_tt2(uname,pname);
					return doPhotogomine();
				} catch (Exception e) {
					System.out.println("删除相框失败");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return doPhotogomine();
	}
	/**
	 * 显示照片
	 */
	@org.apache.struts2.convention.annotation.Action("PhotoshowServlet")
	public String doPhotoshowServlet(){
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		try {
			ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PhotosDAO dao=new PhotosDAO();
		List<photoVO> list=new ArrayList<photoVO>();
		//ArrayList list2=new ArrayList();
    	String p_name=ServletActionContext.getRequest().getParameter("p_name");
    	String u_name=ServletActionContext.getRequest().getParameter("u_name");
		try {
			list=dao.findByPname(p_name, u_name);//返回的一个list
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		ServletActionContext.getRequest().setAttribute("list", list);
		ServletActionContext.getRequest().setAttribute("p_name", p_name);
		ServletActionContext.getRequest().setAttribute("u_name", u_name);
	    HttpSession session=ServletActionContext.getRequest().getSession();
	    if(u_name.equals((String)session.getAttribute(Const.LOGINUNAME))){
	    	return "photo_show";
	    }else{
	    	return "photo_friends_show";
	    }
	}
	/**
	 * 我的相册
	 */
	public String doPhotogomine(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);//session
		System.out.println("uanme= "+uname);
		try {
			int count=pframeService.findPframeCount(uname);
			ArrayList<photoVO> list=(ArrayList<photoVO>) pframeService.findPhotoOrderByPname_tt(uname);
			ServletActionContext.getRequest().setAttribute("list", list);
			ServletActionContext.getRequest().setAttribute("count", count);
			return "photo_mine";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 相册动态
	 */
	public String doUpdate_photo(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);//session
		String p_name="美好时光";//相册的名字，到时候改
		String u_name="puguole";
		System.out.println("相册读取进来了");
		ArrayList list=null;
		try {
			list=(ArrayList) upp.updateFind(uname);
			ServletActionContext.getRequest().setAttribute("list", list);
			return "update_photo";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 查看大图
	 */
	public String doPhotogobigphoto(){
		String src=ServletActionContext.getRequest().getParameter("src");
		String uname=this.uname;
		String pname=this.pname;
		ServletActionContext.getRequest().setAttribute("src", src);
		ServletActionContext.getRequest().setAttribute("uname", uname);
		ServletActionContext.getRequest().setAttribute("pname", pname);
		System.out.println("大埔的："+uname+" "+pname);
		return "photo_big_look";
	}
	/**
	 * 浏览整个
	 */
	public String doPhotogoallscreen(){
		String uname=this.uname;
		String pname=this.pname;
		try {
			ArrayList<photoVO> list=(ArrayList<photoVO>) photoService.findAllPhoto_tt(uname, pname);
			for(photoVO vo:list){
				System.out.println(vo.getP_path());
			}
			ServletActionContext.getRequest().setAttribute("list", list);
			return "photo_allscreen_show";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
