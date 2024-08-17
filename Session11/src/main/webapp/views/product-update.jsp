<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/17/2024
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/product/doUpdate" method="post">
        <input hidden="hidden" type="text" id="id" name="id" value="${product.id}"/><br>
        <label for="prodName">Product Name</label>
        <input type="text" id="prodName" name="productName" value="${product.productName}"/><br>
        <label for="price">Product Price</label>
        <input type="text" id="price" name="price" value="${product.price}"/><br>
        <label for="title">Product Title</label>
        <input type="text" id="title" name="title" value="${product.title}"/><br>
        <label for="description">Product Description</label>
        <input type="text" id="description" name="description" value="${product.description}"/><br>
        <label for="active">Status</label>
        <input type="radio" id="active" name="status" value="true" ${product.status == true ? "checked" : ""}/><label for="active">Active</label>
        <input type="radio" id="inActive" name="status" value="false" ${product.status == true ? "" : "checked"}/><label for="inActive">Inactive</label><br>
        <label for="category">Category</label>
        <select id="category" name="category.id">
            <c:forEach items="${categories}" var="c">
                <c:choose>
                    <c:when test="${product.category.id == c.id}">
                        <option value="${c.id}" selected>${c.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select><br>
        <input type="submit" value="Update"/>
        <button><a href="${pageContext.request.contextPath}/product/findAll">Back</a></button>
    </form>
</body>
</html>
