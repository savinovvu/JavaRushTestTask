<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Пользователи</title>
</head>
<body>
<h3>выберете действие </h3>


<form action="/all" method="get">
    <input type="submit" name="viewAllUsers" value="Показать (всех пользователей или введите имя)">
    <input type="text" placeholder="name" name="name">
    <input type="hidden" placeholder="numberOfPage" name="numberOfPage" value="1"  >
</form>

<form action="/id" method="get">
    <input type="submit" name="viewUsersFromId" value="выбрать пользователя по ID">
    <input type="text" placeholder="id" name="id">
</form>

<form action="/add" method="get">
    <input type="submit" name="addUser" value="Добавить пользователя">
</form>

</body>
</html>