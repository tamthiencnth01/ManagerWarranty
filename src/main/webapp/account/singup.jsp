<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/5/2021
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager Warranty Electronics</title>
</head>
<body>
    <center>
        <h1>Manager Warranty Electronics</h1>
        <h4><a href="/account?action=account">Comeback Login Form</a></h4>
    </center>
    <div align="center">
        <form method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Sign Up Account</h2>
                </caption>
                <tr>
                    <th>User Name:</th>
                    <td>
                        <input type="text" name="user" id="user" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>PassWord</th>
                    <td>
                        <input type="password" name="password" id="password" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Email: </th>
                    <td>
                        <input type="email" name="email" id="email" size="15"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Sign Up"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
