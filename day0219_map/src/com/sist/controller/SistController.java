package com.sist.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.action.DeleteBookOKAction;
import com.sist.action.DetailBookAction;
import com.sist.action.InsertBookAction;
import com.sist.action.InsertBookOKAction;
import com.sist.action.ListBookAction;
import com.sist.action.SistAction;
import com.sist.action.UpdateBookAction;
import com.sist.action.UpdateBookOKAction;

/**
 * Servlet implementation class SistController
 */

public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 사용자의 서비스명을 key로,
	 * 일처리 담당을 위한 Model객체를 value로 담기 위한 Map선언
	 * 
	 * 일처리 담당을 위한 어떤 Action이라도 담을 수 있도록 
	 * 최상위 Action interface인 SistAction을 설정한다
	 */
	HashMap<String, SistAction> map;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SistController() {
        super();
        // TODO Auto-generated constructor stub
        //생성자에 map을 생성한다
        map = new HashMap<String, SistAction>();
        //map에 서비스명과, 실행할 Action 즉, Model을 담아준다
        map.put("insertBook.do", new InsertBookAction());
        map.put("insertBookOK.do", new InsertBookOKAction());
        map.put("listBook.do", new ListBookAction());
        map.put("detailBook.do", new DetailBookAction());
        map.put("updateBook.do", new UpdateBookAction());
        map.put("updateBookOK.do", new UpdateBookOKAction());
        map.put("deleteBook.do", new DeleteBookOKAction());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		pro(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		pro(request,response);
	}

	private void pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		//사용자가 요청한 서비스명을 파악하기
		String uri = request.getRequestURI();
		
		//예를들면,
		//url : http://localhost:9090/day0218/listBook.do
		//uri : /day0218/listBook.do
		//cmd : listBook.do
		String cmd = uri.substring(uri.lastIndexOf("/") + 1);
		
		//cmd를 key이름으로 전달한다 cmd == 서비스명
		//key값으로 꺼내온 value 즉, 객체를 action에 담아 생성한다
		SistAction action = map.get(cmd);
		String viewPage = action.pro(request, response);
		
		//기능이 여러가지이기 때문에, cmd를 나눠서 action을 걸어야한다
		
		
		//viewPage로 이동하는 코드
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}





