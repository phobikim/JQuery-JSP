package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SistController
 */

public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//front Controller 사용해보기
		//utf-8로 인코딩해준다
		//response.setContentType("text/html;charset=utf-8");
		//출력하는 객체생성
		//PrintWriter out = response.getWriter();
		//out.print("hello");
		//System.out.println("컨트롤러가 동작하였습니다_front Controller");
		
		//사용자가 요청한 url을 알아보기
		//String url = request.getRequestURL().toString();
		//System.out.println("사용자가 요청한 url : " + url);
		
		//사용자가 요청한 uri를 알아보기 : 프로젝트명/파일명
		String uri = request.getRequestURI().toString();
		System.out.println("사용자가 요청한 uri : " + uri);
		
		//사용자가 요청한 uri에서 파일명만 담기
		//listIndexOf() : 오른쪽에서부터 문자열을 찾아 인덱스를 반환한다
		//substring() : 인자하나인경우_해당 인덱스부터 문자열을 자른다
		String cmd = uri.substring( uri.lastIndexOf("/")+1 );
		System.out.println(cmd);
		
		//보여질 view페이지를 사용자의 요구에 따라 설정
		String viewPage = "";
		if(cmd.equals("listBook.do")) {
			viewPage = "listBook.jsp";
		}else if(cmd.equals("insertBook.do")) {
			viewPage = "insertBook.jsp";
		}
		
		//viewPage를 이동시켜준다
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		
		//forward가 request, response 즉, 사용자의 요청을 가지고 이동한다
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
