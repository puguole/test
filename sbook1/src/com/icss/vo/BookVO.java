package com.icss.vo;

import java.sql.ResultSet;

import com.icss.commons.RowMapper;

public class BookVO implements RowMapper<BookVO>{
	private String uName;
	private String fName;
	private String uBigname;
	private String bNickname;
	private String bBirth;
	private String bQq;
	private String bTelphone1;
	private String bTelphone2;
	private String bAddress;
	private String bHobby;
	private String bConstellation;
	private String bLovepeople;
	private String bLovefood;
	private String bLovesay;
	private String bLovefruit;
	private String bLovecountry;
	private String bLoveteacher;
	private String bMotto;
	private String bLeaveword;
	public String getuName() {
		return uName;
	}
	public BookVO() {
		super();
	}
	public BookVO(String uName, String fName, String uBigname,
			String bNickname, String bBirth, String bQq, String bTelphone1,
			String bTelphone2, String bAddress, String bHobbr,
			String bConstellation, String bLovepeople, String bLovefood,
			String bLovesay, String bLovefruit, String bLovecountry,
			String bLoveteacher, String bMotto, String bLeaveword) {
		super();
		this.uName = uName;
		this.fName = fName;
		this.uBigname = uBigname;
		this.bNickname = bNickname;
		this.bBirth = bBirth;
		this.bQq = bQq;
		this.bTelphone1 = bTelphone1;
		this.bTelphone2 = bTelphone2;
		this.bAddress = bAddress;
		this.bHobby = bHobby;
		this.bConstellation = bConstellation;
		this.bLovepeople = bLovepeople;
		this.bLovefood = bLovefood;
		this.bLovesay = bLovesay;
		this.bLovefruit = bLovefruit;
		this.bLovecountry = bLovecountry;
		this.bLoveteacher = bLoveteacher;
		this.bMotto = bMotto;
		this.bLeaveword = bLeaveword;
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
	public String getuBigname() {
		return uBigname;
	}
	public void setuBigname(String uBigname) {
		this.uBigname = uBigname;
	}
	public String getbNickname() {
		return bNickname;
	}
	public void setbNickname(String bNickname) {
		this.bNickname = bNickname;
	}
	public String getbBirth() {
		return bBirth;
	}
	public void setbBirth(String bBirth) {
		this.bBirth = bBirth;
	}
	public String getbQq() {
		return bQq;
	}
	public void setbQq(String bQq) {
		this.bQq = bQq;
	}
	public String getbTelphone1() {
		return bTelphone1;
	}
	public void setbTelphone1(String bTelphone1) {
		this.bTelphone1 = bTelphone1;
	}
	public String getbTelphone2() {
		return bTelphone2;
	}
	public void setbTelphone2(String bTelphone2) {
		this.bTelphone2 = bTelphone2;
	}
	public String getbAddress() {
		return bAddress;
	}
	public void setbAddress(String bAddress) {
		this.bAddress = bAddress;
	}
	public String getbHobby() {
		return bHobby;
	}
	public void setbHobby(String bHobby) {
		this.bHobby = bHobby;
	}
	public String getbConstellation() {
		return bConstellation;
	}
	public void setbConstellation(String bConstellation) {
		this.bConstellation = bConstellation;
	}
	public String getbLovepeople() {
		return bLovepeople;
	}
	public void setbLovepeople(String bLovepeople) {
		this.bLovepeople = bLovepeople;
	}
	public String getbLovefood() {
		return bLovefood;
	}
	public void setbLovefood(String bLovefood) {
		this.bLovefood = bLovefood;
	}
	public String getbLovesay() {
		return bLovesay;
	}
	public void setbLovesay(String bLovesay) {
		this.bLovesay = bLovesay;
	}
	public String getbLovefruit() {
		return bLovefruit;
	}
	public void setbLovefruit(String bLovefruit) {
		this.bLovefruit = bLovefruit;
	}
	public String getbLovecountry() {
		return bLovecountry;
	}
	public void setbLovecountry(String bLovecountry) {
		this.bLovecountry = bLovecountry;
	}
	public String getbLoveteacher() {
		return bLoveteacher;
	}
	public void setbLoveteacher(String bLoveteacher) {
		this.bLoveteacher = bLoveteacher;
	}
	public String getbMotto() {
		return bMotto;
	}
	public void setbMotto(String bMotto) {
		this.bMotto = bMotto;
	}
	public String getbLeaveword() {
		return bLeaveword;
	}
	public void setbLeaveword(String bLeaveword) {
		this.bLeaveword = bLeaveword;
	}
	@Override
	public BookVO mapRow(ResultSet rs, int index) throws Exception {
		// TODO Auto-generated method stub
		BookVO vo=new BookVO();
		vo.setbAddress(rs.getString("b_address"));
		vo.setbBirth(rs.getString("b_birth"));
		vo.setbConstellation(rs.getString("b_constellation"));
		vo.setbHobby(rs.getString("b_hobby"));
		vo.setbLeaveword(rs.getString("b_leaveword"));
		vo.setbLovecountry(rs.getString("b_lovecountry"));
		vo.setbLovefood(rs.getString("b_lovefood"));
		vo.setbLovefruit(rs.getString("b_lovefruit"));
		vo.setbLovepeople(rs.getString("b_lovepeople"));
		vo.setbLovesay(rs.getString("b_lovesay"));
		vo.setbLoveteacher(rs.getString("b_loveteacher"));
		vo.setbMotto(rs.getString("b_motto"));
		vo.setbNickname(rs.getString("b_nickname"));
		vo.setbQq(rs.getString("b_qq"));
		vo.setbTelphone1(rs.getString("b_telphone1"));
		vo.setbTelphone2(rs.getString("b_telphone2"));
		vo.setfName(rs.getString("f_name"));
		vo.setuBigname(rs.getString("u_bigname"));
		vo.setuName(rs.getString("u_name"));
		return vo;
	}
}
