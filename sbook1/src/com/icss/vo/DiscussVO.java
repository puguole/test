package com.icss.vo;

import java.sql.ResultSet;

import com.icss.commons.RowMapper;

public class DiscussVO implements RowMapper<DiscussVO>{

	private String uName;
	private int lId;
	private String lDiscussname;
	private String dContent;
	private String dDiscusstime;
	public DiscussVO() {
		super();
	}
	public DiscussVO(String uName, int lId, String lDiscussname,
			String dContent, String dDiscusstime) {
		super();
		this.uName = uName;
		this.lId = lId;
		this.lDiscussname = lDiscussname;
		this.dContent = dContent;
		this.dDiscusstime = dDiscusstime;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public String getlDiscussname() {
		return lDiscussname;
	}
	public void setlDiscussname(String lDiscussname) {
		this.lDiscussname = lDiscussname;
	}
	public String getdContent() {
		return dContent;
	}
	public void setdContent(String dContent) {
		this.dContent = dContent;
	}
	public String getdDiscusstime() {
		return dDiscusstime;
	}
	public void setdDiscusstime(String dDiscusstime) {
		this.dDiscusstime = dDiscusstime;
	}
	@Override
	public DiscussVO mapRow(ResultSet rs, int index) throws Exception {
		// TODO Auto-generated method stub
		DiscussVO vo=new DiscussVO();
		vo.setdContent(rs.getString("d_content"));
		vo.setdDiscusstime(rs.getString("d_discusstime"));
		vo.setlDiscussname(rs.getString("l_discussname"));
		vo.setlId(rs.getInt("l_id"));
		vo.setuName(rs.getString("u_name"));
		return vo;
	}

}
