<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Пользователи</title>
</head>
<body>





<pre>
<form action="/finishEdit" method="get">

<ul style="list-style-type: none">
    <li>Параметр                   Пример             Ввод данных                                                       </li>
    <li><label>Id                          N/N               <input type="text" placeholder="id" name="id" value="${users.id}" readonly >                      </li>
    <li><label>Имя                        Иванов             <input type="text" placeholder="name" name="name" value="${users.name}"></label></li>
    <li><label>Возраст                    18                 <input type="text" placeholder="age" name="age" value="${users.age}"> </label></li>
    <li><label>Админ?                     true/false         <input type="checkbox" placeholder="isAdmin" name="isAdmin" value="true"> </label></li>
    <li>                                              <input type="submit"  value="готово"> </li>
</ul>

</form>

</pre>



</body>
</html>