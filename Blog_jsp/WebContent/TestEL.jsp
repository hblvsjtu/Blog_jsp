<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello EL</title>
</head>
<body>
	<%
		String[] book={"JAVA从入门到精通","C语言从入门到精通","PHP从入门到精通","HTML/CSS从入门到精通"};
		request.setAttribute("book", book);
	%>
	<%
		String[] book1=(String[])request.getAttribute("book");
		for(int i=0;i<book1.length;i++){
			request.setAttribute("booknum", i);
	%>
	${booknum }:${book[booknum] }<br>
	<%
		} 
	%> 
</body>
</html>