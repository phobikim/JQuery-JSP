<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- scope="request"는 다음 요청이 올때까지 정보 유지 -->
<!-- useBean03 에서도 scope=request로 설정. default=page -->
<jsp:useBean id="person" class="com.sist.bean.Person" scope="request"/>
<p>아이디 : <%= person.getId() %></p>
<p>이름 : <%= person.getName() %></p>
<%
	person.setId(20202020);
	person.setName("홍길똥!");
%>
<jsp:include page="useBean03.jsp"/>
</body>
</html>