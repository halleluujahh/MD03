<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/17/2024
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/product/doCreate" method="post">
    <label for="prodName">Product Name</label>
    <input type="text" id="prodName" name="productName"/><br>
    <label for="price">Product Price</label>
    <input type="number" id="price" name="price"/><br>
    <label for="title">Product Title</label>
    <input type="text" id="title" name="title"/><br>
    <label for="description">Product Description</label>
    <input type="text" id="description" name="description"/><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="status" value="true"/><label for="active">Active</label>
    <input type="radio" id="inActive" name="status" value="false"/><label for="inActive">Inactive</label><br>
    <label for="category">Category</label>
    <select id="category" name="category.id">
        <c:forEach items="${categories}" var="c">
            <option value="${c.id}">${c.name}</option>
        </c:forEach>
    </select><br>
    <input type="submit" value="Create"/>
    <button><a href="${pageContext.request.contextPath}/product/findAll">Back</a></button>
</form>
</body>
</html>
