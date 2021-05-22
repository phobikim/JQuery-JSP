<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<h3>회원가입</h3>
<form action="#" method="post" name="member">
	<p>아이디 : <input type="text" name="id"><input type="button" value="아이디 중복 검사"></p>
	<p>비밀번호 : <input type="password" name="pwd"></p>
	<p>이름 : <input type="text" name="name"></p>
	<p>연락처 : 
		<select name="phone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="019">019</option>
		</select>
		-
		<input type="text" maxlength="4" size="4" name="phone2">-
		<input type="text" maxlength="4" size="4" name="phone3">
	</p>
	<p>성별 : 
		<input type="radio" name="gender" value="여성" checked>여성
		<input type="radio" name="gender" value="남성">남성</p>
	<p>혈액형 :
		<input type="radio" name="bloodType" value="A">A
		<input type="radio" name="bloodType" value="B">B
		<input type="radio" name="bloodType" value="AB">AB
		<input type="radio" name="bloodType" value="O" checked>O
	</p>	
	<p>취미 : 
		독서<input type="checkbox" name="hobby1">
		운동<input type="checkbox" name="hobby2"checked>
		영화<input type="checkbox" name="hobby3">
	</p>
	
	<p>지역 : 
		<select name="city" size="1">
			<option value="서울">서울특별시</option>
			<option value="경기">경기도</option>
			<option value="인천">인천광역시</option>
			<option value="충청">충청도</option>
			<option value="전라">전라도</option>
			<option value="경상">경상도</option>
			<option value="제주">제주도</option>
		</select>
	</p>
	
	<p>
		<textarea name="comment" rows="3" cols="30" placeholder="가입인사를 작성해주세요"></textarea>
	</p>
	
	<p>
		<input type="submit" value="가입하기">
		<input type="reset" value="다시쓰기">
	</p>
</form>

</body>
</html>