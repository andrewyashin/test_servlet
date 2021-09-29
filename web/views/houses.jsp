<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Houses</title>
</head>
<body>

<a href="/app">Main page</a> <br>
<c:forEach items="${houses}" var="item">
    ${item.ownerId} - ${item.address} <br>
</c:forEach>
</body>
</html>
