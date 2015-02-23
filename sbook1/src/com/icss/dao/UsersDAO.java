package com.icss.dao;

import java.util.List;

import com.icss.vo.FriendsVO;
import com.icss.vo.UsersVO;

public class UsersDAO extends DAOSupport<UsersVO>{

	@Override
	public void add(UsersVO... po) throws Exception {
		for(UsersVO vo:po){
			db.execute("insert into users(u_name,u_password,u_email) value(?,?,?)", 
					vo.getuName(),
					vo.getuPassword(),
					vo.getuEmail());
		}
		
	}

	@Override
	public void modify(UsersVO... po) throws Exception {
		for(UsersVO vo:po){
			db.execute("update users set u_password=?, u_nickname=?,u_age=?,u_sex=?,u_readingschool=?,u_readschool=?,u_birth=?,u_qq=?,u_telphone=?,u_motto=?,u_head=? where u_name=?",vo.getuPassword(),vo.getuNickname(),vo.getuAge(),vo.getuSex(),vo.getuReadingschool(),vo.getuReadschool(),vo.getuBirth(),vo.getuQq(),vo.getuTelphone(),vo.getuMotto(),vo.getuHead(),vo.getuName());
		}
		
	}

	@Override
	public void delete(UsersVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(UsersVO vo:po){
			 db.execute("delete from users where u_name=?",vo.getuName());
			}
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsersVO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from users", new UsersVO());
	}
	public List<UsersVO> findAll_lzx(String uname) throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from users where u_name in(select f_name from friend where u_name ='"+uname+"')", new UsersVO());
	}
	
	public List<UsersVO> findAll_lzx2(String uname,String search) throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from users where u_name in(select f_name from friend where u_name='"+uname+"' and f_name='"+search+"')", new UsersVO());
	}
	@Override
	public UsersVO findById(UsersVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsersVO findByName(UsersVO po) throws Exception {
		// TODO Auto-generated method stub
		return db.get("select * from users where u_name=?", new UsersVO(), po.getuName());
	}
	/**
	 * 修改
	 * @param po
	 * @throws Exception
	 */
	public void modify_xf(UsersVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(UsersVO vo:po){
			db.execute("update users set u_password=?,u_email=?, u_nickname=?,u_age=?,u_sex=?,u_readingschool=?,u_readschool=?,u_birth=?,u_qq=?,u_telphone=?,u_motto=? where u_name=?",
					vo.getuPassword(),vo.getuEmail(),vo.getuNickname(),vo.getuAge(),vo.getuSex(),
					vo.getuReadingschool(),vo.getuReadschool(),vo.getuBirth(),vo.getuQq(),
					vo.getuTelphone(),vo.getuMotto(),vo.getuName());
		}
	}
	/**
	 * 查找
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public List<UsersVO> findByName_xf(String uname) throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from users where u_name='"+uname+"'", new UsersVO());
	}
	/**
	 * 模糊匹配
	 * @param q
	 * @return
	 * @throws Exception 
	 */
	public List<UsersVO> findAllByQ(String q) throws Exception {
		// TODO Auto-generated method stub
		q = "%"+q+"%";
		return db.list("select distinct * from users where u_name like ?", new UsersVO(),q);
	}
	/**
	 * 曾读学校
	 * @param c
	 * @return
	 * @throws Exception 
	 */
	public List<UsersVO> findAllC(String c) throws Exception {
		// TODO Auto-generated method stub
		String sql="";
		if(c!=null&&!"".equals(c)){
			c=c="%"+c+"%";
			return db.list("select DISTINCT u_readingschool from users where u_readingschool like ?", new UsersVO(),c);
		}else{
			return db.list("select * from users",new UsersVO());
		}
	}
}
