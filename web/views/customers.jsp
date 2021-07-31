<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>
<a href="/app">Main page</a> <br>

<c:forEach items="${customers}" var="item">
    ${item.id}, ${item.name}, ${item.surname} <br>
</c:forEach>
</body>
</html>
