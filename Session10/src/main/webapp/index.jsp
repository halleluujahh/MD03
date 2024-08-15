<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<ul>
    <li><a href="">Deparment Management</a></li>
    <li><a href="<%=request.getContextPath()%>/employeeController/findAll">Employee Management</a></li>
</ul>
</body>
</html>