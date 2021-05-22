package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sist.db.ConnectionProvider;
import com.sist.vo.MemberVo;


public class MemberDao {
	//id, pwd를 매개변수로 전달받아 
	//올바른 회원이면 true를 반환하는 method작성
	
	private static MemberDao dao;
	
	private MemberDao() {
		
	}
	
	public static MemberDao getInstance() {
		if (dao == null) {
			dao = new MemberDao();
		}
		return dao;
	}
	
	public boolean isMember(String id, String pwd) throws SQLException{
		boolean flag = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from member where id=? and pwd=?";
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {//매개변수로 받은 id, pwd로 조회를 수행하면, rs에 1이담긴다
				flag = true;
			}
			
		}catch(Exception e) {
			System.out.println("예외발생: " + e.getMessage());		
		}finally {
			ConnectionProvider.close(con, pstmt, rs);
		}
		
		return flag;
	}
	
	public int insert(MemberVo m) {
		int re = -1;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into member values(?, ?, ?, ?)";
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getPwd());
			pstmt.setString(4, m.getEmail());
			
			re = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}finally {
			ConnectionProvider.close(con, pstmt, null);
		}
		
		
		return re;
	}
	
}
