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
<!-- Date객체 생성, 자신의 나이를 계산하여 나이와 이름 출력하는 jsp작성 -->
<%
	int birthYear = 1996;
	int thisYear = ((new Date()).getYear())+ 1900;
	int age = thisYear - birthYear + 1;
	String name = "JJiny";
%>


<h1>이름 : <%=name%></h1>
<h2>나이 : <%=age%></h2>
</body>
</html>