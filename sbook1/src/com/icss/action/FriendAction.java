package com.icss.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.icss.Const;
import com.icss.service.FriendsService;
import com.icss.service.UsersService;
import com.icss.vo.FriendsVO;
import com.icss.vo.UsersVO;
import com.opensymphony.xwork2.ActionSupport;
@Results({
	@Result(name="friends_list",location="/friends/friends_list.jsp"),
	@Result(name="friends_search",location="/friends/friends_search.jsp"),
	@Result(name="friends_add_result",location="/friends/friends_add_result.jsp"),
	@Result(name="friends_recommend",location="/friends/friends_recommend.jsp")
})
public class FriendAction extends ActionSupport{
	private String fname;
	private String ureadingschool;
	private String q;
	private int page=0;//当前页，每页默认为8
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
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
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	private String ureadschool;
	private String usex;
	private FriendsService friendsService=new FriendsService(); 
	private UsersService usersService=new UsersService();
	public String execute(){
		return null;
	}
	/**
	 * 关键字下拉框获取注册用户（这里就不进行优化了）
	 * @throws UnsupportedEncodingException 
	 */
	public void doGetAllUser() throws UnsupportedEncodingException{
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		System.out.println("q:"+q);
		try {
			List<UsersVO> listf;
			if(q==null){
				listf=usersService.findAll();
			}else{
				listf=usersService.findAllByQ(q);
			}
			ServletActionContext.getResponse().getWriter().print(JSONArray.fromObject(listf));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 推荐
	 */
	public String doFriends_recommend(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);
		UsersVO vo22=new UsersVO();
		try {
			vo22=friendsService.find12(uname);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String ureadingschool = vo22.getuReadingschool();
		String ureadsschool=vo22.getuReadschool();
		System.out.println(ureadingschool);
		try {
			ArrayList<UsersVO> list=(ArrayList<UsersVO>) friendsService.find6_1(ureadingschool,ureadsschool, uname);
			ServletActionContext.getRequest().setAttribute("list", list);
			return "friends_recommend";
		} catch (Exception e) {
			System.out.println("没有推荐人选");
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 添加
	 */
	public String doFriends_add(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);
		String fname=this.fname;
		FriendsVO vo1 =new FriendsVO();
		vo1.setuName(uname);
		vo1.setfName(fname);
		FriendsVO vo2 = new FriendsVO();
		vo2.setuName(fname);
		vo2.setfName(uname);
		//
		boolean b = true;
		try {
			ArrayList<FriendsVO> list=(ArrayList<FriendsVO>) friendsService.findAll2(uname);
			for(FriendsVO vo:list){
				System.out.println(vo.getfName());
				if(vo.getfName().equals(fname)){
					b=false;
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(b){
				ServletActionContext.getRequest().setAttribute("fname", fname);//保存所搜索的就读学校
				ServletActionContext.getRequest().setAttribute("ureadingschool", ureadingschool);//当添加完成后，任然可以进行添加，这里只按照就读学校，其他功能没实现
				try{
				if(!fname.equals(uname)){
					friendsService.add(vo1);
					friendsService.add(vo2);
					ServletActionContext.getRequest().setAttribute("result", "好友添加成功！");
				}else{
					ServletActionContext.getRequest().setAttribute("result", "不能添加自己为好友！");
				}
				return "friends_add_result";
			}catch(Exception e){
				System.out.println("添加失败！");
				e.printStackTrace();
			}
		}else{
			ServletActionContext.getRequest().setAttribute("result", "你们已经是好友了！");
			return "friends_add_result";
		}
		return "";
	}
	/**
	 * 查找好友
	 */
	public String doFriends_search(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);//session
	    String fname="";
	    String ureadingschool="";
	    String ureadschool="";
	    String usex="不限";
	    if(this.fname!=null){
	    	fname=this.fname;
	    }
	    if(this.ureadingschool!=null){
	    	ureadingschool=this.ureadingschool;
	    }
	    if(this.ureadschool!=null){
	    	ureadschool=this.ureadschool;
	    }
	    if(this.usex!=null){
	    	usex=this.usex;
	    }
	    System.out.println("usex="+usex+" ureadingschool="+ureadingschool);
	    //当全都不填
	    if("".equals(ureadingschool)&&"".equals(ureadschool)&&"不限".equals(usex)&&"".equals(fname)){
	    	try {
	    		int total=friendsService.count();
	    		int pageNum=(total-1)/8+1;
	    		if(page>=pageNum){
	    			page=pageNum-1;
	    		}
	    		System.out.println("page="+page);
				ArrayList<UsersVO> list=(ArrayList) friendsService.find3_1(uname,page,total);
				ServletActionContext.getRequest().setAttribute("list", list);
				//进行页面显示page的优化
				if(page<0){
					page=0;
				}
				return "friends_search";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //当写了用户名，进行这个操作
	    if(!"".equals(fname)&&"".equals(ureadingschool)&&"".equals(ureadschool)&&"不限".equals(usex)){
	    	try {
				ArrayList<UsersVO> list=(ArrayList) friendsService.find4(fname);
				ServletActionContext.getRequest().setAttribute("list", list);
				return "friends_search";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  //当写了用户名，就读学校，进行这个操作
	    if(!"".equals(fname)&&!"".equals(ureadingschool)&&"".equals(ureadschool)&&"不限".equals(usex)){
	    	System.out.println("aasdasdsadasdasdasdasd");
	    	try {
				ArrayList<UsersVO> list=(ArrayList) friendsService.find4_t(fname,ureadingschool);
				ServletActionContext.getRequest().setAttribute("list", list);
				return "friends_search";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  //当写了用户名，曾读学校，进行这个操作
	    if(!"".equals(fname)&&"".equals(ureadingschool)&&!"".equals(ureadschool)&&"不限".equals(usex)){
	    	System.out.println("aasdasdsadasdasdasdasd");
	    	try {
				ArrayList<UsersVO> list=(ArrayList) friendsService.find4_t_t(fname,ureadschool);
				ServletActionContext.getRequest().setAttribute("list", list);
				return "friends_search";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //这是填写了性别、就读学校、曾读学校 或用户名
	    if(!"".equals(ureadingschool)&&!"".equals(ureadschool)&&!"不限".equals(usex)){
	    	try {
				ArrayList<UsersVO> list=(ArrayList) friendsService.find5(usex, ureadingschool, ureadschool);
				ServletActionContext.getRequest().setAttribute("list", list);
				return "friends_search";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  //这是填写了性别、就读学校、曾读学校 和用户名
	    if(!"".equals(ureadingschool)&&!"".equals(ureadschool)&&!"不限".equals(usex)&&!"".equals(fname)){
	    	try {
				ArrayList<UsersVO> list=(ArrayList) friendsService.find5_t(usex, ureadingschool, ureadschool,fname);
				ServletActionContext.getRequest().setAttribute("list", list);
				return "friends_search";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  //这是填写了就读学校、曾读学校 和用户名
	    if(!"".equals(ureadingschool)&&!"".equals(ureadschool)&&"不限".equals(usex)&&!"".equals(fname)){
	    	try {
				ArrayList<UsersVO> list=(ArrayList) friendsService.find5_t_t(ureadingschool, ureadschool,fname);
				ServletActionContext.getRequest().setAttribute("list", list);
				return "friends_search";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //这是指填写了指定的就读学校
	    if(!"".equals(ureadingschool)&&"".equals(ureadschool)&&"不限".equals(usex)){
	    	try {
	    		System.out.println("这是指填写了指定的就读学校:"+ureadingschool);
				ArrayList<UsersVO> list=(ArrayList) friendsService.find6(ureadingschool);
				ServletActionContext.getRequest().setAttribute("ureadingschool", ureadingschool);
				ServletActionContext.getRequest().setAttribute("list", list);
				return "friends_search";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //这是指填写了指定的曾读学校
	    if("".equals(ureadingschool)&&!"".equals(ureadschool)&&"不限".equals(usex)){
	    	try {
				ArrayList<UsersVO> list=(ArrayList) friendsService.find7(ureadschool);
				ServletActionContext.getRequest().setAttribute("ureadschool", ureadschool);
				ServletActionContext.getRequest().setAttribute("list", list);
				return "friends_search";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //这是指填写了指定的性别
	    if("".equals(ureadingschool)&&"".equals(ureadschool)&&!"不限".equals(usex)){
	    	try {
				ArrayList<UsersVO> list=(ArrayList) friendsService.find8(usex);
				ServletActionContext.getRequest().setAttribute("list", list);
				return "friends_search";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //这是指填写了指定的就读和曾读
	    if(!"".equals(ureadingschool)&&!"".equals(ureadschool)&&"不限".equals(usex)){
	    	try {
				ArrayList<UsersVO> list=(ArrayList) friendsService.find9(ureadingschool, ureadschool);
				ServletActionContext.getRequest().setAttribute("list", list);
				return "friends_search";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //这是指填写了指定的就读和性别
	    if(!"".equals(ureadingschool)&&"".equals(ureadschool)&&!"不限".equals(usex)){
	    	try {
				ArrayList<UsersVO> list=(ArrayList) friendsService.find10(ureadingschool, usex);
				ServletActionContext.getRequest().setAttribute("list", list);
				return "friends_search";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //这是指填写了指定的曾读和性别
	    if("".equals(ureadingschool)&&!"".equals(ureadschool)&&!"不限".equals(usex)){
	    	try {
				ArrayList<UsersVO> list=(ArrayList) friendsService.find11(ureadschool, usex);
				ServletActionContext.getRequest().setAttribute("list", list);
				return "friends_search";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		return "";
	}
	/**
	 * 删除
	 */
	public String doFriends_delete(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);//默认为puguole,以后通过session得到
		String fname=this.fname;
		FriendsVO vo=new FriendsVO();
		vo.setfName(fname);
		vo.setuName(uname);
		FriendsVO vo2=new FriendsVO();
		vo2.setfName(uname);
		vo2.setuName(fname);
		try {
			friendsService.delete(vo);
			friendsService.delete(vo2);
			return doFriends_list();
		} catch (Exception e) {
			System.out.println("删除失败");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 好友列表
	 * @return
	 */
	public String doFriends_list(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);//默认为puguole,以后通过session得到
		ArrayList list=new ArrayList<FriendsVO>();
		try {
			list=(ArrayList) friendsService.findAll2_2(uname);
			ServletActionContext.getRequest().setAttribute("list", list);
			return "friends_list";
		} catch (Exception e) {
			System.out.println("查找失败！");
			e.printStackTrace();
		}
		return "";
	}
}
