package com.sist.controller;

import java.io.IOException;

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
		
		
		//ListBookAction action = new ListBookAction();
		//이렇게 사용해도 돼고, 
		//SistAction action = new ListBookAction();
		//이렇게 사용해도 된다 따라서, 모든 action이 SistAction 을 상속하므로 
		//최상위 액션을 선언하여, 사용한다
		
		SistAction action;
		String viewPage = "";
		
		//기능이 여러가지이기 때문에, cmd를 나눠서 action을 걸어야한다
		if(cmd.equals("listBook.do")) {
			action = new ListBookAction();
			//ListBookAction이 Overriding한 pro() : listBook.jsp를 반환한다
			viewPage = action.pro(request, response);
		}else if(cmd.equals("insertBook.do")) {
			action = new InsertBookAction();
			viewPage = action.pro(request, response);
		}else if(cmd.equals("insertBookOK.do")) {
			action = new InsertBookOKAction();
			viewPage = action.pro(request, response);
		}else if(cmd.equals("detailBook.do")) {
			action = new DetailBookAction();
			viewPage = action.pro(request, response);
		}else if(cmd.equals("deleteBook.do")) {
			action = new DeleteBookOKAction();
			viewPage = action.pro(request, response);
		}else if(cmd.equals("updateBook.do")) {
			action = new UpdateBookAction();
			viewPage = action.pro(request, response);
		}else if(cmd.equals("updateBookOK.do")) {
			action = new UpdateBookOKAction();
			viewPage = action.pro(request, response);
		}
		
		//viewPage로 이동하는 코드
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}





