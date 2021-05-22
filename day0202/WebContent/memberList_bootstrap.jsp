<%@page import="com.sist.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<Member> list = new ArrayList<Member>();
	list.add(new Member(1, "이순신", 20, "서울", "010-1111-1111"));
	list.add(new Member(2, "김밍키", 10, "부산", "010-2222-1111"));
	list.add(new Member(3, "박열무", 25, "대구", "010-1111-4444"));
	list.add(new Member(4, "김포비", 35, "인천", "010-1111-5555"));
	list.add(new Member(5, "안영지", 50, "광주", "010-7777-1111"));
	
	out.print("<table class='table table-hover'>");
	out.print("<tr><th>번호</th><th>이름</th><th>나이</th><th>주소</th><th>tel</th></tr>");
	for(Member m: list){
		%>
		<tr>
			<td><%= m.getNo()%></td>
			<td><%= m.getName()%></td>
			<td><%= m.getAge()%></td>
			<td><%= m.getAddr()%></td>
			<td><%= m.getTel()%></td>
		</tr>
		<%
		
		
	}
	
	out.print("</table>");
	
%>
</body>
</html>