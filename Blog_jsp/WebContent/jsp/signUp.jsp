<%@ page import="com.lvhongbin.bean.User"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户注册</title>
		<link href="css/signUp.css" type="text/css">
		<link rel="stylesheet" type="text/css" href="/Blog_jsp/css/signUp.css">
		<script type="text/javascript"  src="/Blog_jsp/js/signUp.js"></script>
		<script type="text/javascript"  src="/Blog_jsp/js/Ajax.js"></script>
		<style type="text/css">
			body{
				margin: 0px;font-size: 12px;
			}
			.box{
				border: 1px solid #D1DEB2; width: 15em; height: 20px;
			}
			.div1{
				background-image: url(/Blog_jsp/img/signUp.jpg);
				height: 600px;
				width: 803px;
				padding-left:20px;
				padding-top:220px;
				text-align:left;
			}
			table{
				border:0em;
				width:40em;
			}
		</style>
		<c:set var="trueTag" value="true"></c:set>
		<c:set var="falseTag" value="false"></c:set>
		<c:set var="fromPageSignUpCheckServlet" value="falseTag"/>
		<c:set var="isExisted" value="falseTag"/>
		<c:set var="signUpFlag" value="falseTag"/>
		<c:set var="isSignUpFinish" value="falseTag"/>
		<c:if test="${'SignUpCheckServlet' eq param.fromPage}"><c:set var="fromPageSignUpCheckServlet" value="trueTag"/></c:if>
		<c:if test="${trueTag eq sessionScope.isExisted}"><c:set var="isExisted" value="trueTag"/></c:if>
		<c:if test="${trueTag eq sessionScope.signUpFlag}"><c:set var="signUpFlag" value="trueTag"/></c:if>
		<c:if test="${trueTag eq sessionScope.isSignUpFinish}"><c:set var="isSignUpFinish" value="trueTag"/></c:if>
		<c:choose>
			<c:when test="${('falseTag'eq isFromFunctionCheckExistedUser) && ('trueTag' eq fromPageSignUpCheckServlet) && ('falseTag' eq isSignUpFinish)}">
				<script type="text/javascript" charset="UTF-8">alert("注册信息填写不完整,请重新填写");</script> 
			</c:when>
			<c:when test="${('falseTag'eq isFromFunctionCheckExistedUser) && ('trueTag' eq fromPageSignUpCheckServlet) && ('trueTag' eq isSignUpFinish) && ('trueTag' eq isExisted) && ('falseTag' eq signUpFlag)}">
				<script type="text/javascript" charset="UTF-8">alert("该用户已存在，请重新注册或直接登陆！");</script>
			</c:when>
			<c:when test="${('falseTag'eq isFromFunctionCheckExistedUser) && ('trueTag' eq fromPageSignUpCheckServlet) && ('trueTag' eq isSignUpFinish) && ('falseTag' eq isExisted) && ('trueTag' eq signUpFlag)}">
				<script type="text/javascript" charset="UTF-8">
						 function alertmessage(){
							 var username=window.document.getElementById("username").value;
							 alert("恭喜 "+username+" ,注册成功,3秒后跳转原页面");
						 }
						 setTimeout("alertmessage()", 3000);
						 window.location.href="/Blog_jsp/SignInCheckServlet?fromPage=signUp";
				</script>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</head>
	<body>
	fromPageSignUpCheckServlet: <c:out value="fromPageSignUpCheckServlet"></c:out>
	isSignUpFinish: <c:out value="isSignUpFinish"></c:out>
		<div align="center">
			<div class="div1">
				<form name="formSignUp" id="formSignUp" action="/Blog_jsp/SignUpCheckServlet" method="post" onsubmit="return reg(this);">
					<table>
						<tr>
							<td align="right" width="30%" >用户名：</td>
							<td><input  id="username" name="username" type="text"  class="box" onchange="checkExistedUser()"></td>
							<td id="textCheckExistedUser" width="30%"  class="box" style="border: none;"></td>
						</tr>
						<tr>
							<td align="right">密 码：</td>
							<td><input type="password" name="password" class="box"></td>
						</tr>
						<tr>
							<td align="right">确认密码：</td>
							<td><input type="password" name="repassword" class="box"></td>
						</tr>
						<tr> 
							<td align="right">性 别：</td>
							<td>
								<input type="radio" name="sex" value="男" checked="checked">男
								<input type="radio" name="sex" value="女">女
							</td>
						</tr>
						<tr>
							<td align="right">密码找回问题：</td>
							<td><input type="text" name="question" class="box"></td>
						</tr>
						<tr>
							<td align="right">密码找回答案：</td>
							<td><input type="text" name="answer" class="box"></td>
						</tr>
						<tr>
							<td align="right">邮 箱：</td>
							<td><input type="text" name="email" class="box"></td>
						</tr>
						<tr>
							<td colspan="3" align="center" height="40">
								<input type="submit" value="注 册">
								<input type="reset" value="重 置">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>
