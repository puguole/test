package com.icss.service;

import java.util.ArrayList;
import java.util.List;

import com.icss.dao.FriendsDAO;
import com.icss.vo.FriendsVO;
import com.icss.vo.UsersVO;

public class FriendsService {
	private FriendsDAO dao=new FriendsDAO();
	/**
	 * 查找自己的好友
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<FriendsVO> findAll2(String uname) throws Exception {
		// TODO Auto-generated method stub
		return dao.findAll2(uname);
	}
	/**
	 * 查找自己的好友
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> findAll2_2(String uname) throws Exception {
		// TODO Auto-generated method stub
		return dao.findAll2_2(uname);
	}
	/**
	 * 查找不属于自己的用户
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> findAll3(String uname,String readingschool,String readschool,String sex) throws Exception {
		return dao.findAll3(uname,readingschool,readschool,sex);
	}
	/**
	 * 查找好友-全都不填（不显示自己）
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find3_1(String uname,int page,int total) throws Exception {
		return dao.find3_1(uname,page,total);
	}
	/**
	 * 查找好友-指定的用户名
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find4(String fname) throws Exception {
		return dao.find4(fname);
	}
	/**
	 * 查找好友-指定的性别、就读学校、曾读学校
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find5(String usex,String ureadingschool,String ureadschool) throws Exception {
		return dao.find5(usex, ureadingschool, ureadschool);
	}
	
	/**
	 * 查找好友-指定的性别、就读学校、曾读学校
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find6(String ureadingschool) throws Exception {
		return dao.find6(ureadingschool);
	}
	/**
	 * 查找好友-指定的就读学校,不包括自己
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find6_1(String ureadingschool,String ureadsschool,String uname) throws Exception {
		return dao.find6_1(ureadingschool,ureadsschool, uname);
	}
	/**
	 * 查找好友-指定的曾读学校
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find7(String ureadschool) throws Exception {
		return dao.find7(ureadschool);
	}
	
	/**
	 * 查找好友-指定的性别
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find8(String usex) throws Exception {
		return dao.find8(usex);
	}
	/**
	 * 查找好友-指定的就读和曾读
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find9(String ureadingschool,String ureadschool) throws Exception {
		return dao.find9(ureadingschool, ureadschool);
	}
	/**
	 * 查找好友-指定的就读和性别
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find10(String ureadingschool,String usex) throws Exception {
		return dao.find10(ureadingschool, usex);
	}
	
	/**
	 * 查找好友-指定的曾读和性别
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find11(String ureadschool,String usex) throws Exception {
		return dao.find11(ureadschool, usex);
	}
	/**
	 * 按用户名查找指定的用户信息
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public UsersVO find12(String uname) throws Exception {
		return dao.find12(uname);
	}
	public List<FriendsVO> findAll() throws Exception {
		return dao.findAll();
	}
	public void delete(FriendsVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(FriendsVO vo:po){
			dao.delete(po);
		}
	}
	public void add(FriendsVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(FriendsVO vo:po){
			dao.add(po);
		}
	}
	public List<UsersVO> find5_t(String usex, String ureadingschool,
			String ureadschool, String fname) throws Exception {
		// TODO Auto-generated method stub
		return dao.find5_t(usex,ureadingschool,ureadschool,fname);
	}
	public List<UsersVO> find5_t_t(String ureadingschool,
			String ureadschool, String fname) throws Exception {
		// TODO Auto-generated method stub
		return dao.find5_t_t(ureadingschool,ureadschool,fname);
	}
	public List<UsersVO> find4_t(String fname,String ureadingschool) throws Exception {
		// TODO Auto-generated method stub
		return dao.find4_t(fname,ureadingschool);
	}
	public List<UsersVO> find4_t_t(String fname,String ureadschool) throws Exception {
		// TODO Auto-generated method stub
		return dao.find4_t_t(fname,ureadschool);
	}
	public int count() throws Exception{
		return dao.count();
	}
}
