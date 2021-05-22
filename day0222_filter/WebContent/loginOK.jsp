<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인 확인</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	
	if(id.equals("tiger")&&pwd.equals("1234")){
		session.setAttribute("manager", "yes");
		
		response.sendRedirect("list.jsp");
	}else{
		response.sendRedirect("login.jsp");
	}
	
%>
</body>
</html>