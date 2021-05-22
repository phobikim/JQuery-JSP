<%@page import="java.util.Enumeration"%>
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
	//모든 header의 종류를 알아보기
	//getHeaderNames() : 모든 header의 이름을 Enumeration으로 반환해주는 method
	Enumeration en = request.getHeaderNames();

	//en 에는 헤더 이름이 담겨있는 배열이라고 생각하면 이해하기 쉽다
	while(en.hasMoreElements()){
		//헤더 이름을 담아준다
		String headerName = (String)en.nextElement();
		//헤더 이름으로 헤더를 검색하여 담아준다
		String headerValue = request.getHeader(headerName);
		%>
		<%=headerName %> : <%=headerValue %><br>
		<%
	}
%>
</body>
</html>