package com.icss.service;

import java.util.List;

import com.icss.dao.PhotosDAO;
import com.icss.vo.photoVO;

public class update_photoService {
	private PhotosDAO pdao=new PhotosDAO();

	/**
	 * 通过传入的相册名查询出相册名全部相同的VO对象，并将它放入集合当中
	 * @param p_name
	 * @param u_name
	 * @return
	 * @throws Exception
	 */
	public List<photoVO> findByPname(String p_name,String u_name) throws Exception {
		return pdao.findByPname(p_name, u_name);
		
	}
	/**
	 * 查找所有的相册
	 * @param p_name
	 * @param u_name
	 * @return
	 * @throws Exception
	 */
	public List<photoVO> findPhoto_ld() throws Exception {
		return pdao.findPhoto_ld();
	}
	
	public List<photoVO>  updateFind(String name) throws Exception{
		return pdao.findAll2(name);
	}
}
