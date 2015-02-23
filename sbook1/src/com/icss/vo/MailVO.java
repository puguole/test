package com.icss.vo;

import java.sql.ResultSet;

import com.icss.commons.RowMapper;

public class MailVO implements RowMapper<MailVO>{
	private String uName;
	private int eId;
	private String eTitle;
	private String eContent;
	private String eFile;
	private String eStyle;
	private String eTotime;
	private String eTouname;
	private String eState;
	private String uShow;
	private String tShow;
	public String getuShow() {
		return uShow;
	}
	public void setuShow(String uShow) {
		this.uShow = uShow;
	}
	public String gettShow() {
		return tShow;
	}
	public void settShow(String tShow) {
		this.tShow = tShow;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	
	public MailVO() {
		super();
	}
	public MailVO(String uName, int eId, String eTitle, String eContent,
			String eFile, String eStyle, String eTotime, String eTouname,
			String eState, String uShow, String tShow) {
		super();
		this.uName = uName;
		this.eId = eId;
		this.eTitle = eTitle;
		this.eContent = eContent;
		this.eFile = eFile;
		this.eStyle = eStyle;
		this.eTotime = eTotime;
		this.eTouname = eTouname;
		this.eState = eState;
		this.uShow = uShow;
		this.tShow = tShow;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteTitle() {
		return eTitle;
	}
	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}
	public String geteContent() {
		return eContent;
	}
	public void seteContent(String eContent) {
		this.eContent = eContent;
	}
	public String geteFile() {
		return eFile;
	}
	public void seteFile(String eFile) {
		this.eFile = eFile;
	}
	public String geteStyle() {
		return eStyle;
	}
	public void seteStyle(String eStyle) {
		this.eStyle = eStyle;
	}
	public String geteTotime() {
		return eTotime;
	}
	public void seteTotime(String eTotime) {
		this.eTotime = eTotime;
	}
	public String geteTouname() {
		return eTouname;
	}
	public void seteTouname(String eTouname) {
		this.eTouname = eTouname;
	}
	public String geteState() {
		return eState;
	}
	public void seteState(String eState) {
		this.eState = eState;
	}
	@Override
	public MailVO mapRow(ResultSet rs, int index) throws Exception {
		// TODO Auto-generated method stub
		MailVO vo=new MailVO();
		vo.seteContent(rs.getString("e_content"));
		vo.seteFile(rs.getString("e_file"));
		vo.seteId(rs.getInt("e_id"));
		vo.seteState(rs.getString("e_state"));
		vo.seteStyle(rs.getString("e_style"));
		vo.seteTitle(rs.getString("e_title"));
		vo.seteTotime(rs.getString("e_totime"));
		vo.seteTouname(rs.getString("e_touname"));
		vo.setuName(rs.getString("u_name"));
		vo.setuShow(rs.getString("u_show"));
		vo.settShow(rs.getString("t_show"));
		return vo;
	}
}
