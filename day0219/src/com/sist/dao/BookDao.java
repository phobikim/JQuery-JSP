package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BookVo;

public class BookDao {
	private static BookDao dao;

	private BookDao() {

	}

	public static BookDao getInstance() {
		if (dao == null) {
			dao = new BookDao();
		}
		return dao;
	}

	/**
	 * 입력받은 도서정보로 수정하는 일 
	 * @param b 기준이 되는 도서번호 (도서번호는 변경하지 않는다 = primary key)
	 * @return 수정성공 여부를 반환한다
	 */
	public int update(BookVo b){
		int re = -1;
		
		String sql = "update book set name=?, publisher=?, price=? where no=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection con = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, b.getName());
			pstmt.setString(2, b.getPublisher());
			pstmt.setInt(3, b.getPrice());
			pstmt.setInt(4, b.getNo());
			re = pstmt.executeUpdate();

			if (pstmt != null) {
				pstmt.close();
			}

			if (con != null) {
				con.close();
			}
			
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		}
		
		return re;
	}
	
	/**
	 * 도서번호를 매개변수로 받아 해당 도서정보를 삭제하는 일
	 * @param no 삭제할 도서번호
	 * @return 성공여부 성공시 1을 반환한다
	 */
	public int delete(int no) {
		int re = -1;
		String sql = "delete from book where no=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection con = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			re = pstmt.executeUpdate();

			if (pstmt != null) {
				pstmt.close();
			}

			if (con != null) {
				con.close();
			}
			
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		}
		
		return re;
	}
	
	/**
	 * 도서번호를 매개변수로 받아서, 
	 * 도서번호에 해당하는 레코드를 조회하는 일
	 * @param no 도서번호
	 * @return 도서번호에 해당하는 도서정보가 담긴 VO
	 */
	public BookVo getBook(int no) {
		String sql = "select * from book where no=?";
		BookVo b = new BookVo();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection con = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				b.setNo(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPublisher(rs.getString(3));
				b.setPrice(rs.getInt(4));
			}

			if (rs != null) {
				rs.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}

			if (con != null) {
				con.close();
			}
			
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		}

		return b;
	}

	public int insert(BookVo b) {
		int re = -1;

		String sql = "insert into book values(?, ?, ?, ?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection con = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b.getNo());
			pstmt.setString(2, b.getName());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getPrice());
			re = pstmt.executeUpdate();

			if (pstmt != null) {
				pstmt.close();
			}

			if (con != null) {
				con.close();
			}

		} catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}

		return re;
	}

	public ArrayList<BookVo> findAll() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		String sql = "select * from book";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection con = DriverManager.getConnection(url, user, pwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BookVo b = new BookVo();
				b.setNo(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPublisher(rs.getString(3));
				b.setPrice(rs.getInt(4));
				list.add(b);
			}

			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}

		return list;
	}

}
