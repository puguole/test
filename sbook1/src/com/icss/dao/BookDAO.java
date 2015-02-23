package com.icss.dao;

import java.util.List;

import com.icss.commons.DbUtils;
import com.icss.vo.BookVO;
import com.icss.vo.FriendsVO;

public class BookDAO extends DAOSupport<BookVO>{
	private DbUtils dbUtils=DbUtils.newInstance();
	@Override
	public void add(BookVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(BookVO vo:po){
			db.execute("insert into book values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", vo.getuName(),vo.getfName(),vo.getuBigname(),vo.getbNickname(),vo.getbBirth(),vo.getbQq(),vo.getbTelphone1(),vo.getbTelphone2(),vo.getbAddress(),vo.getbHobby(),vo.getbConstellation(),vo.getbLovepeople(),vo.getbLovefood(),vo.getbLovesay(),vo.getbLovefruit(),vo.getbLovecountry(),vo.getbLoveteacher(),vo.getbMotto(),vo.getbLeaveword());
		}
	}

	@Override
	public void modify(BookVO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BookVO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}
	public void deleteByName(String uname,String fname) throws Exception {
		db.execute("delete from book where f_name='"+uname+"' and u_name='"+fname+"'");
	}

	@Override
	public List<BookVO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 用来查询已有的好友的同学录
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<BookVO> findAlly(String uname) throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from book where u_name in(select f_name from friend where u_name='"+uname+"') and f_name in(select u_name from friend where u_name='"+uname+"')", new BookVO());
	}
	
	/**
	 * 用来查询已有的好友的同学录
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<FriendsVO> findAlln(String uname) throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from friend where u_name='"+uname+"' and f_name not in(select u_name from book where f_name='"+uname+"')", new FriendsVO());
	}
	/**
	 * 用来查询未给他们写同学录的好友列表
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<FriendsVO> findAlln2(String uname) throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from friend where u_name='"+uname+"' and f_name not in(select f_name from book where u_name='"+uname+"')", new FriendsVO());
	}
	/**
	 * 查找自己已有同学录的好友的个数
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public int findCountY(String uname) throws Exception{
		int count=dbUtils.getInt("select count(*) from book where u_name in(select f_name from friend where u_name='"+uname+"') and f_name in(select u_name from friend where u_name='"+uname+"')");
		return count;
	}
	/**
	 * 查找自己没有同学录的好友的个数
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public int findCountN(String uname) throws Exception{
		int count=dbUtils.getInt("select count(*) from friend where u_name='"+uname+"' and f_name not in(select u_name from book where f_name='"+uname+"')");
		return count;
	}
	
	@Override
	public BookVO findById(BookVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookVO findByName(BookVO po) throws Exception {
		// TODO Auto-generated method stub
		return db.get("select * from book where u_name=? and f_name=?", new BookVO(), po.getuName(),po.getfName());
	}
	

}
