<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="joinOK.jsp" method="post">
		Name : <input type="text" name="name"><br>
		ID : <input type="text" name="id"><br>
		PW : <input type="text" name="pwd"><br>
		Email : <input type="text" name="email"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>