<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Пользователи</title>
</head>

<h3>Пользователи</h3>

<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>Имя</td>
        <td>Возраст</td>
        <td>Админ?</td>
        <td>Дата создания</td>
        <td>Редактировать</td>
        <td>Удалить</td>
    </tr>
    </thead>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td><c:out value="${user.name}" escapeXml="true"/></td>
            <td>${user.age} </td>
            <td>${user.isAdmin}</td>
            <td><fmt:formatDate value="${user.createdDate}" pattern="dd-MM-yyyy"/></td>
            <td><a href="<c:url value="/edit?id=${user.id}"/>">Редактировать</a></td>
            <td><a href="<c:url value="/delete?id=${user.id}"/>">Удалить пользователя</a></td>

        </tr>
    </c:forEach>
</table>

<form action="/add" method="get">
    <input type="submit" name="addUser" value="Добавить пользователя">
</form>

<p>страница №${numberOfPage}, всего страниц ${countPages}: </p>
<br>
<c:if test="${numberOfPage != countPages}">
<form action="/all" method="get">
    <input type="submit"  value="перейти на следующую страницу">
    <input type="hidden"  name="name" value="${name}">
    <input type="hidden" placeholder="numberOfPage" name="numberOfPage" value="${numberOfPage+1}">
</form>
</c:if>


<c:if test="${numberOfPage != 1}">
<form action="/all" method="get">
    <input type="submit"  value="перейти на предыдущую страницу">
    <input type="hidden"  name="name" value="${name}">
    <input type="hidden" placeholder="numberOfPage" name="numberOfPage" value="${numberOfPage-1}">
</form>
</c:if>

<c:if test="${countPages != 1}">

<form action="/all" method="get">

    <input type="submit"  value="перейти на страницу №">
    <input type="text" placeholder="numberOfPage" name="numberOfPage">
    <input type="hidden"  name="name" value="${name}">
</form>
</c:if>



 <a href="/">Перейти к выбору действия на начальной странице</a>

</body>
</html>