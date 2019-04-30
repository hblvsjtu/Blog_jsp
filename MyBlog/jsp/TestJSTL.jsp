<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>应用&lt;c:out&gt;标签输出字符串“水平线标记&lt;hr&gt;”</title>
</head>
<body>
	escapeXml属性为true时：
	<c:out value="水平线标记<br>" escapeXml="true"></c:out>
	<br>
	escapeXml属性为false时：
	<c:out value="水平线标记<br>" escapeXml="false"></c:out>
	<br>
	<c:set var="username" value="lvhongbin" scope="request"></c:set>
	<c:out value="username的值为${username}"></c:out>
	<br>
	<jsp:useBean id="book" class="com.lvhongbin.bean.Book"></jsp:useBean> 
	<jsp:setProperty property="name" value="钢铁是怎样炼成的" name="book" />
	<c:out value="书名name为${book.name}"></c:out>
	<br>
	<c:set target="${book}" property="name">西游记</c:set>
	另一部著作为：<jsp:getProperty property="name" name="book"></jsp:getProperty>
	<br>
	<c:remove var="username" scope="request"/>
	<c:out value="${username}" default="空"></c:out>
</body>
</html>