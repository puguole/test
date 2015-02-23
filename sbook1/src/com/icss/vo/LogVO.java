package com.icss.vo;

import java.sql.ResultSet;

import com.icss.commons.RowMapper;

public class LogVO implements RowMapper<LogVO>{
	private String uName;
	private int lId;
	private String lTitle;
	private String lContent;
	private String lPower;
	public LogVO() {
		super();
	}

	public LogVO(String uName, int lId, String lTitle, String lContent,
			String lPower, String lStyle, String lTotime) {
		super();
		this.uName = uName;
		this.lId = lId;
		this.lTitle = lTitle;
		this.lContent = lContent;
		this.lPower = lPower;
		this.lStyle = lStyle;
		this.lTotime = lTotime;
	}

	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}
	private String lStyle;
	private String lTotime;
	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getlTitle() {
		return lTitle;
	}
	public void setlTitle(String lTitle) {
		this.lTitle = lTitle;
	}
	public String getlContent() {
		return lContent;
	}
	public void setlContent(String lContent) {
		this.lContent = lContent;
	}
	public String getlPower() {
		return lPower;
	}
	public void setlPower(String lPower) {
		this.lPower = lPower;
	}
	public String getlStyle() {
		return lStyle;
	}
	public void setlStyle(String lStyle) {
		this.lStyle = lStyle;
	}
	public String getlTotime() {
		return lTotime;
	}
	public void setlTotime(String lTotime) {
		this.lTotime = lTotime;
	}
	@Override
	public LogVO mapRow(ResultSet rs, int index) throws Exception {
		// TODO Auto-generated method stub
		LogVO vo=new LogVO();
		vo.setlContent(rs.getString("l_content"));
		vo.setlId(rs.getInt("l_id"));
		vo.setlPower(rs.getString("l_power"));
		vo.setlStyle(rs.getString("l_style"));
		vo.setlTitle(rs.getString("l_title"));
		vo.setlTotime(rs.getString("l_totime"));
		vo.setuName(rs.getString("u_name"));
		return vo;
	}
	
}
