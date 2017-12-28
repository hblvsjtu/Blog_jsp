<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html >
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>TestHibernate</title>

	</head>
	<body>
	<br><input type="button" value="级联删除" onClick="location.href='TestHibernatedelete.action'"><br>
	<br>新增的用户是：<br>
		&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="user.name"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="user.password"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="user.sex"/><br>
	<br>使用Query方法进行全部查询<br>
		<s:iterator value="list1">
			&nbsp;&nbsp;&nbsp;&nbsp;姓名：<s:property value="name"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;密码：<s:property value="password"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;性别：<s:property value="sex"/><br>
		</s:iterator>
	<br>使用Query方法进行条件查询<br>
		<s:iterator value="listCondition" var="listConditionCustomer">
			&nbsp;&nbsp;&nbsp;&nbsp;客户id：<s:property value="#listConditionCustomer.cid"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;客户姓名：<s:property value="#listConditionCustomer.custName"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;客户手机：<s:property value="#listConditionCustomer.custPhone"/><br>
		</s:iterator>
	<br>使用Query方法进行模糊查询<br>
		<s:iterator value="listConditionFuzzy" var="listConditionFuzzyCustomer">
			&nbsp;&nbsp;&nbsp;&nbsp;客户id：<s:property value="#listConditionFuzzyCustomer.cid"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;客户姓名：<s:property value="#listConditionFuzzyCustomer.custName"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;客户手机：<s:property value="#listConditionFuzzyCustomer.custPhone"/><br>
		</s:iterator>
	<br>使用Query方法进行排序查询<br>
		<s:iterator value="listOrder" var="listOrderCustomer">
			&nbsp;&nbsp;&nbsp;&nbsp;客户id：<s:property value="#listOrderCustomer.cid"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;客户姓名：<s:property value="#listOrderCustomer.custName"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;客户手机：<s:property value="#listOrderCustomer.custPhone"/><br>
		</s:iterator>
	<br>使用Query方法进行分页查询-每页两个记录<br>
		<s:iterator value="listPagination" var="listPaginationCustomer">
			&nbsp;&nbsp;&nbsp;&nbsp;客户id：<s:property value="#listPaginationCustomer.cid"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;客户姓名：<s:property value="#listPaginationCustomer.custName"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;客户手机：<s:property value="#listPaginationCustomer.custPhone"/><br>
		</s:iterator>
	<br>使用Query方法进行投影查询-客户姓名<br>
		<s:iterator value="listProjection" var="listProjectionCustomer">
			&nbsp;&nbsp;&nbsp;&nbsp;客户姓名：<s:property value="#listProjectionCustomer.toString()"/><br>
		</s:iterator>
	<br>使用Query方法进行聚合查询-客户数量<br>
		&nbsp;&nbsp;&nbsp;&nbsp;客户数量：<s:property value="listAggregate.toString()"/><br>
	<br>使用Query方法进行HQL多表查询-内连接<br>
		<s:iterator value="listInnerJoin" var="listInnerJoinCustomer">
			&nbsp;&nbsp;&nbsp;&nbsp;客户姓名：<s:property value="#listInnerJoinCustomer"/><br>
		</s:iterator>	
	<br>使用Criteria方法进行全部查询<br>
		<s:iterator value="list3">
			&nbsp;&nbsp;&nbsp;&nbsp;姓名：<s:property value="name"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;密码：<s:property value="password"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;性别：<s:property value="sex"/><br>
		</s:iterator>
	<br>使用Criteria方法进行条件查询--id>190<br>
		<s:iterator value="listCriteriaCondition">
			&nbsp;&nbsp;&nbsp;&nbsp;客户id：<s:property value="cid"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;客户姓名：<s:property value="custName"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;客户手机：<s:property value="custPhone"/><br>
		</s:iterator>
	<br>使用Criteria方法进行模糊查询<br>
		<s:iterator value="listCriteriaConditionFuzzy">
			&nbsp;&nbsp;&nbsp;&nbsp;客户id：<s:property value="cid"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;客户姓名：<s:property value="custName"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;客户手机：<s:property value="custPhone"/><br>
		</s:iterator>
	<br>使用Criteria方法进行排序和分页查询<br>
		<s:iterator value="listCriteriaOrderAndPagination">
			&nbsp;&nbsp;&nbsp;&nbsp;客户id：<s:property value="cid"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;客户姓名：<s:property value="custName"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;客户手机：<s:property value="custPhone"/><br>
		</s:iterator>
	<br>使用Criteria方法进行统计和离线查询<br>
			&nbsp;&nbsp;&nbsp;&nbsp;客户记录数：<s:property value="listCriteriaStatistical.toString()"/><br>	
	
	<br>使用SQLQuery方法进行全部查询1_数组<br>
		<s:iterator value="list5" var="list">
			&nbsp;&nbsp;&nbsp;&nbsp;姓名：<s:property value="#list[1]"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;密码：<s:property value="#list[2]"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;性别：<s:property value="#list[4]"/><br>
		</s:iterator>
	<br>使用SQLQuery方法进行全部查询2_对象<br>
		<s:iterator value="list6" var="list">
			&nbsp;&nbsp;&nbsp;&nbsp;姓名：<s:property value="#list.name"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;密码：<s:property value="#list.password"/><br>
			&nbsp;&nbsp;&nbsp;&nbsp;性别：<s:property value="#list.sex"/><br>
		</s:iterator>
	<br>一对多级联保存<br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;用户1姓名：<s:property value="customer1.custName"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;用户1等级：<s:property value="customer1.custLevel"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;用户1来源：<s:property value="customer1.custSource"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;用户1电话：<s:property value="customer1.custPhone"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;用户1手机：<s:property value="customer1.custMobile"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;用户2姓名：<s:property value="customer2.custName"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;用户2等级：<s:property value="customer2.custLevel"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;用户2来源：<s:property value="customer2.custSource"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;用户2电话：<s:property value="customer2.custPhone"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;用户2手机：<s:property value="customer2.custMobile"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;联系人1姓名：<s:property value="linkMan1.Lkm_name"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;联系人1性别：<s:property value="linkMan1.Lkm_gender"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;联系人1电话：<s:property value="linkMan1.Lkm_phone"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;联系人2姓名：<s:property value="linkMan2.Lkm_name"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;联系人2性别：<s:property value="linkMan2.Lkm_gender"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;联系人2电话：<s:property value="linkMan2.Lkm_phone"/><br>
 	<br>一对多级联修改<br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;用户姓名：<s:property value="customer4.custName"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;用户等级：<s:property value="customer4.custLevel"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;用户来源：<s:property value="customer4.custSource"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;用户电话：<s:property value="customer4.custPhone"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;用户手机：<s:property value="customer4.custMobile"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;联系人姓名：<s:property value="linkMan4.Lkm_name"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;联系人性别：<s:property value="linkMan4.Lkm_gender"/><br>
	 	&nbsp;&nbsp;&nbsp;&nbsp;联系人电话：<s:property value="linkMan4.Lkm_phone"/><br>
	<br>多对多级联保存<br>
 		&nbsp;&nbsp;&nbsp;&nbsp;用户1姓名：<s:property value="user1.name"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;用户1密码：<s:property value="user1.password"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;用户1性别：<s:property value="user1.sex"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;用户2姓名：<s:property value="user2.name"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;用户2密码：<s:property value="user2.password"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;用户2性别：<s:property value="user2.sex"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;用户3姓名：<s:property value="user3.name"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;用户3密码：<s:property value="user3.password"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;用户3性别：<s:property value="user3.sex"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;角色1姓名：<s:property value="role1.role_name"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;角色1特性：<s:property value="role1.role_memo"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;角色2姓名：<s:property value="role2.role_name"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;角色2特性：<s:property value="role2.role_memo"/><br>

	</body>
</html>