<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 유지 시간</title>
</head>
<body>
<%

	// 식별하기 위해 사용하는 ID
	// browser를 닫기 전까지는 동일한 session ID를 가진다
	// getID를 통해 가져올 수 있다
	// browser마다 별도의 아이디를 가진다(ex: InternetExplorer 와 chrome의 아이디가 다르다)
	String session_id = session.getId();

	out.print("세션아이디 : " + session_id + "<br>");
%>
</body>
</html>