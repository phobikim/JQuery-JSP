<%@page import="com.sist.vo.Company"%>
<%@page import="java.util.ArrayList"%>
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
	ArrayList<Company> list = new ArrayList<Company>();
	list.add(new Company(1, "naver", "http://www.naver.com"));
	list.add(new Company(2, "daum", "http://www.daum.net"));
	list.add(new Company(3, "google", "http://www.google.com"));
%>
	<ul>
<%
	for(Company c: list){
%>
	<li>
		<a href=<%=c.getUrl() %>><%=c.getName() %></a>
	</li>
<%
	}
%>
	</ul>

</body>
</html>