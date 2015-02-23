package com.icss.service;

import com.icss.dao.AdminDAO;
import com.icss.vo.AdminVO;

public class AdminService {
	private AdminDAO dao=new AdminDAO();
	public AdminVO findByName(AdminVO po) throws Exception {
		// TODO Auto-generated method stub
		return dao.findByName(po);
	}
}
