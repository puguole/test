package com.icss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.commons.DbUtils;
import com.icss.vo.DiscussVO;
import com.icss.vo.LogVO;

public class DiscussDAO extends DAOSupport<DiscussVO>{
	private DbUtils dbutils=DbUtils.newInstance();
	@Override
	public void add(DiscussVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(DiscussVO vo:po){
			db.execute("insert into discuss values(?,?,?,?,?)", vo.getuName(),vo.getlId(),vo.getlDiscussname(),vo.getdContent(),vo.getdDiscusstime());
		}
	}

	@Override
	public void modify(DiscussVO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DiscussVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(DiscussVO vo:po){
			db.execute("delete from discuss where u_name=? and l_id=?", vo.getuName(),vo.getlId());
		}
	}
	//删除某一条评论,
	public void delete2(DiscussVO vo)throws Exception{
		dbutils.execute("delete from discuss where u_name=? and l_discussname=? and d_discusstime=?",vo.getuName(),vo.getlDiscussname(),vo.getdDiscusstime() );
	}
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 查找指定的日志的评论数目，根据id、uname、discussname
	 * @throws Exception 
	 *
	 */
	public int findDiscussCount(DiscussVO vo) throws Exception{
		int count=db.getInt("select count(*) from discuss where l_id=? and u_name=?", vo.getlId(),vo.getuName());
		return count;
	}
	@Override
	public List<DiscussVO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiscussVO findById(DiscussVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiscussVO findByName(DiscussVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	//只有一条记录的
	public List<DiscussVO> findByNameOrId(DiscussVO po) throws Exception {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ct=dbutils.getConnectin();
		ps=ct.prepareStatement("select * from discuss where u_name=? and l_id=?");
		ps.setString(1, po.getuName());
		ps.setInt(2, po.getlId());
		rs=ps.executeQuery();
		while(rs.next()){
			DiscussVO vo=new DiscussVO();
			vo.setdContent(rs.getString("d_content"));
			vo.setdDiscusstime(rs.getString("d_discusstime"));
			vo.setlDiscussname(rs.getString("l_discussname"));
			vo.setlId(rs.getInt("l_id"));
			vo.setuName(rs.getString("u_name"));
			list.add(vo);
		}
		return list;
	}
}
