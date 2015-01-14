<%--
  Created by IntelliJ IDEA.
  User: Gagandeep.Singh
  Date: 1/8/2015
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Welcome ${message}</h1>

<form action="validatePermission.html">
    <input type="hidden" name="name" value="${message}">
    <input type="hidden" name="permission" value="delete">
    <input type="submit" value = "Delete">
</form>

</body>
</html>
