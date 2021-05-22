<%@page import="java.io.File"%>
<%@page import="com.sist.dao.GoodsDao"%>
<%@page import="com.sist.vo.GoodsVo"%>
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
	String path = request.getRealPath("upload");
	MultipartRequest multi = new MultipartRequest(
			request,
			path,
			1024*1024*5,
			"utf-8",
			new DefaultFileRenamePolicy());
	
	int no = Integer.parseInt(multi.getParameter("no"));
	String name = multi.getParameter("name");
	int qty = Integer.parseInt(multi.getParameter("qty"));
	int price = Integer.parseInt(multi.getParameter("price"));
	String fname = multi.getParameter("fname");
	
	String upload = multi.getFilesystemName("upload");
	
	out.print("상품번호: " + no + "<br>");
	out.print("상품이름: " + name + "<br>");
	out.print("상품수량: " + qty + "<br>");
	out.print("상품가격: " + price + "<br>");
	out.print("원본파일: " + fname + "<br>");
	out.print("수정파일: " + upload + "<br>");
	
	GoodsVo g = new GoodsVo();
	g.setNo(no);
	g.setName(name);
	g.setQty(qty);
	g.setPrice(price);
	g.setFname(fname);
	
	if(upload != null){//사진을 선택하지 않으면 null값이 담기기 때문에
		g.setFname(upload);
		//수정할때, 사진도 수정하게 된다면
		//새로선택한 사진으로 파일을 변경한다
	}
	
	GoodsDao dao = GoodsDao.getInstance();
	int re = dao.update(g);
	if(re == 1){//상품수정을 성공
		if(upload != null){//사진을 수정했다면, 원본파일은 삭제해준다
			File file = new File(path + "/" + fname);
			file.delete();
		}
		response.sendRedirect("goods_list.jsp");
	}else{
		out.print("상품수정에 실패하였습니다");
	}
	
%>


</body>
</html>