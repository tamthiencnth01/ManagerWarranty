<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/6/2021
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>blak</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Mô tả</th>
        <th>Đơn vị tính</th>
        <th>Số Lượng</th>
        <th>Đơn Giá</th>
        <th>Tổng Cộng</th>
        <th>Thao Tác</th>
    </tr>
    <c:forEach items="${services}" var="service">
        <tr>
            <td>${service.id}</td>
            <td>${service.getId()}</td>
            <td>${service.getId()}</td>
            <td>${service.getId()}</td>
            <td>${service.getId()}</td>
            <td>${service.getId()}</td>
            <td>
                <a href="/services?action=edit&id=${service.id}">Edit</a>
                <a href="/services?action=delete&id=${service.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
