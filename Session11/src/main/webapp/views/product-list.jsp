<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<h2>Product Management</h2>
<button><a href="${pageContext.request.contextPath}/product/create">Create New</a></button>
<table border="1">
  <thead>
  <tr>
    <th>Product ID</th>
    <th>Product Name</th>
    <th>Product Status</th>
    <th>Product_Created</th>
    <th colspan="2">Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${products}" var="p">
    <tr>
      <td>${p.id}</td>
      <td>${p.productName}</td>
      <td>${p.status == true ?"Active":"Deactive"}</td>
      <td><fmt:formatDate pattern="dd/MM/yyyy" value="${p.created}"/></td>
      <td>
        <button><a href="${pageContext.request.contextPath}/product/update?prodId=${p.id}">Update</a></button>
        <button><a href="${pageContext.request.contextPath}/product/delete?prodId=${p.id}">Delete</a></button>
        <button><a href="${pageContext.request.contextPath}/product/view-details?prodId=${p.id}">View Details</a></button>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
