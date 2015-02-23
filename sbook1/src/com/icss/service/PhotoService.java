package com.icss.service;

import java.util.List;

import com.icss.dao.PhotosDAO;
import com.icss.vo.photoVO;

public class PhotoService {
	private PhotosDAO photosDAO=new PhotosDAO();
	//田停的
	/**
	 * 查找指定相框中的所有相册
	 * @param uname
	 * @param pname
	 * @return
	 * @throws Exception
	 */
	public List<photoVO> findAllPhoto_tt(String uname,String pname) throws Exception {
		// TODO Auto-generated method stub
		return photosDAO.findAllPhoto_tt1(uname, pname);
	}
}
