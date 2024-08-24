<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 20/08/2024
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<style>
    .error {
        color: red;
    }
</style>
<h3>Login</h3>
<form:form modelAttribute="loginDTO" action="/userController/login" method="post">
    <form:label path="userName" cssErrorClass="error" for="userName">UserName</form:label>
    <form:input path="userName"/>
    <form:errors path="userName" cssClass="error"/> <br>
    <form:label path="password" cssErrorClass="error" for="password">Password</form:label>
    <form:password path="password"/>
    <form:errors path="password" cssClass="error"/><br>
    <input type="submit" value="Login"/>
</form:form>
<a href="<%=request.getContextPath()%>/userController/initRegister">Create new account</a>
</body>
</html>
