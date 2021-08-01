<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Roles</title>
</head>
<body>
<a href="/app">Go to main page</a> <br>

<c:forEach items="${roles}" var="role">
    ${role.id} - ${role.name} <br>
</c:forEach>

</body>
</html>
