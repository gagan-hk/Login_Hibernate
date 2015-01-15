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

<form action="/delete-user.html">
    <input type="hidden" name="name" value="${message}">
    <input type="text" name="del_user">
    <input type="submit" value = "Delete User">
</form>

<form action="/create-user.html">
    <input type="hidden" name="name" value="${message}">
    <input type="text" name="new_user">
    <input type="password" name = "pwd">
    <input type="text" name = "manager">

    <input type="submit" value = "Create User">
</form>

<form action="/subordinates.html">
    <input type="hidden" name="name" value="${message}">
    <input type="submit" value = "My Subordinates">
</form>



</body>
</html>
