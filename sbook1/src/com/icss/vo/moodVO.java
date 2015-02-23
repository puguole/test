package com.icss.vo;

import java.sql.ResultSet;

import com.icss.commons.RowMapper;

public class moodVO implements RowMapper<moodVO>{
	private Integer m_id;
	private String u_name;
	private  String m_content;
	private String m_totime;
	private Integer m_agreecount;
	
	

	public moodVO() {
		super();
	}



	public moodVO(Integer m_id, String u_name, String m_content,
			String m_totime, Integer m_agreecount) {
		super();
		this.m_id = m_id;
		this.u_name = u_name;
		this.m_content = m_content;
		this.m_totime = m_totime;
		this.m_agreecount = m_agreecount;
	}



	public Integer getM_id() {
		return m_id;
	}



	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}



	public String getU_name() {
		return u_name;
	}



	public void setU_name(String u_name) {
		this.u_name = u_name;
	}



	public  String getM_content() {
		return m_content;
	}



	public void setM_content(String m_content) {
		this.m_content = m_content;
	}



	public  String getM_totime() {
		return m_totime;
	}



	public void setM_totime(String m_totime) {
		this.m_totime = m_totime;
	}



	public Integer getM_agreecount() {
		return m_agreecount;
	}



	public void setM_agreecount(Integer m_agreecount) {
		this.m_agreecount = m_agreecount;
	}



	@Override
	public moodVO mapRow(ResultSet rs, int index) throws Exception {
		// TODO Auto-generated method stub
		moodVO vo=new moodVO();
		vo.setM_agreecount(rs.getInt("m_agreecount"));
		vo.setM_content(rs.getString("m_content"));
		vo.setM_id(rs.getInt("m_id"));
		vo.setM_totime(rs.getString("m_totime"));
		vo.setU_name(rs.getString("u_name"));
		return vo;
	}

}
