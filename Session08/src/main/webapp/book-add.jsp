<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/10/2024
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="BookController?action=add" method="post">
    <div>
        <label for="name">
            Book Name
        </label>
        <input type="text" id="name" name="name">
    </div>
    <div>
        <label for="price">Price</label>
        <input type="text" id="price" name="price">
    </div>
    <div>
        <label for="title">Title</label>
        <input type="text" id="title" name="title">
    </div>
    <div>
        <label for="author">Author</label>
        <input type="text" id="author" name="author">
    </div>
    <div>
        <label for="content">Content</label>
        <input type="text" id="content" name="content">
    </div>
    <div>
        <label for="publisher">Publisher</label>
        <input type="text" id="publisher" name="publisher">
    </div>
    <div>
        <label>Status</label>
        <label>Còn</label>
        <input type="radio" value="true" name="status">
        <label>Hết</label>
        <input type="radio" value="false" name="status">
    </div>
    <button type="submit">ADD</button>
</form>
</body>
</html>
