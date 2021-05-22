<%@page import="java.io.File"%>
<%@page import="com.sist.dao.GoodsDao"%>
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

	//해당 상품을 삭제한 후 (이미지)파일도 삭제하려면
	//그 파일이 있는 실제 경로를 알아야 한다
	//request.getRealPath("폴더명")
	String path = request.getRealPath("upload");

	int no = Integer.parseInt(request.getParameter("no"));

	GoodsDao dao = GoodsDao.getInstance();
	
	//상품을 삭제하면서 파일도 삭제하려면,
	//상품을 삭제하기 전에 해당상품의 파일명을 알아야한다
	String fname = dao.findByNo(no).getFname();
	
	int re = dao.deleteByNo(no); //상품을 삭제하는 함수

	if(re == 1){
		File file = new File(path + "/" + fname);
		file.delete();
		//상품삭제가 성공하면, 목록페이지로 간다
		response.sendRedirect("goods_list.jsp");
	}else{
		out.print("상품 삭제에 실패하였습니다");
	}
	
%>
</body>
</html>