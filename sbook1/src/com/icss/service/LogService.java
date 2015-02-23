package com.icss.service;

import java.util.List;

import com.icss.dao.DiscussDAO;
import com.icss.dao.LogDAO;
import com.icss.vo.DiscussVO;
import com.icss.vo.LogVO;
import com.icss.vo.PageVO;

public class LogService {
	private LogDAO logdao=new LogDAO(); 
	private DiscussDAO ddao=new DiscussDAO();
	public boolean add(LogVO vo){
		boolean b=false;
		try {
			logdao.add(vo);
			b=true;
		} catch (Exception e) {
		}
		return b;
	}
	/**
	 * 日志分页
	 * @param p
	 * @param m
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public PageVO<LogVO> page(String sql,int p,int m,String key) throws Exception{
		return logdao.page(sql,p, m, key);
	}
	public LogVO findByNameOrTitle(LogVO po) throws Exception {
		// TODO Auto-generated method stub
		return logdao.findByNameOrTitle(po);
	}
	public List<DiscussVO> findByNameOrId(DiscussVO po) throws Exception {
		// TODO Auto-generated method stub
		return ddao.findByNameOrId(po);
	}
	/**
	 * 评论增加
	 * @param po
	 * @throws Exception
	 */
	public boolean add2(DiscussVO vo) {
		boolean b=false;
		DiscussDAO dao=new DiscussDAO();
		try {
			dao.add(vo);
			b=true;
		} catch (Exception e) {
		}
		return b;
	}
}
