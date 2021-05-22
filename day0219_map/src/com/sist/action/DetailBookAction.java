package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BookDao;
import com.sist.vo.BookVo;

public class DetailBookAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//상세보기를 할 도서번호를 담는다
		int no = Integer.parseInt(request.getParameter("no"));

		BookDao dao = BookDao.getInstance();
		//vo를 반환하는 getBook의 인자로 도서번호를 전달한다
		BookVo b = dao.getBook(no);
		
		//상태유지를 해서, jsp로 전달한다
		request.setAttribute("b", b);
		
		return "detailBook.jsp";
	}

}
