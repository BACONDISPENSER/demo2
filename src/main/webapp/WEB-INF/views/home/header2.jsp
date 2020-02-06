<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Zaplanuj Jedzonko</title>
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



<sec:authorize access="!isAuthenticated()">
    <header class="page-header">
        <nav class="navbar navbar-expand-lg justify-content-around">
            <a href="/" class="navbar-brand main-logo">
                Give it <span>away!</span>
            </a>

            <ul class="nav nounderline text-uppercase">


                <li class="nav-item ml-4">
                    <a class="nav-link color-header" href="/login">logowanie</a>
                </li>
                <li class="nav-item ml-4">
                    <a class="nav-link color-header" href="/user/add">rejestracja</a>
                </li>

                    <%--<li class="nav-item ml-4">
                        <a class="nav-link" href="/about">o aplikacji</a>
                    </li>
                    <li class="nav-item ml-4">
                        <a class="nav-link disabled" href="/recipe/list">Przepisy</a>
                    </li>
                    <li class="nav-item ml-4">
                        <a class="nav-link disabled" href="/contact">Kontakt</a>
                    </li>--%>
            </ul>
        </nav>
    </header>
</sec:authorize>



<sec:authorize access="isAuthenticated()">
    <header class="page-header">
        <nav class="navbar navbar-expand-lg justify-content-between">
            <a href="/" class="navbar-brand main-logo main-logo-smaller">
                Give it <span>away!</span>
            </a>
            <div class="d-flex justify-content-around">
                <sec:authentication property="principal.appUser.login" />
                <a href="/profile"><h4 class="text-light mr-3"></h4></a>
                <div class="circle-div text-center"><a href="/profile"><i class="fas fa-appUser icon-appUser"></i></a></div>
            </div>
            <form action="<c:url value="/logout"/>" method="post">
                <input class="fa fa-id-badge" type="submit" value="Wyloguj">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </nav>
    </header>
    <%@ include file="/WEB-INF/views/home/dashboard.jsp" %>
</sec:authorize>

</body>
</html>
