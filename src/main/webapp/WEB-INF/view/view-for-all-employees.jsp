<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 14.06.2023
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница для всех сотрудников</title>
</head>
<body>
<h2>Страница для всех сотрудников</h2>

<security:authorize access="hasRole('HR')">
<input type="button" value="Оклад" onclick="window.location.href='hr_info'"/> Только для сотрудников HR<br><br>
</security:authorize>

<security:authorize access="hasRole('MANAGER')">
<input type="button" value="Производительность" onclick="window.location.href='managers_info'"/> Только для менеджеров<br><br>
</security:authorize>


</body>
</html>
