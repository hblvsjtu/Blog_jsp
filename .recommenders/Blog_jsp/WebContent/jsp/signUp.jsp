<%@page import="com.lvhongbin.bean.User"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %>
<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户注册</title>
		<link href="css/signUp.css" type="text/css">
		<link rel="stylesheet" type="text/css" href="/Blog_jsp/css/signUp.css">
		<script type="text/javascript"  src="/Blog_jsp/js/signUp.js" charset="UTF-8"></script>
		<style type="text/css">
			body{
				margin: 0px;font-size: 12px;
			}
			.box{
				border: 1px solid #D1DEB2; width: 150px; height: 20px;
			}
			.div1{
				background-image: url(images/bg.jpg);
				height: 600px;
				width: 803px;
				padding-left:20px;
				padding-top:220px;
				text-align:left;
			}
		</style>
		<%
		System.out.println("======== 跳转到signUp页面 ========");
		boolean fromPageSignUpCheckServlet=false;
		boolean isExisted=false;
        boolean signUpFlag=false;
        boolean isSignUpFinish=false;
        User user =null;
        if(null!=request.getParameter("fromPage")){
        	fromPageSignUpCheckServlet=("SignUpCheckServlet".equals(request.getParameter("fromPage").toString()))?true:false;
        }
        if(null!=session.getAttribute("isSignUpFinish")){
        	isSignUpFinish=(Boolean)session.getAttribute("isSignUpFinish");
        }
        if(null!=session.getAttribute("isExisted")){
        	isExisted=(Boolean)session.getAttribute("isExisted");
        }
        if(null!=session.getAttribute("signUpFlag")){
        	signUpFlag=(Boolean)session.getAttribute("signUpFlag");
        }
        if(null!=session.getAttribute("user")){
        	user=(User)session.getAttribute("user");
        }
        if(fromPageSignUpCheckServlet){
        	if(isSignUpFinish){
        		if(isExisted){
		%>	 
					<script type="text/javascript" charset="UTF-8">
						 alert("用户名已存在，请重新填写用户名，或者选择直接登陆");
					</script> 
		<%
 		    		System.out.println("======== 注册失败,用户账号已存在 ========");
 				}else if(signUpFlag){
        %>
					 <script type="text/javascript" charset="UTF-8">
						 function alertmessage(){
							 var username=window.document.getElementById("username");
							 alert("恭喜 "+username+" ,注册成功,3秒后跳转原页面");
						 }
						 setTimeout("alertmessage()", 3000); 
					 </script>
		<%
   						System.out.println("======== 注册成功，准备离开到signUp页面 ========");
   			       		response.sendRedirect("/Blog_jsp/SignInCheckServlet?fromPage=signUp");
   				}else{
        %>
   						 <script type="text/javascript" charset="UTF-8">
   						 	alert("数据库写入失败,请检查拼写");
   						 </script>
        <%
        		}
        	}else{
        %>
					 <script type="text/javascript" charset="UTF-8">
					 	alert("注册信息填写不完整,请重新填写");
					 </script>
		<%
        	}	
        }
		%>

	</head>
	<body>
		<div align="center">
			<div class="div1">
				<form action="/Blog_jsp/SignUpCheckServlet" method="post" onsubmit="return reg(this);">
					<table align="center" border="0" width="500">
						<tr>
							<td align="right" width="30%" size ="9pt">用户名：</td>
							<td><input  id="username" name="username" type="text"  class="box"></td>
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
							<td colspan="2" align="center" height="40">
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