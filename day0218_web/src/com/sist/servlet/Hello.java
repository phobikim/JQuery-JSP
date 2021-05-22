package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
//@WebServlet("/kim")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response를 통해서, 브라우저의 응답방식을 정해준다
		response.setContentType("text/html;charset=utf-8");
		//html을 출력하기 위해 Stream을 얻어온다
		PrintWriter out = response.getWriter();
		out.print("<h2>Hello</h2>");
		out.print("<ul>");
		out.print("<li>딸기</li>");
		out.print("<li>사과</li>");
		out.print("<li>포도</li>");
		out.print("<li>피자</li>");
		out.print("</ul>");
		//출력을 모두 사용했다면 끊어준다
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
