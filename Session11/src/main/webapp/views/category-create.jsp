<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/17/2024
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/category/doCreate" method="post">
        <label for="cateName">Book Name</label>
        <input type="text" id="cateName" name="name"/><br>
        <label for="description">Price</label>
        <input type="text" id="description" name="description"/><br>
        <label for="active">Status</label>
        <input type="radio" id="active" name="status" value="true"/><label for="active">Active</label>
        <input type="radio" id="inActive" name="status" value="false"/><label for="inActive">InActive</label><br>
        <input type="submit" value="Create"/>
        <button><a href="${pageContext.request.contextPath}/category/findAll">Back</a></button>
    </form>
</body>
</html>
