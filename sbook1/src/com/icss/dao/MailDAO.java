package com.icss.dao;

import java.util.List;

import com.icss.commons.DbUtils;
import com.icss.vo.MailVO;

public class MailDAO extends DAOSupport<MailVO>{
	private DbUtils dbntils=DbUtils.newInstance();
	@Override
	public void add(MailVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(MailVO vo:po){
			db.execute("insert into email(u_name,e_title,e_content,e_file,e_style,e_totime,e_touname,e_state,u_show,t_show) values(?,?,?,?,?,?,?,?,?,?)", vo.getuName(),vo.geteTitle(),vo.geteContent(),vo.geteFile(),vo.geteStyle(),vo.geteTotime(),vo.geteTouname(),vo.geteState(),vo.getuShow(),vo.gettShow());
		}
	}

	@Override
	public void modify(MailVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(MailVO vo:po){
			db.execute("update email set e_state='已读' where u_name=? and e_touname=? and e_title=? and e_totime=?", vo.getuName(),vo.geteTouname(),vo.geteTitle(),vo.geteTotime());
		}
	}

	@Override
	public void delete(MailVO... po) throws Exception {
		// TODO Auto-generated method stub
		//相当于修改
		for(MailVO vo : po)
			db.execute("update email set u_show='n' where u_name=? and e_title=? and e_touname=? and e_totime=?", vo.getuName(),vo.geteTitle(),vo.geteTouname(),vo.geteTotime());
	}
	/**
	 * 供收件箱进行删除的
	 */
	public void delete2(MailVO... po) throws Exception {
		// TODO Auto-generated method stub
		//相当于修改
		for(MailVO vo : po)
			db.execute("update email set t_show='n' where u_name=? and e_title=? and e_touname=? and e_totime=?", vo.getuName(),vo.geteTitle(),vo.geteTouname(),vo.geteTotime());
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public List<MailVO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from email", new MailVO());
	}
	/**
	 * 这是查找某个用户的已经发出去的邮件
	 * @return
	 * @throws Exception
	 */
	public List<MailVO> findAll2(String uname) throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from email where u_name='"+uname+"' and u_show='y' order by e_id desc", new MailVO());
	}
	/**
	 * 这是查找某个用户收到的所有邮件，分为已读或未读
	 * @return
	 * @throws Exception
	 */
	public List<MailVO> findAll3(String etouname,String estate) throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from email where e_touname='"+etouname+"' and e_state='"+estate+"' and t_show='y'  order by e_id desc", new MailVO());
	}

	@Override
	public MailVO findById(MailVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MailVO findByName(MailVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 查找指定的人的已读或未读的邮件总数
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public long findCount(String etouname,String estate) throws Exception{
		return dbntils.getLong("select count(*) from email where e_touname='"+etouname+"' and e_state='"+estate+"' and t_show='y'  order by e_id desc");
	}
	/**
	 * 根据发件人、收件人、邮件标题、发件时间获取发件箱的
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public MailVO findEmail(MailVO po) throws Exception {
		return db.get("select * from email where u_name=? and e_touname=? and e_title=? and e_totime=?  order by e_id desc", new MailVO(), po.getuName(),po.geteTouname(),po.geteTitle(),po.geteTotime());
	}

}
