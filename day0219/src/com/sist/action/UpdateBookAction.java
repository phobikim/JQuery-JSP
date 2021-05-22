package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BookDao;
import com.sist.vo.BookVo;

public class UpdateBookAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//수정할 도서번호를 받는다
		int no = Integer.parseInt(request.getParameter("no"));
		
		BookDao dao = BookDao.getInstance();
		BookVo b = dao.getBook(no);
		
		//도서번호를 통해 가져온, 도서정보를 상태유지하여 updateBook을 하기 위해 이동한다
		request.setAttribute("b", b);
		
		return "updateBook.jsp";
	}

}
