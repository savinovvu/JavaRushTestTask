<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Пользователи</title>
</head>
<body>
<pre>
<form action="/finishAdd" method="get">
<ul style="list-style-type: none">
    <li><label>Параметр                   Пример             Ввод данных                                                       </li>
    <li><label>Имя                        Иванов             <input type="text" placeholder="name" name="name" ></label></li>
    <li><label>Возраст                    18                 <input type="text" placeholder="age" name="age" > </label></li>
    <li><label>Админ?                     true/false         <input type="checkbox" placeholder="isAdmin" name="isAdmin" value="true"></label></li>
    <li>                                              <input type="submit"  value="готово"> </li>
</ul>

</form>

</pre>




</body>
</html>