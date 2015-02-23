package com.icss.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;//注意
import java.util.List;


import com.icss.commons.DBUtil;
import com.icss.dao.moodDAO;
import com.icss.vo.moodVO;

public class moodService {
	private moodDAO mooddao=new moodDAO();
	public void add(String uname,String content,String time,int magreecount) throws SQLException{
		Connection conn=DBUtil.getConnection();
		PreparedStatement pstmt=null;
		String sql="insert into mood(u_name,m_content,m_totime,m_agreecount) VALUES(?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,uname);
			pstmt.setString(2, content);
			pstmt.setString(3, time);
			pstmt.setInt(4,magreecount);
			pstmt.executeUpdate();
	}
	
	public String getDate(){
		return  new  SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date());
	}
	
	/**
	 * 查找属于自己的全部心情
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<moodVO> findAll2(String uname) throws Exception {
		// TODO Auto-generated method stub
		return mooddao.findAll2(uname);
	}
	/**
	 * 按心情id进行删除
	 * @param mid
	 * @throws Exception
	 */
	public void delete2(int mid) throws Exception {
		mooddao.delete2(mid);
	}	
}
