<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	//MultipartRequest는 생성자가 다양하기 때문에, 갯수를 잘 생각하여 사용해야한다
	//MultipartRequest multi = new MultipartRequest();
	MultipartRequest multi = new MultipartRequest(
			request, 
			"c:\\upload",
			1024*1024*5,
			"utf-8",
			new DefaultFileRenamePolicy());
	
	String title = multi.getParameter("title");l
	out.print("<h3>"+title+"</h3>");
	
	//선택한 file의 태그name을 가져오는 getFileNames()
	Enumeration files = multi.getFileNames();
	String name = (String)files.nextElement();
	
	//file이름을 가져오는 getFilesystemName(태그이름)
	//String filename = multi.getFilesystemName("fileName");
	String filename = multi.getFilesystemName(name);
	//file의 원본명을 가져오는 getOriginalFileName
	String original = multi.getOriginalFileName(name);

	out.print("태그이름: " + name + "<br>");
	out.print("실제파일이름: " + filename + "<br>");
	out.print("원본파일이름: " + original + "<br>");
%>
</body>
</html>