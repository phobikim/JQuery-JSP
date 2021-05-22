<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
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

	int[] lastDate = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	String year = request.getParameter("year");
	String month = request.getParameter("month");
	System.out.println("요청한 년도: " + year);
	System.out.println("요청한 월: " + month);

	String[] day_str = {"일", "월", "화", "수", "목", "금", "토"};
	Date today = new Date();
	int thisYear = today.getYear();
	int thisMonth = today.getMonth();
	
	int yoil = (new Date(thisYear, thisMonth, 1)).getDay(); //요일
	
	
%>
<h2><%=thisYear+1900 %>년 <%=thisMonth+1 %>월</h2>

<!-- 나의 페이지로 다시 돌아오게하기 -->
<!-- ?변수명=값&변수명=값   : 공백없이-->
<a href="calendarTest.jsp?year=<%=thisYear%>&month=<%=thisMonth+3%>">다음달</a>

<table border="1">
		<tr>
<%
	for(String day: day_str){
		%>
		<th><%=day %></th>
		<%
	}
	
	%></tr><tr><%
	
	for(int i=1; i<=yoil; i++){
		%>
		<td>&nbsp;</td>
		<%
	}
	
	for(int i=1; i<=lastDate[thisMonth]; i++){
		%>
		<td>
		<%=i%>
		</td>
		<%
		if((yoil+i)%7 == 0){
			%></tr><tr><%
		}
	}
%>
		</tr>
</table>
</body>
</html>