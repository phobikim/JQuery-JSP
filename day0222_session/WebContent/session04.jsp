<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션변수(userID) 삭제 후 확인</title>
</head>
<body>
<h4>--------세션을 삭제하기 전--------</h4>
<%
	String user_id = (String)session.getAttribute("userID");
	String user_pwd = (String)session.getAttribute("userPW");
	
	out.print("설정된 세션의 userID " + user_id + "<br>");
	out.print("설정된 세션의 userPW: " + user_pwd + "<br>");
	
	session.removeAttribute("userID");
%>
<h4>--------userID 세션을 삭제한 후---------</h4>
<%
	user_id = (String)session.getAttribute("userID");
	user_pwd = (String)session.getAttribute("userPW");
	
	out.print("설정된 세션의 userID: " + user_id + "<br>");
	out.print("설정된 세션의 userPW: " + user_pwd + "<br>");
%>
</body>
</html>