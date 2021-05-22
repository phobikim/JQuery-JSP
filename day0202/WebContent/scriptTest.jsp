<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 태그 연습</title>
</head>
<body>
<!-- declaration(선언문) : 변수, method 선언 -->
<!-- 여기서 변수선언 : member영역 -->
<%!
	int count = 3;
	String makeItLower(String data){
		return data.toLowerCase();
	}
%>

<!-- scriptlet : 코드작성 -->
<!-- 여기서 변수선언 : service method안의 지역변수 -->
<%
	int year = 2021;
	out.print("year: " + year + "<br>");
	out.print("count: " + count + "<br>");
	for(int i=1; i<=count; i++){
		out.print(i + "<br>");
	}
%>

<!-- expression(표현문) :  -->
<%=count %><br>
<%=year %><br>
<%=makeItLower("HELLO WORLD!") %><br>
</body>
</html>