<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션변수 확인</title>
</head>
<body>
<%

	// 등록된 세션명을 알고 있을 때, 세션을 가져오는 방법
	
	String user_id = (String)session.getAttribute("userID");
	String user_pwd = (String)session.getAttribute("userPW");
	out.print("설정된 세션의 속성값[1]: " + user_id + "<br>");
	out.print("설정된 세션의 속성값[2]: " + user_pwd + "<br>");
%>
</body>
</html>