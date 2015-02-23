package com.icss.vo;

import java.sql.ResultSet;

import com.icss.commons.RowMapper;

public class AdminVO implements RowMapper<AdminVO>{

	private int aId;
	private String aName;
	private String aPwd;
	private String aPhone;
	public int getaId() {
		return aId;
	}
	public AdminVO() {
		super();
	}
	public AdminVO(int aId, String aName, String aPwd, String aPhone) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aPwd = aPwd;
		this.aPhone = aPhone;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaPwd() {
		return aPwd;
	}
	public void setaPwd(String aPwd) {
		this.aPwd = aPwd;
	}
	public String getaPhone() {
		return aPhone;
	}
	public void setaPhone(String aPhone) {
		this.aPhone = aPhone;
	}
	@Override
	public AdminVO mapRow(ResultSet rs, int index) throws Exception {
		// TODO Auto-generated method stub
		AdminVO vo=new AdminVO();
		vo.setaId(rs.getInt("a_id"));
		vo.setaName(rs.getString("a_name"));
		vo.setaPhone(rs.getString("a_phone"));
		vo.setaPwd(rs.getString("a_pwd"));
		return vo;
	}

}
