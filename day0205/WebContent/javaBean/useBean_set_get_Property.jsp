<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="p" class="com.sist.bean.Person"/>
	<%
		//p.setName("콘프로스트");
		//p.setId(201234);
	%>
	<!-- p의 name을 콘프로스트으로 변경 -->
	<jsp:setProperty property="name" name="p" value="콘프로스트"/>
	<jsp:setProperty property="id" name="p" value="201234"/>
	
	아이디: <%=p.getId() %><br>
	이름: <%= p.getName()%><br>
	<hr>
	<!-- p.getId() -->
	아이디: <jsp:getProperty property="id" name="p" /><br>
	이름: <jsp:getProperty property="name" name="p" /><br>
</body>
</html>