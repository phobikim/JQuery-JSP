<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
	<jsp:forward page="forward_second_param.jsp">
		<jsp:param value="jjiny" name="title"/>
		<jsp:param value='<%=URLEncoder.encode("홍길동") %>' name="name"/>
		<jsp:param value="2021" name="year"/>
		<jsp:param value="<%= new Date()%>" name="date"/>
	</jsp:forward>
	<hr>
	<h2>여기는 forward_first_param.jsp 페이지 입니다</h2>
	<h2>forward액션태그 안에서, param사용하기</h2>
</body>
</html>