<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="process.jsp" method="post">
		<p>아이디 : <input type="text" name="id"></p>
		<p>암호 : <input type="text" name="pwd"></p>
		<p>이름 : <input type="text" name="irum"></p>
		<p>취미 : 
			<input type="checkbox" name="hobby" value="마라톤">마라톤
			<input type="checkbox" name="hobby" value="클라이밍">클라이밍
			<input type="checkbox" name="hobby" value="게임">게임
			<input type="checkbox" name="hobby" value="필라테스">필라테스
		</p>
		<p>성별 : 
			<input type="radio" name="gender" value="여자">여자
			<input type="radio" name="gender" value="남자">남자
		</p>
		<p>
			직업 : 
			<select name="job">
				<option value="학생">학생</option>
				<option value="취준생">취준생</option>
				<option value="회사원">회사원</option>
				<option value="운동선수">운동선수</option>
			</select>
		</p>
		<p>자기소개<br>
			<textarea rows="10" cols="80" name="info"></textarea>
		</p>
		<input type="submit" value="전송">
	</form>
</body>
</html>