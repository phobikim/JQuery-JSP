<%@page import="com.sist.dao.MemberDao_jiny"%>
<%@page import="com.sist.dao.MemberDao"%>
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
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

//select * from member where id=?, pwd=?
//아이디와 암호를 where절로 조회하여, 조회한 결과가 있다면 true를 반환
MemberDao dao = MemberDao.getInstance();
boolean flag = dao.isMember(id, pwd);

//select pwd from member where id=?
//id하나만 넣어서 조회하여, 조회한 암호와 입력한 암호가 일치하다면 true를 반환
//MemberDao_jiny dao = MemberDao_jiny.getInstance();
//boolean flag = dao.selectAll(id, pwd);

if(flag==true){
	//상태유지
	//session.setAttribute("name", "value");
	session.setAttribute("member", "yes"); //상태유지를 하면서,
	response.sendRedirect("main.jsp"); //main페이지로 이동한다
}else{
	response.sendRedirect("login.html");
}


/* if(id.equals("tiger") && pwd.equals("1234")){
	response.sendRedirect("main.jsp");
}else{
	response.sendRedirect("login.html");
} */

%>

<%=id %>
</body>
</html>