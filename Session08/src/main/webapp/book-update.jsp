<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/10/2024
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="BookController?action=update" method="post">
    <div>
        <input type="text" name="id" value="${book.bookId}" hidden="hidden">
    </div>
    <div>
        <label for="name">
            Book Name
        </label>
        <input value="${book.bookName}" type="text" id="name" name="name">
    </div>
    <div>
        <label for="price">Price</label>
        <input value="${book.price}" type="text" id="price" name="price">
    </div>
    <div>
        <label for="title">Title</label>
        <input value="${book.title}" type="text" id="title" name="title">
    </div>
    <div>
        <label for="author">Author</label>
        <input value="${book.author}" type="text" id="author" name="author">
    </div>
    <div>
        <label for="content">Content</label>
        <input value="${book.content}" type="text" id="content" name="content">
    </div>
    <div>
        <label for="publisher">Publisher</label>
        <input value="${book.publisher}" type="text" id="publisher" name="publisher">
    </div>
    <div>
        <label>Status</label>
        <c:choose>
            <c:when test="${book.status eq 'true'}">
                <label>Còn</label>
                <input checked type="radio" value="true" name="status">
                <label>Hết</label>
                <input type="radio" value="false" name="status">
            </c:when>
            <c:otherwise>
                <label>Còn</label>
                <input type="radio" value="true" name="status" >
                <label>Hết</label>
                <input checked type="radio" value="false" name="status">
            </c:otherwise>
        </c:choose>
    </div>
    <button type="submit">Do Update</button>
</form>
</body>
</html>
