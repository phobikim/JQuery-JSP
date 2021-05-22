package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MemberDao_jiny {
	//id, pwd를 매개변수로 전달받아 
	//올바른 회원이면 true를 반환하는 method작성
	
	private static MemberDao_jiny dao;
	
	private MemberDao_jiny() {
		
	}
	
	public static MemberDao_jiny getInstance() {
		if (dao == null) {
			dao = new MemberDao_jiny();
		}
		return dao;
	}
	
	public boolean selectAll(String id, String pwd) throws SQLException{
		boolean flag = false;
		
		String sql = "select pwd from member where id=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			if(pstmt.executeUpdate()>-1) {
				flag = true;
			}
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		
		return flag;
	}
	
}
