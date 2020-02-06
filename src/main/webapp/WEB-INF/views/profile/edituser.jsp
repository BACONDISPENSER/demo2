<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 03.02.2020
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <%@ include file="/WEB-INF/views/html/headerMetaTags.jsp" %>

    <title>Give it away - Edit profile</title>

    <%@ include file="/WEB-INF/views/html/headerLinks.jsp" %>

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <%@ include file="/WEB-INF/views/html/sidebar.jsp" %>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Top Bar -->
            <%@ include file="/WEB-INF/views/html/topBar.jsp" %>
            <!-- End of Top Bar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-4 text-gray-800">Edytuj profil</h1>

                <div class="row">

                    <div class="col-lg-6">

                        <!-- Circle Buttons -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Zmień zdjęcię profilu</h6>
                            </div>
                            <div class="card-body">
                                Currently image ... gdzies tu jest
                                <form:form modelAttribute="appUserPhoto" action="/profile/edit/changePhoto"
                                           cssClass="user"
                                           method="post">
                                    <div class="form-group row">
                                        <div class="col-sm-12">
                                            <form:input path="photo" type="file"/>
                                            <span style="color: red"><form:errors path="photo"/></span>
                                        </div>
                                    </div>
                                    <input class="btn btn-primary btn-user btn-block"
                                           type="submit" value="Zapisz zmiany">
                                </form:form>
                            </div>
                        </div>

                        <!-- Brand Buttons -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Zmień hasło</h6>
                            </div>
                            <div class="card-body">
                                <%--<form:form modelAttribute="appUserPassword" action="/profile/edit/changePassword"
                                           cssClass="user"
                                           method="post">
                                    <div class="form-group row">
                                        <div class="col-sm-12">
                                            <form:password path="password" placeholder="Password"
                                                           cssClass="form-control form-control-user"/>
                                            <span style="color: red"><form:errors path="password"/></span>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-12">
                                            <form:password path="repassword" placeholder="Repeat password"
                                                           cssClass="form-control form-control-user"/>
                                            <span style="color: red"><form:errors path="repassword"/></span>
                                        </div>
                                    </div>
                                    <span style="color: red"><form:errors path=""/></span>
                                    <input class="btn btn-primary btn-user btn-block"
                                           type="submit" value="Zapisz zmiany">
                                </form:form>--%>

                            </div>
                        </div>

                    </div>

                    <div class="col-lg-6">

                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Zmień dane</h6>
                            </div>
                            <div class="card-body">
                                <form:form modelAttribute="appUser" cssClass="user"
                                           method="post" action="/profile/edit/changeUserData">
                                    <div class="form-group row">
                                        <div class="col-sm-12">
                                            <form:input path="login" cssClass="form-control form-control-user"
                                                        id="exampleUserName" placeholder="Username"/>
                                                <%--id username nie wiem skad brane, tak było w temlatce--%>
                                            <span style="color: red"><form:errors path="login"/></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <form:input path="email" cssClass="form-control form-control-user"
                                                    id="exampleInputEmail" placeholder="Email Address" type="email"/>
                                        <span style="color: red"><form:errors path="email"/></span>
                                    </div>
                                    <%--<div class="form-group">
                                        <form:textarea path="description" placeholder="Description"/>
                                    </div>--%>
                                    <input class="btn btn-primary btn-user btn-block"
                                           type="submit" value="Zapisz zmiany">
                                </form:form>
                            </div>
                        </div>

                    </div>

                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <%@ include file="/WEB-INF/views/html/footer.jsp" %>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<%@ include file="/WEB-INF/views/html/scrollTop.jsp" %>

<!-- Logout Modal-->
<%@ include file="/WEB-INF/views/html/logout.jsp" %>

<%@ include file="/WEB-INF/views/html/scripts.jsp" %>

</body>

</html>