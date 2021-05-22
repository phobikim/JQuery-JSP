<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>도서목록11</h2>
	<a href="insertBook.do">도서등록</a>
	<table border="1" width="80%">
		<tr>
			<td>도서번호</td>
			<td>도서이름</td>
		</tr>
		<c:forEach var="b" items="${list }">
		<!-- b : BookVo의 변수명을 지정 -->
		<!-- ${list} : request에서 상태유지한 list라는 의미 -->
			<tr>
				<%-- 표현식 : <td><%=b.getNo() %></td> --%>
				<%-- 표현언어 : <td>${b.no }</td> --%>
				<td>${b.no }</td>
				<td><a href="detailBook.do?no=${b.no }">${b.name }</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>