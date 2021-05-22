package com.sist.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BookListVO;

public class BookListDAO {

	private static BookListDAO dao;

	private BookListDAO() {

	}

	public static BookListDAO getInstance() {
		if (dao == null) {
			dao = new BookListDAO();
		}
		return dao;
	}

	public int deleteBook(int no) throws SQLException {//VO���θ� �����ʰ�, ��ȣ�� �޴´�
		int result = -1;
		String sql = "delete book where no=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate(); //���������� ��ȯ�� ���ڵ��� ���� ��ȯ�Ѵ�
			
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
			
		}
		
		return result;
	}
	
	public int updateBook(BookListVO bVO) throws SQLException {
		int result = -1;
		String sql = "update book set name=?, publisher=?, price=? where no=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			//���ε庯���� ������
			//������  VO���� �����´�
			pstmt.setString(1, bVO.getName());
			pstmt.setString(2, bVO.getPublisher());
			pstmt.setInt(3, bVO.getPrice());
			pstmt.setInt(4, bVO.getNo());
			
			result = pstmt.executeUpdate(); //���������� ��ȯ�� ���ڵ��� ���� ��ȯ�Ѵ�
			
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
			
		}
		
		return result;
	}
	public int insertBook(BookListVO bVO) throws SQLException {
		int result = -1;
		String sql = "insert into book values(?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			//���ε庯���� ������
			//������  VO���� �����´�
			pstmt.setInt(1, bVO.getNo());
			pstmt.setString(2, bVO.getName());
			pstmt.setString(3, bVO.getPublisher());
			pstmt.setInt(4, bVO.getPrice());
			
			result = pstmt.executeUpdate(); //���������� ��ȯ�� ���ڵ��� ���� ��ȯ�Ѵ�
			
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
			
		}
		
		return result;
	}
	
	public ArrayList<BookListVO> selectAll() throws SQLException{
		String sql = "select * from book";
		ArrayList<BookListVO> list = new ArrayList<BookListVO>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//no, name, publisher, price
				list.add(new BookListVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			
		}finally {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		
		
		return list;
	}
	
}
