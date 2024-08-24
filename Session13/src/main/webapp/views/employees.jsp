<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 22/08/2024
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>
<h3>List Employees</h3>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>EmpId</th>
        <th>EmpName</th>
        <th>Age</th>
        <th>Avatar</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listEmps}" var="emp" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${emp.empId}</td>
            <td>${emp.empName}</td>
            <td>${emp.empAge}</td>
            <td><img src="${emp.avatar}" alt="${emp.empName}" width="50" height="50"/></td>
            <td>${emp.empStatus?"Active":"Inactive"}</td>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/employeeController/initCreate">Create new employee</a>
</body>
</html>
