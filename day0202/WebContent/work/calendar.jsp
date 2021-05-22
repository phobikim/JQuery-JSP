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
<table border="1">
		<tr>
<%
	Date today = new Date();
	String[] day = {"일", "월", "화", "수", "목", "금", "토"};
	
	int month = today.getMonth()+1;
	int year = today.getYear()+1900;
	today.setDate(1);
	int firstDay = today.getDay();
	
	Calendar cal = Calendar.getInstance();
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
%>

	<h2><%=year %>년 <%=month %>월 달력</h2>

<%
	//일 - 0 토 - 6
	
	for(String v: day){
		%>
		<th><%=v %></th>
		<%
	}
	
	%></tr><tr><%
	
	for(int i=firstDay; i<=lastDay; i++){
		%>
		<td>
		<%=i%>
		</td>
		<%
		if(i%7 == 0){
			%></tr><tr><%
		}
	}
%>
		</tr>
</table>
</body>
</html>