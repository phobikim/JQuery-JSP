<%@page import="java.util.Date"%>
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
	Date date1 = new Date();
%>
<jsp:useBean id="date" class="java.util.Date"/>
오늘의 날짜~! <%=date %>
</body>
</html>