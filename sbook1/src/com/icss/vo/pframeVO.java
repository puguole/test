package com.icss.vo;

import java.sql.ResultSet;

import com.icss.commons.RowMapper;

public class pframeVO implements RowMapper<pframeVO>{
 private String u_name,p_name;

public pframeVO(String u_name, String p_name) {
	super();
	this.u_name = u_name;
	this.p_name = p_name;
}

public pframeVO() {
	super();
}

public String getU_name() {
	return u_name;
}

public void setU_name(String u_name) {
	this.u_name = u_name;
}

public String getP_name() {
	return p_name;
}

public void setP_name(String p_name) {
	this.p_name = p_name;
}

@Override
public pframeVO mapRow(ResultSet rs, int index) throws Exception {
	// TODO Auto-generated method stub
	pframeVO vo=new pframeVO();
	vo.setP_name(rs.getString("p_name"));
	vo.setU_name(rs.getString("u_name"));
	return vo;
}
 

}
