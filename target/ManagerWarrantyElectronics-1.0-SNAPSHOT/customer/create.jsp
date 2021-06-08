<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/5/2021
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
    <center>
        <h2>Create Customer</h2>
        <p><a href="customers">List Customer</a></p>
    </center>
    <div align="center">
        <form method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Create New Customer</h2>
                </caption>
                <tr>
                    <th> Full Name:</th>
                    <td>
                        <input type="text" name="name" id="name" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td>
                        <input type="text" name="address" id="address" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Email: </th>
                    <td>
                        <input type="email" name="email" id="email" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Phone: </th>
                    <td>
                        <input type="text" name="phone" id="phone" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Mô tả: </th>
                    <td>
                        <select name="des" id="des">
                            <option value=""></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>

</form>
</body>
</html>
