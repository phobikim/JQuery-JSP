<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션파기하기</title>
</head>
<body>
<%
	String user_id = (String)session.getAttribute("userID");
	String user_pwd = (String)session.getAttribute("userPW");
	
	out.print("<h4>--------- 설정된 세션을 파기하기 전 ----------</h4>");
	
	out.print("설정된 세션 user_id" + user_id + "<br>");
	out.print("설정된 세션 user_pwd" + user_pwd + "<br><hr>");
	
	
	// isRequestedSessionIdValid() : 세션이 유효한지 묻는 함수
	if(request.isRequestedSessionIdValid()){
		out.print("세션이 유효합니다");
	}else{
		out.print("세션이 유효하지 않습니다");
	}
	
	out.print("<h4>--------- 설정된 세션을 모두 파기하기 ----------</h4>");
	// 세션을 파기하는 함수
	session.invalidate();
	// 세션을 삭제(remove)한다면 조회하였을 때 null이 나오지만
	// 세션을 파기한 후에는 세션을 사용할 수 없다

	if(request.isRequestedSessionIdValid()){
		out.print("세션이 유효합니다");
	}else{
		out.print("세션이 유효하지 않습니다");
	}
	
	// 세션변수를 사용할 수 없기 때문에 세션을 사용하는 코드를 작성할 경우 Error발생
	// java.lang.IllegalStateException: getAttribute: 세션이 이미 무효화되었습니다.
	/* user_id = (String)session.getAttribute("userID");
	user_pwd = (String)session.getAttribute("userPW");
	
	out.print("설정된 세션 user_id" + user_id + "<br>");
	out.print("설정된 세션 user_pwd" + user_pwd + "<br>"); */
	
%>
</body>
</html>