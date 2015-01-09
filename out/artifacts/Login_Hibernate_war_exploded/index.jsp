<%--
  Created by IntelliJ IDEA.
  User: Gagandeep.Singh
  Date: 1/9/2015
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Hello</title>
<head>
</head>
<body>
<div>
    <h1>Enter Login Details</h1>
    <form action="login.html">
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
                    <input type="submit" value="Submit"/>
                </td>
                <td>
                    <a href="reg.jsp"><input type="button" value="Register"/></a>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>