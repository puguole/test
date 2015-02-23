package com.icss.service;

import java.util.List;

import com.icss.dao.MailDAO;
import com.icss.vo.MailVO;

public class MailService {
	private MailDAO mailDAO=new MailDAO();
	/**
	 * 查找指定的人的已读或未读的邮件总数
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public long findCount(String uname,String estate) throws Exception{
		return mailDAO.findCount(uname, estate);
	}
	/**
	 * 这是查找某个用户的已经发出去的邮件
	 * @return
	 * @throws Exception
	 */
	public List<MailVO> findAll2(String uname) throws Exception {
		// TODO Auto-generated method stub
		return mailDAO.findAll2(uname);
	}
	/**
	 * 这是查找某个用户收到的所有邮件，分为已读或未读
	 * @return
	 * @throws Exception
	 */
	public List<MailVO> findAll3(String uname,String estate) throws Exception {
		// TODO Auto-generated method stub
		return mailDAO.findAll3(uname, estate);
	}
	/**
	 * 增加邮件
	 * @param po
	 * @throws Exception
	 */
	public void add(MailVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(MailVO vo:po){
			mailDAO.add(po);
		}
	}
	/**
	 * 根据发件人、收件人、邮件标题、发件时间获取
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public MailVO findEmail(MailVO po) throws Exception {
		return mailDAO.findEmail(po);
	}
	public void delete(MailVO... po) throws Exception {
		// TODO Auto-generated method stub
		mailDAO.delete(po);
	}
	/**
	 * 供收件箱进行删除的
	 */
	public void delete2(MailVO... po) throws Exception {
		// TODO Auto-generated method stub
		//相当于修改
		for(MailVO vo : po)
			mailDAO.delete2(po);
	}
	public void modify(MailVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(MailVO vo:po){
			mailDAO.modify(po);
		}
	}
}
