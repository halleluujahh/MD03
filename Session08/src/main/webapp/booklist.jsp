<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/10/2024
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>BookManagement</h2>
<form action="BookController" method="get">
    <input type="hidden" value="search" name="action">
    <input type="text" name="search">
    <select name="searchCriteria">
        <option value="book_name">Name</option>
        <option value="book_author">Author</option>
        <option value="book_publisher">Publisher</option>
    </select>
    <label>Price Range (0-number)</label>
    <input type="number" name="price" min="10000" max="1000000">
    <button type="submit">SEARCH</button>
</form>
<table border="1px">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Title</th>
            <th>Author</th>
            <th>Content</th>
            <th>Puslisher</th>
            <th>Status</th>
            <th colspan="2">Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${books}" var="b">
            <tr>
                <td>${b.bookId}</td>
                <td>${b.bookName}</td>
                <td>${b.price}</td>
                <td>${b.title}</td>
                <td>${b.author}</td>
                <td>${b.content}</td>
                <td>${b.publisher}</td>
                <td>${b.status ? "Còn" : "Hết"}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/BookController?action=delete&bookId=${b.bookId}">
                        <button>Delete</button>
                    </a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/BookController?action=update&bookId=${b.bookId}">
                        <button>Update</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div>${msg}</div>
<br>
<a href="${pageContext.request.contextPath}/BookController?action=add"><button>ADD NEW BOOK</button></a>

</body>
</html>
