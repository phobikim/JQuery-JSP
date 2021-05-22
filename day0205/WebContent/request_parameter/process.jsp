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

	String method = request.getMethod(); //get, post방식을 확인할 수 있는 method
	request.setCharacterEncoding("UTF-8");

	//값이 하나가 반환될 때, request.getParameter _ String
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("irum");
	
	//값이 여러개가 반환될 때, request.getParameterValues _ String[]
	String[] hobby = request.getParameterValues("hobby");
	
	String gender = request.getParameter("gender");
	String job = request.getParameter("job");
	String info = request.getParameter("info");
	

%>
<p>요청방식 : <%=method %></p>
<p>요청정보 길이 : <%=request.getContentLength() %></p>
<p>요청 URL : <%=request.getRequestURL() %></p>
<p>요청 URI : <%=request.getRequestURI() %></p>
<p>서버이름 : <%=request.getServerName() %></p>
<p>서버포트 : <%=request.getServerPort() %></p>
<p>IP주소 : <%=request.getRemoteAddr() %></p>

<hr>

<p>ID : <%=id %></p>
<p>PWD : <%=pwd %></p>
<p>이름 : <%=name %></p>
<p>취미 :
<%
	if(hobby != null){
		for(String h: hobby){
			out.print(h + " ");
		}
	}
%>
</p>
<p>성별 : <%=gender %></p>
<p>직업 : <%=job %></p>
<p>자기소개 : <%=info %></p>
</body>
</html>