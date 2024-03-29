<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pajeczyniak
  Date: 03/02/2020
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Give it away</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>
<body>
<ul class="nav flex-column long-bg">
    <li class="nav-item">
        <a class="nav-link" href='<c:url value = "/user/profile"/>'>
            <span>Podgląd profilu</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href='<c:url value = "/offers/myoffers"/>'>
            <span>Twoje oferty</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href='<c:url value = "/user/profile/edit"/>'>
            <span>Edytuj dane</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href='<c:url value = "/user/changepassword"/>'>
            <span>Zmiana hasła</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <%--<c:if test="${appUser.admin == 1}">
        <li class="nav-item">
            <a class="nav-link" href="/app/users">
                <span>Użytkownicy</span>
                <i class="fas fa-angle-right"></i>
            </a>
        </li>
    </c:if>--%>
</ul>

</body>
</html>
