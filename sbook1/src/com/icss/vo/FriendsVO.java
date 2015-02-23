package com.icss.vo;

import java.sql.ResultSet;

import com.icss.commons.RowMapper;

public class FriendsVO implements RowMapper<FriendsVO>{
	private String uName;
	private String fName;
	public FriendsVO() {
		super();
	}
	public FriendsVO(String uName, String fName) {
		super();
		this.uName = uName;
		this.fName = fName;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	@Override
	public FriendsVO mapRow(ResultSet rs, int index) throws Exception {
		// TODO Auto-generated method stub
		FriendsVO vo=new FriendsVO();
		vo.setfName(rs.getString("f_name"));
		vo.setuName(rs.getString("u_name"));
		return vo;
	}
}
