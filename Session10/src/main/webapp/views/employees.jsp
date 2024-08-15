<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 15/08/2024
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employees</title>
</head>
<body>
    <h3>Employee Management</h3>
    <table border="1">
        <thead>
        <tr>
            <th>No</th>
            <th>Employee Id</th>
            <th>Employee Name</th>
            <th>Age</th>
            <th>BirthDate</th>
            <th>Salary</th>
            <th>Department Name</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${listEmployees}" var="emp" varStatus="loop">
                <tr>
                    <td>${loop.index+1}</td>
                    <td>${emp.empId}</td>
                    <td>${emp.empName}</td>
                    <td>${emp.age}</td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${emp.birthDate}"/></td>
                    <td>${emp.salary}</td>
                    <td>${emp.department.deptName}</td>
                    <td>${emp.status?"Active":"Inactive"}</td>
                    <td></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
<a href="<%=request.getContextPath()%>/employeeController/initCreate">Create new employee</a>
</body>
</html>
