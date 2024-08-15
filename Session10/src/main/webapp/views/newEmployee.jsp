<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 15/08/2024
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Employee</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/employeeController/create" method="post">
    <label for="empId">Employee Id</label>
    <input type="text" id="empId" name="empId"/><br>
    <label for="empName">Employee Name</label>
    <input type="text" id="empName" name="empName"/><br>
    <label for="age">Age</label>
    <input type="number" id="age" name="age"/><br>
    <label for="birthDate">BirthDate</label>
    <input type="date" id="birthDate" name="birthDate"/><br>
    <label for="salary">Salary</label>
    <input type="number" id="salary" name="salary"/><br>
    <label for="department">Choose department</label>
    <select id="department" name="department.deptId">
        <c:forEach items="${listDepartments}" var="dept">
            <option value="${dept.deptId}">${dept.deptName}</option>
        </c:forEach>
    </select><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="status" value="true" checked/><label for="active">Active</label>
    <input type="radio" id="inActive" name="status" value="false"/><label for="inActive">Inactive</label><br>
    <input type="submit" value="Create"/>
</form>
</body>
</html>
