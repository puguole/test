package com.icss.vo;

import java.sql.ResultSet;

import com.icss.commons.RowMapper;

public class photoVO implements RowMapper<photoVO>{	
	private String p_name;
	private String u_name;
	private String p_path;
	private String p_explain;
	private String p_power;
	private int p_id;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	public photoVO(String p_name, String u_name, String p_path,
			String p_explain, String p_power, int p_id) {
		super();
		this.p_name = p_name;
		this.u_name = u_name;
		this.p_path = p_path;
		this.p_explain = p_explain;
		this.p_power = p_power;
		this.p_id = p_id;
	}
	public photoVO() {
		super();
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getP_path() {
		return p_path;
	}
	public void setP_path(String p_path) {
		this.p_path = p_path;
	}
	public String getP_explain() {
		return p_explain;
	}
	public void setP_explain(String p_explain) {
		this.p_explain = p_explain;
	}
	public String getP_power() {
		return p_power;
	}
	public void setP_power(String p_power) {
		this.p_power = p_power;
	}
	@Override
	public photoVO mapRow(ResultSet rs, int index) throws Exception {
		// TODO Auto-generated method stub
		photoVO vo=new photoVO();
		vo.setP_id(rs.getInt("p_id"));
		vo.setP_explain(rs.getString("p_explain"));
		vo.setP_name(rs.getString("p_name"));
		vo.setP_path(rs.getString("p_path"));
		vo.setP_power(rs.getString("p_power"));
		vo.setU_name(rs.getString("u_name"));
		return vo;
	}


}
