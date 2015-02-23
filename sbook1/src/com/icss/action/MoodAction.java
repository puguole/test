package com.icss.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.icss.Const;
import com.icss.dao.moodDAO;
import com.icss.service.moodService;
import com.icss.service.update_moodService;
import com.icss.vo.agreecountVO;
import com.icss.vo.moodVO;
import com.opensymphony.xwork2.ActionSupport;
@Results({
	@Result(name="update_mood",location="/update/update_mood.jsp"),
	@Result(name="mood",location="/mood/mood.jsp"),
	@Result(name="mood_info_manager",location="/admin/mood_info_manager.jsp")
})
public class MoodAction extends ActionSupport{
	private moodDAO moodDAO=new moodDAO();
	private String mid;
	private String content;
	private String user;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	private update_moodService upmood=new update_moodService();
	private moodService mservice=new moodService();
	public String execute(){
		return null;
	}
	/**
	 * 后台-显示
	 */
	public String doAdminmoodlist(){
		try {
			ArrayList<moodVO> list= (ArrayList<moodVO>) moodDAO.findAll();
			ServletActionContext.getRequest().setAttribute("list", list);
			return "mood_info_manager";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("没有找到数据");
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 删除
	 */
	public String doMooddelete(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		moodService mood=new moodService();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);//到时候改动
		int mid=Integer.parseInt(this.mid);
		//System.out.println(mid);
		try {
			mood.delete2(mid);
			return doMoodget();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("删除失败！");
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 添加心情
	 */
	public String doMoodadd(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		moodService mood=new moodService();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);//到时候改动
		String content=this.content;
		String time=mood.getDate();
		String uname2=uname;
		int magreecount=0;
		//System.out.println(content+" \n"+time);
		if(content.equals("")){
			System.out.println("心情发表不能为空");
			return doMoodget();
		}else{
		try {
			mood.add(uname2, content, time, magreecount);
			//System.out.println("发表心情成功");
			//response.sendRedirect("mood");
			return doMoodget();
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("发表心情失败");
		}
		}
		return "";
	}
	/**
	 * 获取最近动态
	 * @return
	 */
	public String doUpdate_moodGet(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);//到时候改动
		//数据库数据的读取
		ArrayList list=null;
		try {
			list=(ArrayList) upmood.findAll2(uname);
			ServletActionContext.getRequest().setAttribute("list", list);
			return "update_mood";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取动态
	 * @return
	 */
	public String doMoodget(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);//到时候改动
		String countname="小二";//赞的用户名到时候改
		//数据库数据的读取
		ArrayList list=null;
		try {
			list=(ArrayList) mservice.findAll2(uname);
			ServletActionContext.getRequest().setAttribute("list", list);
			return "mood";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 心情 点赞
	 * @return
	 */
	public String doUpdate_mood(){
		update_moodService  upmood=new update_moodService();
		
		HttpSession session=ServletActionContext.getRequest().getSession();
//		//String user=request.getParameter("mname");//用户名，到时候改
		String countname=this.user;//赞的用户名到时候改
		
		System.out.println("countname="+countname);
		int mid=Integer.parseInt(this.mid);
		try {
			//List<agreecountVO> existcount=upmood.judge(mid);
			List<agreecountVO> existcount = upmood.judge(mid);
			
			//确定是否是同一个人进行点赞操作
			boolean flage=true;
			for(agreecountVO vo:existcount){
				if(vo.getCount_name().equals(countname)){
					//System.out.println(vo.getCount_name());
					flage=false;
				}
			}
			if(!flage){
				System.out.println("进入了点过赞的");
				//System.out.println("已经点赞过!");
				return doUpdate_moodGet();
			}
			else if(flage){
				System.out.println("进入了为点过赞的");
				try{
					upmood.update1(mid);
					upmood.update2(mid, countname);
					System.out.println("赞数增加成功！");
					return doUpdate_moodGet();
				}catch(Exception e){
					e.printStackTrace();
////					System.out.println("赞数增加失败！");
				}
				}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "";
	}
}
