package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BookDao;

public class DeleteBookOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		BookDao dao = BookDao.getInstance();
		int re = dao.delete(no);
		
		String msg = "";
		
		if(re == 1) {
			msg = "도서삭제에 성공하였습니다";
		}else {
			msg = "도서삭제에 실패하였습니다";
		}
		
		request.setAttribute("msg", msg);
		
		return "deleteBookOK.jsp";
	}

}
