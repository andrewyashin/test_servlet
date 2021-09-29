<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>
<a href="/app">Main page</a> <br>

<form action="customers" method="post">
    Name: <input type="text" name="name"> <br>
    Surname: <input type="text" name="surname"> <br>
    EMail: <input type="email" name="email"> <br>
    <input type="submit">
</form>

<br>

<c:forEach items="${customers}" var="item">
    ${item.id}, ${item.name}, ${item.surname}, ${item.email} ,
    <a href="http://localhost:8080/app/customer/delete?id=${item.id}">DELETE</a><br>
</c:forEach>
</body>
</html>
