package com.icss.service;

import java.util.List;

import com.icss.dao.moodDAO;
import com.icss.dao.update_moodDAO;
import com.icss.vo.agreecountVO;
import com.icss.vo.moodVO;

public class update_moodService {
	private update_moodDAO update_mooddao=new update_moodDAO();
	
	/**
	 * 查找属于自己的全部心情
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<moodVO> findAll2(String uname) throws Exception {
		// TODO Auto-generated method stub
		return update_mooddao.findAll2(uname);
	}
	
	/**
	 * 动态更新里头赞的方法
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public void update1(int m) throws Exception{
		update_mooddao.update1(m);		
	}
	public void update2(int m,String name) throws Exception{
		update_mooddao.update2(m, name);
	}
	public List<agreecountVO> judge(int mid) throws Exception{
		return 	update_mooddao.judge(mid);
	}

}
