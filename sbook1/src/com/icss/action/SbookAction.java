package com.icss.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.icss.Const;
import com.icss.dao.BookDAO;
import com.icss.service.BookService;
import com.icss.service.FriendsService;
import com.icss.vo.BookVO;
import com.icss.vo.FriendsVO;
import com.opensymphony.xwork2.ActionSupport;
@Results({
	@Result(name="book_mine",location="/book/book_mine.jsp"),
	@Result(name="book_write",location="/book/book_write.jsp"),
	@Result(name="book_show1",location="/book/book_show1.jsp"),
	@Result(name="book_write3",location="/book/book_write3.jsp"),
	@Result(name="book_invite",location="/book/book_invite.jsp"),
	@Result(name="book_write_result",location="/book/book_write_result.jsp"),
})
public class SbookAction extends ActionSupport{
	private BookDAO bookDAO=new BookDAO();
	private BookDAO dao=new BookDAO();
	private BookService bookService=new BookService();
	public String execute(){
		return null;
	}
	
	/**
	 * 跳转book
	 */
	public String doBookgomine(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);
		boolean b=false;
		try {
			//获取有同学录的好友信息
			ArrayList<BookVO> list=(ArrayList<BookVO>) bookService.findAlly(uname);
			int count=bookService.findCountY(uname);
			ServletActionContext.getRequest().setAttribute("county", count);
			ServletActionContext.getRequest().setAttribute("listy", list);
			b=true;
			//request.getRequestDispatcher("book/book_mine.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("没有找到已有好友的同学录");
			e.printStackTrace();
		}
		if(b){
			try {
				//获取没有同学录的好友信息
				ArrayList<FriendsVO> list=(ArrayList<FriendsVO>) bookService.findAlln(uname);
				int count=bookService.findCountN(uname);
				ServletActionContext.getRequest().setAttribute("countn", count);
				ServletActionContext.getRequest().setAttribute("listn", list);
				return "book_mine";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("没有找到未有同学录的好友列表信息");
				e.printStackTrace();
			}
		}
		return null;
	}
	public String doBookgowritestyle(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		FriendsService friendsService=new FriendsService();
		ArrayList<FriendsVO> list=new ArrayList<FriendsVO>();
		try {
			//获取没有同学录的好友信息
			list=(ArrayList<FriendsVO>) bookService.findAlln2((String) session.getAttribute(Const.LOGINUNAME));
		} catch (Exception e) {e.printStackTrace();System.out.println("没有得到好友列表");
		}
		ServletActionContext.getRequest().setAttribute("list", list);
		return "book_write";
	}
	/**
	 * 显示
	 * @return
	 */
	public String doBookshow(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String) session.getAttribute(Const.LOGINUNAME);
		String fname=ServletActionContext.getRequest().getParameter("fname");
		BookVO vo1=new BookVO();
		vo1.setuName(fname);//这里fname应该属于uname
		vo1.setfName(uname);
		try {
			BookVO vo2=bookDAO.findByName(vo1);
			ServletActionContext.getRequest().setAttribute("fname", fname);
			ServletActionContext.getRequest().setAttribute("vo", vo2);
			return "book_show1";
		} catch (Exception e) {
		}
		return "";
	}
	/**
	 * 写
	 * @return
	 */
	public String doBookgowrite(){
		String book_style=ServletActionContext.getRequest().getParameter("book_style");
		String f_name=ServletActionContext.getRequest().getParameter("f_name");
		if(book_style.equals("1")){
			ServletActionContext.getRequest().setAttribute("fname", f_name);//保存下来传过去，在那边用隐藏表单传到下一个servlet中
			return "book_write3";
		}
		return "";
	}
	/**
	 * 邀请好友填写
	 * @return
	 */
	public String doBookgoinvite(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		FriendsService friendsService=new FriendsService();
		ArrayList<FriendsVO> list=new ArrayList<FriendsVO>();
		try {
			//获取没有同学录的好友信息
			list=(ArrayList<FriendsVO>) bookService.findAlln2((String) session.getAttribute(Const.LOGINUNAME));
		} catch (Exception e) {e.printStackTrace();System.out.println("没有得到好友列表");
		}
		ServletActionContext.getRequest().setAttribute("list", list);
		return "book_invite";
	}
	/**
	 * 删除
	 */
	public String doLookdelete(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uname=(String)session.getAttribute(Const.LOGINUNAME);
		String fname=ServletActionContext.getRequest().getParameter("fname");
		try {
			bookService.deleteByName(uname, fname);
			doBookgomine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("删除失败");
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 写同学录
	 */
	public String doBookwrite(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String uName=(String) session.getAttribute(Const.LOGINUNAME);
		String fName=ServletActionContext.getRequest().getParameter("fname");
		String uBigname=ServletActionContext.getRequest().getParameter("uBigname");
		String bNickname=ServletActionContext.getRequest().getParameter("bNickname");
		String bBirth=ServletActionContext.getRequest().getParameter("bBirth");
		String bQq=ServletActionContext.getRequest().getParameter("bQq");
		String bTelphone1=ServletActionContext.getRequest().getParameter("bTelphone1");
		String bTelphone2=ServletActionContext.getRequest().getParameter("bTelphone2");
		String bAddress=ServletActionContext.getRequest().getParameter("bAddress");
		String bHobby=ServletActionContext.getRequest().getParameter("bHobby");
		String bConstellation=ServletActionContext.getRequest().getParameter("bConstellation");
		String bLovepeople=ServletActionContext.getRequest().getParameter("bLovepeople");
		String bLovefood=ServletActionContext.getRequest().getParameter("bLovefood");
		String bLovesay=ServletActionContext.getRequest().getParameter("bLovesay");
		String bLovefruit=ServletActionContext.getRequest().getParameter("bLovefruit");
		String bLovecountry=ServletActionContext.getRequest().getParameter("bLovecountry");
		String bLoveteacher=ServletActionContext.getRequest().getParameter("bLoveteacher");
		String bMotto=ServletActionContext.getRequest().getParameter("bMotto");
		String bLeaveword=ServletActionContext.getRequest().getParameter("bLeaveword");
		BookVO vo=new BookVO();
		vo.setbAddress(bAddress);
		vo.setbBirth(bBirth);
		vo.setbConstellation(bConstellation);
		vo.setbHobby(bHobby);
		vo.setbLeaveword(bLeaveword);
		vo.setbLovecountry(bLovecountry);
		vo.setbLovefood(bLovefood);
		vo.setbLovefruit(bLovefruit);
		vo.setbLovepeople(bLovepeople);
		vo.setbLovesay(bLovesay);
		vo.setbLoveteacher(bLoveteacher);
		vo.setbMotto(bMotto);
		vo.setbNickname(bNickname);
		vo.setbQq(bQq);
		vo.setbTelphone1(bTelphone1);
		vo.setbTelphone2(bTelphone2);
		vo.setfName(fName);
		vo.setuBigname(uBigname);
		vo.setuName(uName);
		try {
			dao.add(vo);
			ServletActionContext.getRequest().setAttribute("result", "同学录填写成功！");
			return "book_write_result";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ServletActionContext.getRequest().setAttribute("result", "服务器处于高峰期，同学录填写失败！");
			e.printStackTrace();
		}
		return "";
	}
}
