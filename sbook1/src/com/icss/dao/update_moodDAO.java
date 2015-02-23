package com.icss.dao;

import java.util.List;

import com.icss.vo.agreecountVO;
import com.icss.vo.moodVO;

public class update_moodDAO extends DAOSupport<moodVO>{

	@Override
	public void add(moodVO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(moodVO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(moodVO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<moodVO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from mood", new moodVO());
	}
	/*
	 * 查找属于自己和自己的朋友的心情动态
	 * @see com.icss.dao.DAOSupport#findById(java.lang.Object)
	 */
	public List<moodVO> findAll2(String uname) throws Exception {
		// TODO Auto-generated method stub
		return db.list("select DISTINCT mood.* from friend,mood where friend.f_name=mood.u_name and friend.u_name='"+uname+"' or mood.u_name='"+uname+"' ORDER BY m_id desc", new moodVO());
	}

	@Override
	public moodVO findById(moodVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 动态里头心情赞的方法
	 * @throws Exception 
	 */
	public void update1(int mid) throws Exception{
		db.execute("update mood set m_agreecount=m_agreecount+1 where m_id='"+mid+"'");
	}
	public void update2(int mid,String name) throws Exception{
		db.execute("insert into agreecount(m_id,count_name) VALUES('"+mid+"','"+name+"')");		
	}
	public List<agreecountVO> judge(int mid) throws Exception{
		return db.list("select * from agreecount where m_id='"+mid+"'",new agreecountVO());		
	}

	@Override
	public moodVO findByName(moodVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
