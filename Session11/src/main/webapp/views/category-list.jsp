<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/17/2024
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Category Management</h2>
<button><a href="${pageContext.request.contextPath}/category/create">Create New</a></button>
<table border="1">
    <thead>
        <tr>
            <th>Catalog ID</th>
            <th>Catalog Name</th>
            <th>Catalog Description</th>
            <th>Catalog Status</th>
            <th colspan="2">Action</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.description}</td>
            <td>${c.status == true ?"Active":"Deactive"}</td>
            <td>
                <button><a href="${pageContext.request.contextPath}/category/update?cateId=${c.id}">Update</a></button>
                <button><a href="${pageContext.request.contextPath}/category/delete?cateId=${c.id}">Delete</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
