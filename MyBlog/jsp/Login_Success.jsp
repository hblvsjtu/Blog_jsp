<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: hblvs
  Date: 2017/11/11
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GBK" language="java" pageEncoding="GBK"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="" method="post">
        <input type="text" name="userName"/>
        <input type="submit" value="提交"/>
    </form>
    <%
        String getMethod=request.getMethod();
        String getRequestURI= request.getRequestURI();
        String getProtocol=request.getProtocol();
        String getServerName=request.getServerName();
        int getServerPort=request.getServerPort();
        String getRemoteAddr=request.getRemoteAddr();
        String getRemoteHost=request.getRemoteHost();
        String getParameter_user = request.getAttribute("username").toString();
        String getParameter_pwd=request.getAttribute("password").toString();
        String getParameter_sex=request.getAttribute("sex").toString();
        Cookie cookie =new Cookie("myCookie", URLEncoder.encode(getParameter_user,"UTF-8")+"#"+URLEncoder.encode(new Date().toString(),"UTF-8"));
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
    %><br/>
    请求方法名：<%= getMethod%><br/>
    请求的资源：<%= getRequestURI%><br/>
    请求使用的协议：<%= getProtocol%><br/>
    请求的服务器IP：<%= getServerName%><br/>
    请求的服务器端口：<%= getServerPort%><br/>
    客户端的IP地址：<%= getRemoteAddr%><br/>
    客户端的主机名：<%= getRemoteHost%><br/>
    表单提交来的用户名:<%= getParameter_user%><br/>
    表单提交来的密码:<%= getParameter_pwd%><br/>
    表单提交来的性别:<%= getParameter_sex%><br/>
    <% String message=request.getParameter("status");%>
    表单的提交的名字：<%= message%>
    <script type="text/javascript">
        window.location.href="../index.jsp";
    </script>
</body>
</html>
