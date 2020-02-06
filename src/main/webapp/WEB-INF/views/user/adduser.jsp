<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 01.02.2020
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="/WEB-INF/views/html/headerMetaTags.jsp" %>


    <title>Give it away! - Register</title>

    <%@ include file="/WEB-INF/views/html/headerLinks.jsp" %>

</head>

<body class="bg-gradient-primary">

<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                        </div>
                        <form:form modelAttribute="appUser" cssClass="user" method="post">
                            <div class="form-group row">
                                <div class="col-sm-12">
                                    <form:input path="login" cssClass="form-control form-control-user"
                                                id="exampleUserName" placeholder="Nick"/>
                                        <%--id username nie wiem skad brane, tak było w temlatce--%>
                                    <span style="color: red"><form:errors path="login"/></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <form:input path="email" cssClass="form-control form-control-user"
                                            id="exampleInputEmail" placeholder="Email Address" type="email"/>
                                <span style="color: red"><form:errors path="email"/></span>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <form:password path="password" cssClass="form-control form-control-user"
                                                   id="exampleInputPassword" placeholder="Password"/>
                                    <span style="color: red"><form:errors path="password"/></span>
                                </div>
                                <%--<div class="col-sm-6">
                                    <form:password path="repassword" cssClass="form-control form-control-user"
                                                   id="exampleRepeatPassword" placeholder="Repeat Password"/>
                                    <span style="color: red"><form:errors path=""/></span>
                                </div>--%>
                            </div>
                            <div class="form-group">
                                <div class="custom-control custom-checkbox small">
                                    <form:checkbox path="termsAccept" cssClass="custom-control-input"
                                                   id="customCheck"/>
                                    <label class="custom-control-label" for="customCheck">Akceptuje regulamin...</label>
                                    <br>
                                    <span style="color: red"><form:errors path="termsAccept"/></span>
                                </div>
                            </div>
                            <input class="btn btn-primary btn-user btn-block"
                                   type="submit" value="Register Account">
                            <hr>
                            <a href="index.html" class="btn btn-google btn-user btn-block">
                                <i class="fab fa-google fa-fw"></i> Register with Google
                            </a>
                            <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                            </a>
                        </form:form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="forgot-password.html">Forgot Password?</a>
                        </div>
                        <div class="text-center">
                            <a class="small" href="/login">Already have an account? Login!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<%@ include file="/WEB-INF/views/html/scripts.jsp" %>

</body>

</html>