<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션의 유효시간 설정 및 확인</title>
</head>
<body>
<h4>------------세션 유효시간 변경 전------------</h4>

<%
	int time = session.getMaxInactiveInterval()/60;
	out.print("세션 유효 시간 : " + time + "분<br>");
%>

<h4>------------세션 유효시간 변경 후------------</h4>
<%
	// 세션 유효시간을 변경
	// 1시간으로 변경
	session.setMaxInactiveInterval(60*60);

	time = session.getMaxInactiveInterval()/60;
	out.print("세션 유효 시간 : " + time + "분<br>");
%>
</body>
</html>