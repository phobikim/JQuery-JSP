<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션변수 확인</title>
</head>
<body>
<%

	// 등록된 세션명을 모를때,
	// 모든 세션을 가져오는 방법
		
	String name;
	String value;
	
	// getAttributeNames() : Returns an Enumeration of String objects
	Enumeration en = session.getAttributeNames();
	
	int i = 0;
	while(en.hasMoreElements()){
		// 세션을 하나씩 가져와서 반복
		i++;
		
		name = en.nextElement().toString();
		// 가져온 name으로 value를 가져온다
		value = session.getAttribute(name).toString();
		
		out.print("설정된 세션의 이름 ["+ i + "] " + name + "<br>");
		out.print("설정된 세션의 값 ["+ i + "] " + value + "<br>");
	}
	
%>
</body>
</html>