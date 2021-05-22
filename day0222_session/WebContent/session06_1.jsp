<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 파기 후 새로운 세션연결 설정하기(로그아웃-재로그인)</title>
</head>
<body>
<%
	// 세션을 파기하기 (ex: 로그아웃)
	session.invalidate();

	// 새로운 세션연결 설정하기 (ex: 로그인)
	response.sendRedirect("session01.jsp");
%>
</body>
</html>