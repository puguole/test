package com.icss.vo;

import java.sql.ResultSet;

import com.icss.commons.RowMapper;

public class agreecountVO implements RowMapper<agreecountVO>{
	private Integer id;
	private Integer m_id;
	private String count_name;
	
	
	public agreecountVO() {
		super();
	}



	public agreecountVO(Integer id, Integer m_id, String count_name) {
		super();
		this.id = id;
		this.m_id = m_id;
		this.count_name = count_name;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getM_id() {
		return m_id;
	}



	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}



	public String getCount_name() {
		return count_name;
	}



	public void setCount_name(String count_name) {
		this.count_name = count_name;
	}



	@Override
	public agreecountVO mapRow(ResultSet rs, int index) throws Exception {
		// TODO Auto-generated method stub
		agreecountVO vo=new agreecountVO();
		vo.setId(rs.getInt("id"));
		vo.setM_id(rs.getInt("m_id"));
		vo.setCount_name(rs.getString("count_name"));
		return vo;
	}

}
