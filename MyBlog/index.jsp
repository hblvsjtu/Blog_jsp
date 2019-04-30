<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Locale" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--
  Created by IntelliJ IDEA.
  User: hblvs
  Date: 2017/11/10
  Time: 22:01
  To change this template use File | Settings | File Templates.
-->
<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<!DDOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${sessionScope.myTitle}</title>
    <link rel="icon" href="img/123.jpg" type="image/x-icon" />
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/top.css">
    <link rel="stylesheet" type="text/css" href="css/container.css">
    <link rel="stylesheet" type="text/css" href="css/libraryContainer.css">
    <link rel="stylesheet" type="text/css" href="css/commentContainer.css">
    <link rel="stylesheet" type="text/css" href="css/animation.css">
    <script type="text/javascript"  src="js/pretreatment.js"></script>
    <script type="text/javascript" src="js/treatment.js" ></script>
    <!--src="http://maps.google.com/maps/api/js?sensor=false"-->
	</head>
	<body onmousedown="rightKey()" onload="load()">
		<div id="bodyContainer">
		<header id="top">
		        <h1 align="center" id="biaoti">${sessionScope.myTitle}</h1>
		    <h5 id="vistor">
		        <input type="button" id="btn_checkCache" value="检查缓存" onclick="checkCache()">
		        <input type="button" id="btn_undataCache" value="更新缓存" onclick="updateMyCache()"><br>
		        总访问数：<input type="text"  id="vistorNumber" width="auto" onclick="inialVistorNumber()" 
		        value="<%= application.getAttribute("count") %>" ><br>
		        当前会话内访问数：<input type="text"  id="vistorNumberTime" width="auto" onclick="inialVistorNumberTime()" >
		    </h5>
		</header>
		<nav id="myNav" draggable="true">
		        <p>	<MARK><b>技术分类</b></MARK></p>
		        <ul>
		            <li><a href="#theam_桌面端">桌面端</a></li>
		            <li><a href="#theam_移动端">移动端</a></li>
		            <li><a href="#theam_网页端">网页端</a></li>
		            <li><a href="#theam_服务器端">服务器端</a></li>
		            <li><a href="html/Login.html">用户登陆界面</a></li>
		            <li><a href="TestServlet">访问TestServlet</a></li>
		            <li><a href="TestJDBCServlet">访问TestJDBC</a></li>
		            <li><a href="jsp/TestEL.jsp?name=TestEL">访问TestEL</a></li>
		            <li><a href="jsp/TestJSTL.jsp">访问TestJSTL</a></li>
		            <li><a href="jsp/TestStruts2.jsp">访问TestStruts2</a></li>
		        </ul>
		        <P id="myTime">2017-11-09</P>
		</nav>
		<div id="articalContainer">
			<div id="container">
			    <div id="myArticle">
			        <section id="theam_桌面端">
			            <HEADER>
			                <P>桌面端</P>
			            </HEADER>
			            <ul>
			                <li>C/C++</li>
			                <li>Java</li>
			                <li>VB</li>
			            </ul>
			        </section>
			        <section id="theam_移动端" >
			            <HEADER>
			                <P>移动端</P>
			            </HEADER>
			            <ul>
			                <li>Android</li>
			                <li>IOS</li>
			            </ul>
			        </section>
			        <section id="theam_网页端" >
			            <HEADER>
			                <P>网页端</P>
			            </HEADER>
			            <ul>
			                <li>HTML/XHTML/HTML5</li>
			                <li>CSS</li>
			                <li>Java Script</li>
			                <li>Node.js</li>
			                <li>PHP</li>
			            </ul>
			        </section>
			        <section id="theam_服务器端" >
			            <HEADER>
			                <P>服务器端</P>
			            </HEADER>
			            <ul>
			                <li>UNIX/Linux</li>
			                <li>SQL Sever</li>
			                <li>MySQL</li>
			                <li>MongoDB</li>
			                <li><a href="html/hibernate.html">Hibernate</a></li>
			                <li><a href="html/jdbc.html">Java Web数据库操作</a></li>
			            </ul>
			        </section>
			    </div>
			    <div id="myAside">
			        
			    <%
			        Cookie[] cookies=request.getCookies();
			        String cookieUser="";
			        String cookieData="";
			        if (cookies != null){
			            for(int i=0;i<cookies.length;i++){
			                if(cookies[i].getName().equals("myCookie")){	                 
			                    cookieUser= URLDecoder.decode(cookies[i].getValue().split("#")[0],"UTF-8");
			                    cookieData=URLDecoder.decode(cookies[i].getValue().split("#")[1].toString(),"UTF-8");
			                };
			            };
			        }
				%>
				<c:set var="trueTag" value="true" />
				<c:set var="falseTag" value="fasle" />
				<c:set var="paramIsQuitSignIn" value="falseTag" />
				<c:set var="paramFromPageSignInCheckServlet" value="falseTag"/>
				<c:set var="paramIsSignInFinish" value="falseTag"/>
				<c:set var="paramSignInFlag" value="falseTag"/>
				<c:set var="paramHasSignInName" value="falseTag"/>
				<c:if test="${trueTag eq param.isQuitSignIn}"><c:set var="paramIsQuitSignIn" value="trueTag" /></c:if>
				<c:if test="${'SignInCheckServlet' eq param.fromPage}"><c:set var="paramFromPageSignInCheckServlet" value="trueTag" /></c:if>
				<c:if test="${trueTag eq sessionScope.isSignInFinish}"><c:set var="paramIsSignInFinish" value="trueTag" /></c:if>
				<c:if test="${trueTag eq sessionScope.signInFlag}"><c:set var="paramSignInFlag" value="trueTag" /></c:if>
			    <c:if test="${trueTag eq sessionScope.hasSignInName}"><c:set var="paramHasSignInName" value="trueTag" /></c:if>
			    <c:set var="doSignInFlag">
			    	<form id="form1" name="form1" method="post" action="<%= request.getContextPath()%>/SignInCheckServlet" target="_self">	
				       <P>欢迎<b>${sessionScope.username}</b>再次光临</P>
				       <P>您的注册时间是：${sessionScope.signUpTime}</P>
				       <input type="submit" name="btnQuitSignIn" class="btn_grey" value="退出登陆">&nbsp;&nbsp;
				  	</form>
				</c:set>
			    <c:set var="noSignInFlag">
			    	<form id="form1" name="form1" method="post" action="<%= request.getContextPath()%>/SignInCheckServlet" target="_self">	
			           <table id="myTable">
			               <tr>
			                   <td  colspan="2"  bgcolor="#eeeeee">·用户登录</td>
			               </tr>
			               <tr>
			                   <td width="20%" >用户名:</td>
			                   <td><input type="text" name="user" id="user" width="100px" onclick="setUserName()" class="table_input"></td>
			               </tr>
			               <tr>
			                   <td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
			                   <td ><input type="password" name="pwd" id="pwd" onclick="setPassword()" class="table_input" ></td>
			               </tr>
			               <tr>
			                   <td >性别：</td>
			                   <td >
			                       <select name="sex" id="sex" size="digit" >
			                           <option>男生&nbsp;&nbsp;&nbsp;&nbsp;</option>
			                           <option>女生&nbsp;&nbsp;&nbsp;&nbsp;</option>
			                       </select>
			                   </td>
			               </tr>
			               <tr>
			                   <td colspan="2">
			                       <input type="checkbox" name="checkbox1" id="checkbox1" value="Apple"> Apple&nbsp;
			                       <input type="checkbox" name="checkbox2" id="checkbox2" value="Orange"> Orange&nbsp;
			                       <input type="checkbox" name="checkbox3" id="checkbox3" value="Pear"> Pear&nbsp;
			                   </td>
			               </tr>
			               <tr>
			                   <td colspan="2" align="center">
			                   	<input type="submit" id="signin" name="signin" class="btn_grey" value="登陆" onclick="check()"/>&nbsp;&nbsp;
			                       <input type="button" id="signup" name="signup" class="btn_grey" value="注册" onclick="jumpToSignUpPage()">&nbsp;&nbsp;
			                       <input type="reset" name="Submit2" class="btn_grey" value="重置">&nbsp;&nbsp;
			                   </td>
			               </tr>
			               <tr>
			                   <td  colspan="2">
			                   </td>
			               </tr>
			           </table>
	   				</form>
			    </c:set>
			  		<c:choose>
			  			<c:when test="${('trueTag' eq paramFromPageSignInCheckServlet)  && ('trueTag' eq paramIsSignInFinish)}">
			    			<c:out value="${doSignInFlag}" escapeXml="false"></c:out>
			    		</c:when>
					  	<c:when test="${('trueTag' eq paramFromPageSignInCheckServlet)  && ('trueTag' eq paramIsSignInFinish)
					     && ('falseTag' eq paramSignInFlag) && ('trueTag' eq paramHasSignInName)}">
					     	<c:out value="${noSignInFlag}" escapeXml="false"></c:out>
					    	<script type="text/javascript">alert("密码错误，请重新登陆")</script>
					    </c:when>
					    <c:when test="${('trueTag' eq paramFromPageSignInCheckServlet)  && ('trueTag' eq paramIsSignInFinish)
					     && ('falseTag' eq paramSignInFlag) && ('falseTag' eq paramHasSignInName)}">
					     <c:out value="${noSignInFlag}" escapeXml="false"></c:out>
					    	<script type="text/javascript">alert("用户已存在，请注册新用户 ")</script>
					    </c:when>
					    <c:when test="${('trueTag' eq paramFromPageSignInCheckServlet)  && ('falseTag' eq paramIsSignInFinish)}">
					    	<c:out value="${noSignInFlag}" escapeXml="false"></c:out>
					    	<script type="text/javascript">alert("登陆信息填写不完整，请填写完整! ")</script>
					    </c:when>
		   				<c:otherwise><c:out value="${noSignInFlag}" escapeXml="false"></c:out></c:otherwise>
	   				</c:choose>
				        <div id="myImage"><img src="img/zjl.jpg"></div>
				        <div id="myAudio">
				            <audio id="music"  onmousemove="this.play()" onmouseout="this.pause()" preload="auto">
				                <source src="music/anjing.wav" type="audio/wav">
				            </audio>
				        </div>
				        <p align="center"><button id="toggle" onclick="toggleSound()" >播放</button></p>
				        <p align="center"><button id="communication" onclick="workerMethod()" >线程间通讯</button></p>
				        <canvas id="myCanvas"></canvas>
					        <script type="text/javascript">
					            var c=document.getElementById("myCanvas");
					            var context=c.getContext("2d");
					            if (c.getContext==false) {
					                alert("你的浏览器不支持canvas元素，请更新或者更换您的浏览器。")
					            }
					            context.moveTo(0,100);
					            //context.lineTo(200,100);
					            //context.stroke();
					            //context.fillStyle="#FF00FF";
					            //context.fillRect(0,0,200,100);
					            for(var i=0;i<20;i++){
					                context.strokeStyle="#FF00FF";
					                context.beginPath();
					                context.arc(0,100,i*5,0,Math.PI*3/2,true);
					                context.stroke();
					            }
					        </script>
				        <div id="fibonacci">
				            请输入Fibonacci的N值：<input type="text" id="text_fibonacci">
				            <button id="btn_fibonacci" onclick="fibonacci()">计算</button>
				            <input type="text" id="result_fibonacci">
				        </div>
			    </div>
			</div>
			<div id="library">
				<div id="bookInfor">
					<form id="formBookInfor" action="<%= request.getContextPath()%>/AddServlet" target="_self" method="post">
						<table id="tableBookInfor">
						<caption>添加图书信息</caption>
						<tr>
							<td>图书编号：</td>
							<td><input type="text" id="inputBookInforID" name="inputBookInforID"/></td>
						</tr>
						<tr>
							<td>图书名称：</td>
							<td><input type="text" id="inputBookInforName" name="inputBookInforName" /></td>
						</tr>
						<tr>
							<td>作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：</td>
							<td><input type="text" id="inputBookInforAuthor" name="inputBookInforAuthor" /></td>
						</tr>
						<tr>
							<td>价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：</td>
							<td><input type="text" id="inputBookInforPrice" name="inputBookInforPrice"/></td>
						</tr>
						<tr>
							<td>数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量：</td>
							<td><input type="text" id="inputBookInforNumber" name="inputBookInforNumber"/></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit" id="inputBookInforSummit" name="inputBookInforSummit" value="提交"></td>
						</tr>
						</table>
					</form>
				</div>
				<div id="checkEmailAndPhone">
					<jsp:useBean id="emailCheck" class="com.lvhongbin.bean.EmailCheck" scope="page">
			        <jsp:setProperty name="emailCheck" property="phoneAdd" value="15821717328"></jsp:setProperty>
			        </jsp:useBean>
			        <form id="checkForm"  action="jsp/mailCheck.jsp" method="post" target="_blank">
			            <table id="checkTable">
			                <caption>验证系统 <jsp:getProperty property="phoneAdd" name="emailCheck"/></caption>
			                <tr>
			                    <td align="center">电话号码</td>
			                    <td align="center"><input type="text" id="phoneCheck" name="phoneCheck"></td>
			                </tr>
			                <tr>
			                    <td align="center">邮箱地址</td>
			                    <td align="center"><input type="text" id="mailCheck"  name="mailCheck"></td>
			                </tr>
			                <tr>
			                    <td colspan="2" align="center"><input type="submit" id="summitCheck"></td>
			                </tr>
			            </table>
			        </form>
				</div>
				<div id="libraryUpload">
					<form action="<%= request.getContextPath()%>/UploadServlet" enctype="multipart/form-data" method="post">
						选择文件<input type="file" name="file1" id="file1">
						<input type="submit" name="upload" id="upload" value="上传">
					</form>
				</div>
				<div id=libraryCheckloginName>
				
				</div>
			</div>
			<div id="commentContainer">
			    <div id="videoArea">
			        <video id="video" width="600px" height="400px"  onmousemove="this.play()" onmouseout="this.pause()" preload="metadata"  controls="controls"
			               oncanplay="startVideo()" onended="stopTimeline()">
			            <source src="video/video.mp4" type="video/mp4">
			        </video>
			        <canvas id="timeline" width="400px" height="300px"></canvas>
			    </div>
			    <div id="commentArea">
			        <div id="commentAreaContainer">
			            <div id="commentFormDiv">
			                <form id="commentForm">
			                    <table id="commentTable">
			                        <tr>
			                            <td id="commenter"  style="width: 10em">评论人</td>
			                            <td id="comment" >评论内容</td>
			                        </tr>
			                    </table>
			                </form>
			            </div>
			            <div id="commentInfoFormDiv">
			                <form id="commenterInfoForm" method="get" action="">
			                    <table id="commenterInfoTable">
			                        <tr>
			                            <td style="width: 5em">评论人：&nbsp;&nbsp;</td>
			                            <td><input id="commenterName" type="text"></td>
			                        </tr>
			                        <tr>
			                            <td>评论内容：</td>
			                            <td ><textarea id="commenterText" rows="6"></textarea></td>
			                        </tr>
			                    </table>
			                </form>
			            </div>
			            <div id="commentButtonDiv">
			                <input type="button" id="commentPublic" value="发表" onclick="addComment()">
			                <input type="button" id="commentReset" value="重置" onclick="clearComment()">
			                <input type="button" id="commentDeleteFirst" value="删除第一条评论" onclick="deleteFirstComment()">
			                <input type="button" id="commentDeleteLast" value="删除最后一条评论" onclick="deleteLastComment()">
			            </div>
			        </div>
			    </div>
			</div>
		</div>
		<footer>
		    <P>Copyright@冰先生</P>
		    <a href="http://www.sjtu.edu.cn/" style="color:white;">上海交通大学<br></a>
		    <jsp:useBean id="showTime" class="com.lvhongbin.bean.ShowTime"></jsp:useBean>
		    <time pubdate datetime="2017-10-26 10:57"><jsp:getProperty property="realTime" name="showTime"/></time>
		</footer>
		</div>
	</body>
</html>
