package com.icss.service;

import java.util.List;

import com.icss.dao.UsersDAO;
import com.icss.vo.UsersVO;

public class UsersService {
	private UsersDAO usersDAO=new UsersDAO();
	public void add(UsersVO... po) throws Exception {
		for(UsersVO vo:po){
			usersDAO.add(po);
		}
	}
	//检查登录是否正确
	public boolean checkLogin(String uname,String upassword){
		boolean b=false;
		UsersVO vo=new UsersVO();
		vo.setuName(uname);
		UsersVO vo2=null;
		UsersDAO udao=new UsersDAO();
		try {
			vo2=udao.findByName(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return b;
		}
		if(vo2.getuPassword().equals(upassword)){
			b=true;
		}
		return b;
	}
	public UsersVO findByName(UsersVO po) throws Exception {
		// TODO Auto-generated method stub
		return usersDAO.findByName(po);
	}
	public List<UsersVO> findAll() throws Exception {                                                                                                                
		// TODO Auto-generated method stub
		return usersDAO.findAll();
	}
	public void modify_xf(UsersVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(UsersVO vo:po){
			
			usersDAO.modify_xf(po);
		}
	}
	
	public void delete(UsersVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(UsersVO vo:po){
		  usersDAO.delete(po);
		}
	}
	
	/**
	 * 鏍规嵁鐢ㄦ埛鍚嶆煡鎵�
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> findByName_xf(String uname) throws Exception {
		// TODO Auto-generated method stub
		return usersDAO.findByName_xf(uname);
	}
	/**
	 *关键字模糊匹配
	 * @param q
	 * @return
	 * @throws Exception 
	 */
	public List<UsersVO> findAllByQ(String q) throws Exception {
		// TODO Auto-generated method stub
		return usersDAO.findAllByQ(q);
	}
	/**
	 * 就读学校模糊匹配
	 * @return
	 * @throws Exception 
	 */
	public List<UsersVO> findAllC(String c) throws Exception {
		// TODO Auto-generated method stub
		return usersDAO.findAllC(c);
	}
}
