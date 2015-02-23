package com.icss.dao;

import java.util.List;

import com.icss.commons.DbUtils;
import com.icss.vo.LogVO;
import com.icss.vo.PageVO;


public class LogDAO extends DAOSupport<LogVO>{
	private DbUtils dbutils=DbUtils.newInstance();
	@Override
	public void add(LogVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(LogVO vo:po){
			db.execute("insert into logg(u_name,l_title,l_content,l_power,l_style,l_totime) values(?,?,?,?,?,?)", vo.getuName(),vo.getlTitle(),vo.getlContent(),vo.getlPower(),vo.getlStyle(),vo.getlTotime());
		}
	}

	@Override
	public void modify(LogVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(LogVO vo: po)
			db.execute("update logg set l_title=?,l_content=?,l_power=?,l_style=?,l_totime=? where u_name=? and l_id=?"
					,vo.getlTitle()
					,vo.getlContent()
					,vo.getlPower()
					,vo.getlStyle()
					,vo.getlTotime()
					,vo.getuName()
					,vo.getlId()
			);
	}

	@Override
	public void delete(LogVO... po) throws Exception {
		// TODO Auto-generated method stub
		for(LogVO vo:po){
			db.execute("delete from logg where u_name=? and l_id=?", vo.getuName(),vo.getlId());
		}
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 查找属于自己及自己好友的可见的日志
	 * @param name
	 * @return
	 * @throws Exception
	 */

	public List<LogVO> findAll1(String name) throws Exception {
		// TODO Auto-generated method stub
	    return db.list("select * from logg where u_name in(SELECT f_name from friend where u_name='"+name+"' )and l_power='全部用户可见' OR u_name='"+name+"' order by l_id desc", new LogVO());
	}
	@Override
	public List<LogVO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from logg", new LogVO());
	}
	/**
	 * 查找自己好友的所有可见的日志
	 */
	public List<LogVO> findAll2(String uname) throws Exception {
		// TODO Auto-generated method stub
		return db.list("select DISTINCT * from logg where u_name in (select f_name from friend where u_name='"+uname+"') and u_name!='"+uname+"' and l_power!='只允许自己可见' order by l_id desc", new LogVO());
	}
	/**
	 * 按姓名查找自己好友的所有日志
	 */
	public List<LogVO> findAll3(String uname,String sname) throws Exception {
		// TODO Auto-generated method stub
		return db.list("select distinct l.* from logg l,friend f where f.u_name='"+uname+"' and l.u_name!='"+uname+"' and l.u_name like '%"+sname+"%' and l.l_power!='只允许自己可见' order by l_id desc", new LogVO());
	}
	@Override
	public LogVO findById(LogVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogVO findByName(LogVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public LogVO findByNameOrTitle(LogVO po) throws Exception {
		// TODO Auto-generated method stub
		return db.get("select * from logg where u_name=? and l_title=? order by l_id desc", new LogVO(), po.getuName(),po.getlTitle());
	}
	/**
	 * 学生视图的分页数据
	 * @param p 页码
	 * @param m 每页最大数
	 * @param key 搜索关键字,模糊匹配 s_name s_num
	 * @return
	 */
	public PageVO<LogVO> page(String sql,int p,int m,String key) throws Exception{
		if(key!=null&&!"".equals(key)){
			key = "%"+key+"%";
			return page(sql, p, m, new LogVO(), key, key);
		}else{
			return page(sql, p, m, new LogVO());
		}
	}
}
