package com.icss.dao;

import java.util.List;

import com.icss.vo.photoVO;

public class PhotosDAO extends DAOSupport<photoVO> {

	@Override
	public void add(photoVO... po) throws Exception {
		for(photoVO vo:po){
			db.execute("insert into photo(u_name,p_name,p_path,p_power,p_explain) values(?,?,?,?,?)",vo.getU_name(),vo.getP_name(),vo.getP_path(),vo.getP_power(),vo.getP_explain());
		}
		
	}

	@Override
	public void modify(photoVO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(photoVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(photoVO vo:po){
			db.execute("delete from photo where p_id=?",vo.getP_id());
		}
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<photoVO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from photo", new photoVO());
	}
	
	public List<photoVO> findAll2(String name) throws Exception{
		return db.list("select DISTINCT photo.* from friend,photo where friend.f_name=photo.u_name and friend.u_name='"+name+"' or photo.u_name='"+name+"' ORDER BY p_id desc", new photoVO());
		
	}

	@Override
	public photoVO findById(photoVO po) throws Exception {
		// TODO Auto-generated method stub
		return db.get("select * from photo where p_id=?", new photoVO(), po.getP_id());
	}

	@Override
	public photoVO findByName(photoVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	//田停的
	/**
	 * 查找指定相框中的所有相册
	 * @param uname
	 * @param pname
	 * @return
	 * @throws Exception
	 */
	public List<photoVO> findAllPhoto_tt1(String uname,String pname) throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from photo where u_name='"+uname+"' and p_name='"+pname+"'", new photoVO());
	}
	/**
	 * 通过传入的相册名查询出相册名全部相同的VO对象，并将它放入集合当中
	 * @param p_name
	 * @param u_name
	 * @return
	 * @throws Exception
	 */
	public List<photoVO> findByPname(String p_name,String u_name) throws Exception {
		return db.list("select * from photo where p_name=?and u_name=?", new photoVO(),p_name,u_name);
	}
	/**
	 * 查找所有的相册
	 * @param p_name
	 * @param u_name
	 * @return
	 * @throws Exception
	 */
	public List<photoVO> findPhoto_ld() throws Exception {
		return db.list("select * from photo ORDER BY p_id desc", new photoVO());
	}

}
