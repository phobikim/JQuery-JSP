<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
 
	first페이지에서 전달받은<Br>
	Title : <%= request.getParameter("title") %><br>
<%--Name : <%= request.getParameter("name") %><br> --%>
	Name : <%= URLDecoder.decode(request.getParameter("name")) %><br>
	Year : <%= request.getParameter("year") %><br>
	Date : <%= request.getParameter("date") %><br>
 	
</body>
</html>