package com.icss.dao;

import java.util.List;

import com.icss.vo.moodVO;

public class moodDAO extends DAOSupport<moodVO>{

	@Override
	public void add(moodVO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 插入心情内容
	 */
	public void add(String content,String time) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(moodVO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(moodVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(moodVO vo:po){
			db.execute("delete from mood where m_id=?", vo.getM_id());
		}
	}
	/**
	 * 按心情id进行删除
	 * @param mid
	 * @throws Exception
	 */
	public void delete2(int mid) throws Exception {
		db.execute("delete from mood where m_id='"+mid+"'");
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
	/**
	 * 查找属于自己的全部心情
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<moodVO> findAll2(String uname) throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from mood where u_name='"+uname+"' ORDER BY m_id desc", new moodVO());
	}

	@Override
	public moodVO findById(moodVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public moodVO findByName(moodVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
