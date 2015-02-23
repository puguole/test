package com.icss.vo;

import java.sql.ResultSet;

import com.icss.commons.RowMapper;

/**
 * 
 * @author tianting
 *
 */
public class UsersVO implements RowMapper<UsersVO>{
	private String uName;
	private String uPassword;
	private String uEmail;
	private String uNickname;//用户昵称
	private int uAge;
	public UsersVO() {
		super();
	}
	public UsersVO(String uName, String uPassword, String uEmail,
			String uNickname, int uAge, String uSex, String uReadingschool,
			String uReadschool, String uBirth, String uQq, String uTelphone,
			String uMotto, String uHead) {
		super();
		this.uName = uName;
		this.uPassword = uPassword;
		this.uEmail = uEmail;
		this.uNickname = uNickname;
		this.uAge = uAge;
		this.uSex = uSex;
		this.uReadingschool = uReadingschool;
		this.uReadschool = uReadschool;
		this.uBirth = uBirth;
		this.uQq = uQq;
		this.uTelphone = uTelphone;
		this.uMotto = uMotto;
		this.uHead = uHead;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuNickname() {
		return uNickname;
	}
	public void setuNickname(String uNickname) {
		this.uNickname = uNickname;
	}
	public int getuAge() {
		return uAge;
	}
	public void setuAge(int uAge) {
		this.uAge = uAge;
	}
	public String getuSex() {
		return uSex;
	}
	public void setuSex(String uSex) {
		this.uSex = uSex;
	}
	public String getuReadingschool() {
		return uReadingschool;
	}
	public void setuReadingschool(String uReadingschool) {
		this.uReadingschool = uReadingschool;
	}
	public String getuReadschool() {
		return uReadschool;
	}
	public void setuReadschool(String uReadschool) {
		this.uReadschool = uReadschool;
	}
	public String getuBirth() {
		return uBirth;
	}
	public void setuBirth(String uBirth) {
		this.uBirth = uBirth;
	}
	public String getuQq() {
		return uQq;
	}
	public void setuQq(String uQq) {
		this.uQq = uQq;
	}
	public String getuTelphone() {
		return uTelphone;
	}
	public void setuTelphone(String uTelphone) {
		this.uTelphone = uTelphone;
	}
	public String getuMotto() {
		return uMotto;
	}
	public void setuMotto(String uMotto) {
		this.uMotto = uMotto;
	}
	public String getuHead() {
		return uHead;
	}
	public void setuHead(String uHead) {
		this.uHead = uHead;
	}
	private String uSex;
	private String uReadingschool;//在读学校
	private String uReadschool;//曾读学校
	private String uBirth;
	private String uQq;
	private String uTelphone;
	private String uMotto;//座右铭
	private String uHead;//头像文件路径
	@Override
	public UsersVO mapRow(ResultSet rs, int index) throws Exception {
		// TODO Auto-generated method stub
		UsersVO vo=new UsersVO();
		vo.setuAge(rs.getInt("u_age"));
		vo.setuBirth(rs.getString("u_birth"));
		vo.setuEmail(rs.getString("u_email"));
		vo.setuHead(rs.getString("u_head"));
		vo.setuMotto(rs.getString("u_motto"));
		vo.setuName(rs.getString("u_name"));
		vo.setuNickname(rs.getString("u_nickname"));
		vo.setuPassword(rs.getString("u_password"));
		vo.setuQq(rs.getString("u_qq"));
		vo.setuReadingschool(rs.getString("u_readingschool"));
		vo.setuReadschool(rs.getString("u_readschool"));
		vo.setuSex(rs.getString("u_sex"));
		vo.setuTelphone(rs.getString("u_telphone"));
		return vo;
	}
}
