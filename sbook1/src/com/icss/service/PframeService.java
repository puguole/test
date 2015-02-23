package com.icss.service;

import java.util.List;

import com.icss.dao.PhotosDAO;
import com.icss.dao.pframeDAO;
import com.icss.vo.pframeVO;
import com.icss.vo.photoVO;

public class PframeService {
	private pframeDAO pframeDAO=new pframeDAO();
	//田停的
		/**
		 * 查找指定用户名的相框数
		 * @param uname
		 * @return
		 * @throws Exception
		 */
		public int findPframeCount(String uname) throws Exception{
			return pframeDAO.findPframeCount(uname);
		}
		/**
		 * 查找指定用户的照片信息，适合我的相框页面
		 * @return
		 * @throws Exception
		 */
		public List<photoVO> findPhotoOrderByPname_tt(String uname) throws Exception {
			// TODO Auto-generated method stub
			return pframeDAO.findPhotoOrderByPname_tt(uname);
		}
		/**
		 * 删除某个相框中的所有相册
		 * @param po
		 * @throws Exception
		 */
		public void delete_tt1(photoVO... po) throws Exception {
			// TODO Auto-generated method stub
			for(photoVO vo:po){
				pframeDAO.delete_tt1(po);
			}
		}
		/**
		 * 删除某个相框中，和上一个联系使用
		 * @param po
		 * @throws Exception
		 */
		public void delete_tt2(String uname,String pname) throws Exception {
			pframeDAO.delete_tt2(uname, pname);
		}
		/**
		 * 删除某个用户的全部相框，与下面的联系使用
		 * @param po
		 * @throws Exception
		 */
		public void delete_tt3(String uname) throws Exception {
			pframeDAO.delete_tt3(uname);
		}
		/**
		 * 删除某个用户的全部相册
		 * @param po
		 * @throws Exception
		 */
		public void delete_tt4(String uname) throws Exception {
			pframeDAO.delete_tt4(uname);
		}
}
