<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();

	// 모든 쿠키를 삭제하는 코드
	for(int i=0; i<cookies.length; i++){
		
		// 특정 쿠키를 삭제할 때, 이곳에 if문을 활용하여 해당쿠키를 찾아 삭제하면 된다
		
		cookies[i].setMaxAge(0); // 쿠키를 즉시 파기
		// 파기한 쿠키를 클라이언트에게 다시 작성
		response.addCookie(cookies[i]);
		
	}
	// 현재 쿠키를 확인하는 페이지로 이동
	response.sendRedirect("cookie02.jsp");
%>
</body>
</html>