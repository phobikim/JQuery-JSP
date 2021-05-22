<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 구구단 2단 -->

<%
	//out객체 없이 출력
	int dan = 2;
	int result = 0;

	for(int i=1; i<=9; i++){
		result = dan * i;
		%>
		<%=dan %> x <%=i %> = <%=result %><br><%
	}
	
	out.print("<hr>");
	//out객체 사용해서 출력
	
	dan = 3;
	for(int i=1; i<=9; i++){
		out.print(dan + " x " + i + " = " + (dan*i) + "<br>");
	}

%>

</body>
</html>