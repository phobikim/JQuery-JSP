<%@page import="com.thoughtworks.xstream.XStream"%>
<%@page import="com.sist.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.MemberDao"%>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberDao dao = MemberDao.getInstance();
	ArrayList<MemberVO> list = dao.findAll();
	XStream xstream = new XStream();
	xstream.alias("member", MemberVO.class);
	String r = xstream.toXML(list);
%>

<%=r%>