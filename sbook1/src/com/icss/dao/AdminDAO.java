package com.icss.dao;

import java.util.List;

import com.icss.vo.AdminVO;

public class AdminDAO extends DAOSupport<AdminVO>{

	@Override
	public void add(AdminVO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(AdminVO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AdminVO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AdminVO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminVO findById(AdminVO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminVO findByName(AdminVO po) throws Exception {
		// TODO Auto-generated method stub
		return db.get("select * from admin where a_name=?",new AdminVO(), po.getaName());
	}

}
