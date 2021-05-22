<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#btnRead").click(function() {
		$("#bookList").html("");
		$.ajax({url:"xml_bookList_DB_xstream.jsp", success:function(data){
			//ajax통신을 통해, DB의 데이터를 가져온다
			//bookList라고 변경한 레코드값들을 가져와 담는다
			let book_list = $(data).find("book");
			$.each(book_list, function(index, bookList) {
				//변수에 bookList의 레코드명으로 검색하여 값을 담는다
				let no = $(this).find("no").text();
				let name = $(this).find("name").text();
				let publisher = $(this).find("publisher").text();
				let price = $(this).find("price").text();
				
				//태그를 생성하고, 담는다
				let tr = $("<tr></tr>");
				$("<td></td>").html(no).appendTo(tr);
				$("<td></td>").html(name).appendTo(tr);
				$("<td></td>").html(publisher).appendTo(tr);
				$("<td></td>").html(price).appendTo(tr);
				
				//tr에 담은 것을 생성한 tbody에 id로 접근하여 담는다
				$("#bookList").append(tr);
			})
			
		}})
	})
		
})
</script>
</head>
<body>
<div class="navbar navbar-expand navbar_dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="./welcome.jsp">Home</a>
		</div>
	</div>
</div>

<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">
			Welcome to Web Shopping Mall
		</h1>
	</div>
</div>

<main role="main">
	<div class="container">
		<div class="text-center">
			<h3>
				Welcome to Web Market!
			</h3>
		</div>
	</div>

	<div class="container">
		<button id="btnRead">책 목록 읽어오기</button>
		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<td>번호</td>
					<td>이름</td>
					<td>출판사</td>
					<td>가격</td>
				</tr>
			</thead>
			<tbody id="bookList"></tbody>
		</table>
	</div>
</main>

<footer class="container">
	<p>&copy; WebMarket</p>
</footer>

</body>
</html>