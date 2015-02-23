package com.icss.service;

import java.util.List;

import com.icss.dao.BookDAO;
import com.icss.vo.BookVO;
import com.icss.vo.FriendsVO;

public class BookService {
	private BookDAO bookDAO=new BookDAO();
	/**
	 * 用来查询已有的好友的同学录
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<BookVO> findAlly(String uname) throws Exception {
		// TODO Auto-generated method stub
		return bookDAO.findAlly(uname);
	}
	/**
	 * 用来查询已有的好友的同学录
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<FriendsVO> findAlln(String uname) throws Exception {
		// TODO Auto-generated method stub
		return bookDAO.findAlln(uname);
	}
	public List<FriendsVO> findAlln2(String uname) throws Exception {
		// TODO Auto-generated method stub
		return bookDAO.findAlln2(uname);
	}
	/**
	 * 查找已有同学录的好友的个数
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public int findCountY(String uname) throws Exception{
		return bookDAO.findCountY(uname);
	}
	/**
	 * 查找没有同学录的好友的个数
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public int findCountN(String uname) throws Exception{
		return bookDAO.findCountN(uname);
	}
	public BookVO findByName(BookVO po) throws Exception {
		// TODO Auto-generated method stub
		return bookDAO.findByName(po);
	}
	public void add(BookVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(BookVO vo:po){
			bookDAO.add(po);
		}
	}
	public void deleteByName(String uname,String fname) throws Exception {
		bookDAO.deleteByName(uname, fname);
	}
}
