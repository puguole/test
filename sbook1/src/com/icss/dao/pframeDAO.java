package com.icss.dao;

import java.util.List;

import com.icss.vo.pframeVO;
import com.icss.vo.photoVO;

public class pframeDAO  extends DAOSupport<pframeVO>{

	@Override
	public void add(pframeVO... po) throws Exception {
		for(pframeVO vo:po){
			db.execute("insert into pframe values(?,?)",vo.getU_name(),vo.getP_name());
					
		}
		
	}

	@Override
	public void modify(pframeVO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(pframeVO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<pframeVO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from pframe",new pframeVO());
	}

	@Override
	public pframeVO findById(pframeVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public pframeVO findByName(pframeVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	//田停的
	/**
	 * 查找指定用户名的相框数
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public int findPframeCount(String uname) throws Exception{
		return db.getInt("select count(*) from pframe where u_name=?", uname);
	}
	/**
	 * 查找指定用户的照片信息，适合我的相框页面
	 * @return
	 * @throws Exception
	 */
	public List<photoVO> findPhotoOrderByPname_tt(String uname) throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from photo where p_name in(select p_name from pframe where u_name='"+uname+"') and u_name='"+uname+"' GROUP BY p_name", new photoVO());
	} 
	/**
	 * 删除某个相框中的所有相册
	 * @param po
	 * @throws Exception
	 */
	public void delete_tt1(photoVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(photoVO vo:po){
			db.execute("delete from photo where u_name=? and p_name=?", vo.getU_name(),vo.getP_name());
		}
	}
	/**
	 * 删除某个相框中，和上一个联系使用
	 * @param po
	 * @throws Exception
	 */
	public void delete_tt2(String uname,String pname) throws Exception {
		db.execute("delete from pframe where u_name='"+uname+"' and p_name='"+pname+"'");
	}
	/**
	 * 删除某个用户的全部相框，与下面的联系使用
	 * @param po
	 * @throws Exception
	 */
	public void delete_tt3(String uname) throws Exception {
		db.execute("delete from pframe where u_name='"+uname+"'");
	}
	/**
	 * 删除某个用户的全部相册
	 * @param po
	 * @throws Exception
	 */
	public void delete_tt4(String uname) throws Exception {
		db.execute("delete from photo where u_name='"+uname+"'");
	}
}
