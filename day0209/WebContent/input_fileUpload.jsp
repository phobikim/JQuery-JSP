<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cos.jar의 내장객체를 사용해서 파일 업로드하기</title>
</head>
<body>
<form action="result_fileUpload.jsp" method="post" enctype="multipart/form-data">
	<p>제목 : <input type="text" name="title"></p>
	<p>파일 : <input type="file" name="fileName"></p>
	<p>전송 : <input type="submit" value="확인"></p>
</form>
</body>
</html>