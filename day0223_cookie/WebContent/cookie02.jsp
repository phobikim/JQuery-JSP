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
	// 클라이언트가 요청한 모든 쿠키 불러오기
	// request.getCookies() : 쿠키를 배열로 반환해주는 method
	Cookie[] cookies = request.getCookies();

	// 쿠키를 삭제한 경우, NullPointException이 발생하기 때문에 if문안에 조건을 작성해준다
	if(cookies != null){ 
		out.println("현재 설정된 쿠키의 총개수: " + cookies.length + "<br>");
		out.println("======================================<br>");
		
		// 배열을 쿠키갯수만큼 반복하여, 해당쿠키를 찾는다
		for(int i=0; i<cookies.length; i++){
			// getName() : 해당 쿠키의 이름을 String으로 반환해준다
			// getValue() : 해당 쿠키의 값을 반환해준다
			out.println("쿠키이름: " + cookies[i].getName() + "<br>");
			out.println("쿠키값: " + cookies[i].getValue() + "<br>");
			out.println("-------------------------------------<br>");
		}
	}
	
%>

<a href="cookie03.jsp">모든 쿠키 삭제하기</a>
</body>
</html>