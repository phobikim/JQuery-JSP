package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BoardVO;

public class BoardDAO {

	private static BoardDAO dao;
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	public int insert(BoardVO vo) {
		int re = -1;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "insert into board values(seq_board.nextval, ?, ?, ?, ?, ?, sysdate, 0)";
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getIp());
			
			re = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}finally {
			ConnectionProvider.close(con, pstmt, null);
		}
		
		return re;
	}
	
	public ArrayList<BoardVO> selectBoard(){
		String sql = "select * from board";
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionProvider.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO b = new BoardVO();
				b.setNo(rs.getInt(1));
				b.setWriter(rs.getString(2));
				b.setPwd(rs.getString(3));
				b.setTitle(rs.getString(4));
				b.setContent(rs.getString(5));
				b.setIp(rs.getString(6));
				b.setRegdate(rs.getTimestamp(7));
				b.setHit(rs.getInt(8));
			}
			
		}catch(Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}finally {
			ConnectionProvider.close(con, stmt, null);
		}
		
		
		
		return list;
	}
	
}
