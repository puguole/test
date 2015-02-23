package com.icss.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.icss.commons.DbUtils;
import com.icss.vo.FriendsVO;
import com.icss.vo.UsersVO;

public class FriendsDAO extends DAOSupport<FriendsVO>{
    
	private DbUtils db = DbUtils.newInstance();
	public List<FriendsVO> findAll() throws Exception {
		return db.list("select * from friend",new FriendsVO());
	}
	/**
	 * 查找自己的好友
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<FriendsVO> findAll2(String uname) throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from friend where u_name=?", new FriendsVO(),uname);
	}
	/**
	 * 查找自己的好友2,因为要传递座右铭，所以返回的应该是一个UsersVO
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> findAll2_2(String uname) throws Exception {
		return db.list("select * from users where u_name in(select f_name from friend where u_name=?)", new UsersVO(),uname);
	}
	
	/**
	 * 查找不属于自己的用户
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> findAll3(String uname,String readingschool,String readschool,String sex) throws Exception {
		return db.list("select * from users where u_name not in(select f_name from friend where u_name='"+uname+"') and u_name!='"+uname+"' and u_sex='"+sex+"' and u_readingschool='"+readingschool+"' and u_readschool='"+readschool+"'", new UsersVO());
	}
	
	/**
	 * 查找好友-全都不填（不显示自己）
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find3_1(String uname,int page,int total) throws Exception {
		int pageNum=(total-1)/8+1;//计算总共有多少页 27
		if(page>=pageNum){
			page=pageNum-1;
		}
		int start=page*8; //(0,8) (7,8)
		if(start<0){
			start=0;
		}
		return db.list("select * from users where u_name!='"+uname+"' limit "+start+",8", new UsersVO());
	}
	/**
	 * 查找好友-指定的用户名
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find4(String fname) throws Exception {
		fname="%"+fname+"%";
		return db.list("select * from users where u_name like '"+fname+"'", new UsersVO());
	}
	/**
	 * 查找好友-指定的性别、就读学校、曾读学校
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find5(String usex,String ureadingschool,String ureadschool) throws Exception {
		ureadingschool="%"+ureadingschool+"%";
		ureadschool="%"+ureadschool+"%";
		return db.list("select * from users where u_sex='"+usex+"' and u_readingschool like '"+ureadingschool+"' and u_readschool like '"+ureadschool+"'", new UsersVO());
	}
	
	/**
	 * 查找好友-指定的就读学校
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find6(String ureadingschool) throws Exception {
		ureadingschool="%"+ureadingschool+"%";
		return db.list("select * from users where u_readingschool like '"+ureadingschool+"'", new UsersVO());
	}
	/**
	 * 查找好友-指定的就读学校,不包括自己
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find6_1(String ureadingschool,String ureadsschool,String uname) throws Exception {
		ureadingschool="%"+ureadingschool+"%";
		return db.list("select * from users where u_readingschool = '"+ureadingschool+"' or u_readschool= '"+ureadsschool+"' and u_name!='"+uname+"' and u_name not in(select f_name from friend where u_name='"+uname+"')", new UsersVO());
	}
	/**
	 * 查找好友-指定的曾读学校
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find7(String ureadschool) throws Exception {
		ureadschool="%"+ureadschool+"%";
		return db.list("select * from users where u_readschool like '"+ureadschool+"'", new UsersVO());
	}
	
	/**
	 * 查找好友-指定的性别
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find8(String usex) throws Exception {
		return db.list("select * from users where u_sex='"+usex+"'", new UsersVO());
	}
	
	/**
	 * 查找好友-指定的就读和曾读
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find9(String ureadingschool,String ureadschool) throws Exception {
		ureadingschool="%"+ureadingschool+"%";
		ureadschool="%"+ureadschool+"%";
		return db.list("select * from users where u_readingschool like '"+ureadingschool+"' and u_readschool like '"+ureadschool+"'", new UsersVO());
	}
	
	/**
	 * 查找好友-指定的就读和性别
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find10(String ureadingschool,String usex) throws Exception {
		ureadingschool="%"+ureadingschool+"%";
		return db.list("select * from users where u_readingschool like '"+ureadingschool+"' and u_sex='"+usex+"'", new UsersVO());
	}
	
	/**
	 * 查找好友-指定的曾读和性别
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> find11(String ureadschool,String usex) throws Exception {
		ureadschool="%"+ureadschool+"%";
		return db.list("select * from users where u_readschool like '"+ureadschool+"' and u_sex='"+usex+"'", new UsersVO());
	}
	/**
	 * 按用户名查找指定的用户信息
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public UsersVO find12(String uname) throws Exception {
		return db.get("select * from users where u_name='"+uname+"'",new UsersVO());
	}
	public FriendsVO findById(FriendsVO po) throws Exception {
		
		return null;
	}

	@Override
	public FriendsVO findByName(FriendsVO po) throws Exception {
		return (FriendsVO) db.list("select * from friend where u_name=?", po.getuName());

	}


	@Override
	public void add(FriendsVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(FriendsVO vo:po){
			db.execute("insert into friend(u_name,f_name) values(?,?)",vo.getuName(),vo.getfName());
		}
	}


	@Override
	public void modify(FriendsVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(FriendsVO vo:po){
			db.execute("update friend set u_name=? f_name=?", vo.getuName(),vo.getfName() );
		}
	}


	@Override
	public void delete(FriendsVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(FriendsVO vo:po){
			db.execute("delete from friend where u_name=? and f_name=?" ,vo.getuName(),vo.getfName());
		}
	}
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 删除自己的全部好友信息
	 * @param uname
	 * @throws Exception
	 */
	public void deleteAll2(String uname) throws Exception {
		// TODO Auto-generated method stub
		db.execute("delete from friend where u_name='"+uname+"'");
	}
	/**
	 * 都填了
	 * @param usex
	 * @param ureadingschool
	 * @param ureadschool
	 * @param fname
	 * @return
	 * @throws Exception 
	 */
	public List<UsersVO> find5_t(String usex, String ureadingschool,
			String ureadschool, String fname) throws Exception {
		// TODO Auto-generated method stub
		ureadingschool="%"+ureadingschool+"%";
		ureadschool="%"+ureadschool+"%";
		fname="%"+fname+"%";
		return db.list("select * from users where u_readschool like '"+ureadschool+"' and u_sex='"+usex+"' and u_readingschool like '"+ureadingschool+"' and u_name like '"+fname+"'", new UsersVO());
	}
	/**
	 * 都填了，除了性别
	 * @param usex
	 * @param ureadingschool
	 * @param ureadschool
	 * @param fname
	 * @return
	 * @throws Exception 
	 */
	public List<UsersVO> find5_t_t(String ureadingschool,
			String ureadschool, String fname) throws Exception {
		// TODO Auto-generated method stub
		ureadingschool="%"+ureadingschool+"%";
		ureadschool="%"+ureadschool+"%";
		fname="%"+fname+"%";
		return db.list("select * from users where u_readschool like '"+ureadschool+"' and u_readingschool like '"+ureadingschool+"' and u_name like '"+fname+"'", new UsersVO());
	}
	/**
	 * 用户名和就读
	 * @param usex
	 * @param ureadingschool
	 * @param ureadschool
	 * @param fname
	 * @return
	 * @throws Exception 
	 */
	public List<UsersVO> find4_t(String fname,String ureadingschool) throws Exception {
		// TODO Auto-generated method stub
		ureadingschool="%"+ureadingschool+"%";
		fname="%"+fname+"%";
		return db.list("select * from users where u_readingschool like '"+ureadingschool+"' and u_name like '"+fname+"'", new UsersVO());
	}
	/**
	 * 用户名和曾读
	 * @param usex
	 * @param ureadingschool
	 * @param ureadschool
	 * @param fname
	 * @return
	 * @throws Exception 
	 */
	public List<UsersVO> find4_t_t(String fname,String ureadschool) throws Exception {
		// TODO Auto-generated method stub
		ureadschool="%"+ureadschool+"%";
		fname="%"+fname+"%";
		return db.list("select * from users where u_readschool like '"+ureadschool+"' and u_name like '"+fname+"'", new UsersVO());
	}
	public int count() throws Exception{
		return db.getInt("select count(*) from users");
	}
}
