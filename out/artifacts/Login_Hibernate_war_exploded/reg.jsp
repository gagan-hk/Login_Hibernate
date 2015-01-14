<%--
  Created by IntelliJ IDEA.
  User: Gagandeep.Singh
  Date: 1/8/2015
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Enter Registration Details</h1>
<form action="register.html">
    <table>
        <tr>
            <td><h3>Username: </h3></td>
            <td><h3><input type="text" name="user"></h3></td>
        </tr>
        <tr>
            <td><h3>Password: </h3></td>
            <td><h3><input type="password" name="pwd" /></h3></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Register"/>
            </td>
            <td>
                <a href="index.jsp"><input type="button" value="Login"/></a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
