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
        <input type="submit" value="�ύ"/>
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
    ���󷽷�����<%= getMethod%><br/>
    �������Դ��<%= getRequestURI%><br/>
    ����ʹ�õ�Э�飺<%= getProtocol%><br/>
    ����ķ�����IP��<%= getServerName%><br/>
    ����ķ������˿ڣ�<%= getServerPort%><br/>
    �ͻ��˵�IP��ַ��<%= getRemoteAddr%><br/>
    �ͻ��˵���������<%= getRemoteHost%><br/>
    ���ύ�����û���:<%= getParameter_user%><br/>
    ���ύ��������:<%= getParameter_pwd%><br/>
    ���ύ�����Ա�:<%= getParameter_sex%><br/>
    <% String message=request.getParameter("status");%>
    �����ύ�����֣�<%= message%>
    <script type="text/javascript">
        window.location.href="../index.jsp";
    </script>
</body>
</html>
