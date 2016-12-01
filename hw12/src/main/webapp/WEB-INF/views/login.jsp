<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kollaps
  Date: 30.11.16
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>

<h1>Авторизация</h1>

<form:form action="login" method="post" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="login">Логин</form:label></td>
            <td><form:input path="login"/></td>
            <td><form:errors path="login"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Пароль</form:label></td>
            <td><form:input path="password"/></td>
            <td><form:errors path="password"/></td>
        </tr>
    </table>
    <input type="submit" value="Log in"/>
</form:form>

</body>
</html>
