package com.icss.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.icss.Const;
import com.icss.dao.DiscussDAO;
import com.icss.dao.LogDAO;
import com.icss.service.LogService;
import com.icss.service.update_logService;
import com.icss.vo.DiscussVO;
import com.icss.vo.LogVO;
import com.opensymphony.xwork2.ActionSupport;
@Results({
	@Result(name="log_friends",location="/log/log_friends.jsp"),
	@Result(name="update_log",location="/update/update_log.jsp"),
	@Result(name="log_show",location="/log/log_show.jsp"),
	@Result(name="log_mine",location="/log/log_mine.jsp"),
	@Result(name="log_write",location="/log/log_write.jsp"),
	@Result(name="log_write_result",location="/log/log_write_result.jsp"),
	@Result(name="log_info_manager",location="/admin/log_info_manager.jsp")
})
public class LogAction extends ActionSupport{
	private LogService logService=new LogService();
	private LogDAO logdao=new LogDAO();
	private update_logService uplog=new update_logService();
	private DiscussDAO discussdao=new DiscussDAO();
	private LogService logservice=new LogService();
	private LogDAO logDAO=new LogDAO();
	
	private String title;
	private String content;
	private String power;
	private String old;
	private String oldtitle;
	private String name;
	private String discusscontent;
	private String type;
	private String uname;
	private String lname;
	private String dname;
	private String dtime;
	private String dtitle;
	private String key;
	private String searchfriend;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
	public String getOldtitle() {
		return oldtitle;
	}
	public void setOldtitle(String oldtitle) {
		this.oldtitle = oldtitle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDiscusscontent() {
		return discusscontent;
	}
	public void setDiscusscontent(String discusscontent) {
		this.discusscontent = discusscontent;
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
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public String getDtitle() {
		return dtitle;
	}
	public void setDtitle(String dtitle) {
		this.dtitle = dtitle;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSearchfriend() {
		return searchfriend;
	}
	public void setSearchfriend(String searchfriend) {
		this.searchfriend = searchfriend;
	}
	public String execute(){
		return null;
	}
	/**
	 * 后台-列表
	 */
	public String doAdminloglist(){
		try {
			ArrayList<LogVO> list= (ArrayList<LogVO>) logDAO.findAll();
			ServletActionContext.getRequest().setAttribute("list", list);
			return "log_info_manager";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("没有找到数据");
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 编辑
	 */
	public String doLogwrite(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		String uname=(String) session.getAttribute(Const.LOGINUNAME);
		String title=this.title;
		String content=this.content;
		String power=this.power;
		String style="正式";//这里指定都是正式
		String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		LogVO vo=new LogVO();
		vo.setlTitle(title);
		vo.setlContent(content);
		vo.setlPower(power);
		vo.setlStyle(style);
		vo.setlTotime(time);
		vo.setuName(uname);
		LogVO lvo2=new LogVO();
		//先进行判断old标记，如果为old，直接修改，否则，新增
		if(!this.old.equals("")&&this.old!=null){
			System.out.println("进来了");
			//先根据用户名和标题进行查找该日志id，然后修改
			try {
				vo.setlTitle(ServletActionContext.getRequest().getParameter("oldtitle"));
				lvo2=logservice.findByNameOrTitle(vo);
				lvo2.setlTitle(title);
				lvo2.setlContent(content);
				lvo2.setlPower(power);
				lvo2.setlStyle(style);
				lvo2.setlTotime(time);
			} catch (Exception e1) {System.out.println("没有找到");
			}
			try {
				System.out.println(lvo2.getlId()+" "+lvo2.getlContent()+" "+lvo2.getlTitle());
				logdao.modify(lvo2);
				ServletActionContext.getRequest().setAttribute("result", "修改成功！");
				ServletActionContext.getRequest().setAttribute("lname", uname);
				ServletActionContext.getRequest().setAttribute("dtitle", title);
				return "log_write_result";
			} catch (Exception e) {System.out.println("修改失败！");
			}
		}else{
			LogService logService=new LogService();
			//这里最好不允许日志名相同
			if(logService.add(vo)){
				ServletActionContext.getRequest().setAttribute("result", "发表成功！");
				ServletActionContext.getRequest().setAttribute("lname", uname);
				ServletActionContext.getRequest().setAttribute("dtitle", title);
				return "log_write_result";
			}else{System.out.println("发表失败！");
			}
		}
		return "";
	}
	/**
	 * 评论
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String doLogdiscuss() throws ServletException, IOException{
		//创建service
		LogService logService=new LogService();
		//通过下面的找到该日志的id
		LogVO lvo=new LogVO();
		lvo.setuName(this.name);
		lvo.setlTitle(this.title);
		LogVO lvo2=new LogVO();
		try {
			lvo2 = logService.findByNameOrTitle(lvo);
		} catch (Exception e) {
		}
		//设置DiscussVO
		DiscussVO dvo=new DiscussVO();
		dvo.setdContent(this.discusscontent);
		dvo.setdDiscusstime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		HttpSession session=ServletActionContext.getRequest().getSession();
		dvo.setlDiscussname((String)session.getAttribute("UserName"));
		dvo.setuName(this.name);
		dvo.setlId(lvo2.getlId());
		//存入到评论表中
		boolean b=logService.add2(dvo);
		if(b){
			System.out.println("在这");
			ServletActionContext.getRequest().setAttribute("uname", this.name);
			ServletActionContext.getRequest().setAttribute("title", this.title);
			return doLogshow();
		}else{
			ServletActionContext.getRequest().setAttribute("uname", this.name);
			ServletActionContext.getRequest().setAttribute("title", this.title);
			return doLogshow();
		}
	}
	/**
	 * 编辑
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public String doLogupdate() throws ServletException, IOException{
		//根据type进行操作
		String type=this.type;
		String uname=this.uname;
		String title=this.title;
		//删除日志以及对应的评论记录
		if(type.equals("delete")){
			//不是本人的日志就不能乱删别人的！
			HttpSession session=ServletActionContext.getRequest().getSession();
			
			if(this.uname.equals(((String)session.getAttribute(Const.LOGINUNAME)))){
				//先根据标题找到日志id，然后根据id进行删除，并把评论表中的记录删除（需要id）
				LogVO vo=new LogVO();
				vo.setuName(uname);
				vo.setlTitle(title);
				boolean b1=false;//查找成功的标志
				boolean b2=false;//删除成功的标志
				LogVO vo2=new LogVO();
				try {
					vo2=logdao.findByNameOrTitle(vo);b1=true;
				} catch (Exception e) {
				}
				if(b1==true){
					try {
						logdao.delete(vo2);//删除日志记录
						b2=true;
					} catch (Exception e) {
					}
				}
				if(b2==true){
					//下面删除评论记录
					DiscussVO dvo=new DiscussVO();
					dvo.setuName(vo2.getuName());
					dvo.setlId(vo2.getlId());
					DiscussDAO ddao=new DiscussDAO();
					try {
						ddao.delete(dvo);
					} catch (Exception e) {
					}
				}
				return doLoglist();
			}else{
				System.out.println("这不是你的日记，不能乱删哦！");
				ServletActionContext.getRequest().setAttribute("uname", uname);
				ServletActionContext.getRequest().setAttribute("title",title);
				return doLogshow();
			}
			
		}
		//修改日志
		if(type.equals("edit")){
			//找到全部信息
			LogVO vo=new LogVO();
			vo.setuName(uname);
			vo.setlTitle(title);
			LogVO vo2=new LogVO();
			try {
				vo2=logdao.findByNameOrTitle(vo);
			} catch (Exception e) {e.printStackTrace();
			}
			ServletActionContext.getRequest().setAttribute("edit_info", vo2);
			ServletActionContext.getRequest().setAttribute("old", "old");//设置一个标志，用来重新插入数据的，把原来的删除好重新插入，不然会新增
			return "log_write";
		}
		//删除指定的某一条日志评论
		if(type.equals("discussdelet")){
			//不是本人的日志就不能乱删别人的！
			HttpSession session=ServletActionContext.getRequest().getSession();
			if(this.lname.equals((String)session.getAttribute(Const.LOGINUNAME))){
				DiscussVO vo=new DiscussVO();
				vo.setuName(this.lname);
				vo.setlDiscussname(this.dname);
				vo.setdDiscusstime(this.dtime);
				try {
					discussdao.delete2(vo);
					ServletActionContext.getRequest().setAttribute("uname", this.lname);
					ServletActionContext.getRequest().setAttribute("title", this.dtitle);
					return doLogshow();
				}catch (Exception e) {
					System.out.println("删除日志评论失败");
				}
			}else{
				System.out.println("这不是你的日记，不能乱删哦！");
				ServletActionContext.getRequest().setAttribute("uname", this.lname);
				ServletActionContext.getRequest().setAttribute("title", this.dtitle);
				return doLogshow();
			}
		}
		return "";
	}
	/**
	 * 日志列表
	 */
	public String doLoglist(){
		//获取参数
		HttpSession session=ServletActionContext.getRequest().getSession();
		int p = 1;
		try{ 
			p = Integer.valueOf(ServletActionContext.getRequest().getParameter("p"));
		}catch (Exception e) {}
		int m = 4;
		
		String key = this.key;
		
		//执行业务逻辑
		ServletActionContext.getRequest().setAttribute("p", p);
		ServletActionContext.getRequest().setAttribute("m", m);
		ServletActionContext.getRequest().setAttribute("key", key);
		try{
			ServletActionContext.getRequest().setAttribute("page", logService.page("select * from logg where u_name='"+session.getAttribute("UserName")+"' order by l_id desc",p, m, key));
		}catch (Exception e) {
			System.out.println("没有记录");
		}
		
		//页面跳转
		return "log_mine";
	}
	/**
	 * 搜索
	 */
	public String doLogsearch(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String search="";
		try {
			search=this.searchfriend;
		} catch (Exception e) {search="";
		}
		if(!search.equals("")){
			try {
				ArrayList list=(ArrayList) logdao.findAll3((String)session.getAttribute(Const.LOGINUNAME),search);
				ServletActionContext.getRequest().setAttribute("searchInfo", search);
				ServletActionContext.getRequest().setAttribute("list", list);
				return "log_friends";
			} catch (Exception e) {System.out.println("查找失败");e.printStackTrace();
			}
		}else{
			try {
				ArrayList list=(ArrayList) logdao.findAll2((String)session.getAttribute(Const.LOGINUNAME));
				ServletActionContext.getRequest().setAttribute("searchInfo", search);
				ServletActionContext.getRequest().setAttribute("list", list);
				return "log_friends";
			} catch (Exception e) {System.out.println("查找失败");e.printStackTrace();
			}
		}
		return "";
	}
	/**
	 * 朋友日志
	 */
	public String doLogfriends(){
		System.out.println("朋友日志");
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);
		try {
			ArrayList list=(ArrayList) logdao.findAll2(uname);
			ServletActionContext.getRequest().setAttribute("list", list);
			return "log_friends";
		} catch (Exception e) {
			System.out.println("查找失败！检查一下");
		}
		return "";
	}
	/**
	 * 日志动态
	 */
	public String doUpdate_log(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String username=(String) session.getAttribute(Const.LOGINUNAME);//用户的名字，到时候改
		
		ArrayList list=null;
		try {
			list=(ArrayList) uplog.findAll1(username);
			ServletActionContext.getRequest().setAttribute("list", list);
			//System.out.println("log进来了");
			return "update_log";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 显示日志
	 */
	public String doLogshow(){
		//通过下面的查找指定的LogVO
		HttpSession session=ServletActionContext.getRequest().getSession();
		//String uname=(String) session.getAttribute("UserName");
		String uname="";
		String title="";
		if(this.uname!=null){
			System.out.println("aaa"+this.uname);
			uname=this.uname;
		}else{
			uname=(String) ServletActionContext.getRequest().getAttribute("uname");
		}
		if(this.title!=null){
			System.out.println("bbb:"+this.title);
			title=this.title;
		}else{
			title=(String) ServletActionContext.getRequest().getAttribute("title");
		}
		LogVO vo=new LogVO();
		System.out.println("uname:"+uname);
		vo.setuName(uname);
		vo.setlTitle(title);
		LogService logService=new LogService();
		LogVO vo2=new LogVO();
		try {
			vo2=logService.findByNameOrTitle(vo);
		} catch (Exception e) {
		}
		System.out.println(vo2.getuName());
		//通过下面查找指定的日志评论,因为有可能有多条记录，所以用集合来装
		//System.out.println(vo2.getuName()+" "+vo2.getlId());
		DiscussVO dvo=new DiscussVO();
		dvo.setuName(vo2.getuName());
		dvo.setlId(vo2.getlId());
		
		DiscussVO dvo2=new DiscussVO();
		LogService ls=new LogService();
		List list=null;
		try {
			list=ls.findByNameOrId(dvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//保存数据
		ServletActionContext.getRequest().setAttribute("discusslist", list);
		ServletActionContext.getRequest().setAttribute("vo", vo2);
		return "log_show";
	}
}
