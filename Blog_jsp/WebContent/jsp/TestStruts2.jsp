<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<style type="text/css">
		#testStrutsContainer {
			display: box;
			display: -moz-box;
			display: -webkit-box;
			-moz-box-align:left;
			-webkit-box-align:left;
			width:70em;
			margin: 0em auto;
		}
		#testStrutsColumn1{
			-moz-box-flex:1;
			-webkit-box-flex:1;
		}
		#testStrutsColumn2{
			width:35em;
		}
		#testStrutsColumn1,#testStrutsColumn2{
			box-sizing: border-box;
			-moz-box-sizing:border-box;
			-webkit-box-sizing:border-box;
		}
	</style>
	<title>Insert title here</title>
	</head>
	<body>
		<a href="userAction.action">用户登录</a>
		<br>
		<a href="userAction.action">用户注册</a>
		<font color="red">返回显示：<s:property value="info"/></font>
		<br>
		<div id="testStrutsContainer">
			<s:debug></s:debug>
			<div id="testStrutsColumn1">
				<h1>Action获取表单数据的三种方式</h1>
					<h3>第一种：使用ActionContext类</h3>
						<form action="action1.action" method="post">
							<table>
								<tr>
									<td>姓名：</td>
									<td><input type="text" name="name"></td>
								</tr>
								<tr>
									<td>密码：</td>
									<td><input type="text" name="password"></td>
								</tr>
								<tr>
									<td>性别：</td>
									<td><select name="sex">
										  <option value ="boy">男性</option>
										  <option value ="girl">女性</option>
										</select></td>
								</tr>
							</table>
							<input type="submit" name="btnAction1">
						</form><br>
						姓名：${param.name}<br>
						密码：${param.password}<br>
						性别：${param.sex}<br>
						nameOgnl:<s:property value="nameOgnl"/>
					
					<h3>第二种：使用ServletActionContext类</h3>
						<form action="action2.action" method="post">
							<table>
								<tr>
									<td>姓名：</td>
									<td><input type="text" name="name"></td>
								</tr>
								<tr>
									<td>密码：</td>
									<td><input type="text" name="password"></td>
								</tr>
								<tr>
									<td>性别：</td>
									<td><select name="sex">
										  <option value ="boy">男性</option>
										  <option value ="girl">女性</option>
										</select></td>
								</tr>
							</table>
							<input type="submit" name="btnAction1">
						</form><br>
						姓名：${requestScope.name7}<br>
						密码：${sessionScope.password7}<br>
						性别：${applicationScope.sex7}
					
					<h3>第三种：使用接口注入的方法</h3>
						<form action="action3.action" method="post">
							<table>
								<tr>
									<td>姓名：</td>
									<td><input type="text" name="name"></td>
								</tr>
								<tr>
									<td>密码：</td>
									<td><input type="text" name="password"></td>
								</tr>
								<tr>
									<td>性别：</td>
									<td><select name="sex">
										  <option value ="boy">男性</option>
										  <option value ="girl">女性</option>
										</select></td>
								</tr>
							</table>
							<input type="submit" name="btnAction1">
						</form><br>
						姓名：${requestScope.name8}<br>
						密码：${sessionScope.password8}<br>
						性别：${applicationScope.sex8}
			</div>
			<div id="testStrutsColumn2">		
				<h1>Struts获取表单数据的六种方式</h1>
					<h3>第一种：原始方式</h3>
						<form action="action4.action" method="post">
							<table>
								<tr>
									<td>姓名：</td>
									<td><input type="text" name="name"></td>
								</tr>
								<tr>
									<td>密码：</td>
									<td><input type="text" name="password"></td>
								</tr>
								<tr>
									<td>性别：</td>
									<td><select name="sex">
										  <option value ="boy">男性</option>
										  <option value ="girl">女性</option>
										</select></td>
								</tr>
							</table>
							<input type="submit" name="btnAction1">
						</form><br>
						姓名：${requestScope.name9}<br>
						密码：${sessionScope.password9}<br>
						性别：${applicationScope.sex9}
					<h3>第二种：属性封装</h3>
						<form action="action5.action" method="post">
							<table>
								<tr>
									<td>姓名：</td>
									<td><input type="text" name="name1"></td>
								</tr>
								<tr>
									<td>密码：</td>
									<td><input type="text" name="password1"></td>
								</tr>
								<tr>
									<td>性别：</td>
									<td><select name="sex1">
										  <option value ="boy">男性</option>
										  <option value ="girl">女性</option>
										</select></td>
								</tr>
							</table>
							<input type="submit" name="btnAction1">
						</form><br>
						姓名：${requestScope.name1}<br>
						密码：${sessionScope.password1}<br>
						性别：${applicationScope.sex1}
					<h3>第三种：模型驱动封装</h3>
						<form action="action6.action" method="post">
							<table>
								<tr>
									<td>姓名：</td>
									<td><input type="text" name="name"></td>
								</tr>
								<tr>
									<td>密码：</td>
									<td><input type="text" name="password"></td>
								</tr>
								<tr>
									<td>性别：</td>
									<td><select name="sex">
										  <option value ="boy">男性</option>
										  <option value ="girl">女性</option>
										</select></td>
								</tr>
							</table>
							<input type="submit" name="btnAction1">
						</form><br>
						姓名：${requestScope.name2}<br>
						密码：${sessionScope.password2}<br>
						性别：${applicationScope.sex2}
					<h3>第四种：表达式封装</h3>
						<form action="action7.action" method="post">
							<table>
								<tr>
									<td>姓名：</td>
									<td><input type="text" name="user3.name"></td>
								</tr>
								<tr>
									<td>密码：</td>
									<td><input type="text" name="user3.password"></td>
								</tr>
								<tr>
									<td>性别：</td>
									<td><select name="user3.sex">
										  <option value ="boy">男性</option>
										  <option value ="girl">女性</option>
										</select></td>
								</tr>
							</table>
							<input type="submit" name="btnAction1">
						</form><br>
						姓名：${requestScope.name3}<br>
						密码：${sessionScope.password3}<br>
						性别：${applicationScope.sex3}<br>
						姓名OGNL：<s:property value="user3.name"/><br>
						密码OGNL：<s:property value="user3.password"/><br>
						性别OGNL：<s:property value="user3.sex"/>
					<h3>第五种 List集合封装</h3>
						<form action="action8.action" method="post">
							<table>
								<tr>
									<td>姓名1：</td>
									<td><input type="text" name="list[0].name"></td>
								</tr>
								<tr>
									<td>密码1：</td>
									<td><input type="text" name="list[0].password"></td>
								</tr>
								<tr>
									<td>性别1：</td>
									<td><select name="list[0].sex">
										  <option value ="boy">男性</option>
										  <option value ="girl">女性</option>
										</select></td>
								</tr>
								<tr>
									<td>姓名2：</td>
									<td><input type="text" name="list[1].name"></td>
								</tr>
								<tr>
									<td>密码2：</td>
									<td><input type="text" name="list[1].password"></td>
								</tr>
								<tr>
									<td>性别2：</td>
									<td><select name="list[1].sex">
										  <option value ="boy">男性</option>
										  <option value ="girl">女性</option>
										</select></td>
								</tr>
							</table>
							<input type="submit" name="btnAction1">
						</form><br>
						姓名：${requestScope.name4}<br>
						密码：${sessionScope.password4}<br>
						性别：${applicationScope.sex4}
						<h5>获取list集合数据法一</h5>
							<s:iterator value="listOgnl">
								姓名：<s:property value="name"/><br>
								密码：<s:property value="password"/><br>
								性别：<s:property value="sex"/><br>
							</s:iterator>
						<h5>获取list集合数据法二</h5>
							<s:iterator value="listOgnl" var="user">
								姓名：<s:property value="#user.name"/><br>
								密码：<s:property value="#user.password"/><br>
								性别：<s:property value="#user.sex"/><br>
							</s:iterator>
					<h3>第六种 Map集合封装</h3>
						<form action="action9.action" method="post">
							<table>
								<tr>
									<td>姓名1：</td>
									<td><input type="text" name="Map['one'].name"></td>
								</tr>
								<tr>
									<td>密码1：</td>
									<td><input type="text" name="Map['one'].password"></td>
								</tr>
								<tr>
									<td>性别1：</td>
									<td><select name="Map['one'].sex">
										  <option value ="boy">男性</option>
										  <option value ="girl">女性</option>
										</select></td>
								</tr>
								<tr>
									<td>姓名2：</td>
									<td><input type="text" name="Map['two'].name"></td>
								</tr>
								<tr>
									<td>密码2：</td>
									<td><input type="text" name="Map['two'].password"></td>
								</tr>
								<tr>
									<td>性别2：</td>
									<td><select name="Map['two'].sex">
										  <option value ="boy">男性</option>
										  <option value ="girl">女性</option>
										</select></td>
								</tr>
							</table>
							<input type="submit" name="btnAction1">
						</form><br>
						姓名：${requestScope.name5}<br>
						密码：${sessionScope.password5}<br>
						性别：${applicationScope.sex5}
			</div>
		</div>
	</body>
</html>
