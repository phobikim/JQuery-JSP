<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>이 파일은 first.jsp입니다</h3>
	<!-- 이미 있는 다른 페이지의 내용을 포함시키기 위해 actionTag_include를 사용할 수 있다 -->
	<!-- 지시자 include : 서블릿이 하나만 만들어진다 (호출하는 페이지의 서블릿만) -->
	<!-- 액션태그 include : 서블릿이 별도로 만들어지고 그것의 실행결과가 포함된다(호출하는, 호출되는 페이지 서블릿 , second의 결과를 포함) -->
	<jsp:include page="second.jsp"/>
	<p>Java Server Page</p>
</body>
</html>