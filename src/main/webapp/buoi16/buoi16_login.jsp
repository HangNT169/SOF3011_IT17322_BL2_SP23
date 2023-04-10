<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 10/04/2023
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Login" method="post">
    <div class="container">
        <label><b>Nhập tên</b></label>
        <input type="text" placeholder="Nhập tên" name="uname"/>
        <br/>
        <label><b>Nhập mât </b></label>
        <input type="password" placeholder="Nhập mật khẩu" name="psw"/>
        <br/>
        <button type="submit">Login</button>
    </div>
    ${message}
</form>
<c:forEach items="${demo}" var="x">
    <p>${x}</p>
</c:forEach>
</body>
</html>
