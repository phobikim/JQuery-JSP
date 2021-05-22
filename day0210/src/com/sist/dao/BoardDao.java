package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.sist.vo.BoardVo;

public class BoardDao {
	
	private static BoardDao dao;
	
	private BoardDao() {
		
	}
	
	public static BoardDao getInstance() {
		if(dao == null) {
			dao = new BoardDao();
		}
		return dao;
	}
	
	/**
	 * DB에 있는 board 테이블에 값을 insert를 하는 일
	 * @param b Board테이블의 레코드값을 담고있는 VO
	 * @return 실행결과를 정수로 반환 실패시 -1 , 성공시 1
	 */
	public int insert(BoardVo b) {
		int re = -1;
		
		String sql = "insert into board values(seq_board.nextval, ?, ?, ?, ?, ?, sysdate, ?, ?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getPwd());
			pstmt.setString(3, b.getTitle());
			pstmt.setString(4, b.getContent());
			pstmt.setString(5, b.getIp());
			pstmt.setInt(6, b.getHit());
			pstmt.setString(7, b.getFname());
			
			re = pstmt.executeUpdate();
			
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
			
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		}
		
		return re;
	}
}
