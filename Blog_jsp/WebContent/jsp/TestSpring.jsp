<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>TestSpring</title>
	</head>
	<body>
		<h2>Bean实例化的三种方式实现</h2>
			<h4>使用类的无参构造创建</h4>
				<form action="testSpring1.action" method="post">
					请输入书名：<input type="text" name="name1" >
					<input type="submit" value="提交"><br>
					结果如下：<br>
					<s:property value="name1"/><br>
					有参构造注入价钱：<s:property value="price"/><br>
					set方法注入作者：<s:property value="author"/><br>
					p名称空间注入折扣：<s:property value="pbookCount"/><br>
					数组注入姓氏：<s:property value="arr[0]"/><br>
					List注入姓名：<s:property value="list[1].name"/><br>
					Map注入：<s:property value="map['an entry']"/><br>
					Property注入姓名：<s:property value="administrator"/><br>
				</form>
			<h4>使用静态工厂创建</h4>
				<form action="testSpring2.action" method="post">
					请输入书名：<input type="text" name="name2" >
					<input type="submit" value="提交"><br>
					结果如下：<s:property value="name2"/><br>
				</form>
			<h4>使用实例工厂创建</h4>
				<form action="testSpring3.action" method="post">
					请输入书名：<input type="text" name="name3" >
					<input type="submit" value="提交"><br>
					结果如下：<s:property value="name3"/><br>
				</form>
			<h4>混合模式使用注解创建对象</h4>
				<form action="testSpring4.action" method="post">
					请输入书名：<input type="text" name="name4" >
					<input type="submit" value="提交"><br>
					结果如下：<s:property value="book2.str1"/><br>
				</form>
			<h4>混合模式使用注解@Autowired进行属性注入</h4>
				<form action="testSpring5.action" method="post">
					请输入书名：<input type="text" name="name5" >
					<input type="submit" value="提交"><br>
					结果如下：<s:property value="book2.str2"/><br>
				</form>
			<h4>混合模式使用注解@Resource进行属性注入</h4>
				<form action="testSpring6.action" method="post">
					请输入书名：<input type="text" name="name6" >
					<input type="submit" value="提交"><br>
					结果如下：<s:property value="book2.str3"/><br>
				</form>
			<h4>AOP操作试验_利用配置文件</h4>
				<form action="testAop1.action" method="post">
					请输入书名：<input type="text" name="name7" >
					<input type="submit" value="提交"><br>
					结果如下：<s:property value="feedbackMessage"/><br>
				</form>
			<h4>AOP操作试验_利用注解</h4>
				<form action="testAop2.action" method="post">
					请输入书名：<input type="text" name="name8" >
					<input type="submit" value="提交"><br>
					结果如下：<s:property value="feedbackMessage"/><br>
				</form>
			<h4>JDBCTemperate——增加</h4>
				<form action="testJDBCTemperate1.action" method="post">
					请输入书名：<input type="text" name="name9"><br><br>
					请输入作者：<input type="text" name="name10"><br><br>
					请输入价钱：<input type="text" name="name11"><br><br>
					请输入出版时间：<input type="text" name="name12">年<br><br>
					<input type="submit" value="提交"><br>
					结果如下：<s:property value="feedbackMessage"/><br>
				</form>
			<h4>JDBCTemperate——跟据书名修改价钱</h4>
				<form action="testJDBCTemperate2.action" method="post">
					请输入书名：<input type="text" name="name9"><br><br>
					请输入价钱：<input type="text" name="name11"><br><br>
					<input type="submit" value="提交"><br>
					结果如下：<s:property value="feedbackMessage"/><br>
				</form>
			<h4>JDBCTemperate——跟据书名删除</h4>
				<form action="testJDBCTemperate3.action" method="post">
					请输入书名：<input type="text" name="name9"><br><br>
					<input type="submit" value="提交"><br>
					结果如下：<s:property value="feedbackMessage"/><br>
				</form>
			<h4>JDBCTemperate——跟据书名查询价钱</h4>
				<form action="testJDBCTemperate4.action" method="post">
					请输入书名：<input type="text" name="name9"><br><br>
					<input type="submit" value="提交"><br>
					结果如下：<s:property value="feedbackMessage"/><br>
				</form>
			<h4>String事务管理——ComboPool——增加</h4>
				<form action="comboPool.action" method="post">
					请输入书名：<input type="text" name="name9"><br><br>
					请输入作者：<input type="text" name="name10"><br><br>
					请输入价钱：<input type="text" name="name11"><br><br>
					请输入出版时间：<input type="text" name="name12">年<br><br>
					<input type="submit" value="提交"><br>
					结果如下：<s:property value="feedbackMessage"/><br>
				</form>
			
	</body>
</html>