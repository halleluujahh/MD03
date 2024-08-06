<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 08/08/2024
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Catalog</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/CategoriesController?action=Update" method="post">
    <label for="catalogId">Catalog Id</label>
    <input type="text" id="catalogId" name="catalogId" value="${catalogUpdate.catalogId}" readonly/></br>
    <label for="catalogName">Catalog Name</label>
    <input type="text" id="catalogName" name="catalogName" value="${catalogUpdate.catalogName}"/><br/>
    <label for="description">Description</label>
    <input type="text" id="description" name="description" value="${catalogUpdate.description}"/><br/>
    <label>Status</label>
    <input type="radio" id="active" name="status" value="true" ${catalogUpdate.status?'checked':''}/><label
        for="active">Active</label>
    <input type="radio" id="inActive" name="status" value="false" ${catalogUpdate.status?'':'checked'}/><label
        for="inActive">Inactive</label><br/>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
