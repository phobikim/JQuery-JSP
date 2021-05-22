<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Lotto 번호 생성기 -->
	<!-- 중복제거를 위해 set을 사용 -->
	<%
	TreeSet<Integer> set = new TreeSet<Integer>();//중복되지 않는 자료, 정렬
	Random r = new Random();//난수발생

/* 	while (true) {//조건달성까지 무한반복
		int n = r.nextInt(45) + 1;//1~45 난수
		set.add(n);//중복값은 담기지 않기 때문에 중복되지 않는 난수가 담긴다
		if (set.size() < 6) {//set의 크기가 6개 될때까지 반복하게 조건
			break;//중복되지 않는 수가 6개담기면 while문이 종료된다
		}
	} */
	while (set.size() < 6) {//중복되지 않는 수가 6개담기면 while문이 종료된다
		int n = r.nextInt(45) + 1;//1~45 난수
		set.add(n);//중복값은 담기지 않기 때문에 중복되지 않는 난수가 담긴다
	}
	%>
	<h2>이번주 추첨 로또번호</h2>
	<h3><%=set %></h3>

</body>
</html>