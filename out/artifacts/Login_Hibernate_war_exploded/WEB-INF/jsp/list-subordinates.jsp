<%@ page import="login_hibernate.Model.UsersEntity" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Gagandeep.Singh
  Date: 1/15/2015
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subordinates</title>
</head>
<body>

<%

    ArrayList<UsersEntity> subs = (ArrayList<UsersEntity>) request.getAttribute("subordinates");
    out.println("<h2>Subordinates of "+ subs.get(0) +"</h2><br>");
    for(int i=1 ; i < subs.size() ; i++ ) {
        out.println("<h4>"+subs.get(i)+"</h4>");
    }
%>
</body>
</html>
