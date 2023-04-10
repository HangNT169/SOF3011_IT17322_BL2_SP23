<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 10/04/2023
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    Username: ${username}--%>
<%--Co 2 cach de goi 1 bien session
 C1: Goi truc tiep trong JSP
 C2: Goi thong qua servlet
--%>
${sessionScope.username1}
<a href="/dang-xuat1">Dang xuat </a>
</body>
</html>
