package com.icss.service;

import java.util.List;

import com.icss.dao.LogDAO;
import com.icss.vo.LogVO;
import com.icss.vo.moodVO;

public class update_logService{
	private LogDAO logdao=new LogDAO();
	/**
	 * 查找属于自己及自己好友的日志
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<LogVO> findAll1(String uname) throws Exception {
		return logdao.findAll1(uname);
		
	}

}
