<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink">

<%
	String member = (String)session.getAttribute("member");
	//session에는 다양한 자료형을 담을 수 있다.
	//따라서 object로 반환하기 때문에 casting해주어야한다
	if(member == null){
		response.sendRedirect("login.html");
	}
	
%>

	서비스 되는 문서입니다
</body>
</html>