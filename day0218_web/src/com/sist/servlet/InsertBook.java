package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BookDao;
import com.sist.vo.BookVo;

/**
 * Servlet implementation class Book
 */

public class InsertBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//도서정보를 입력받기 위한 form 태그를 생성하는 서블릿 생성
		String str = "<form action='insertBook' method='post'>";
		//form태그를 전송하면, post방식의 insertBook으로 전송된다 즉, doPost메소드로 호출된다
		str += "도서번호 : <input type='text' name='no'><br>";
		str += "도서이름 : <input type='text' name='name'><br>";
		str += "출판사명 : <input type='text' name='publisher'><br>";
		str += "도서가격 : <input type='text' name='price'><br>";
		str += "<input type='submit' value='등록'>";
		str += "</form>";
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(str);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		String publisher = request.getParameter("publisher");
		int price = Integer.parseInt(request.getParameter("price"));
		
		BookVo b = new BookVo(no, name, publisher, price);
		BookDao dao = BookDao.getInstance();
		int re = dao.insert(b);
		
		String str = "도서를 등록하였습니다";
		
		if(re != 1) {
			str = "도서 등록에 실패하였습니다";
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(str);
		out.close();
	}

}
