<%--
  Created by IntelliJ IDEA.
  User: hblvs
  Date: 2017/11/12
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GBK" language="java" pageEncoding="GBK" %>
<html>
    <head>
        <meta charset="utf-8">
        <% 
			String path = request.getContextPath(); 
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			String Login_Success=basePath+"/jsp/Login_Success.jsp";
			String index=basePath+"/jsp/index.jsp";
		%> 
        <%--½øÐÐµÇÂ¼¼ì²â --%>
        <%
            String usernamecheck= request.getParameter("user");
            String passwordcheck = request.getParameter("pwd");
            String sexcheck=request.getParameter("sex");
            try{
                request.setAttribute("username",usernamecheck);
                request.setAttribute("password",passwordcheck);
                request.setAttribute("sex",sexcheck);
            }catch (Exception e){
                request.setAttribute("username","The result is missing");
                request.setAttribute("password","The result is missing");
                request.setAttribute("sex","The result is missing");
            }
            if(usernamecheck.equals("admin")&&passwordcheck.equals("12345687")){
        %>
        <%-- --%>
        <jsp:forward page="/jsp/Login_Success.jsp">
            <jsp:param name="status" value="success"/>
        </jsp:forward>
        <%
        }else{
        %>
        <jsp:forward page="/jsp/Index.jsp"/>
        <%} %>
    </head>
    <body>
    </body>
</html>
