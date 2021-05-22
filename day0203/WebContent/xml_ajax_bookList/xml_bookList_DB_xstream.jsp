<%@page import="com.thoughtworks.xstream.XStream"%>
<%@page import="com.sist.vo.BookListVO"%>
<%@page import="com.sist.dao.BookListDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%

	BookListDAO dao = BookListDAO.getInstance();
	ArrayList<BookListVO> list = dao.selectAll();
	XStream xstream = new XStream();
	//자동설정된 태그명을 변경한다
	xstream.alias("book", BookListVO.class);
	
	//생성한 xstream를 가지고 XML형식으로 변경한다 (list를)
	String r = xstream.toXML(list);

%>

<%=r%>