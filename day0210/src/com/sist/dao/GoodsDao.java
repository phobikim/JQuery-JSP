package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.GoodsVo;

public class GoodsDao {
	private static GoodsDao dao;
	private GoodsDao() {		
	}
	
	public static GoodsDao getInstance()
	{
		if(dao == null) {
			dao = new GoodsDao();
		}
		return dao;
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "scott";
	String pwd = "tiger";
	
	public int update(GoodsVo g) {
		int re = -1;
		
		try {
			String sql = "update goods set name=?, qty=?, price=?, fname=? where no=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, g.getName());
			pstmt.setInt(2, g.getQty());
			pstmt.setInt(3, g.getPrice());
			pstmt.setString(4, g.getFname());
			pstmt.setInt(5, g.getNo());
			
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
	
	/**
	 * 상품번호를 매개변수로 전달받아
	 * 해당 상품을 삭제하는 일
	 * @param no 상품번호
	 * @return 성공여부를 정수로 반환
	 */
	public int deleteByNo(int no) {
		int re = -1;
		String sql = "delete goods where no=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
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
	
	/**
	 * 상품번호를 매개변수로 전달받아
	 * 해당상품의 정보를 데이터베이스 테이블 goods로부터
	 * 검색하여 GoodsVo로 포장하여 반환하는 일
	 * @param no 상품번호
	 * @return 해당상품의 정보
	 */
	public GoodsVo findByNo(int no) {
		GoodsVo g = new GoodsVo();
		String sql = "select * from goods where no=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//바인드변수에 값 담기
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				//현재 resultset이 바라보는 레코드 값을 vo에 넣는다
				g.setNo(rs.getInt(1));
				g.setName(rs.getString(2));
				g.setQty(rs.getInt(3));
				g.setPrice(rs.getInt(4));
				g.setFname(rs.getString(5));
			}
			
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
			
		}catch(Exception e) {
			System.out.println("예외발샐 : " + e.getMessage());		}
		return g;
	}
	
	/**
	 * 상품정보를 모두 select하여 ArrayList로 반환하는 일
	 * @return ArrayList로 반환한다
	 */
	public ArrayList<GoodsVo> findAll(){
		ArrayList<GoodsVo> list = new ArrayList<GoodsVo>();
		String sql = "select * from goods";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection(url, id, pwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				GoodsVo g = new GoodsVo();
				g.setNo(rs.getInt(1));
				g.setName(rs.getString(2));
				g.setQty(rs.getInt(3));
				g.setPrice(rs.getInt(4));
				g.setFname(rs.getString(5));
				list.add(g);
			}
			
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(con != null) {
				con.close();
			}
			
		}catch(Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
		
		
		return list;
	}
	
	public int insert(GoodsVo g) {
		int re = -1;
		String sql = "insert into goods values(?,?,?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url, user,pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, g.getNo());
			pstmt.setString(2, g.getName());
			pstmt.setInt(3, g.getQty());
			pstmt.setInt(4, g.getPrice());
			pstmt.setString(5, g.getFname());
			re = pstmt.executeUpdate();
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
}














