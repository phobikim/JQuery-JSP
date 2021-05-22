package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.sist.vo.BookVo;

public class BookDao {
	private static BookDao dao;
	
	private BookDao() {
		
	}
	
	public static BookDao getInstance() {
		if(dao == null) {
			dao = new BookDao();
		}
		return dao;
	}
	
	public int insert(BookVo b) {
		int re = -1;
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String pwd = "tiger";
		
		String sql = "insert into book values(?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b.getNo());
			pstmt.setString(2, b.getName());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getPrice());
			
			re = pstmt.executeUpdate();
			
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
			
		}catch(Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		}
		
		return re;
	}
}
