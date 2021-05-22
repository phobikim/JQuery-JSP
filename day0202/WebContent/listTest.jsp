<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("김포비");
	list.add("김밍키");
	list.add("박열무");
	list.add("박자두");
	list.add("남정수");
	list.add("신지유");
	out.print(list);
%>
<hr>
<%=list %>
</body>
</html>