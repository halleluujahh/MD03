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
<h3>Product Name: ${product.productName}</h3>
<h3>Product Price: ${product.price}</h3>
<h3>Product Title: ${product.title}</h3>
<h3>Product Description: ${product.description}</h3>
<h3>Status: ${product.status == true ? "Active" : "Deactive"}</h3>
<h3>Category: ${product.category.name}</h3>
<h3>Count View: ${product.view}</h3>
<button><a href="${pageContext.request.contextPath}/product/findAll">Back</a></button>
</body>
</html>
