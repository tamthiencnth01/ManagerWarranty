<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/5/2021
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer</title>
</head>
<body>
    <center>
        <h1>Customer Management</h1>
        <h2>
            <a href="customers?action=customers">List All Users</a>
        </h2>
    </center>
    <div align="center">
        <form method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        Edit User
                    </h2>
                </caption>
                <c:if test="${check != null}">
                    <input type="hidden" name="id" value="${customers.id}"/>
                </c:if>
                <tr>
                    <th>Full Name:</th>
                    <td>
                        <input type="text" name="fullName" size="45"
                               value="${customers.fullName}"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Address:</th>
                    <td>
                        <input type="text" name="address" size="45"
                               value="${customers.address}"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>
                        <input type="text" name="email" size="45"
                               value="${customers.email}"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Phone:</th>
                    <td>
                        <input type="text" name="phone" size="15"
                               value="${customers.phone}"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Edit"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
